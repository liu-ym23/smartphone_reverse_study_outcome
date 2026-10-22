package nn6;

import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f519662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Long> f519663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f519664c;

    public final void a() {
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L17
        Iterator r101 = ((HashMap) this.f519664c).entrySet().iterator();     // Catch: Exception -> L17
    L5:
        if (r101.hasNext() == false) goto L9;
        Map.Entry r102 = (Map.Entry) r101.next();     // Catch: Exception -> L17
        String r103 = (String) r102.getKey();     // Catch: Exception -> L17
        String r104 = (String) r102.getValue();     // Catch: Exception -> L17
        if (r103 == null) goto L5;
        r100.put(r103, r104);     // Catch: Exception -> L17
        goto L5
    L9:
        Iterator r105 = ((HashMap) this.f519663b).entrySet().iterator();     // Catch: Exception -> L17
    L11:
        if (r105.hasNext() == false) goto L15;
        Map.Entry r106 = (Map.Entry) r105.next();     // Catch: Exception -> L17
        String r107 = (String) r106.getKey();     // Catch: Exception -> L17
        long r108 = ((Number) r106.getValue()).longValue();     // Catch: Exception -> L17
        if (r108 <= 0) goto L11;
        r100.put(r107, String.valueOf(r108));     // Catch: Exception -> L17
        goto L11
    L15:
        int r109 = com.bytedance.locallife.biz.mob.a.f256703c;     // Catch: Exception -> L17
        com.bytedance.locallife.biz.mob.a.C3646a.d(this.f519662a, r100);     // Catch: Exception -> L17
    L38:
        JSONObject r110 = new JSONObject();     // Catch: Exception -> L33
        Iterator r111 = ((HashMap) this.f519664c).entrySet().iterator();     // Catch: Exception -> L33
    L21:
        if (r111.hasNext() == false) goto L25;
        Map.Entry r112 = (Map.Entry) r111.next();     // Catch: Exception -> L33
        String r113 = (String) r112.getKey();     // Catch: Exception -> L33
        String r114 = (String) r112.getValue();     // Catch: Exception -> L33
        if (r113 == null) goto L21;
        r110.put(r113, r114);     // Catch: Exception -> L33
        goto L21
    L25:
        JSONObject r115 = new JSONObject();     // Catch: Exception -> L33
        Iterator r116 = ((HashMap) this.f519663b).entrySet().iterator();     // Catch: Exception -> L33
    L27:
        if (r116.hasNext() == false) goto L31;
        Map.Entry r117 = (Map.Entry) r116.next();     // Catch: Exception -> L33
        String r118 = (String) r117.getKey();     // Catch: Exception -> L33
        long r119 = ((Number) r117.getValue()).longValue();     // Catch: Exception -> L33
        if (r119 <= 0) goto L27;
        r115.put(r118, String.valueOf(r119));     // Catch: Exception -> L33
        goto L27
    L31:
        HostServiceUtilsKt.l().monitorEvent(this.f519662a, r110, r115, null);     // Catch: Exception -> L33
        return;
    L33:
        e = move-exception;
        e.printStackTrace();
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L38
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f519662a = r100;
        new HashMap();
        this.f519663b = new HashMap();
        this.f519664c = new HashMap();
        new LinkedHashMap();
    }

    public final void b(String r100, String r101) {
        ((HashMap) this.f519664c).put(r100, r101);
    }
}
