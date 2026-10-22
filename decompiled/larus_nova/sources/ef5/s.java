package ef5;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class s implements gf5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f472499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> f472500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kf5.b f472501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommentInputRequest f472502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ze5.c f472503e;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "InputImageChangedEvent(changeType=" + this.f472499a + ", imageList=" + this.f472500b.size() + ')';
    }

    public /* synthetic */ s(int r100, List r101, kf5.b r102) {
        this(r100, r101, r102, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s(int r100, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r101, kf5.b r102, CommentInputRequest r103, ze5.c r104) {
        Intrinsics.checkNotNullParameter(r101, "imageList");
        this.f472499a = r100;
        this.f472500b = r101;
        this.f472501c = r102;
        this.f472502d = r103;
        this.f472503e = r104;
    }
}
