package com.obric.assistant.settings.autogui;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/* JADX INFO: loaded from: classes33.dex */
public final class i {
    public static final String a(JsonObject r100, String r101) {
        JsonElement r102 = r100.get(r101);
        if (r102 != null) goto L6;
    L13:
        return "";
    L6:
        if (r102.isJsonNull() == true) goto L13;
        if (r102.isJsonPrimitive() == false) goto L11;
        JsonPrimitive r103 = r102.getAsJsonPrimitive();
    L12:
        if (r103 == null) goto L13;
        return r103.getAsString();
    L11:
        r103 = null;
        goto L12
    }
}
