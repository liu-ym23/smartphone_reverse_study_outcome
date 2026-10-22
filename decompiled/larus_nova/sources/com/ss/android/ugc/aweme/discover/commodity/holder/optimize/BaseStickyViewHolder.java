package com.ss.android.ugc.aweme.discover.commodity.holder.optimize;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.commodity.StaggeredGridDoubleColumnDecoration;
import com.ss.android.ugc.aweme.discover.commodity.holder.ECSearchBaseViewHolder;
import com.ss.android.ugc.aweme.discover.commodity.stickyheaders.StickyHeader;
import com.ss.android.ugc.aweme.discover.commodity.stickyheaders.handler.StickyHeaderHandler;
import com.ss.android.ugc.aweme.discover.model.SearchAggregateCommodity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/optimize/BaseStickyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/ugc/aweme/discover/commodity/holder/ECSearchBaseViewHolder;", "Lcom/ss/android/ugc/aweme/discover/commodity/stickyheaders/StickyHeader;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseStickyViewHolder<T extends RecyclerView.ViewHolder> extends ECSearchBaseViewHolder implements StickyHeader {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f450237i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f450238j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f450239k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f450240l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final BaseStickyViewHolder$mOnScrollListener$1 f450241m;

    public abstract void e4(SearchAggregateCommodity r100);

    public abstract InstantAddressSelectViewHolder$createRealViewHolder$1 f4();

    public void d4() {
        View r100 = this.itemView;
        ViewParent r101 = null;
        if ((r100 instanceof ViewGroup) == true) goto L5;
        r100 = null;
    L5:
        ViewGroup r102 = (ViewGroup) r100;
        if (r102 == null) goto L23;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L10;
        r103.height = -2;
        Unit r104 = Unit.INSTANCE;
    L11:
        r102.setLayoutParams(r103);
        r102.removeAllViews();
        View r105 = g4();
        if (r105 != null) goto L14;
        return;
    L14:
        ViewParent r106 = r105.getParent();
        if ((r106 instanceof ViewGroup) == false) goto L18;
        r101 = r106;
    L18:
        ViewGroup r107 = (ViewGroup) r101;
        if (r107 == null) goto L21;
        r107.removeView(r105);
    L21:
        r102.addView(r105);
        return;
    L10:
        r103 = null;
        goto L11
    }

    public final View g4() {
        if (((RecyclerView.ViewHolder) this.f450239k.getValue()) != null) goto L7;
        return null;
    L7:
        return ((RecyclerView.ViewHolder) this.f450239k.getValue()).itemView;
    }

    public BaseStickyViewHolder(Context r100) {
        FrameLayout r101 = new FrameLayout(r100);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "wrapperFrameLayout");
        super(r101);
        this.f450239k = LazyKt.lazy(new BaseStickyViewHolder$realViewHolder$2(this));
        this.f450241m = new BaseStickyViewHolder$mOnScrollListener$1(this);
    }

    @Override // com.ss.android.ugc.aweme.discover.commodity.stickyheaders.StickyHeader
    public final void V0(final RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f450240l = true;
        this.itemView.addOnAttachStateChangeListener(new BaseStickyViewHolder$createAsStickyHeader$1(this, r100));
    }

    public void c4(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        View r101 = this.itemView;
        ViewParent r102 = null;
        if ((r101 instanceof ViewGroup) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup r103 = (ViewGroup) r101;
        if (r103 == null) goto L8;
        int r104 = r103.getHeight();
        r103.removeAllViews();
        r103.addView(new View(getContext()), new ViewGroup.LayoutParams(-1, r104));
    L8:
        View r105 = g4();
        if (r105 != null) goto L11;
        return;
    L11:
        ViewParent r106 = r105.getParent();
        if ((r106 instanceof ViewGroup) == false) goto L15;
        r102 = r106;
    L15:
        ViewGroup r107 = (ViewGroup) r102;
        if (r107 == null) goto L18;
        r107.removeView(r105);
    L18:
        r100.addView(r105);
    }

    public static final boolean b4(BaseStickyViewHolder r100, RecyclerView r101) {
        View r102 = r100.g4();
        if (r102 == null) goto L25;
        RecyclerView.LayoutManager r103 = r101.getLayoutManager();
        if ((r103 instanceof StaggeredGridLayoutManager) == true) goto L8;
        r103 = null;
    L8:
        StaggeredGridLayoutManager r104 = (StaggeredGridLayoutManager) r103;
        if (r104 == null) goto L26;
        ViewGroup r105 = StickyHeaderHandler.b(r101);
        if (r105 == null) goto L27;
        RecyclerView.ViewHolder r106 = r101.findViewHolderForAdapterPosition(r104.findFirstVisibleItemPositions(null)[0]);
        if (r106 != null) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(r106.getClass(), r100.getClass()) == false) goto L24;
        int r107 = r106.itemView.getTop() - r101.getPaddingTop();
        if (r106.itemView.getTop() < (-r102.getHeight())) goto L21;
        r100.f450237i = r107;
        r105.setTranslationY(r107);
    L21:
        return true;
    L24:
        return false;
    L27:
        return false;
    L26:
        return false;
    L25:
        return false;
    }

    @Override // com.ss.android.ugc.aweme.discover.commodity.holder.ECSearchBaseViewHolder
    public void U3(SearchAggregateCommodity r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "searchAggregateCommodity");
        StaggeredGridDoubleColumnDecoration.Companion r102 = StaggeredGridDoubleColumnDecoration.f450023i;
        View r103 = this.itemView;
        r102.getClass();
        StaggeredGridDoubleColumnDecoration.Companion.a(r103, false);
        if (this.f450240l == true) goto L6;
        e4(r100);
        return;
    }
}
