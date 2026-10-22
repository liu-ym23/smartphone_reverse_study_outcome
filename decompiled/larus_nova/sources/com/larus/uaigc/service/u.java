package com.larus.uaigc.service;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.bigimg.i1;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f373992a = null;

    static {
        f373992a = new u();
    }

    public u() {
    }

    public static boolean c(String r100) {
        if (r100 == null) goto L5;
        String r101 = StringsKt.trim(r100).toString();
    L6:
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        if (StringsKt.startsWith$default(r101, "content://", false, 2, null) == false) goto L11;
    L14:
        return true;
    L11:
        if (StringsKt.startsWith$default(r101, MSkiaImageRegionDecoder.FILE_PREFIX, false, 2, null) == true) goto L14;
        if (StringsKt.startsWith$default(r101, HTTP.URL_DEFAULT, false, 2, null) == true) goto L14;
        return false;
    L5:
        r101 = null;
        goto L6
    }

    public static boolean b(Context r100, String r110) {
        FlowFileProtectionService r101 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
        return false;
    L10:
        com.larus.platform.service.o r103 = com.larus.platform.service.o.f365780a;
        JSONObject r104 = new JSONObject();
        r104.put("action", "share");
        r104.put("entry", "generated_local_media");
        r104.put("channel", "more");
        r104.put("content_type", r110);
        Unit r111 = Unit.INSTANCE;
        r103.reportEvent("flow_enterprise_file_egress_block", r104);
        String r112 = r101.A0();
        if (r112 != null) goto L13;
    L19:
        return true;
    L13:
        if ((!StringsKt.isBlank(r112)) == true) goto L16;
        r112 = null;
    L16:
        String r105 = r112;
        if (r105 == null) goto L19;
        t19.s.j(t19.s.f544207a, r100, r105, null, false, 28);
        goto L19
    L5:
        if (r101.I0() != true) goto L7;
        r102 = true;
        goto L8
    }

    public static boolean d(Context r100, Uri r101, String r102) {
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L4
        Intent r104 = new Intent("android.intent.action.SEND");     // Catch: Throwable -> L4
        r104.setType(r102);     // Catch: Throwable -> L4
        r104.putExtra("android.intent.extra.STREAM", r101);     // Catch: Throwable -> L4
        r104.addFlags(1);     // Catch: Throwable -> L4
        r104.addFlags(268435456);     // Catch: Throwable -> L4
        Intent r105 = Intent.createChooser(r104, null);     // Catch: Throwable -> L4
        r105.addFlags(268435456);     // Catch: Throwable -> L4
        r100.startActivity(r105);     // Catch: Throwable -> L4
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L10;
        FLogger.f375446a.e("LocalMediaMenuShareHelper", "shareLocal failed, mimeType=".concat(r102), r107);
    L10:
        return Result.m9456isSuccessimpl(r106);
    L4:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static final Object a(u r100, Context r101, Uri r102, boolean r110, Continuation r111) {
        r100.getClass();
        if ((r111 instanceof LocalMediaMenuShareHelper$resolveLocalShareUri$1) == false) goto L7;
        LocalMediaMenuShareHelper$resolveLocalShareUri$1 r103 = (LocalMediaMenuShareHelper$resolveLocalShareUri$1) r111;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r112 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L17;
        if (r106 == 1) goto L16;
        if (r106 != 2) goto L15;
        ResultKt.throwOnFailure(r105);
    L61:
        return r105;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r107 = (String) r103.L$1;
        Context r108 = (Context) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L47:
        r105 = (Uri) r105;
        if (r105 != null) goto L61;
        Uri r109 = i1.c(r108, new PolarisFileWrapper(r107));
        if (r109 == null) goto L60;
        return r109;
    L60:
        return null;
    L17:
        ResultKt.throwOnFailure(r105);
        if (r102 == null) goto L60;
        if (Intrinsics.areEqual(r102.getScheme(), "content") == true) goto L63;
        String r113 = r102.getScheme();
        if (r113 != null) goto L26;
    L31:
        String r114 = r102.toString();
        Intrinsics.checkNotNull(r114);
        if (StringsKt.startsWith$default(r114, HTTP.URL_DEFAULT, false, 2, null) == true) goto L35;
        r114 = null;
    L35:
        if (r114 == null) goto L60;
        if (StringsKt.isBlank(r114) == true) goto L60;
        if (new PolarisFileWrapper(r114).exists() == false) goto L60;
        if (r110 == false) goto L53;
        ImageSave r115 = ImageSave.f295932a;
        String r116 = new PolarisFileWrapper(r114).getName();
        r103.L$0 = r101;
        r103.L$1 = r114;
        r103.label = 1;
        Object r117 = ImageSave.l(r115, r101, r114, r116, r103);
        if (r117 == r112) goto L62;
        r107 = r114;
        r105 = r117;
        r108 = r101;
    L62:
        return r112;
    L53:
        Uri r118 = i1.c(r101, new PolarisFileWrapper(r114));
        if (r118 != null) goto L65;
        ImageSave r119 = ImageSave.f295932a;
        String r120 = new PolarisFileWrapper(r114).getName();
        r103.label = 2;
        r105 = ImageSave.l(r119, r101, r114, r120, r103);
        if (r105 != r112) goto L61;
    L65:
        return r118;
    L26:
        if (r113.hashCode() != 3143036) goto L31;
        if (r113.equals("file") == false) goto L31;
        r114 = r102.getPath();
        goto L35
    L63:
        return r102;
    L7:
        r103 = new LocalMediaMenuShareHelper$resolveLocalShareUri$1(r100, r111);
        goto L8
    }
}
