package zf0;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.liveinteract.linkpanel.viewholder.GuestApplyPaidQueueEmptyViewHolder;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e extends me.drakeet.multitype.b<a, GuestApplyPaidQueueEmptyViewHolder> {

    public static final class a {
        public a() {
        }
    }

    public e() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        Intrinsics.checkNotNullParameter((GuestApplyPaidQueueEmptyViewHolder) r100, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new GuestApplyPaidQueueEmptyViewHolder(r100.inflate(R.layout.ttlive_item_paid_queue_empty_layout, r101, false));
    }
}
