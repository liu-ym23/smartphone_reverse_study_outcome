package ef5;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.extension.events.ReactionCacheActionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b0 implements gf5.c {
    public final ReactionCacheActionType a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final CommentBean.CommentDetail h;

    public final String toString() {
        return "ReactionCacheActionEvent(action=" + this.a + ", replyId=" + this.c + ", reactionKey=" + this.d + ", actionId=" + this.e + ", userId=" + this.f + ", item=" + this.h + ')';
    }

    public b0(ReactionCacheActionType r2, String r3, String r4, String r5, String r6, String r7, String r8, CommentBean.CommentDetail r9) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "commentId");
        Intrinsics.checkNotNullParameter(r4, "replyId");
        Intrinsics.checkNotNullParameter(r5, "reactionKey");
        Intrinsics.checkNotNullParameter(r6, "actionId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
