package f20;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.AbsOpenFeatureTabListItemViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class g<T, V extends AbsOpenFeatureTabListItemViewHolder<T>> implements a<T, V> {
    public g() {
    }

    public void b(V r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        r100.T3(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f20.a
    public /* bridge */ /* synthetic */ void d(RecyclerView.ViewHolder r100, Object r101) {
        b((AbsOpenFeatureTabListItemViewHolder) r100, r101);
    }
}
