package com.bytedance.applet.impl.moa;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g {
    public static final JSONObject b(String r1) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r2 = Result.constructor-impl(new JSONObject(r1));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r2) == false) goto L10;
        r2 = null;
    L10:
        return (JSONObject) r2;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static final Object c(Object r4) {
        if (Intrinsics.areEqual(r4, JSONObject.NULL) == false) goto L6;
        return null;
    L6:
        if ((r4 instanceof JSONObject) == false) goto L9;
        return d((JSONObject) r4);
    L9:
        if ((r4 instanceof JSONArray) == false) goto L18;
        JSONArray r5 = (JSONArray) r4;
        List r0 = CollectionsKt.createListBuilder(r5.length());
        int r1 = r5.length();
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L14;
        r0.add(c(r5.opt(r2)));
        r2 = r2 + 1;
        goto L11
    L14:
        return CollectionsKt.build(r0);
    L18:
        return r4;
    }

    public static final Map<String, Object> d(JSONObject r4) {
        Map r0 = MapsKt.createMapBuilder();
        Iterator<String> r1 = r4.keys();
    L4:
        if (r1.hasNext() == false) goto L7;
        String r2 = r1.next();
        Intrinsics.checkNotNull(r2);
        r0.put(r2, c(r4.opt(r2)));
        goto L4
    L7:
        return MapsKt.build(r0);
    }

    public static final String a(JSONObject r1, String r2) {
        Object r3 = r1.opt(r2);
        if ((r3 instanceof String) == false) goto L5;
        String r4 = (String) r3;
    L6:
        if (r4 == null) goto L16;
        String r5 = StringsKt.trim(r4).toString();
        if (r5 != null) goto L10;
        return null;
    L10:
        if (r5.length() <= 0) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == true) goto L15;
        return null;
    L15:
        return r5;
    L12:
        r6 = false;
        goto L13
    L16:
        return null;
    L5:
        r4 = null;
        goto L6
    }
}
