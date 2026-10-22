package nuc;

import java.util.Arrays;
import kotlin.UIntArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: classes42.dex */
@ExperimentalSerializationApi
public final class e3 extends j2<UIntArray> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f520669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f520670b;

    @Override // nuc.j2
    public final UIntArray a() {
        return UIntArray.m9597boximpl(UIntArray.m9599constructorimpl(Arrays.copyOf(this.f520669a, this.f520670b)));
    }

    @Override // nuc.j2
    public final int d() {
        return this.f520670b;
    }

    public e3(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "bufferWithData");
        this.f520669a = r100;
        this.f520670b = UIntArray.m9605getSizeimpl(r100);
        b(10);
    }

    @Override // nuc.j2
    public final void b(int r100) {
        if (UIntArray.m9605getSizeimpl(this.f520669a) >= r100) goto L6;
        int[] r101 = this.f520669a;
        this.f520669a = UIntArray.m9599constructorimpl(Arrays.copyOf(r101, RangesKt.coerceAtLeast(r100, UIntArray.m9605getSizeimpl(r101) * 2)));
        return;
    }
}
