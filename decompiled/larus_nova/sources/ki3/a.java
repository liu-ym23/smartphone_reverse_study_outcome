package ki3;

import android.content.Context;
import android.util.AttributeSet;
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
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends SlcScrollElementView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f503602f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f503603g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f503604h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, ? extends Object> f503605i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f503606j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f503607k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f503608l;

    /* JADX INFO: renamed from: ki3.a$a, reason: collision with other inner class name */
    public static final class RunnableC6559a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f503609a;

        public RunnableC6559a(a r100) {
            this.f503609a = r100;
        }

        public final void a() {
            if (this.f503609a.getChildCount() <= 0) goto L15;
            Iterator<T> r100 = com.bytedance.commerce.base.view.b.a((View) ListProtector.get(com.bytedance.commerce.base.view.b.a(this.f503609a), 0)).iterator();
        L6:
            if (r100.hasNext() == false) goto L19;
            View r101 = (View) r100.next();
            BaseSlcViewManager<?> r102 = SlcViewExtensionsKt.g(r101);
            if (r102 == null) goto L10;
            String r103 = r102.d0();
        L12:
            if (Intrinsics.areEqual(r103, "iesec_pdp_shop_recommend_v2_show_more") == false) goto L14;
            this.f503609a.f503606j = r101;
        L14:
            this.f503609a.f503607k += r101.getWidth();
            goto L6
        L10:
            r103 = null;
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

    private final View getCallJumpView() {
        if (this.f503606j != null) goto L17;
        if (getChildCount() <= 0) goto L17;
        Iterator<T> r100 = com.bytedance.commerce.base.view.b.a((View) ListProtector.get(com.bytedance.commerce.base.view.b.a(this), 0)).iterator();
    L8:
        if (r100.hasNext() == false) goto L17;
        View r101 = (View) r100.next();
        BaseSlcViewManager<?> r102 = SlcViewExtensionsKt.g(r101);
        if (r102 == null) goto L12;
        String r103 = r102.d0();
    L14:
        if (Intrinsics.areEqual(r103, "iesec_pdp_shop_recommend_v2_show_more") == false) goto L8;
        this.f503606j = r101;
        goto L8
    L12:
        r103 = null;
    L17:
        return this.f503606j;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        super(r100, r101, 6, 0);
        setOverScrollMode(2);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        post(new RunnableC6559a(this));
    }

    public static final /* synthetic */ View c(a r100) {
        return r100.getCallJumpView();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getAction();
        ViewParent r102 = null;
        if (r101 != 0) goto L5;
        this.f503608l = r100.getX();
        ViewParent r103 = getParent();
        if (r103 == null) goto L79;
        ViewParent r104 = r103.getParent();
        if (r104 == null) goto L79;
        ViewParent r105 = r104.getParent();
    L81:
        if ((r105 instanceof com.bytedance.android.shopping.slice.elements.shoprecommend.a) == false) goto L84;
        r102 = r105;
    L84:
        com.bytedance.android.shopping.slice.elements.shoprecommend.a r106 = (com.bytedance.android.shopping.slice.elements.shoprecommend.a) r102;
        if (r106 == null) goto L88;
        r106.requestDisallowInterceptTouchEvent(true);
    L88:
        return super.dispatchTouchEvent(r100);
    L79:
        r105 = null;
        goto L81
    L5:
        if (r101 == 1) goto L47;
        if (r101 != 2) goto L88;
        int r107 = getChildAt(0).getWidth() - getWidth();
        int r108 = getScrollX();
        if (1 > r108) goto L13;
        if (r107 <= r108) goto L13;
    L20:
        ViewParent r109 = getParent();
        if (r109 == null) goto L25;
        ViewParent r110 = r109.getParent();
        if (r110 == null) goto L25;
        ViewParent r111 = r110.getParent();
    L27:
        if ((r111 instanceof com.bytedance.android.shopping.slice.elements.shoprecommend.a) == false) goto L30;
        r102 = r111;
    L30:
        com.bytedance.android.shopping.slice.elements.shoprecommend.a r112 = (com.bytedance.android.shopping.slice.elements.shoprecommend.a) r102;
        if (r112 == null) goto L88;
        r112.requestDisallowInterceptTouchEvent(true);
    L25:
        r111 = null;
    L13:
        if (getScrollX() != 0) goto L17;
        if ((r100.getX() - this.f503608l) < 0) goto L20;
    L17:
        if (getScrollX() >= r107) goto L19;
    L33:
        ViewParent r113 = getParent();
        if (r113 == null) goto L38;
        ViewParent r114 = r113.getParent();
        if (r114 == null) goto L38;
        ViewParent r115 = r114.getParent();
    L40:
        if ((r115 instanceof com.bytedance.android.shopping.slice.elements.shoprecommend.a) == false) goto L43;
        r102 = r115;
    L43:
        com.bytedance.android.shopping.slice.elements.shoprecommend.a r116 = (com.bytedance.android.shopping.slice.elements.shoprecommend.a) r102;
        if (r116 == null) goto L88;
        r116.requestDisallowInterceptTouchEvent(false);
    L38:
        r115 = null;
        goto L40
    L19:
        if ((r100.getX() - this.f503608l) <= 0) goto L33;
    L47:
        if (getScrollX() < (getChildAt(0).getWidth() - getWidth())) goto L61;
        ViewParent r117 = getParent();
        if (r117 == null) goto L53;
        ViewParent r118 = r117.getParent();
        if (r118 == null) goto L53;
        ViewParent r119 = r118.getParent();
    L55:
        if ((r119 instanceof com.bytedance.android.shopping.slice.elements.shoprecommend.a) == false) goto L58;
        r102 = r119;
    L58:
        com.bytedance.android.shopping.slice.elements.shoprecommend.a r120 = (com.bytedance.android.shopping.slice.elements.shoprecommend.a) r102;
        if (r120 == null) goto L88;
        r120.requestDisallowInterceptTouchEvent(false);
    L53:
        r119 = null;
        goto L55
    L61:
        ViewParent r121 = getParent();
        if (r121 == null) goto L66;
        ViewParent r122 = r121.getParent();
        if (r122 == null) goto L66;
        ViewParent r123 = r122.getParent();
    L68:
        if ((r123 instanceof com.bytedance.android.shopping.slice.elements.shoprecommend.a) == false) goto L71;
        r102 = r123;
    L71:
        com.bytedance.android.shopping.slice.elements.shoprecommend.a r124 = (com.bytedance.android.shopping.slice.elements.shoprecommend.a) r102;
        if (r124 == null) goto L88;
        r124.requestDisallowInterceptTouchEvent(true);
    L66:
        r123 = null;
        goto L68
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L4;
        int r101 = r100.getAction();
        if (r101 != 1) goto L8;
    L34:
        this.f503602f = 0.0f;
        this.f503604h = false;
    L36:
        return super.onTouchEvent(r100);
    L8:
        if (r101 != 2) goto L10;
        float r102 = this.f503602f;
        if (r102 == 0.0f) goto L27;
        int r103 = (int) (r102 - r100.getX());
        if (r103 >= 0) goto L17;
        this.f503603g = 0;
        goto L27
    L17:
        if (r103 <= 0) goto L22;
        if (canScrollHorizontally(r103) == true) goto L22;
        this.f503603g += r103;
    L22:
        if (this.f503603g <= 200) goto L27;
        View r104 = getCallJumpView();
        if (r104 == null) goto L26;
        r104.post(new b(this));
    L26:
        this.f503603g = 0;
    L27:
        this.f503602f = r100.getX();
        if (this.f503604h == true) goto L36;
        this.f503604h = true;
        BaseSlcViewManager<?> r105 = SlcViewExtensionsKt.g(this);
        if (r105 == null) goto L36;
        SlcTemplateContext r106 = r105.f50260a;
        if (r106 == null) goto L36;
        SlcTemplateContext.e(r106, new SlcCommonAction("PDPRecommendGoodsScrollEvent", MapsKt.mapOf(TuplesKt.to("slide_params", this.f503605i))), this, null, null, 24);
        goto L36
    L10:
        if (r101 == 6) goto L34;
    L4:
        return super.onTouchEvent(r100);
    }
}
