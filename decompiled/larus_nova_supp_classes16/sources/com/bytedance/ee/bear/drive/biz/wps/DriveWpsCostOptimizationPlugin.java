package com.bytedance.ee.bear.drive.biz.wps;

import android.util.SparseArray;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.drive.biz.permission.model.DrivePermissionInfoViewModel;
import com.bytedance.ee.bear.drive.biz.preview.edit.DriveEditModeSwitchPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.core.model.PreviewMeta;
import com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster;
import com.bytedance.ee.bear.drive.loader.download.platform.adjuster.VCFollowPriorityAdjuster;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import i75.h;
import java.util.List;
import jdb.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001dB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/wps/DriveWpsCostOptimizationPlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePlugin;", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "Lcom/bytedance/ee/bear/drive/biz/wps/IWpsCostOptimization;", "<init>", "()V", "onAttachToHost", "", "host", "onDetachFromHost", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "isWpsCostOptimization", "", "fileModel", "Lcom/bytedance/ee/bear/drive/core/model/AbsFileModel;", "checkStatus", "getCustomizationAdjust", "Lcom/bytedance/ee/bear/drive/loader/download/platform/adjuster/IPriorityAdjuster;", "getAsyncWpsCostOptimizationCacheHandler", "Lcom/bytedance/ee/bear/drive/loader/impl/executor/cache/filter/async/IDriveAsyncCacheFileHandler;", "revertEditButton", "initEditButton", "mEditModeSwitchObserver", "Landroidx/lifecycle/Observer;", "", "mInnerFilePermissionChangedObserver", "Lcom/bytedance/ee/bear/drive/biz/permission/model/DrivePermissionInfo;", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveWpsCostOptimizationPlugin extends BasePlugin<DrivePluginHost> implements g75.a {
    public static final a Companion = null;
    private static final String TAG = "DriveWpsCostOptimizationPlugin";
    private final Observer<Integer> mEditModeSwitchObserver;
    private final Observer<u55.b> mInnerFilePermissionChangedObserver;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements d85.d {
        public final /* synthetic */ DriveWpsCostOptimizationPlugin a;

        public b(DriveWpsCostOptimizationPlugin r1) {
            this.a = r1;
        }

        @Override // d85.d
        public final boolean a(w75.c<?> r7, w75.c<?> r8) {
            Intrinsics.checkNotNullParameter(r7, "localFileModel");
            Intrinsics.checkNotNullParameter(r8, "latestFileModel");
            Boolean r0 = (Boolean) ((DriveWPSPreviewViewModel) DriveWpsCostOptimizationPlugin.access$viewModel(this.a, DriveWPSPreviewViewModel.class)).getLiveWpsIsEditMode().getValue();
            if (r0 == null) goto L5;
            boolean r1 = r0.booleanValue();
        L6:
            boolean r4 = true;
            if (r1 == false) goto L12;
        L22:
            e = e;
            r4 = false;
        L24:
            tt5.a.e(DriveWpsCostOptimizationPlugin.TAG, "isCacheNotAvailable exception", e, false);
        L25:
            return r4;
        L9:
            if (r8.n() == 2) goto L12;
        L17:
            if (r4 == false) goto L25;
            tt5.a.h(DriveWpsCostOptimizationPlugin.TAG, "isCacheNotAvailable true");     // Catch: Exception -> L20
            int r9 = com.bytedance.ee.bear.drive.biz.cache.a.a;     // Catch: Exception -> L20
            com.bytedance.ee.bear.drive.biz.cache.a.C0118a.c(r7.getDetails(), this.a.getHost().b());     // Catch: Exception -> L20
        L20:
            e = e;
        L12:
            if (this.a.isWpsCostOptimization(r7.getDetails(), true) == false) goto L16;
            if (r8.n() == 2) goto L17;
        L16:
            r4 = false;
            goto L17
        L5:
            r1 = false;
            goto L6
        }
    }

    public static final class c implements IPriorityAdjuster {
        public final /* synthetic */ DriveWpsCostOptimizationPlugin a;

        @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
        public final String getName() {
            return "DriveWpsCostOptimizationAdjuster";
        }

        public c(DriveWpsCostOptimizationPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
        public final List<Integer> adjust(w75.c<?> r4, List<Integer> r5) {
            Intrinsics.checkNotNullParameter(r4, "fileModel");
            Intrinsics.checkNotNullParameter(r5, "source");
            if (this.a.isWpsCostOptimization(r4.getDetails(), false) == true) goto L6;
            return r5;
        L6:
            return new VCFollowPriorityAdjuster().adjust(r4, r5);
        }
    }

    public static final class d implements u75.b.a {
        public final /* synthetic */ DriveWpsCostOptimizationPlugin a;

        @Override // u75.b.a
        public final <I> void a(InfoCode r1, I r2) {
            Intrinsics.checkNotNullParameter(r1, "code");
        }

        @Override // u75.b.a
        public final void c(ErrCode r2) {
            Intrinsics.checkNotNullParameter(r2, "code");
        }

        @Override // u75.b.a
        public final void onProgress(int r1) {
        }

        public d(DriveWpsCostOptimizationPlugin r1) {
            this.a = r1;
        }

        @Override // u75.b.a
        public final void b(z r3) {
            Intrinsics.checkNotNullParameter(r3, "previewFileModel");
            tt5.a.h(DriveWpsCostOptimizationPlugin.TAG, "onSuccess...");
            DrivePluginHost r4 = this.a.getHost();
            if (r4 == null) goto L7;
            DriveViewModel r5 = r4.c;
            if (r5 == null) goto L7;
            w75.a r6 = r5.getFileModel();
        L8:
            if (r6 != null) goto L12;
            tt5.a.h(DriveWpsCostOptimizationPlugin.TAG, "onSuccess fileModel is null");
            return;
        L12:
            if (this.a.isWpsCostOptimization(r6, false) == true) goto L14;
        L16:
            DriveWpsCostOptimizationPlugin.access$revertEditButton(this.a);
            return;
        L14:
            if (r6.q == 2) goto L16;
            DriveWpsCostOptimizationPlugin.access$initEditButton(this.a);
            return;
        L7:
            r6 = null;
            goto L8
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // g75.a
    public d85.d getAsyncWpsCostOptimizationCacheHandler() {
        return new b(this);
    }

    @Override // g75.a
    public IPriorityAdjuster getCustomizationAdjust() {
        return new c(this);
    }

    public DriveWpsCostOptimizationPlugin() {
        this.mEditModeSwitchObserver = new DriveWpsCostOptimizationPlugin$mEditModeSwitchObserver$1(this);
        this.mInnerFilePermissionChangedObserver = new DriveWpsCostOptimizationPlugin$mInnerFilePermissionChangedObserver$1(this);
    }

    private final void initEditButton() {
        if (getHost().c.getBizType() != 5) goto L6;
        tt5.a.h(TAG, "bizType is BIZ_TYPE_SPACE_THIRDPARTY_ATTACHMENT");
        return;
    L6:
        tt5.a.h(TAG, "initEditButton");
        a65.a.a(k75.a.i(getHost()));
        DriveEditModeSwitchPlugin r0 = (DriveEditModeSwitchPlugin) getHost().findPlugin(DriveEditModeSwitchPlugin.class);
        if (r0 == null) goto L9;
        r0.setEnable(false);
    L9:
        MutableLiveData<u55.b> r1 = ((DrivePermissionInfoViewModel) viewModel(DrivePermissionInfoViewModel.class)).getLiveInnerFilePermissionChanged();
        r1.removeObserver(this.mInnerFilePermissionChangedObserver);
        r1.observe(getLifecycleOwner(), this.mInnerFilePermissionChangedObserver);
        k75.a.i(getHost()).liveInnerEditModeSwitchAction().removeObserver(this.mEditModeSwitchObserver);
        k75.a.i(getHost()).liveInnerEditModeSwitchAction().observe(getLifecycleOwner(), this.mEditModeSwitchObserver);
    }

    private final void revertEditButton() {
        if (getHost().c.getBizType() != 5) goto L6;
        tt5.a.h(TAG, "bizType is BIZ_TYPE_SPACE_THIRDPARTY_ATTACHMENT");
        return;
    L6:
        tt5.a.h(TAG, "revertEditButton");
        DriveEditModeSwitchPlugin r0 = (DriveEditModeSwitchPlugin) getHost().findPlugin(DriveEditModeSwitchPlugin.class);
        if (r0 == null) goto L9;
        r0.setEnable(true);
    L9:
        ((DrivePermissionInfoViewModel) viewModel(DrivePermissionInfoViewModel.class)).getLiveInnerFilePermissionChanged().removeObserver(this.mInnerFilePermissionChangedObserver);
        k75.a.i(getHost()).liveInnerEditModeSwitchAction().removeObserver(this.mEditModeSwitchObserver);
    }

    public static final /* synthetic */ Observer access$getMInnerFilePermissionChangedObserver$p(DriveWpsCostOptimizationPlugin r0) {
        return r0.mInnerFilePermissionChangedObserver;
    }

    public static final /* synthetic */ void access$initEditButton(DriveWpsCostOptimizationPlugin r0) {
        r0.initEditButton();
    }

    public static final /* synthetic */ void access$revertEditButton(DriveWpsCostOptimizationPlugin r0) {
        r0.revertEditButton();
    }

    public void onAttachToHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToHost(r2);
        r2.registerHostAbility(this);
    }

    public void onDetachFromHost(DrivePluginHost r1) {
        super.onDetachFromHost(r1);
        if (r1 == null) goto L6;
        r1.unregisterHostAbility(this);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveWpsCostOptimizationPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }

    @Override // g75.a
    public boolean isWpsCostOptimization(w75.a r6, boolean r7) {
        Boolean r0 = (Boolean) ((DriveWPSPreviewViewModel) viewModel(DriveWPSPreviewViewModel.class)).getLiveWpsIsEditMode().getValue();
        if (r0 == null) goto L5;
        boolean r1 = r0.booleanValue();
    L6:
        if (r6 != null) goto L9;
        return false;
    L9:
        if (r1 == false) goto L11;
        tt5.a.h(TAG, "isWpsCostOptimization in edit mode");
        return false;
    L11:
        DriveViewModel r2 = getHost().c;
        if (r2 != null) goto L14;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == true) goto L45;
        SparseArray<PreviewMeta> r4 = r6.c().i;
        if (r4 == null) goto L26;
        PreviewMeta r5 = r4.get(9);
        if (r5 == null) goto L26;
        if (r5.getStatus() != 0) goto L26;
        boolean r8 = true;
    L27:
        if (r8 == true) goto L30;
        if (r7 == false) goto L30;
        tt5.a.h(TAG, "isWpsCostOptimization not ready");
        return false;
    L30:
        g r9 = ((dn4.a) getHost().getUserComponent().a(dn4.a.class)).a();
        if (h.j(r6.c().k) == false) goto L35;
        if (r9.isEnable("ccm.drive.mobile_ppt_prefer_transcode_preview") == false) goto L35;
    L38:
        return true;
    L35:
        if (h.g(r6.c().k) == true) goto L37;
        return false;
    L37:
        if (r9.isEnable("ccm.drive.mobile_word_prefer_transcode_preview") == true) goto L38;
        return false;
    L26:
        r8 = false;
        goto L27
    L45:
        return false;
    L14:
        if (r2.isVCFollowMode() != true) goto L16;
        r3 = true;
        goto L17
    L5:
        r1 = false;
        goto L6
    }

    public void onAttachToUIContainer(DrivePluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super.onAttachToUIContainer(r2, r3);
        r2.c().c(new d(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DrivePluginHost) r1, r2);
    }
}
