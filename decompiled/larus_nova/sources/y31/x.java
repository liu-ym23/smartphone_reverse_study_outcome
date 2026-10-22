package y31;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.RevLinkTitleViewHolder;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class x extends me.drakeet.multitype.b<s.a, RevLinkTitleViewHolder> {
    public x() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, s.a r101) {
        RevLinkTitleViewHolder r102 = (RevLinkTitleViewHolder) r100;
        s.a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        CharSequence r104 = r103.f565821a;
        if (r104 == null) goto L6;
        String r105 = r104.toString();
        if (r105 == null) goto L6;
    L7:
        r102.f96279b = r105;
        ((TextView) r102.f96278a.findViewById(R.id.title)).setVisibility(0);
        ((TextView) r102.f96278a.findViewById(R.id.title)).setText(r103.f565821a);
        return;
    L6:
        r105 = "";
        goto L7
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new RevLinkTitleViewHolder(r100.inflate(R.layout.ttlive_item_rev_link_main_title, r101, false));
    }
}
