package com.obric.assistant.cocreationreview;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class m {
    public static final String a(JsonObject r100, String r101) {
        JsonElement r102 = r100.get(r101);
        String r103 = null;
        if (r102 != null) goto L5;
    L10:
        String r104 = null;
    L11:
        if (r104 == null) goto L18;
        if ((!StringsKt.isBlank(r104)) == false) goto L15;
        r103 = r104;
    L15:
        if (r103 == null) goto L18;
        return r103;
    L18:
        throw new IllegalStateException("Missing feedback media field: ".concat(r101).toString());
    L5:
        if (r102.isJsonNull() == false) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L10;
        r104 = r102.getAsString();
        goto L11
    }
}
