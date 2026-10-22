package com.bytedance.ies.xbridge;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class l implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONArray f249504a;

    @Override // com.bytedance.ies.xbridge.v
    public final int size() {
        return this.f249504a.length();
    }

    @Override // com.bytedance.ies.xbridge.v
    public final List<Object> toList() {
        int r100 = com.bytedance.ies.xbridge.utils.e.f249556a;
        return com.bytedance.ies.xbridge.utils.e.a(this.f249504a);
    }

    public l(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f249504a = r100;
    }

    @Override // com.bytedance.ies.xbridge.v
    public final t get(int r100) {
        return new b(this.f249504a.opt(r100));
    }

    @Override // com.bytedance.ies.xbridge.v
    public final v getArray(int r100) {
        JSONArray r101 = this.f249504a.optJSONArray(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return new l(r101);
    }

    @Override // com.bytedance.ies.xbridge.v
    public final boolean getBoolean(int r100) {
        return this.f249504a.optBoolean(r100);
    }

    @Override // com.bytedance.ies.xbridge.v
    public final double getDouble(int r100) {
        return this.f249504a.optDouble(r100);
    }

    @Override // com.bytedance.ies.xbridge.v
    public final int getInt(int r100) {
        return this.f249504a.optInt(r100);
    }

    @Override // com.bytedance.ies.xbridge.v
    public final XReadableMap getMap(int r100) {
        JSONObject r101 = this.f249504a.optJSONObject(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return new ReadableMapImpl(r101);
    }

    @Override // com.bytedance.ies.xbridge.v
    public final String getString(int r100) {
        return this.f249504a.optString(r100);
    }

    @Override // com.bytedance.ies.xbridge.v
    public XReadableType getType(int r100) {
        Object r101 = this.f249504a.opt(r100);
        if ((r101 instanceof JSONArray) == false) goto L6;
        return XReadableType.Array;
    L6:
        if ((r101 instanceof Boolean) == false) goto L9;
        return XReadableType.Boolean;
    L9:
        if ((r101 instanceof JSONObject) == false) goto L12;
        return XReadableType.Map;
    L12:
        if ((r101 instanceof Number) == false) goto L15;
        return XReadableType.Number;
    L15:
        if ((r101 instanceof String) == false) goto L18;
        return XReadableType.String;
    L18:
        return XReadableType.Null;
    }
}
