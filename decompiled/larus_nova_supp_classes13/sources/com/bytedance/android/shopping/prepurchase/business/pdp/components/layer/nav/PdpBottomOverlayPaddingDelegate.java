package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PdpBottomOverlayPaddingDelegate {
    public final LinkedHashMap<String, Integer> a;
    public final IdentityHashMap<View, a> b;
    public final Function0<View> c;
    public final Function0<List<View>> d;

    public static final class a {
        public static final /* synthetic */ int f = 0;
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.PdpBottomOverlayPaddingDelegate$a$a, reason: collision with other inner class name */
        public static final class C0158a {
            public static a a(View r7) {
                Intrinsics.checkNotNullParameter(r7, FreqActions.ACTION_VIEW);
                int r2 = r7.getPaddingLeft();
                int r3 = r7.getPaddingTop();
                int r4 = r7.getPaddingRight();
                int r5 = r7.getPaddingBottom();
                ViewGroup.LayoutParams r8 = r7.getLayoutParams();
                if ((r8 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
                r8 = null;
            L5:
                ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
                if (r9 == null) goto L8;
                int r6 = r9.bottomMargin;
            L10:
                return new a(r2, r3, r4, r5, r6);
            L8:
                r6 = 0;
                goto L10
            }
        }

        static {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L16;
            a r4 = (a) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L14;
            return false;
        L14:
            if (this.e == r4.e) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            return (((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e;
        }

        public final String toString() {
            return "InitialState(paddingLeft=" + this.a + ", paddingTop=" + this.b + ", paddingRight=" + this.c + ", paddingBottom=" + this.d + ", marginBottom=" + this.e + ")";
        }

        public a(int r1, int r2, int r3, int r4, int r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public final void a() {
        int r0 = CollectionsKt.sumOfInt(this.a.values());
        View r1 = (View) this.c.invoke();
        if (r1 == null) goto L8;
        IdentityHashMap<View, a> r2 = this.b;
        a r3 = r2.get(r1);
        if (r3 != null) goto L7;
        int r4 = a.f;
        r3 = a.C0158a.a(r1);
        r2.put(r1, r3);
    L7:
        a r5 = r3;
        r1.setPadding(r5.a, r5.b, r5.c, r5.d + r0);
    L8:
        Iterator r6 = ((Iterable) this.d.invoke()).iterator();
    L10:
        if (r6.hasNext() == false) goto L21;
        View r7 = (View) r6.next();
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == true) goto L14;
        r8 = null;
    L14:
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
        if (r9 == null) goto L10;
        IdentityHashMap<View, a> r10 = this.b;
        a r11 = r10.get(r7);
        if (r11 != null) goto L20;
        int r12 = a.f;
        r11 = a.C0158a.a(r7);
        r10.put(r7, r11);
    L20:
        r9.bottomMargin = r11.e + r0;
        r7.setLayoutParams(r9);
        goto L10
    }

    public /* synthetic */ PdpBottomOverlayPaddingDelegate(Function0 r2) {
        this(r2, AnonymousClass1.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PdpBottomOverlayPaddingDelegate(Function0<? extends View> r2, Function0<? extends List<? extends View>> r3) {
        Intrinsics.checkNotNullParameter(r2, "paddingTargetProvider");
        Intrinsics.checkNotNullParameter(r3, "marginTargetProvider");
        this.c = r2;
        this.d = r3;
        this.a = new LinkedHashMap();
        this.b = new IdentityHashMap();
    }

    public final void b(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        if (r3 > 0) goto L6;
        Intrinsics.checkNotNullParameter(r2, "source");
        this.a.remove(r2);
        a();
        return;
    L6:
        this.a.put(r2, Integer.valueOf(r3));
        a();
    }
}
