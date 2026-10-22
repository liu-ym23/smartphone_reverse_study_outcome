package wv7;

/* JADX INFO: loaded from: classes23.dex */
public final class a {
    public static int a(int r100, int r101) {
        if (r100 < 0) goto L8;
        if (r100 > 127) goto L8;
        return (r100 << 24) | (r101 & (-2130706433));
    L8:
        throw new IllegalArgumentException("Segment value is out of range. (segment = " + r100 + ")");
    }
}
