package s15;

import du5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final String a;
    public final String b;

    public final String toString() {
        return "AreaCommentExtra(commentId='" + b.h(this.a) + "', replyId='" + b.h(this.b) + "')";
    }

    public a(String r2, String r3) {
        this.a = "";
        this.b = "";
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        this.a = r2;
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        this.b = r3;
    }
}
