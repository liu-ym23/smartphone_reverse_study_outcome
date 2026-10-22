package lx;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a {
    public static final JavaOnlyArray a(JSONArray r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JavaOnlyArray r101 = new JavaOnlyArray();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L39;
        Object r104 = r100.opt(r103);
        if ((r104 instanceof Float) == false) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == false) goto L11;
        r101.pushDouble(JSONArrayProtectorUtils.getDouble(r100, r103));
    L36:
        r103 = r103 + 1;
        goto L3
    L11:
        if ((r104 instanceof Long) == false) goto L19;
        long r106 = JSONArrayProtectorUtils.getLong(r100, r103);
        if (r106 <= Integer.MAX_VALUE) goto L15;
    L17:
        r101.pushString(String.valueOf(r106));
        goto L36
    L15:
        if (r106 < Integer.MIN_VALUE) goto L17;
        r101.pushInt((int) r106);
        goto L36
    L19:
        if ((r104 instanceof Number) == false) goto L22;
        r101.pushInt(JSONArrayProtectorUtils.getInt(r100, r103));
        goto L36
    L22:
        if ((r104 instanceof String) == false) goto L25;
        r101.pushString(JSONArrayProtectorUtils.getString(r100, r103));
        goto L36
    L25:
        if ((r104 instanceof Boolean) == false) goto L28;
        r101.pushBoolean(JSONArrayProtectorUtils.getBoolean(r100, r103));
        goto L36
    L28:
        if ((r104 instanceof JSONObject) == false) goto L31;
        r101.pushMap(b(JSONArrayProtectorUtils.getJSONObject(r100, r103)));
        goto L36
    L31:
        if ((r104 instanceof JSONArray) == false) goto L34;
        r101.pushArray(a(JSONArrayProtectorUtils.getJSONArray(r100, r103)));
        goto L36
    L34:
        if (Intrinsics.areEqual(r104, JSONObject.NULL) == false) goto L38;
        r101.pushNull();
        goto L36
    L38:
        throw new IllegalStateException(("Failed to convert value " + r104 + " of type " + r104.getClass()).toString());
    L7:
        r105 = r104 instanceof Double;
        goto L8
    L39:
        return r101;
    }

    public static final JavaOnlyMap b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        JavaOnlyMap r101 = new JavaOnlyMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L39;
        String r103 = r102.next();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.String");
        String r104 = r103;
        Object r105 = r100.opt(r104);
        if ((r105 instanceof Float) == false) goto L8;
        boolean r106 = true;
    L9:
        if (r106 == true) goto L10;
        if ((r105 instanceof Long) == true) goto L13;
        if ((r105 instanceof Number) == true) goto L21;
        if ((r105 instanceof String) == true) goto L24;
        if ((r105 instanceof Boolean) == true) goto L27;
        if ((r105 instanceof JSONObject) == true) goto L30;
        if ((r105 instanceof JSONArray) == true) goto L33;
        if (Intrinsics.areEqual(r105, JSONObject.NULL) == false) goto L38;
        r101.putNull(r104);
        goto L4
    L38:
        throw new IllegalStateException(("Failed to convert value " + r105 + " of type " + r105.getClass()).toString());
    L33:
        r101.putArray(r104, a(JSONObjectProtectorUtils.getJSONArray(r100, r104)));
        goto L4
    L30:
        r101.putMap(r104, b(JSONObjectProtectorUtils.getJSONObject(r100, r104)));
        goto L4
    L27:
        r101.putBoolean(r104, JSONObjectProtectorUtils.getBoolean(r100, r104));
        goto L4
    L24:
        r101.putString(r104, JSONObjectProtectorUtils.getString(r100, r104));
        goto L4
    L21:
        r101.putInt(r104, JSONObjectProtectorUtils.getInt(r100, r104));
        goto L4
    L13:
        long r107 = JSONObjectProtectorUtils.getLong(r100, r104);
        if (r107 > Integer.MAX_VALUE) goto L18;
        if (r107 < Integer.MIN_VALUE) goto L18;
        r101.putInt(r104, (int) r107);
    L18:
        r101.putString(r104, String.valueOf(r107));
        goto L4
    L10:
        r101.putDouble(r104, JSONObjectProtectorUtils.getDouble(r100, r104));
        goto L4
    L8:
        r106 = r105 instanceof Double;
        goto L9
    L39:
        return r101;
    }
}
