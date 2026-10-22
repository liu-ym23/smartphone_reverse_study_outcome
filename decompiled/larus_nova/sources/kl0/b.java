package kl0;

import com.bytedance.android.livesdk.config.p70;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.lynx.jsbridge.Arguments;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import com.lynx.react.bridge.WritableArray;
import com.lynx.react.bridge.WritableMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class b {
    public static final JSONArray a(ReadableArray r100) throws JSONException {
        Intrinsics.checkNotNullParameter(r100, "$this$toJSONArray");
        JSONArray r101 = new JSONArray();
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L18;
        ReadableType r104 = r100.getType(r103);
        if (r104 == null) goto L17;
        switch(a.f503836b[r104.ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            default: goto L17;
        };
    L10:
        r101.put(JSONObject.NULL);
        goto L17
    L11:
        r101.put(a(r100.getArray(r103)));
        goto L17
    L12:
        r101.put(b(r100.getMap(r103)));
        goto L17
    L13:
        r101.put(r100.getString(r103));
        goto L17
    L14:
        r101.put(r100.getDouble(r103));
        goto L17
    L15:
        r101.put(r100.getLong(r103));
        goto L17
    L16:
        r101.put(r100.getBoolean(r103));
    L17:
        r103 = r103 + 1;
        goto L3
    L18:
        return r101;
    }

    public static final JSONObject b(ReadableMap r100) throws JSONException {
        Intrinsics.checkNotNullParameter(r100, "$this$toJSONObject");
        JSONObject r101 = new JSONObject();
        ReadableMapKeySetIterator r102 = r100.keySetIterator();
    L4:
        if (r102.hasNextKey() == false) goto L18;
        String r103 = r102.nextKey();
        ReadableType r104 = r100.getType(r103);
        if (r104 == null) goto L4;
        switch(a.f503835a[r104.ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L4;
        };
    L11:
        r101.put(r103, JSONObject.NULL);
        goto L4
    L12:
        r101.put(r103, a(r100.getArray(r103)));
        goto L4
    L13:
        r101.put(r103, b(r100.getMap(r103)));
        goto L4
    L14:
        r101.put(r103, r100.getString(r103));
        goto L4
    L15:
        r101.put(r103, r100.getDouble(r103));
        goto L4
    L16:
        r101.put(r103, r100.getLong(r103));
        goto L4
    L17:
        r101.put(r103, r100.getBoolean(r103));
        goto L4
    L18:
        return r101;
    }

    public static final WritableArray c(JSONArray r100) throws JSONException {
        Intrinsics.checkNotNullParameter(r100, "$this$toWritableArray");
        WritableArray r101 = Arguments.createArray();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L40;
        Object r104 = r100.opt(r103);
        if ((r104 instanceof Float) == false) goto L7;
    L38:
        r101.pushDouble(JSONArrayProtectorUtils.getDouble(r100, r103));
    L39:
        r103 = r103 + 1;
        goto L3
    L7:
        if ((r104 instanceof Double) == true) goto L38;
        if ((r104 instanceof Long) == false) goto L21;
        long r105 = JSONArrayProtectorUtils.getLong(r100, r103);
        if (p70.f120957a.getValue().booleanValue() == true) goto L14;
        r101.pushString(String.valueOf(r105));
        goto L39
    L14:
        if (r105 <= Integer.MAX_VALUE) goto L16;
    L18:
        r101.pushString(String.valueOf(r105));
        goto L39
    L16:
        if (r105 < Integer.MIN_VALUE) goto L18;
        r101.pushInt((int) r105);
        goto L39
    L21:
        if ((r104 instanceof Number) == false) goto L24;
        r101.pushInt(JSONArrayProtectorUtils.getInt(r100, r103));
        goto L39
    L24:
        if ((r104 instanceof String) == false) goto L27;
        r101.pushString(JSONArrayProtectorUtils.getString(r100, r103));
        goto L39
    L27:
        if ((r104 instanceof Boolean) == false) goto L30;
        r101.pushBoolean(JSONArrayProtectorUtils.getBoolean(r100, r103));
        goto L39
    L30:
        if ((r104 instanceof JSONObject) == false) goto L33;
        r101.pushMap(d(JSONArrayProtectorUtils.getJSONObject(r100, r103)));
        goto L39
    L33:
        if ((r104 instanceof JSONArray) == false) goto L36;
        r101.pushArray(c(JSONArrayProtectorUtils.getJSONArray(r100, r103)));
        goto L39
    L36:
        if (Intrinsics.areEqual(r104, JSONObject.NULL) == false) goto L39;
        r101.pushNull();
        goto L39
    L40:
        return r101;
    }

    public static final WritableMap d(JSONObject r100) throws JSONException {
        Intrinsics.checkNotNullParameter(r100, "$this$toWritableMap");
        WritableMap r101 = Arguments.createMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L44;
        String r103 = r102.next();
        if (r103 == null) goto L43;
        String r104 = r103;
        Object r105 = r100.opt(r104);
        if ((r105 instanceof Float) == true) goto L41;
        if ((r105 instanceof Double) == true) goto L41;
        if ((r105 instanceof Long) == true) goto L14;
        if ((r105 instanceof Number) == true) goto L25;
        if ((r105 instanceof String) == true) goto L28;
        if ((r105 instanceof Boolean) == true) goto L31;
        if ((r105 instanceof JSONObject) == true) goto L34;
        if ((r105 instanceof JSONArray) == true) goto L37;
        if (Intrinsics.areEqual(r105, JSONObject.NULL) == false) goto L4;
        r101.putNull(r104);
        goto L4
    L37:
        r101.putArray(r104, c(JSONObjectProtectorUtils.getJSONArray(r100, r104)));
        goto L4
    L34:
        r101.putMap(r104, d(JSONObjectProtectorUtils.getJSONObject(r100, r104)));
        goto L4
    L31:
        r101.putBoolean(r104, JSONObjectProtectorUtils.getBoolean(r100, r104));
        goto L4
    L28:
        r101.putString(r104, JSONObjectProtectorUtils.getString(r100, r104));
        goto L4
    L25:
        r101.putInt(r104, JSONObjectProtectorUtils.getInt(r100, r104));
        goto L4
    L14:
        long r106 = JSONObjectProtectorUtils.getLong(r100, r104);
        if (p70.f120957a.getValue().booleanValue() == true) goto L17;
        r101.putString(r104, String.valueOf(r106));
        goto L4
    L17:
        if (r106 > Integer.MAX_VALUE) goto L21;
        if (r106 < Integer.MIN_VALUE) goto L21;
        r101.putInt(r104, (int) r106);
    L21:
        r101.putString(r104, String.valueOf(r106));
    L41:
        r101.putDouble(r104, JSONObjectProtectorUtils.getDouble(r100, r104));
        goto L4
    L43:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L44:
        return r101;
    }
}
