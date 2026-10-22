package com.bytedance.android.shopping.extensions;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d {

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/shopping/extensions/d$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<Map<String, ? extends String>> {
        public a() {
        }
    }

    public static final void a(JSONObject r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$appendByString");
        if (r3 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L21;
        return;
    L21:
        Iterator r4 = ((Map) GsonProtectorUtils.fromJson(u0.c(), r3, new a().getType())).entrySet().iterator();     // Catch: JSONException -> L16 JsonSyntaxException -> L18
    L13:
        if (r4.hasNext() == false) goto L26;
        Map.Entry r1 = (Map.Entry) r4.next();     // Catch: JSONException -> L16 JsonSyntaxException -> L18
        r2.put((String) r1.getKey(), r1.getValue());     // Catch: JSONException -> L16 JsonSyntaxException -> L18
    L26:
        return;
    L16:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L18:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public static final void b(JSONObject r1, String r2, String r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r3 != null) goto L14;
        return;
    L14:
    L11:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L7:
        if (r1.opt(r2) == null) goto L9;
        return;
    L9:
        r1.put(r2, r3);     // Catch: Exception -> L11
    }
}
