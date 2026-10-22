package ki3;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.scroll.SlcScrollElementView;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends SlcScrollElementView {
    public float f;
    public int g;
    public boolean h;
    public Map<String, ? extends Object> i;
    public View j;
    public int k;
    public float l;

    /* JADX INFO: renamed from: ki3.a$a, reason: collision with other inner class name */
    public static final class RunnableC0213a implements Runnable {
        public final /* synthetic */ a a;

        public RunnableC0213a(a r1) {
            this.a = r1;
        }

        public final void a() {
            if (this.a.getChildCount() <= 0) goto L15;
            Iterator r0 = com.bytedance.commerce.base.view.b.a((View) ListProtector.get(com.bytedance.commerce.base.view.b.a(this.a), 0)).iterator();
        L6:
            if (r0.hasNext() == false) goto L19;
            View r1 = (View) r0.next();
            BaseSlcViewManager r2 = SlcViewExtensionsKt.g(r1);
            if (r2 == null) goto L10;
            String r3 = r2.d0();
        L12:
            if (Intrinsics.areEqual(r3, "iesec_pdp_shop_recommend_v2_show_more") == false) goto L14;
            this.a.j = r1;
        L14:
            this.a.k += r1.getWidth();
            goto L6
        L10:
            r3 = null;
            goto L12
        L19:
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

    /* JADX WARN: Multi-variable type inference failed */
    private final View getCallJumpView() {
        if (this.j != null) goto L17;
        if (getChildCount() <= 0) goto L17;
        Iterator r0 = com.bytedance.commerce.base.view.b.a((View) ListProtector.get(com.bytedance.commerce.base.view.b.a(this), 0)).iterator();
    L8:
        if (r0.hasNext() == false) goto L17;
        View r1 = (View) r0.next();
        BaseSlcViewManager r2 = SlcViewExtensionsKt.g(r1);
        if (r2 == null) goto L12;
        String r3 = r2.d0();
    L14:
        if (Intrinsics.areEqual(r3, "iesec_pdp_shop_recommend_v2_show_more") == false) goto L8;
        this.j = r1;
        goto L8
    L12:
        r3 = null;
    L17:
        return this.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
        setOverScrollMode(2);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        post(new RunnableC0213a(this));
    }

    public static final /* synthetic */ View c(a r0) {
        return r0.getCallJumpView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "ev");
        int r0 = r7.getAction();
        SlcScrollElementView r2 = null;
        if (r0 != 0) goto L5;
        this.l = r7.getX();
        ViewParent r1 = getParent();
        if (r1 == null) goto L79;
        ViewParent r3 = r1.getParent();
        if (r3 == null) goto L79;
        SlcScrollElementView r4 = r3.getParent();
    L81:
        if ((r4 instanceof com.bytedance.android.shopping.slice.elements.shoprecommend.a) == false) goto L84;
        r2 = r4;
    L84:
        SlcScrollElementView r5 = (com.bytedance.android.shopping.slice.elements.shoprecommend.a) r2;
        if (r5 == null) goto L88;
        r5.requestDisallowInterceptTouchEvent(true);
    L88:
        return super/*android.widget.HorizontalScrollView*/.dispatchTouchEvent(r7);
    L79:
        r4 = null;
        goto L81
    L5:
        if (r0 == 1) goto L47;
        if (r0 != 2) goto L88;
        int r6 = getChildAt(0).getWidth() - getWidth();
        int r8 = getScrollX();
        if (1 > r8) goto L13;
        if (r6 <= r8) goto L13;
    L20:
        ViewParent r9 = getParent();
        if (r9 == null) goto L25;
        ViewParent r10 = r9.getParent();
        if (r10 == null) goto L25;
        SlcScrollElementView r11 = r10.getParent();
    L27:
        if ((r11 instanceof com.bytedance.android.shopping.slice.elements.shoprecommend.a) == false) goto L30;
        r2 = r11;
    L30:
        SlcScrollElementView r12 = (com.bytedance.android.shopping.slice.elements.shoprecommend.a) r2;
        if (r12 == null) goto L88;
        r12.requestDisallowInterceptTouchEvent(true);
    L25:
        r11 = null;
    L13:
        if (getScrollX() != 0) goto L17;
        if ((r7.getX() - this.l) < 0) goto L20;
    L17:
        if (getScrollX() >= r6) goto L19;
    L33:
        ViewParent r13 = getParent();
        if (r13 == null) goto L38;
        ViewParent r14 = r13.getParent();
        if (r14 == null) goto L38;
        SlcScrollElementView r15 = r14.getParent();
    L40:
        if ((r15 instanceof com.bytedance.android.shopping.slice.elements.shoprecommend.a) == false) goto L43;
        r2 = r15;
    L43:
        SlcScrollElementView r16 = (com.bytedance.android.shopping.slice.elements.shoprecommend.a) r2;
        if (r16 == null) goto L88;
        r16.requestDisallowInterceptTouchEvent(false);
    L38:
        r15 = null;
        goto L40
    L19:
        if ((r7.getX() - this.l) <= 0) goto L33;
    L47:
        if (getScrollX() < (getChildAt(0).getWidth() - getWidth())) goto L61;
        ViewParent r17 = getParent();
        if (r17 == null) goto L53;
        ViewParent r18 = r17.getParent();
        if (r18 == null) goto L53;
        SlcScrollElementView r19 = r18.getParent();
    L55:
        if ((r19 instanceof com.bytedance.android.shopping.slice.elements.shoprecommend.a) == false) goto L58;
        r2 = r19;
    L58:
        SlcScrollElementView r20 = (com.bytedance.android.shopping.slice.elements.shoprecommend.a) r2;
        if (r20 == null) goto L88;
        r20.requestDisallowInterceptTouchEvent(false);
    L53:
        r19 = null;
        goto L55
    L61:
        ViewParent r21 = getParent();
        if (r21 == null) goto L66;
        ViewParent r22 = r21.getParent();
        if (r22 == null) goto L66;
        SlcScrollElementView r23 = r22.getParent();
    L68:
        if ((r23 instanceof com.bytedance.android.shopping.slice.elements.shoprecommend.a) == false) goto L71;
        r2 = r23;
    L71:
        SlcScrollElementView r24 = (com.bytedance.android.shopping.slice.elements.shoprecommend.a) r2;
        if (r24 == null) goto L88;
        r24.requestDisallowInterceptTouchEvent(true);
    L66:
        r23 = null;
        goto L68
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r8) {
        if (r8 == null) goto L4;
        int r0 = r8.getAction();
        if (r0 != 1) goto L8;
    L34:
        this.f = 0.0f;
        this.h = false;
    L36:
        return super/*android.widget.HorizontalScrollView*/.onTouchEvent(r8);
    L8:
        if (r0 != 2) goto L10;
        float r1 = this.f;
        if (r1 == 0.0f) goto L27;
        int r2 = (int) (r1 - r8.getX());
        if (r2 >= 0) goto L17;
        this.g = 0;
        goto L27
    L17:
        if (r2 <= 0) goto L22;
        if (canScrollHorizontally(r2) == true) goto L22;
        this.g += r2;
    L22:
        if (this.g <= 200) goto L27;
        View r3 = getCallJumpView();
        if (r3 == null) goto L26;
        r3.post(new b(this));
    L26:
        this.g = 0;
    L27:
        this.f = r8.getX();
        if (this.h == true) goto L36;
        this.h = true;
        BaseSlcViewManager r4 = SlcViewExtensionsKt.g(this);
        if (r4 == null) goto L36;
        SlcTemplateContext r5 = r4.a;
        if (r5 == null) goto L36;
        SlcTemplateContext.e(r5, new SlcCommonAction("PDPRecommendGoodsScrollEvent", MapsKt.mapOf(TuplesKt.to("slide_params", this.i))), this, null, null, 24);
        goto L36
    L10:
        if (r0 == 6) goto L34;
    L4:
        return super/*android.widget.HorizontalScrollView*/.onTouchEvent(r8);
    }
}
