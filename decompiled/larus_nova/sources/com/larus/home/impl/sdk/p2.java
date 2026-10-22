package com.larus.home.impl.sdk;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class p2 {
    public static final Object a(String r100, JSONObject r101) {
        if (r101 == null) goto L30;
        List r102 = StringsKt.split$default(r100, new String[]{"."}, false, 0, 6, null);
        if (r102.isEmpty() == true) goto L31;
        int r103 = 0;
        Object r104 = r101;
    L9:
        if (r104 == null) goto L21;
        if (r103 >= r102.size()) goto L21;
        String r105 = (String) ListProtector.get(r102, r103);
        if ((r104 instanceof Map) == false) goto L16;
        Object r106 = ((Map) r104).get(r105);
    L19:
        r103 = r103 + 1;
        r104 = r106;
        goto L9
    L16:
        if ((r104 instanceof JSONObject) == false) goto L18;
        r106 = ((JSONObject) r104).opt(r105);
        goto L19
    L18:
        r106 = null;
    L21:
        if (Intrinsics.areEqual(r104, JSONObject.NULL) == false) goto L23;
        return null;
    L23:
        return r104;
    L31:
        return null;
    L30:
        return null;
    }
}
