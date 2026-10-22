package cc4;

import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public final String a;
    public long b;
    public long c;
    public h d;
    public h e;
    public h f;
    public h g;

    public final int hashCode() {
        if (TextUtils.isEmpty(this.a) == false) goto L7;
        return super.hashCode();
    L7:
        return this.a.hashCode();
    }

    public d(String r1) {
        this.a = r1;
        System.currentTimeMillis();
    }

    public final boolean equals(Object r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if ((r3 instanceof d) == false) goto L11;
        String r1 = this.a;
        if (r1 == null) goto L11;
        return r1.equals(((d) r3).a);
    L11:
        return false;
    }
}
