package dw1;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder.SingleDrawTabViewHolder;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdk.viewmodel.SingleDrawViewModel;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends me.drakeet.multitype.b<e, SingleDrawTabViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SingleDrawViewModel f470304b;

    public c(SingleDrawViewModel r100) {
        this.f470304b = r100;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, e r101) {
        SingleDrawTabViewHolder r102 = (SingleDrawTabViewHolder) r100;
        e r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.f123839a.setText(r103.i());
        r102.f123840b.setOnClickListener(new d(r102, r103));
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new SingleDrawTabViewHolder(r100.inflate(R.layout.ttlive_feed_single_draw_tab_viewholder_layout, r101, false), this.f470304b);
    }
}
