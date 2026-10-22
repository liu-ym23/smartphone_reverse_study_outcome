package q21;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.viewholder.AnchorLinkTitleViewHolder;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f extends me.drakeet.multitype.b<a, AnchorLinkTitleViewHolder> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f531364a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CharSequence f531365b;

        public a() {
        }
    }

    public f() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        AnchorLinkTitleViewHolder r102 = (AnchorLinkTitleViewHolder) r100;
        a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        CharSequence r104 = r103.f531365b;
        if (r104 == null) goto L5;
        r102.f93740a.setText(r104);
        return;
    L5:
        r102.f93740a.setText(r103.f531364a);
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new AnchorLinkTitleViewHolder(r100.inflate(R.layout.ttlive_item_anchor_link_title, r101, false));
    }
}
