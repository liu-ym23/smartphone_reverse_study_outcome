package ytb;

import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes37.dex */
public final class t {
    public static final Object a(Class r100) {
        s r101 = s.f569210a;
        return Proxy.newProxyInstance(r100.getClassLoader(), new Class[]{r100}, r101);
    }
}
