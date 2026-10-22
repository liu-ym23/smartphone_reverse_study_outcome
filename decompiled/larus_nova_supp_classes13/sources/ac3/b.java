package ac3;

import cc3.k;
import com.bytedance.android.shopping.anchorv3.comment.model.CommentNodeVO;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import p53.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final String b(CommentNodeVO r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$getUserCommentLevel");
        List r4 = r3.getTagsInfo();
        if (r4 == null) goto L15;
        Iterator r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        Object r0 = r5.next();
        if (Intrinsics.areEqual(((i) r0).a, "2") == false) goto L6;
    L11:
        i r1 = (i) r0;
        if (r1 != null) goto L14;
        return "";
    L14:
        return String.valueOf(r1.b);
    L10:
        r0 = null;
        goto L11
    L15:
        return "";
    }

    public static final k a(CommentNodeVO r11, int r12, int r13, int r14, String r15, CommentNodeVO r16) {
        Intrinsics.checkNotNullParameter(r11, "$this$getGalleryInfo");
        Intrinsics.checkNotNullParameter(r15, "commentSwitchType");
        Intrinsics.checkNotNullParameter(r16, "commentNodeVO");
        List r2 = r11.getVideoInfo();
        if (r2 == null) goto L5;
        int r4 = r2.size();
    L6:
        List r3 = r11.getImagesInfos();
        if (r3 == null) goto L9;
        int r5 = r3.size();
    L10:
        String r8 = b(r11);
        return new k(r12, r14, r4, r5, r15, String.valueOf(r11.getId()), r8, r13, r16);
    L9:
        r5 = 0;
        goto L10
    L5:
        r4 = 0;
        goto L6
    }
}
