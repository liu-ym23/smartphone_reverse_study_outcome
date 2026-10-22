package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<zac.a, Unit> f230647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<yac.a, Unit> f230648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<abc.c, Unit> f230649c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f230647a, r101.f230647a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f230648b, r101.f230648b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f230649c, r101.f230649c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f230647a.hashCode() * 31) + this.f230648b.hashCode()) * 31) + this.f230649c.hashCode();
    }

    public final String toString() {
        return "CommentUnifiedVoiceComponentFlowCallbacks(onResult=" + this.f230647a + ", onEvent=" + this.f230648b + ", onRecordState=" + this.f230649c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(Function1<? super zac.a, Unit> r100, Function1<? super yac.a, Unit> r101, Function1<? super abc.c, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "onResult");
        Intrinsics.checkNotNullParameter(r101, "onEvent");
        Intrinsics.checkNotNullParameter(r102, "onRecordState");
        this.f230647a = r100;
        this.f230648b = r101;
        this.f230649c = r102;
    }
}
