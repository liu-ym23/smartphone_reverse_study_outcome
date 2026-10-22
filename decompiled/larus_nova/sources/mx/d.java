package mx;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.widget.simple.SimpleViewHolder;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d extends me.drakeet.multitype.b<Object, RecyclerView.ViewHolder> {
    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
    }

    public d() {
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new SimpleViewHolder(r100.inflate(R.layout.ttlive_item_horizon_divider_slim_socks, r101, false));
    }
}
