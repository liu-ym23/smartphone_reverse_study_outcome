package aw3;

import android.os.Looper;
import com.bytedance.applet.audio.background.AppletBackgroundAudioMediaSessionService;
import com.bytedance.applet.audio.background.BackgroundAudioEventName;
import com.bytedance.applet.audio.background.BackgroundAudioPlaybackState;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.audio.controller.GlobalAudioController;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import com.larus.utils.logger.FLogger;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class w implements p0.b {
    public static final w a = null;
    public static q0 b;
    public static final Map<String, q0> c = null;
    public static final Set<BackgroundAudioEventName> d = null;
    public static p0 e;
    public static Double f;
    public static boolean g;
    public static boolean h;
    public static boolean i;
    public static final b j = null;
    public static String k;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BackgroundAudioPlaybackState.values().length];
            r0[BackgroundAudioPlaybackState.PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[BackgroundAudioPlaybackState.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[BackgroundAudioPlaybackState.STOPPED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[BackgroundAudioPlaybackState.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class b implements Runnable {
        public b() {
        }

        public final void a() {
            p0 r0 = w.e;
            if (r0 != null) goto L5;
        L9:
            w.i = false;
            return;
        L5:
            if (w.b.m != BackgroundAudioPlaybackState.PLAYING) goto L9;
            w r3 = w.a;
            w.u(r0);
            w.s(r3, BackgroundAudioEventName.TIMEUPDATE, q0.a(w.b), null, null, 12);
            com.larus.utils.y.b().postDelayed(this, 250);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public w() {
    }

    static {
        a = new w();
        b = new q0(0);
        c = new LinkedHashMap();
        d = new LinkedHashSet();
        h = true;
        j = new b();
    }

    public static void D() {
        final p0 r0 = e;
        if (r0 != null) goto L5;
        return;
    L5:
        e = null;
        f = null;
        boolean r1 = false;
        g = false;
        h = true;
        F();
        boolean r3 = r0.f.isWorking();
        final Ref.BooleanRef r4 = new Ref.BooleanRef();
        Function0 r5 = new g(r4, r0);
        if (r0.c == true) goto L9;
        r0.f.g(r5);
        r1 = true;
    L9:
        if (r1 == false) goto L14;
        if (r3 == false) goto L12;
    L17:
        FLogger.a.i("AppletBackgroundAudioManager", "current player detached. stopped: " + r1 + ", wasWorking: " + r3);
        return;
    L12:
        if (r4.element == true) goto L17;
    L14:
        if (r0.c == true) goto L17;
        r0.c = true;
        r0.f.release();
        goto L17
    }

    public static void F() {
        if (i == true) goto L5;
        return;
    L5:
        i = false;
        SoftReference r0 = com.larus.utils.y.a;
        b r1 = j;
        Intrinsics.checkNotNullParameter(r1, "action");
        com.larus.utils.y.a(r1);
    }

    public static q0 o() {
        H("mediaSessionStateSnapshot");
        if (k == null) goto L18;
        String r0 = b.a;
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L20;
        p0 r2 = e;
        if (r2 == null) goto L17;
        u(r2);
    L17:
        return q0.a(b);
    L20:
        return null;
    L7:
        if (StringsKt.isBlank(r0) == true) goto L10;
        r1 = false;
        goto L11
    L18:
        return null;
    }

    public static q0 C(String r1) {
        H("stateForApplet");
        if (n(r1) == false) goto L9;
        p0 r2 = e;
        if (r2 == null) goto L10;
        u(r2);
    L10:
        return q0.a(b);
    L9:
        return j(r1);
    }

    public static void H(String r2) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
        FLogger.a.e("AppletBackgroundAudioManager", r2.concat(" should run on main thread"));
        return;
    }

    public static q0 j(String r2) {
        String r3 = p(r2);
        if (r3 == null) goto L5;
        q0 r4 = (q0) ((LinkedHashMap) c).get(r3);
        if (r4 == null) goto L10;
        return q0.a(r4);
    L10:
        return new q0(0);
    L5:
        return new q0(0);
    }

    public static void l(final p0 r4) {
        Double r0 = f;
        if (r0 == null) goto L6;
        final double r1 = r0.doubleValue();
        f = null;
        r4.e(r1, new j(r4, r1));
        FLogger.a.i("AppletBackgroundAudioManager", "initial seek requested. position: " + r1);
        return;
    }

    public static boolean m(p0 r1) {
        if (e != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean n(String r1) {
        String r0 = k;
        if (r0 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r0, p(r1));
    }

    public static String p(String r1) {
        if (r1 != null) goto L4;
    L6:
        return null;
    L4:
        if ((!StringsKt.isBlank(r1)) == false) goto L6;
        return r1;
    }

    public static void u(p0 r13) {
        q0 r0 = b;
        double r3 = ((double) RangesKt.coerceAtLeast(r13.f.f(), 0)) / 1000.0d;
        double r7 = ((double) RangesKt.coerceAtLeast(r13.f.getAudioDuration(), 0)) / 1000.0d;
        double r9 = ((double) RangesKt.coerceAtLeast(r13.f.f(), 0)) / 1000.0d;
        double r11 = ((double) RangesKt.coerceAtLeast(r13.f.getAudioDuration(), 0)) / 1000.0d;
        int r1 = RangesKt.coerceIn(r13.f.k(), 0, 100);
        if (r11 <= 0.0d) goto L5;
        double r12 = (r11 * ((double) r1)) / 100.0d;
    L6:
        double r2 = RangesKt.coerceAtLeast(r12, r9);
        int r10 = p0.g;
        Double r14 = Double.valueOf(p0.a.a(r13.f.e()));
        r0.getClass();
        r0.h = RangesKt.coerceAtLeast(r3, 0.0d);
        r0.i = RangesKt.coerceAtLeast(r7, 0.0d);
        r0.k = RangesKt.coerceAtLeast(r2, 0.0d);
        if (r14 == null) goto L10;
        r0.l = r14.doubleValue();
        return;
    L10:
        return;
    L5:
        r12 = 0.0d;
        goto L6
    }

    public static void z(final Function0 r2) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r2.invoke();
        return;
    L5:
        com.larus.utils.y.c(new f(r2));
    }

    public final l0 E(String r9) {
        H("stopForApplet");
        if (k != null) goto L7;
        return new l0(j(r9), null);
    L7:
        if (n(r9) == false) goto L9;
        FLogger r0 = FLogger.a;
        StringBuilder r2 = new StringBuilder("stop requested. appletId: ");
        String r10 = p(r9);
        String r3 = "";
        if (r10 != null) goto L13;
        r10 = "";
    L13:
        r2.append(r10);
        r2.append(", owner: ");
        String r11 = k;
        if (r11 == null) goto L17;
        r3 = r11;
    L17:
        r2.append(r3);
        r2.append(", state: ");
        r2.append(b.b());
        r0.i("AppletBackgroundAudioManager", r2.toString());
        D();
        b.e(BackgroundAudioPlaybackState.STOPPED);
        b.d(0.0d);
        CopyOnWriteArrayList<Function1<AppletBackgroundAudioMediaSessionService, Unit>> r12 = g0.a;
        g0.c(q0.a(b));
        G(this, q0.a(b));
        s(this, BackgroundAudioEventName.STOP, q0.a(b), null, null, 12);
        return new l0(q0.a(b), null);
    L9:
        return v(m0.g, r9, "stop");
    }

    @Override // aw3.p0.b
    public final void a(final p0 r2) {
        Intrinsics.checkNotNullParameter(r2, "player");
        z(new aw3.b(r2));
    }

    @Override // aw3.p0.b
    public final void b(final p0 r2) {
        Intrinsics.checkNotNullParameter(r2, "player");
        z(new i(r2));
    }

    @Override // aw3.p0.b
    public final void c(final p0 r2) {
        Intrinsics.checkNotNullParameter(r2, "player");
        z(new h(r2));
    }

    @Override // aw3.p0.b
    public final void d(final p0 r2) {
        Intrinsics.checkNotNullParameter(r2, "player");
        z(new d(r2));
    }

    @Override // aw3.p0.b
    public final void g(final p0 r2) {
        Intrinsics.checkNotNullParameter(r2, "player");
        z(new u(r2));
    }

    @Override // aw3.p0.b
    public final void h(final p0 r2) {
        Intrinsics.checkNotNullParameter(r2, "player");
        z(new s(r2));
    }

    @Override // aw3.p0.b
    public final void i(final p0 r2) {
        Intrinsics.checkNotNullParameter(r2, "player");
        z(new c(r2));
    }

    public final l0 q(String r5) {
        H("pauseForApplet");
        if (k != null) goto L7;
        return new l0(j(r5), null);
    L7:
        if (n(r5) == false) goto L9;
        FLogger r0 = FLogger.a;
        StringBuilder r2 = new StringBuilder("pause requested. appletId: ");
        String r6 = p(r5);
        String r3 = "";
        if (r6 != null) goto L13;
        r6 = "";
    L13:
        r2.append(r6);
        r2.append(", owner: ");
        String r7 = k;
        if (r7 == null) goto L17;
        r3 = r7;
    L17:
        r2.append(r3);
        r2.append(", state: ");
        r2.append(b.b());
        r0.i("AppletBackgroundAudioManager", r2.toString());
        p0 r8 = e;
        boolean r1 = false;
        if (r8 != null) goto L20;
    L25:
        if (r1 == false) goto L28;
        return new l0(q0.a(b), null);
    L28:
        return x(m0.f);
    L20:
        if (r8.c == false) goto L22;
        boolean r9 = false;
    L23:
        if (r9 != true) goto L25;
        r1 = true;
        goto L25
    L22:
        r8.f.h(false, "background_audio");
        r9 = true;
        goto L23
    L9:
        return v(m0.g, r5, "pause");
    }

    public final l0 r(String r13) {
        H("playForApplet");
        String r0 = p(r13);
        if (r0 != null) goto L7;
        return v(m0.j, r13, "play");
    L7:
        if (n(r0) == true) goto L19;
        String r14 = j(r0).a;
        if (r14 != null) goto L11;
    L14:
        boolean r15 = true;
    L15:
        if (r15 == true) goto L17;
        k(r0, "play");
        goto L19
    L17:
        return v(m0.c, r0, "play");
    L11:
        if (r14.length() == 0) goto L14;
        r15 = false;
    L19:
        String r16 = b.a;
        if (r16 != null) goto L22;
    L25:
        boolean r17 = true;
    L26:
        if (r17 == true) goto L28;
        FLogger r18 = FLogger.a;
        StringBuilder r1 = new StringBuilder("play requested. appletId: ");
        r1.append(r0);
        r1.append(", owner: ");
        String r2 = k;
        String r4 = "";
        if (r2 != null) goto L32;
        r2 = "";
    L32:
        r1.append(r2);
        r1.append(", state: ");
        r1.append(b.b());
        r18.i("AppletBackgroundAudioManager", r1.toString());
        String r3 = b.a;
        if (r3 != null) goto L35;
    L69:
        p0 r7 = null;
    L70:
        if (r7 == null) goto L72;
        g = false;
        h = false;
        q0 r5 = q0.a(b);
        Intrinsics.checkNotNullParameter(r5, "state");
        if (r7.c == false) goto L76;
    L79:
        StringBuilder r6 = new StringBuilder("play rejected. released: ");
        r6.append(r7.c);
        r6.append(", hasUrl: ");
        r6.append(!StringsKt.isBlank(r7.b));
        r18.e("BackgroundAudioPlayer", r6.toString());
        m0 r8 = m0.f;
    L80:
        if (r8 != null) goto L90;
        if (MusicPlayManagerDelegate.b.d() == false) goto L94;
        String r9 = k;
        if (r9 == null) goto L87;
        r4 = r9;
    L87:
        r18.i("AppletBackgroundAudioManager", "background audio takeover requested applet music stop. owner: ".concat(r4));
    L94:
        return new l0(q0.a(b), null);
    L90:
        if (b.m != BackgroundAudioPlaybackState.ERROR) goto L93;
        return new l0(q0.a(b), r8);
    L93:
        return x(r8);
    L76:
        if (StringsKt.isBlank(r7.b) == true) goto L79;
        r7.e = null;
        r7.f(r5);
        r7.f.i("background_audio");
        r8 = r7.e;
        goto L80
    L72:
        return x(m0.f);
    L35:
        if ((!StringsKt.isBlank(r3)) == true) goto L38;
        r3 = null;
    L38:
        if (r3 == null) goto L69;
        r7 = e;
        if (r7 == null) goto L43;
        String r10 = r7.b;
    L45:
        if (Intrinsics.areEqual(r10, r3) == false) goto L47;
        r7.f(q0.a(b));
        CopyOnWriteArrayList<Function1<AppletBackgroundAudioMediaSessionService, Unit>> r11 = g0.a;
        g0.a(q0.a(b));
        goto L70
    L47:
        D();
        Double r12 = Double.valueOf(b.g);
        double r19 = r12.doubleValue();
        if (Double.isInfinite(r19) == false) goto L50;
    L52:
        boolean r20 = false;
    L53:
        if (r20 == true) goto L55;
    L57:
        boolean r21 = false;
    L58:
        if (r21 == true) goto L61;
        r12 = null;
    L61:
        f = r12;
        r7 = new p0(q0.a(b), this);
        e = r7;
        g = false;
        h = false;
        StringBuilder r22 = new StringBuilder("new player created. owner: ");
        String r23 = k;
        if (r23 != null) goto L64;
        r23 = "";
    L64:
        r22.append(r23);
        r22.append(", hasInitialSeek: ");
        if (f == null) goto L67;
        boolean r24 = true;
    L68:
        r22.append(r24);
        r22.append(", state: ");
        r22.append(b.b());
        r18.i("AppletBackgroundAudioManager", r22.toString());
        goto L70
    L67:
        r24 = false;
        goto L68
    L55:
        if (r19 <= 0.0d) goto L57;
        r21 = true;
        goto L58
    L50:
        if (Double.isNaN(r19) == true) goto L52;
        r20 = true;
        goto L53
    L43:
        r10 = null;
        goto L45
    L28:
        return x(m0.c);
    L22:
        if (r16.length() == 0) goto L25;
        r17 = false;
        goto L26
    }

    public final l0 x(m0 r8) {
        F();
        b.e(BackgroundAudioPlaybackState.ERROR);
        h = true;
        q0 r0 = q0.a(b);
        CopyOnWriteArrayList<Function1<AppletBackgroundAudioMediaSessionService, Unit>> r1 = g0.a;
        Intrinsics.checkNotNullParameter(r0, "state");
        Intrinsics.checkNotNullParameter(r8, "error");
        FLogger r2 = FLogger.a;
        r2.e("AppletBackgroundAudioMediaSessionController", "media session error. errorCode: " + r8.a + ", state: " + r0.b());
        GlobalAudioController.a.d(g0.b);
        g0.a.clear();
        g0.e(new d0(new y()));
        GlobalAudioObserver.a.f("plugin_background_audio", Integer.valueOf(r8.a), null);
        g0.f(GlobalAudioStateEnum.STOPPED, k);
        G(this, r0);
        StringBuilder r3 = new StringBuilder("background audio error. owner: ");
        String r4 = k;
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r3.append(r4);
        r3.append(", errorCode: ");
        r3.append(r8.a);
        r3.append(", errorMsg: ");
        r3.append(r8.b);
        r3.append(", state: ");
        r3.append(r0.b());
        r2.e("AppletBackgroundAudioManager", r3.toString());
        s(this, BackgroundAudioEventName.ERROR, r0, r8, null, 8);
        return new l0(r0, r8);
    }

    public static boolean B(String r2, q0 r3) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (e != null) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == false) goto L13;
    L14:
        return true;
    L13:
        if (r3.m != BackgroundAudioPlaybackState.STOPPED) goto L14;
        return false;
    L8:
        if (h == true) goto L10;
        r4 = true;
        goto L11
    }

    public static void G(w r1, q0 r2) {
        String r0 = k;
        r1.getClass();
        com.bytedance.applet.task.b.a.getClass();
        com.bytedance.applet.task.b.b(r2, r0);
    }

    public static void w(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        final String r6 = p(r4);
        if (r6 != null) goto L6;
        FLogger.a.i("AppletBackgroundAudioManager", "release ignored from lifecycle. reason: " + r5 + ", appletId missing");
        return;
    L6:
        FLogger.a.i("AppletBackgroundAudioManager", "release requested from lifecycle. reason: " + r5 + ", appletId: " + r6);
        z(new v(r6));
    }

    public final l0 A(double r11, String r13) {
        H("seekToForApplet");
        if (k != null) goto L7;
        return new l0(j(r13), null);
    L7:
        if (n(r13) == true) goto L11;
        return v(m0.g, r13, "seek");
    L11:
        if (Double.isInfinite(r11) == false) goto L13;
    L15:
        boolean r0 = false;
    L16:
        final double r2 = 0.0d;
        if (r0 == false) goto L19;
        r2 = RangesKt.coerceAtLeast(r11, 0.0d);
    L19:
        b.d(r2);
        FLogger r1 = FLogger.a;
        StringBuilder r4 = new StringBuilder("seek requested. appletId: ");
        String r14 = p(r13);
        String r5 = "";
        if (r14 != null) goto L22;
        r14 = "";
    L22:
        r4.append(r14);
        r4.append(", owner: ");
        String r15 = k;
        if (r15 == null) goto L26;
        r5 = r15;
    L26:
        r4.append(r5);
        r4.append(", position: ");
        r4.append(r2);
        r4.append(", rawPosition: ");
        r4.append(r11);
        r1.i("AppletBackgroundAudioManager", r4.toString());
        s(this, BackgroundAudioEventName.SEEKING, q0.a(b), null, null, 12);
        final p0 r12 = e;
        if (r12 != null) goto L31;
        return x(m0.f);
    L31:
        if (r12.e(r2, new t(r12, r2)) == false) goto L34;
        return new l0(q0.a(b), null);
    L34:
        return x(m0.e);
    L13:
        if (Double.isNaN(r11) == true) goto L15;
        r0 = true;
        goto L16
    }

    @Override // aw3.p0.b
    public final void e(final p0 r2, final String r3) {
        Intrinsics.checkNotNullParameter(r2, "player");
        Intrinsics.checkNotNullParameter(r3, "reason");
        z(new k(r2, r3));
    }

    @Override // aw3.p0.b
    public final void f(final p0 r2, final m0 r3) {
        Intrinsics.checkNotNullParameter(r2, "player");
        Intrinsics.checkNotNullParameter(r3, "error");
        z(new e(r2, r3));
    }

    public final void k(String r8, String r9) {
        String r10 = p(r8);
        if (Intrinsics.areEqual(k, r10) == false) goto L5;
        return;
    L5:
        String r5 = k;
        q0 r3 = q0.a(b);
        boolean r0 = B(r5, r3);
        D();
        k = r10;
        if (r10 == null) goto L9;
        q0 r1 = c.remove(r10);
        if (r1 == null) goto L9;
    L10:
        b = r1;
        f = null;
        FLogger r2 = FLogger.a;
        StringBuilder r4 = new StringBuilder("owner changed. reason: ");
        r4.append(r9);
        r4.append(", previous: ");
        if (r5 != null) goto L13;
        String r6 = "";
    L14:
        r4.append(r6);
        r4.append(", next: ");
        if (r10 != null) goto L17;
        r10 = "";
    L17:
        r4.append(r10);
        r4.append(", previousState: ");
        r4.append(r3.b());
        r4.append(", nextState: ");
        r4.append(b.b());
        r2.i("AppletBackgroundAudioManager", r4.toString());
        if (r0 == false) goto L21;
        r3.e(BackgroundAudioPlaybackState.STOPPED);
        r3.d(0.0d);
        g0.c(r3);
        com.bytedance.applet.task.b.a.getClass();
        com.bytedance.applet.task.b.b(r3, r5);
        s(this, BackgroundAudioEventName.STOP, r3, null, r5, 4);
        return;
    L21:
        return;
    L13:
        r6 = r5;
    L9:
        r1 = new q0(0);
        goto L10
    }

    public final void t(BackgroundAudioEventName r8, String r9) {
        p0 r0 = e;
        if (r0 == null) goto L5;
        u(r0);
    L5:
        FLogger.a.i("AppletBackgroundAudioManager", "media session track event. event: " + r8.getValue() + ", appletId: " + r9);
        s(this, r8, q0.a(b), null, r9, 4);
    }

    public final void y(m0 r4, String r5) {
        if (g == false) goto L6;
        FLogger.a.i("AppletBackgroundAudioManager", "player error ignored. reason: already reported, source: " + r5 + ", errorCode: " + r4.a);
        return;
    L6:
        g = true;
        F();
        x(r4);
    }

    public static l0 v(m0 r4, String r5, String r6) {
        q0 r0 = C(r5);
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("action rejected. action: ");
        r2.append(r6);
        r2.append(", appletId: ");
        String r7 = p(r5);
        String r8 = "";
        if (r7 != null) goto L5;
        r7 = "";
    L5:
        r2.append(r7);
        r2.append(", owner: ");
        String r9 = k;
        if (r9 == null) goto L9;
        r8 = r9;
    L9:
        r2.append(r8);
        r2.append(", error: ");
        r2.append(r4.b);
        r1.e("AppletBackgroundAudioManager", r2.toString());
        return new l0(r0, r4);
    }

    public static void s(w r2, BackgroundAudioEventName r3, q0 r4, m0 r5, String r6, int r7) {
        Integer r1 = null;
        if ((r7 & 4) == 0) goto L6;
        r5 = null;
    L6:
        if ((r7 & 8) == 0) goto L8;
        r6 = k;
    L8:
        r2.getClass();
        if (r3 == BackgroundAudioEventName.TIMEUPDATE) goto L18;
        FLogger r8 = FLogger.a;
        StringBuilder r9 = new StringBuilder("publish event. event: ");
        r9.append(r3.getValue());
        r9.append(", targetAppletId: ");
        if (r6 != null) goto L13;
        String r0 = "";
    L14:
        r9.append(r0);
        r9.append(", errorCode: ");
        if (r5 == null) goto L17;
        r1 = Integer.valueOf(r5.a);
    L17:
        r9.append(r1);
        r9.append(", state: ");
        r9.append(r4.b());
        r8.i("AppletBackgroundAudioManager", r9.toString());
        goto L18
    L13:
        r0 = r6;
    L18:
        Lazy r10 = l3.d.a;
        n0 r11 = new n0(r3, r4, r5, r6);
        q0 r12 = r11.b;
        JsonObject r13 = new JsonObject();
        String r14 = r12.a;
        if (r14 == null) goto L21;
        r13.addProperty("src", r14);
    L21:
        String r15 = r12.b;
        if (r15 == null) goto L24;
        r13.addProperty("title", r15);
    L24:
        String r16 = r12.c;
        if (r16 == null) goto L27;
        r13.addProperty("epname", r16);
    L27:
        String r17 = r12.d;
        if (r17 == null) goto L30;
        r13.addProperty("singer", r17);
    L30:
        String r18 = r12.e;
        if (r18 == null) goto L33;
        r13.addProperty("coverImgUrl", r18);
    L33:
        String r19 = r12.f;
        if (r19 == null) goto L36;
        r13.addProperty("webUrl", r19);
    L36:
        r13.addProperty("startTime", Double.valueOf(r12.g));
        r13.addProperty("currentTime", Double.valueOf(r12.h));
        r13.addProperty("duration", Double.valueOf(r12.i));
        r13.addProperty("paused", Boolean.valueOf(r12.j));
        r13.addProperty("buffered", Double.valueOf(r12.k));
        r13.addProperty("playbackRate", Double.valueOf(r12.l));
        JsonObject r20 = new JsonObject();
        r20.addProperty("eventName", r11.a.getValue());
        r20.add("state", r13);
        String r21 = r11.d;
        if (r21 == null) goto L39;
        r20.addProperty("appletId", r21);
    L39:
        m0 r22 = r11.c;
        if (r22 == null) goto L42;
        r20.addProperty("errCode", Integer.valueOf(r22.a));
        r20.addProperty("errMsg", r22.b);
    L42:
        l3.a r23 = new l3.a("doubao.onBackgroundAudioManagerStateChange", r20, 4);
        r23.d = r6;
        l3.d.c(r23);
    }
}
