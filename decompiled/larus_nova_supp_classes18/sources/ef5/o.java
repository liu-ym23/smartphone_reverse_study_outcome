package ef5;

import android.widget.EditText;
import com.bytedance.ee.bear.middleground.comment.export.MentionUserState;
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o implements gf5.c {
    public final kf5.b a;
    public final EditText b;
    public final String c;
    public final String d;
    public final MentionUserState e;

    /* JADX WARN: Multi-variable type inference failed */
    public o(kf5.b r2, CommentEditText r3, String r4, String r5, MentionUserState r6) {
        Intrinsics.checkNotNullParameter(r2, "inputComment");
        Intrinsics.checkNotNullParameter(r3, "commentEditText");
        Intrinsics.checkNotNullParameter(r4, "userId");
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r6, "state");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
