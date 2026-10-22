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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o {
    public static final o a = null;

    static {
        a = new o();
    }

    public o() {
    }

    public static boolean a(Activity r8, Uri r9, boolean r10) {
        Handler r0 = s.a;
        if (r9 != null) goto L5;
    L13:
        r9 = null;
    L15:
        if (r9 != null) goto L17;
        u r11 = new u(false, null);
    L55:
        final t r1 = r11.b;
        if (r1 == null) goto L72;
        a.getClass();
        if (r1.a == r8.getTaskId()) goto L72;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L66
        Object r3 = r8.getSystemService("activity");     // Catch: Throwable -> L66
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L66
        ActivityManager r4 = (ActivityManager) r3;     // Catch: Throwable -> L66
        int r5 = r1.a;     // Catch: Throwable -> L66
        if (r5 == 0) goto L63;
        r4.moveTaskToFront(r5, 0);     // Catch: Throwable -> L66
    L64:
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L66
    L68:
        final Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L72;
        FLogger.a.h("AISDK_HuaweiHealthCallback", new n(r1, r7));
        goto L72
    L63:
        ActivityManagerLancet.handleFakeMoveTaskToFront(0);     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L72:
        if (r11.a == false) goto L76;
        if (r10 == false) goto L76;
        r8.finish();
    L76:
        return r11.a;
    L17:
        String r13 = UriProtector.getQueryParameter(r9, "state");
        String r14 = "";
        if (r13 != null) goto L21;
        r13 = "";
    L21:
        if (m.a(r9, "/healthKitHuawei") == false) goto L31;
        s.b r15 = s.b;
        if ((r15 instanceof s.a) == false) goto L25;
        s.b r16 = (s.a) r15;
    L26:
        if (r16 != null) goto L28;
    L35:
        r16 = null;
    L36:
        if (r16 != null) goto L38;
        FLogger.a.f("AISDK_HuaweiHealthCallback", new p());
        r11 = new u(true, null);
        goto L55
    L38:
        s.c(r16.a);
        if ((r16 instanceof s.a) == false) goto L52;
        s.a r17 = (s.a) r16;
        String r18 = UriProtector.getQueryParameter(r9, "code");
        if (r18 != null) goto L44;
        r18 = "";
    L44:
        if ((!StringsKt.isBlank(r18)) == false) goto L46;
        r17.h.invoke(r18, r17.g);
    L54:
        r11 = new u(true, r16.b);
        goto L55
    L46:
        String r19 = UriProtector.getQueryParameter(r9, "errorCode");
        if (r19 == null) goto L50;
        r14 = r19;
    L50:
        r17.e.invoke(f3.a.m, "Huawei health authorization returned no code, errorCode=".concat(r14));
        goto L54
    L52:
        if ((r16 instanceof s.c) == false) goto L54;
        ((s.c) r16).g.invoke();
        goto L54
    L28:
        if (Intrinsics.areEqual(r16.a, r13) == false) goto L35;
    L25:
        r16 = null;
        goto L26
    L31:
        if (m.a(r9, "/healthKitHuaweiSync") == false) goto L35;
        s.b r20 = s.b;
        if ((r20 instanceof s.c) == false) goto L35;
        r16 = (s.c) r20;
        goto L36
    L5:
        if (m.a(r9, "/healthKitHuawei") == false) goto L7;
    L10:
        boolean r21 = true;
    L11:
        if (r21 == false) goto L13;
    L7:
        if (m.a(r9, "/healthKitHuaweiSync") == true) goto L10;
        r21 = false;
        goto L11
    }
}
