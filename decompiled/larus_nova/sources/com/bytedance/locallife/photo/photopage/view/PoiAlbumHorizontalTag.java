package com.bytedance.locallife.photo.photopage.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ies.dmt.ui.widget.DmtTextView;
import com.bytedance.locallife.dito.utils.o;
import com.bytedance.locallife.model.album.TabInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0005\u0015\u0016\u0017\u0018\u0019B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J)\u0010\u000b\u001a\u00020\u00042!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00040\u0006J\u001a\u0010\r\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u0006¨\u0006\u001a"}, d2 = {"Lcom/bytedance/locallife/photo/photopage/view/PoiAlbumHorizontalTag;", "Landroid/widget/FrameLayout;", "", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "", "setSelectedPos", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "callback", "setOnItemExposed", "", "setOnListScrollEnd", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "CenterLayoutManager", "CenterSmoothScroller", "PoiAlbumHorizontalTagAdapter", "PoiAlbumHorizontalTagDecoration", "PoiAlbumHorizontalTagViewHolder", "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiAlbumHorizontalTag extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f262236f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f262237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PoiAlbumHorizontalTagAdapter f262238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super Integer, Unit> f262239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f262240d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f262241e;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/photo/photopage/view/PoiAlbumHorizontalTag$CenterLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class CenterLayoutManager extends LinearLayoutManager {
        public CenterLayoutManager(Context r100) {
            super(r100, 0, false);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public final void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            Intrinsics.checkNotNullParameter(r101, "state");
            CenterSmoothScroller r103 = new CenterSmoothScroller(r100.getContext());
            r103.setTargetPosition(r102);
            startSmoothScroll(r103);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/photo/photopage/view/PoiAlbumHorizontalTag$CenterSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class CenterSmoothScroller extends LinearSmoothScroller {
        public CenterSmoothScroller(Context r100) {
            super(r100);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final int calculateDtToFit(int r100, int r101, int r102, int r103, int r104) {
            return (r102 + ((r103 - r102) / 2)) - (r100 + ((r101 - r100) / 2));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/locallife/photo/photopage/view/PoiAlbumHorizontalTag$PoiAlbumHorizontalTagAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/locallife/photo/photopage/view/PoiAlbumHorizontalTag$PoiAlbumHorizontalTagViewHolder;", "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class PoiAlbumHorizontalTagAdapter extends RecyclerView.Adapter<PoiAlbumHorizontalTagViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView f262243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<TabInfo> f262244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f262245c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Function1<? super Integer, Unit> f262246d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f262247e;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            List<TabInfo> r100 = this.f262244b;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.size();
        }

        public PoiAlbumHorizontalTagAdapter(RecyclerView r100) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            this.f262243a = r100;
            this.f262247e = true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            PoiAlbumHorizontalTagViewHolder r102 = (PoiAlbumHorizontalTagViewHolder) r100;
            Intrinsics.checkNotNullParameter(r102, "holder");
            List<TabInfo> r103 = this.f262244b;
            if (r103 == null) goto L32;
            TabInfo r104 = (TabInfo) ListProtector.get(r103, r101);
            if (r104 == null) goto L36;
            int r105 = this.f262245c;
            boolean r106 = this.f262247e;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r104, "tabInfo");
            DmtTextView r107 = r102.f262248a;
            if (r107 == null) goto L16;
            if (r106 == false) goto L12;
            String r108 = r104.getTabName() + '(' + r104.getTabCount() + ')';
        L15:
            r107.setText(r108);
            goto L16
        L12:
            r108 = r104.getTabName();
            if (r108 != null) goto L15;
            r108 = "";
        L16:
            if (r101 != r105) goto L24;
            DmtTextView r109 = r102.f262248a;
            if (r109 == null) goto L21;
            r109.setBackground(r102.f262249b);
        L21:
            DmtTextView r110 = r102.f262248a;
            if (r110 == null) goto L33;
            r110.setTextColor(ContextCompat.getColor(r102.itemView.getContext(), R.color.POIPrimary));
            return;
        L33:
            return;
        L24:
            DmtTextView r111 = r102.f262248a;
            if (r111 == null) goto L28;
            r111.setBackground(r102.f262250c);
        L28:
            DmtTextView r112 = r102.f262248a;
            if (r112 == null) goto L35;
            r112.setTextColor(ContextCompat.getColor(r102.itemView.getContext(), R.color.POIPrimary2));
            return;
        L35:
            return;
        L36:
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.poi_item_album_tag_view, r100, false);
            PoiAlbumHorizontalTagViewHolder r103 = new PoiAlbumHorizontalTagViewHolder(r102);
            r102.setOnClickListener(new b(r103, this));
            return r103;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/photo/photopage/view/PoiAlbumHorizontalTag$PoiAlbumHorizontalTagDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class PoiAlbumHorizontalTagDecoration extends RecyclerView.ItemDecoration {
        public PoiAlbumHorizontalTagDecoration(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
            Intrinsics.checkNotNullParameter(r100, "outRect");
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "parent");
            Intrinsics.checkNotNullParameter(r103, "state");
            int r104 = r103.getItemCount();
            if (r104 <= 0) goto L12;
            int r105 = r102.getChildLayoutPosition(r101);
            if (r105 != 0) goto L8;
            Resources r106 = Resources.getSystem();
            int r107 = MathKt.roundToInt(TypedValue.applyDimension(1, 16, WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics())));
            Resources r108 = Resources.getSystem();
            r100.set(r107, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 8, WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics()))), 0);
            return;
        L8:
            if (r105 != (r104 - 1)) goto L10;
            Resources r109 = Resources.getSystem();
            r100.set(0, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 16, WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics()))), 0);
            return;
        L10:
            Resources r110 = Resources.getSystem();
            r100.set(0, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 8, WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics()))), 0);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/photo/photopage/view/PoiAlbumHorizontalTag$PoiAlbumHorizontalTagViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class PoiAlbumHorizontalTagViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DmtTextView f262248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Drawable f262249b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Drawable f262250c;

        public PoiAlbumHorizontalTagViewHolder(final View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            if ((r100 instanceof DmtTextView) == false) goto L5;
            DmtTextView r101 = (DmtTextView) r100;
        L6:
            this.f262248a = r101;
            this.f262249b = o.a(new PoiAlbumHorizontalTag$PoiAlbumHorizontalTagViewHolder$selectedBackground$1(r100));
            this.f262250c = o.a(new PoiAlbumHorizontalTag$PoiAlbumHorizontalTagViewHolder$unSelectedBackground$1(r100));
            return;
        L5:
            r101 = null;
            goto L6
        }
    }

    public PoiAlbumHorizontalTag(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PoiAlbumHorizontalTag(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        RecyclerView.LayoutManager r100 = this.f262237a.getLayoutManager();
        Integer r101 = null;
        if ((r100 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r102 = (LinearLayoutManager) r100;
    L6:
        if (r102 == null) goto L8;
        Integer r103 = Integer.valueOf(r102.findFirstVisibleItemPosition());
    L9:
        RecyclerView.LayoutManager r104 = this.f262237a.getLayoutManager();
        if ((r104 instanceof LinearLayoutManager) == false) goto L12;
        LinearLayoutManager r105 = (LinearLayoutManager) r104;
    L13:
        if (r105 == null) goto L15;
        r101 = Integer.valueOf(r105.findLastVisibleItemPosition());
    L15:
        if (r103 == null) goto L28;
        if (r101 != null) goto L18;
        return;
    L18:
        if (r103.intValue() >= 0) goto L20;
        return;
    L20:
        if (r101.intValue() < 0) goto L32;
        int r106 = r103.intValue();
        int r107 = r101.intValue();
        if (r106 > r107) goto L33;
    L23:
        Function1<? super Integer, Unit> r108 = this.f262239c;
        if (r108 == null) goto L26;
        Unit r109 = r108.invoke(Integer.valueOf(r106));
    L26:
        if (r106 == r107) goto L34;
        r106 = r106 + 1;
        goto L23
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L28:
        return;
    L12:
        r105 = null;
        goto L13
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    public final void setOnItemExposed(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f262239c = r100;
    }

    public final void setOnListScrollEnd(Function1<? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f262240d = r100;
    }

    public final void setSelectedPos(int r100) {
        RecyclerView.Adapter r101 = this.f262237a.getAdapter();
        if ((r101 instanceof PoiAlbumHorizontalTagAdapter) == false) goto L5;
        PoiAlbumHorizontalTagAdapter r102 = (PoiAlbumHorizontalTagAdapter) r101;
    L6:
        if (r102 == null) goto L12;
        int r103 = r102.f262245c;
        if (r103 == r100) goto L13;
        r102.f262245c = r100;
        r102.notifyItemChanged(r103);
        r102.notifyItemChanged(r102.f262245c);
        r102.f262243a.smoothScrollToPosition(r100);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public PoiAlbumHorizontalTag(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        RecyclerView r103 = new RecyclerView(r100);
        this.f262237a = r103;
        PoiAlbumHorizontalTagAdapter r104 = new PoiAlbumHorizontalTagAdapter(r103);
        this.f262238b = r104;
        r103.addItemDecoration(new PoiAlbumHorizontalTagDecoration(r100));
        r103.setOverScrollMode(2);
        r103.setAdapter(r104);
        r103.setLayoutManager(new CenterLayoutManager(r100));
        r103.addOnScrollListener(new AnonymousClass1(this));
    }

    public /* synthetic */ PoiAlbumHorizontalTag(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
