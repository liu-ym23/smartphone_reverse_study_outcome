package com.bytedance.ies.tools.prefetch;

import android.net.Uri;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class g0 {
    public static final JSONObject b(JSONObject r100) {
        JSONObject r101 = new JSONObject();
        Iterator r102 = SequencesKt.sorted(SequencesKt.asSequence(r100.keys())).iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        String r103 = (String) r102.next();
        Object r104 = r100.get(r103);
        if ((r104 instanceof JSONObject) == true) goto L7;
        r101.put(r103, r104);
        goto L4
    L7:
        r101.put(r103, b((JSONObject) r104));
        goto L4
    L9:
        return r101;
    }

    public static final JSONObject c(Map<String, ? extends Object> r100) {
        if (r100 == null) goto L9;
        JSONObject r101 = new JSONObject();
        Iterator<T> r102 = r100.entrySet().iterator();
    L5:
        if (r102.hasNext() == false) goto L7;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.put((String) r103.getKey(), r103.getValue());
        goto L5
    L7:
        return r101;
    L9:
        return new JSONObject();
    }

    public static final List<String> d(JSONArray r100) throws JSONException {
        if (r100 == null) goto L10;
        ArrayList r101 = new ArrayList();
        int r102 = r100.length();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L8;
        r101.add(JSONArrayProtectorUtils.getString(r100, r103));
        r103 = r103 + 1;
        goto L5
    L8:
        return r101;
    L10:
        return CollectionsKt.emptyList();
    }

    public static final SortedMap<String, String> e(JSONObject r100) throws JSONException {
        TreeMap r101 = new TreeMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        r101.put(r103, JSONObjectProtectorUtils.getString(r100, r103));
        goto L4
    L6:
        return r101;
    }

    public static final SortedMap<String, f0<?>> f(JSONObject r100) throws JSONException {
        if (r100 == null) goto L55;
        TreeMap r101 = new TreeMap();
        Iterator<String> r102 = r100.keys();
    L6:
        if (r102.hasNext() == false) goto L30;
        String r103 = r102.next();
        JSONObject r104 = JSONObjectProtectorUtils.getJSONObject(r100, r103);
        String r105 = JSONObjectProtectorUtils.getString(r104, "type");
        Locale r106 = Locale.ROOT;
        if (r105 == null) goto L28;
        String r107 = r105.toLowerCase(r106);
        switch(r107.hashCode()) {
            case -1249586564: goto L25;
            case -1048944393: goto L22;
            case -892481938: goto L19;
            case -362445944: goto L16;
            case 107944136: goto L13;
            default: goto L6;
        };
    L13:
        if (r107.equals("query") == false) goto L6;
        r101.put(r103, new s(JSONObjectProtectorUtils.getString(r104, "value"), r104.optString("dataType", "string")));
        goto L6
    L16:
        if (r107.equals("pathparam") == false) goto L6;
        r101.put(r103, new t(JSONObjectProtectorUtils.getString(r104, "value"), r104.optString("dataType", "string")));
        goto L6
    L19:
        if (r107.equals("static") == false) goto L6;
        r101.put(r103, new d0(r104.get("value")));
        goto L6
    L22:
        if (r107.equals("nested") == false) goto L6;
        r101.put(r103, new q(f(JSONObjectProtectorUtils.getJSONObject(r104, "value"))));
        goto L6
    L25:
        if (r107.equals("variable") == false) goto L6;
        r101.put(r103, new h0(JSONObjectProtectorUtils.getString(r104, "value")));
        goto L6
    L28:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L30:
        return r101;
    L55:
        return new TreeMap();
    }

    public static final String a(String r100, Map<String, ? extends Object> r101) {
        Uri.Builder r102 = UriProtector.parse(r100).buildUpon();
        if (r101 == null) goto L9;
        Iterator<Map.Entry<String, ? extends Object>> r103 = r101.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        Map.Entry<String, ? extends Object> r104 = r103.next();
        r102.appendQueryParameter(r104.getKey(), r104.getValue().toString());
    L9:
        return r102.toString();
    }
}
