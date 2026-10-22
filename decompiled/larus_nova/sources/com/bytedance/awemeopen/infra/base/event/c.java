package com.bytedance.awemeopen.infra.base.event;

import com.bytedance.awemeopen.infra.base.env.AoEnv;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f198616a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, Function0<String>> f198617b = null;

    public c() {
    }

    static {
        f198616a = new c();
        f198617b = new HashMap();
    }

    @Override // com.bytedance.awemeopen.infra.base.event.d
    public final JSONObject getParams() {
        JSONObject r100 = new JSONObject();
        String r101 = b.f198600f.invoke();
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.put("aosdk_open_id", r101);
        Function0<String> r103 = b.f198601g;
        if (r103 != null) goto L8;
        String r104 = "";
    L9:
        if (r104 == null) goto L12;
        r102 = r104;
    L12:
        r100.put("nature_open_id", r102);
        if (b.f198602h.invoke().booleanValue() == false) goto L15;
        String r105 = "1";
    L16:
        r100.put("is_auth", r105);
        r100.put("is_tob", "0");
        r100.put("origin_app_id", AoEnv.d());
        r100.put("aosdk_version", AoEnv.g());
        r100.put("aosdk_version_code", 37300);
        r100.put("aosdk_full_version", "3.7.3");
        r100.put("host_version", AoEnv.f());
        r100.put("host_version_code", AoEnv.a().getHostVersionCode());
        r100.put("host_update_version_code", AoEnv.e());
        r100.put("aobizsdk_name", AoEnv.f198596c);
        r100.put("aobizsdk_version", AoEnv.f198597d);
        r100.put("aobizsdk_version_code", 0);
        HashMap<String, Function0<String>> r106 = f198617b;
        if ((!r106.isEmpty()) == false) goto L22;
        Iterator<Map.Entry<String, Function0<String>>> r107 = r106.entrySet().iterator();
    L20:
        if (r107.hasNext() == false) goto L22;
        Map.Entry<String, Function0<String>> r108 = r107.next();
        r100.put(r108.getKey(), r108.getValue().invoke());
    L22:
        return r100;
    L15:
        r105 = "0";
        goto L16
    L8:
        r104 = r103.invoke();
        goto L9
    }
}
