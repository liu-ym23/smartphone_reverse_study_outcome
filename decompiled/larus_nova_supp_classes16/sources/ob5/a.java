package ob5;

import com.bytedance.ee.bear.basesdk.config.j;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements wk5.a {
    public a() {
    }

    public final int a(String r2) {
        Map r0 = j.a;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        Integer r3 = (Integer) r0.get(r2);
        if (r3 != null) goto L10;
        return 1;
    L10:
        return r3.intValue();
    }
}
