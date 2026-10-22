package ip6;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.lynx.jsbridge.Arguments;
import com.lynx.react.bridge.WritableArray;
import com.lynx.react.bridge.WritableMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f495309a = 0;

    static {
    }

    public static WritableArray a(JSONArray r100) throws JSONException {
        Intrinsics.checkNotNullParameter(r100, "jsonArray");
        WritableArray r101 = Arguments.createArray();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L32;
        Object r104 = r100.get(r103);
        if ((r104 instanceof Float) == false) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L11;
        r101.pushDouble(JSONArrayProtectorUtils.getDouble(r100, r103));
    L31:
        r103 = r103 + 1;
        goto L3
    L11:
        if ((r104 instanceof Long) == false) goto L14;
        r101.pushDouble(JSONArrayProtectorUtils.getLong(r100, r103));
        goto L31
    L14:
        if ((r104 instanceof Number) == false) goto L17;
        r101.pushInt(JSONArrayProtectorUtils.getInt(r100, r103));
        goto L31
    L17:
        if ((r104 instanceof String) == false) goto L20;
        r101.pushString(JSONArrayProtectorUtils.getString(r100, r103));
        goto L31
    L20:
        if ((r104 instanceof Boolean) == false) goto L23;
        r101.pushBoolean(JSONArrayProtectorUtils.getBoolean(r100, r103));
        goto L31
    L23:
        if ((r104 instanceof JSONObject) == false) goto L26;
        r101.pushMap(b(JSONArrayProtectorUtils.getJSONObject(r100, r103)));
        goto L31
    L26:
        if ((r104 instanceof JSONArray) == false) goto L29;
        r101.pushArray(a(JSONArrayProtectorUtils.getJSONArray(r100, r103)));
        goto L31
    L29:
        if (Intrinsics.areEqual(r104, JSONObject.NULL) == false) goto L31;
        r101.pushNull();
        goto L31
    L7:
        r105 = r104 instanceof Double;
        goto L8
    L32:
        return r101;
    }

    public static WritableMap b(JSONObject r100) throws JSONException {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        WritableMap r101 = Arguments.createMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L32;
        String r103 = r102.next();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.String");
        String r104 = r103;
        Object r105 = r100.get(r104);
        if ((r105 instanceof Float) == false) goto L8;
        boolean r106 = true;
    L9:
        if (r106 == true) goto L10;
        if ((r105 instanceof Long) == true) goto L13;
        if ((r105 instanceof Number) == true) goto L16;
        if ((r105 instanceof String) == true) goto L19;
        if ((r105 instanceof Boolean) == true) goto L22;
        if ((r105 instanceof JSONObject) == true) goto L25;
        if ((r105 instanceof JSONArray) == true) goto L28;
        if (Intrinsics.areEqual(r105, JSONObject.NULL) == false) goto L4;
        r101.putNull(r104);
        goto L4
    L28:
        r101.putArray(r104, a(JSONObjectProtectorUtils.getJSONArray(r100, r104)));
        goto L4
    L25:
        r101.putMap(r104, b(JSONObjectProtectorUtils.getJSONObject(r100, r104)));
        goto L4
    L22:
        r101.putBoolean(r104, JSONObjectProtectorUtils.getBoolean(r100, r104));
        goto L4
    L19:
        r101.putString(r104, JSONObjectProtectorUtils.getString(r100, r104));
        goto L4
    L16:
        r101.putInt(r104, JSONObjectProtectorUtils.getInt(r100, r104));
        goto L4
    L13:
        r101.putDouble(r104, JSONObjectProtectorUtils.getLong(r100, r104));
        goto L4
    L10:
        r101.putDouble(r104, JSONObjectProtectorUtils.getDouble(r100, r104));
        goto L4
    L8:
        r106 = r105 instanceof Double;
        goto L9
    L32:
        return r101;
    }
}
