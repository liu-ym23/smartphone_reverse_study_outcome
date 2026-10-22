package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h {
    public final Function1<zac.a, Unit> a;
    public final Function1<yac.a, Unit> b;
    public final Function1<abc.c, Unit> c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "CommentUnifiedVoiceComponentFlowCallbacks(onResult=" + this.a + ", onEvent=" + this.b + ", onRecordState=" + this.c + ')';
    }

    public h(Function1<? super zac.a, Unit> r2, Function1<? super yac.a, Unit> r3, Function1<? super abc.c, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "onResult");
        Intrinsics.checkNotNullParameter(r3, "onEvent");
        Intrinsics.checkNotNullParameter(r4, "onRecordState");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
