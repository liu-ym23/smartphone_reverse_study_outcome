package com.larus.dora.o.impl.simul;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/dora/o/impl/simul/OSimulSubtitleAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/avlink/api/DoraSimulSubtitleItem;", "Lcom/larus/dora/o/impl/simul/OSimulSubtitleAdapter$SubtitleViewHolder;", "isBottomPanel", "", "<init>", "(Z)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "Companion", "SubtitleViewHolder", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OSimulSubtitleAdapter extends ListAdapter<w88.l, SubtitleViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final OSimulSubtitleAdapter$Companion$DIFF$1 f338873b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f338874a;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/dora/o/impl/simul/OSimulSubtitleAdapter$SubtitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "isBottomPanel", "", "<init>", "(Landroid/view/View;Z)V", "originalView", "Landroid/widget/TextView;", "translationView", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/larus/avlink/api/DoraSimulSubtitleItem;", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SubtitleViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f338875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f338876b;

        public SubtitleViewHolder(View r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            TextView r102 = (TextView) r100.findViewById(R.id.subtitle_original);
            this.f338875a = r102;
            TextView r103 = (TextView) r100.findViewById(R.id.subtitle_translation);
            this.f338876b = r103;
            r102.setTextSize(2, 12.0f);
            r103.setTextSize(2, 16.0f);
            r103.setTypeface(null, 0);
            Context r104 = r100.getContext();
            if (r101 == false) goto L5;
            int r105 = R.color.dora_o_text_primary;
        L6:
            r103.setTextColor(ContextCompat.getColor(r104, r105));
            return;
        L5:
            r105 = R.color.dora_o_day_selected_bg;
            goto L6
        }
    }

    public static final class a {
    }

    public OSimulSubtitleAdapter() {
        this(false);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.dora.o.impl.simul.OSimulSubtitleAdapter$Companion$DIFF$1] */
    static {
        f338873b = new OSimulSubtitleAdapter$Companion$DIFF$1();
    }

    public OSimulSubtitleAdapter(boolean r100) {
        super(f338873b);
        this.f338874a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        SubtitleViewHolder r102 = (SubtitleViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        w88.l r103 = getItem(r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        boolean r104 = true;
        if (r103.f558691b.length() != 0) goto L5;
        boolean r105 = true;
    L7:
        if (r105 == false) goto L9;
        r102.f338875a.setVisibility(8);
    L11:
        if (r103.f558692c.length() == 0) goto L14;
        r104 = false;
    L14:
        if (r104 == false) goto L16;
        r102.f338876b.setVisibility(8);
        return;
    L16:
        r102.f338876b.setVisibility(0);
        r102.f338876b.setText(r103.f558692c);
        return;
    L9:
        r102.f338875a.setVisibility(0);
        r102.f338875a.setText(r103.f558691b);
        goto L11
    L5:
        r105 = false;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.dora_o_item_simul_subtitle, r100, false);
        Intrinsics.checkNotNull(r102);
        return new SubtitleViewHolder(r102, this.f338874a);
    }
}
