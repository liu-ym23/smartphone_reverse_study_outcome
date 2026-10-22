package com.larus.community.impl.detail.comment;

import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.community.impl.detail.b0;
import com.larus.nova.R;
import com.larus.platform.model.comment.api.CommentItemCustomType;
import com.larus.utils.e1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class f implements rq9.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f329256a;

    @Override // rq9.e
    public final int a() {
        return R.layout.larus_creation_detail_comment_fail_item_layout;
    }

    @Override // rq9.e
    public final CommentItemCustomType c() {
        return CommentItemCustomType.FAIL;
    }

    public f(b0 r100) {
        Intrinsics.checkNotNullParameter(r100, "retryClick");
        this.f329256a = r100;
    }

    @Override // rq9.e
    public final void b(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        LinearLayout r101 = (LinearLayout) r100.itemView.findViewById(R.id.ll_retry_view);
        if (r101 == null) goto L6;
        e1.x(r101);
        e1.d(r101, new e(this));
        return;
    }
}
