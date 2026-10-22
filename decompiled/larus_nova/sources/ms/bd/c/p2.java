package ms.bd.c;

/* JADX INFO: loaded from: classes5.dex */
public abstract class p2 {
    public static native Object a(int r100, int r101, long r102, String r103, Object r104);

    public p2() {
    }

    public static Object b(int r100, int r101, long r102, String r103, Object r104) {
        return i2.a(r100, r101, r102, r103, r104);
    L4:
        th = move-exception;
        throw new RuntimeException(th);
    }
}
