package y31;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.PKNoMutualFollowedViewHolder;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class m extends me.drakeet.multitype.b<a, PKNoMutualFollowedViewHolder> {

    public static final class a {
        public a() {
        }
    }

    public m() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        PKNoMutualFollowedViewHolder r102 = (PKNoMutualFollowedViewHolder) r100;
        a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r103.getClass();
        r102.f96189a.setText(null);
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new PKNoMutualFollowedViewHolder(r100.inflate(R.layout.ttlive_item_interact_pk_no_mutual_followed_user, r101, false));
    }
}
