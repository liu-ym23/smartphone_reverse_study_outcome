package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<zac.a, Unit> f230630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<yac.a, Unit> f230631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<abc.c, Unit> f230632c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f230630a, r101.f230630a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f230631b, r101.f230631b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f230632c, r101.f230632c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f230630a.hashCode() * 31) + this.f230631b.hashCode()) * 31) + this.f230632c.hashCode();
    }

    public final String toString() {
        return "CommentUnifiedVoiceComponentAdvancedCallbacks(onResult=" + this.f230630a + ", onEvent=" + this.f230631b + ", onRecordState=" + this.f230632c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function1<? super zac.a, Unit> r100, Function1<? super yac.a, Unit> r101, Function1<? super abc.c, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "onResult");
        Intrinsics.checkNotNullParameter(r101, "onEvent");
        Intrinsics.checkNotNullParameter(r102, "onRecordState");
        this.f230630a = r100;
        this.f230631b = r101;
        this.f230632c = r102;
    }
}
