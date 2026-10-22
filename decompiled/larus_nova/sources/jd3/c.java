package jd3;

import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public abstract class c extends com.bytedance.android.ec.core.event.a {
    public c() {
        Intrinsics.checkNotNullParameter("enter_product_detail_fail", "event");
        super("enter_product_detail_fail");
    }

    public final void a(JSONObject r100) {
        if (r100 == null) goto L28;
        Iterator<String> r101 = r100.keys();
    L18:
    L15:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L5:
        if (r101.hasNext() == false) goto L29;
        String r102 = r101.next();     // Catch: Exception -> L15
        if (r102 == null) goto L14;
        String r103 = r102;     // Catch: Exception -> L15
        String r104 = r100.optString(r103);     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r104) == true) goto L18;
        if (TextUtils.equals("null", r104) == true) goto L18;
        Intrinsics.checkNotNull(r104);     // Catch: Exception -> L15
        com.bytedance.android.ec.core.event.a.b.f44002a.getClass();     // Catch: Exception -> L15
        appendParam(r103, r104, com.bytedance.android.ec.core.event.a.b.C0794a.f44003a);     // Catch: Exception -> L15
        goto L18
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L15
    L29:
        return;
    }
}
