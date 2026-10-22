package nuc;

import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: classes5.dex */
@ExperimentalSerializationApi
public final class c3 extends l2<UByte, UByteArray, b3> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c3 f520652c = null;

    static {
        f520652c = new c3();
    }

    @Override // nuc.l2
    public final UByteArray k() {
        return UByteArray.m9518boximpl(UByteArray.m9519constructorimpl(0));
    }

    public c3() {
        Intrinsics.checkNotNullParameter(UByte.Companion, "<this>");
        super(d3.f520661a);
    }

    @Override // nuc.a
    public final int e(Object r100) {
        byte[] r101 = ((UByteArray) r100).m9534unboximpl();
        Intrinsics.checkNotNullParameter(r101, "$this$collectionSize");
        return UByteArray.m9526getSizeimpl(r101);
    }

    @Override // nuc.a
    public final Object i(Object r100) {
        byte[] r101 = ((UByteArray) r100).m9534unboximpl();
        Intrinsics.checkNotNullParameter(r101, "$this$toBuilder");
        return new b3(r101);
    }

    @Override // nuc.l2
    public final void l(muc.d r100, UByteArray r101, int r102) {
        byte[] r103 = r101.m9534unboximpl();
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r103, "content");
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r100.encodeInlineElement(this.f520733b, r104).encodeByte(UByteArray.m9525getw2LRezQ(r103, r104));
        r104 = r104 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(muc.c r100, int r101, Object r102, boolean r103) {
        b3 r104 = (b3) r102;
        Intrinsics.checkNotNullParameter(r100, "decoder");
        Intrinsics.checkNotNullParameter(r104, "builder");
        byte r105 = UByte.m9467constructorimpl(r100.decodeInlineElement(this.f520733b, r101).decodeByte());
        r104.getClass();
        j2.c(r104);
        byte[] r106 = r104.f520646a;
        int r107 = r104.f520647b;
        r104.f520647b = r107 + 1;
        UByteArray.m9530setVurrAj0(r106, r107, r105);
    }
}
