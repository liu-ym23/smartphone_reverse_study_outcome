package com.bytedance.android.shopping.commentv3.uitree.list.rvkit.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.commentv3.base.c;
import com.bytedance.android.shopping.commentv3.view.CommentLynxView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/uitree/list/rvkit/viewholder/BaseLynxViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BaseLynxViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int c = 0;
    public final CommentLynxView a;
    public final c b;

    public static final class a {
    }

    static {
    }

    public BaseLynxViewHolder(View r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.b = r3;
        this.a = (CommentLynxView) r2.findViewById(2131379280);
    }
}
