package pd7;

import com.bytedance.sdk.xbridge.cn.auth.PermissionConfigV2Parser;
import com.bytedance.sdk.xbridge.cn.auth.g;
import id7.c;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ld7.f;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static g f528686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, md7.a> f528687b = null;

    static {
        f528687b = new ConcurrentHashMap();
    }

    public static md7.a a(String r100) {
        ConcurrentHashMap<String, md7.a> r101 = f528687b;
        md7.a r102 = r101.get(r100);
        ConcurrentHashMap<String, f> r103 = PermissionConfigV2Parser.f269801a;
        Map<String, ? extends List<ld7.b>> r104 = PermissionConfigV2Parser.b(r100);
        if (r104 == null) goto L11;
        if (r102 != null) goto L10;
        g r105 = f528686a;
        if (r105 == null) goto L8;
        r105.j();
        int r106 = 128;
    L9:
        r102 = new md7.a(r100, r106, r104);
        r101.put(r100, r102);
        c.a("create config for namespace: ".concat(r100));
        goto L11
    L8:
        r106 = 32;
        goto L9
    L10:
        r102.update(r104);
        c.a("update config for namespace: ".concat(r100));
    L11:
        return r102;
    }
}
