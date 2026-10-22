package com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode;

import android.view.View;
import com.bytedance.android.shopping.anchorv3.detail.widget.ECAnchorHeaderFrameLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AnchorV4SmallTransition {
    public final List<com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a> a;
    public final List<com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a> b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public final Lazy i;
    public float j;
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.a k;

    public static final class a implements Runnable {
        public final /* synthetic */ AnchorV4SmallTransition a;
        public final /* synthetic */ boolean b;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(AnchorV4SmallTransition r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final int b() {
        return ((Number) this.i.getValue()).intValue();
    }

    public final List<View> a() {
        return this.k.getContainers();
    }

    public AnchorV4SmallTransition(com.bytedance.android.shopping.anchorv4.voavhs.head.smallmode.a r2) {
        Intrinsics.checkNotNullParameter(r2, "transformViewPager");
        this.k = r2;
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.i = LazyKt.lazy(AnchorV4SmallTransition$mScreenWidth$2.INSTANCE);
        this.j = -1.0f;
    }

    public final void c(boolean r6) {
        List<com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a> r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        this.k.d(new a(this, r6));
        return;
    L12:
        this.k.b();
        ECAnchorHeaderFrameLayout r3 = this.k.f();
        if (r3 == null) goto L35;
        if (r6 == false) goto L16;
        int r7 = this.h;
    L17:
        r3.setFixedWidth(Integer.valueOf(r7));
        if (this.k.e() == false) goto L24;
        int r8 = this.k.a();
        com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a r4 = (com.bytedance.android.shopping.anchorv3.detail.widget.transwidget.a) ListProtector.get(this.a, r8);
        if ((r4.a + r4.c) <= b()) goto L22;
        float r5 = (r4.a + r4.c) - b();
    L23:
        this.c = (int) r5;
    L32:
        this.d = r8 * b();
        return;
    L22:
        r5 = 0.0f;
        goto L23
    L24:
        int r9 = this.k.h().getScrollX();
        Iterator<T> r10 = a().iterator();
        int r11 = 0;
    L26:
        if (r10.hasNext() == false) goto L31;
        if (r9 <= ((View) r10.next()).getX()) goto L29;
        r11 = r11 + 1;
        goto L26
    L29:
        r1 = r11;
    L31:
        this.c = this.k.h().getScrollX();
        r8 = r1;
        goto L32
    L16:
        r7 = this.e;
        goto L17
    L35:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv3.detail.widget.ECAnchorHeaderFrameLayout");
    L5:
        if (((ArrayList) r0).isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }
}
