package s7a;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f540932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f540933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f540934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, List<Integer>> f540935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ReadableMap f540936e;

    public static Map<Integer, a> a(ReadableArray r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        HashMap r100 = new HashMap();
        int r101 = 0;
    L7:
        if (r101 >= r110.size()) goto L38;
        ReadableMap r102 = r110.getMap(r101);
        int r103 = r102.getInt("id");
        int r104 = r102.getInt("type");
        ReadableArray r105 = r102.getArray("callbackNames");
        ArrayList r106 = new ArrayList();
        if (r105 == null) goto L14;
        int r107 = 0;
    L12:
        if (r107 >= r105.size()) goto L14;
        r106.add(r105.getString(r107));
        r107 = r107 + 1;
    L14:
        HashMap r108 = new HashMap();
        ReadableMap r109 = r102.getMap("relationMap");
        if (r109 == null) goto L37;
        ReadableArray r111 = r109.getArray("simultaneous");
        if (r111 == null) goto L23;
        ArrayList r112 = new ArrayList();
        int r113 = 0;
    L20:
        if (r113 >= r111.size()) goto L22;
        r112.add(Integer.valueOf(r111.getInt(r113)));
        r113 = r113 + 1;
        goto L20
    L22:
        r108.put("simultaneous", r112);
    L23:
        ReadableArray r114 = r109.getArray("waitFor");
        if (r114 == null) goto L30;
        ArrayList r115 = new ArrayList();
        int r116 = 0;
    L27:
        if (r116 >= r114.size()) goto L29;
        r115.add(Integer.valueOf(r114.getInt(r116)));
        r116 = r116 + 1;
        goto L27
    L29:
        r108.put("waitFor", r115);
    L30:
        ReadableArray r117 = r109.getArray("continueWith");
        if (r117 == null) goto L37;
        ArrayList r118 = new ArrayList();
        int r119 = 0;
    L34:
        if (r119 >= r117.size()) goto L36;
        r118.add(Integer.valueOf(r117.getInt(r119)));
        r119 = r119 + 1;
        goto L34
    L36:
        r108.put("continueWith", r118);
    L37:
        a r120 = new a(r103, r104, r106, r108, r102.getMap("configMap"));
        r100.put(Integer.valueOf(r103), r120);
        r101 = r101 + 1;
        goto L7
    L38:
        return r100;
    }

    public a(int r100, int r101, List<String> r102, Map<String, List<Integer>> r103, ReadableMap r104) {
        this.f540932a = r100;
        this.f540933b = r101;
        this.f540934c = new ArrayList(r102);
        this.f540935d = new HashMap(r103);
        this.f540936e = r104;
    }
}
