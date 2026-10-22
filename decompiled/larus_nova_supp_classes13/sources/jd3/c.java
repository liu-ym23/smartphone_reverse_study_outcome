package jd3;

import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class c extends com.bytedance.android.ec.core.event.a {
    public c() {
        Intrinsics.checkNotNullParameter("enter_product_detail_fail", "event");
        super("enter_product_detail_fail");
    }

    public final void a(JSONObject r5) {
        if (r5 == null) goto L28;
        Iterator<String> r0 = r5.keys();
    L18:
    L15:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L5:
        if (r0.hasNext() == false) goto L29;
        String r1 = r0.next();     // Catch: Exception -> L15
        if (r1 == null) goto L14;
        String r2 = r1;     // Catch: Exception -> L15
        String r3 = r5.optString(r2);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r3) == true) goto L18;
        if (TextUtils.equals("null", r3) == true) goto L18;
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L15
        com.bytedance.android.ec.core.event.a.b.a.getClass();     // Catch: Exception -> L15
        appendParam(r2, r3, com.bytedance.android.ec.core.event.a.b.a.a);     // Catch: Exception -> L15
        goto L18
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L15
    L29:
        return;
    }
}
