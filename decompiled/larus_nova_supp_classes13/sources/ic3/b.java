package ic3;

import com.bytedance.android.bst.api.g;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements g {
    public final /* synthetic */ Map a;

    public b(Map r1) {
        this.a = r1;
    }

    public final void a(String r4, Map<Object, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "params");
        Iterator r6 = ((LinkedHashMap) r5).entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) r6.next();
        this.a.put(r0.getKey().toString(), String.valueOf(r0.getValue()));
        goto L4
    L6:
        new a(r4, this.a).post(null, null);
    }
}
