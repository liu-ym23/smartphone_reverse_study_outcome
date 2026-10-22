package gi2;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements com.bytedance.android.shopping.ligo.monitor.a {
    public final /* synthetic */ a a;

    public final String a() {
        return "good_list";
    }

    public b(a r1) {
        this.a = r1;
    }

    public final void b(String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        v r0 = new v(r3, this.a);
        if (r4 == null) goto L8;
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        Map.Entry<String, String> r6 = r5.next();
        r0.c(r6.getKey(), r6.getValue());
    L8:
        r0.i(null);
    }
}
