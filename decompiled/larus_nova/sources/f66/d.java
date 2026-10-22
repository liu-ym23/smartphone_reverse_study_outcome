package f66;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.t;
import com.bytedance.ies.xbridge.u;
import com.bytedance.ies.xbridge.v;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements XReadableMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f475708a;

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final u keyIterator() {
        return new b(this.f475708a.keys());
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final Map<String, Object> toMap() {
        int r100 = e.f475709a;
        return e.b(this.f475708a);
    }

    public d(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f475708a = r100;
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final t get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return new a(this.f475708a.opt(r100));
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final v getArray(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Object r101 = this.f475708a.optJSONArray(r100);
        if (r101 != null) goto L6;
        r101 = this.f475708a.opt(r100);
    L6:
        if (r101 != null) goto L9;
        return null;
    L9:
        if ((r101 instanceof JSONArray) == false) goto L12;
        return new c((JSONArray) r101);
    L12:
        if ((r101 instanceof List) == false) goto L16;
        int r102 = com.bytedance.ies.xbridge.utils.e.f249556a;
        return new c(com.bytedance.ies.xbridge.utils.e.c((List) r101));
    L16:
        return null;
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final boolean getBoolean(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f475708a.optBoolean(r100);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final double getDouble(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f475708a.optDouble(r100);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final int getInt(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f475708a.optInt(r100);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final XReadableMap getMap(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Object r101 = this.f475708a.optJSONObject(r100);
        if (r101 != null) goto L6;
        r101 = this.f475708a.opt(r100);
    L6:
        if (r101 != null) goto L9;
        return null;
    L9:
        if ((r101 instanceof JSONObject) == false) goto L12;
        return new d((JSONObject) r101);
    L12:
        if ((r101 instanceof Map) == false) goto L16;
        int r102 = com.bytedance.ies.xbridge.utils.e.f249556a;
        return new d(com.bytedance.ies.xbridge.utils.e.d((Map) r101));
    L16:
        return null;
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final String getString(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f475708a.optString(r100);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public XReadableType getType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Object r101 = this.f475708a.opt(r100);
        boolean r102 = true;
        if ((r101 instanceof JSONArray) == false) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        return XReadableType.Array;
    L9:
        if ((r101 instanceof Boolean) == false) goto L12;
        return XReadableType.Boolean;
    L12:
        if ((r101 instanceof JSONObject) == true) goto L15;
        r102 = r101 instanceof Map;
    L15:
        if (r102 == false) goto L18;
        return XReadableType.Map;
    L18:
        if ((r101 instanceof Integer) == false) goto L21;
        return XReadableType.Int;
    L21:
        if ((r101 instanceof Number) == false) goto L24;
        return XReadableType.Number;
    L24:
        if ((r101 instanceof String) == false) goto L27;
        return XReadableType.String;
    L27:
        return XReadableType.Null;
    L5:
        r103 = r101 instanceof List;
        goto L6
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final boolean hasKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f475708a.has(r100);
    }

    @Override // com.bytedance.ies.xbridge.XReadableMap
    public final boolean isNull(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f475708a.isNull(r100);
    }
}
