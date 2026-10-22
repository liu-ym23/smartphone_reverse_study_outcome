package kotlin.io.encoding;

import com.bytedance.android.ec.core.event.a;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\b\u001a5\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\b\u001a%\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\b\u001a%\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0081\b¨\u0006\u000e"}, d2 = {"platformCharsToBytes", "", "Lkotlin/io/encoding/Base64;", "source", "", "startIndex", "", "endIndex", "platformEncodeIntoByteArray", a.KEY_DESTINATION, "destinationOffset", "platformEncodeToByteArray", "platformEncodeToString", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class Base64JVMKt {
    private static final byte[] platformCharsToBytes(Base64 r100, CharSequence r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "source");
        if ((r101 instanceof String) == false) goto L6;
        r100.checkSourceBounds$kotlin_stdlib(r101.length(), r102, r103);
        String r104 = ((String) r101).substring(r102, r103);
        Charset r105 = Charsets.ISO_8859_1;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type java.lang.String");
        return r104.getBytes(r105);
    L6:
        return r100.charsToBytesImpl$kotlin_stdlib(r101, r102, r103);
    }

    private static final byte[] platformEncodeToByteArray(Base64 r100, byte[] r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "source");
        return r100.encodeToByteArrayImpl$kotlin_stdlib(r101, r102, r103);
    }

    private static final String platformEncodeToString(Base64 r100, byte[] r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "source");
        return new String(r100.encodeToByteArrayImpl$kotlin_stdlib(r101, r102, r103), Charsets.ISO_8859_1);
    }

    private static final int platformEncodeIntoByteArray(Base64 r100, byte[] r101, byte[] r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, a.KEY_DESTINATION);
        return r100.encodeIntoByteArrayImpl$kotlin_stdlib(r101, r102, r103, r104, r105);
    }
}
