package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<zac.a, Unit> f230651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<yac.a, Unit> f230652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<abc.c, Unit> f230653c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f230651a, r101.f230651a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f230652b, r101.f230652b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f230653c, r101.f230653c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f230651a.hashCode() * 31) + this.f230652b.hashCode()) * 31) + this.f230653c.hashCode();
    }

    public final String toString() {
        return "CommentUnifiedVoiceComponentSimpleCallbacks(onResult=" + this.f230651a + ", onEvent=" + this.f230652b + ", onRecordState=" + this.f230653c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(Function1<? super zac.a, Unit> r100, Function1<? super yac.a, Unit> r101, Function1<? super abc.c, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "onResult");
        Intrinsics.checkNotNullParameter(r101, "onEvent");
        Intrinsics.checkNotNullParameter(r102, "onRecordState");
        this.f230651a = r100;
        this.f230652b = r101;
        this.f230653c = r102;
    }
}
