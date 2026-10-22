package ef5;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.extension.events.ReactionCacheActionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b0 implements gf5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReactionCacheActionType f472441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f472442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f472443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f472444d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f472445e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f472446f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f472447g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CommentBean.CommentDetail f472448h;

    public final String toString() {
        return "ReactionCacheActionEvent(action=" + this.f472441a + ", replyId=" + this.f472443c + ", reactionKey=" + this.f472444d + ", actionId=" + this.f472445e + ", userId=" + this.f472446f + ", item=" + this.f472448h + ')';
    }

    public b0(ReactionCacheActionType r100, String r101, String r102, String r103, String r104, String r105, String r106, CommentBean.CommentDetail r107) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "commentId");
        Intrinsics.checkNotNullParameter(r102, "replyId");
        Intrinsics.checkNotNullParameter(r103, "reactionKey");
        Intrinsics.checkNotNullParameter(r104, "actionId");
        this.f472441a = r100;
        this.f472442b = r101;
        this.f472443c = r102;
        this.f472444d = r103;
        this.f472445e = r104;
        this.f472446f = r105;
        this.f472447g = r106;
        this.f472448h = r107;
    }
}
