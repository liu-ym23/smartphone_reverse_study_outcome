package ef5;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x implements gf5.c {
    public final RecyclerView a;
    public final CommentBean b;
    public final List<CommentBean.CommentDetail> c;

    public final String toString() {
        return "ItemPageDataChangedEvent(recyclerView=" + this.a + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x(RecyclerView r2, CommentBean r3, List<? extends CommentBean.CommentDetail> r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "commentBean");
        Intrinsics.checkNotNullParameter(r4, "oldList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
