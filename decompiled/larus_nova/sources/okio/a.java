package okio;

import kotlin.UByte;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes42.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f523968a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f523969b = null;

    static {
        ByteString.Companion.getClass();
        f523968a = ByteString.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        f523969b = ByteString.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    public static final String a(byte[] r110, byte[] r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "map");
        byte[] r100 = new byte[((r110.length + 2) / 3) * 4];
        int r101 = r110.length - (r110.length % 3);
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r102 >= r101) goto L5;
        int r104 = r102 + 1;
        byte r105 = r110[r102];
        int r106 = r104 + 1;
        byte r107 = r110[r104];
        int r108 = r106 + 1;
        byte r109 = r110[r106];
        int r112 = r103 + 1;
        r100[r103] = r111[(r105 & UByte.MAX_VALUE) >> 2];
        int r113 = r112 + 1;
        r100[r112] = r111[((r105 & 3) << 4) | ((r107 & UByte.MAX_VALUE) >> 4)];
        int r114 = r113 + 1;
        r100[r113] = r111[((r107 & 15) << 2) | ((r109 & UByte.MAX_VALUE) >> 6)];
        r103 = r114 + 1;
        r100[r114] = r111[r109 & 63];
        r102 = r108;
        goto L3
    L5:
        int r115 = r110.length - r101;
        if (r115 == 1) goto L10;
        if (r115 != 2) goto L11;
        int r116 = r102 + 1;
        byte r117 = r110[r102];
        byte r118 = r110[r116];
        int r119 = r103 + 1;
        r100[r103] = r111[(r117 & UByte.MAX_VALUE) >> 2];
        int r120 = r119 + 1;
        r100[r119] = r111[((r117 & 3) << 4) | ((r118 & UByte.MAX_VALUE) >> 4)];
        r100[r120] = r111[(r118 & 15) << 2];
        r100[r120 + 1] = Base64.padSymbol;
    L11:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new String(r100, Charsets.UTF_8);
    L10:
        byte r121 = r110[r102];
        int r122 = r103 + 1;
        r100[r103] = r111[(r121 & UByte.MAX_VALUE) >> 2];
        int r123 = r122 + 1;
        r100[r122] = r111[(r121 & 3) << 4];
        r100[r123] = Base64.padSymbol;
        r100[r123 + 1] = Base64.padSymbol;
        goto L11
    }
}
