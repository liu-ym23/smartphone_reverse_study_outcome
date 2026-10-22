package o83;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {
    public final Boolean a;
    public final Boolean b;
    public final Boolean c;

    public d() {
        this(null, 7);
    }

    public d(Boolean r3, int r4) {
        if ((r4 & 1) == 0) goto L5;
        r3 = Boolean.FALSE;
    L5:
        Boolean r1 = null;
        if ((r4 & 2) == 0) goto L8;
        Boolean r0 = Boolean.FALSE;
    L10:
        if ((r4 & 4) == 0) goto L12;
        r1 = Boolean.FALSE;
    L12:
        this.a = r3;
        this.b = r0;
        this.c = r1;
        return;
    L8:
        r0 = null;
        goto L10
    }
}
