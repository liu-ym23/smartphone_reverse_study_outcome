package com.bytedance.ee.bear.bitable.cardview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.common.CastMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00012B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u000bJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0014J\u0006\u0010\u0016\u001a\u00020\u0007J0\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0014J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\rH\u0002J\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\u0007H\u0002J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rH\u0002J\b\u0010\"\u001a\u00020\u0013H\u0002J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\rH\u0002J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u000fH\u0002J&\u0010&\u001a\u00020\u00132\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0011H\u0002J2\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070-2\n\u0010'\u001a\u0006\u0012\u0002\b\u00030(2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0011H\u0002J\u0006\u00101\u001a\u00020\u0013R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/ee/bear/bitable/cardview/widget/StickyItemViewLayout;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "targetRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "stickyItemView", "Landroid/view/View;", "enableSticky", "", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "getStickyTopOffset", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "l", "t", "r", "b", "initRecyclerView", "recyclerView", "findVisibleCompletelyHeaderView", "asleast", "hasGroup", "safeRemoveStickyItemView", "findAndAttachStickyView", "updateStickItemViewIfNeed", "stickItemView", "attachStickyViewByPosition", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "noScroll", "findStickyPositionByRange", "", "startPosition", "endPosition", "needFirst", "refreshItemView", "IStickyAdapter", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StickyItemViewLayout extends RelativeLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f209301d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f209302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f209303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f209304c;

    public interface a {
        void O(View r100, boolean r101, int r102);

        boolean T(int r100);

        int U1();

        boolean h2();

        View s(ViewGroup r100, int r101);
    }

    public final void e() {
        RecyclerView r100 = this.f209302a;
        if (r100 == null) goto L9;
        View r101 = this.f209303b;
        if (r101 == null) goto L7;
        r101.setTag(null);
    L7:
        b(r100);
        return;
    }

    public final int getStickyTopOffset() {
        RecyclerView r100 = this.f209302a;
        Object r101 = null;
        if (r100 == null) goto L5;
        RecyclerView.Adapter r102 = r100.getAdapter();
    L7:
        if ((r102 instanceof a) == false) goto L13;
        RecyclerView r103 = this.f209302a;
        if (r103 == null) goto L11;
        r101 = r103.getAdapter();
    L11:
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.cardview.widget.StickyItemViewLayout.IStickyAdapter");
        return ((a) r101).U1();
    L13:
        return 0;
    L5:
        r102 = null;
        goto L7
    }

    public StickyItemViewLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void b(RecyclerView r110) {
        if ((r110.getAdapter() instanceof a) == false) goto L5;
        Object r100 = r110.getAdapter();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.cardview.widget.StickyItemViewLayout.IStickyAdapter");
        boolean r101 = ((a) r100).h2();
    L7:
        if (r101 == true) goto L12;
        View r111 = this.f209303b;
        if (r111 == null) goto L53;
        removeView(r111);
        this.f209303b = null;
        return;
    L53:
        return;
    L12:
        RecyclerView.LayoutManager r102 = r110.getLayoutManager();
        if ((r102 instanceof LinearLayoutManager) == false) goto L54;
        LinearLayoutManager r103 = (LinearLayoutManager) r102;
        int r104 = r103.findFirstVisibleItemPosition();
        int r105 = r103.findLastVisibleItemPosition();
        RecyclerView.Adapter r112 = r110.getAdapter();
        if (r112 == null) goto L55;
        List r106 = c(r112, r105, 0, false);
        if (r104 != 0) goto L26;
        View r107 = r103.findViewByPosition(0);
        if (r107 != null) goto L21;
    L23:
        boolean r108 = false;
    L24:
        if (r108 == false) goto L26;
        boolean r109 = true;
    L27:
        ArrayList r113 = (ArrayList) r106;
        if ((true ^ r113.isEmpty()) == false) goto L42;
        Iterator r114 = r113.iterator();
    L31:
        if (r114.hasNext() == false) goto L42;
        int r115 = ((Number) r114.next()).intValue();
        View r116 = r103.findViewByPosition(r115);
        if (r116 != null) goto L35;
    L38:
        if (r116 != null) goto L31;
        if (r115 >= r104) goto L31;
        a(r112, r115, r109);
        return;
    L35:
        if (r116.getY() > (getStickyTopOffset() + 0)) goto L38;
        a(r112, r115, r109);
        return;
    L42:
        View r117 = this.f209303b;
        if (r117 == null) goto L56;
        removeView(r117);
        this.f209303b = null;
        return;
    L56:
        return;
    L21:
        if (r107.getTop() != 0) goto L23;
        r108 = true;
    L26:
        r109 = false;
        goto L27
    L55:
        return;
    L54:
        return;
    L5:
        r101 = false;
        goto L7
    }

    public StickyItemViewLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, -1);
    }

    public static View d(RecyclerView r100, int r101) {
        RecyclerView.LayoutManager r102 = r100.getLayoutManager();
        if ((r102 instanceof LinearLayoutManager) == false) goto L11;
        LinearLayoutManager r103 = (LinearLayoutManager) r102;
        int r104 = RangesKt.coerceAtLeast(r103.findFirstCompletelyVisibleItemPosition(), r101);
        int r105 = r103.findLastCompletelyVisibleItemPosition();
        RecyclerView.Adapter r106 = r100.getAdapter();
        if (r106 == null) goto L11;
        Integer r107 = (Integer) CollectionsKt.firstOrNull(c(r106, r104, r105, true));
        if (r107 == null) goto L9;
        int r108 = r107.intValue();
    L13:
        return r103.findViewByPosition(r108);
    L9:
        r108 = -1;
    L11:
        return null;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f209302a == null) goto L5;
    L12:
        measureChild(this.f209302a, r100, r101);
        View r102 = this.f209303b;
        if (r102 == null) goto L15;
        measureChild(r102, r100, r101);
    L15:
        setMeasuredDimension(View.MeasureSpec.getSize(r100), View.MeasureSpec.getSize(r101));
        return;
    L5:
        if (this.f209304c == false) goto L12;
        int r103 = getChildCount();
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L12;
        View r105 = getChildAt(0);
        if ((r105 instanceof RecyclerView) == true) goto L10;
        r104 = r104 + 1;
        goto L7
    L10:
        RecyclerView r106 = (RecyclerView) r105;
        this.f209302a = r106;
        r106.addOnScrollListener(new StickyItemViewLayout$initRecyclerView$1(this));
        goto L12
    }

    public StickyItemViewLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f209304c = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(RecyclerView.Adapter<RecyclerView.ViewHolder> r100, int r110, boolean r111) {
        View r101 = this.f209303b;
        ViewParent r102 = null;
        boolean r103 = false;
        if (r101 == null) goto L37;
        boolean r104 = Intrinsics.areEqual(r101.getTag(), Integer.valueOf(r110));
        if (r104 == false) goto L35;
        RecyclerView r105 = this.f209302a;
        if (r105 == null) goto L20;
        View r106 = this.f209303b;
        if (r106 == null) goto L11;
        Object r107 = r106.getTag();
    L13:
        if ((r107 instanceof Integer) == false) goto L15;
        Integer r108 = (Integer) r107;
    L16:
        if (r108 == null) goto L18;
        int r109 = r108.intValue();
    L19:
        View r112 = d(r105, r109 + 1);
    L21:
        if (r112 != null) goto L23;
    L27:
        View r113 = this.f209303b;
        if (r113 != null) goto L30;
    L33:
        if ((r100 instanceof a) == false) goto L35;
        ((a) r100).O(this.f209303b, r111, r110);
        goto L35
    L30:
        if (((int) r113.getY()) == (getStickyTopOffset() + 0)) goto L33;
        r113.requestLayout();
        goto L33
    L23:
        if (r112.getY() < 0.0f) goto L27;
        if (r112.getY() > (getStickyTopOffset() + r101.getMeasuredHeight())) goto L27;
        requestLayout();
        goto L33
    L18:
        r109 = 0;
        goto L19
    L15:
        r108 = null;
        goto L16
    L11:
        r107 = null;
        goto L13
    L20:
        r112 = null;
    L35:
        if (r104 != true) goto L37;
        r103 = true;
    L37:
        if (r103 == false) goto L40;
        return;
    L40:
        if ((r100 instanceof a) == false) goto L54;
        a r114 = (a) r100;
        View r115 = r114.s(this, r110);
        View r116 = this.f209303b;
        if (r116 != null) goto L44;
    L49:
        this.f209303b = r115;
        if (r115 == null) goto L52;
        r115.setTag(Integer.valueOf(r110));
    L52:
        r114.O(this.f209303b, r111, r110);
        addView(this.f209303b);
        return;
    L44:
        if (r116.getParent() == null) goto L49;
        View r117 = this.f209303b;
        if (r117 == null) goto L48;
        r102 = r117.getParent();
    L48:
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r102).removeView(this.f209303b);
        goto L49
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static List c(RecyclerView.Adapter r100, int r101, int r102, boolean r103) {
        ArrayList r104 = new ArrayList();
        if (r101 >= r102) goto L5;
        IntProgression r105 = new IntRange(r101, r102);
    L6:
        int r106 = r105.getFirst();
        int r107 = r105.getLast();
        int r108 = r105.getStep();
        if (r108 <= 0) goto L9;
        if (r106 > r107) goto L9;
    L12:
        if ((r100 instanceof a) == true) goto L14;
    L18:
        if (r106 == r107) goto L20;
        r106 = r106 + r108;
    L20:
        return r104;
    L14:
        if (((a) r100).T(r106) == false) goto L18;
        r104.add(Integer.valueOf(r106));
        if (r103 == false) goto L18;
    L9:
        if (r108 >= 0) goto L20;
        if (r107 > r106) goto L20;
    L5:
        r105 = RangesKt.downTo(r101, r102);
        goto L6
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        RecyclerView r105 = this.f209302a;
        if (r105 == null) goto L5;
        r105.layout(0, 0, r105.getMeasuredWidth(), r105.getMeasuredHeight());
    L5:
        View r106 = this.f209303b;
        if (r106 == null) goto L26;
        RecyclerView r107 = this.f209302a;
        if (r107 == null) goto L23;
        Object r108 = r106.getTag();
        if ((r108 instanceof Integer) == false) goto L12;
        Integer r109 = (Integer) r108;
    L13:
        if (r109 == null) goto L15;
        int r110 = r109.intValue();
    L16:
        View r111 = d(r107, r110 + 1);
        if (r111 == null) goto L23;
        if (r111.getY() <= (getStickyTopOffset() + 0)) goto L23;
        if (r111.getY() >= (getStickyTopOffset() + r106.getMeasuredHeight())) goto L23;
        float r112 = (r111.getY() - r106.getMeasuredHeight()) - getStickyTopOffset();
    L24:
        int r113 = (int) (r112 + getStickyTopOffset());
        r106.layout(0, r113, r106.getMeasuredWidth(), r106.getMeasuredHeight() + r113);
        return;
    L15:
        r110 = 0;
        goto L16
    L12:
        r109 = null;
    L23:
        r112 = 0.0f;
        goto L24
    }
}
