package nuc;

import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: classes5.dex */
@ExperimentalSerializationApi
public final class i3 extends l2<ULong, ULongArray, h3> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i3 f520711c = null;

    static {
        f520711c = new i3();
    }

    @Override // nuc.l2
    public final ULongArray k() {
        return ULongArray.m9676boximpl(ULongArray.m9677constructorimpl(0));
    }

    public i3() {
        Intrinsics.checkNotNullParameter(ULong.Companion, "<this>");
        super(j3.f520720a);
    }

    @Override // nuc.a
    public final int e(Object r100) {
        long[] r101 = ((ULongArray) r100).m9692unboximpl();
        Intrinsics.checkNotNullParameter(r101, "$this$collectionSize");
        return ULongArray.m9684getSizeimpl(r101);
    }

    @Override // nuc.a
    public final Object i(Object r100) {
        long[] r101 = ((ULongArray) r100).m9692unboximpl();
        Intrinsics.checkNotNullParameter(r101, "$this$toBuilder");
        return new h3(r101);
    }

    @Override // nuc.l2
    public final void l(muc.d r100, ULongArray r101, int r102) {
        long[] r103 = r101.m9692unboximpl();
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r103, "content");
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r100.encodeInlineElement(this.f520733b, r104).encodeLong(ULongArray.m9683getsVKNKU(r103, r104));
        r104 = r104 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(muc.c r100, int r101, Object r102, boolean r103) {
        h3 r104 = (h3) r102;
        Intrinsics.checkNotNullParameter(r100, "decoder");
        Intrinsics.checkNotNullParameter(r104, "builder");
        long r105 = ULong.m9623constructorimpl(r100.decodeInlineElement(this.f520733b, r101).decodeLong());
        r104.getClass();
        j2.c(r104);
        long[] r106 = r104.f520703a;
        int r107 = r104.f520704b;
        r104.f520704b = r107 + 1;
        ULongArray.m9688setk8EXiF4(r106, r107, r105);
    }
}
