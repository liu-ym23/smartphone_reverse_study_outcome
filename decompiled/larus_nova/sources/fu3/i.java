package fu3;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes14.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f478903a = null;

    public static class a extends ThreadLocal<ArrayList<h>> {
        @Override // java.lang.ThreadLocal
        public final ArrayList<h> initialValue() {
            ArrayList<h> r100 = new ArrayList();
            r100.add(new h());
            r100.add(new h());
            return r100;
        }

        public a() {
        }
    }

    static {
        f478903a = new a();
    }
}
