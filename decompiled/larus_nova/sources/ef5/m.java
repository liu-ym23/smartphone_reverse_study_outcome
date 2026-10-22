package ef5;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class m implements gf5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<CommentBean> f472483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f472484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f472485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<CommentBean> f472486d;

    public /* synthetic */ m() {
        throw null;
    }

    public final String toString() {
        return "DataUpdatedEvent(data=" + this.f472483a + ", position=" + this.f472484b + ", lastPosition=" + this.f472485c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(List<? extends CommentBean> r100, Integer r101, Integer r102, List<? extends CommentBean> r103) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f472483a = r100;
        this.f472484b = r101;
        this.f472485c = r102;
        this.f472486d = r103;
    }
}
