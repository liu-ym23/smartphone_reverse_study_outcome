package yq5;

import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z {
    public int a;
    public String b;
    public String c;
    public int d;
    public boolean e;
    public long f;
    public String g;

    public final boolean a() {
        if (TextUtils.isEmpty(this.b) == false) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(this.c) == true) goto L9;
        if (this.d == (-1)) goto L9;
        return true;
    }

    public final String toString() {
        return "WikiRouteEntry{wiki_token='" + du5.b.g(this.b) + "', obj_token='" + du5.b.g(this.c) + "', obj_type=" + this.d + ", in_space=" + this.e + ", log_id=" + this.g + '}';
    }

    public z() {
        this.f = System.currentTimeMillis();
    }
}
