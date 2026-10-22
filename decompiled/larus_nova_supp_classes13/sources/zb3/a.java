package zb3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final String a;
    public boolean b;
    public long c;
    public final String d;

    public a() {
        this(null, false, 0, 15);
    }

    public /* synthetic */ a(String r9, boolean r10, long r11, int r13) {
        String r1 = "";
        if ((r13 & 1) == 0) goto L5;
        String r3 = "";
    L7:
        if ((r13 & 2) == 0) goto L9;
        boolean r4 = false;
    L11:
        if ((r13 & 4) == 0) goto L13;
        r11 = 0;
    L13:
        long r5 = r11;
        if ((r13 & 8) != 0) goto L17;
        r1 = null;
    L17:
        this(r3, r4, r5, r1);
        return;
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    public a(String r2, boolean r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r6, "actionType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
    }
}
