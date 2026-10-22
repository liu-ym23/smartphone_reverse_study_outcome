package com.bytedance.android.shopping.deepfeed.event;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int r = 0;
    public long a;
    public long b;
    public d c;
    public VelocityTracker d;
    public b e;
    public e f;
    public final List<d> g;
    public final Handler h;
    public f i;
    public final Map<Long, Runnable> j;
    public Runnable k;
    public final int l;
    public final Function2<Float, Float, c> m;
    public final Function0<DeepFeedProductEventTracker> n;
    public final boolean o;
    public final boolean p;
    public final Function1<Integer, Boolean> q;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.event.a$a, reason: collision with other inner class name */
    public static final class C0052a {
    }

    public static final class b {
        public final int a;
        public final int b;
        public final String c;
        public final Integer d;
        public final int e;
        public final int f;
        public final int g;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L20;
            b r4 = (b) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
            return false;
        L14:
            if (this.e == r4.e) goto L16;
            return false;
        L16:
            if (this.f == r4.f) goto L18;
            return false;
        L18:
            if (this.g == r4.g) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        public final int hashCode() {
            int r0 = ((this.a * 31) + this.b) * 31;
            String r1 = this.c;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            Integer r5 = this.d;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            return ((((((r4 + r2) * 31) + this.e) * 31) + this.f) * 31) + this.g;
        L5:
            r3 = 0;
            goto L6
        }

        public final String toString() {
            return "CompletedGesture(dx=" + this.a + ", dy=" + this.b + ", result=" + this.c + ", quadrant=" + this.d + ", xAngle=" + this.e + ", yAngle=" + this.f + ", velocity=" + this.g + ")";
        }

        public b(int r2, int r3, String r4, Integer r5, int r6, int r7, int r8) {
            Intrinsics.checkNotNullParameter(r4, "result");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }
    }

    public static final class c {
        public final String a;
        public final int b;
        public final int c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof c) == false) goto L12;
            c r4 = (c) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L7:
            return (((r1 * 31) + this.b) * 31) + this.c;
        L5:
            r1 = 0;
            goto L7
        }

        public final String toString() {
            return "DownTarget(area=" + this.a + ", dragPosition=" + this.b + ", snapPosition=" + this.c + ")";
        }

        public c(String r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "area");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class d {
        public final long a;
        public final String b;
        public final int c;
        public final int d;
        public final long e;
        public final float f;
        public final float g;
        public long h;
        public float i;
        public float j;
        public float k;
        public float l;
        public boolean m;
        public String n;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof d) == false) goto L34;
            d r7 = (d) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r7.c) goto L12;
            return false;
        L12:
            if (this.d == r7.d) goto L14;
            return false;
        L14:
            if (this.e == r7.e) goto L16;
            return false;
        L16:
            if (Float.compare(this.f, r7.f) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.g, r7.g) == 0) goto L20;
            return false;
        L20:
            if (this.h == r7.h) goto L22;
            return false;
        L22:
            if (Float.compare(this.i, r7.i) == 0) goto L24;
            return false;
        L24:
            if (Float.compare(this.j, r7.j) == 0) goto L26;
            return false;
        L26:
            if (Float.compare(this.k, r7.k) == 0) goto L28;
            return false;
        L28:
            if (Float.compare(this.l, r7.l) == 0) goto L30;
            return false;
        L30:
            if (this.m == r7.m) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.n, r7.n) == true) goto L52;
            return false;
        L52:
            return true;
        L34:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v22, types: [int] */
        /* JADX WARN: Type inference failed for: r0v24 */
        /* JADX WARN: Type inference failed for: r0v26 */
        /* JADX WARN: Type inference failed for: r1v24, types: [int] */
        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            String r2 = this.b;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r2.hashCode();
        L6:
            int r5 = (((((r1 + r4) * 31) + this.c) * 31) + this.d) * 31;
            long r6 = this.e;
            int r7 = (((((r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31) + Float.floatToIntBits(this.f)) * 31) + Float.floatToIntBits(this.g)) * 31;
            long r8 = this.h;
            int r9 = (((((((((r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31) + Float.floatToIntBits(this.i)) * 31) + Float.floatToIntBits(this.j)) * 31) + Float.floatToIntBits(this.k)) * 31) + Float.floatToIntBits(this.l)) * 31;
            boolean r10 = this.m;
            ?? r11 = r10;
            if (r10 == false) goto L9;
            r11 = 1;
        L9:
            int r12 = (r9 + r11) * 31;
            String r13 = this.n;
            if (r13 == null) goto L13;
            r3 = r13.hashCode();
        L13:
            return r12 + r3;
        L5:
            r4 = 0;
            goto L6
        }

        public final String toString() {
            return "GestureSession(id=" + this.a + ", area=" + this.b + ", dragPosition=" + this.c + ", startSnapPosition=" + this.d + ", downTimeMs=" + this.e + ", startX=" + this.f + ", startY=" + this.g + ", endTimeMs=" + this.h + ", endX=" + this.i + ", endY=" + this.j + ", velocityX=" + this.k + ", velocityY=" + this.l + ", ended=" + this.m + ", pendingResult=" + this.n + ")";
        }

        public d(long r2, String r4, int r5, int r6, long r7, float r9, float r10) {
            Intrinsics.checkNotNullParameter(r4, "area");
            this.a = r2;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r9;
            this.g = r10;
            this.h = 0;
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = false;
            this.n = null;
        }
    }

    public static final class e {
        public final long a;
        public final String b;
        public final long c;
        public final long d;
        public final String e;
        public b f;
        public boolean g;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof e) == false) goto L20;
            e r7 = (e) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r7.c) goto L12;
            return false;
        L12:
            if (this.d == r7.d) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r7.e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
            return false;
        L18:
            if (this.g == r7.g) goto L31;
            return false;
        L31:
            return true;
        L20:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r1v12, types: [int] */
        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            String r2 = this.b;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r2.hashCode();
        L6:
            long r5 = this.c;
            int r6 = (((r1 + r4) * 31) + ((int) (r5 ^ (r5 >>> 32)))) * 31;
            long r7 = this.d;
            int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
            String r9 = this.e;
            if (r9 == null) goto L9;
            int r10 = r9.hashCode();
        L10:
            int r11 = (r8 + r10) * 31;
            b r12 = this.f;
            if (r12 == null) goto L13;
            r3 = r12.hashCode();
        L13:
            int r13 = (r11 + r3) * 31;
            boolean r14 = this.g;
            ?? r15 = r14;
            if (r14 == false) goto L17;
            r15 = 1;
        L17:
            return r13 + r15;
        L9:
            r10 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }

        public final String toString() {
            return "RouteEntry(token=" + this.a + ", enterType=" + this.b + ", enterTimeMs=" + this.c + ", createdElapsedMs=" + this.d + ", gestureType=" + this.e + ", gestureSnapshot=" + this.f + ", confirmed=" + this.g + ")";
        }

        public e(long r2, String r4, long r5, long r7, String r9, b r10) {
            Intrinsics.checkNotNullParameter(r4, "enterType");
            Intrinsics.checkNotNullParameter(r9, "gestureType");
            this.a = r2;
            this.b = r4;
            this.c = r5;
            this.d = r7;
            this.e = r9;
            this.f = r10;
            this.g = false;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ long b;

        public f(a r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            this.a.j.remove(Long.valueOf(this.b));
            a r0 = this.a;
            d r1 = r0.c;
            Iterator<T> r2 = r0.g.iterator();
        L4:
            if (r2.hasNext() == false) goto L11;
            Object r3 = r2.next();
            if (((d) r3).a != this.b) goto L8;
            boolean r4 = true;
        L9:
            if (r4 == false) goto L4;
        L12:
            d r5 = (d) r3;
            if (r1 != null) goto L15;
            r1 = r5;
        L15:
            if (r1 != null) goto L17;
            return;
        L17:
            if (r1.m == true) goto L19;
            return;
        L19:
            if (r1.n == null) goto L21;
            return;
        L21:
            if (this.a.f(r1) == false) goto L32;
            this.a.e(r1, "no_action");
            return;
        L32:
            return;
        L8:
            r4 = false;
            goto L9
        L11:
            r3 = null;
            goto L12
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

    static {
    }

    public final void b() {
        Runnable r0 = this.k;
        if (r0 == null) goto L5;
        this.h.removeCallbacks(r0);
    L5:
        this.k = null;
    }

    public final void c() {
        Iterator r0 = CollectionsKt.toList(this.g).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        a((d) r0.next());
        goto L4
    L6:
        ((ArrayList) this.g).clear();
        ((LinkedHashMap) this.j).clear();
        a(null);
        b();
        VelocityTracker r1 = this.d;
        if (r1 == null) goto L9;
        r1.recycle();
    L9:
        this.d = null;
        this.c = null;
    }

    public static Map i(b r3) {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("pre_drag_dx", Integer.valueOf(r3.a)), TuplesKt.to("pre_drag_dy", Integer.valueOf(r3.b)), TuplesKt.to("pre_user_gesture_result", r3.c), TuplesKt.to("pre_user_scroll_degree_quadrant", r3.d), TuplesKt.to("pre_user_drag_y_angle", Integer.valueOf(r3.f)), TuplesKt.to("pre_user_drag_x_angle", Integer.valueOf(r3.e)), TuplesKt.to("pre_user_scroll_velocity", Integer.valueOf(r3.g))});
    }

    public final void a(d r4) {
        if (r4 != null) goto L4;
    L5:
        f r0 = this.i;
        if (r0 == null) goto L8;
        this.h.removeCallbacks(r0);
    L8:
        this.i = null;
    L9:
        if (r4 != null) goto L15;
        Collection r5 = ((LinkedHashMap) this.j).values();
        Handler r1 = this.h;
        Iterator r6 = r5.iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        r1.removeCallbacks((Runnable) r6.next());
        goto L12
    L14:
        ((LinkedHashMap) this.j).clear();
        return;
    L15:
        Runnable r7 = this.j.remove(Long.valueOf(r4.a));
        if (r7 == null) goto L21;
        this.h.removeCallbacks(r7);
        return;
    L21:
        return;
    L4:
        if (this.c != r4) goto L9;
        goto L5
    }

    public final void d(MotionEvent r7) {
        d r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        VelocityTracker r1 = this.d;
        if (r1 == null) goto L8;
        r1.addMovement(r7);
        r1.computeCurrentVelocity(1000);
        r0.k = r1.getXVelocity();
        r0.l = r1.getYVelocity();
    L8:
        VelocityTracker r2 = this.d;
        if (r2 == null) goto L11;
        r2.recycle();
    L11:
        this.d = null;
        r0.h = System.currentTimeMillis();
        r0.i = r7.getX();
        r0.j = r7.getY();
        r0.m = true;
        if (f(r0) == true) goto L16;
        this.c = null;
        return;
    L16:
        if (this.p == true) goto L18;
    L30:
        String r3 = r0.n;
        if (r3 == null) goto L52;
        if (Intrinsics.areEqual(r3, "enter_detail") == false) goto L39;
        if (this.o == true) goto L39;
        this.c = null;
        return;
    L39:
        if (Intrinsics.areEqual(r3, "enter_detail") == false) goto L46;
        e r4 = this.f;
        if (r4 == null) goto L46;
        if (r4.g != true) goto L46;
        e(r0, r3);
    L46:
        if (Intrinsics.areEqual(r3, "switch_image") == false) goto L49;
        b();
        com.bytedance.android.shopping.deepfeed.event.b r8 = new com.bytedance.android.shopping.deepfeed.event.b(this, r0.a);
        this.h.postDelayed(r8, 500);
        Unit r5 = Unit.INSTANCE;
        this.k = r8;
        goto L52
    L49:
        if ((true ^ Intrinsics.areEqual(r3, "enter_detail")) == false) goto L52;
        e(r0, r3);
    L52:
        if (this.c == r0) goto L55;
        return;
    L55:
        if (r0.n != null) goto L61;
        if (g(r0) == false) goto L61;
        ((ArrayList) this.g).add(r0);
        this.c = null;
        h(r0);
        return;
    L61:
        if (r0.n != null) goto L64;
        h(r0);
        return;
    L64:
        return;
    L18:
        if ((!Intrinsics.areEqual(r0.b, "info")) == true) goto L25;
        float r6 = r0.i - r0.f;
        float r9 = r0.j - r0.g;
        if (r6 >= (-this.l)) goto L25;
        if (Math.abs(r6) <= Math.abs(r9)) goto L25;
        boolean r10 = true;
    L26:
        if (r10 == false) goto L30;
        if (((Boolean) this.q.invoke(Integer.valueOf(r0.c))).booleanValue() == false) goto L30;
        r0.n = "enter_detail";
    L25:
        r10 = false;
        goto L26
    }

    public final boolean f(d r3) {
        if (Math.abs(r3.i - r3.f) <= this.l) goto L5;
    L8:
        return true;
    L5:
        if (Math.abs(r3.j - r3.g) > this.l) goto L8;
        return false;
    }

    public final boolean g(d r3) {
        float r0 = Math.abs(r3.i - r3.f);
        float r4 = Math.abs(r3.j - r3.g);
        if (r4 > this.l) goto L5;
    L7:
        return false;
    L5:
        if (r4 < r0) goto L7;
        return true;
    }

    public final void h(d r5) {
        a(r5);
        long r0 = r5.a;
        f r2 = new f(this, r0);
        if (this.c != r5) goto L5;
        this.i = r2;
    L6:
        this.h.postDelayed(r2, 3000);
        return;
    L5:
        this.j.put(Long.valueOf(r0), r2);
        goto L6
    }

    public final void e(d r24, String r25) {
        if (this.o == true) goto L6;
        return;
    L6:
        if (this.c != r24) goto L8;
    L10:
        a(r24);
        b();
        float r2 = r24.i - r24.f;
        float r3 = r24.j - r24.g;
        int r11 = MathKt.roundToInt(Math.abs(r2));
        int r12 = MathKt.roundToInt(Math.abs(r3));
        int r13 = MathKt.roundToInt(Math.toDegrees(Math.atan2(Math.abs(r3), Math.abs(r2))));
        int r14 = MathKt.roundToInt(Math.toDegrees(Math.atan2(Math.abs(r2), Math.abs(r3))));
        int r15 = MathKt.roundToInt(Math.hypot(r24.k, r24.l));
        if (r2 == 0.0f) goto L13;
    L15:
        float r4 = 0;
        if (r2 >= r4) goto L18;
    L20:
        if (r2 < r4) goto L25;
        if (r3 < r4) goto L25;
        int r5 = 2;
    L30:
        Integer r7 = r5;
    L31:
        Integer r16 = r7;
        b r6 = new b(r11, r12, r25, r7, r13, r14, r15);
        DeepFeedProductEventTracker r8 = (DeepFeedProductEventTracker) this.n.invoke();
        if (r8 == null) goto L40;
        Map<String, ? extends Object> r9 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("user_drag_area", r24.b), TuplesKt.to("user_drag_position", Integer.valueOf(r24.c)), TuplesKt.to("user_drag_time", Long.valueOf(r24.e)), TuplesKt.to("user_drag_touch_x", Integer.valueOf(MathKt.roundToInt(r24.f))), TuplesKt.to("user_drag_touch_y", Integer.valueOf(MathKt.roundToInt(r24.g))), TuplesKt.to("user_drag_end_x", Integer.valueOf(MathKt.roundToInt(r24.i))), TuplesKt.to("user_drag_end_y", Integer.valueOf(MathKt.roundToInt(r24.j))), TuplesKt.to("user_drag_y_angle", Integer.valueOf(r14)), TuplesKt.to("user_drag_x_angle", Integer.valueOf(r13)), TuplesKt.to("user_scroll_velocity", Integer.valueOf(r15)), TuplesKt.to("user_scroll_degree_quadrant", r16), TuplesKt.to("user_gesture_result", r25), TuplesKt.to("user_drag_dx", Integer.valueOf(r11)), TuplesKt.to("user_drag_dy", Integer.valueOf(r12)), TuplesKt.to("user_scroll_duration_ms", Long.valueOf(RangesKt.coerceAtLeast(r24.h - r24.e, 0)))});
        b r10 = this.e;
        if (r10 == null) goto L36;
        Map<? extends String, ? extends Object> r17 = i(r10);
    L37:
        if (r17 != null) goto L39;
        r17 = MapsKt.emptyMap();
    L39:
        r9.putAll(r17);
        Unit r18 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r9, "params");
        r8.doEventAction("ec_deep_feed_slide", r9);
        goto L40
    L36:
        r17 = null;
    L40:
        this.e = r6;
        if (Intrinsics.areEqual(r25, "enter_detail") == false) goto L51;
        e r19 = this.f;
        if (r19 == null) goto L51;
        if (Intrinsics.areEqual(r19.b, "product_detail") == true) goto L48;
        r19 = null;
    L48:
        if (r19 == null) goto L51;
        r19.f = r6;
    L51:
        if (this.c != r24) goto L53;
        this.c = null;
        return;
    L53:
        ((ArrayList) this.g).remove(r24);
        return;
    L25:
        if (r2 < r4) goto L27;
    L29:
        r5 = 4;
        goto L30
    L27:
        if (r3 < r4) goto L29;
        r5 = 3;
        goto L30
    L18:
        if (r3 >= r4) goto L20;
        r5 = 1;
        goto L30
    L13:
        if (r3 != 0.0f) goto L15;
        r7 = null;
        goto L31
    L8:
        if (((ArrayList) this.g).contains(r24) == true) goto L10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(int r2, Function2<? super Float, ? super Float, c> r3, Function0<? extends DeepFeedProductEventTracker> r4, boolean r5, boolean r6, Function1<? super Integer, Boolean> r7) {
        Intrinsics.checkNotNullParameter(r3, "targetResolver");
        Intrinsics.checkNotNullParameter(r4, "trackerProvider");
        Intrinsics.checkNotNullParameter(r7, "onInfoSwipeEnterDetail");
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.o = r5;
        this.p = r6;
        this.q = r7;
        this.g = new ArrayList();
        this.h = new Handler(Looper.getMainLooper());
        this.j = new LinkedHashMap();
    }
}
