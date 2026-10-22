package o66;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.t;
import com.bytedance.ies.xbridge.u;
import com.bytedance.ies.xbridge.v;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements XReadableMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f522205a;

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final u keyIterator() {
        return new b(this.f522205a.keys());
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final Map<String, Object> toMap() {
        int r100 = com.bytedance.ies.xbridge.platform.web.a.f249528a;
        return com.bytedance.ies.xbridge.platform.web.a.b(this.f522205a);
    }

    public d(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f522205a = r100;
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final t get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return new a(this.f522205a.opt(r100));
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final v getArray(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        JSONArray r101 = this.f522205a.optJSONArray(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return new c(r101);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final boolean getBoolean(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f522205a.optBoolean(r100);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final double getDouble(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f522205a.optDouble(r100);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final int getInt(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f522205a.optInt(r100);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final XReadableMap getMap(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        JSONObject r101 = this.f522205a.optJSONObject(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return new d(r101);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final String getString(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f522205a.optString(r100);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public XReadableType getType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Object r101 = this.f522205a.opt(r100);
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
    public final boolean hasKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f522205a.has(r100);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final boolean isNull(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f522205a.isNull(r100);
    }
}
