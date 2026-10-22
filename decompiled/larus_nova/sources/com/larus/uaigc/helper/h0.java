package com.larus.uaigc.helper;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class h0 {
    public static final void a(JSONObject r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "json");
        Iterator<String> r102 = r101.keys();
        Intrinsics.checkNotNull(r102);
    L4:
        if (r102.hasNext() == false) goto L17;
        String r103 = r102.next();
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == true) goto L4;
        Object r105 = r101.opt(r103);
        if (r105 == null) goto L4;
        r100.put(r103, r105);
        goto L4
    L8:
        if (StringsKt.isBlank(r103) == true) goto L11;
        r104 = false;
        goto L12
    }
}
