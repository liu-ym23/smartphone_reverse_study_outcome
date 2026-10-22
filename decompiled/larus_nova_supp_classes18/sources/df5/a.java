package df5;

import com.bytedance.ee.bear.middleground.comment.export.CommentStyle;
import com.bytedance.ee.bear.middleground.comment.extension.addins.a0;
import com.bytedance.ee.bear.middleground.comment.extension.addins.b;
import com.bytedance.ee.bear.middleground.comment.extension.addins.e0;
import com.bytedance.ee.bear.middleground.comment.extension.addins.f;
import com.bytedance.ee.bear.middleground.comment.extension.addins.i0;
import com.bytedance.ee.bear.middleground.comment.extension.addins.x;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static List a(p r3) {
        b[] r0 = new b[5];
        r0[0] = new e0();
        r0[1] = new i0();
        CommentStyle r4 = r3.n;
        if (r4 != CommentStyle.ASIDE) goto L5;
    L8:
        b r5 = new com.bytedance.ee.bear.middleground.comment.extension.addins.a();
    L9:
        r0[2] = r5;
        r0[3] = new x();
        r0[4] = new a0();
        return CollectionsKt.listOf(r0);
    L5:
        if (r4 == CommentStyle.ASIDE_IN_PICTURE) goto L8;
        r5 = new f();
        goto L9
    }
}
