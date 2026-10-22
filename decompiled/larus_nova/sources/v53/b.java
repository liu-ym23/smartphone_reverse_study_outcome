package v53;

import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import p53.i;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f553246a = 0;

    static {
    }

    public static String a(CommentNodeVO r100) {
        Intrinsics.checkNotNullParameter(r100, "commentNodeVo");
        List<i> r101 = r100.getTagsInfo();
        if (r101 == null) goto L11;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L16;
        if (Intrinsics.areEqual(((i) r102.next()).f527781a, "3") == false) goto L6;
        return "1";
    L16:
        return "0";
    L11:
        return "0";
    }

    public static String b(CommentNodeVO r100) {
        Intrinsics.checkNotNullParameter(r100, "commentNodeVo");
        List<i> r101 = r100.getTagsInfo();
        if (r101 == null) goto L10;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(((i) r102.next()).f527781a, "1") == false) goto L6;
        return "1";
    L15:
        return "0";
    L10:
        return "0";
    }
}
