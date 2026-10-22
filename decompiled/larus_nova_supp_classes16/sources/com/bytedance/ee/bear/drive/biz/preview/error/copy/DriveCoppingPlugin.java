package com.bytedance.ee.bear.drive.biz.preview.error.copy;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.view.preview.loadingview.LoadingAnimView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/error/copy/DriveCoppingPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveCoppingPlugin extends AbsDrivePreviewPlugin {

    public static final class a implements Runnable {
        public final /* synthetic */ DriveCoppingPlugin a;
        public final /* synthetic */ DrivePluginHost b;

        public a(DriveCoppingPlugin r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            LoadingAnimView r0 = new LoadingAnimView(DriveCoppingPlugin.access$getActivity(this.a));
            r0.c(this.b.d());
            new FrameLayout.LayoutParams(-2, -2).gravity = 17;
            r0.setGravity(17);
            DriveCoppingPlugin.access$removeAndAddPreviewView(this.a, r0);
            r0.a();
            r0.setTipText(DriveCoppingPlugin.access$getContext(this.a).getString(2131887250));
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

    public DriveCoppingPlugin() {
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveCoppingPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ Context access$getContext(DriveCoppingPlugin r0) {
        return r0.getContext();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        addErrorHandler(new a(this, r4), new ErrCode[]{ErrCode.COPPING});
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$removeAndAddPreviewView(DriveCoppingPlugin r0, View r1) {
        r0.removeAndAddPreviewView(r1);
    }
}
