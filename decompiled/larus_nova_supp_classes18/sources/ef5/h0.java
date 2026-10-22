package ef5;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBottomPopupData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h0 implements gf5.c {
    public static final /* synthetic */ int c = 0;
    public final CommentBottomPopupData a;
    public final bf5.b b;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "SharePermissionShowDialogEvent";
    }

    public h0(CommentBottomPopupData r2, bf5.b r3) {
        Intrinsics.checkNotNullParameter(r2, "commentBottomPopupData");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a = r2;
        this.b = r3;
    }
}
