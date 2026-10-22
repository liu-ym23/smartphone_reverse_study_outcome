package a08;

import android.content.Context;
import android.content.res.Resources;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel4;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.SortedMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static final SortedMap<Integer, a> a = null;

    public static final class a {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        /* JADX INFO: renamed from: a08.b$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0000a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ZoomLevel6.values().length];
                r0[ZoomLevel6.SMALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r0[ZoomLevel6.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r0[ZoomLevel6.LARGE1.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r0[ZoomLevel6.LARGE2.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r0[ZoomLevel6.LARGE3.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r0[ZoomLevel6.LARGE4.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                a = r0;
            }
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return (((((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f;
        }

        public final String toString() {
            return "LarkFontConfig(small=" + this.a + ", normal=" + this.b + ", large1=" + this.c + ", large2=" + this.d + ", large3=" + this.e + ", large4=" + this.f + ')';
        }

        public final int a(ZoomLevel4 r2) {
            Intrinsics.checkNotNullParameter(r2, "zoomLevel");
            ZoomLevel6 r3 = zz7.b.d();
            switch(C0000a.a[r3.ordinal()]) {
                case 1: goto L10;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L11;
                default: goto L5;
            };
        L5:
            throw new NoWhenBranchMatchedException();
        L11:
            return this.d;
        L12:
            return this.c;
        L13:
            return this.b;
        L10:
            return this.a;
        }

        public final int b(ZoomLevel6 r2) {
            Intrinsics.checkNotNullParameter(r2, "zoomLevel");
            switch(C0000a.a[r2.ordinal()]) {
                case 1: goto L12;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                default: goto L5;
            };
        L5:
            throw new NoWhenBranchMatchedException();
        L13:
            return this.f;
        L14:
            return this.e;
        L15:
            return this.d;
        L16:
            return this.c;
        L17:
            return this.b;
        L12:
            return this.a;
        }

        public a(int r1, int r2, int r3, int r4, int r5, int r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    static {
        a r0 = new a(24, 26, 28, 30, 34, 40);
        a r1 = new a(22, 24, 26, 28, 32, 36);
        a r9 = new a(18, 20, 22, 24, 28, 32);
        a r2 = new a(16, 17, 18, 20, 24, 28);
        a r3 = new a(15, 16, 17, 18, 20, 24);
        a r4 = new a(13, 14, 15, 16, 18, 20);
        a r5 = new a(11, 12, 13, 14, 15, 16);
        a r6 = new a(9, 10, 11, 12, 13, 14);
        LinkedHashMap r7 = new LinkedHashMap();
        insert(r7, r0);
        insert(r7, r1);
        insert(r7, r9);
        insert(r7, r2);
        insert(r7, r3);
        insert(r7, r4);
        insert(r7, r5);
        insert(r7, r6);
        a = MapsKt.toSortedMap(r7);
    }

    @JvmStatic
    public static final float a(float r8, Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        if (yz7.a.b == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
        return r8;
    L10:
        ZoomLevel6 r2 = zz7.b.d();
        ZoomLevel6 r4 = ZoomLevel6.NORMAL;
        if (r2 != r4) goto L13;
        return r8;
    L13:
        Intrinsics.checkNotNullParameter(r9, "context");
        Resources r10 = r9.getResources();
        int r11 = MathKt.roundToInt((r8 / WindowDisplayMetricsOverride.apply(r10, r10.getDisplayMetrics()).density) + 0.5f);
        if (r2 != r4) goto L16;
        float r12 = r4.getMultiplier();
    L48:
        return r8 * r12;
    L16:
        SortedMap<Integer, a> r0 = a;
        a r5 = r0.get(Integer.valueOf(r11));
        if (r5 == null) goto L19;
        int r3 = r5.b(r2);
    L46:
        r12 = r3 / r11;
        goto L48
    L19:
        Iterator<T> r6 = r0.values().iterator();
        Object r7 = null;
        Object r13 = null;
    L21:
        if (r6.hasNext() == false) goto L28;
        Object r14 = r6.next();
        if (((a) r14).b >= r11) goto L25;
        boolean r15 = true;
    L26:
        if (r15 == false) goto L21;
        r13 = r14;
        goto L21
    L25:
        r15 = false;
        goto L26
    L28:
        a r16 = (a) r13;
        Iterator<T> r17 = a.values().iterator();
    L30:
        if (r17.hasNext() == false) goto L37;
        Object r19 = r17.next();
        if (((a) r19).b <= r11) goto L34;
        boolean r20 = true;
    L35:
        if (r20 == false) goto L30;
        r7 = r19;
        goto L37
    L34:
        r20 = false;
    L37:
        a r21 = (a) r7;
        if (r16 == null) goto L41;
        if (r21 == null) goto L41;
        r3 = MathKt.roundToInt((((r16.b(r2) / r16.b) + (r21.b(r2) / r21.b)) / 2.0f) * r11);
    L41:
        if (r16 == null) goto L43;
        r3 = MathKt.roundToInt((r16.b(r2) / r16.b) * r11);
        goto L46
    L43:
        if (r21 == null) goto L45;
        r3 = MathKt.roundToInt((r21.b(r2) / r21.b) * r11);
        goto L46
    L45:
        r3 = r11;
        goto L46
    L5:
        if (yz7.a.a == false) goto L7;
        r1 = true;
        goto L8
    }

    @JvmStatic
    public static final int b(int r1, Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return MathKt.roundToInt(a(r1, r2));
    }

    @JvmStatic
    public static final void insert(HashMap<Integer, a> r1, a r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "config");
        r1.put(Integer.valueOf(r2.b), r2);
    }
}
