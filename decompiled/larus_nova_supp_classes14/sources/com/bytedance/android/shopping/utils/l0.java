package com.bytedance.android.shopping.utils;

import android.net.Uri;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l0 {
    public static final String b(String r7, Pair... r8) {
        Intrinsics.checkNotNullParameter(r7, "$this$appendOrReplaceSchemaJsonParams");
        Intrinsics.checkNotNullParameter(r8, "params");
        Uri r1 = UriProtector.parse(r7);     // Catch: Exception -> L20
        String r2 = UriProtector.getQueryParameter(r1, "ecom_live_params");     // Catch: Exception -> L20
        int r3 = 0;
        if (r2 != null) goto L6;
    L10:
        r2 = "{}";
    L11:
        JSONObject r4 = new JSONObject(r2);     // Catch: Exception -> L20
        int r5 = r8.length;     // Catch: Exception -> L20
    L12:
        if (r3 >= r5) goto L18;
        Pair r6 = r8[r3];     // Catch: Exception -> L20
        String r9 = (String) r6.component1();     // Catch: Exception -> L20
        String r10 = (String) r6.component2();     // Catch: Exception -> L20
        if (r9 == null) goto L17;
        if (r10 == null) goto L17;
        r4.put(r9, r10);     // Catch: Exception -> L20
    L17:
        r3 = r3 + 1;     // Catch: Exception -> L20
        goto L12
    L18:
        return c(r1, "ecom_live_params", r4.toString()).toString();
    L6:
        if (r2.length() != 0) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == false) goto L11;
    L8:
        r11 = false;
    L20:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return r7;
    }

    public static final String a(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$appendOrReplaceParameter");
        return c(UriProtector.parse(r1), r2, r3).toString();
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return r1;
    }

    public static final Uri c(Uri r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "$this$replaceOrAppendParameter");
        if (r7 == null) goto L26;
        if (r8 == null) goto L27;
        Uri.Builder r0 = r6.buildUpon();
        r0.clearQuery();
        Iterator r1 = UriProtector.getQueryParameterNames(r6).iterator();
        boolean r2 = false;
    L8:
        if (r1.hasNext() == false) goto L16;
        String r3 = (String) r1.next();
        if ((!Intrinsics.areEqual(r3, r7)) == true) goto L11;
        r0.appendQueryParameter(r3, r8);
        r2 = true;
        goto L8
    L11:
        Iterator r4 = UriProtector.getQueryParameters(r6, r3).iterator();
    L13:
        if (r4.hasNext() == false) goto L8;
        r0.appendQueryParameter(r3, (String) r4.next());
        goto L13
    L16:
        if (r2 == true) goto L19;
        r0.appendQueryParameter(r7, r8);
    L19:
        return r0.build();
    L27:
        return r6;
    L26:
        return r6;
    }
}
