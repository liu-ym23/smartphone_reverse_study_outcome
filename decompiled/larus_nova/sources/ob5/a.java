package ob5;

import com.bytedance.ee.bear.basesdk.config.j;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements wk5.a {
    public a() {
    }

    @Override // wk5.a
    public final int a(String r100) {
        Map<String, Integer> r101 = j.f206601a;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        Integer r102 = r101.get(r100);
        if (r102 != null) goto L10;
        return 1;
    L10:
        return r102.intValue();
    }
}
