package ef5;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.extension.events.CardAdapterActionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements gf5.c {
    public final CardAdapterActionType a;
    public final RecyclerView b;
    public final RecyclerView.ViewHolder c;
    public final CommentBean.CommentDetail d;

    public final String toString() {
        return "CardAdapterActionEvent(recyclerView=" + this.b + ", holder=" + this.c + ", item=" + this.d + ')';
    }

    public b(CardAdapterActionType r2, RecyclerView r3, RecyclerView.ViewHolder r4, CommentBean.CommentDetail r5) {
        Intrinsics.checkNotNullParameter(r2, "actionType");
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
