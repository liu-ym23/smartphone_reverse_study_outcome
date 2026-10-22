package com.bytedance.ee.bear.bitable.common;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c {
    public static final Boolean a(JsonObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        Intrinsics.checkNotNullParameter(r101, "key");
        JsonElement r102 = r100.get(r101);
        if (r102 == null) goto L7;
        boolean r103 = true;
        if (r102.isJsonNull() != true) goto L7;
    L9:
        if (r103 == false) goto L11;
        return null;
    L11:
        if (r102 != null) goto L13;
        return null;
    L13:
        return Boolean.valueOf(r102.getAsBoolean());
    L7:
        r103 = false;
        goto L9
    }

    public static final String b(JsonObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        Intrinsics.checkNotNullParameter(r101, "key");
        JsonElement r102 = r100.get(r101);
        if (r102 == null) goto L7;
        boolean r103 = true;
        if (r102.isJsonNull() != true) goto L7;
    L9:
        if (r103 == false) goto L11;
        return null;
    L11:
        if (r102 != null) goto L13;
        return null;
    L13:
        return r102.getAsString();
    L7:
        r103 = false;
        goto L9
    }
}
