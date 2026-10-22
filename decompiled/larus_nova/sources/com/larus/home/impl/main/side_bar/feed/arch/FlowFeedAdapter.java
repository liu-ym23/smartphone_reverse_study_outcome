package com.larus.home.impl.main.side_bar.feed.arch;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larus.utils.e1;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 !2\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002 !B+\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J&\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0003H\u0016J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0003H\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/home/impl/main/side_bar/feed/arch/FlowFeedAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/home/api/feed/FlowUIFeedCard;", "Lcom/larus/home/impl/main/side_bar/feed/arch/FlowFeedAdapter$FlowFeedViewHolder;", "registry", "Lcom/larus/home/impl/main/side_bar/feed/arch/FlowFeedRegistry;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/home/api/feed/IFlowFeedCardContext;", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "<init>", "(Lcom/larus/home/impl/main/side_bar/feed/arch/FlowFeedRegistry;Lcom/larus/home/api/feed/IFlowFeedCardContext;Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onDetachedFromRecyclerView", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "payloads", "", "", "onViewRecycled", "onViewAttachedToWindow", "onViewDetachedFromWindow", "FlowFeedViewHolder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowFeedAdapter extends ListAdapter<eb9.o<?>, FlowFeedViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f344562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final eb9.u f344563b;

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0010\u001a\u00020\u00112\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0012\u001a\u00020\u0013J\u001a\u0010\u0014\u001a\u00020\u00112\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0012\u001a\u00020\u0013J\u001c\u0010\u0015\u001a\u00020\u00112\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J$\u0010\u0016\u001a\u00020\u00172\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0013H\u0002J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013H\u0002J\u0006\u0010\u001b\u001a\u00020\u0011J\b\u0010\u001c\u001a\u00020\u0011H\u0002J\u0006\u0010\u001d\u001a\u00020\u0011J\u0006\u0010\u001e\u001a\u00020\u0011J\u0006\u0010\u001f\u001a\u00020\u0011J\b\u0010 \u001a\u0004\u0018\u00010!J\u0012\u0010\"\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010#j\u0004\u0018\u0001`$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/home/impl/main/side_bar/feed/arch/FlowFeedAdapter$FlowFeedViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL, "Lcom/larus/home/api/feed/IFlowFeedCell;", "action", "Lcom/larus/home/api/feed/IFlowFeedAction;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/home/api/feed/IFlowFeedCardContext;", "<init>", "(Landroid/view/View;Lcom/larus/home/api/feed/IFlowFeedCell;Lcom/larus/home/api/feed/IFlowFeedAction;Lcom/larus/home/api/feed/IFlowFeedCardContext;)V", BrowserDependency.UrlClickType.CARD, "Lcom/larus/home/api/feed/FlowUIFeedCard;", "clickActionView", "longClickActionView", "bind", "", "position", "", "bindSelection", "bindActions", "handleLongClick", "", "anchor", "fallbackPosition", "currentAdapterPosition", "recycle", "clearActionListeners", LynxViewpagerItem.BIND_ON_ATTACH, "detach", "reportShow", "getReportKey", "", "getCardType", "", "Lcom/larus/home/api/feed/FlowFeedCardType;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FlowFeedViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int f344564g = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final eb9.x f344565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final eb9.p f344566b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final eb9.u f344567c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public eb9.o<?> f344568d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f344569e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public View f344570f;

        public final void U3() {
            View r100 = this.f344569e;
            if (r100 == null) goto L5;
            r100.setOnClickListener(null);
        L5:
            this.f344569e = null;
            View r101 = this.f344570f;
            if (r101 == null) goto L8;
            r101.setOnLongClickListener(null);
        L8:
            this.f344570f = null;
        }

        public final int V3(int r100) {
            Integer r101 = Integer.valueOf(getBindingAdapterPosition());
            if (r101.intValue() != (-1)) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L9;
            r101 = null;
        L9:
            if (r101 != null) goto L11;
            return r100;
        L11:
            return r101.intValue();
        L5:
            r102 = false;
            goto L6
        }

        public final void T3(final eb9.o<?> r100, final int r101) {
            eb9.p r102 = this.f344566b;
            boolean r103 = true;
            if (r102 != null) goto L5;
        L7:
            boolean r104 = false;
        L8:
            if (r104 == false) goto L10;
        L14:
            eb9.p r105 = this.f344566b;
            if (r105 != null) goto L17;
        L19:
            r103 = false;
        L21:
            if (this.f344566b == null) goto L27;
            if (r103 == true) goto L28;
            View r106 = this.f344565a.f(this.itemView);
            this.f344570f = r106;
            if (r106 == null) goto L29;
            r106.setOnLongClickListener(new f(this, r100, r101));
            return;
        L29:
            return;
        L28:
            return;
        L27:
            return;
        L17:
            if (r105.c(r100, this.f344567c) != true) goto L19;
        L10:
            if (this.f344566b == null) goto L12;
        L13:
            View r107 = this.f344565a.i(this.itemView);
            this.f344569e = r107;
            e1.d(r107, new e(this, r100, r101));
            goto L14
        L12:
            if (r100.f471910d == null) goto L14;
        L5:
            if (r102.a(r100, this.f344567c) != true) goto L7;
            r104 = true;
            goto L8
        }

        public FlowFeedViewHolder(View r100, eb9.x r101, eb9.p r102, eb9.u r103) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            Intrinsics.checkNotNullParameter(r101, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
            Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
            this.f344565a = r101;
            this.f344566b = r102;
            this.f344567c = r103;
        }
    }

    public static final class a {
    }

    static {
    }

    public FlowFeedAdapter() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        w r101 = this.f344562a;
        Enum<?> r102 = getItem(r100).getType();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "cardType");
        Intrinsics.checkNotNullParameter(r102, "cardType");
        if (r101.f344640a.get(r102) != null) goto L5;
        Integer r103 = null;
    L12:
        if (r103 != null) goto L16;
        return -1;
    L16:
        return r103.intValue();
    L5:
        ConcurrentHashMap<Enum<?>, Integer> r104 = r101.f344641b;
        Integer r105 = r104.get(r102);
        if (r105 != null) goto L11;
        r105 = Integer.valueOf(r101.f344641b.size());
        Integer r106 = r104.putIfAbsent(r102, r105);
        if (r106 == null) goto L11;
        r105 = r106;
    L11:
        r103 = r105;
        goto L12
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
        int r101 = t.f344637a;
        t.c("adapter_attach", "adapter=" + t.e(this) + " rv=" + t.e(r100) + " items=" + getItemCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        int r101 = t.f344637a;
        t.c("adapter_detach", "adapter=" + t.e(this) + " rv=" + t.e(r100) + " items=" + getItemCount());
        super.onDetachedFromRecyclerView(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        FlowFeedViewHolder r101 = (FlowFeedViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewAttachedToWindow(r101);
        r101.f344565a.g(r101.itemView, r101.f344567c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        FlowFeedViewHolder r101 = (FlowFeedViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        r101.f344565a.c(r101.itemView, r101.f344567c);
        super.onViewDetachedFromWindow(r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        FlowFeedViewHolder r101 = (FlowFeedViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        r101.U3();
        r101.f344565a.d(r101.itemView, r101.f344567c);
        r101.f344568d = null;
        super.onViewRecycled(r101);
    }

    public FlowFeedAdapter(w r100, c r101) {
        k r102 = new k(r100);
        Intrinsics.checkNotNullParameter(r100, "registry");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "diffCallback");
        super(r102);
        this.f344562a = r100;
        this.f344563b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        FlowFeedViewHolder r102 = (FlowFeedViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        eb9.o<?> r103 = getItem(r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, BrowserDependency.UrlClickType.CARD);
        r102.f344568d = r103;
        r102.U3();
        r102.f344565a.e(r102.itemView, r103, r101, r102.f344567c);
        r102.T3(r103, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        w r102 = this.f344562a;
        Iterator<T> r103 = r102.f344641b.entrySet().iterator();
    L3:
        eb9.p r104 = null;
        if (r103.hasNext() == false) goto L14;
        Object r105 = r103.next();
        Integer r106 = (Integer) ((Map.Entry) r105).getValue();
        if (r106 != null) goto L9;
    L11:
        boolean r107 = false;
    L12:
        if (r107 == false) goto L3;
    L15:
        Map.Entry r108 = (Map.Entry) r105;
        if (r108 == null) goto L18;
        Enum r109 = (Enum) r108.getKey();
    L19:
        if (r109 == null) goto L21;
        eb9.w r110 = r102.f344640a.get(r109);
    L22:
        if (r110 == null) goto L25;
        eb9.x r111 = r110.b();
        if (r111 == null) goto L25;
    L26:
        View r112 = r111.b(r100);
        if (r110 == null) goto L30;
        r104 = r110.c();
    L30:
        return new FlowFeedViewHolder(r112, r111, r104, this.f344563b);
    L25:
        r111 = e0.f344613a;
        goto L26
    L21:
        r110 = null;
        goto L22
    L18:
        r109 = null;
        goto L19
    L9:
        if (r106.intValue() != r101) goto L11;
        r107 = true;
        goto L12
    L14:
        r105 = null;
        goto L15
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        FlowFeedViewHolder r103 = (FlowFeedViewHolder) r100;
        Intrinsics.checkNotNullParameter(r103, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        boolean r104 = true;
        if ((!r102.isEmpty()) == false) goto L17;
        List r105 = r102;
        if ((r105 instanceof Collection) == true) goto L7;
    L9:
        Iterator r106 = r105.iterator();
    L11:
        if (r106.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(r106.next(), "flow_feed_selection") == true) goto L11;
        r104 = false;
    L15:
        if (r104 == false) goto L17;
        eb9.o<?> r107 = getItem(r101);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r107, BrowserDependency.UrlClickType.CARD);
        r103.f344568d = r107;
        r103.U3();
        r103.f344565a.a(r103.itemView, r107, r101, r103.f344567c);
        r103.T3(r107, r101);
        return;
    L7:
        if (r105.isEmpty() == false) goto L9;
    L17:
        super.onBindViewHolder(r103, r101, r102);
    }
}
