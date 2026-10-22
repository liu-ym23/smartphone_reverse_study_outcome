package g59;

import android.content.Context;
import com.google.gson.Gson;
import com.larus.dora.impl.dynamic.a2;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h59.a f480103a;

    public static final class a {
    }

    static {
    }

    public d() {
        h59.a r100 = new h59.a();
        Intrinsics.checkNotNullParameter(r100, "localPageDataSource");
        this.f480103a = r100;
    }

    public final a2 a(Context r100, String r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "pageName");
        h59.a r101 = this.f480103a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "pageName");
        String r102 = r110 + '_' + r111;
        if (r101.f483887a.containsKey(r102) == false) goto L5;
        a2 r103 = (a2) ((LinkedHashMap) r101.f483887a).get(r102);
        g49.d.d("LocalPageDataSource", "fetchPageData: cache hit, productId=" + r111 + ", page=" + r110 + ", data=" + r103);
        return r103;
    L5:
        int r104 = r110.hashCode();
        if (r104 == (-1543122713)) goto L21;
        if (r104 == (-1156133010)) goto L17;
        if (r104 == (-857462632)) goto L13;
    L22:
        String r105 = "";
    L25:
        if (r105.length() != 0) goto L27;
        boolean r106 = true;
    L29:
        if (r106 == false) goto L42;
        g49.d.b("LocalPageDataSource", "fetchPageData: ERROR fileName is empty");
    L45:
        return null;
    L42:
        String r107 = h59.a.a(r100, r105);     // Catch: Exception -> L36
        if (r107 == null) goto L45;
        a2 r108 = (a2) new Gson().fromJson(r107, a2.class);     // Catch: Exception -> L36
    L38:
        if (r108 == null) goto L40;
        r101.f483887a.put(r102, r108);
    L40:
        g49.d.d("LocalPageDataSource", "fetchPageData: productId=" + r111 + ", page=" + r110 + ", data=" + r108);
        return r108;
    L36:
        e = move-exception;
        g49.d.c("LocalPageDataSource", "fetchPageData: ERROR " + e.getMessage(), e);
        r108 = null;
        goto L38
    L27:
        r106 = false;
        goto L29
    L13:
        if (r110.equals("bind_device") == false) goto L22;
        r105 = h59.a.b(r111, "dora_bind_device.json");
        goto L25
    L17:
        if (r110.equals("device_manage") == false) goto L22;
        r105 = h59.a.b(r111, "dora_device_manage.json");
        goto L25
    L21:
        if (r110.equals("device_list") == false) goto L22;
        r105 = h59.a.b(-1, "dora_device_list.json");
        goto L25
    }
}
