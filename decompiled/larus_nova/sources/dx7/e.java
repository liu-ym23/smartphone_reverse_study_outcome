package dx7;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.ivy.ivykit.api.bridge.core.model.IvyReadableType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public final class e implements cx7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONArray f470434a;

    public final int b() {
        return this.f470434a.length();
    }

    @Override // cx7.c
    public final List<Object> toList() {
        int r100 = c.f470432a;
        return c.a(this.f470434a);
    }

    public e(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        this.f470434a = r100;
    }

    public final a a(int r100) {
        return new a(this.f470434a.opt(r100));
    }

    @Override // cx7.c
    public final e getArray(int r100) {
        JSONArray r101 = this.f470434a.optJSONArray(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return new e(r101);
    }

    @Override // cx7.c
    public final boolean getBoolean(int r100) {
        return this.f470434a.optBoolean(r100);
    }

    @Override // cx7.c
    public final double getDouble(int r100) {
        return this.f470434a.optDouble(r100);
    }

    @Override // cx7.c
    public final int getInt(int r100) {
        return this.f470434a.optInt(r100);
    }

    @Override // cx7.c
    public final b getMap(int r100) {
        JSONObject r101 = this.f470434a.optJSONObject(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return new b(r101);
    }

    @Override // cx7.c
    public final String getString(int r100) {
        return this.f470434a.optString(r100);
    }

    @Override // cx7.c
    public IvyReadableType getType(int r100) {
        Object r101 = this.f470434a.opt(r100);
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
}
