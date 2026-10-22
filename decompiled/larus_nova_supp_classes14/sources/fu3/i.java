package fu3;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i {
    public static final a a = null;

    public static class a extends ThreadLocal<ArrayList<h>> {
        @Override // java.lang.ThreadLocal
        public final ArrayList<h> initialValue() {
            ArrayList<h> r0 = new ArrayList();
            r0.add(new h());
            r0.add(new h());
            return r0;
        }

        public a() {
        }
    }

    static {
        a = new a();
    }
}
