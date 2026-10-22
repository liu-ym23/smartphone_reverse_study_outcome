package com.larus.uaigc.helper;

import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import com.larus.platform.service.DownloadWatermarkService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes31.dex */
public final class EnterpriseFileDownloadHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnterpriseFileDownloadHelper f372995a = null;

    static {
        f372995a = new EnterpriseFileDownloadHelper();
    }

    public EnterpriseFileDownloadHelper() {
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(UriProtector.getQueryParameter(UriProtector.parse(r100), "mime_type"));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        String r103 = (String) r102;
        if (r103 == null) goto L14;
        return r103;
    L14:
        return StringsKt.substringAfterLast(StringsKt.substringBefore$default(StringsKt.substringBefore$default(r100, '#', null, 2, null), '?', null, 2, null), '.', "").toLowerCase(Locale.ROOT);
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v4 */
    public final Object c(e0 r110, Continuation<? super String> r111) {
        e0 r100 = r110;
        if ((r111 instanceof EnterpriseFileDownloadHelper$resolveFinalDownloadUrl$1) == false) goto L7;
        EnterpriseFileDownloadHelper$resolveFinalDownloadUrl$1 r101 = (EnterpriseFileDownloadHelper$resolveFinalDownloadUrl$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r112 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        String r113 = null;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        ResultKt.throwOnFailure(r103);
    L55:
        return r103;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (e0) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L19:
        dm9.a r105 = (dm9.a) r103;
        boolean r106 = r105 instanceof dm9.a.b;
        if (r106 == false) goto L62;
        dm9.a.b r107 = (dm9.a.b) r105;
        if (r107.f469231a.isSuccess() == false) goto L62;
        q0 r108 = (q0) r107.f469231a.getData();
        if (r108 == null) goto L29;
        String r109 = r108.b();
        if (r109 == null) goto L29;
        Object r114 = r109.toLowerCase(Locale.ROOT);
    L30:
        boolean r115 = false;
        if (Intrinsics.areEqual(r114, "ready") == false) goto L44;
        String r116 = r108.a();
        if (r116 != 0) goto L35;
    L36:
        r115 = true;
    L37:
        if (r115 == false) goto L40;
        r116 = r113;
    L40:
        if (r116 == 0) goto L80;
        DownloadWatermarkService.f365700a.getClass();
        DownloadWatermarkService.f(r116);
        return r116;
    L80:
        return r100.f373008a;
    L35:
        if (r116.length() != 0) goto L37;
    L44:
        if (Intrinsics.areEqual(r114, "processing") == false) goto L56;
        String r117 = r108.c();
        if (r117 != null) goto L48;
    L49:
        r115 = true;
    L50:
        if (r115 == false) goto L52;
        FLogger.f375446a.e("EnterpriseFileDownloadHelper", "watermarkDownload missing taskId, context=" + r100);
        return r100.f373008a;
    L52:
        r101.L$0 = r113;
        r101.label = 2;
        r103 = b(r117, r100, r101);
        if (r103 != r112) goto L55;
        return r112;
    L48:
        if (r117.length() != 0) goto L50;
    L56:
        FLogger r118 = FLogger.f375446a;
        StringBuilder r119 = new StringBuilder("watermarkDownload unexpected status=");
        if (r108 == null) goto L59;
        String r120 = r108.b();
    L60:
        r119.append(r120);
        r119.append(", context=");
        r119.append(r100);
        r118.e("EnterpriseFileDownloadHelper", r119.toString());
        return r100.f373008a;
    L59:
        r120 = r113;
    L29:
        r114 = r113;
    L62:
        if (r106 == false) goto L64;
        dm9.a.b r121 = (dm9.a.b) r105;
    L65:
        if (r121 == 0) goto L69;
        BizResponse<T> r122 = r121.f469231a;
        if (r122 == 0) goto L69;
        Object r123 = Boxing.boxLong(r122.getCode());
    L70:
        if (r106 == false) goto L72;
        dm9.a.b r124 = (dm9.a.b) r105;
    L73:
        if (r124 == 0) goto L77;
        BizResponse<T> r125 = r124.f469231a;
        if (r125 == 0) goto L77;
        r113 = r125.getMsg();
    L77:
        FLogger.f375446a.e("EnterpriseFileDownloadHelper", "watermarkDownload failed, code=" + r123 + ", msg=" + r113 + ", context=" + r100);
        return r100.f373008a;
    L72:
        r124 = r113;
    L69:
        r123 = r113;
        goto L70
    L64:
        r121 = r113;
        goto L65
    L16:
        ResultKt.throwOnFailure(r103);
        EnterpriseFileWatermarkApi.a r126 = EnterpriseFileWatermarkApi.f372996a;
        EnterpriseFileDownloadHelper$resolveFinalDownloadUrl$result$1 r127 = new EnterpriseFileDownloadHelper$resolveFinalDownloadUrl$result$1(r100, r113);
        r101.L$0 = r100;
        r101.label = 1;
        r126.getClass();
        FlowHttpConnection r128 = FlowHttpConnection.f359975a;
        r103 = FlowHttpConnection.g(ServiceType.UGC, EnterpriseFileWatermarkApi.class, r127, true, "/alice/resource/watermark_download", null, null, r101, 224);
        if (r103 != r112) goto L19;
        return r112;
    L7:
        r101 = new EnterpriseFileDownloadHelper$resolveFinalDownloadUrl$1(this, r111);
        goto L8
    }

    public final Object d(e0 r100, Continuation<? super String> r101) {
        if (com.larus.platform.service.n0.f365775a.b() == true) goto L11;
        if (z2.f365865a.enableCreationFileWatermark() == true) goto L7;
        FLogger.f375446a.i("EnterpriseFileDownloadHelper", "file watermark disable, skip redundant resolve");
        return r100.f373008a;
    L7:
        return c(r100, r101);
    L11:
        return c(r100, r101);
    }

    public final Object b(String r210, e0 r211, Continuation<? super String> r212) {
        if ((r212 instanceof EnterpriseFileDownloadHelper$pollFinalDownloadUrl$1) == false) goto L7;
        EnterpriseFileDownloadHelper$pollFinalDownloadUrl$1 r100 = (EnterpriseFileDownloadHelper$pollFinalDownloadUrl$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        int r105 = 1;
        Continuation r106 = null;
        String r107 = "EnterpriseFileDownloadHelper";
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        int r108 = r100.I$1;
        long r110 = r100.J$0;
        int r111 = r100.I$0;
        e0 r112 = (e0) r100.L$1;
        String r113 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Object r109 = r103;
        String r114 = r113;
        EnterpriseFileDownloadHelper$pollFinalDownloadUrl$1 r115 = r100;
        int r116 = r111;
        e0 r117 = r112;
        String r118 = "EnterpriseFileDownloadHelper";
        long r119 = r110;
        int r120 = r108;
    L64:
        int r121 = r120 + 1;
        Object r122 = r109;
        r105 = 1;
        r106 = null;
    L17:
        if (r121 >= r116) goto L83;
        EnterpriseFileWatermarkApi.a r123 = EnterpriseFileWatermarkApi.f372996a;
        EnterpriseFileDownloadHelper$pollFinalDownloadUrl$2$result$1 r124 = new EnterpriseFileDownloadHelper$pollFinalDownloadUrl$2$result$1(r114, r106);
        r115.L$0 = r114;
        r115.L$1 = r117;
        r115.I$0 = r116;
        r115.J$0 = r119;
        r115.I$1 = r121;
        r115.I$2 = r121;
        r115.label = r105;
        r123.getClass();
        FlowHttpConnection r125 = FlowHttpConnection.f359975a;
        long r213 = r119;
        String r126 = r118;
        int r127 = r116;
        int r128 = r121;
        Object r129 = FlowHttpConnection.g(ServiceType.UGC, EnterpriseFileWatermarkApi.class, r124, true, "/alice/resource/watermark_task", null, null, r115, 224);
        if (r129 != r122) goto L21;
        return r122;
    L21:
        String r130 = r114;
        e0 r131 = r117;
        r100 = r115;
        r103 = r122;
        int r132 = r127;
        r102 = r129;
        int r133 = r128;
        r120 = r133;
        r119 = r213;
        r107 = r126;
    L22:
        dm9.a r134 = (dm9.a) r102;
        boolean r135 = r134 instanceof dm9.a.b;
        if (r135 == false) goto L65;
        dm9.a.b r136 = (dm9.a.b) r134;
        if (r136.f469231a.isSuccess() == false) goto L65;
        r0 r137 = (r0) r136.f469231a.getData();
        if (r137 == null) goto L32;
        String r138 = r137.b();
        if (r138 == null) goto L32;
        String r139 = r138.toLowerCase(Locale.ROOT);
    L34:
        if (Intrinsics.areEqual(r139, "ready") == false) goto L50;
        String r140 = r137.a();
        if (r140 != null) goto L38;
    L41:
        boolean r141 = true;
    L42:
        if (r141 == true) goto L44;
        String r142 = r140;
    L45:
        if (r142 == null) goto L48;
        DownloadWatermarkService.f365700a.getClass();
        DownloadWatermarkService.f(r142);
        return r142;
    L48:
        return r131.f373008a;
    L44:
        r142 = null;
        goto L45
    L38:
        if (r140.length() == 0) goto L41;
        r141 = false;
        goto L42
    L50:
        if (Intrinsics.areEqual(r139, "processing") == true) goto L58;
        FLogger r143 = FLogger.f375446a;
        StringBuilder r144 = new StringBuilder("watermarkTask unexpected status=");
        if (r137 == null) goto L54;
        String r145 = r137.b();
    L55:
        r144.append(r145);
        r144.append(", taskId=");
        r144.append(r130);
        r143.e(r107, r144.toString());
        return r131.f373008a;
    L54:
        r145 = null;
        goto L55
    L58:
        if (r133 >= (r132 - 1)) goto L85;
        r100.L$0 = r130;
        r100.L$1 = r131;
        r100.I$0 = r132;
        r100.J$0 = r119;
        r100.I$1 = r120;
        r100.label = 2;
        if (DelayKt.delay(r119, r100) != r103) goto L63;
        return r103;
    L63:
        r109 = r103;
        r114 = r130;
        r115 = r100;
        r117 = r131;
        r116 = r132;
        r118 = r107;
        goto L64
    L85:
        r109 = r103;
        r114 = r130;
        r115 = r100;
        r117 = r131;
        r116 = r132;
        r118 = r107;
    L32:
        r139 = null;
    L65:
        if (r135 == false) goto L67;
        dm9.a.b r146 = (dm9.a.b) r134;
    L68:
        if (r146 == null) goto L72;
        BizResponse<T> r147 = r146.f469231a;
        if (r147 == 0) goto L72;
        Long r148 = Boxing.boxLong(r147.getCode());
    L73:
        if (r135 == false) goto L75;
        dm9.a.b r149 = (dm9.a.b) r134;
    L76:
        if (r149 == null) goto L80;
        BizResponse<T> r150 = r149.f469231a;
        if (r150 == 0) goto L80;
        String r151 = r150.getMsg();
    L81:
        FLogger.f375446a.e(r107, "watermarkTask failed, code=" + r148 + ", msg=" + r151 + ", taskId=" + r130);
        return r131.f373008a;
    L80:
        r151 = null;
        goto L81
    L75:
        r149 = null;
    L72:
        r148 = null;
        goto L73
    L67:
        r146 = null;
        goto L68
    L83:
        FLogger.f375446a.e(r118, "watermarkTask reach max poll count(" + r116 + "), taskId=" + r114 + ", context=" + r117);
        return r117.f373008a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r133 = r100.I$2;
        r120 = r100.I$1;
        r119 = r100.J$0;
        r132 = r100.I$0;
        r131 = (e0) r100.L$1;
        r130 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        goto L22
    L16:
        ResultKt.throwOnFailure(r102);
        z2 r152 = z2.f365865a;
        int r153 = r152.getWatermarkPollMaxCount();
        long r154 = r152.getWatermarkPollInterval();
        r114 = r210;
        r116 = r153;
        r118 = "EnterpriseFileDownloadHelper";
        r119 = r154;
        r121 = 0;
        r122 = r103;
        r115 = r100;
        r117 = r211;
    L7:
        r100 = new EnterpriseFileDownloadHelper$pollFinalDownloadUrl$1(this, r212);
        goto L8
    }
}
