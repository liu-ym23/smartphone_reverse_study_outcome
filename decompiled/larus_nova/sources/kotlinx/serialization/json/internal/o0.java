package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes5.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f505451a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f505452b = null;

    public static final char c(int r100) {
        int r101 = r100 & 15;
        if (r101 >= 10) goto L5;
        int r102 = r101 + 48;
    L7:
        return (char) r102;
    L5:
        r102 = (r101 - 10) + 97;
        goto L7
    }

    static {
        String[] r100 = new String[93];
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= 32) goto L6;
        r100[r102] = "\\u" + c(r102 >> 12) + c(r102 >> 8) + c(r102 >> 4) + c(r102);
        r102 = r102 + 1;
        goto L4
    L6:
        r100[34] = "\\\"";
        r100[92] = "\\\\";
        r100[9] = "\\t";
        r100[8] = "\\b";
        r100[10] = "\\n";
        r100[13] = "\\r";
        r100[12] = "\\f";
        f505451a = r100;
        byte[] r103 = new byte[93];
    L7:
        if (r101 >= 32) goto L9;
        r103[r101] = 1;
        r101 = r101 + 1;
        goto L7
    L9:
        r103[34] = 34;
        r103[92] = 92;
        r103[9] = 116;
        r103[8] = 98;
        r103[10] = 110;
        r103[13] = 114;
        r103[12] = 102;
        f505452b = r103;
    }

    public static final Boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (StringsKt.equals(r100, "true", true) == false) goto L6;
        return Boolean.TRUE;
    L6:
        if (StringsKt.equals(r100, "false", true) == true) goto L11;
        return null;
    L11:
        return Boolean.FALSE;
    }

    public static final void a(StringBuilder r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "value");
        r100.append(Typography.quote);
        int r102 = r101.length();
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L10;
        char r105 = r101.charAt(r103);
        String[] r106 = f505451a;
        if (r105 >= r106.length) goto L9;
        if (r106[r105] == null) goto L9;
        r100.append(r101, r104, r103);
        r100.append(r106[r105]);
        r104 = r103 + 1;
    L9:
        r103 = r103 + 1;
        goto L3
    L10:
        if (r104 == 0) goto L12;
        r100.append(r101, r104, r101.length());
    L13:
        r100.append(Typography.quote);
        return;
    L12:
        r100.append(r101);
        goto L13
    }
}
