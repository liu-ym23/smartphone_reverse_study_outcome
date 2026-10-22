package un5;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k extends h {
    public final String e;
    public final Integer f;
    public final Integer g;
    public final String h;
    public final String i;
    public final String j;

    public final Integer getType() {
        return this.f;
    }

    public k(Context r2, String r3, Integer r4, Integer r5, String r6, String r7, String r8, String r9, a.InterfaceC0318a r10) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        super(r2, r6, r10);
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r7;
        this.i = r8;
        this.j = r9;
    }
}
