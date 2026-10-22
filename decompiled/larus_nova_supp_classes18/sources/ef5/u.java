package ef5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u implements gf5.c {
    public final String a;
    public final kf5.b b;

    public final String toString() {
        return "InputTextChangedEvent(text=" + this.a.length() + ')';
    }

    public u(String r2, kf5.b r3) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "inputComment");
        this.a = r2;
        this.b = r3;
    }
}
