package mx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.simple.SimpleViewHolder;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f extends me.drakeet.multitype.b<e, RecyclerView.ViewHolder> {
    public f() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, e r101) {
        e r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        View r103 = r100.itemView;
        r103.setBackgroundColor(s1.h(r102.f516138a));
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L13;
        r104.height = s1.f(r102.f516139b);
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        ViewGroup.LayoutParams r105 = null;
    L8:
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        if (r106 == null) goto L11;
        int r107 = s1.f(r102.f516140c);
        r106.leftMargin = r107;
        r106.rightMargin = r107;
    L11:
        r103.setLayoutParams(r104);
        return;
    L7:
        r105 = r104;
        goto L8
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new SimpleViewHolder(r100.inflate(R.layout.ttlive_item_horizon_divider, r101, false));
    }
}
