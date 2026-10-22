package com.bytedance.ee.bear.drive.biz.monitor;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.d;
import com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ttnet.TTNetInit;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import w75.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/monitor/DriveMonitorPlugin;", "Lcom/bytedance/ee/bear/drive/biz/preview/AbsDrivePreviewPlugin;", "<init>", "()V", "analyticService", "Lcom/bytedance/ee/bear/contract/AnalyticService;", "extra", "Lorg/json/JSONObject;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onAttachPreview", "onDetachPreview", "onDetachFromHost", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveMonitorPlugin extends AbsDrivePreviewPlugin {
    public static final a Companion = null;
    public static final String TAG = "DriveMonitorPlugin";
    private final d analyticService;
    private final JSONObject extra;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DriveMonitorPlugin b;

        public b(DrivePluginHost r1, DriveMonitorPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c r0 = this.a.c.getIFileModel();     // Catch: Throwable -> L10
            if (r0 == null) goto L13;
            DriveMonitorPlugin r1 = this.b;     // Catch: Throwable -> L10
            DriveMonitorPlugin.access$getExtra$p(r1).put("file_type", r0.I());     // Catch: Exception -> L7 Throwable -> L10
            DriveMonitorPlugin.access$getExtra$p(r1).put("file_size", r0.getFileSize());     // Catch: Exception -> L7 Throwable -> L10
        L20:
            return;
        L7:
            e = move-exception;
            tt5.a.f(DriveMonitorPlugin.TAG, e, false);     // Catch: Throwable -> L10
            return;
        L13:
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.AbsDrivePreviewPlugin, com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveMonitorPlugin() {
        this.analyticService = (d) org.koin.java.a.c(d.class, null, null, 6);
        this.extra = new JSONObject();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        ((d) org.koin.java.a.c(d.class, null, null, 6)).k("drive_view");
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        ((d) org.koin.java.a.c(d.class, null, null, 6)).p("drive_view", this.extra);
    }

    public static final /* synthetic */ JSONObject access$getExtra$p(DriveMonitorPlugin r0) {
        return r0.extra;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r7) {
        Intrinsics.checkNotNullParameter(r7, "host");
        super.onAttachToHost(r7);
        boolean r1 = true;
        addInfoHandler(new b(r7, this), new InfoCode[]{InfoCode.FileInfoSuccess});
        this.analyticService.h("ccm_battery_extra");
        this.analyticService.j("ccm_battery_extra", "ccm_battery_extra" + r7.c.getFileId(), this.extra);
        this.extra.put("file_app_id", r7.c.getOpenEntity().getAppId());
        this.extra.put("encrypted_token", du5.b.g(r7.c.getFileId()));
        JSONObject r0 = this.extra;
        if (r7.c.isVCFollowMode() == false) goto L5;
    L8:
        r0.put("is_vc", r1);
        this.extra.put("start_net_level", TTNetInit.getEffectiveConnectionType());
        return;
    L5:
        if (r7.c.isVCAttachment() == true) goto L8;
        r1 = false;
        goto L8
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
        this.analyticService.c("ccm_battery_extra");
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }
}
