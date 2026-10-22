package com.bytedance.awemeopen.apps.framework.base.view.refresh;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public class LoadMoreFrameLayoutForRecycleView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DmtStatusView f193374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f193375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f193376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f193377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f193378e;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoadMoreFrameLayoutForRecycleView f193379a;

        public a(LoadMoreFrameLayoutForRecycleView r100) {
            this.f193379a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            g r101 = this.f193379a.f193375b;
            if (r101 == null) goto L6;
            r101.onLoadMore();
            return;
        }
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    public interface e {
    }

    private int getViewPagerMarginTop() {
        return 0;
    }

    private void setViewPagerMarginTopByDelta(int r100) {
    }

    public boolean getIsDragged() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return false;
    }

    public void setCheckChildCanScroll(boolean r100) {
    }

    public void setEnableMoveViewPager(boolean r100) {
    }

    public void setInterceptPredicate(j r100) {
    }

    public void setLabel(String r100) {
    }

    public void setLoadMoreWithEmptyStatusListener(g r100) {
    }

    public void setOnLoadMoreShowingListener(b r100) {
    }

    public void setOnLoadMoreUiListener(c r100) {
    }

    public void setOnScrolledListener(d r100) {
    }

    public void setPullUp2LeaveListener(g r100) {
    }

    public void setReleaseListener(e r100) {
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();     // Catch: Exception -> L4
        this.f193376c = true;     // Catch: Exception -> L4
        return;
    }

    public LoadMoreFrameLayoutForRecycleView(Context r100) {
        this(r100, null);
    }

    public final DmtStatusView a(boolean r100) {
        if (this.f193374a != null) goto L21;
        if (r100 == false) goto L21;
        if (this.f193376c == false) goto L21;
        this.f193374a = new DmtStatusView(getContext());     // Catch: Exception -> L20
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-1, x54.a.a(60));     // Catch: Exception -> L20
        r101.gravity = 80;     // Catch: Exception -> L20
        r101.setMargins(0, 0, 0, x54.a.a(49));     // Catch: Exception -> L20
        addView(this.f193374a, 0, r101);     // Catch: Exception -> L20
        if (this.f193378e != null) goto L12;
        TextView r102 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.aos_view_default_empty_list, null);     // Catch: Exception -> L20
        r102.setGravity(17);     // Catch: Exception -> L20
        r102.setTextColor(getContext().getResources().getColor(R.color.aos_const_text_inverse4));     // Catch: Exception -> L20
        this.f193378e = r102;     // Catch: Exception -> L20
    L12:
        if ((this.f193378e.getParent() instanceof ViewGroup) == true) goto L14;
    L16:
        DmtStatusView r103 = this.f193374a;     // Catch: Exception -> L20
        DmtStatusView.a r104 = DmtStatusView.a.a(getContext());     // Catch: Exception -> L20
        r104.c(new a(this));     // Catch: Exception -> L20
        r104.b(this.f193378e);     // Catch: Exception -> L20
        r103.setBuilder(r104);     // Catch: Exception -> L20
        Drawable r105 = this.f193377d;     // Catch: Exception -> L20
        if (r105 == null) goto L21;
        this.f193374a.setBackgroundDrawable(r105);     // Catch: Exception -> L20
        goto L21
    L14:
        if (((ViewGroup) this.f193378e.getParent()).indexOfChild(this.f193378e) == (-1)) goto L16;
        ((ViewGroup) this.f193378e.getParent()).removeView(this.f193378e);     // Catch: Exception -> L20
    L20:
        this.f193374a = null;
        this.f193377d = null;
    L21:
        DmtStatusView r106 = this.f193374a;
        if (r106 == null) goto L24;
        int r107 = r106.f193288b;
    L24:
        return r106;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        a(true);
        return false;
    }

    public void setBottomViewBackground(Drawable r100) {
        DmtStatusView r101 = a(false);
        if (r101 == null) goto L5;
        r101.setBackgroundDrawable(r100);
        return;
    L5:
        this.f193377d = r100;
    }

    public void setLoadMoreEmptyView(View r100) {
        this.f193378e = r100;
        DmtStatusView r101 = this.f193374a;
        if (r101 == null) goto L10;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (indexOfChild(r101) == (-1)) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        removeView(this.f193374a);
        goto L10
    L7:
        r102 = false;
    L10:
        this.f193374a = null;
    }

    public void setLoadMoreListener(g r100) {
        this.f193375b = r100;
    }

    public LoadMoreFrameLayoutForRecycleView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public LoadMoreFrameLayoutForRecycleView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f193376c = false;
        this.f193377d = null;
        ViewConfiguration.get(r100).getScaledTouchSlop();
        Resources r103 = getContext().getResources();
        float r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density;
        Resources r105 = getContext().getResources();
        float r106 = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density;
        Resources r107 = getContext().getResources();
        float r108 = WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()).density;
    }
}
