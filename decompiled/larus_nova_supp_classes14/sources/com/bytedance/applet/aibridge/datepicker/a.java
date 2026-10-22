package com.bytedance.applet.aibridge.datepicker;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.applet.aibridge.datepicker.picker.reels.views.OReelPickerMulti;
import com.bytedance.applet.aibridge.datepicker.picker.reels.views.WheelView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonObject;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import hv3.f;
import hv3.g;
import hv3.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kv3.e;
import l3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static volatile c a;

    /* JADX INFO: renamed from: com.bytedance.applet.aibridge.datepicker.a$a, reason: collision with other inner class name */
    public static final class C0046a {
        public final long a;
        public final List<String> b;
        public final int c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof C0046a) == true) goto L8;
            return false;
        L8:
            C0046a r9 = (C0046a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c;
        }

        public final String toString() {
            return "PendingCol(token=" + this.a + ", entries=" + this.b + ", selectedIndex=" + this.c + ')';
        }

        public C0046a(long r2, List<String> r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "entries");
            this.a = r2;
            this.b = r4;
            this.c = r5;
        }
    }

    public static final class b {
        public final long a;
        public final List<List<String>> b;
        public final int[] c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + Arrays.hashCode(this.c);
        }

        public final String toString() {
            return "PendingRebuild(token=" + this.a + ", columns=" + this.b + ", selectedIndices=" + Arrays.toString(this.c) + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(long r2, List<? extends List<String>> r4, int[] r5) {
            Intrinsics.checkNotNullParameter(r4, "columns");
            Intrinsics.checkNotNullParameter(r5, "selectedIndices");
            this.a = r2;
            this.b = r4;
            this.c = r5;
        }
    }

    public static final class c {
        public final int a;
        public final int b;
        public List<? extends List<String>> c;
        public int[] d;
        public long e;
        public boolean[] f;
        public boolean[] g;
        public int[] h;
        public final Map<Integer, C0046a> i;
        public b j;
        public long k;
        public List<WheelView> l;
        public final Map<Integer, Runnable> m;
        public final int n;
        public final long o;
        public final WeakReference<Activity> p;
        public com.bytedance.applet.aibridge.datepicker.b q;
        public boolean r;
        public final WeakReference<AppCompatDialog> s;
        public final WeakReference<FrameLayout> t;

        /* JADX INFO: renamed from: com.bytedance.applet.aibridge.datepicker.a$c$a, reason: collision with other inner class name */
        public static final class C0047a implements e {
            public final /* synthetic */ c a;
            public final /* synthetic */ int b;

            @Override // kv3.e
            public final void a(int r11) {
                c r0 = this.a;
                boolean[] r1 = r0.f;
                int r2 = this.b;
                r1[r2] = false;
                C0046a r3 = r0.i.remove(Integer.valueOf(r2));
                if (r3 != null) goto L5;
            L22:
                boolean r4 = false;
            L23:
                if (r4 == false) goto L27;
                this.a.f();
                return;
            L27:
                if (Intrinsics.areEqual(ArraysKt.getOrNull(this.a.g, this.b), Boolean.TRUE) == false) goto L30;
                c r12 = this.a;
                r12.g[this.b] = false;
                r12.f();
                return;
            L30:
                this.a.d(this.b);
                this.a.e(this.b, r11, true);
                this.a.f();
                return;
            L5:
                if (r3.a != r0.k) goto L7;
                boolean r5 = true;
            L8:
                if (r5 == true) goto L11;
                r3 = null;
            L11:
                if (r3 == null) goto L22;
                r0.a(r2, r3.b, r3.c);
                List<? extends List<String>> r6 = CollectionsKt.toMutableList(r0.c);
                if (r2 >= 0) goto L16;
            L18:
                boolean r7 = false;
            L19:
                if (r7 == false) goto L21;
                ListProtector.set(r6, r2, r3.b);
            L21:
                r0.c = r6;
                r4 = true;
                goto L23
            L16:
                if (r2 >= r6.size()) goto L18;
                r7 = true;
                goto L19
            L7:
                r5 = false;
                goto L8
            }

            @Override // kv3.e
            public final void onChanged(final int r6) {
                Boolean r0 = ArraysKt.getOrNull(this.a.g, this.b);
                Boolean r1 = Boolean.TRUE;
                if (Intrinsics.areEqual(r0, r1) == false) goto L5;
                this.a.g[this.b] = false;
            L5:
                final c r2 = this.a;
                boolean[] r3 = r2.f;
                final int r4 = this.b;
                r3[r4] = true;
                if (Intrinsics.areEqual(ArraysKt.getOrNull(r2.g, r4), r1) == true) goto L18;
                Runnable r5 = r2.m.remove(Integer.valueOf(r4));
                if (r5 == null) goto L13;
                FrameLayout r7 = r2.t.get();
                if (r7 == null) goto L13;
                r7.removeCallbacks(r5);
            L13:
                Runnable r8 = new g(r2, r4, r6);
                Integer r9 = Integer.valueOf(r4);
                r2.m.put(r9, r8);
                FrameLayout r10 = r2.t.get();
                if (r10 == null) goto L17;
                r10.postDelayed(r8, r2.o);
                return;
            L17:
                return;
            }

            public C0047a(c r1, int r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public final void c() {
            Iterator<T> r0 = this.m.values().iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            Runnable r1 = (Runnable) r0.next();
            FrameLayout r2 = this.t.get();
            if (r2 == null) goto L4;
            r2.removeCallbacks(r1);
            goto L4
        L8:
            this.m.clear();
        }

        public final void f() {
            b r0 = this.j;
            if (r0 == null) goto L47;
            boolean r5 = true;
            if (r0.a != this.k) goto L7;
            boolean r1 = true;
        L8:
            ViewGroup r2 = null;
            if (r1 == true) goto L12;
            r0 = null;
        L12:
            if (r0 == null) goto L51;
            boolean[] r3 = this.f;
            int r4 = r3.length;
            int r6 = 0;
        L15:
            if (r6 >= r4) goto L20;
            if (r3[r6] == true) goto L21;
            r6 = r6 + 1;
        L21:
            if (r5 == false) goto L23;
            return;
        L23:
            this.j = null;
            List<List<String>> r7 = r0.b;
            this.c = r7;
            int[] r8 = r0.c;
            this.d = r8;
            c();
            ((LinkedHashMap) this.i).clear();
            this.j = null;
            this.f = new boolean[r7.size()];
            this.g = new boolean[r7.size()];
            int r9 = r7.size();
            int[] r10 = new int[r9];
            int r11 = 0;
        L25:
            if (r11 >= r9) goto L27;
            r10[r11] = -1;
            r11 = r11 + 1;
            goto L25
        L27:
            this.h = r10;
            int r12 = r7.size();
            ArrayList r13 = new ArrayList(r12);
            int r14 = 0;
        L28:
            if (r14 >= r12) goto L30;
            r13.add(null);
            r14 = r14 + 1;
            goto L28
        L30:
            this.l = r13;
            FrameLayout r15 = this.t.get();
            if (r15 == null) goto L48;
            final View r16 = r15.getChildAt(0);
            View r17 = b(r7, r8);
            if (r17 == null) goto L49;
            ViewParent r18 = r17.getParent();
            if ((r18 instanceof ViewGroup) == false) goto L37;
            r2 = (ViewGroup) r18;
        L37:
            if (r2 == null) goto L39;
            r2.removeView(r17);
        L39:
            r17.setAlpha(0.0f);
            r15.addView(r17, new FrameLayout.LayoutParams(-1, -2, 17));
            r17.animate().alpha(1.0f).setDuration(120).start();
            if (r16 == null) goto L50;
            r16.animate().alpha(0.0f).setDuration(120).withEndAction(new h(r16)).start();
            return;
        L50:
            return;
        L49:
            return;
        L48:
            return;
        L20:
            r5 = false;
            goto L21
        L51:
            return;
        L7:
            r1 = false;
            goto L8
        }

        public final void d(int r2) {
            Runnable r3 = this.m.remove(Integer.valueOf(r2));
            if (r3 != null) goto L5;
            return;
        L5:
            FrameLayout r0 = this.t.get();
            if (r0 == null) goto L9;
            r0.removeCallbacks(r3);
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r15v2, types: [android.view.View, com.bytedance.applet.aibridge.datepicker.picker.reels.views.OReelPickerMulti] */
        public final View b(List<? extends List<String>> r14, int[] r15) {
            AppCompatDialog r0 = this.s.get();
            ViewGroup r1 = 0;
            if (r0 == null) goto L39;
            OReelPickerMulti.a r2 = new OReelPickerMulti.a();
            Iterator<T> r3 = r14.iterator();
            int r4 = 0;
            int r5 = 0;
        L6:
            if (r3.hasNext() == false) goto L15;
            Object r6 = r3.next();
            int r7 = r5 + 1;
            if (r5 >= 0) goto L10;
            CollectionsKt.throwIndexOverflow();
        L10:
            List r8 = (List) r6;
            int r9 = this.n + r5;
            Resources r11 = Resources.getSystem();
            Integer r10 = Integer.valueOf(MathKt.roundToInt(TypedValue.applyDimension(1, 72, WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics()))));
            Integer r12 = ArraysKt.getOrNull(r15, r5);
            if (r12 == null) goto L13;
            int r13 = r12.intValue();
        L14:
            iv3.a r16 = new iv3.a(r9, r8, r10, r13);
            Intrinsics.checkNotNullParameter(r16, "reel");
            ((ArrayList) r2.a).add(r16);
            r5 = r7;
            goto L6
        L13:
            r13 = r8.size() / 2;
            goto L14
        L15:
            ?? r17 = r2.a(r0.getContext(), null, 0);
            IntIterator r18 = CollectionsKt.getIndices(r14).iterator();
        L17:
            if (r18.hasNext() == false) goto L23;
            int r19 = r18.nextInt();
            List<WheelView> r20 = CollectionsKt.toMutableList(this.l);
            WheelView r21 = r17.R5(r19);
            if (r21 == null) goto L21;
            r21.setSelectedTextColor(this.a);
            r21.setNormalTextColor(this.b);
            Unit r22 = Unit.INSTANCE;
        L22:
            ListProtector.set(r20, r19, r21);
            this.l = r20;
            goto L17
        L21:
            r21 = null;
            goto L22
        L23:
            Iterator<T> r110 = this.l.iterator();
        L25:
            if (r110.hasNext() == false) goto L33;
            Object r23 = r110.next();
            int r24 = r4 + 1;
            if (r4 >= 0) goto L29;
            CollectionsKt.throwIndexOverflow();
        L29:
            WheelView r25 = (WheelView) r23;
            if (r25 == null) goto L32;
            r25.setOnWheelChangedListener(new C0047a(this, r4));
        L32:
            r4 = r24;
            goto L25
        L33:
            ViewParent r111 = r17.getParent();
            if ((r111 instanceof ViewGroup) == false) goto L36;
            r1 = (ViewGroup) r111;
        L36:
            if (r1 == 0) goto L38;
            r1.removeView(r17);
        L38:
            return r17;
        L39:
            return null;
        }

        public final void a(int r4, List<String> r5, int r6) {
            final WheelView r0 = (WheelView) CollectionsKt.getOrNull(this.l, r4);
            if (r0 != null) goto L5;
            return;
        L5:
            this.g[r4] = true;
            d(r4);
            r0.setEntries(r5);
            final int r7 = RangesKt.coerceIn(r6, 0, RangesKt.coerceAtLeast(r5.size() - 1, 0));
            r0.post(new f(this, r0, r7));
        }

        public final void e(int r5, int r6, boolean r7) {
            Integer r0 = ArraysKt.getOrNull(this.h, r5);
            if (r0 != null) goto L6;
        L9:
            if (r5 >= 0) goto L11;
        L13:
            boolean r1 = false;
        L14:
            if (r1 == false) goto L16;
            this.h[r5] = r6;
        L16:
            this.e++;
            Lazy r2 = d.a;
            JsonObject r3 = new JsonObject();
            r3.addProperty("column", Integer.valueOf(r5));
            r3.addProperty("selectedIndex", Integer.valueOf(r6));
            r3.addProperty("isFinal", Boolean.valueOf(r7));
            r3.addProperty("version", Long.valueOf(this.e));
            Unit r8 = Unit.INSTANCE;
            d.c(new l3.a("applet.onCustomPickerOptionChanged", r3, 4));
            return;
        L11:
            if (r5 >= this.h.length) goto L13;
            r1 = true;
            goto L14
        L6:
            if (r0.intValue() != r6) goto L9;
            if (r7 == true) goto L9;
        }

        public c(AppCompatDialog r5, Context r6, FrameLayout r7, int r8, int r9, List<? extends List<String>> r10, int[] r11) {
            Intrinsics.checkNotNullParameter(r5, "dialog");
            Intrinsics.checkNotNullParameter(r6, "ctx");
            Intrinsics.checkNotNullParameter(r7, "contentContainer");
            Intrinsics.checkNotNullParameter(r10, "columns");
            Intrinsics.checkNotNullParameter(r11, "selectedIndices");
            this.a = r8;
            this.b = r9;
            this.c = r10;
            this.d = r11;
            this.f = new boolean[r10.size()];
            this.g = new boolean[r10.size()];
            int r12 = r10.size();
            int[] r13 = new int[r12];
            int r0 = 0;
            int r1 = 0;
        L4:
            if (r1 >= r12) goto L6;
            r13[r1] = -1;
            r1 = r1 + 1;
            goto L4
        L6:
            this.h = r13;
            this.i = new LinkedHashMap();
            int r14 = r10.size();
            ArrayList r15 = new ArrayList(r14);
            int r2 = 0;
        L8:
            if (r2 >= r14) goto L10;
            r15.add(null);
            r2 = r2 + 1;
            goto L8
        L10:
            this.l = r15;
            this.m = new LinkedHashMap();
            this.n = 9000;
            this.o = 80;
            this.p = new WeakReference((Activity) r6);
            this.s = new WeakReference(r5);
            this.t = new WeakReference(r7);
            c();
            ((LinkedHashMap) this.i).clear();
            this.j = null;
            this.f = new boolean[r10.size()];
            this.g = new boolean[r10.size()];
            int r16 = r10.size();
            int[] r17 = new int[r16];
            int r18 = 0;
        L11:
            if (r18 >= r16) goto L13;
            r17[r18] = -1;
            r18 = r18 + 1;
            goto L11
        L13:
            this.h = r17;
            int r19 = r10.size();
            ArrayList r20 = new ArrayList(r19);
        L14:
            if (r0 >= r19) goto L16;
            r20.add(null);
            r0 = r0 + 1;
            goto L14
        L16:
            this.l = r20;
            FrameLayout r21 = this.t.get();
            if (r21 == null) goto L19;
            r21.removeAllViews();
        L19:
            View r22 = b(r10, r11);
            if (r22 == null) goto L25;
            FrameLayout r23 = this.t.get();
            if (r23 == null) goto L25;
            r23.addView(r22, new FrameLayout.LayoutParams(-1, -2, 17));
        L25:
            if (this.p.get() == null) goto L33;
            com.bytedance.applet.aibridge.datepicker.b r24 = new com.bytedance.applet.aibridge.datepicker.b(this);
            this.q = r24;
            AppHost.a.a().e(r24);
            return;
        }
    }

    static {
    }

    public static c b() {
        c r0 = a;
        if (r0 != null) goto L5;
        return null;
    L5:
        AppCompatDialog r2 = r0.s.get();
        if (r2 == null) goto L10;
        boolean r3 = true;
        if (r2.isShowing() != true) goto L10;
    L11:
        if (r3 == false) goto L13;
        return r0;
    L13:
        a(r0);
        return null;
    L10:
        r3 = false;
        goto L11
    }

    public static void a(c r3) {
        Intrinsics.checkNotNullParameter(r3, "session");
        if (a != r3) goto L12;
        a = null;
        if (r3.r == true) goto L13;
        r3.r = true;
        r3.c();
        com.bytedance.applet.aibridge.datepicker.b r1 = r3.q;
        if (r1 == null) goto L10;
        AppHost.a.a().f(r1);
    L10:
        r3.q = null;
        return;
    L13:
        return;
    }
}
