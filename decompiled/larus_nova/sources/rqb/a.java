package rqb;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f538958a = 0;

    static {
    }

    public static Object a(Object r100) {
        if ((r100 instanceof ReadableMap) == false) goto L16;
        HashMap<String, Object> r101 = ((ReadableMap) r100).toHashMap();
        JSONObject r102 = new JSONObject();
        if (r101 == null) goto L14;
        Iterator<Map.Entry<String, Object>> r103 = r101.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L14;
        Map.Entry<String, Object> r104 = r103.next();
        String r105 = r104.getKey();
        r102.put(r105, a(r104.getValue()));     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        Log.e("BridgeUtils", e.toString());
    L14:
        return r102;
    L16:
        if ((r100 instanceof ReadableArray) == false) goto L23;
        ArrayList<Object> r106 = ((ReadableArray) r100).toArrayList();
        JSONArray r107 = new JSONArray();
        if (r106 == null) goto L22;
        int r108 = r106.size();
        int r109 = 0;
    L20:
        if (r109 >= r108) goto L22;
        r107.put(a(ListProtector.get(r106, r109)));
        r109 = r109 + 1;
    L22:
        return r107;
    L23:
        return r100;
    }

    public static JavaOnlyMap b(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        JavaOnlyMap r101 = JavaOnlyMap.from(r100);
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        Object r105 = r103.getValue();
        if ((r105 instanceof Map) == false) goto L4;
        if ((r105 instanceof JavaOnlyMap) == true) goto L4;
        Intrinsics.checkNotNull(r101);
        r101.put(r104, b((Map) r105));
        goto L4
    L10:
        Intrinsics.checkNotNull(r101);
        return r101;
    }
}
