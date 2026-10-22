package com.larus.connector;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.utils.e1;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0018\u0019\u001a\u001bB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/connector/ConnectorAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/connector/ConnectorListItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "clickListener", "Lcom/larus/connector/ConnectorItemClickListener;", "<init>", "(Lcom/larus/connector/ConnectorItemClickListener;)V", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "onViewAttachedToWindow", "onViewRecycled", "bindIcon", "Lcom/larus/connector/ConnectorAdapter$ConnectorViewHolder;", "iconUrl", "", "ConnectorViewHolder", "LoadingViewHolder", "ConnectorDiffCallback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConnectorAdapter extends ListAdapter<o, RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f330147b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f330148a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/connector/ConnectorAdapter$ConnectorDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/larus/connector/ConnectorListItem;", "<init>", "()V", "areItemsTheSame", "", "oldItem", "newItem", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ConnectorDiffCallback extends DiffUtil.ItemCallback<o> {
        public ConnectorDiffCallback() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final boolean areContentsTheSame(o r100, o r101) {
            o r102 = r100;
            o r103 = r101;
            Intrinsics.checkNotNullParameter(r102, "oldItem");
            Intrinsics.checkNotNullParameter(r103, "newItem");
            return Intrinsics.areEqual(r102, r103);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final boolean areItemsTheSame(o r100, o r101) {
            o r102 = r100;
            o r103 = r101;
            Intrinsics.checkNotNullParameter(r102, "oldItem");
            Intrinsics.checkNotNullParameter(r103, "newItem");
            if ((r102 instanceof o.a) == false) goto L8;
            if ((r103 instanceof o.a) == false) goto L8;
            return Intrinsics.areEqual(((o.a) r102).f330218a.f330210a, ((o.a) r103).f330218a.f330210a);
        L8:
            if (r102.getClass() != r103.getClass()) goto L10;
            return true;
        L10:
            return false;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/larus/connector/ConnectorAdapter$ConnectorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "ivIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getIvIcon", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "iconBorders", "", "tvName", "Landroid/widget/TextView;", "getTvName", "()Landroid/widget/TextView;", "switch", "Lcom/larus/bmhome/view/item/CustomSwitchCompat;", "getSwitch", "()Lcom/larus/bmhome/view/item/CustomSwitchCompat;", "connectAction", "getConnectAction", "()Landroid/view/View;", "vDivider", "getVDivider", "boundIconUrl", "", "getBoundIconUrl", "()Ljava/lang/String;", "setBoundIconUrl", "(Ljava/lang/String;)V", "setIconBordersVisible", "", "visible", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ConnectorViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SimpleDraweeView f330149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<View> f330150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f330151c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final CustomSwitchCompat f330152d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f330153e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final View f330154f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f330155g;

        public ConnectorViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f330149a = (SimpleDraweeView) r100.findViewById(R.id.item_left_icon);
            this.f330150b = CollectionsKt.listOf(new View[]{r100.findViewById(R.id.item_left_icon_outer_border), r100.findViewById(R.id.item_left_icon_border)});
            this.f330151c = (TextView) r100.findViewById(R.id.item_main_name);
            this.f330152d = (CustomSwitchCompat) r100.findViewById(R.id.item_connect_switch);
            this.f330153e = r100.findViewById(R.id.item_connect_action);
            this.f330154f = r100.findViewById(R.id.item_divider);
        }

        public final void T3(boolean r100) {
            if (r100 == false) goto L4;
            int r101 = 0;
        L5:
            Iterator<T> r102 = this.f330150b.iterator();
        L7:
            if (r102.hasNext() == false) goto L9;
            ((View) r102.next()).setVisibility(r101);
            goto L7
        L9:
            return;
        L4:
            r101 = 8;
            goto L5
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/connector/ConnectorAdapter$LoadingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LoadingViewHolder extends RecyclerView.ViewHolder {
        public LoadingViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
        }
    }

    public static final class a {
    }

    static {
    }

    public ConnectorAdapter(ConnectorFragment.d r100) {
        Intrinsics.checkNotNullParameter(r100, "clickListener");
        super(new ConnectorDiffCallback());
        this.f330148a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        o r101 = getItem(r100);
        if ((r101 instanceof o.a) == false) goto L6;
        return 0;
    L6:
        if (Intrinsics.areEqual(r101, o.b.f330220a) == false) goto L10;
        return 1;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewAttachedToWindow(r100);
        int r101 = r100.getAdapterPosition();
        if (r101 != (-1)) goto L5;
        return;
    L5:
        o r102 = getItem(r101);
        if ((r102 instanceof o.a) == false) goto L8;
        o.a r103 = (o.a) r102;
    L9:
        if (r103 != null) goto L11;
        return;
    L11:
        this.f330148a.b(r103.f330218a);
        return;
    L8:
        r103 = null;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof ConnectorViewHolder) == false) goto L5;
        ConnectorViewHolder r101 = (ConnectorViewHolder) r100;
        r101.f330155g = null;
        r101.T3(false);
    L5:
        super.onViewRecycled(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(final RecyclerView.ViewHolder r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        final o r112 = getItem(r111);
        if ((r110 instanceof LoadingViewHolder) == false) goto L5;
    L21:
        r110.itemView.setOnClickListener(null);
        return;
    L5:
        if ((r112 instanceof o.a) == false) goto L21;
        ConnectorViewHolder r100 = (ConnectorViewHolder) r110;
        o.a r101 = (o.a) r112;
        final n r102 = r101.f330218a;
        r100.f330152d.setOnCheckedChangeListener(null);
        r100.f330152d.setOnClickListener(null);
        r110.itemView.setOnClickListener(null);
        final ConnectorViewHolder r103 = (ConnectorViewHolder) r110;
        r103.f330151c.setText(r102.f330211b);
        final String r104 = r102.f330213d;
        r103.f330155g = r104;
        r103.T3(false);
        ImageLoaderKt.y(r103.f330149a, r104, "task_connector_icon", new d(r103, r104), 4);
        if (r102.f330214e == 1) goto L10;
    L12:
        boolean r105 = false;
    L14:
        if (r105 == false) goto L16;
        r103.f330152d.setVisibility(0);
        r103.f330153e.setVisibility(8);
        r103.f330152d.setChecked(r102.f330216g);
        r103.f330152d.setEnabled(!r101.f330219b);
        r103.f330152d.setClickable(!r101.f330219b);
        r103.f330152d.setFocusable(!r101.f330219b);
        r103.f330152d.setOnCheckedChangeListener(new com.larus.connector.a(this, r102));
        e1.d(r110.itemView, new b(r112, r110));
    L17:
        r103.f330154f.setVisibility(0);
        if (r110.itemView.isAttachedToWindow() == false) goto L23;
        this.f330148a.b(r102);
        return;
    L23:
        return;
    L16:
        r103.f330152d.setVisibility(8);
        r103.f330153e.setVisibility(0);
        e1.d(r110.itemView, new c(this, r102));
        goto L17
    L10:
        if (r102.f330215f != 1) goto L12;
        r105 = true;
        goto L14
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        LayoutInflater r102 = LayoutInflater.from(r100.getContext());
        if (r101 != 1) goto L6;
        return new LoadingViewHolder(r102.inflate(R.layout.larus_item_task_project_loading, r100, false));
    L6:
        return new ConnectorViewHolder(r102.inflate(R.layout.larus_item_connector, r100, false));
    }
}
