package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.awemeopen.apps.framework.AosSeriesRefactorService;
import com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.VerticalViewPager;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public class LoadMoreFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DmtStatusView f193346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VerticalViewPager f193347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f193348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f193349d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f193350e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f193351f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f193352g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.awemeopen.apps.framework.base.view.refresh.g f193353h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.bytedance.awemeopen.apps.framework.base.view.refresh.g f193354i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.awemeopen.apps.framework.base.view.refresh.g f193355j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f193356k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f193357l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f193358m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f193359n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ValueAnimator f193360o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f193361p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f193362q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f193363r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Drawable f193364s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f193365t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public f f193366u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f193367v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f193368w;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoadMoreFrameLayout f193369a;

        public a(LoadMoreFrameLayout r100) {
            this.f193369a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.awemeopen.apps.framework.base.view.refresh.g r101 = this.f193369a.f193353h;
            if (r101 == null) goto L6;
            r101.onLoadMore();
            return;
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoadMoreFrameLayout f193370a;

        public b(LoadMoreFrameLayout r100) {
            this.f193370a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            com.bytedance.awemeopen.apps.framework.base.view.refresh.g r101 = this.f193370a.f193353h;
            if (r101 == null) goto L6;
            r101.onLoadMore();
            return;
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f193371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LoadMoreFrameLayout f193372b;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            float r101 = r100.getAnimatedFraction();
            int r102 = LoadMoreFrameLayout.a(this.f193372b);
            LoadMoreFrameLayout r103 = this.f193372b;
            if (r101 != 1.0f) goto L5;
            int r104 = -r102;
        L6:
            LoadMoreFrameLayout.b(r103, r104);
            return;
        L5:
            r104 = (int) (((1.0d - Math.pow(r101, 3.0d)) * ((double) this.f193371a)) - ((double) LoadMoreFrameLayout.a(this.f193372b)));
            goto L6
        }

        public c(LoadMoreFrameLayout r100, int r101) {
            this.f193372b = r100;
            this.f193371a = r101;
        }
    }

    public class d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoadMoreFrameLayout f193373a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        public d(LoadMoreFrameLayout r100) {
            this.f193373a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f193373a.setBackground(null);
        }
    }

    public interface e {
    }

    public interface f {
        void onHide();

        void onShow();
    }

    public interface g {
    }

    public interface h {
    }

    public final void c() {
        this.f193360o = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        int r100 = getViewPagerMarginTop();
        int r101 = (r100 * (-200)) / this.f193357l;
        if (r101 >= 0) goto L5;
        r101 = 200;
    L5:
        this.f193360o.setDuration(r101);
        this.f193360o.addUpdateListener(new c(this, r100));
        this.f193360o.addListener(new d(this));
        this.f193360o.start();
        DmtStatusView r102 = e(false);
        if (r102 == null) goto L8;
        r102.setVisibility(8);
    L8:
        f r103 = this.f193366u;
        if (r103 == null) goto L12;
        r103.onHide();
        return;
    }

    public final void f() {
        DmtStatusView r100 = e(false);
        if (r100 == null) goto L5;
        r100.c();
    L5:
        this.f193356k = -1;
        if (this.f193347b == null) goto L9;
        c();
    L9:
        if (this.f193361p != (-1)) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(this.f193362q) == true) goto L15;
        this.f193361p = -1;
        return;
    }

    public final void g() {
        DmtStatusView r100 = e(true);
        if (r100 == null) goto L5;
        r100.setVisibility(0);
        r100.setStatus(1);
    L5:
        this.f193356k = 1;
        if (this.f193347b == null) goto L9;
        c();
    L9:
        if (this.f193361p != (-1)) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(this.f193362q) == true) goto L15;
        this.f193361p = -1;
        return;
    }

    public void setInterceptPredicate(j r100) {
    }

    public void setOnLoadMoreShowingListener(e r100) {
    }

    public void setOnScrolledListener(g r100) {
    }

    public void setReleaseListener(h r100) {
    }

    private int getViewPagerMarginTop() {
        VerticalViewPager r100 = this.f193347b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return ((ViewGroup.MarginLayoutParams) r100.getLayoutParams()).topMargin;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();     // Catch: Exception -> L4
        this.f193363r = true;     // Catch: Exception -> L4
        return;
    }

    public boolean getIsDragged() {
        return this.f193350e;
    }

    public LoadMoreFrameLayout(Context r100) {
        this(r100, null);
    }

    public static /* synthetic */ int a(LoadMoreFrameLayout r100) {
        return r100.getViewPagerMarginTop();
    }

    private void setViewPagerMarginTopByDelta(int r100) {
        VerticalViewPager r101 = this.f193347b;
        if (r101 != null) goto L5;
        return;
    L5:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101.getLayoutParams();
        int r103 = r102.topMargin + r100;
        r102.topMargin = r103;
        r102.bottomMargin = -r103;
        this.f193347b.setLayoutParams(r102);
    }

    public final DmtStatusView e(boolean r100) {
        boolean r101 = false;
        if (this.f193346a != null) goto L28;
        if (r100 == false) goto L28;
        if (this.f193363r == false) goto L28;
        boolean r102 = TextUtils.equals("series", this.f193362q);     // Catch: Exception -> L27
        this.f193346a = new DmtStatusView(getContext());     // Catch: Exception -> L27
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-1, x54.a.a(60));     // Catch: Exception -> L27
        r103.gravity = 80;     // Catch: Exception -> L27
        if (r102 == false) goto L11;
        int r104 = 0;
    L12:
        r103.setMargins(0, 0, 0, r104);     // Catch: Exception -> L27
        addView(this.f193346a, 0, r103);     // Catch: Exception -> L27
        if (this.f193365t != null) goto L16;
        TextView r105 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.aos_view_default_empty_list, null);     // Catch: Exception -> L27
        r105.setGravity(17);     // Catch: Exception -> L27
        r105.setTextColor(getContext().getResources().getColor(R.color.aos_const_text_inverse4));     // Catch: Exception -> L27
        this.f193365t = r105;     // Catch: Exception -> L27
    L16:
        if ((this.f193365t.getParent() instanceof ViewGroup) == true) goto L18;
    L20:
        if (r102 == false) goto L22;
        DmtStatusView r106 = this.f193346a;     // Catch: Exception -> L27
        DmtStatusView.a r107 = new DmtStatusView.a(getContext());     // Catch: Exception -> L27
        View r108 = ((AosSeriesRefactorService) BdpManager.getInst().getService(AosSeriesRefactorService.class)).q2();     // Catch: Exception -> L27
        r107.f193293b = r108;     // Catch: Exception -> L27
        r108.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));     // Catch: Exception -> L27
        r107.c(new a(this));     // Catch: Exception -> L27
        r107.b(this.f193365t);     // Catch: Exception -> L27
        r106.setBuilder(r107);     // Catch: Exception -> L27
    L23:
        Drawable r109 = this.f193364s;     // Catch: Exception -> L27
        if (r109 == null) goto L28;
        this.f193346a.setBackgroundDrawable(r109);     // Catch: Exception -> L27
        goto L28
    L22:
        DmtStatusView r110 = this.f193346a;     // Catch: Exception -> L27
        DmtStatusView.a r111 = DmtStatusView.a.a(getContext());     // Catch: Exception -> L27
        r111.c(new b(this));     // Catch: Exception -> L27
        r111.b(this.f193365t);     // Catch: Exception -> L27
        r110.setBuilder(r111);     // Catch: Exception -> L27
        goto L23
    L18:
        if (((ViewGroup) this.f193365t.getParent()).indexOfChild(this.f193365t) == (-1)) goto L20;
        ((ViewGroup) this.f193365t.getParent()).removeView(this.f193365t);     // Catch: Exception -> L27
        goto L20
    L11:
        r104 = x54.a.a(49);     // Catch: Exception -> L27
    L27:
        this.f193346a = null;
        this.f193364s = null;
    L28:
        DmtStatusView r112 = this.f193346a;
        if (r112 != null) goto L31;
    L35:
        return r112;
    L31:
        if (r112.f193288b != (-1)) goto L33;
        r101 = true;
    L33:
        if (r101 == false) goto L35;
        this.f193356k = -1;
        goto L35
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        VerticalViewPager r101 = this.f193347b;
        if (r101 != null) goto L5;
    L48:
        return false;
    L5:
        if (r101.getAdapter() == null) goto L48;
        if (this.f193347b.getAdapter().getCount() == 0) goto L48;
        if ((this.f193347b.getAdapter().getCount() - 1) != this.f193347b.getCurrentItem()) goto L48;
        VerticalViewPager r102 = this.f193347b;
        if (r102.P0 == true) goto L48;
        if (this.f193368w == true) goto L15;
    L16:
        i r103 = this.f193348c;
        if (r103 != null) goto L19;
    L20:
        int r104 = r100.getAction();
        if (r104 == 0) goto L45;
        if (r104 != 1) goto L24;
    L44:
        this.f193350e = false;
    L47:
        return this.f193350e;
    L24:
        if (r104 != 2) goto L26;
        float r105 = r100.getY();
        float r106 = this.f193351f;
        float r107 = r106 - r105;
        float r108 = this.f193349d;
        if (r107 <= r108) goto L36;
        if (this.f193350e == true) goto L36;
        this.f193350e = true;
        ValueAnimator r109 = this.f193360o;
        if (r109 == null) goto L47;
        r109.cancel();
    L36:
        if ((r105 - r106) <= r108) goto L47;
        if (this.f193350e == true) goto L47;
        if (this.f193347b.getTop() >= 0) goto L47;
        this.f193350e = true;
        ValueAnimator r110 = this.f193360o;
        if (r110 == null) goto L47;
        r110.cancel();
        goto L47
    L26:
        if (r104 == 3) goto L44;
    L45:
        this.f193350e = false;
        float r111 = r100.getY();
        this.f193351f = r111;
        this.f193352g = r111;
        goto L47
    L19:
        if (r103.isRefreshing() == true) goto L48;
    L15:
        if (d(r102, (int) r100.getX(), (int) r100.getY()) == true) goto L48;
        goto L16
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        DmtStatusView r101 = e(true);
        if (r101 == null) goto L83;
        VerticalViewPager r102 = this.f193347b;
        if (r102 == null) goto L83;
        if (r102.getAdapter() == null) goto L83;
        if (this.f193347b.getAdapter().getCount() == 0) goto L83;
        if ((this.f193347b.getAdapter().getCount() - 1) != this.f193347b.getCurrentItem()) goto L83;
        if (this.f193347b.P0 == true) goto L83;
        i r103 = this.f193348c;
        if (r103 != null) goto L17;
    L19:
        int r104 = r100.getAction();
        if (r104 != 0) goto L22;
        this.f193350e = false;
    L82:
        return super.onTouchEvent(r100);
    L22:
        if (r104 == 1) goto L53;
        if (r104 == 2) goto L31;
        if (r104 != 3) goto L82;
        if (this.f193350e == false) goto L82;
        c();
        this.f193350e = false;
        goto L82
    L31:
        if (this.f193350e == false) goto L82;
        float r105 = r100.getY();
        int r106 = (int) ((r105 - this.f193352g) / 1.0f);
        this.f193352g = r105;
        int r107 = getViewPagerMarginTop();
        int r108 = r107 + r106;
        if (r108 <= 0) goto L36;
        r106 = -r107;
    L36:
        if (r108 < (-this.f193357l)) goto L82;
        if (this.f193367v == false) goto L41;
        setViewPagerMarginTopByDelta(r106);
    L41:
        if (r101.f193288b != (-1)) goto L43;
        boolean r109 = true;
    L44:
        if (r109 == false) goto L46;
        r101.e();
        goto L82
    L46:
        DmtStatusView r110 = e(true);
        if (r110 == null) goto L49;
        r110.setVisibility(0);
    L49:
        setBackgroundColor(getContext().getResources().getColor(R.color.aos_const_bg_inverse));
        f r111 = this.f193366u;
        if (r111 == null) goto L82;
        r111.onShow();
        goto L82
    L43:
        r109 = false;
        goto L44
    L53:
        if (this.f193350e == false) goto L82;
        if (this.f193355j != null) goto L57;
    L61:
        boolean r112 = false;
    L62:
        if (r112 == false) goto L64;
    L79:
        this.f193350e = false;
        goto L82
    L64:
        if (getViewPagerMarginTop() > (-this.f193358m)) goto L73;
        int r113 = this.f193356k;
        if (r113 == 1) goto L73;
        if (r113 == 2) goto L73;
        this.f193360o = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        int r114 = getViewPagerMarginTop();
        int r115 = ((this.f193358m + r114) * (-200)) / this.f193357l;
        if (r115 >= 0) goto L72;
        r115 = 200;
    L72:
        this.f193360o.setDuration(r115);
        this.f193360o.addUpdateListener(new k(this, r114));
        this.f193360o.addListener(new l(this));
        this.f193360o.start();
    L73:
        com.bytedance.awemeopen.apps.framework.base.view.refresh.g r116 = this.f193354i;
        if (r116 != null) goto L76;
    L78:
        c();
        goto L79
    L76:
        if (this.f193356k != 1) goto L78;
        r116.onLoadMore();
        goto L78
    L57:
        if (this.f193356k != 1) goto L61;
        if (getViewPagerMarginTop() >= (-this.f193359n)) goto L61;
        this.f193355j.onLoadMore();
        r112 = true;
        goto L62
    L17:
        if (r103.isRefreshing() == false) goto L19;
    L83:
        return false;
    }

    public void setBottomViewBackground(Drawable r100) {
        DmtStatusView r101 = e(false);
        if (r101 == null) goto L5;
        r101.setBackgroundDrawable(r100);
        return;
    L5:
        this.f193364s = r100;
    }

    public void setCheckChildCanScroll(boolean r100) {
        this.f193368w = r100;
    }

    public void setEnableMoveViewPager(boolean r100) {
        this.f193367v = r100;
    }

    public void setLabel(String r100) {
        this.f193362q = r100;
    }

    public void setLoadMoreEmptyView(View r100) {
        this.f193365t = r100;
        DmtStatusView r101 = this.f193346a;
        if (r101 == null) goto L10;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (indexOfChild(r101) == (-1)) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        removeView(this.f193346a);
        goto L10
    L7:
        r102 = false;
    L10:
        this.f193346a = null;
    }

    public void setLoadMoreListener(com.bytedance.awemeopen.apps.framework.base.view.refresh.g r100) {
        this.f193353h = r100;
    }

    public void setLoadMoreWithEmptyStatusListener(com.bytedance.awemeopen.apps.framework.base.view.refresh.g r100) {
        this.f193354i = r100;
    }

    public void setOnLoadMoreUiListener(f r100) {
        this.f193366u = r100;
    }

    public void setPullUp2LeaveListener(com.bytedance.awemeopen.apps.framework.base.view.refresh.g r100) {
        this.f193355j = r100;
    }

    public LoadMoreFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static /* synthetic */ void b(LoadMoreFrameLayout r100, int r101) {
        r100.setViewPagerMarginTopByDelta(r101);
    }

    public LoadMoreFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f193356k = -1;
        this.f193361p = -1;
        this.f193363r = false;
        this.f193364s = null;
        this.f193367v = true;
        this.f193368w = false;
        this.f193349d = ViewConfiguration.get(r100).getScaledTouchSlop();
        Resources r103 = getContext().getResources();
        this.f193358m = (int) (WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density * 109.0f);
        Resources r104 = getContext().getResources();
        this.f193357l = (int) (WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density * 218.0f);
        Resources r105 = getContext().getResources();
        this.f193359n = (int) (WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density * 100.0f);
    }

    public static boolean d(View r100, int r110, int r111) {
        if ((r100 instanceof ViewGroup) == false) goto L19;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r100.getScrollX();
        int r103 = r100.getScrollY();
        int r104 = r101.getChildCount() - 1;
    L5:
        if (r104 < 0) goto L19;
        View r105 = r101.getChildAt(r104);
        int r106 = r110 + r102;
        if (r106 < r105.getLeft()) goto L17;
        if (r106 >= r105.getRight()) goto L17;
        int r107 = r111 + r103;
        if (r107 < r105.getTop()) goto L17;
        if (r107 >= r105.getBottom()) goto L17;
        if (d(r105, r106 - r105.getLeft(), r107 - r105.getTop()) == false) goto L17;
        return true;
    L17:
        r104 = r104 - 1;
    L19:
        if (r100.canScrollVertically(1) == true) goto L30;
        return false;
    L30:
        return true;
    }
}
