package com.bytedance.android.shopping.ligo.monitor;

import com.bytedance.android.ec.sdk.helper.g;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.shopping.ligo.monitor.a$a, reason: collision with other inner class name */
    public static final class C0073a {
        public static void a(String r4, Map r5) {
            Intrinsics.checkNotNullParameter(r4, "eventName");
            g r0 = g.a;
            JSONObject r1 = new JSONObject();
            if (r5 == null) goto L8;
            Iterator r6 = r5.entrySet().iterator();
        L6:
            if (r6.hasNext() == false) goto L8;
            Map.Entry r2 = (Map.Entry) r6.next();
            r1.put((String) r2.getKey(), r2.getValue());
        L8:
            Unit r7 = Unit.INSTANCE;
            r0.logV3(r4, r1);
        }
    }

    String a();

    void b(String r1, Map<String, String> r2);
}
