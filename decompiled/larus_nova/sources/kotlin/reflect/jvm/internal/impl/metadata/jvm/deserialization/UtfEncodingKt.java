package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class UtfEncodingKt {
    public static final byte[] stringsToBytes(String[] r110) {
        Intrinsics.checkNotNullParameter(r110, "strings");
        int r100 = r110.length;
        int r101 = 0;
        int r102 = 0;
    L3:
        if (r101 >= r100) goto L5;
        r102 = r102 + r110[r101].length();
        r101 = r101 + 1;
        goto L3
    L5:
        byte[] r103 = new byte[r102];
        int r104 = r110.length;
        int r105 = 0;
        int r106 = 0;
    L6:
        if (r105 >= r104) goto L11;
        String r107 = r110[r105];
        int r108 = r107.length();
        int r109 = 0;
    L8:
        if (r109 >= r108) goto L10;
        r103[r106] = (byte) r107.charAt(r109);
        r109 = r109 + 1;
        r106 = r106 + 1;
        goto L8
    L10:
        r105 = r105 + 1;
        goto L6
    L11:
        return r103;
    }
}
