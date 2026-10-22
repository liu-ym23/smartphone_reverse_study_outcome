package com.story.ai.biz.comment.adapter;

import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.story.ai.biz.comment.model.CommentSection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class u extends dnc.a<CommentSection> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f459837a;

    @Override // dnc.a
    public final int c() {
        return R.layout.larus_comment_fail_item_layout;
    }

    @Override // dnc.a
    public final int b() {
        return CommentSection.CommentItemType.FAIL.ordinal();
    }

    public u(k r100) {
        Intrinsics.checkNotNullParameter(r100, "retryClick");
        this.f459837a = r100;
    }

    @Override // dnc.a
    public final void a(RecyclerView.ViewHolder r100, CommentSection r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, "holder");
        LinearLayout r103 = (LinearLayout) r100.itemView.findViewById(R.id.ll_retry_view);
        if (r103 == null) goto L6;
        e1.x(r103);
        e1.d(r103, new t(this));
        return;
    }
}
