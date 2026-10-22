package n95;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final b a;
    public final String b;
    public String c;
    public URL d;

    public final String a() {
        if (TextUtils.isEmpty(this.c) == false) goto L10;
        String r0 = this.b;
        if (TextUtils.isEmpty(r0) == true) goto L8;
        this.c = Uri.encode(r0, "@#&=*+-_.,:!?()/~'%");
        goto L10
    L8:
        throw null;
    L10:
        return this.c;
    }

    public final int hashCode() {
        String r0 = this.b;
        r0.getClass();
        return (r0.hashCode() * 31) + this.a.hashCode();
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder();
        String r1 = this.b;
        r1.getClass();
        r0.append(r1);
        r0.append('\n');
        r0.append(this.a.toString());
        return r0.toString();
    }

    public final boolean equals(Object r4) {
        if ((r4 instanceof a) == false) goto L10;
        a r5 = (a) r4;
        String r0 = this.b;
        r0.getClass();
        String r2 = r5.b;
        r2.getClass();
        if (r0.equals(r2) == true) goto L7;
        return false;
    L7:
        if (this.a.equals(r5.a) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public a(String r3, h r4) {
        if (TextUtils.isEmpty(r3) == true) goto L7;
        this.b = r3;
        this.a = r4;
        return;
    L7:
        throw new IllegalArgumentException("String url must not be empty or null: " + r3);
    }
}
