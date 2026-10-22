package ef5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements gf5.c {
    public final Integer a;
    public final int b;
    public final String c;
    public final String d;
    public final String e;
    public final Integer f;

    public final String toString() {
        return "CommentSwitchEvent(position=" + this.a + ", commentId='" + this.c + "', lastCommentId='" + this.e + "')";
    }

    public /* synthetic */ j(Integer r8, int r9, String r10, String r11, String r12) {
        this(r8, r9, r10, r11, r12, null);
    }

    public j(Integer r2, int r3, String r4, String r5, String r6, Integer r7) {
        Intrinsics.checkNotNullParameter(r4, "commentId");
        Intrinsics.checkNotNullParameter(r5, "commentUUID");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
