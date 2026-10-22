package yk0;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.livepkaudience.dialog.viewholder.PKAudienceSearchFootViewHolder;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.b;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends b<C8347a, PKAudienceSearchFootViewHolder> {

    /* JADX INFO: renamed from: yk0.a$a, reason: collision with other inner class name */
    public static final class C8347a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f568118a;

        public C8347a() {
        }

        public final int getType() {
            return this.f568118a;
        }
    }

    public a() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, C8347a r101) {
        PKAudienceSearchFootViewHolder r102 = (PKAudienceSearchFootViewHolder) r100;
        C8347a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        int r104 = r103.getType();
        if (r104 != 0) goto L6;
        r102.f81852a.setText(R.string.ttlive_pk_rivals_search_result_load_more);
        return;
    L6:
        if (r104 != 1) goto L8;
        r102.f81852a.setText(R.string.ttlive_pk_rivals_search_result_nomore);
        return;
    L8:
        r102.getClass();
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new PKAudienceSearchFootViewHolder(r100.inflate(R.layout.ttlive_item_pk_audience_search_foot, r101, false));
    }
}
