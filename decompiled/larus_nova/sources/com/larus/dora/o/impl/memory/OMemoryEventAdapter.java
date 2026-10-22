package com.larus.dora.o.impl.memory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001c\u001d\u001eB5\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u000f\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/dora/o/impl/memory/OMemoryEventAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onEventClick", "Lkotlin/Function1;", "Lcom/larus/dora/o/impl/memory/OMemoryEvent;", "", "onEventLongPress", "Lkotlin/Function2;", "Landroid/view/View;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "items", "", "Lcom/larus/dora/o/impl/memory/OMemoryListItem;", "submitList", "newItems", "", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "Companion", "GroupHolder", "EventHolder", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OMemoryEventAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<n, Unit> f338737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<n, View, Unit> f338738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b0> f338739c;

    public static final class a {
    }

    public final class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f338740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f338741b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f338742c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ OMemoryEventAdapter f338743d;

        public b(OMemoryEventAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "view");
            this.f338743d = r100;
            super(r101);
            this.f338740a = (TextView) r101.findViewById(R.id.memory_event_type);
            this.f338741b = (TextView) r101.findViewById(R.id.memory_event_title);
            this.f338742c = (TextView) r101.findViewById(R.id.memory_event_content);
        }
    }

    public static final class c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OSectionTitleBar f338744a;

        public c(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f338744a = (OSectionTitleBar) r100.findViewById(R.id.memory_event_group_title);
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f338739c).size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return !(ListProtector.get(this.f338739c, r100) instanceof z) ? 1 : 0;
    }

    public OMemoryEventAdapter(s r100, t r101) {
        Intrinsics.checkNotNullParameter(r100, "onEventClick");
        Intrinsics.checkNotNullParameter(r101, "onEventLongPress");
        this.f338737a = r100;
        this.f338738b = r101;
        this.f338739c = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        b0 r102 = (b0) ListProtector.get(this.f338739c, r101);
        String r103 = "";
        if ((r102 instanceof z) == false) goto L10;
        c r104 = (c) r100;
        z r105 = (z) r102;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, MapController.ITEM_LAYER_TAG);
        OSectionTitleBar r106 = r104.f338744a;
        String r107 = r105.f338840a;
        if (r107 == null) goto L8;
        r103 = r107;
    L8:
        r106.setTitleText(r103);
        r104.f338744a.setTitleTextSize(12.0f);
        return;
    L10:
        if ((r102 instanceof n) == false) goto L43;
        final b r108 = (b) r100;
        final n r109 = (n) r102;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r109, MapController.ITEM_LAYER_TAG);
        TextView r110 = r108.f338741b;
        String r111 = r109.e();
        if (r111 != null) goto L14;
        r111 = "";
    L14:
        r110.setText(r111);
        TextView r112 = r108.f338742c;
        String r113 = r109.a();
        if (r113 != null) goto L17;
        r113 = "";
    L17:
        r112.setText(r113);
        TextView r114 = r108.f338742c;
        String r115 = r109.a();
        boolean r116 = true;
        int r117 = 0;
        if (r115 != null) goto L20;
    L23:
        boolean r118 = true;
    L25:
        if (r118 == false) goto L27;
        int r119 = 8;
    L28:
        r114.setVisibility(r119);
        TextView r120 = r108.f338740a;
        String r121 = r109.getType();
        if (r121 == null) goto L32;
        r103 = r121;
    L32:
        r120.setText(r103);
        TextView r122 = r108.f338740a;
        String r123 = r109.getType();
        if (r123 != null) goto L35;
    L38:
        if (r116 == false) goto L40;
        r117 = 8;
    L40:
        r122.setVisibility(r117);
        View r124 = r108.itemView;
        final OMemoryEventAdapter r125 = r108.f338743d;
        r124.setOnClickListener(new o(r125, r109));
        View r126 = r108.itemView;
        final OMemoryEventAdapter r127 = r108.f338743d;
        r126.setOnLongClickListener(new p(r127, r109, r108));
        return;
    L35:
        if (r123.length() == 0) goto L38;
        r116 = false;
        goto L38
    L27:
        r119 = 0;
        goto L28
    L20:
        if (r115.length() == 0) goto L23;
        r118 = false;
        goto L25
    L43:
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        LayoutInflater r102 = LayoutInflater.from(r100.getContext());
        if (r101 != 0) goto L6;
        return new c(r102.inflate(R.layout.dora_o_item_memory_event_group, r100, false));
    L6:
        return new b(this, r102.inflate(R.layout.dora_o_item_memory_event, r100, false));
    }
}
