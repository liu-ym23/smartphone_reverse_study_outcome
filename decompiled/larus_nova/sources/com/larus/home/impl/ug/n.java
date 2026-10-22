package com.larus.home.impl.ug;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f346328a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f346329b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f346330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f346331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f346332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f346333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f346334g;

    public n() {
    }

    static {
        f346328a = new n();
        f346329b = LazyKt.lazy(new m());
        f346330c = "";
        f346331d = "";
        f346332e = "";
        f346333f = "";
        f346334g = "";
    }

    public static boolean a(Context r110, Uri r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "uri");
        FLogger r100 = FLogger.f375446a;
        r100.i("UGReturnSchemeProcessor", "[process] uri:" + r111);
        String r101 = y0.f(r111, "aid");
        Object r102 = null;
        if (r101 == null) goto L5;
        String r103 = AppConstants.SCHEME_SNSSDK + r101 + "://";
    L6:
        String r104 = y0.f(r111, "backurl");
        if (r104 != null) goto L10;
        if (r103 != null) goto L11;
        return false;
    L11:
        Uri r105 = UriProtector.parse(r103);
        Lazy r106 = f346329b;
        if (((Map) r106.getValue()).containsKey(r105.getScheme()) == false) goto L42;
        String r107 = r105.getScheme();
        String r108 = "";
        if (r107 != null) goto L16;
        r107 = "";
    L16:
        f346333f = r107;
        f346332e = r103;
        String r109 = (String) ((Map) r106.getValue()).get(f346333f);
        if (r109 != null) goto L19;
        r109 = "";
    L19:
        f346330c = r109;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L22
        Object r113 = Result.m9449constructorimpl(r110.getResources().getString(r110.getResources().getIdentifier(f346330c, "string", r110.getPackageName())));     // Catch: Throwable -> L22
    L24:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 == null) goto L28;
        FLogger.f375446a.e("UGReturnSchemeProcessor", "[process] getTitle failed, " + r114);
    L28:
        if (Result.m9455isFailureimpl(r113) == true) goto L31;
        r102 = r113;
    L31:
        String r115 = (String) r102;
        if (r115 != null) goto L34;
        r115 = "";
    L34:
        f346331d = r115;
        String r116 = y0.f(r111, "open_method");
        if (r116 == null) goto L38;
        r108 = r116;
    L38:
        f346334g = r108;
        FLogger.f375446a.i("UGReturnSchemeProcessor", "[process] backurlString:" + f346332e + ", scheme:" + r105.getScheme() + ", title:" + f346331d + ", currentTitleKey:" + f346330c + ", openMethod:" + f346334g);
        if (f346331d.length() <= 0) goto L46;
        return true;
    L46:
        return false;
    L22:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L42:
        r100.e("UGReturnSchemeProcessor", "[process] invalid scheme, " + r105.getScheme());
        return false;
    L10:
        r103 = r104;
        goto L11
    L5:
        r103 = null;
        goto L6
    }
}
