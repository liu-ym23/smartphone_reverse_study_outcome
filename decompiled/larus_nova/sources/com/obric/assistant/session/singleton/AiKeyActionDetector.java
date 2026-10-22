package com.obric.assistant.session.singleton;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.content.IntentCompat;
import com.larus.audio.utils.g1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureAction;
import com.obric.assistant.activation.presentation.contract.gesture.ObricAiKeyGestureState;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.session.model.ILaunchMethodOperation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class AiKeyActionDetector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AiKeyActionDetector f391622a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f391623b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f391624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Bundle f391625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f391626e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f391627f = null;

    public interface a {
        void a(Bundle r100);

        void b(String r100);

        void c();

        void g();

        void i();

        void j();

        void k();

        void l();

        void o();

        void q();
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f391628a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f391629b = null;

        static {
            int[] r100 = new int[ObricAiKeyGestureAction.values().length];
            r100[ObricAiKeyGestureAction.DOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L53:
            r100[ObricAiKeyGestureAction.LONG_PRESS_FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L63:
            r100[ObricAiKeyGestureAction.SINGLE_PRESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L39:
            r100[ObricAiKeyGestureAction.DOUBLE_PRESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L41:
            r100[ObricAiKeyGestureAction.PRESS_START.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L51:
            r100[ObricAiKeyGestureAction.SHORT_PRESS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L61:
            r100[ObricAiKeyGestureAction.LONG_PRESS_START.ordinal()] = 7;     // Catch: NoSuchFieldError -> L29
        L45:
            r100[ObricAiKeyGestureAction.LONG_PRESS_STOP.ordinal()] = 8;     // Catch: NoSuchFieldError -> L30
        L55:
            r100[ObricAiKeyGestureAction.CANCEL.ordinal()] = 9;     // Catch: NoSuchFieldError -> L31
        L57:
            r100[ObricAiKeyGestureAction.TIMEOUT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
        L16:
            f391628a = r100;
            int[] r101 = new int[ObricAiKeyGestureState.values().length];
            r101[ObricAiKeyGestureState.FIRST_DOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
        L49:
            r101[ObricAiKeyGestureState.PRESS_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
        L59:
            r101[ObricAiKeyGestureState.SECOND_DOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L35
        L37:
            r101[ObricAiKeyGestureState.LONG_PRESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L36
        L21:
            f391629b = r101;
        }
    }

    public AiKeyActionDetector() {
    }

    static {
        f391622a = new AiKeyActionDetector();
        Handler r100 = g1.f290034a;
        f391623b = g1.f290034a;
        f391626e = LazyKt.lazy(new com.obric.assistant.session.singleton.a());
        f391627f = LazyKt.lazy(new com.obric.assistant.session.singleton.b());
    }

    public static long a(Bundle r100) {
        Long r101 = Long.valueOf(r100.getLong(IntentCompat.EXTRA_TIME, -1));
        if (r101.longValue() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        r101 = null;
    L9:
        if (r101 == null) goto L12;
        return r101.longValue();
    L12:
        return SystemClock.uptimeMillis();
    L5:
        r102 = false;
        goto L6
    }

    public static void b(Bundle r100) {
        FLogger.f375446a.i("AiKeyActionDetector", "onKeyCancel");
        com.obric.assistant.common.utils.i.a r101 = com.obric.assistant.common.utils.i.a("ObricAiKey.keyCancel");
        f391622a.getClass();     // Catch: Throwable -> L7
        ((cba.b) f391627f.getValue()).f(a(r100));     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        if (r101 == null) goto L13;
        r101.a();
        return;
    L13:
        return;
    L7:
        th = move-exception;
        if (r101 == null) goto L10;
        r101.a();
    L10:
        throw th;
    }

    public static void c(Bundle r100) {
        FLogger.f375446a.i("AiKeyActionDetector", "onKeyDown");
        f391625d = r100;
        com.obric.assistant.common.utils.i.a r101 = com.obric.assistant.common.utils.i.a("ObricAiKey.keyDown");
        f391622a.getClass();     // Catch: Throwable -> L7
        ((cba.b) f391627f.getValue()).g(a(r100));     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        if (r101 == null) goto L13;
        r101.a();
        return;
    L13:
        return;
    L7:
        th = move-exception;
        if (r101 == null) goto L10;
        r101.a();
    L10:
        throw th;
    }

    public static void d(Bundle r100) {
        FLogger.f375446a.i("AiKeyActionDetector", "onKeyUp");
        com.obric.assistant.common.utils.i.a r101 = com.obric.assistant.common.utils.i.a("ObricAiKey.keyUp");
        f391622a.getClass();     // Catch: Throwable -> L7
        ((cba.b) f391627f.getValue()).h(a(r100));     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        if (r101 == null) goto L13;
        r101.a();
        return;
    L13:
        return;
    L7:
        th = move-exception;
        if (r101 == null) goto L10;
        r101.a();
    L10:
        throw th;
    }

    public static void e(int r100, String r101, String r102) {
        JSONObject r103 = new JSONObject().put("press_type", r101).put("end_reason", r102).put("keyguard_locked", IKeyguardStateKt.getKeyguardState().isKeyguardLocked());
        ILaunchMethodOperation r104 = bga.g.a();
        if (r104 == null) goto L6;
        Intrinsics.checkNotNull(r103);
        r104.c(r100, r103);
        return;
    }
}
