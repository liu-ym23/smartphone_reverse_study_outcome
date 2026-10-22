package ak5;

import io.reactivex.functions.Function;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t implements Function<l, k> {
    public final boolean a;
    public final Map<String, String> b;

    public final Object apply(Object r3) throws Exception {
        k r0 = new k();
        r0.a = (l) r3;
        r0.b = this.a;
        Map<String, String> r4 = this.b;
        ((HashMap) r0.c).putAll(r4);
        return r0;
    }

    public t(boolean r2, Map<String, String> r3) {
        HashMap r0 = new HashMap();
        this.b = r0;
        this.a = r2;
        r0.putAll(r3);
    }
}
