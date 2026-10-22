package zf0;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.linkpanel.viewholder.EmptyInviteAudienceViewHolder;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c extends me.drakeet.multitype.b<a, EmptyInviteAudienceViewHolder> {

    public static final class a {
        public a() {
        }
    }

    public c() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        Intrinsics.checkNotNullParameter((EmptyInviteAudienceViewHolder) r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new EmptyInviteAudienceViewHolder(r100.inflate(R.layout.ttlive_item_interact_invite_empty_audience, r101, false));
    }
}
