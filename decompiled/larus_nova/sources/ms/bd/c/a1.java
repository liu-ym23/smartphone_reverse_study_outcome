package ms.bd.c;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a1 {
    public static byte[] a(String r100) {
        int r101 = r100.length();
        byte[] r102 = new byte[r101 / 2];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        int r104 = Character.digit(r100.charAt(r103), 16) << 4;
        r102[r103 / 2] = (byte) (Character.digit(r100.charAt(r103 + 1), 16) + r104);
        r103 = r103 + 2;
        goto L3
    L5:
        return r102;
    }
}
