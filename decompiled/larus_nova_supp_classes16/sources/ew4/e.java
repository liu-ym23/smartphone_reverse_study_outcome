package ew4;

import com.bytedance.ee.bear.config.CommentImageSelectorDismissReason;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e {
    public final int a;
    public final int b;
    public final Function1<List<f>, Unit> c;
    public final Function1<CommentImageSelectorDismissReason, Unit> d;
    public final d e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a * 31) + this.b) * 31) + this.c.hashCode()) * 31;
        Function1<CommentImageSelectorDismissReason, Unit> r1 = this.d;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.e.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "CommentImageSelectorRequest(height=" + this.a + ", maxSelectImageCount=" + this.b + ", onSelectImages=" + this.c + ", onDismiss=" + this.d + ", dialogLifecycle=" + this.e + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(int r2, int r3, Function1<? super List<f>, Unit> r4, Function1<? super CommentImageSelectorDismissReason, Unit> r5, d r6) {
        Intrinsics.checkNotNullParameter(r4, "onSelectImages");
        Intrinsics.checkNotNullParameter(r6, "dialogLifecycle");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
