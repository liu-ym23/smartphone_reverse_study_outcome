package ef5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g0 implements gf5.c {
    public final String a;
    public final String b;

    public final String toString() {
        return "ReplyTextChangedEvent(text=" + this.a.length() + ", commentId='" + this.b + "')";
    }

    public g0(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "commentId");
        this.a = r2;
        this.b = r3;
    }
}
