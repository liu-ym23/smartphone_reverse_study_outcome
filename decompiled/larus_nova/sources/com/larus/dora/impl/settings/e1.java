package com.larus.dora.impl.settings;

import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class e1 {
    public static final String c(JsonElement r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isJsonPrimitive() == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L20;
        JsonPrimitive r101 = r100.getAsJsonPrimitive();
        if (r101 != null) goto L13;
        return null;
    L13:
        if (r101.isString() == true) goto L16;
        r101 = null;
    L16:
        if (r101 != null) goto L18;
        return null;
    L18:
        return r101.getAsString();
    L20:
        return null;
    }

    public static final float a(String r100, String r101) {
        float r102 = CastFloatProtector.parseFloat(r101);
        if (r100 == null) goto L20;
        String r103 = StringsKt.trim(r100).toString();
        if (r103 == null) goto L21;
        Float r104 = StringsKt.toFloatOrNull(r103);
        if (r104 == null) goto L22;
        Float r105 = Float.valueOf(r104.floatValue());
        float r106 = r105.floatValue();
        if (r106 >= 0.0f) goto L11;
    L13:
        boolean r107 = false;
    L14:
        if (r107 == true) goto L17;
        r105 = null;
    L17:
        if (r105 != null) goto L19;
        return r102;
    L19:
        return r105.floatValue();
    L11:
        if (r106 >= 24.0f) goto L13;
        r107 = true;
        goto L14
    L22:
        return r102;
    L21:
        return r102;
    L20:
        return r102;
    }

    public static final long b(String r100, String r101) {
        long r102 = CastLongProtector.parseLong(r101) * 60000;
        if (r100 == null) goto L20;
        String r103 = StringsKt.trim(r100).toString();
        if (r103 == null) goto L21;
        Long r104 = StringsKt.toLongOrNull(r103);
        if (r104 == null) goto L22;
        Long r105 = Long.valueOf(r104.longValue());
        long r106 = r105.longValue();
        if (r106 > 0) goto L11;
    L13:
        boolean r107 = false;
    L14:
        if (r107 == true) goto L17;
        r105 = null;
    L17:
        if (r105 != null) goto L19;
        return r102;
    L19:
        return r105.longValue() * 60000;
    L11:
        if (r106 > 153722867280912L) goto L13;
        r107 = true;
        goto L14
    L22:
        return r102;
    L21:
        return r102;
    L20:
        return r102;
    }
}
