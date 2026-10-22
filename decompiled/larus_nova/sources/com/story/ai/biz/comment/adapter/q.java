package com.story.ai.biz.comment.adapter;

import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.nova.R;
import com.story.ai.biz.comment.model.CommentSection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class q extends dnc.a<CommentSection> {

    public static final class a {
    }

    static {
    }

    @Override // dnc.a
    public final int c() {
        return R.layout.larus_comment_empty_item_layout;
    }

    @Override // dnc.a
    public final int b() {
        return CommentSection.CommentItemType.EMPTY.ordinal();
    }

    public q() {
    }

    @Override // dnc.a
    public final void a(RecyclerView.ViewHolder r100, CommentSection r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, "holder");
        LinearLayout r103 = (LinearLayout) r100.itemView.findViewById(R.id.ll_empty_view);
        if (r103 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r103.getTag(), "done") == true) goto L10;
        AlphaAnimation r104 = new AlphaAnimation(0.0f, 1.0f);
        r104.setDuration(1000);
        r104.setAnimationListener(new r(r103));
        r103.startAnimation(r104);
        r103.setTag("done");
        return;
    }
}
