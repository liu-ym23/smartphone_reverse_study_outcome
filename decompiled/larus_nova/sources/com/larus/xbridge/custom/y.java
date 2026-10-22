package com.larus.xbridge.custom;

import android.content.Context;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.bytedance.map.api.monitor.MonitorValueConst;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.common.apphost.AppHost;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.platform.service.DownloadWatermarkService;
import com.larus.platform.service.watermark.DownloadWatermarkScene;
import com.larus.platform.service.watermark.WatermarkPerfLogger;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class y extends bx7.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f379803b = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return "app.saveMsgExportFile";
    }

    public y() {
    }

    public static String g(Context r100, Uri r101) {
        String r102 = r101.getScheme();
        if (r102 == null) goto L18;
        int r103 = r102.hashCode();
        if (r103 == 3143036) goto L14;
        if (r103 == 951530617) goto L10;
        return null;
    L10:
        if (r102.equals("content") == true) goto L12;
        return null;
    L12:
        return r100.getContentResolver().getType(r101);
    L14:
        if (r102.equals("file") == false) goto L22;
        String r104 = MimeTypeMap.getFileExtensionFromUrl(r101.toString());
        FLogger.f375446a.d("AppSaveFileMethod", "extension: " + r104);
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(r104);
    L22:
        return null;
    L18:
        return null;
    }

    public static final Object f(y r100, String r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof AppSaveMsgExportFileMethod$applyDownloadFileWatermark$1) == false) goto L7;
        AppSaveMsgExportFileMethod$applyDownloadFileWatermark$1 r103 = (AppSaveMsgExportFileMethod$applyDownloadFileWatermark$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        String r108 = null;
        if (r107 == 0) goto L18;
        if (r107 != 1) goto L17;
        WatermarkPerfLogger.a r109 = (WatermarkPerfLogger.a) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L14
    L43:
        com.larus.platform.service.watermark.g r110 = (com.larus.platform.service.watermark.g) r105;     // Catch: Throwable -> L14
        if ((r110 instanceof com.larus.platform.service.watermark.g.c) == false) goto L46;
        com.larus.platform.service.watermark.g.c r111 = (com.larus.platform.service.watermark.g.c) r110;     // Catch: Throwable -> L14
    L47:
        if (r111 == null) goto L49;
        String r112 = r111.f365855a;     // Catch: Throwable -> L14
    L50:
        Object r113 = Result.m9449constructorimpl(r112);     // Catch: Throwable -> L14
    L56:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 != null) goto L65;
        String r115 = (String) r113;
        r109.a("applyWatermarkToFileAsLocal");
        if (r115 == null) goto L61;
        WatermarkPerfLogger.Result r116 = WatermarkPerfLogger.Result.SUCCESS;
    L62:
        if (r115 != null) goto L64;
        r108 = "no_ready_local_file";
    L64:
        r109.b(r116, r108);
        return r115;
    L61:
        r116 = WatermarkPerfLogger.Result.FAIL;
        goto L62
    L65:
        FLogger.f375446a.w("AppSaveFileMethod", "applyDownloadFileWatermark failed: " + r114);
        r109.b(WatermarkPerfLogger.Result.FAIL, r114.getClass().getSimpleName());
    L67:
        return null;
    L49:
        r112 = null;
        goto L50
    L46:
        r111 = null;
    L14:
        Throwable th10 = th;
        WatermarkPerfLogger.a r117 = r109;
    L55:
        Result.Companion r118 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
        r109 = r117;
        goto L56
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r105);
        DownloadWatermarkService r119 = DownloadWatermarkService.f365700a;
        r119.getClass();
        if (DownloadWatermarkService.d() == true) goto L22;
        r119 = null;
    L22:
        ex7.d r120 = r100.f21364a;
        if (r120 == null) goto L25;
        Context r121 = (Context) r120.a(Context.class);
    L26:
        int r122 = WatermarkPerfLogger.f365828a;
        if (r119 != null) goto L29;
        WatermarkPerfLogger.Version r123 = WatermarkPerfLogger.Version.PERSONAL;
    L30:
        DownloadWatermarkScene r124 = DownloadWatermarkScene.MESSAGE_EXPORT_FILE;
        r117 = WatermarkPerfLogger.a("app_save_msg_export_file", r123, r124);
        if (r119 != null) goto L33;
        WatermarkPerfLogger.Path r125 = WatermarkPerfLogger.Path.NONE;
    L34:
        r117.c(r125);
        if (r119 != null) goto L37;
        r117.b(WatermarkPerfLogger.Result.SUCCESS, null);
        goto L67
    L37:
        if (r121 != null) goto L70;
        r117.b(WatermarkPerfLogger.Result.FAIL, MonitorValueConst.TYPE_CONTEXT_NULL);
        goto L67
    L70:
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L53
        Uri r127 = Uri.fromFile(new PolarisFileWrapper(r101));     // Catch: Throwable -> L53
        Intrinsics.checkNotNull(r127);     // Catch: Throwable -> L53
        com.larus.platform.service.watermark.a r128 = new com.larus.platform.service.watermark.a(r101, g(r121, r127), r124);     // Catch: Throwable -> L53
        r103.L$0 = r117;     // Catch: Throwable -> L53
        r103.label = 1;     // Catch: Throwable -> L53
        r105 = r119.a(r128, r103);     // Catch: Throwable -> L53
        if (r105 == r106) goto L73;
        r109 = r117;
        goto L43
    L73:
        return r106;
    L53:
        th = move-exception;
        th10 = th;
        goto L55
    L33:
        r125 = WatermarkPerfLogger.Path.B_FILE;
        goto L34
    L29:
        r123 = WatermarkPerfLogger.Version.ENTERPRISE;
        goto L30
    L25:
        r121 = null;
    L7:
        r103 = new AppSaveMsgExportFileMethod$applyDownloadFileWatermark$1(r100, r102);
        goto L8
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r110, ux7.d.C7943d r111, IvyBridgePlatformType r112) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        FlowFileProtectionService r113 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r113 != null) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == false) goto L25;
        com.larus.platform.service.o r114 = com.larus.platform.service.o.f365780a;
        JSONObject r101 = new JSONObject();
        r101.put("action", ShareChannel.EXPORT_FILE);
        r101.put("entry", "message_export_bridge");
        r101.put("channel", "local_export");
        r101.put("content_type", "file");
        Unit r102 = Unit.INSTANCE;
        r114.reportEvent("flow_enterprise_file_egress_block", r101);
        String r115 = r113.H0();
        if (r115 != null) goto L12;
    L23:
        bx7.c.c(this, r111, 0, "blocked by enterprise file security", 8);
        return;
    L12:
        if ((!StringsKt.isBlank(r115)) == true) goto L15;
        r115 = null;
    L15:
        String r103 = r115;
        if (r103 == null) goto L23;
        t19.s r104 = t19.s.f544207a;
        ex7.d r116 = this.f21364a;
        if (r116 == null) goto L21;
        Context r117 = (Context) r116.a(Context.class);
        if (r117 == null) goto L21;
    L22:
        t19.s.j(r104, r117, r103, null, false, 28);
    L21:
        r117 = AppHost.f326268a.getApplication();
        goto L22
    L25:
        String r105 = r110.getString("content");
        String r106 = r110.getString("name");
        FLogger.f375446a.d("AppSaveFileMethod", "fileName: " + r106);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(new z(CoroutineExceptionHandler.Key))), null, null, new AppSaveMsgExportFileMethod$handle$4(this, r105, r106, r111, r110, null), 3, null);
        return;
    L5:
        if (r113.I0() != true) goto L7;
        r100 = true;
        goto L8
    }
}
