package ef5;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class x implements gf5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f472514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CommentBean f472515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<CommentBean.CommentDetail> f472516c;

    public final String toString() {
        return "ItemPageDataChangedEvent(recyclerView=" + this.f472514a + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x(RecyclerView r100, CommentBean r101, List<? extends CommentBean.CommentDetail> r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "commentBean");
        Intrinsics.checkNotNullParameter(r102, "oldList");
        this.f472514a = r100;
        this.f472515b = r101;
        this.f472516c = r102;
    }
}
