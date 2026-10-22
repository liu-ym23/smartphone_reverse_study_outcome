package am2;

import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l {
    public long a;
    public String b;
    public int c;
    public String d;
    public long e;
    public String f;
    public String g;
    public int h;
    public String i;

    public l() {
    }

    public final void a(Boolean r1) {
        if (r1.booleanValue() == false) goto L5;
        String r2 = "1";
    L6:
        this.g = r2;
        return;
    L5:
        r2 = BDLocationException.ERROR_TIMEOUT;
        goto L6
    }
}
