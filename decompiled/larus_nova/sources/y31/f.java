package y31;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.PKActEmptyViewHolder;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f extends me.drakeet.multitype.b<a, PKActEmptyViewHolder> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f565760a;

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f565760a = r100;
        }
    }

    public f() {
    }

    @Override // me.drakeet.multitype.b
    public final void g(RecyclerView.ViewHolder r100) {
        PKActEmptyViewHolder r101 = (PKActEmptyViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        r101.getClass();
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        PKActEmptyViewHolder r102 = (PKActEmptyViewHolder) r100;
        a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        TextView r104 = (TextView) r102.itemView.findViewById(R.id.empty_text);
        if (r103 == null) goto L5;
        String r105 = r103.f565760a;
    L6:
        r104.setText(r105);
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new PKActEmptyViewHolder(r100.inflate(R.layout.ttlive_item_pk_flex_activity_empty_view, r101, false));
    }
}
