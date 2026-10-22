package q21;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder.AnchorLinkFootViewHolder;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b extends me.drakeet.multitype.b<a, AnchorLinkFootViewHolder> {

    public static final class a {
        public a() {
        }
    }

    public b() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        AnchorLinkFootViewHolder r102 = (AnchorLinkFootViewHolder) r100;
        a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r103.getClass();
        r102.f93729a.setText(null);
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new AnchorLinkFootViewHolder(r100.inflate(R.layout.ttlive_item_anchor_link_foot, r101, false));
    }
}
