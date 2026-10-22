package va1;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public va1.a f553921a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f553922a = null;

        static {
            f553922a = new b();
        }
    }

    public b() {
    }

    public final <T> T a(Class<T> r100) {
        va1.a r101 = this.f553921a;
        if (r101 != null) goto L5;
        c r102 = c.a.f553925a;
        r102.getClass();
        String r103 = r100.getName();
        T r104 = (T) ((ConcurrentHashMap) r102.f553923a).get(r103);
        if (r104 == null) goto L9;
        return r104;
    L9:
        if (r102.f553924b.contains(r103) == true) goto L13;
        r102.f553924b.add(r100.getName());
        return null;
    L13:
        return r104;
    L5:
        return (T) r101.getRealService(r100);
    }
}
