package com.ss.android.lark.audio.recorder;

import java.nio.ByteBuffer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Integer, Integer> f409107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<ByteBuffer, Integer, Double> f409108b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f409107a, r101.f409107a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f409108b, r101.f409108b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f409107a.hashCode() * 31) + this.f409108b.hashCode();
    }

    public final String toString() {
        return "AudioRecordCompatStrategy(bufferSizeStrategy=" + this.f409107a + ", calculateVolume=" + this.f409108b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function1<? super Integer, Integer> r100, Function2<? super ByteBuffer, ? super Integer, Double> r101) {
        Intrinsics.checkNotNullParameter(r100, "bufferSizeStrategy");
        Intrinsics.checkNotNullParameter(r101, "calculateVolume");
        this.f409107a = r100;
        this.f409108b = r101;
    }
}
