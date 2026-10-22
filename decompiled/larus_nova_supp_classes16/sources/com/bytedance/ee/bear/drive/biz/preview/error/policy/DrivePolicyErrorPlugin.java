package com.bytedance.ee.bear.drive.biz.preview.error.policy;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.biz.preview.image.DriveImageThumbLoadingPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.view.widget.PolicyDeniedView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/error/policy/DrivePolicyErrorPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrivePolicyErrorPlugin extends AbsDrivePreviewPlugin {

    public static final class a implements Runnable {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DrivePolicyErrorPlugin b;

        public a(DrivePluginHost r1, DrivePolicyErrorPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            int r0 = com.bytedance.ee.bear.drive.biz.cache.a.a;
            DrivePluginHost r1 = this.a;
            com.bytedance.ee.bear.drive.biz.cache.a.C0118a.b(r1.c, null, r1.b());
            DrivePolicyErrorPlugin r2 = this.b;
            DrivePolicyErrorPlugin.access$removeAndAddPreviewView(r2, new PolicyDeniedView(DrivePolicyErrorPlugin.access$getActivity(r2)));
            DriveImageThumbLoadingPlugin r3 = (DriveImageThumbLoadingPlugin) DrivePolicyErrorPlugin.access$findPlugin(this.b, DriveImageThumbLoadingPlugin.class);
            if (r3 == null) goto L6;
            r3.updateForceGone(true);
            return;
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

    public DrivePolicyErrorPlugin() {
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DrivePolicyErrorPlugin r0) {
        return r0.getActivity();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        addErrorHandler(new a(r4, this), new ErrCode[]{ErrCode.POLICY_DENIED});
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ f access$findPlugin(DrivePolicyErrorPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ void access$removeAndAddPreviewView(DrivePolicyErrorPlugin r0, View r1) {
        r0.removeAndAddPreviewView(r1);
    }
}
