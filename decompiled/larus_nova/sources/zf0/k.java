package zf0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.linkpanel.viewholder.SimpleGuestApplyFootHolder;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class k extends me.drakeet.multitype.b<d, SimpleGuestApplyFootHolder> {
    public k() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, d r101) {
        SimpleGuestApplyFootHolder r102 = (SimpleGuestApplyFootHolder) r100;
        d r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        int r104 = r103.getType();
        View r105 = r102.itemView;
        if (r105 == null) goto L44;
        TextView r106 = (TextView) r105;
        switch(r104) {
            case 0: goto L37;
            case 1: goto L32;
            case 2: goto L27;
            case 3: goto L22;
            case 4: goto L17;
            case 5: goto L12;
            case 6: goto L7;
            default: goto L51;
        };
    L7:
        r102.T3(s1.f(60.0f));
        View r107 = r102.itemView;
        if (r107 == null) goto L11;
        ((TextView) r107).setText(R.string.ttlive_normal_queue_empty_anchor_tips);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L12:
        r102.T3(-1);
        View r108 = r102.itemView;
        if (r108 == null) goto L16;
        ((TextView) r108).setText(R.string.ttlive_normal_queue_empty_anchor_tips);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L17:
        r102.T3(s1.f(60.0f));
        View r109 = r102.itemView;
        if (r109 == null) goto L21;
        ((TextView) r109).setText(R.string.ttlive_paid_queue_empty_anchor_tips);
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L22:
        r102.T3(-1);
        View r110 = r102.itemView;
        if (r110 == null) goto L26;
        ((TextView) r110).setText(R.string.ttlive_paid_queue_empty_anchor_tips);
        return;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L27:
        r102.T3(-1);
        View r111 = r102.itemView;
        if (r111 == null) goto L31;
        ((TextView) r111).setText(R.string.ttlive_paid_queue_empty_audience_tips);
        return;
    L31:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L32:
        r102.T3(s1.f(60.0f));
        View r112 = r102.itemView;
        if (r112 == null) goto L36;
        ((TextView) r112).setText(R.string.ttlive_interact_rivals_search_result_nomore);
        return;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L37:
        r102.T3(s1.f(60.0f));
        View r113 = r102.itemView;
        if (r113 == null) goto L41;
        ((TextView) r113).setText(R.string.ttlive_interact_rivals_search_result_load_more);
        return;
    L41:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L51:
        return;
    L44:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new SimpleGuestApplyFootHolder(r100.inflate(R.layout.ttlive_item_common_apply_list_foot, r101, false));
    }
}
