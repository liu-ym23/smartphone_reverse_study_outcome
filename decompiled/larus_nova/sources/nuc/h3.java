package nuc;

import java.util.Arrays;
import kotlin.ULongArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: classes42.dex */
@ExperimentalSerializationApi
public final class h3 extends j2<ULongArray> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f520703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f520704b;

    @Override // nuc.j2
    public final ULongArray a() {
        return ULongArray.m9676boximpl(ULongArray.m9678constructorimpl(Arrays.copyOf(this.f520703a, this.f520704b)));
    }

    @Override // nuc.j2
    public final int d() {
        return this.f520704b;
    }

    public h3(long[] r100) {
        Intrinsics.checkNotNullParameter(r100, "bufferWithData");
        this.f520703a = r100;
        this.f520704b = ULongArray.m9684getSizeimpl(r100);
        b(10);
    }

    @Override // nuc.j2
    public final void b(int r100) {
        if (ULongArray.m9684getSizeimpl(this.f520703a) >= r100) goto L6;
        long[] r101 = this.f520703a;
        this.f520703a = ULongArray.m9678constructorimpl(Arrays.copyOf(r101, RangesKt.coerceAtLeast(r100, ULongArray.m9684getSizeimpl(r101) * 2)));
        return;
    }
}
