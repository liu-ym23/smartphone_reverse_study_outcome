package b05;

import com.bytedance.ee.bear.contract.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final d a;
    public final HashMap<String, Object> b;

    /* JADX INFO: renamed from: b05.a$a, reason: collision with other inner class name */
    public static final class C0005a {
    }

    static {
    }

    public a(d r4) {
        Intrinsics.checkNotNullParameter(r4, "analyticService");
        this.a = r4;
        this.b = new HashMap();
        HashMap<String, Object> r5 = r4.m("docCommonParams");
        if ((!r5.isEmpty()) == false) goto L8;
        Iterator<Map.Entry<String, Object>> r6 = r5.entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        Map.Entry<String, Object> r0 = r6.next();
        this.b.put(r0.getKey(), r0.getValue());
        goto L6
    L10:
        return;
    }
}
