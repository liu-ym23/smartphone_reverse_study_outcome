package com.bytedance.ies.xbridge;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f249441a;

    @Override // com.bytedance.ies.xbridge.t
    public final v asArray() {
        Object r100 = this.f249441a;
        if ((r100 instanceof JSONArray) == false) goto L7;
        return new l((JSONArray) r100);
    L7:
        throw new Exception("Dynamic is not JSONArray");
    }

    @Override // com.bytedance.ies.xbridge.t
    public final boolean asBoolean() {
        Object r100 = this.f249441a;
        if ((r100 instanceof Boolean) == false) goto L7;
        return ((Boolean) r100).booleanValue();
    L7:
        throw new Exception("Dynamic is not Boolean");
    }

    @Override // com.bytedance.ies.xbridge.t
    public final double asDouble() {
        Object r100 = this.f249441a;
        if ((r100 instanceof Double) == false) goto L6;
        return ((Number) r100).doubleValue();
    L6:
        if ((r100 instanceof Integer) == false) goto L9;
        return ((Number) r100).intValue();
    L9:
        if ((r100 instanceof Float) == false) goto L12;
        return ((Number) r100).floatValue();
    L12:
        if ((r100 instanceof Long) == false) goto L16;
        return ((Number) r100).longValue();
    L16:
        throw new Exception("Dynamic is not Double");
    }

    @Override // com.bytedance.ies.xbridge.t
    public final int asInt() {
        Object r100 = this.f249441a;
        if ((r100 instanceof Integer) == false) goto L7;
        return ((Number) r100).intValue();
    L7:
        throw new Exception("Dynamic is not Int");
    }

    @Override // com.bytedance.ies.xbridge.t
    public final XReadableMap asMap() {
        Object r100 = this.f249441a;
        if ((r100 instanceof JSONObject) == false) goto L7;
        return new ReadableMapImpl((JSONObject) r100);
    L7:
        throw new Exception("Dynamic is not JSONObject");
    }

    @Override // com.bytedance.ies.xbridge.t
    public final String asString() {
        Object r100 = this.f249441a;
        if ((r100 instanceof String) == false) goto L7;
        return (String) r100;
    L7:
        throw new Exception("Dynamic is not String");
    }

    @Override // com.bytedance.ies.xbridge.t
    public XReadableType getType() {
        Object r100 = this.f249441a;
        if ((r100 instanceof JSONArray) == false) goto L6;
        return XReadableType.Array;
    L6:
        if ((r100 instanceof Boolean) == false) goto L9;
        return XReadableType.Boolean;
    L9:
        if ((r100 instanceof JSONObject) == false) goto L12;
        return XReadableType.Map;
    L12:
        if ((r100 instanceof Number) == false) goto L15;
        return XReadableType.Number;
    L15:
        if ((r100 instanceof String) == false) goto L18;
        return XReadableType.String;
    L18:
        return XReadableType.Null;
    }

    public b(Object r100) {
        this.f249441a = r100;
    }
}
