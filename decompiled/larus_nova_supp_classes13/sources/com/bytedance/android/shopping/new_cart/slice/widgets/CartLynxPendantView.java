package com.bytedance.android.shopping.new_cart.slice.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.CartSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.new_cart.container.b0;
import com.bytedance.android.shopping.new_cart.container.s;
import com.bytedance.android.shopping.new_cart.params.CartParams;
import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/slice/widgets/CartLynxPendantView;", "Lcom/bytedance/android/ecom/arch/slice/render/widget/roundcorner/SlcRoundFrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartLynxPendantView extends SlcRoundFrameLayout {
    public ti.l c;
    public boolean d;

    public static final class a {
    }

    public static final class b implements ti.k {
        public final /* synthetic */ CartLynxPendantView a;
        public final /* synthetic */ Function0 b;
        public final /* synthetic */ String c;

        public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
            public final /* synthetic */ View a;
            public final /* synthetic */ ViewTreeObserver b;
            public final /* synthetic */ b c;

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                int r0 = this.a.getHeight();
                if (r0 > 0) goto L5;
                return;
            L5:
                if (this.b.isAlive() == false) goto L8;
                this.b.removeOnGlobalLayoutListener(this);
            L8:
                if (this.c.b != null) goto L10;
                return;
            L10:
                if (CartSettingUtils.b() == false) goto L14;
                Float r1 = ECAppInfoService.e.getCurrentFontScale();
                if (r1 == null) goto L14;
                float r2 = r1.floatValue();
            L15:
                int r3 = com.bytedance.android.shopping.new_cart.utils.c.a;
                CartSliceCustomWidgetAdapterComponent r4 = (CartSliceCustomWidgetAdapterComponent) this.c.b.invoke();
                if (r4 == null) goto L24;
                CartObjectContainer r5 = r4.g;
                if (r5 == null) goto L24;
                com.bytedance.android.shopping.new_cart.container.b r6 = r5.e;
                if (r6 == null) goto L24;
                CartParams r7 = r6.c;
                if (r7 == null) goto L24;
                String r8 = r7.getSplitActivityScene();
            L25:
                boolean r9 = com.bytedance.android.shopping.new_cart.utils.c.a(r8);
                int r10 = s.a;
                float r11 = s.a(Boolean.valueOf(r9)).a;
                int r12 = (int) ((60 * r2) * r11);
                if (com.bytedance.android.shopping.extensions.k.c(this.c.c) == false) goto L34;
                int r13 = (int) (12 * r11);
                CartSliceCustomWidgetAdapterComponent r14 = (CartSliceCustomWidgetAdapterComponent) this.c.b.invoke();
                if (r14 == null) goto L44;
                b0 r15 = r14.f;
                if (r15 == null) goto L45;
                Function1<Integer, Unit> r16 = r15.e;
                if (r16 == null) goto L46;
                Unit r17 = (Unit) r16.invoke(Integer.valueOf((r12 + r13) + r0));
                return;
            L46:
                return;
            L45:
                return;
            L44:
                return;
            L34:
                CartSliceCustomWidgetAdapterComponent r18 = (CartSliceCustomWidgetAdapterComponent) this.c.b.invoke();
                if (r18 == null) goto L48;
                b0 r19 = r18.f;
                if (r19 == null) goto L49;
                Function1<Integer, Unit> r20 = r19.e;
                if (r20 == null) goto L50;
                Unit r21 = (Unit) r20.invoke(Integer.valueOf(r12));
                return;
            L50:
                return;
            L49:
                return;
            L48:
                return;
            L24:
                r8 = null;
            L14:
                r2 = 1.0f;
                goto L15
            }

            public a(View r1, ViewTreeObserver r2, b r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.slice.widgets.CartLynxPendantView$b$b, reason: collision with other inner class name */
        public static final class RunnableC0128b implements Runnable {
            public final /* synthetic */ b a;

            public RunnableC0128b(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.requestLayout();     // Catch: Throwable -> L4
                this.a.a.invalidate();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final void b() {
            Intrinsics.checkNotNullParameter("", "errorMessage");
            Intrinsics.checkNotNullParameter("", "errorMessage");
        }

        public final void onFirstScreen(View r2) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            Intrinsics.checkNotNullParameter(r2, "lynxView");
        }

        public final void onLoadSuccess(View r3) {
            Intrinsics.checkNotNullParameter(r3, "lynxView");
            this.a.post(new RunnableC0128b(this));
            ti.l r4 = this.a.c;
            if (r4 == null) goto L8;
            View r5 = r4.getHybridView();
            if (r5 == null) goto L9;
            ViewTreeObserver r0 = r5.getViewTreeObserver();
            r0.addOnGlobalLayoutListener(new a(r5, r0, this));
            return;
        L9:
            return;
        }

        public final void onRuntimeReady(View r2) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            Intrinsics.checkNotNullParameter(r2, "lynxView");
        }

        public final void g(View r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
            Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
        }

        public final void onLoadFailed(View r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            CartLynxPendantView.b(this.a, "onLoadFailed", r3);
        }

        public final void onPageStart(View r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "lynxView");
            Intrinsics.checkNotNullParameter(r1, "lynxView");
        }

        public b(CartLynxPendantView r1, Function0 r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void s(View r1, String r2, String r3) {
            Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
            Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
            CartLynxPendantView.b(this.a, "onReceivedError", r3);
        }
    }

    static {
    }

    public CartLynxPendantView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CartLynxPendantView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void requestLayout() {
        if (this.d == true) goto L6;
        super/*android.widget.FrameLayout*/.requestLayout();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
        ti.l r0 = this.c;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.c = null;
    }

    public final void d(Map<String, ? extends Object> r3) {
        if (r3 == null) goto L4;
        String r4 = com.bytedance.android.ec.hybrid.list.util.k.d(r3);
    L6:
        if (a2.b(r4) == false) goto L11;
        ti.l r0 = this.c;
        if (r0 == null) goto L12;
        r0.updateGlobalProps(MapsKt.mapOf(TuplesKt.to("pass_param", r4)));
        return;
    L12:
        return;
    L11:
        return;
    L4:
        r4 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchHoverEvent(MotionEvent r1) {
        return super/*android.widget.FrameLayout*/.dispatchHoverEvent(r1);
    }

    public final void onMeasure(int r2, int r3) {
        this.d = true;
        super.onMeasure(r2, r3);
        this.d = false;
    }

    public CartLynxPendantView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public static final void b(CartLynxPendantView r2, String r3, String r4) {
        r2.getClass();
        dm.a.a("CartLynxPendantView").a("CartLynxPendantView1 onLoadFailed errorMethod=" + r3 + ",errMsg=" + r4);
        Throwable r5 = new Throwable("errorMethod");
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        ECExceptionMonitor.f(r5, r4);
    }

    public /* synthetic */ CartLynxPendantView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(String r17, JSONObject r18, Function0<CartSliceCustomWidgetAdapterComponent> r19, Map<String, ? extends Object> r20) {
        if (r17 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        setVisibility(8);
        return;
    L12:
        String r4 = UUID.randomUUID().toString();
        HashMap r5 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        com.bytedance.android.ec.core.hybrid.utils.j.h(r4, r18);
        String r6 = UriProtector.parse(r17).buildUpon().appendQueryParameter("mega_object_id", r4).build().toString();
        removeAllViews();
        setVisibility(0);
        dm.a.a("CartLynxPendantView").a("CartLynxPendantView bind " + r6);
        ti.l r7 = this.c;
        if (r7 == null) goto L15;
        r7.release();
    L15:
        this.c = ECLiveHybridUtil.b(getContext(), r6, null, null, new b(this, r19, r17), null, null, false, null, null, false, 4076);
        dm.a.b r1 = dm.a.a("CartLynxPendantView");
        StringBuilder r2 = new StringBuilder("CartLynxPendantView bind finish: ");
        r2.append(this.c);
        r2.append(" view=");
        ti.l r8 = this.c;
        if (r8 == null) goto L18;
        View r9 = r8.getHybridView();
    L19:
        r2.append(r9);
        r1.a(r2.toString());
        d(r20);
        ti.l r10 = this.c;
        if (r10 == null) goto L25;
        View r11 = r10.getHybridView();
        if (r11 == null) goto L26;
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-1, -1);
        r12.gravity = 8388613;
        addView(r11, r12);
        return;
    L26:
        return;
    L25:
        return;
    L18:
        r9 = null;
        goto L19
    L5:
        if (r17.length() == 0) goto L8;
        r3 = false;
        goto L9
    }
}
