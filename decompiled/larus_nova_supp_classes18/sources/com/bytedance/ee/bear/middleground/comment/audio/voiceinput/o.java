package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import android.view.ViewGroup;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o {
    public final Function0<ViewGroup> a;
    public final Function0<p> b;
    public final Function1<p, Boolean> c;
    public final Function2<p, CharSequence, Unit> d;
    public final Function1<Boolean, Unit> e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o) == true) goto L8;
        return false;
    L8:
        o r6 = (o) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        Function1<Boolean, Unit> r1 = this.e;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "CommentVoiceSimpleInputContext(overlayContainerProvider=" + this.a + ", targetSnapshotProvider=" + this.b + ", targetValidator=" + this.c + ", onFinalText=" + this.d + ", onVoiceRecordingStateChanged=" + this.e + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(Function0<? extends ViewGroup> r2, Function0<p> r3, Function1<? super p, Boolean> r4, Function2<? super p, ? super CharSequence, Unit> r5, Function1<? super Boolean, Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "overlayContainerProvider");
        Intrinsics.checkNotNullParameter(r3, "targetSnapshotProvider");
        Intrinsics.checkNotNullParameter(r4, "targetValidator");
        Intrinsics.checkNotNullParameter(r5, "onFinalText");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
