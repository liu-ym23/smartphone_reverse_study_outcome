package com.bytedance.android.shopping.new_cart.manager;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.CartSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.android.shopping.new_cart.widgets.j;
import com.bytedance.android.shopping.new_cart.widgets.nest.CartLinkedScrollViewV2;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements com.bytedance.android.shopping.new_cart.manager.b.a {
    public int a;
    public com.bytedance.android.shopping.new_cart.manager.b b;
    public final Lazy c;
    public final CartObjectContainer d;
    public final RecyclerView e;
    public final View f;
    public final j g;
    public final int h;
    public final CartViewModel i;

    public static final class a implements Runnable {
        public final /* synthetic */ c a;
        public final /* synthetic */ View b;

        public a(c r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c r0 = this.a;     // Catch: Throwable -> L8
            com.bytedance.android.shopping.new_cart.manager.b r4 = new com.bytedance.android.shopping.new_cart.manager.b(this.b, r0, Boolean.TRUE, r0.h);     // Catch: Throwable -> L5
        L6:
            r0.b = r4;     // Catch: Throwable -> L8
            return;
        L5:
            r4 = null;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final void a() {
            CartSliceCustomWidgetAdapterComponent r0 = (CartSliceCustomWidgetAdapterComponent) this.a.c.getValue();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.d != true) goto L15;
            com.bytedance.android.shopping.new_cart.yata.customdata.a r1 = this.a.i.getCustomDataCenter();
            if (r1 == null) goto L9;
            r1.c(Boolean.FALSE);
        L9:
            CartSliceCustomWidgetAdapterComponent r2 = (CartSliceCustomWidgetAdapterComponent) this.a.c.getValue();
            if (r2 == null) goto L12;
            r2.d = false;
        L12:
            ((AndroidYaTaInstance) this.a.d.e.d.invoke()).x(null, aa6.a.a.b, null, null);
            return;
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

    /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.manager.c$c, reason: collision with other inner class name */
    public static final class RunnableC0124c implements Runnable {
        public final /* synthetic */ c a;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.manager.c$c$a */
        public static final class a implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ RunnableC0124c c;

            public a(int r1, int r2, RunnableC0124c r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final void a() {
                if (this.c.a.e.isAttachedToWindow() == true) goto L5;
                return;
            L5:
                c r0 = this.c.a;
                int r1 = this.a;
                RecyclerView.Adapter r2 = r0.e.getAdapter();
                if (r2 == null) goto L13;
                int r3 = r2.getItemCount();
                if (r1 == (-1)) goto L13;
                if (r1 < 0) goto L13;
                if (r3 <= r1) goto L13;
                boolean r4 = true;
            L14:
                if (r4 == true) goto L16;
                return;
            L16:
                int r5 = this.c.a.e.getHeight();
                int[] r6 = new int[2];
                this.c.a.e.getLocationOnScreen(r6);
                int r7 = r6[1] + r5;
                Rect r8 = new Rect();
                this.c.a.e.getWindowVisibleDisplayFrame(r8);
                int r9 = RangesKt.coerceAtLeast((r5 - RangesKt.coerceAtLeast(r7 - r8.bottom, 0)) - this.b, 0);
                RecyclerView.LayoutManager r10 = this.c.a.e.getLayoutManager();
                if ((r10 instanceof LinearLayoutManager) == true) goto L19;
                r10 = null;
            L19:
                LinearLayoutManager r11 = (LinearLayoutManager) r10;
                if (r11 == null) goto L23;
                r11.scrollToPositionWithOffset(this.a, r9);
                return;
            L23:
                return;
            L13:
                r4 = false;
                goto L14
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

        public RunnableC0124c(c r1) {
            this.a = r1;
        }

        public final void a() {
            j r0 = this.a.g;
            if (r0 == null) goto L5;
            r0.c();
        L5:
            Iterator r1 = com.bytedance.commerce.base.view.b.a(this.a.e).iterator();
        L7:
            if (r1.hasNext() == false) goto L11;
            Object r2 = r1.next();
            if (((View) r2).hasFocus() == false) goto L7;
        L12:
            View r3 = (View) r2;
            if (r3 == null) goto L32;
            int r4 = this.a.e.getChildAdapterPosition(r3);
            RecyclerView.Adapter r5 = this.a.e.getAdapter();
            if (r5 == null) goto L22;
            int r6 = r5.getItemCount();
            if (r4 == (-1)) goto L22;
            if (r4 < 0) goto L22;
            if (r6 <= r4) goto L22;
            boolean r7 = true;
        L23:
            if (r7 == false) goto L33;
            c r8 = this.a;
            if (r8.a <= 0) goto L27;
            int r9 = r3.getHeight();
            this.a.e.post(new a(r4, r9, this));
            return;
        L27:
            r8.e.scrollToPosition(r4);
            return;
        L33:
            return;
        L22:
            r7 = false;
            goto L23
        L32:
            return;
        L11:
            r2 = null;
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

    @Override // com.bytedance.android.shopping.new_cart.manager.b.a
    public final void a() {
        this.f.setVisibility(0);
        j r0 = this.g;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        this.e.post(new b(this));
    }

    public final void c() {
        com.bytedance.android.shopping.new_cart.manager.b r0 = this.b;
        if (r0 == null) goto L8;
        View r1 = r0.a;
        if (r1 == null) goto L9;
        r1.getViewTreeObserver().addOnGlobalLayoutListener(r0.f);
        return;
    L9:
        return;
    }

    public final void d() {
        com.bytedance.android.shopping.new_cart.manager.b r0 = this.b;
        if (r0 == null) goto L8;
        View r1 = r0.a;
        if (r1 == null) goto L9;
        r1.getViewTreeObserver().removeOnGlobalLayoutListener(r0.f);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.new_cart.manager.b.a
    public final void z() {
        this.f.setVisibility(8);
        com.bytedance.android.shopping.new_cart.utils.a.c.d("onKeyboardShow", new RunnableC0124c(this));
    }

    public final void b(View r3) {
        Intrinsics.checkNotNullParameter(r3, "rootView");
        com.bytedance.android.shopping.new_cart.utils.a.c.d("bindWidget", new a(this, r3));
    }

    public c(CartObjectContainer r2, RecyclerView r3, View r4, CartLinkedScrollViewV2 r5, int r6, int r7) {
        if ((r7 & 16) == 0) goto L6;
        r6 = 0;
    L6:
        if ((r7 & 32) == 0) goto L8;
        CartViewModel r8 = r2.d;
    L9:
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        Intrinsics.checkNotNullParameter(r3, "bodyWidget");
        Intrinsics.checkNotNullParameter(r4, "footerWidget");
        Intrinsics.checkNotNullParameter(r8, "cartVM");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r8;
        this.c = LazyKt.lazy(new KeyboardManager$sliceCustomWidgetAdapterComponent$2(this));
        return;
    L8:
        r8 = null;
        goto L9
    }
}
