package com.bytedance.ee.bear.drive.biz.preview.error.net;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/error/net/DriveTrafficDownloadPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveTrafficDownloadPlugin extends AbsDrivePreviewPlugin {
    public static final a Companion = null;
    public static final String TAG = "DriveTrafficDownloadPlugin";

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DriveTrafficDownloadPlugin b;

        public b(DrivePluginHost r1, DriveTrafficDownloadPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = r55.a.a;     // Catch: Throwable -> L10
            w75.a r1 = this.a.c.getFileModel();     // Catch: Throwable -> L10
            if (r1 == null) goto L7;
            w75.b r2 = r1.c();     // Catch: Throwable -> L10
            if (r2 == null) goto L7;
            long r3 = r2.c;     // Catch: Throwable -> L10
        L8:
            r55.a.C0282a.a(Long.valueOf(r3), DriveTrafficDownloadPlugin.access$getActivity(this.b), 2131887459);     // Catch: Throwable -> L10
            return;
        L7:
            r3 = 0;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveTrafficDownloadPlugin() {
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveTrafficDownloadPlugin r0) {
        return r0.getActivity();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachToHost(r4);
        addInfoHandler(new b(r4, this), new InfoCode[]{InfoCode.MobileNetworkWarning});
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
