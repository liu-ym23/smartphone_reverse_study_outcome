package erb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.nova.R;
import com.ss.android.lark.mention.base.impl.atselector.IItemContainer;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.bean.BottomSearchTipBean;
import com.ss.android.lark.mention.base.impl.atselector.view.adapter.holder.BottomSearchTipViewHolder;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements drb.a<BottomSearchTipBean, BottomSearchTipViewHolder> {
    public f(IItemContainer r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
    }

    @Override // drb.a
    public final /* bridge */ /* synthetic */ long a(BottomSearchTipBean r100) {
        return -1;
    }

    @Override // drb.a
    public final RecyclerView.ViewHolder b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.group_member_item_bottom_search_tip, r100, false);
        Intrinsics.checkNotNull(r101);
        return new BottomSearchTipViewHolder(r101);
    }

    @Override // drb.a
    public final /* bridge */ /* synthetic */ void c(RecyclerView.ViewHolder r100, BaseAtBean r101, int r102) {
        BottomSearchTipViewHolder r103 = (BottomSearchTipViewHolder) r100;
        BottomSearchTipBean r104 = (BottomSearchTipBean) r101;
    }

    @Override // drb.a
    public final void d(RecyclerView.ViewHolder r100, BaseAtBean r101, int r102, List r103) {
        BottomSearchTipViewHolder r104 = (BottomSearchTipViewHolder) r100;
        BottomSearchTipBean r105 = (BottomSearchTipBean) r101;
        Intrinsics.checkNotNullParameter(r103, "payloads");
    }
}
