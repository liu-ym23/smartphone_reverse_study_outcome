package tq;

import android.util.LruCache;
import com.bytedance.android.ecom.arch.expr.parser.SlcExprParser;
import com.bytedance.android.ecom.arch.slice.expr.SlcExprContext;
import com.bytedance.android.ecom.arch.slice.expr.b;
import com.bytedance.android.ecom.arch.slice.expr.c;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.template.JsonTemplate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import zp.d;

/* JADX INFO: loaded from: classes44.dex */
public final class a {
    public static final void a(SlcExprContext r100, String r101, b r102, Function1<? super c, Unit> r103) {
        r100.getClass();
        if (r102 == null) goto L17;
    L6:
        LruCache<String, dq.a> r104 = r102.f50061a.f50060a;     // Catch: Throwable -> L13
        if (r101 == null) goto L12;
        if (r104.get(r101.trim()) != null) goto L18;
        SlcExprParser r105 = r100.f50057d;     // Catch: Throwable -> L13
        d r106 = r100.f50058e;     // Catch: Throwable -> L13
        r105.getClass();     // Catch: Throwable -> L13
        dq.a r107 = SlcExprParser.a(r101, r106);     // Catch: Throwable -> L13
        r102.f50061a.f50060a.put(r101.trim(), r107);     // Catch: Throwable -> L13
        return;
    L18:
        return;
    L12:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L13
    L17:
        r102 = r100.f50059f;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (r103 == null) goto L20;
        Unit r108 = r103.invoke(new c(r101, th, 4));
        return;
    }

    public static final void b(SlcExprContext r100, com.bytedance.android.ecom.arch.slice.render.bindinfo.d r101, b r102, Function1<? super c, Unit> r103) {
        Map<String, String> r104 = r101.f50130a;
        if (r104 == null) goto L8;
        Iterator<Map.Entry<String, String>> r105 = r104.entrySet().iterator();
    L6:
        if (r105.hasNext() == false) goto L8;
        a(r100, r105.next().getValue(), r102, r103);
    L8:
        Map<String, String> r106 = r101.f50131b;
        if (r106 == null) goto L14;
        Iterator<Map.Entry<String, String>> r107 = r106.entrySet().iterator();
    L12:
        if (r107.hasNext() == false) goto L14;
        a(r100, r107.next().getValue(), r102, r103);
    L14:
        String r108 = r101.f50134e;
        if (r108 == null) goto L17;
        a(r100, r108, r102, r103);
    L17:
        String r109 = r101.f50135f;
        if (r109 == null) goto L20;
        a(r100, r109, r102, r103);
    L20:
        Map<String, String> r110 = r101.f50136g;
        if (r110 == null) goto L26;
        Iterator<Map.Entry<String, String>> r111 = r110.entrySet().iterator();
    L24:
        if (r111.hasNext() == false) goto L26;
        a(r100, r111.next().getValue(), r102, r103);
    L26:
        Map<String, String> r112 = r101.f50132c;
        if (r112 == null) goto L32;
        Iterator<Map.Entry<String, String>> r113 = r112.entrySet().iterator();
    L30:
        if (r113.hasNext() == false) goto L32;
        a(r100, r113.next().getValue(), r102, r103);
    L32:
        Map<String, String> r114 = r101.f50141l;
        if (r114 == null) goto L38;
        Iterator<Map.Entry<String, String>> r115 = r114.entrySet().iterator();
    L36:
        if (r115.hasNext() == false) goto L38;
        a(r100, r115.next().getValue(), r102, r103);
    L38:
        Map<String, String> r116 = r101.f50137h;
        if (r116 == null) goto L44;
        Iterator<Map.Entry<String, String>> r117 = r116.entrySet().iterator();
    L42:
        if (r117.hasNext() == false) goto L44;
        a(r100, r117.next().getValue(), r102, r103);
    L44:
        com.bytedance.android.ecom.arch.slice.render.bindinfo.c r118 = r101.f50133d;
        if (r118 == null) goto L47;
        a(r100, r118.start, r102, r103);
        a(r100, r118.end, r102, r103);
        a(r100, r118.target, r102, r103);
    L47:
        String r119 = r101.f50140k;
        boolean r120 = true;
        if (r119 != null) goto L50;
    L53:
        boolean r121 = true;
    L54:
        if (r121 == true) goto L56;
        a(r100, r101.f50140k, r102, r103);
    L56:
        String r122 = r101.f50138i;
        if (r122 != null) goto L59;
    L62:
        if (r120 == true) goto L71;
        a(r100, r101.f50138i, r102, r103);
        return;
    L71:
        return;
    L59:
        if (r122.length() == 0) goto L62;
        r120 = false;
        goto L62
    L50:
        if (r119.length() == 0) goto L53;
        r121 = false;
        goto L54
    }

    public static final void c(SlcExprContext r100, SlcElement r101, b r102, Function1<? super c, Unit> r103) {
        com.bytedance.android.ecom.arch.slice.render.bindinfo.d r104 = r101.bindInfo;     // Catch: Throwable -> L26
        if (r104 == null) goto L6;
        b(r100, r104, r102, r103);     // Catch: Throwable -> L26
    L6:
        Map<String, Object> r105 = r101.getProps();     // Catch: Throwable -> L26
        if (r105 == null) goto L19;
        Iterator<Map.Entry<String, Object>> r106 = r105.entrySet().iterator();     // Catch: Throwable -> L26
    L10:
        if (r106.hasNext() == false) goto L19;
        Map.Entry<String, Object> r107 = r106.next();     // Catch: Throwable -> L26
        JsonTemplate.a r108 = JsonTemplate.f51054c;     // Catch: Throwable -> L26
        String r109 = r107.getKey();     // Catch: Throwable -> L26
        r108.getClass();     // Catch: Throwable -> L26
        if (JsonTemplate.a.c(r109) == false) goto L10;
        Object r110 = r107.getValue();     // Catch: Throwable -> L26
        if ((r110 instanceof String) == true) goto L16;
        r110 = null;
    L16:
        String r111 = (String) r110;     // Catch: Throwable -> L26
        if (r111 == null) goto L10;
        a(r100, r111, r102, r103);     // Catch: Throwable -> L26
    L19:
        List<SlcElement> r112 = r101.getElements();     // Catch: Throwable -> L26
        if (r112 == null) goto L39;
        Iterator<T> r113 = r112.iterator();     // Catch: Throwable -> L26
    L22:
        if (r113.hasNext() == false) goto L40;
        c(r100, (SlcElement) r113.next(), r102, r103);     // Catch: Throwable -> L26
        goto L22
    L40:
        return;
    L39:
        return;
    L26:
        th = move-exception;
        nq.a.c(th, null, 2);
    }

    public static /* synthetic */ void d(SlcExprContext r100, SlcElement r101, b r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        c(r100, r101, r102, null);
    }
}
