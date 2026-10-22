package uw3;

import android.util.Pair;
import com.bytedance.applog.IBDAccountCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j implements gx3.b {
    public final /* synthetic */ i a;

    public final String a() {
        IBDAccountCallback r0 = this.a.b.c.a0;
        if (r0 == null) goto L13;
        Pair r1 = r0.getOdinUserInfo();
        if (((Long) r1.second).longValue() <= 0) goto L9;
        return String.valueOf(r1.second);
    L9:
        if (this.a.b.k.d == 0) goto L11;
        return null;
    L11:
        return String.valueOf(this.a.b.k.b);
    L13:
        if (this.a.b.k.a > 0) goto L15;
        return null;
    L15:
        return String.valueOf(this.a.b.k.a);
    }

    public final String b() {
        IBDAccountCallback r0 = this.a.b.c.a0;
        if (r0 == null) goto L12;
        Pair r1 = r0.getOdinUserInfo();
        if (((Long) r1.second).longValue() <= 0) goto L9;
        return String.valueOf(r1.first);
    L9:
        if (this.a.b.k.d == 0) goto L11;
        return null;
    L11:
        return String.valueOf(this.a.b.k.c);
    L12:
        return null;
    }

    public final String c() {
        return this.a.b.c.getDid();
    }

    public final String d() {
        return this.a.b.c.j;
    }

    public j(i r1) {
        this.a = r1;
    }
}
