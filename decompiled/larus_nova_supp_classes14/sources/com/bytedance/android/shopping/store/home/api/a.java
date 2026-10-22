package com.bytedance.android.shopping.store.home.api;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(JsonObject r5, Uri r6) {
        Iterator r0 = new HashSet(r5.keySet()).iterator();
    L4:
        if (r0.hasNext() == false) goto L19;
        String r1 = (String) r0.next();
        JsonPrimitive r2 = r5.get(r1);
        if ((r2 instanceof JsonPrimitive) == false) goto L17;
        JsonPrimitive r3 = r2;
        if (r3.isString() == false) goto L17;
        if (Intrinsics.areEqual(r3.getAsString(), "$from_schema$") == false) goto L17;
        if (r6 == null) goto L14;
        String r4 = UriProtector.getQueryParameter(r6, r1);
        if (r4 == null) goto L14;
    L15:
        r5.addProperty(r1, r4);
    L14:
        r4 = "";
    L17:
        if ((r2 instanceof JsonObject) == false) goto L4;
        a((JsonObject) r2, r6);
        goto L4
    }
}
