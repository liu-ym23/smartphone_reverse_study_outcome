package dx7;

import com.ivy.ivykit.api.bridge.core.model.IvyReadableType;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public final class a implements cx7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f470430a;

    public final e a() {
        Object r100 = this.f470430a;
        if ((r100 instanceof JSONArray) == false) goto L7;
        return new e((JSONArray) r100);
    L7:
        throw new IllegalArgumentException("Dynamic is not JSONArray");
    }

    public final boolean b() {
        Object r100 = this.f470430a;
        if ((r100 instanceof Boolean) == false) goto L7;
        return ((Boolean) r100).booleanValue();
    L7:
        throw new IllegalArgumentException("Dynamic is not Boolean");
    }

    public final double c() {
        Object r100 = this.f470430a;
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
        throw new IllegalArgumentException("Dynamic is not Double");
    }

    public final int d() {
        Object r100 = this.f470430a;
        if ((r100 instanceof Integer) == false) goto L7;
        return ((Number) r100).intValue();
    L7:
        throw new IllegalArgumentException("Dynamic is not Int");
    }

    public final b e() {
        Object r100 = this.f470430a;
        if ((r100 instanceof JSONObject) == false) goto L7;
        return new b((JSONObject) r100);
    L7:
        throw new IllegalArgumentException("Dynamic is not JSONObject");
    }

    public final String f() {
        Object r100 = this.f470430a;
        if ((r100 instanceof String) == false) goto L7;
        return (String) r100;
    L7:
        throw new IllegalArgumentException("Dynamic is not String");
    }

    @Override // cx7.b
    public IvyReadableType getType() {
        Object r100 = this.f470430a;
        if ((r100 instanceof JSONArray) == false) goto L6;
        return IvyReadableType.Array;
    L6:
        if ((r100 instanceof Boolean) == false) goto L9;
        return IvyReadableType.Boolean;
    L9:
        if ((r100 instanceof JSONObject) == false) goto L12;
        return IvyReadableType.Map;
    L12:
        if ((r100 instanceof Integer) == false) goto L15;
        return IvyReadableType.Int;
    L15:
        if ((r100 instanceof Number) == false) goto L18;
        return IvyReadableType.Number;
    L18:
        if ((r100 instanceof String) == false) goto L21;
        return IvyReadableType.String;
    L21:
        return IvyReadableType.Null;
    }

    public a(Object r100) {
        this.f470430a = r100;
    }
}
