package il4;

/* JADX INFO: loaded from: classes15.dex */
public abstract class b extends hl4.a {

    public static final class a extends b {
        public a() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: il4.b$b, reason: collision with other inner class name */
    public static final class C6282b extends b {
        public C6282b(int r100) {
            super(Integer.valueOf(r100));
        }
    }

    public b(Integer r100) {
        if (r100 == null) goto L5;
        byte[] r101 = {(byte) r100.intValue()};
    L6:
        super(5, 1, r101);
        return;
    L5:
        r101 = null;
        goto L6
    }
}
