package s45;

import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l {
    public String a;
    public String b;
    public String c;
    public String d;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.a, this.b, this.c});
    }

    public l() {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L19:
        return false;
    L8:
        if (l.class != r5.getClass()) goto L19;
        l r6 = (l) r5;
        if (Objects.equals(this.a, r6.a) == true) goto L13;
    L17:
        return false;
    L13:
        if (Objects.equals(this.b, r6.b) == false) goto L17;
        if (Objects.equals(this.c, r6.c) == false) goto L17;
        return true;
    }
}
