package com.bytedance.ee.bear.bitable.card.view.cell.formgrid.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.util.ui.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0014J\u0006\u0010\u0018\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/view/HorizontalScrollBar;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "scrollBar", "Landroid/view/View;", "rvScrollRange", "getRvScrollRange", "()I", "setRvScrollRange", "(I)V", "scrollBarScrollRange", "scrollBarWidth", "defaultWidth", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "updateScrollBarWidth", "bind", "scrollManager", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/RowScrollManager;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HorizontalScrollBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f207693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f207694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f207695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f207696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f207697e;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HorizontalScrollBar f207698a;

        public a(HorizontalScrollBar r100) {
            this.f207698a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HorizontalScrollBar r100 = this.f207698a;     // Catch: Throwable -> L4
            m.B(r100.f207693a, r100.f207696d, true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public HorizontalScrollBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HorizontalScrollBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        int r100 = (int) RangesKt.coerceAtLeast(RangesKt.coerceAtMost(((getMeasuredWidth() * getMeasuredWidth()) / this.f207694b) / 2, (getMeasuredWidth() * 3) / 4), this.f207697e);
        this.f207696d = r100;
        if (r100 == this.f207693a.getWidth()) goto L6;
        post(new a(this));
        return;
    }

    public final int getRvScrollRange() {
        return this.f207694b;
    }

    public final void setRvScrollRange(int r100) {
        this.f207694b = r100;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        a();
    }

    public HorizontalScrollBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r103 = n.d(30);
        this.f207697e = r103;
        ImageView r104 = new ImageView(r100);
        r104.setBackgroundResource(R.drawable.bitable_scroll_bar_bg);
        r104.setLayoutParams(new FrameLayout.LayoutParams(r103, n.d(4)));
        this.f207693a = r104;
        addView(r104);
    }

    public /* synthetic */ HorizontalScrollBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
