package g26;

import android.os.Bundle;
import com.lynx.tasm.TemplateData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "user lynx_adapter instead")
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f479728b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TemplateData f479729a;

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [java.util.LinkedHashMap, java.util.Map] */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v12, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r0v7, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r0v8, types: [java.util.LinkedHashMap, java.util.Map] */
        /* JADX WARN: Type inference failed for: r0v9, types: [java.util.LinkedHashMap, java.util.Map] */
        /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object] */
        @JvmStatic
        public static Object a(Object r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            r100.toString();
            r100.getClass().toString();
            if ((r100 instanceof List) == false) goto L13;
            ?? r101 = new ArrayList();
            Iterator r102 = ((Iterable) r100).iterator();
        L9:
            if (r102.hasNext() == false) goto L42;
            Object r103 = r102.next();
            int r104 = b.f479728b;
            r101.add(a(r103));
        L42:
            return r101;
        L13:
            if ((r100 instanceof Map) == false) goto L22;
            r101 = new LinkedHashMap();
            Iterator r105 = ((Map) r100).entrySet().iterator();
        L16:
            if (r105.hasNext() == false) goto L42;
            Map.Entry r106 = (Map.Entry) r105.next();
            if ((r106.getKey() instanceof String) == true) goto L19;
            r106.toString();
            goto L16
        L19:
            Object r107 = r106.getKey();
            Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type kotlin.String");
            int r108 = b.f479728b;
            r101.put((String) r107, a(r106.getValue()));
            goto L16
        L22:
            if ((r100 instanceof Bundle) == false) goto L28;
            r101 = new LinkedHashMap();
            Bundle r109 = (Bundle) r100;
            Iterator r110 = r109.keySet().iterator();
        L25:
            if (r110.hasNext() == false) goto L42;
            String r111 = (String) r110.next();
            int r112 = b.f479728b;
            r101.put(r111, a(r109.get(r111)));
            goto L25
        L28:
            if ((r100 instanceof JSONObject) == false) goto L34;
            r101 = new LinkedHashMap();
            JSONObject r113 = (JSONObject) r100;
            Iterator<String> r114 = r113.keys();
        L31:
            if (r114.hasNext() == false) goto L42;
            String r115 = r114.next();
            int r116 = b.f479728b;
            r101.put(r115, a(r113.get(r115)));
            goto L31
        L34:
            if ((r100 instanceof JSONArray) == false) goto L55;
            r101 = new ArrayList();
            JSONArray r117 = (JSONArray) r100;
            int r118 = r117.length();
            int r119 = 0;
        L36:
            if (r119 >= r118) goto L42;
            int r120 = b.f479728b;
            r101.add(a(r117.get(r119)));
            r119 = r119 + 1;
        L40:
            th = move-exception;
            throw th;
        L55:
            return r100;
        }
    }

    static {
    }

    public b() {
        this.f479729a = TemplateData.empty();
    }
}
