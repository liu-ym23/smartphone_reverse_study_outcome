package w4a;

import com.lynx.animax.service.IAnimaXService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<? extends IAnimaXService>, IAnimaXService> f558279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f558280b;

    public d(e r100) {
        this.f558279a = new ConcurrentHashMap();
        this.f558280b = r100;
    }

    public final <T extends IAnimaXService> T a(Class<T> r100) {
        IAnimaXService r101 = (IAnimaXService) ((ConcurrentHashMap) this.f558279a).get(r100);
        if (r101 != null) goto L5;
        a r102 = a.b();
        e r103 = this.f558280b;
        Map r104 = (Map) ((ConcurrentHashMap) r102.f558278a).get(r103);
        if (r104 != null) goto L9;
    L11:
        return null;
    L9:
        if (r104.containsKey(r100) == false) goto L11;
        return (T) r104.get(r100);
    L5:
        return r100.cast(r101);
    }
}
