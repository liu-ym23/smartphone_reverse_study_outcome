package ic9;

import com.larus.network.HttpConst;
import com.larus.network.http.HttpExtKt;
import com.larus.network.m;
import com.larus.platform.api.b2;
import com.larus.platform.api.i;
import hq9.q1;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements b2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f489262b = null;

    static {
        f489262b = new f();
    }

    public f() {
    }

    @Override // com.larus.platform.api.b2
    public final int getPluginVersion() {
        return -1;
    }

    @Override // com.larus.platform.api.b2
    public final Object m() {
        return null;
    }

    @Override // com.larus.platform.api.b2
    public final Object n() {
        return null;
    }

    @Override // com.larus.platform.api.b2
    public final i a() {
        HttpConst r100 = HttpConst.f359979a;
        r100.getClass();
        String r101 = HttpConst.f359987e;
        r100.getClass();
        String r102 = HttpConst.f360030z0;
        r100.getClass();
        String r103 = HttpConst.A0;
        r100.getClass();
        String r104 = HttpConst.B0;
        r100.getClass();
        String r105 = HttpConst.C0;
        r100.getClass();
        String r106 = HttpConst.D0;
        r100.getClass();
        return new i(r101, r102, r103, r104, r105, r106, HttpConst.E0);
    }

    @Override // com.larus.platform.api.b2
    public final Map<String, String> b() {
        HashMap r100 = new HashMap();
        String r101 = com.larus.network.http.d.f360140a;
        if (com.larus.network.http.d.f360140a.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        r100.put("evaluate", com.larus.network.http.d.f360140a);
        r100.put("evaluate_conversation_id_list", com.larus.network.http.d.f360141b);
    L8:
        return r100;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.larus.platform.api.b2
    public final String c() {
        return HttpConst.f359979a.X();
    }

    @Override // com.larus.platform.api.b2
    public final q1 d() {
        Lazy r100 = m.f360210a;
        return m.a();
    }

    @Override // com.larus.platform.api.b2
    public final String e() {
        HttpConst.f359979a.getClass();
        return HttpConst.f360005n;
    }

    @Override // com.larus.platform.api.b2
    public final String g() {
        int r100 = yo8.b.f568681a;
        if (HttpExtKt.e().f360166a == false) goto L5;
        return "is.snssdk.com.boe-gateway.byted.org";
    L5:
        return "settings-api.doubao.com";
    }

    @Override // com.larus.platform.api.b2
    public final String h() {
        HttpConst.f359979a.getClass();
        return HttpConst.f359995i;
    }

    @Override // com.larus.platform.api.b2
    public final String j() {
        StringBuilder r100 = new StringBuilder("https://");
        HttpConst r101 = HttpConst.f359979a;
        r101.getClass();
        r101.getClass();
        r100.append(HttpConst.f359999k);
        return r100.toString();
    }

    @Override // com.larus.platform.api.b2
    public final String k() {
        HttpConst.f359979a.getClass();
        return HttpConst.f360009p;
    }

    @Override // com.larus.platform.api.b2
    public final String l() {
        HttpConst.f359979a.getClass();
        return HttpConst.f360001l;
    }

    @Override // com.larus.platform.api.b2
    public final String o() {
        HttpConst.f359979a.getClass();
        return HttpConst.f360007o;
    }

    @Override // com.larus.platform.api.b2
    public final Map<String, String> f() {
        return MapsKt.emptyMap();
    }

    @Override // com.larus.platform.api.b2
    public final Map<String, String> getCommonParams() {
        return d.a();
    }

    @Override // com.larus.platform.api.b2
    public final List<String> i() {
        return CollectionsKt.emptyList();
    }
}
