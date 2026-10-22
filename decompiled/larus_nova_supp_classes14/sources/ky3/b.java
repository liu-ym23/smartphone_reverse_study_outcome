package ky3;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends o14.a {
    public final String d;
    public int e;
    public final String f;
    public long g;
    public boolean h;
    public int i;
    public final int j;

    public b(o14.a r6) {
        this.f = "";
        this.h = true;
        ((o14.a) this).a = 11;
        String r0 = r6.cid;
        this.d = r0;
        ((o14.a) this).cid = r0 + "-reply-button";
        List r1 = r6.replyComments;
        if (r1 == null) goto L14;
        int r2 = r1.size();
        StringBuilder r3 = new StringBuilder();
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L9;
        if (r4 <= 0) goto L8;
        r3.append(",");
    L8:
        r3.append(((o14.a) ListProtector.get(r6.replyComments, r4)).cid);
        r4 = r4 + 1;
        goto L5
    L9:
        this.f = r3.toString();
        Integer r5 = r6.n();
        if (r5 == null) goto L12;
        this.j = r5.intValue();
    L13:
        this.g = Math.max(0, r2 - 1);
        this.i = r2;
        goto L14
    L12:
        this.j = r2;
    L14:
        ((o14.a) this).replyCommentTotal = r6.replyCommentTotal;
    }
}
