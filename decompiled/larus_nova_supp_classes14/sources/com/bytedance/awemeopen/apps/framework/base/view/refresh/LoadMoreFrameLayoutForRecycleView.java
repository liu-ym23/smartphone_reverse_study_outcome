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
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class LoadMoreFrameLayoutForRecycleView extends FrameLayout {
    public DmtStatusView a;
    public g b;
    public boolean c;
    public Drawable d;
    public View e;

    public class a implements View.OnClickListener {
        public final /* synthetic */ LoadMoreFrameLayoutForRecycleView a;

        public a(LoadMoreFrameLayoutForRecycleView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            g r2 = this.a.b;
            if (r2 == null) goto L6;
            r2.onLoadMore();
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

    private void setViewPagerMarginTopByDelta(int r1) {
    }

    public boolean getIsDragged() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return false;
    }

    public void setCheckChildCanScroll(boolean r1) {
    }

    public void setEnableMoveViewPager(boolean r1) {
    }

    public void setInterceptPredicate(j r1) {
    }

    public void setLabel(String r1) {
    }

    public void setLoadMoreWithEmptyStatusListener(g r1) {
    }

    public void setOnLoadMoreShowingListener(b r1) {
    }

    public void setOnLoadMoreUiListener(c r1) {
    }

    public void setOnScrolledListener(d r1) {
    }

    public void setPullUp2LeaveListener(g r1) {
    }

    public void setReleaseListener(e r1) {
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();     // Catch: Exception -> L4
        this.c = true;     // Catch: Exception -> L4
        return;
    }

    public LoadMoreFrameLayoutForRecycleView(Context r2) {
        this(r2, null);
    }

    public final DmtStatusView a(boolean r5) {
        if (this.a != null) goto L21;
        if (r5 == false) goto L21;
        if (this.c == false) goto L21;
        this.a = new DmtStatusView(getContext());     // Catch: Exception -> L20
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, x54.a.a(60));     // Catch: Exception -> L20
        r0.gravity = 80;     // Catch: Exception -> L20
        r0.setMargins(0, 0, 0, x54.a.a(49));     // Catch: Exception -> L20
        addView(this.a, 0, r0);     // Catch: Exception -> L20
        if (this.e != null) goto L12;
        TextView r1 = (TextView) LayoutInflater.from(getContext()).inflate(2131558701, null);     // Catch: Exception -> L20
        r1.setGravity(17);     // Catch: Exception -> L20
        r1.setTextColor(getContext().getResources().getColor(2131100273));     // Catch: Exception -> L20
        this.e = r1;     // Catch: Exception -> L20
    L12:
        if ((this.e.getParent() instanceof ViewGroup) == true) goto L14;
    L16:
        DmtStatusView r2 = this.a;     // Catch: Exception -> L20
        DmtStatusView.a r3 = DmtStatusView.a.a(getContext());     // Catch: Exception -> L20
        r3.c(new a(this));     // Catch: Exception -> L20
        r3.b(this.e);     // Catch: Exception -> L20
        r2.setBuilder(r3);     // Catch: Exception -> L20
        Drawable r4 = this.d;     // Catch: Exception -> L20
        if (r4 == null) goto L21;
        this.a.setBackgroundDrawable(r4);     // Catch: Exception -> L20
        goto L21
    L14:
        if (((ViewGroup) this.e.getParent()).indexOfChild(this.e) == (-1)) goto L16;
        ((ViewGroup) this.e.getParent()).removeView(this.e);     // Catch: Exception -> L20
    L20:
        this.a = null;
        this.d = null;
    L21:
        DmtStatusView r6 = this.a;
        if (r6 == null) goto L24;
        int r7 = r6.b;
    L24:
        return r6;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r1) {
        super.onDraw(r1);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r1) {
        a(true);
        return false;
    }

    public void setBottomViewBackground(Drawable r2) {
        DmtStatusView r0 = a(false);
        if (r0 == null) goto L5;
        r0.setBackgroundDrawable(r2);
        return;
    L5:
        this.d = r2;
    }

    public void setLoadMoreEmptyView(View r2) {
        this.e = r2;
        DmtStatusView r3 = this.a;
        if (r3 == null) goto L10;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r3, "child");
        if (indexOfChild(r3) == (-1)) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L10;
        removeView(this.a);
        goto L10
    L7:
        r4 = false;
    L10:
        this.a = null;
    }

    public void setLoadMoreListener(g r1) {
        this.b = r1;
    }

    public LoadMoreFrameLayoutForRecycleView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public LoadMoreFrameLayoutForRecycleView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.c = false;
        this.d = null;
        ViewConfiguration.get(r1).getScaledTouchSlop();
        Resources r4 = getContext().getResources();
        float r5 = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).density;
        Resources r6 = getContext().getResources();
        float r7 = WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()).density;
        Resources r8 = getContext().getResources();
        float r9 = WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()).density;
    }
}
