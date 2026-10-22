package nm5;

import com.bytedance.ee.bear.share.newshare.e0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public final Map<Class<?>, Integer> a;
    public e0 b;

    public c() {
        this.a = new HashMap();
    }

    public final int a(e0 r3) {
        Class<?> r4 = r3.getClass();
        Integer r0 = (Integer) ((HashMap) this.a).get(r4);
        if (r0 != null) goto L6;
        r0 = Integer.valueOf(((HashMap) this.a).size() + 1);
        ((HashMap) this.a).put(r4, r0);
    L6:
        return r0.intValue();
    }
}
