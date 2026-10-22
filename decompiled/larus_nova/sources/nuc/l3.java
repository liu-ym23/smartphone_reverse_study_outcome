package nuc;

import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: classes5.dex */
@ExperimentalSerializationApi
public final class l3 extends l2<UShort, UShortArray, k3> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l3 f520734c = null;

    static {
        f520734c = new l3();
    }

    @Override // nuc.l2
    public final UShortArray k() {
        return UShortArray.m9781boximpl(UShortArray.m9782constructorimpl(0));
    }

    public l3() {
        Intrinsics.checkNotNullParameter(UShort.Companion, "<this>");
        super(m3.f520738a);
    }

    @Override // nuc.a
    public final int e(Object r100) {
        short[] r101 = ((UShortArray) r100).m9797unboximpl();
        Intrinsics.checkNotNullParameter(r101, "$this$collectionSize");
        return UShortArray.m9789getSizeimpl(r101);
    }

    @Override // nuc.a
    public final Object i(Object r100) {
        short[] r101 = ((UShortArray) r100).m9797unboximpl();
        Intrinsics.checkNotNullParameter(r101, "$this$toBuilder");
        return new k3(r101);
    }

    @Override // nuc.l2
    public final void l(muc.d r100, UShortArray r101, int r102) {
        short[] r103 = r101.m9797unboximpl();
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r103, "content");
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r100.encodeInlineElement(this.f520733b, r104).encodeShort(UShortArray.m9788getMh2AYeg(r103, r104));
        r104 = r104 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(muc.c r100, int r101, Object r102, boolean r103) {
        k3 r104 = (k3) r102;
        Intrinsics.checkNotNullParameter(r100, "decoder");
        Intrinsics.checkNotNullParameter(r104, "builder");
        short r105 = UShort.m9730constructorimpl(r100.decodeInlineElement(this.f520733b, r101).decodeShort());
        r104.getClass();
        j2.c(r104);
        short[] r106 = r104.f520727a;
        int r107 = r104.f520728b;
        r104.f520728b = r107 + 1;
        UShortArray.m9793set01HTLdE(r106, r107, r105);
    }
}
