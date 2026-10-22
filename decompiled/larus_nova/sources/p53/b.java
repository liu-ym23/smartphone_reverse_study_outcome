package p53;

import com.bytedance.android.ec.model.response.f1;
import com.bytedance.android.shopping.anchorv3.comment.LoadState;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;
import com.bytedance.android.shopping.anchorv3.commentv2.model.CommentRefreshFrom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<CommentNodeVO> f527768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f527769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f1 f527770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f527771d;

    public b(List r100, boolean r101, LoadState r102, int r103, CommentRefreshFrom r104, boolean r105, int r106, f1 r107, long r108, int r110) {
        if ((r110 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r110 & 8) == 0) goto L9;
        r102 = LoadState.RESET;
    L9:
        if ((r110 & 32) == 0) goto L12;
        r104 = CommentRefreshFrom.OTHER;
    L12:
        if ((r110 & 128) == 0) goto L15;
        r106 = -1;
    L15:
        if ((r110 & 256) == 0) goto L17;
        r107 = null;
    L17:
        Intrinsics.checkNotNullParameter(r100, "commentNodeList");
        Intrinsics.checkNotNullParameter(r102, "commentListLoadState");
        Intrinsics.checkNotNullParameter(r104, "refreshFrom");
        this.f527768a = r100;
        this.f527769b = r106;
        this.f527770c = r107;
        this.f527771d = null;
    }
}
