package nv3;

import android.app.Activity;
import android.app.ActivityManager;
import android.net.Uri;
import android.os.Handler;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.ActivityManagerLancet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f520841a = null;

    static {
        f520841a = new o();
    }

    public o() {
    }

    public static boolean a(Activity r100, Uri r101, boolean r110) {
        Handler r102 = s.f520844a;
        if (r101 != null) goto L5;
    L13:
        r101 = null;
    L15:
        if (r101 != null) goto L17;
        u r103 = new u(false, null);
    L55:
        final t r104 = r103.f520858b;
        if (r104 == null) goto L72;
        f520841a.getClass();
        if (r104.f520856a == r100.getTaskId()) goto L72;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L66
        Object r106 = r100.getSystemService("activity");     // Catch: Throwable -> L66
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L66
        ActivityManager r107 = (ActivityManager) r106;     // Catch: Throwable -> L66
        int r108 = r104.f520856a;     // Catch: Throwable -> L66
        if (r108 == 0) goto L63;
        r107.moveTaskToFront(r108, 0);     // Catch: Throwable -> L66
    L64:
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L66
    L68:
        final Throwable r111 = Result.m9452exceptionOrNullimpl(r109);
        if (r111 == null) goto L72;
        FLogger.f375446a.h("AISDK_HuaweiHealthCallback", new n(r104, r111));
        goto L72
    L63:
        ActivityManagerLancet.handleFakeMoveTaskToFront(0);     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L72:
        if (r103.f520857a == false) goto L76;
        if (r110 == false) goto L76;
        r100.finish();
    L76:
        return r103.f520857a;
    L17:
        String r113 = UriProtector.getQueryParameter(r101, "state");
        String r114 = "";
        if (r113 != null) goto L21;
        r113 = "";
    L21:
        if (m.a(r101, "/healthKitHuawei") == false) goto L31;
        s.b r115 = s.f520845b;
        if ((r115 instanceof s.a) == false) goto L25;
        s.b r116 = (s.a) r115;
    L26:
        if (r116 != null) goto L28;
    L35:
        r116 = null;
    L36:
        if (r116 != null) goto L38;
        FLogger.f375446a.f("AISDK_HuaweiHealthCallback", new p());
        r103 = new u(true, null);
        goto L55
    L38:
        s.c(r116.f520849a);
        if ((r116 instanceof s.a) == false) goto L52;
        s.a r117 = (s.a) r116;
        String r118 = UriProtector.getQueryParameter(r101, "code");
        if (r118 != null) goto L44;
        r118 = "";
    L44:
        if ((!StringsKt.isBlank(r118)) == false) goto L46;
        r117.f520848h.invoke(r118, r117.f520847g);
    L54:
        r103 = new u(true, r116.f520850b);
        goto L55
    L46:
        String r119 = UriProtector.getQueryParameter(r101, "errorCode");
        if (r119 == null) goto L50;
        r114 = r119;
    L50:
        r117.f520853e.invoke(f3.a.f475272m, "Huawei health authorization returned no code, errorCode=".concat(r114));
        goto L54
    L52:
        if ((r116 instanceof s.c) == false) goto L54;
        ((s.c) r116).f520855g.invoke();
        goto L54
    L28:
        if (Intrinsics.areEqual(r116.f520849a, r113) == false) goto L35;
    L25:
        r116 = null;
        goto L26
    L31:
        if (m.a(r101, "/healthKitHuaweiSync") == false) goto L35;
        s.b r120 = s.f520845b;
        if ((r120 instanceof s.c) == false) goto L35;
        r116 = (s.c) r120;
        goto L36
    L5:
        if (m.a(r101, "/healthKitHuawei") == false) goto L7;
    L10:
        boolean r121 = true;
    L11:
        if (r121 == false) goto L13;
    L7:
        if (m.a(r101, "/healthKitHuaweiSync") == true) goto L10;
        r121 = false;
        goto L11
    }
}
