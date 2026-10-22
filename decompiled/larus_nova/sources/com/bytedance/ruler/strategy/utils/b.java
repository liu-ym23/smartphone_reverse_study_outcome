package com.bytedance.ruler.strategy.utils;

import com.bytedance.express.command.Instruction;
import com.bytedance.express.command.Primitive;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes15.dex */
public final class b {
    public static final JsonObject a(Instruction r100) {
        JsonObject r101 = new JsonObject();
        r101.add(RXScreenCaptureService.KEY_INDEX, new JsonPrimitive(Integer.valueOf(r100.getI())));
        Primitive r102 = com.bytedance.express.command.e.a((r100.getI() << 18) >> 28);
        switch(a.f267748a[r102.ordinal()]) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L22;
            case 4: goto L22;
            case 5: goto L17;
            case 6: goto L12;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        JsonElement r103 = JsonNull.INSTANCE;
    L26:
        r101.add(BaseSwitches.V, r103);
        return r101;
    L7:
        Object r104 = r100.getV();
        if (r104 == null) goto L11;
        JsonPrimitive r105 = new JsonPrimitive((Boolean) r104);
    L25:
        r103 = r105;
        goto L26
    L11:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
    L12:
        Object r106 = r100.getV();
        if (r106 == null) goto L16;
        r105 = new JsonPrimitive((String) r106);
        goto L25
    L16:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    L17:
        Object r107 = r100.getV();
        if (r107 == null) goto L21;
        r105 = new JsonPrimitive((Character) r107);
        goto L25
    L21:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Char");
    L22:
        Object r108 = r100.getV();
        if (r108 == null) goto L29;
        r105 = new JsonPrimitive((Number) r108);
        goto L25
    L29:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Number");
    L5:
        throw new IllegalArgumentException("unsupported primitive type");
    }
}
