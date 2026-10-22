package ef5;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q implements gf5.c {
    public final String a;
    public final List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> b;
    public final boolean c;
    public final kf5.b d;

    public final String toString() {
        return "InputDismissedEvent(content=" + this.a.length() + ", imageList=" + this.b.size() + ", bySend=" + this.c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(String r2, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r3, boolean r4, kf5.b r5) {
        Intrinsics.checkNotNullParameter(r2, "content");
        Intrinsics.checkNotNullParameter(r3, "imageList");
        Intrinsics.checkNotNullParameter(r5, "inputComment");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
