package ouc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
public final class t {
    public static final h a(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof h) == false) goto L5;
        h r101 = (h) r100;
    L6:
        if (r101 == null) goto L9;
        return r101;
    L9:
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + Reflection.getOrCreateKotlinClass(r100.getClass()));
    L5:
        r101 = null;
        goto L6
    }

    public static final u b(muc.f r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof u) == false) goto L5;
        u r101 = (u) r100;
    L6:
        if (r101 == null) goto L9;
        return r101;
    L9:
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got " + Reflection.getOrCreateKotlinClass(r100.getClass()));
    L5:
        r101 = null;
        goto L6
    }
}
