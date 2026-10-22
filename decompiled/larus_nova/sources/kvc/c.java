package kvc;

import okio.Buffer;

/* JADX INFO: loaded from: classes42.dex */
public final class c {
    public static String a(int r100) {
        if (r100 < 1000) goto L20;
        if (r100 >= 5000) goto L20;
        if (r100 < 1004) goto L12;
        if (r100 > 1006) goto L12;
    L16:
        return "Code " + r100 + " is reserved and may not be used.";
    L12:
        if (r100 >= 1012) goto L14;
        return null;
    L14:
        if (r100 <= 2999) goto L16;
        return null;
    L20:
        return "Code must be in range [1000,5000): " + r100;
    }

    public static void b(Buffer.a r100, byte[] r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        byte[] r104 = r100.f523961e;
        int r105 = r100.f523962f;
        int r106 = r100.f523963g;
    L4:
        if (r105 >= r106) goto L7;
        int r107 = r103 % r102;
        r104[r105] = (byte) (r104[r105] ^ r101[r107]);
        r105 = r105 + 1;
        r103 = r107 + 1;
        goto L4
    L7:
        if (r100.a() != (-1)) goto L3;
    }
}
