package lc3;

import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;
import com.bytedance.android.shopping.commentv3.data.FetchFrom;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<CommentNodeVO> f508408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FetchFrom f508409b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f508408a, r101.f508408a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f508409b, r101.f508409b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<CommentNodeVO> r100 = this.f508408a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        FetchFrom r104 = this.f508409b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CommentsModel(comments=" + this.f508408a + ", from=" + this.f508409b + ")";
    }

    public a(List<CommentNodeVO> r100, FetchFrom r101) {
        Intrinsics.checkNotNullParameter(r100, "comments");
        Intrinsics.checkNotNullParameter(r101, "from");
        this.f508408a = r100;
        this.f508409b = r101;
    }
}
