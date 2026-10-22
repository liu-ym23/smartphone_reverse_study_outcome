package o66;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.t;
import com.bytedance.ies.xbridge.v;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONArray f522204a;

    @Override // com.bytedance.ies.xbridge.v
    public final int size() {
        return this.f522204a.length();
    }

    @Override // com.bytedance.ies.xbridge.v
    public final List<Object> toList() {
        int r100 = com.bytedance.ies.xbridge.platform.web.a.f249528a;
        return com.bytedance.ies.xbridge.platform.web.a.a(this.f522204a);
    }

    public c(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f522204a = r100;
    }

    @Override // com.bytedance.ies.xbridge.v
    public final t get(int r100) {
        return new a(this.f522204a.opt(r100));
    }

    @Override // com.bytedance.ies.xbridge.v
    public final v getArray(int r100) {
        JSONArray r101 = this.f522204a.optJSONArray(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return new c(r101);
    }

    @Override // com.bytedance.ies.xbridge.v
    public final boolean getBoolean(int r100) {
        return this.f522204a.optBoolean(r100);
    }

    @Override // com.bytedance.ies.xbridge.v
    public final double getDouble(int r100) {
        return this.f522204a.optDouble(r100);
    }

    @Override // com.bytedance.ies.xbridge.v
    public final int getInt(int r100) {
        return this.f522204a.optInt(r100);
    }

    @Override // com.bytedance.ies.xbridge.v
    public final XReadableMap getMap(int r100) {
        JSONObject r101 = this.f522204a.optJSONObject(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return new d(r101);
    }

    @Override // com.bytedance.ies.xbridge.v
    public final String getString(int r100) {
        return this.f522204a.optString(r100);
    }

    @Override // com.bytedance.ies.xbridge.v
    public XReadableType getType(int r100) {
        Object r101 = this.f522204a.opt(r100);
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
}
