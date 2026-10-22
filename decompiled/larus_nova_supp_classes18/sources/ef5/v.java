package ef5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v implements gf5.c {
    public final String a;
    public final String b;
    public final boolean c;
    public final String d;
    public final boolean e;
    public final boolean f;

    public final String toString() {
        return "InsertContentToDraftEvent(commentId=" + this.a + ", replyId=" + this.b + ", isWhole=" + this.c + ", content=" + this.d + ", insertAtBeginning=" + this.e + ", checkExistingContent=" + this.f + ')';
    }

    public v(String r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "content");
        this.a = r2;
        this.b = null;
        this.c = r3;
        this.d = r4;
        this.e = true;
        this.f = true;
    }
}
