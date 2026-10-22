package w62;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.model.k;
import com.bytedance.android.livesdk.interactivity.comment.input.view.LiveVideoCommentSearchVideoFooterViewHolder;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends me.drakeet.multitype.b<k, LiveVideoCommentSearchVideoFooterViewHolder> {
    public c() {
    }

    @Override // me.drakeet.multitype.b
    public final void e(RecyclerView.ViewHolder r100) {
        LiveVideoCommentSearchVideoFooterViewHolder r101 = (LiveVideoCommentSearchVideoFooterViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        if (r101.f135187c != 1) goto L6;
        r101.f135185a.b();
        return;
    }

    @Override // me.drakeet.multitype.b
    public final void f(RecyclerView.ViewHolder r100) {
        LiveVideoCommentSearchVideoFooterViewHolder r101 = (LiveVideoCommentSearchVideoFooterViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        if (r101.f135187c != 1) goto L6;
        r101.f135185a.c();
        return;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, k r101) {
        LiveVideoCommentSearchVideoFooterViewHolder r102 = (LiveVideoCommentSearchVideoFooterViewHolder) r100;
        k r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, "data");
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "data");
        UtilityKotlinExtentionsKt.t(r102.f135185a);
        UtilityKotlinExtentionsKt.t(r102.f135186b);
        int r104 = r103.f106958a;
        r102.f135187c = r104;
        if (r104 != 1) goto L6;
        UtilityKotlinExtentionsKt.w(r102.f135185a);
    L6:
        if (r102.f135187c != 2) goto L9;
        UtilityKotlinExtentionsKt.w(r102.f135186b);
        return;
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new LiveVideoCommentSearchVideoFooterViewHolder(r100.inflate(R.layout.ttlive_video_comment_search_footer_item_layout, r101, false));
    }
}
