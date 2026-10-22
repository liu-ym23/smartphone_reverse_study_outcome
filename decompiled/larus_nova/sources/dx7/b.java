package dx7;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.ivy.ivykit.api.bridge.core.model.IvyReadableType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public final class b implements cx7.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f470431a;

    public final Map<String, Object> a() {
        int r100 = c.f470432a;
        return c.b(this.f470431a);
    }

    @Override // cx7.d
    public final d keyIterator() {
        return new d(this.f470431a.keys());
    }

    public b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f470431a = r100;
    }

    @Override // cx7.d
    public final a get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return new a(this.f470431a.opt(r100));
    }

    @Override // cx7.d
    public final e getArray(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        JSONArray r101 = this.f470431a.optJSONArray(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return new e(r101);
    }

    @Override // cx7.d
    public final boolean getBoolean(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f470431a.optBoolean(r100);
    }

    @Override // cx7.d
    public final double getDouble(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f470431a.optDouble(r100);
    }

    @Override // cx7.d
    public final int getInt(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f470431a.optInt(r100);
    }

    @Override // cx7.d
    public final b getMap(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        JSONObject r101 = this.f470431a.optJSONObject(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return new b(r101);
    }

    @Override // cx7.d
    public final String getString(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f470431a.optString(r100);
    }

    @Override // cx7.d
    public IvyReadableType getType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Object r101 = this.f470431a.opt(r100);
        if ((r101 instanceof JSONArray) == false) goto L6;
        return IvyReadableType.Array;
    L6:
        if ((r101 instanceof Boolean) == false) goto L9;
        return IvyReadableType.Boolean;
    L9:
        if ((r101 instanceof JSONObject) == false) goto L12;
        return IvyReadableType.Map;
    L12:
        if ((r101 instanceof Integer) == false) goto L15;
        return IvyReadableType.Int;
    L15:
        if ((r101 instanceof Number) == false) goto L18;
        return IvyReadableType.Number;
    L18:
        if ((r101 instanceof String) == false) goto L21;
        return IvyReadableType.String;
    L21:
        return IvyReadableType.Null;
    }

    @Override // cx7.d
    public final boolean hasKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f470431a.has(r100);
    }
}
