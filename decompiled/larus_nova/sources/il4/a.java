package il4;

/* JADX INFO: loaded from: classes15.dex */
public abstract class a extends hl4.a {

    /* JADX INFO: renamed from: il4.a$a, reason: collision with other inner class name */
    public static final class C6281a extends a {
        public C6281a() {
            super(null);
        }
    }

    public static final class b extends a {
        public b(int r100) {
            super(Integer.valueOf(r100));
        }
    }

    public a(Integer r100) {
        if (r100 == null) goto L4;
        byte[] r101 = {(byte) r100.intValue()};
    L5:
        super(4, 11, r101);
        return;
    L4:
        r101 = null;
        goto L5
    }
}
