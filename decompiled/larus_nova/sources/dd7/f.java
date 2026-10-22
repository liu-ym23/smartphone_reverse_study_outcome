package dd7;

import com.bytedance.sdk.bridge.Logger;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import java.util.Iterator;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class f {
    static {
    }

    @JvmStatic
    public static final JavaOnlyArray a(JSONArray r100) {
        JavaOnlyArray r101 = new JavaOnlyArray();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L12;
        Object r104 = r100.opt(r103);
        if ((r104 instanceof JSONArray) == false) goto L8;
        r101.add(a((JSONArray) r104));
    L11:
        r103 = r103 + 1;
        goto L3
    L8:
        if ((r104 instanceof JSONObject) == false) goto L10;
        r101.add(b((JSONObject) r104));
        goto L11
    L10:
        r101.add(r104);
        goto L11
    L12:
        return r101;
    }

    @JvmStatic
    public static final JavaOnlyMap b(JSONObject r100) {
        Iterator<String> r101 = r100.keys();
        JavaOnlyMap r102 = new JavaOnlyMap();
    L4:
        if (r101.hasNext() == false) goto L12;
        String r103 = r101.next();
        Object r104 = r100.opt(r103);
        if ((r104 instanceof JSONObject) == true) goto L7;
        if ((r104 instanceof JSONArray) == true) goto L10;
        r102.put(r103, r104);
        goto L4
    L10:
        r102.put(r103, a((JSONArray) r104));
        goto L4
    L7:
        r102.put(r103, b((JSONObject) r104));
        goto L4
    L12:
        return r102;
    }

    @JvmStatic
    public static final JSONArray c(JavaOnlyArray r100) {
        JSONArray r101 = new JSONArray();
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L24;
        Object r104 = r100.get(r103);
        ReadableType r105 = r100.getType(r103);     // Catch: Throwable -> L21
        if (r105 == null) goto L12;
        int r106 = e.f468029a[r105.ordinal()];     // Catch: Throwable -> L21
        if (r106 != 1) goto L11;
        if (r104 == null) goto L20;
        r101.put(d((JavaOnlyMap) r104));     // Catch: Throwable -> L21
    L23:
        r103 = r103 + 1;
        goto L3
    L20:
        throw new TypeCastException("null cannot be cast to non-null type com.lynx.react.bridge.JavaOnlyMap");     // Catch: Throwable -> L21
    L11:
        if (r106 != 2) goto L12;
        if (r104 == null) goto L16;
        r101.put(c((JavaOnlyArray) r104));     // Catch: Throwable -> L21
        goto L23
    L16:
        throw new TypeCastException("null cannot be cast to non-null type com.lynx.react.bridge.JavaOnlyArray");     // Catch: Throwable -> L21
    L12:
        r101.put(r104);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Logger r107 = Logger.f269563c;
        th.toString();
        r107.getClass();
        Logger.b();
        goto L23
    L24:
        return r101;
    }

    @JvmStatic
    public static final JSONObject d(JavaOnlyMap r100) {
        JSONObject r101 = new JSONObject();
        if (r100.isEmpty() == false) goto L5;
        return r101;
    L5:
        ReadableMapKeySetIterator r102 = r100.keySetIterator();
    L7:
        if (r102.hasNextKey() == false) goto L27;
        String r103 = r102.nextKey();
        Object r104 = r100.get(r103);
        ReadableType r105 = r100.getType(r103);     // Catch: Throwable -> L25
        if (r105 == null) goto L16;
        int r106 = e.f468030b[r105.ordinal()];     // Catch: Throwable -> L25
        if (r106 != 1) goto L15;
        if (r104 == null) goto L24;
        r101.putOpt(r103, c((JavaOnlyArray) r104));     // Catch: Throwable -> L25
        goto L7
    L24:
        throw new TypeCastException("null cannot be cast to non-null type com.lynx.react.bridge.JavaOnlyArray");     // Catch: Throwable -> L25
    L15:
        if (r106 != 2) goto L16;
        if (r104 == null) goto L20;
        r101.putOpt(r103, d((JavaOnlyMap) r104));     // Catch: Throwable -> L25
        goto L7
    L20:
        throw new TypeCastException("null cannot be cast to non-null type com.lynx.react.bridge.JavaOnlyMap");     // Catch: Throwable -> L25
    L16:
        r101.putOpt(r103, r104);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Logger r107 = Logger.f269563c;
        th.toString();
        r107.getClass();
        Logger.b();
        goto L7
    L27:
        return r101;
    }
}
