package mz3;

import android.content.Context;
import android.widget.Scroller;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m extends Scroller {
    public final l a;
    public int b;
    public boolean c;

    public static final class a {
    }

    static {
    }

    public m(Context r3) {
        l r0 = new l();
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r0, "interpolator");
        super(r3, r0);
        this.a = r0;
        this.b = 600;
    }

    public final void a(boolean r2) {
        this.c = r2;
        this.a.d = r2;
    }

    @Override // android.widget.Scroller
    public final void startScroll(int r7, int r8, int r9, int r10, int r11) {
        if (this.c == false) goto L5;
        super.startScroll(r7, r8, r9, r10, this.b);
        return;
    L5:
        super.startScroll(r7, r8, r9, r10, 600);
    }
}
