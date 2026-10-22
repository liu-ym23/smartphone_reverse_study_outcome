package xoa;

import com.bytedance.services.apm.api.EnsureManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f564690a;

    static {
    }

    public static void a(Throwable r100, String r101, Map r102) {
        apa.a.c("AzerothPrivacyError", r101, r100);
        if (f564690a != null) goto L6;
        return;
    L6:
        if (fpa.b.b(r100) == false) goto L8;
        return;
    L8:
        Map<String, String> r103 = fpa.b.a(r100);
        if (r103 == null) goto L18;
        if (r102 != null) goto L12;
        r102 = r103;
        goto L18
    L12:
        Iterator<Map.Entry<String, String>> r104 = r103.entrySet().iterator();
    L14:
        if (r104.hasNext() == false) goto L18;
        Map.Entry<String, String> r105 = r104.next();
        HashMap r106 = (HashMap) r102;
        if (r106.get(r105.getKey()) != null) goto L14;
        r106.put(r105.getKey(), r105.getValue());
    L18:
        if (r102 != null) goto L20;
        r102 = fpa.a.a();
    L20:
        ((com.larus.security.api.b) f564690a).getClass();
        EnsureManager.ensureNotReachHere(r100, r101, r102);
    }
}
