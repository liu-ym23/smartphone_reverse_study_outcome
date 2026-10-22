package ef5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y implements gf5.c {
    public final kf5.b a;
    public final int b;
    public final boolean c;

    public final String toString() {
        return "KeyboardHeightChangeEvent(height=" + this.b + ", canDismiss=" + this.c + ')';
    }

    public y(kf5.b r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "inputComment");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
