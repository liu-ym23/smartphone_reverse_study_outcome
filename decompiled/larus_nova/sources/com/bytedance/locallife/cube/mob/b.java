package com.bytedance.locallife.cube.mob;

import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.bullet.service.base.d1;
import com.bytedance.locallife.biz.base.cube.s;
import com.bytedance.locallife.cube.c;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f257256a = 0;

    static {
    }

    public static void a(String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "schema");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L23
        Uri r101 = UriProtector.parse(r110);     // Catch: Throwable -> L23
        String r102 = UriProtector.getQueryParameter(r101, "channel");     // Catch: Throwable -> L23
        String r103 = UriProtector.getQueryParameter(r101, "bundle");     // Catch: Throwable -> L23
        if (r103 == null) goto L6;
        List r104 = StringsKt.split$default(r103, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null);     // Catch: Throwable -> L23
    L8:
        if (r104 != null) goto L10;
    L13:
        boolean r105 = false;
    L15:
        if (r105 == false) goto L17;
        String r106 = (String) CollectionsKt.first(r104);     // Catch: Throwable -> L23
    L18:
        c.d().k();     // Catch: Throwable -> L23
        s r107 = s.f256551a;     // Catch: Throwable -> L23
        JSONObject r108 = new JSONObject();     // Catch: Throwable -> L23
        r108.put("channel", r102);     // Catch: Throwable -> L23
        r108.put("bundle", r106);     // Catch: Throwable -> L23
        r108.put("code", 0);     // Catch: Throwable -> L23
        r108.put("schema", r110);     // Catch: Throwable -> L23
        r108.put(BdpAppEventConstant.PARAMS_STRATEGY_NAME, r111);     // Catch: Throwable -> L23
        if (r112 != null) goto L21;
        r112 = "";
    L21:
        r108.put("errorMsg", r112);     // Catch: Throwable -> L23
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L23
        r107.b(r108);     // Catch: Throwable -> L23
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
        return;
    L17:
        r106 = "";
        goto L18
    L10:
        r105 = true;
        if ((!r104.isEmpty()) != true) goto L13;
    L6:
        r104 = null;
    L23:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void b(String r110, String r111, d1 r112) {
        Intrinsics.checkNotNullParameter(r110, "schema");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L29
        Uri r101 = UriProtector.parse(r110);     // Catch: Throwable -> L29
        String r102 = UriProtector.getQueryParameter(r101, "channel");     // Catch: Throwable -> L29
        String r103 = UriProtector.getQueryParameter(r101, "bundle");     // Catch: Throwable -> L29
        if (r103 == null) goto L6;
        List r104 = StringsKt.split$default(r103, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null);     // Catch: Throwable -> L29
    L8:
        if (r104 != null) goto L10;
    L12:
        boolean r105 = false;
    L13:
        if (r105 == false) goto L16;
        String r106 = (String) CollectionsKt.first(r104);     // Catch: Throwable -> L29
    L17:
        c.d().k();     // Catch: Throwable -> L29
        s r107 = s.f256551a;     // Catch: Throwable -> L29
        JSONObject r108 = new JSONObject();     // Catch: Throwable -> L29
        r108.put("channel", r102);     // Catch: Throwable -> L29
        r108.put("bundle", r106);     // Catch: Throwable -> L29
        r108.put("code", 1);     // Catch: Throwable -> L29
        r108.put("schema", r110);     // Catch: Throwable -> L29
        r108.put(BdpAppEventConstant.PARAMS_STRATEGY_NAME, r111);     // Catch: Throwable -> L29
        if (r112 == null) goto L27;
        r108.put("version", r112.f247863f);     // Catch: Throwable -> L29
        r108.put("resFrom", r112.a());     // Catch: Throwable -> L29
        if (r112.f247871n == false) goto L23;
        String r113 = "memory";
    L26:
        r108.put("type", r113);     // Catch: Throwable -> L29
        goto L27
    L23:
        if (r112.f247862e == false) goto L25;
        r113 = UploadTypeInf.DISK;
        goto L26
    L25:
        r113 = "remote";
    L27:
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L29
        r107.b(r108);     // Catch: Throwable -> L29
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
        return;
    L16:
        r106 = "";
        goto L17
    L10:
        if ((!r104.isEmpty()) != true) goto L12;
        r105 = true;
        goto L13
    L6:
        r104 = null;
    L29:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
