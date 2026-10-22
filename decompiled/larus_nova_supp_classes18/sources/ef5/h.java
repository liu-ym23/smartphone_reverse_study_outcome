package ef5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements gf5.c {
    public final String a;
    public final String b;
    public final int c;
    public final boolean d;
    public final boolean e;
    public String f;
    public String g;

    public final String toString() {
        return "CommentSendEvent(commentId='" + this.a + "', replyId=" + this.b + ", sendType=" + this.c + ", isWhole=" + this.d + ", clearDraft=" + this.e + ')';
    }

    public /* synthetic */ h(String r7) {
        this(r7, null, 2, false, true);
    }

    public h(String r2, String r3, int r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
