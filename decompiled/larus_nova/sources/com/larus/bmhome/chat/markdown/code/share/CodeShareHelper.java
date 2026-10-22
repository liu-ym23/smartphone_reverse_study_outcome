package com.larus.bmhome.chat.markdown.code.share;

import android.content.Context;
import android.webkit.MimeTypeMap;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.platform.service.DownloadWatermarkService;
import com.larus.platform.service.o;
import com.larus.platform.service.watermark.DownloadWatermarkScene;
import com.larus.platform.service.watermark.WatermarkPerfLogger;
import com.larus.platform.service.watermark.a;
import com.larus.platform.service.watermark.g;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: classes25.dex */
public final class CodeShareHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CodeShareHelper f307023a = null;

    static {
        f307023a = new CodeShareHelper();
    }

    public CodeShareHelper() {
    }

    public static final Object a(CodeShareHelper r100, String r101, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof CodeShareHelper$applyCodeExportWatermark$1) == false) goto L7;
        CodeShareHelper$applyCodeExportWatermark$1 r102 = (CodeShareHelper$applyCodeExportWatermark$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        String r106 = null;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        WatermarkPerfLogger.a r107 = (WatermarkPerfLogger.a) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L14
    L38:
        if ((r104 instanceof g.c) == false) goto L40;
        g.c r108 = (g.c) r104;     // Catch: Throwable -> L14
    L41:
        if (r108 == null) goto L43;
        String r109 = r108.f365855a;     // Catch: Throwable -> L14
    L44:
        Object r112 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L14
    L49:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 != null) goto L58;
        String r114 = (String) r112;
        r107.a("applyWatermarkToFileAsLocal");
        if (r114 == null) goto L54;
        WatermarkPerfLogger.Result r115 = WatermarkPerfLogger.Result.SUCCESS;
    L55:
        if (r114 != null) goto L57;
        r106 = "no_ready_local_file";
    L57:
        r107.b(r115, r106);
        return r114;
    L54:
        r115 = WatermarkPerfLogger.Result.FAIL;
        goto L55
    L58:
        FLogger.f375446a.w("CodeShareHelper", "applyCodeExportWatermark failed: " + r113);
        r107.b(WatermarkPerfLogger.Result.FAIL, r113.getClass().getSimpleName());
    L60:
        return null;
    L43:
        r109 = null;
        goto L44
    L40:
        r108 = null;
    L14:
        th = th;
        WatermarkPerfLogger.a r116 = r107;
    L48:
        Result.Companion r117 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r107 = r116;
        goto L49
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        DownloadWatermarkService r118 = DownloadWatermarkService.f365700a;
        r118.getClass();
        if (DownloadWatermarkService.d() == true) goto L22;
        r118 = null;
    L22:
        int r119 = WatermarkPerfLogger.f365828a;
        if (r118 != null) goto L25;
        WatermarkPerfLogger.Version r120 = WatermarkPerfLogger.Version.PERSONAL;
    L26:
        DownloadWatermarkScene r121 = DownloadWatermarkScene.MESSAGE_EXPORT_CODE;
        r116 = WatermarkPerfLogger.a("code_share_export", r120, r121);
        if (r118 != null) goto L29;
        WatermarkPerfLogger.Path r122 = WatermarkPerfLogger.Path.NONE;
    L30:
        r116.c(r122);
        if (r118 != null) goto L63;
        r116.b(WatermarkPerfLogger.Result.SUCCESS, null);
        goto L60
    L63:
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L47
        a r124 = new a(r101, MimeTypeMap.getSingleton().getMimeTypeFromExtension(StringsKt.substringAfterLast(r101, '.', "").toLowerCase(Locale.ROOT)), r121);     // Catch: Throwable -> L47
        r102.L$0 = r116;     // Catch: Throwable -> L47
        r102.label = 1;     // Catch: Throwable -> L47
        r104 = r118.a(r124, r102);     // Catch: Throwable -> L47
        if (r104 == r111) goto L66;
        r107 = r116;
        goto L38
    L66:
        return r111;
    L47:
        th = th;
        goto L48
    L29:
        r122 = WatermarkPerfLogger.Path.B_FILE;
        goto L30
    L25:
        r120 = WatermarkPerfLogger.Version.ENTERPRISE;
    L7:
        r102 = new CodeShareHelper$applyCodeExportWatermark$1(r100, r110);
        goto L8
    }

    public static void b(Context r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "code");
        Intrinsics.checkNotNullParameter(r112, "language");
        FlowFileProtectionService r100 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (r101 == false) goto L19;
        o r102 = o.f365780a;
        JSONObject r103 = new JSONObject();
        r103.put("action", "share");
        r103.put("entry", "code_share_export");
        r103.put("channel", ShareChannel.EXPORT_FILE);
        r103.put("content_type", "file");
        Unit r104 = Unit.INSTANCE;
        r102.reportEvent("flow_enterprise_file_egress_block", r103);
        String r105 = r100.A0();
        if (r105 != null) goto L13;
        return;
    L13:
        if ((!StringsKt.isBlank(r105)) == false) goto L15;
        String r106 = r105;
    L16:
        if (r106 == null) goto L22;
        s.j(s.f544207a, r110, r106, null, false, 28);
        return;
    L22:
        return;
    L15:
        r106 = null;
        goto L16
    L19:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new CodeShareHelper$shareCode$4(r110, r111, r112, null), 3, null);
        return;
    L5:
        if (r100.I0() != true) goto L7;
        r101 = true;
        goto L9
    }
}
