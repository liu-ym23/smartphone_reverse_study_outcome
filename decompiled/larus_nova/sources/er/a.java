package er;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<String, kc.a> f473565a = null;

    static {
        f473565a = new b();
    }

    public static kc.a a(String r100) {
        b<String, kc.a> r101 = f473565a;
        b.a<K, V> r102 = (b.a) ((ConcurrentHashMap) r101.f473566a).get(r100);
        if (r102 == 0) goto L14;
        b.a<K, V> r103 = r102.f473568a;
        if (r103 == 0) goto L7;
        r103.f473569b = r102.f473569b;
    L7:
        b.a<K, V> r104 = r102.f473569b;
        if (r104 == 0) goto L10;
        r104.f473568a = r103;
    L10:
        b.a r105 = r101.f473567b;
        r102.f473568a = r105;
        r102.f473569b = r105.f473569b;
        b.a<K, V> r106 = r105.f473569b;
        if (r106 == 0) goto L13;
        r106.f473568a = r102;
    L13:
        r105.f473569b = r102;
        Object r107 = r102.f473571d;
    L16:
        return (kc.a) r107;
    L14:
        r107 = null;
        goto L16
    }
}
