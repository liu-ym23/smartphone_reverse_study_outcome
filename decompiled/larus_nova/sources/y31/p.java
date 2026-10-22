package y31;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.PKRivalsSearchFootViewHolder;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class p extends me.drakeet.multitype.b<a, PKRivalsSearchFootViewHolder> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f565813a;

        public a() {
        }

        public final int getType() {
            return this.f565813a;
        }
    }

    public p() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        PKRivalsSearchFootViewHolder r102 = (PKRivalsSearchFootViewHolder) r100;
        a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        int r104 = r103.getType();
        if (r104 != 0) goto L6;
        r102.f96246a.setText(R.string.ttlive_pk_rivals_search_result_load_more);
        return;
    L6:
        if (r104 != 1) goto L8;
        r102.f96246a.setText(R.string.ttlive_pk_rivals_search_result_nomore);
        return;
    L8:
        r102.getClass();
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new PKRivalsSearchFootViewHolder(r100.inflate(R.layout.ttlive_item_pk_rival_search_foot, r101, false));
    }
}
