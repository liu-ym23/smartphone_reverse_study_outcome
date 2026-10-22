package com.bytedance.ies.xbridge;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0016\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0016R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ies/xbridge/ReadableMapImpl;", "Lcom/bytedance/ies/xbridge/XReadableMap;", "", "name", "", "hasKey", "isNull", "getBoolean", "", "getDouble", "", "getInt", "getString", "Lcom/bytedance/ies/xbridge/v;", "getArray", "getMap", "Lcom/bytedance/ies/xbridge/t;", MonitorConstants.CONNECT_TYPE_GET, "Lcom/bytedance/ies/xbridge/XReadableType;", "getType", "Lcom/bytedance/ies/xbridge/u;", "keyIterator", "", "", "toMap", "Lorg/json/JSONObject;", PlayerResolution.SDKKEY.ORIGIN, "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class ReadableMapImpl implements XReadableMap {
    private final JSONObject origin;

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public u keyIterator() {
        return new j(this.origin.keys());
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public Map<String, Object> toMap() {
        int r100 = com.bytedance.ies.xbridge.utils.e.f249556a;
        return com.bytedance.ies.xbridge.utils.e.b(this.origin);
    }

    public ReadableMapImpl(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.origin = r100;
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public t get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return new b(this.origin.opt(r100));
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public v getArray(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        JSONArray r101 = this.origin.optJSONArray(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return new l(r101);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public boolean getBoolean(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.origin.optBoolean(r100);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public double getDouble(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.origin.optDouble(r100);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public int getInt(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.origin.optInt(r100);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public XReadableMap getMap(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        JSONObject r101 = this.origin.optJSONObject(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return new ReadableMapImpl(r101);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public String getString(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.origin.optString(r100);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public XReadableType getType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Object r101 = this.origin.opt(r100);
        if ((r101 instanceof JSONArray) == false) goto L6;
        return XReadableType.Array;
    L6:
        if ((r101 instanceof Boolean) == false) goto L9;
        return XReadableType.Boolean;
    L9:
        if ((r101 instanceof JSONObject) == false) goto L12;
        return XReadableType.Map;
    L12:
        if ((r101 instanceof Integer) == false) goto L15;
        return XReadableType.Int;
    L15:
        if ((r101 instanceof Number) == false) goto L18;
        return XReadableType.Number;
    L18:
        if ((r101 instanceof String) == false) goto L21;
        return XReadableType.String;
    L21:
        return XReadableType.Null;
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public boolean hasKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.origin.has(r100);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public boolean isNull(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.origin.isNull(r100);
    }
}
