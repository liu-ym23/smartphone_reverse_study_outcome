package nuc;

import java.util.Arrays;
import kotlin.UByteArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: classes42.dex */
@ExperimentalSerializationApi
public final class b3 extends j2<UByteArray> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f520646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f520647b;

    @Override // nuc.j2
    public final UByteArray a() {
        return UByteArray.m9518boximpl(UByteArray.m9520constructorimpl(Arrays.copyOf(this.f520646a, this.f520647b)));
    }

    @Override // nuc.j2
    public final int d() {
        return this.f520647b;
    }

    public b3(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "bufferWithData");
        this.f520646a = r100;
        this.f520647b = UByteArray.m9526getSizeimpl(r100);
        b(10);
    }

    @Override // nuc.j2
    public final void b(int r100) {
        if (UByteArray.m9526getSizeimpl(this.f520646a) >= r100) goto L6;
        byte[] r101 = this.f520646a;
        this.f520646a = UByteArray.m9520constructorimpl(Arrays.copyOf(r101, RangesKt.coerceAtLeast(r100, UByteArray.m9526getSizeimpl(r101) * 2)));
        return;
    }
}
