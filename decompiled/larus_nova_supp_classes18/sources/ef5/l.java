package ef5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements gf5.c {
    public final String a;
    public final String b;
    public final int c;

    public final String toString() {
        return "ConfirmDialogShowedEvent(commentId='" + this.a + "', replyId='" + this.b + "', type=" + this.c + ')';
    }

    public final int getType() {
        return this.c;
    }

    public l(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r3, "replyId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
