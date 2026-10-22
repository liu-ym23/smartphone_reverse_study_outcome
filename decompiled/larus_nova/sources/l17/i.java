package l17;

import com.bytedance.lynx.webview.internal.TTWebContext;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public abstract class i {
    public static Map<String, Method> a(Class<?> r210, String r211) {
        HashMap r100 = new HashMap();
        long r101 = System.currentTimeMillis();
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        Class<?> r110 = TTWebContext.h().f265216b.f(r211, true);     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        if (r110 != null) goto L7;
        k.d(new String[]{"TT_WEBVIEW", "InterfaceUtils: Failed to load class ".concat(r211)});     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        return new HashMap();
    L7:
        int r104 = r210.getMethods().length;     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        Method[] r105 = r210.getMethods();     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        int r111 = r105.length;     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        int r112 = 0;
        int r113 = 0;
        int r114 = 0;
        int r115 = 0;
    L8:
        if (r112 >= r111) goto L51;
        Method r116 = r105[r112];     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        String r106 = r116.getName();     // Catch: Exception -> L13 NoClassDefFoundError -> L59
        Class<?>[] r117 = r116.getParameterTypes();     // Catch: Exception -> L13 NoClassDefFoundError -> L59
        if (r117.length != 0) goto L15;
        Method r118 = r110.getMethod(r106, new Class[0]);     // Catch: Exception -> L13 NoClassDefFoundError -> L59
        Method[] r212 = r105;
    L38:
        if (r118 == null) goto L50;
        if (r100.containsKey(r116.getName()) == false) goto L44;
        r114 = r114 + 1;
        r103.add(r106);     // Catch: Exception -> L64 NoClassDefFoundError -> L59
    L45:
        r100.put(r116.getName(), r118);     // Catch: Exception -> L64 NoClassDefFoundError -> L59
    L48:
        r113 = r113 + 1;
        r102.add(r116.getName());     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        goto L50
    L44:
        r115 = r115 + 1;     // Catch: Exception -> L64 NoClassDefFoundError -> L59
        r114 = r114;
    L47:
        r115 = r115;
        r114 = r114;
    L50:
        r112 = r112 + 1;     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        r105 = r212;
        goto L8
    L15:
        r212 = r105;
        if (r117.length != 1) goto L20;
        r118 = r110.getMethod(r106, new Class[]{r117[0]});     // Catch: Exception -> L65 NoClassDefFoundError -> L59
        goto L38
    L20:
        if (r117.length != 2) goto L23;
        r118 = r110.getMethod(r106, new Class[]{r117[0], r117[1]});     // Catch: Exception -> L65 NoClassDefFoundError -> L59
        goto L38
    L23:
        if (r117.length != 3) goto L26;
        r118 = r110.getMethod(r106, new Class[]{r117[0], r117[1], r117[2]});     // Catch: Exception -> L65 NoClassDefFoundError -> L59
        goto L38
    L26:
        if (r117.length != 4) goto L29;
        r118 = r110.getMethod(r106, new Class[]{r117[0], r117[1], r117[2], r117[3]});     // Catch: Exception -> L65 NoClassDefFoundError -> L59
        goto L38
    L29:
        if (r117.length != 5) goto L32;
        r118 = r110.getMethod(r106, new Class[]{r117[0], r117[1], r117[2], r117[3], r117[4]});     // Catch: Exception -> L65 NoClassDefFoundError -> L59
        goto L38
    L32:
        if (r117.length != 6) goto L35;
        r118 = r110.getMethod(r106, new Class[]{r117[0], r117[1], r117[2], r117[3], r117[4], r117[5]});     // Catch: Exception -> L65 NoClassDefFoundError -> L59
        goto L38
    L35:
        if (r117.length != 7) goto L37;
        r118 = r110.getMethod(r106, new Class[]{r117[0], r117[1], r117[2], r117[3], r117[4], r117[5], r117[6]});     // Catch: Exception -> L65 NoClassDefFoundError -> L59
        goto L38
    L37:
        r118 = null;
    L13:
        r212 = r105;
        goto L47
    L51:
        long r107 = System.currentTimeMillis();     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        StringBuilder r119 = new StringBuilder();     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        r119.append("InterfaceUtils: Initialized ");     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        r119.append(r210.getName());     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        r119.append(" (total=");     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        r119.append(r104);     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        r119.append(", success=");     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        r119.append(r115);     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        r119.append(", missing=");     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        r119.append(r113);     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        r119.append(", override=");     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        r119.append(r114);     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        r119.append(", time=");     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        r119.append(r107 - r101);     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        r119.append("ms");     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        if (r102.isEmpty() == true) goto L55;
        r119.append(", missingMethods=");     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        r119.append(r102);     // Catch: NoClassDefFoundError -> L59 Exception -> L61
    L55:
        if (r103.isEmpty() == true) goto L57;
        r119.append(", overrideMethods=");     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        r119.append(r103);     // Catch: NoClassDefFoundError -> L59 Exception -> L61
    L57:
        r119.append(")");     // Catch: NoClassDefFoundError -> L59 Exception -> L61
        k.d(new String[]{"TT_WEBVIEW", r119.toString()});     // Catch: NoClassDefFoundError -> L59 Exception -> L61
    L63:
        return r100;
    L61:
        e = move-exception;
        k.d(new String[]{"TT_WEBVIEW", "InterfaceUtils: Exception initializing " + r210.getName() + " - " + e.toString()});
    L59:
        e = move-exception;
        k.d(new String[]{"TT_WEBVIEW", "InterfaceUtils: NoClassDefFoundError initializing " + r210.getName() + " - " + e.toString()});
        goto L63
    }
}
