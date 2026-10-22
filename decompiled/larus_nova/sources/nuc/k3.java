package nuc;

import java.util.Arrays;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: classes42.dex */
@ExperimentalSerializationApi
public final class k3 extends j2<UShortArray> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short[] f520727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f520728b;

    @Override // nuc.j2
    public final UShortArray a() {
        return UShortArray.m9781boximpl(UShortArray.m9783constructorimpl(Arrays.copyOf(this.f520727a, this.f520728b)));
    }

    @Override // nuc.j2
    public final int d() {
        return this.f520728b;
    }

    public k3(short[] r100) {
        Intrinsics.checkNotNullParameter(r100, "bufferWithData");
        this.f520727a = r100;
        this.f520728b = UShortArray.m9789getSizeimpl(r100);
        b(10);
    }

    @Override // nuc.j2
    public final void b(int r100) {
        if (UShortArray.m9789getSizeimpl(this.f520727a) >= r100) goto L6;
        short[] r101 = this.f520727a;
        this.f520727a = UShortArray.m9783constructorimpl(Arrays.copyOf(r101, RangesKt.coerceAtLeast(r100, UShortArray.m9789getSizeimpl(r101) * 2)));
        return;
    }
}
