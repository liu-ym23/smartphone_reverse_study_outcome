package ef5;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class q implements gf5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f472494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> f472495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f472496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final kf5.b f472497d;

    public final String toString() {
        return "InputDismissedEvent(content=" + this.f472494a.length() + ", imageList=" + this.f472495b.size() + ", bySend=" + this.f472496c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(String r100, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r101, boolean r102, kf5.b r103) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "imageList");
        Intrinsics.checkNotNullParameter(r103, "inputComment");
        this.f472494a = r100;
        this.f472495b = r101;
        this.f472496c = r102;
        this.f472497d = r103;
    }
}
