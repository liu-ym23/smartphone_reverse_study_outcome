package ef5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e0 implements gf5.c {
    public final String a;

    public final String toString() {
        return "ReactionShowedEvent(replyId='" + this.a + "')";
    }

    public e0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "replyId");
        this.a = r2;
    }
}
