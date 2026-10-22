package com.bytedance.ee.bear.bitable.itemview.record.list;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.itemview.cell.ItemViewCellContainerV2;
import com.bytedance.ee.bear.bitable.itemview.util.i;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0002\u0013\u0016\u0018\u0000 .2\u00020\u0001:\u0001.B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u0019J\u0006\u0010\"\u001a\u00020\u0019J\b\u0010#\u001a\u00020\u0007H\u0002J\b\u0010$\u001a\u00020\u0019H\u0002J\u0018\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u0007H\u0002J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u00192\b\u0010,\u001a\u0004\u0018\u00010-R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/list/HorizontalRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "heightMap", "", "lastMaxHeight", "lastAvgItemWidth", "isAdaptiveMode", "", "maskColor", "maskWidth", "scrollListener", "com/bytedance/ee/bear/bitable/itemview/record/list/HorizontalRecyclerView$scrollListener$1", "Lcom/bytedance/ee/bear/bitable/itemview/record/list/HorizontalRecyclerView$scrollListener$1;", "onGlobalLayoutListener", "com/bytedance/ee/bear/bitable/itemview/record/list/HorizontalRecyclerView$onGlobalLayoutListener$1", "Lcom/bytedance/ee/bear/bitable/itemview/record/list/HorizontalRecyclerView$onGlobalLayoutListener$1;", "onAttachedToWindow", "", "onDetachedFromWindow", "canScrollHorizontally", "direction", "canScrollVertically", "setAdaptiveMode", "mode", "Lcom/bytedance/ee/bear/bitable/itemview/record/list/HorizontalContainerMode;", "clearLayoutInfo", "updateLayout", "getItemAvgWidth", "updateMinHeight", "updateItemWidth", "needAdjust", "avgWidth", "onDrawForeground", "canvas", "Landroid/graphics/Canvas;", "setMaskColor", "hexColor", "", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HorizontalRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, Integer> f214096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f214097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f214098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f214099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f214100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f214101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HorizontalRecyclerView$scrollListener$1 f214102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f214103h;

    public static final class a {
    }

    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f214104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HorizontalRecyclerView f214105b;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            int r100 = this.f214105b.getHeight();
            if (this.f214104a == r100) goto L6;
            this.f214104a = r100;
            tt5.a.b("HorizontalContainerItem", "onGlobalLayout Height changed to: " + r100);
            this.f214105b.t();
            return;
        }

        public b(HorizontalRecyclerView r100) {
            this.f214105b = r100;
        }
    }

    static {
    }

    public HorizontalRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HorizontalRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int r100) {
        return true;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        return false;
    }

    public final void u() {
        Integer r100 = (Integer) CollectionsKt.maxOrNull(((HashMap) this.f214096a).values());
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
    L7:
        if (this.f214097b == r101) goto L10;
        tt5.a.h("HorizontalContainerItem", "updateMinHeight minHeight = " + r101);
        this.f214097b = r101;
        setMinimumHeight(r101);
        return;
    L10:
        return;
    L5:
        r101 = 0;
        goto L7
    }

    private final int getItemAvgWidth() {
        RecyclerView.Adapter r100 = getAdapter();
        if (r100 == null) goto L5;
        int r101 = r100.getItemCount();
    L7:
        if (this.f214099d == true) goto L9;
        return 0;
    L9:
        if (r101 != getChildCount()) goto L17;
        int r102 = getMeasuredWidth();
        if (r101 < 0) goto L18;
        int r103 = r102 - (n.d(24) * (r101 - 1));
        if (r103 >= 0) goto L15;
        return 0;
    L15:
        return r103 / r101;
    L18:
        return 0;
    L17:
        return 0;
    L5:
        r101 = 0;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        addOnScrollListener(this.f214102g);
        getViewTreeObserver().addOnGlobalLayoutListener(this.f214103h);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeOnScrollListener(this.f214102g);
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f214103h);
    }

    public final void t() {
        int r100 = getItemAvgWidth();
        tt5.a.b("HorizontalContainerItem", "updateLayout avgWidth = " + r100);
        Iterator<Integer> r101 = RangesKt.until(0, getChildCount()).iterator();
        boolean r102 = true;
    L4:
        if (r101.hasNext() == false) goto L19;
        View r103 = getChildAt(((IntIterator) r101).nextInt());
        int r104 = getChildAdapterPosition(r103);
        int r105 = r103.getMeasuredHeight();
        ((HashMap) this.f214096a).put(Integer.valueOf(r104), Integer.valueOf(r105));
        if (r102 == false) goto L17;
        if (r100 <= 0) goto L17;
        if ((r103 instanceof ItemViewCellContainerV2) == false) goto L11;
        Integer r106 = Integer.valueOf(((ItemViewCellContainerV2) r103).getHotSpotContainer().getMeasuredWidth());
    L13:
        if (r106.intValue() <= 0) goto L18;
        if (r106.intValue() <= r100) goto L18;
        r102 = false;
    L18:
        tt5.a.b("HorizontalContainerItem", "position = " + r104 + " itemHeight = " + r105 + " itemWidth = " + r106);
        goto L4
    L11:
        r106 = Integer.valueOf(r103.getMeasuredWidth());
    L17:
        r106 = null;
        goto L18
    L19:
        u();
        r(r102, r100);
    }

    @Override // android.view.View
    public final void onDrawForeground(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDrawForeground(r110);
        if (super.canScrollHorizontally(1) == false) goto L6;
        float r100 = getWidth() - this.f214101f;
        LinearGradient r111 = new LinearGradient(r100, 0.0f, getWidth(), 0.0f, 0, this.f214100e, Shader.TileMode.CLAMP);
        Paint r101 = new Paint();
        r101.setShader(r111);
        r101.setAntiAlias(true);
        r110.drawRect(r100, 0.0f, getWidth(), getHeight(), r101);
        return;
    }

    public final void setAdaptiveMode(HorizontalContainerMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        if (r100 != HorizontalContainerMode.ADAPTIVE) goto L5;
        boolean r101 = true;
    L6:
        this.f214099d = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setMaskColor(String r100) {
        this.f214100e = i.d(getContext(), r100);
    }

    public final void r(boolean r100, int r101) {
        int r102 = 0;
        if (r100 == false) goto L5;
        int r103 = r101;
    L7:
        if (this.f214098c == r103) goto L11;
        tt5.a.h("HorizontalContainerItem", "updateItemWidth needAdjust = " + r100 + ", avgWidth = " + r101);
        this.f214098c = r103;
        int r104 = getChildCount();
    L9:
        if (r102 >= r104) goto L13;
        getChildAt(r102).setMinimumWidth(r103);
        r102 = r102 + 1;
        goto L9
    L13:
        return;
    L11:
        return;
    L5:
        r103 = 0;
        goto L7
    }

    public HorizontalRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f214096a = new HashMap();
        this.f214100e = n.h(r100, R.color.bg_body);
        this.f214101f = n.d(40);
        this.f214102g = new HorizontalRecyclerView$scrollListener$1(this);
        this.f214103h = new b(this);
        setNestedScrollingEnabled(false);
        setClipToPadding(false);
        setOverScrollMode(2);
        addItemDecoration(new AnonymousClass1());
    }

    public /* synthetic */ HorizontalRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
