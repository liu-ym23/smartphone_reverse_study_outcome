package com.bytedance.ee.bear.drive.biz.preview.edit;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.drive.biz.extra_info.meta.DriveMetaInfoVM;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.widgets.button.CommonEditButton;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0014\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/edit/DriveEditModeSwitchPlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePlugin;", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "<init>", "()V", "mEditModeSwitchView", "Lcom/bytedance/ee/bear/widgets/button/CommonEditButton;", "interceptor", "Lcom/bytedance/ee/bear/drive/biz/preview/edit/ForceSecretInterceptor;", "enable", "", "setEnable", "", "onAttachToHost", "host", "initObserve", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "onDetachFromHost", "applyEditVisibleAction", "loadListener", "Lcom/bytedance/ee/bear/drive/core/load/IFileLoader$SimpleLoadListener;", "getLoadListener", "()Lcom/bytedance/ee/bear/drive/core/load/IFileLoader$SimpleLoadListener;", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveEditModeSwitchPlugin extends BasePlugin<DrivePluginHost> {
    public static final a Companion = null;
    private static final String TAG = "DriveEditModeSwitchPlugin";
    private boolean enable;
    private a65.c interceptor;
    private final u75.b.C0306b loadListener;
    private CommonEditButton mEditModeSwitchView;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DriveEditModeSwitchPlugin a;

        public b(DriveEditModeSwitchPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            if (DriveEditModeSwitchPlugin.access$getEnable$p(this.a) == false) goto L6;
            tt5.a.h(DriveEditModeSwitchPlugin.TAG, "switch edit mode, enable: " + DriveEditModeSwitchPlugin.access$getEnable$p(this.a));
            DriveEditModeSwitchPlugin.access$applyEditVisibleAction(this.a);
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ DriveEditModeSwitchPlugin a;
        public final /* synthetic */ DrivePluginHost b;

        public c(DriveEditModeSwitchPlugin r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r6) {
            Boolean r7 = (Boolean) r6;
            DriveEditModeSwitchPlugin r0 = this.a;
            FragmentActivity r2 = DriveEditModeSwitchPlugin.access$getActivity(r0);
            Intrinsics.checkNotNull(r7);
            boolean r8 = r7.booleanValue();
            u55.a r3 = (u55.a) ((DriveMetaInfoVM) DriveEditModeSwitchPlugin.access$viewModel(this.a, DriveMetaInfoVM.class)).getLiveMetaInfo().getValue();
            if (r3 == null) goto L5;
            DocMetaInfo r4 = r3.b;
        L6:
            DriveEditModeSwitchPlugin.access$setInterceptor$p(r0, new a65.c(r2, r8, r4, this.b.c.getFileId()));
            return;
        L5:
            r4 = null;
            goto L6
        }
    }

    public static final class d extends u75.b.C0306b {
        public final /* synthetic */ DriveEditModeSwitchPlugin a;

        public d(DriveEditModeSwitchPlugin r1) {
            this.a = r1;
        }

        @Override // u75.b.C0306b, u75.b.a
        public final void c(ErrCode r2) {
            Intrinsics.checkNotNullParameter(r2, "code");
            Intrinsics.checkNotNullParameter(r2, "code");
            if (r2 != ErrCode.DRIVE_FILE_NOT_SUPPORT_PREVIEW) goto L6;
            k75.a.i(this.a.getHost()).liveInnerEditModeSwitchActive().postValue(Boolean.FALSE);
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ DriveEditModeSwitchPlugin a;
        public final /* synthetic */ DrivePluginHost b;

        public e(DriveEditModeSwitchPlugin r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            a65.c r6 = DriveEditModeSwitchPlugin.access$getInterceptor$p(this.a);
            if (r6 != null) goto L5;
        L7:
            boolean r7 = false;
        L8:
            if (r7 == false) goto L13;
            a65.c r8 = DriveEditModeSwitchPlugin.access$getInterceptor$p(this.a);
            if (r8 == null) goto L19;
            FragmentActivity r0 = r8.a;
            Intrinsics.checkNotNullParameter(r0, "context");
            FlowToast.a r1 = FlowToast.a(r0);
            r1.d(UDToast.access$createTintedIcon(UDToast.INSTANCE, r0, 2131256189));
            r1.e(2131889918);
            a65.b r2 = new a65.b(r8);
            Intrinsics.checkNotNullParameter(r2, JSEventListener.ACTION);
            r1.b(2131889947, new com.larksuite.component.universe_design.toast.a(r2));
            r1.a().show();
            return;
        L19:
            return;
        L13:
            tt5.a.h(DriveEditModeSwitchPlugin.TAG, "click button enter edit mode");
            com.bytedance.ee.bear.drive.report.c r9 = k75.a.c(this.b);
            w75.a r3 = this.b.c.getFileModel();
            String r4 = this.b.c.getOpenEntity().getMountPoint();
            if (r3 != null) goto L16;
            r9.getClass();
        L17:
            k75.a.i(this.b).liveInnerEditModeSwitchAction().postValue(1);
            return;
        L16:
            HashMap<String, Object> r10 = r9.i(r3);
            r10.put(DrivePreviewOpenItem.EXTRA_MOUNT_POINT, r4);
            r10.put("click", JSEventListener.ACTION_EDIT);
            r10.put("target", "none");
            r9.A("ccm_drive_edit_click", r10);
            goto L17
        L5:
            if ((!r6.b) == true) goto L7;
            r7 = true;
            goto L8
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveEditModeSwitchPlugin() {
        this.enable = true;
        this.loadListener = new d(this);
    }

    private final void applyEditVisibleAction() {
        Boolean r0 = (Boolean) k75.a.i(getHost()).liveInnerEditModeSwitchActive().getValue();
        tt5.a.h(TAG, "switch edit mode: " + r0);
        if (Boolean.TRUE.equals(r0) == false) goto L11;
        com.bytedance.ee.bear.drive.report.c r1 = k75.a.c(getHost());
        w75.a r2 = getHost().c.getFileModel();
        if (r2 != null) goto L7;
        r1.getClass();
    L8:
        CommonEditButton r3 = this.mEditModeSwitchView;
        if (r3 == null) goto L15;
        r3.setVisibility(0);
        return;
    L15:
        return;
    L7:
        r1.A("ccm_drive_edit_view", r1.i(r2));
        goto L8
    L11:
        CommonEditButton r4 = this.mEditModeSwitchView;
        if (r4 == null) goto L17;
        r4.setVisibility(8);
        return;
    }

    public final u75.b.C0306b getLoadListener() {
        return this.loadListener;
    }

    public static final /* synthetic */ void access$applyEditVisibleAction(DriveEditModeSwitchPlugin r0) {
        r0.applyEditVisibleAction();
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveEditModeSwitchPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ boolean access$getEnable$p(DriveEditModeSwitchPlugin r0) {
        return r0.enable;
    }

    public static final /* synthetic */ a65.c access$getInterceptor$p(DriveEditModeSwitchPlugin r0) {
        return r0.interceptor;
    }

    private final void initObserve(DrivePluginHost r4) {
        k75.a.i(r4).liveInnerEditModeSwitchActive().observe(getLifecycleOwner(), new b(this));
        k75.a.i(r4).liveOuterEditableFromSecret().observe(getLifecycleOwner(), new c(this, r4));
    }

    public void onAttachToHost(DrivePluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        super.onAttachToHost(r3);
        r3.c().c(this.loadListener);
        initObserve(r3);
    }

    public void onDetachFromHost(DrivePluginHost r2) {
        super.onDetachFromHost(r2);
        if (r2 == null) goto L8;
        u75.b r3 = r2.c();
        if (r3 == null) goto L9;
        r3.g(this.loadListener);
        return;
    L9:
        return;
    }

    public final void setEnable(boolean r3) {
        this.enable = r3;
        tt5.a.h(TAG, "setEnable: " + r3);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$setInterceptor$p(DriveEditModeSwitchPlugin r0, a65.c r1) {
        r0.interceptor = r1;
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveEditModeSwitchPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }

    public void onAttachToUIContainer(DrivePluginHost r6, t r7) {
        Intrinsics.checkNotNullParameter(r6, "host");
        Intrinsics.checkNotNullParameter(r7, "uiContainer");
        super.onAttachToUIContainer(r6, r7);
        if (this.mEditModeSwitchView != null) goto L6;
        CommonEditButton r0 = new CommonEditButton(getContext(), null, 0, 14);
        r0.setOnClickListener(new e(this, r6));
        this.mEditModeSwitchView = r0;
        r7.h(this, r0);
        return;
    }

    public void onDetachFromUIContainer(DrivePluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super.onDetachFromUIContainer(r2, r3);
        CommonEditButton r4 = this.mEditModeSwitchView;
        if (r4 == null) goto L6;
        r3.m(this, r4);
        this.mEditModeSwitchView = null;
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DrivePluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DrivePluginHost) r1, r2);
    }
}
