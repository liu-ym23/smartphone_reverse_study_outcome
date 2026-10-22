package com.bytedance.ee.bear.drive.biz.preview.Offline;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import cj5.b;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.biz.permission.c;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.biz.preview.image.DriveImageThumbLoadingPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.larus.apm.impl.protector.RunnableProtector;
import jg5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/Offline/DriveSpaceFileOfflinePlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "TAG", "", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSpaceFileOfflinePlugin extends AbsDrivePreviewPlugin {
    private final String TAG;

    public static final class a implements Runnable {
        public final /* synthetic */ DriveSpaceFileOfflinePlugin a;
        public final /* synthetic */ DrivePluginHost b;

        public a(DriveSpaceFileOfflinePlugin r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            j r0 = j.a.a;
            if (r0 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == false) goto L10;
            return;
        L10:
            if (TextUtils.isEmpty(k75.a.d(this.a)) == true) goto L36;
            BaseOpenEntity r2 = this.b.c.getOpenEntity();
            if (r2 == null) goto L14;
            String r5 = r2.getMountPoint();
        L15:
            ((b) org.koin.java.a.c(b.class, null, null, 6)).getConfig();
            if (e.a.a.g() == false) goto L18;
            boolean r3 = s55.a.h(s55.a.a, "VIEW", r5, k75.a.d(this.a), null, null, null, null, null, null, 504).getAllow();
        L19:
            tt5.a.h(DriveSpaceFileOfflinePlugin.access$getTAG$p(this.a), "checkSecurityPolicy ValidateResult allow is " + r3);
            if (r3 == true) goto L37;
            DriveSpaceFileOfflinePlugin.access$removePreviewView(this.a);
            DriveImageThumbLoadingPlugin r4 = (DriveImageThumbLoadingPlugin) DriveSpaceFileOfflinePlugin.access$findPlugin(this.a, DriveImageThumbLoadingPlugin.class);
            if (r4 == null) goto L24;
            r4.updateForceGone(true);
        L24:
            Fragment r6 = DriveSpaceFileOfflinePlugin.access$getLifecycleOwner(this.a);
            if (r6 == null) goto L38;
            FragmentManager r7 = r6.getParentFragmentManager();
            if (r7 != null) goto L30;
            return;
        L30:
            if (this.b.c.isVCFollowMode() == true) goto L33;
            r7 = DriveSpaceFileOfflinePlugin.access$getActivity(this.a).getSupportFragmentManager();
        L33:
            FragmentManager r8 = r7;
            ((DriveMGPermissionVM) DriveSpaceFileOfflinePlugin.access$viewModel(this.a, DriveMGPermissionVM.class)).getLiveConditionControl().setValue(Boolean.FALSE);
            String r9 = com.bytedance.ee.util.io.a.c(this.b.c.getFileName());
            boolean r10 = this.b.c.isVCFollowMode();
            int r11 = c.a;
            Boolean r12 = Boolean.valueOf(r10);
            Intrinsics.checkNotNullParameter(r8, "fm");
            c.a.a(r8, false, "", "", -1, true, r9, r12, "", true, -1);
            return;
        L38:
            return;
        L37:
            return;
        L18:
            r3 = ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_FILE_PREVIEW", pw4.b.d(r5), sbb.e.l.b, k75.a.d(this.a)).a;
            goto L19
        L14:
            r5 = null;
            goto L15
        L36:
            return;
        L5:
            if (r0.getNetworkState().a() != true) goto L7;
            r1 = true;
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveSpaceFileOfflinePlugin() {
        this.TAG = "DriveOfflinePlugin";
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveSpaceFileOfflinePlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ LifecycleOwner access$getLifecycleOwner(DriveSpaceFileOfflinePlugin r0) {
        return r0.getLifecycleOwner();
    }

    public static final /* synthetic */ String access$getTAG$p(DriveSpaceFileOfflinePlugin r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ void access$removePreviewView(DriveSpaceFileOfflinePlugin r0) {
        r0.removePreviewView();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        addInfoHandler(new a(this, r4), new InfoCode[]{InfoCode.ShowCommitted});
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ f access$findPlugin(DriveSpaceFileOfflinePlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveSpaceFileOfflinePlugin r0, Class r1) {
        return r0.viewModel(r1);
    }
}
