package yp0;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.grouptitle.AnchorShelfDisplayGroupTitleItemViewHolder;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends me.drakeet.multitype.b<b, AnchorShelfDisplayGroupTitleItemViewHolder> {
    public a() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, b r101) {
        AnchorShelfDisplayGroupTitleItemViewHolder r102 = (AnchorShelfDisplayGroupTitleItemViewHolder) r100;
        b r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "vh");
        Intrinsics.checkNotNullParameter(r103, "groupTitle");
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "groupTitle");
        ViewGroup.LayoutParams r104 = r102.itemView.getLayoutParams();
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r104 = null;
    L5:
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        if (r105 == null) goto L10;
        int r106 = r105.topMargin;
        int r107 = r103.f568697b;
        if (r106 == r107) goto L10;
        r105.topMargin = r107;
        r102.itemView.setLayoutParams(r105);
    L10:
        r102.f84552a.setText(r103.f568696a);
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new AnchorShelfDisplayGroupTitleItemViewHolder(r100.inflate(R.layout.ttlive_miniapp_shelf_page_anchor_group_title, r101, false));
    }
}
