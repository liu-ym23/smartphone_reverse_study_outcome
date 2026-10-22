package ef5;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s implements gf5.c {
    public final int a;
    public final List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> b;
    public final kf5.b c;
    public final CommentInputRequest d;
    public final ze5.c e;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "InputImageChangedEvent(changeType=" + this.a + ", imageList=" + this.b.size() + ')';
    }

    public /* synthetic */ s(int r7, List r8, kf5.b r9) {
        this(r7, r8, r9, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s(int r2, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r3, kf5.b r4, CommentInputRequest r5, ze5.c r6) {
        Intrinsics.checkNotNullParameter(r3, "imageList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
