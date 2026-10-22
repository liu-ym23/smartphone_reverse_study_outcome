package bw3;

import android.os.Looper;
import com.bytedance.applet.audio.inner.InnerAudioEventName;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.o0;
import com.larus.utils.logger.FLogger;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class v implements f0.b {
    public static final v a = null;
    public static final Map<String, e0> b = null;
    public static final Set<String> c = null;
    public static final Set<String> d = null;
    public static boolean e;
    public static float f;
    public static boolean g;
    public static final b h = null;
    public static final Lazy i = null;
    public static final a j = null;

    public static final class a implements com.larus.media.v {
        public a() {
        }

        public final boolean b(lk9.g r2) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            Map r0 = o0.a;
            return o0.a("plugin_inner_audio", r2.getScene());
        }

        public final void e(final lk9.g r3) {
            Intrinsics.checkNotNullParameter(r3, "applicant");
            com.larus.media.v.a.d(r3);
            v r0 = v.a;
            Function0 r1 = new t(r3);
            r0.getClass();
            v.s(r1);
        }

        public final void f(MediaResourceManager.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public final void a(lk9.g r2, final float r3) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            com.larus.media.v.a.f(r2, r3);
            v r4 = v.a;
            Function0 r0 = new s(r3);
            r4.getClass();
            v.s(r0);
        }

        public final void d(lk9.g r1, lk9.g r2) {
            com.larus.media.v.a.c(r1, r2);
        }

        public final void g(final lk9.g r3, final float r4) {
            Intrinsics.checkNotNullParameter(r3, "applicant");
            com.larus.media.v.a.g(r3, r4);
            v r0 = v.a;
            Function0 r1 = new u(r3, r4);
            r0.getClass();
            v.s(r1);
        }

        public final void i(lk9.g r2, final lk9.g r3) {
            Intrinsics.checkNotNullParameter(r2, "current");
            Intrinsics.checkNotNullParameter(r3, "applicant");
            com.larus.media.v.a.e(r2, r3);
            v r4 = v.a;
            Function0 r0 = new r(r3);
            r4.getClass();
            v.s(r0);
        }

        public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
            return com.larus.media.v.a.a(this, r1, r2, r3);
        }

        public final MediaOccupyStrategy h(lk9.g r1, lk9.g r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "current");
            Intrinsics.checkNotNullParameter(r2, "applicant");
            Map r4 = o0.a;
            return o0.b("plugin_inner_audio", r2.getScene());
        }
    }

    public static final class b implements Runnable {
        public b() {
        }

        public final void a() {
            Set<String> r0 = v.c;
            if (r0.isEmpty() == false) goto L6;
            v.g = false;
            return;
        L6:
            Iterator r1 = CollectionsKt.toList(r0).iterator();
        L8:
            if (r1.hasNext() == false) goto L13;
            String r2 = (String) r1.next();
            e0 r3 = (e0) ((LinkedHashMap) v.b).get(r2);
            if (r3 == null) goto L8;
            v.q(v.a, InnerAudioEventName.TIMEUPDATE, r3.h(), r3.b);
            goto L8
        L13:
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

    public v() {
    }

    static {
        a = new v();
        b = new LinkedHashMap();
        c = new LinkedHashSet();
        d = new LinkedHashSet();
        f = 1.0f;
        h = new b();
        i = LazyKt.lazy(new bw3.b());
        j = new a();
    }

    public static void v() {
        if ((!c.isEmpty()) == false) goto L5;
        return;
    L5:
        if (g == false) goto L10;
        g = false;
        SoftReference r0 = com.larus.utils.y.a;
        b r1 = h;
        Intrinsics.checkNotNullParameter(r1, "action");
        com.larus.utils.y.a(r1);
        return;
    }

    public static e0 k(f0 r2) {
        Map<String, e0> r0 = b;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        e0 r3 = (e0) r1.get(r2.a);
        if (r3 != null) goto L5;
    L12:
        return null;
    L5:
        if (r3.b(r2) == true) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L12;
        return r3;
    L7:
        if (r3.c == true) goto L9;
        r4 = true;
        goto L10
    }

    public static String m(String r1) {
        if (r1 != null) goto L4;
    L6:
        return null;
    L4:
        if ((!StringsKt.isBlank(r1)) == false) goto L6;
        return r1;
    }

    public static float n(float r2) {
        if (Float.isInfinite(r2) == false) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r0 == true) goto L11;
        return 1.0f;
    L11:
        return RangesKt.coerceIn(r2, 0.0f, 1.0f);
    L5:
        if (Float.isNaN(r2) == true) goto L7;
        r0 = true;
        goto L9
    }

    public static void r(String r2) {
        if (e == true) goto L5;
        return;
    L5:
        if ((!c.isEmpty()) == false) goto L7;
        return;
    L7:
        if ((!d.isEmpty()) == true) goto L13;
        e = false;
        Lazy r0 = MediaResourceManager.a;
        MediaResourceManager.a((com.larus.media.model.a) i.getValue());
        FLogger.a.i("AppletInnerAudioManager", "category resource released. scene: plugin_inner_audio, reason: ".concat(r2));
        return;
    }

    public static void s(final Function0 r2) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r2.invoke();
        return;
    L5:
        com.larus.utils.y.b().post(new q(r2));
    }

    public static w t(e0 r1) {
        if (r1.c == false) goto L5;
        int r2 = w.c;
        return w.a.a(x.d, null);
    L5:
        int r0 = w.c;
        return w.a.a(x.g, r1.h());
    }

    public static void w(String r2) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L6;
        FLogger.a.e("AppletInnerAudioManager", r2.concat(" should run on main thread"));
        return;
    }

    @Override // bw3.f0.b
    public final void a(final f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "player");
        s(new o(r2));
    }

    @Override // bw3.f0.b
    public final void b(final f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "player");
        s(new p(r2));
    }

    @Override // bw3.f0.b
    public final void c(final f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "player");
        s(new n(r2));
    }

    @Override // bw3.f0.b
    public final void d(final f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "player");
        s(new j(r2));
    }

    @Override // bw3.f0.b
    public final void e(final f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "player");
        s(new m(r2));
    }

    @Override // bw3.f0.b
    public final void f(final f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "player");
        s(new k(r2));
    }

    @Override // bw3.f0.b
    public final void h(final f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "player");
        s(new c(r2));
    }

    public static void i(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        final String r6 = m(r4);
        if (r6 != null) goto L6;
        FLogger.a.i("AppletInnerAudioManager", "destroy all ignored from lifecycle. reason: " + r5 + ", appletId missing");
        return;
    L6:
        FLogger.a.i("AppletInnerAudioManager", "destroy all requested from lifecycle. reason: " + r5 + ", appletId: " + r6);
        s(new i(r6));
    }

    public static e0 j(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "audioId");
        w("instanceForApplet");
        String r4 = m(r3);
        if (r4 != null) goto L5;
        return null;
    L5:
        e0 r5 = (e0) ((LinkedHashMap) b).get(r2);
        if (r5 != null) goto L9;
        return null;
    L9:
        if (Intrinsics.areEqual(r5.b, r4) == true) goto L11;
    L14:
        return null;
    L11:
        if (r5.c == true) goto L14;
        return r5;
    }

    public static w u(String r5, e0 r6) {
        Set<String> r0 = c;
        r0.add(r5);
        Set<String> r1 = d;
        r1.remove(r5);
        w r2 = r6.c(f);
        if (r2.a() == true) goto L5;
        r0.remove(r5);
        r1.remove(r5);
        r("playFailed");
    L5:
        FLogger.a.i("AppletInnerAudioManager", "play requested. appletId: " + r6.b + ", audioId: " + r5 + ", success: " + r2.a() + ", activeCount: " + r0.size());
        return r2;
    }

    @Override // bw3.f0.b
    public final void g(final f0 r2, final x r3) {
        Intrinsics.checkNotNullParameter(r2, "player");
        Intrinsics.checkNotNullParameter(r3, "error");
        s(new l(r2, r3));
    }

    public static boolean l(String r1, e0 r2, String r3) {
        if (((e0) ((LinkedHashMap) b).get(r1)) == r2) goto L5;
    L9:
        return false;
    L5:
        if (r2.c == true) goto L9;
        if (Intrinsics.areEqual(r2.h().b, r3) == false) goto L9;
        return true;
    }

    public final void o(final String r6, String r7, final Function1<? super w, Unit> r8) {
        Intrinsics.checkNotNullParameter(r6, "audioId");
        Intrinsics.checkNotNullParameter(r8, "completion");
        w("playForApplet");
        final e0 r9 = j(r6, r7);
        String r0 = null;
        if (r9 != null) goto L6;
        int r10 = w.c;
        r8.invoke(w.a.a(x.d, null));
        return;
    L6:
        w r1 = r9.d(this);
        if (r1.a() == true) goto L18;
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("play prepare failed. appletId: ");
        r3.append(r9.b);
        r3.append(", audioId: ");
        r3.append(r6);
        r3.append(", errCode: ");
        x r11 = r1.b;
        if (r11 == null) goto L11;
        Integer r12 = Integer.valueOf(r11.a);
    L12:
        r3.append(r12);
        r3.append(", errMsg: ");
        x r13 = r1.b;
        if (r13 == null) goto L15;
        r0 = r13.b;
    L15:
        r3.append(r0);
        r2.e("AppletInnerAudioManager", r3.toString());
        r8.invoke(r1);
        return;
    L11:
        r12 = null;
        goto L12
    L18:
        if (e == false) goto L20;
        r8.invoke(u(r6, r9));
        return;
    L20:
        final String r4 = r9.h().b;
        Lazy r5 = MediaResourceManager.a;
        MediaResourceManager.m((com.larus.media.model.a) i.getValue(), new d(r6, r9, r4, r8), new e(r6, r9, r4, r8), 0, 8);
    }

    public static void p(InnerAudioEventName r5, h0 r6, x r7, String r8) {
        if (r5 == InnerAudioEventName.TIMEUPDATE) goto L13;
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("publish event. event: ");
        r1.append(r5.getValue());
        r1.append(", appletId: ");
        if (r8 != null) goto L7;
        String r2 = "";
    L8:
        r1.append(r2);
        r1.append(", audioId: ");
        r1.append(r6.a);
        r1.append(", errorCode: ");
        if (r7 == null) goto L11;
        Integer r3 = Integer.valueOf(r7.a);
    L12:
        r1.append(r3);
        r1.append(", state: ");
        r1.append(r6.b());
        r0.i("AppletInnerAudioManager", r1.toString());
        goto L13
    L11:
        r3 = null;
        goto L12
    L7:
        r2 = r8;
    L13:
        Lazy r4 = l3.d.a;
        y r9 = new y(r5, r6, r7, r8);
        h0 r10 = r9.b;
        JsonObject r11 = new JsonObject();
        r11.addProperty("audioId", r10.a);
        String r12 = r10.b;
        if (r12 == null) goto L16;
        r11.addProperty("src", r12);
    L16:
        r11.addProperty("startTime", Double.valueOf(r10.f));
        r11.addProperty("autoplay", Boolean.valueOf(r10.c));
        r11.addProperty("loop", Boolean.valueOf(r10.d));
        r11.addProperty("volume", Double.valueOf(r10.k));
        r11.addProperty("playbackRate", Double.valueOf(r10.l));
        r11.addProperty("currentTime", Double.valueOf(r10.g));
        r11.addProperty("duration", Double.valueOf(r10.h));
        r11.addProperty("paused", Boolean.valueOf(r10.i));
        r11.addProperty("buffered", Double.valueOf(r10.j));
        JsonObject r13 = new JsonObject();
        r13.addProperty("audioId", r9.b.a);
        String r14 = r9.d;
        if (r14 == null) goto L19;
        r13.addProperty("appletId", r14);
    L19:
        r13.addProperty("eventName", r9.a.getValue());
        r13.add("state", r11);
        x r15 = r9.c;
        if (r15 == null) goto L22;
        r13.addProperty("errCode", Integer.valueOf(r15.a));
        r13.addProperty("errMsg", r15.b);
    L22:
        l3.a r16 = new l3.a("doubao.onInnerAudioContextStateChange", r13, 4);
        r16.d = r8;
        l3.d.c(r16);
    }

    public static /* synthetic */ void q(v r0, InnerAudioEventName r1, h0 r2, String r3) {
        r0.getClass();
        p(r1, r2, null, r3);
    }
}
