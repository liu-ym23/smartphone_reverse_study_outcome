package nm5;

import com.bytedance.ee.bear.share.newshare.e0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, Integer> f519599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e0 f519600b;

    public c() {
        this.f519599a = new HashMap();
    }

    public final int a(e0 r100) {
        Class<?> r101 = r100.getClass();
        Integer r102 = (Integer) ((HashMap) this.f519599a).get(r101);
        if (r102 != null) goto L6;
        r102 = Integer.valueOf(((HashMap) this.f519599a).size() + 1);
        ((HashMap) this.f519599a).put(r101, r102);
    L6:
        return r102.intValue();
    }
}
