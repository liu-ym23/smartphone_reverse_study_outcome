package ksc;

import kotlin.UByte;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes41.dex */
public final class c {
    public static final long a(int r100, int r101) {
        long r102 = ((long) r100) << 32;
        return (((long) r101) & BodyPartID.bodyIdMax) | r102;
    }

    public static final void c(int r100) {
        throw new IllegalArgumentException("Malformed code-point " + Integer.toHexString(r100) + " found");
    }

    public static final void d(byte r100) {
        throw new IllegalStateException(("Unsupported byte code, first byte is 0x" + StringsKt.padStart(Integer.toString(r100 & UByte.MAX_VALUE, CharsKt.checkRadix(16)), 2, '0')).toString());
    }

    public static final Throwable b(int r100, int r101) {
        return new IndexOutOfBoundsException("0 (offset) + " + r100 + " (length) > " + r101 + " (array.length)");
    }
}
