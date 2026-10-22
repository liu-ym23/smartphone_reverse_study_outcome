package gbc;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xac.a f480809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f480810b;

    /* JADX INFO: renamed from: gbc.a$a, reason: collision with other inner class name */
    public static final class C6006a {
    }

    static {
    }

    @Override // gbc.d
    public final e a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (Intrinsics.areEqual(r100, c.b.f480813a) == false) goto L6;
        String r101 = "voice_input_start";
    L11:
        xac.a r102 = this.f480809a;
        r102.getClass();
        Intrinsics.checkNotNullParameter("extra_analytic_params", "key");
        Object r103 = ((LinkedHashMap) r102.f563099a).get("extra_analytic_params");
        if (r103 != null) goto L15;
        LinkedHashMap r104 = new LinkedHashMap();
    L32:
        if (r104.containsKey("click") == true) goto L34;
        r104.put("click", r101);
    L34:
        Iterator<Map.Entry<String, Object>> r105 = this.f480810b.entrySet().iterator();
    L36:
        if (r105.hasNext() == false) goto L41;
        Map.Entry<String, Object> r106 = r105.next();
        String r107 = r106.getKey();
        Object r108 = r106.getValue();
        if (r104.containsKey(r107) == true) goto L36;
        r104.put(r107, r108);
        goto L36
    L41:
        return new e(r104);
    L15:
        if ((r103 instanceof Map) == false) goto L43;
        Map r109 = (Map) r103;
        LinkedHashMap r110 = new LinkedHashMap(r109.size());
        Iterator r111 = r109.entrySet().iterator();
    L18:
        if (r111.hasNext() == false) goto L30;
        Map.Entry r112 = (Map.Entry) r111.next();
        Object r113 = r112.getKey();
        Object r114 = r112.getValue();
        if ((r113 instanceof String) == false) goto L29;
        if (r114 == null) goto L23;
        boolean r115 = true;
    L24:
        if (r115 == false) goto L27;
        r110.put(r113, r114);
        goto L18
    L27:
        throw new IllegalArgumentException("extra analytic param values must be non-null".toString());
    L23:
        r115 = false;
        goto L24
    L29:
        throw new IllegalArgumentException("extra analytic param keys must be String".toString());
    L30:
        r104 = r110;
        goto L32
    L43:
        throw new IllegalArgumentException("extra analytic params must be a Map<String, Any>".toString());
    L6:
        if (Intrinsics.areEqual(r100, c.a.f480812a) == false) goto L9;
        r101 = "voice_input_send";
        goto L11
    L9:
        if (Intrinsics.areEqual(r100, c.C6007c.f480814a) == false) goto L45;
        r101 = "slide_cancel";
        goto L11
    L45:
        throw new NoWhenBranchMatchedException();
    }

    public a(xac.a r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "voiceContext");
        Intrinsics.checkNotNullParameter(r101, "componentParams");
        this.f480809a = r100;
        this.f480810b = r101;
    }
}
