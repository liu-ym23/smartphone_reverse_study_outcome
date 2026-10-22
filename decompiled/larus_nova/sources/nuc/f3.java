package nuc;

import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: classes5.dex */
@ExperimentalSerializationApi
public final class f3 extends l2<UInt, UIntArray, e3> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f3 f520676c = null;

    static {
        f520676c = new f3();
    }

    @Override // nuc.l2
    public final UIntArray k() {
        return UIntArray.m9597boximpl(UIntArray.m9598constructorimpl(0));
    }

    public f3() {
        Intrinsics.checkNotNullParameter(UInt.Companion, "<this>");
        super(g3.f520695a);
    }

    @Override // nuc.a
    public final int e(Object r100) {
        int[] r101 = ((UIntArray) r100).m9613unboximpl();
        Intrinsics.checkNotNullParameter(r101, "$this$collectionSize");
        return UIntArray.m9605getSizeimpl(r101);
    }

    @Override // nuc.a
    public final Object i(Object r100) {
        int[] r101 = ((UIntArray) r100).m9613unboximpl();
        Intrinsics.checkNotNullParameter(r101, "$this$toBuilder");
        return new e3(r101);
    }

    @Override // nuc.l2
    public final void l(muc.d r100, UIntArray r101, int r102) {
        int[] r103 = r101.m9613unboximpl();
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r103, "content");
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r100.encodeInlineElement(this.f520733b, r104).encodeInt(UIntArray.m9604getpVg5ArA(r103, r104));
        r104 = r104 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(muc.c r100, int r101, Object r102, boolean r103) {
        e3 r104 = (e3) r102;
        Intrinsics.checkNotNullParameter(r100, "decoder");
        Intrinsics.checkNotNullParameter(r104, "builder");
        int r105 = UInt.m9544constructorimpl(r100.decodeInlineElement(this.f520733b, r101).decodeInt());
        r104.getClass();
        j2.c(r104);
        int[] r106 = r104.f520669a;
        int r107 = r104.f520670b;
        r104.f520670b = r107 + 1;
        UIntArray.m9609setVXSXFK8(r106, r107, r105);
    }
}
