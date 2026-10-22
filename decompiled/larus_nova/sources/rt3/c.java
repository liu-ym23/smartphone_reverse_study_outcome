package rt3;

import com.bytedance.apm6.hub.q;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends cv3.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f539190d;

    public final void a() {
        long r100 = System.currentTimeMillis();
        d r101 = this.f539190d;
        int r102 = r101.f539195d;
        long r103 = (((long) r101.f539194c) * 1024) * 1024;
        HashMap r104 = new HashMap();
        if (xu3.a.a() == false) goto L5;
        List<String> r105 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "start weedOut:" + (r100 - (((long) r102) * 86400000)));
    L5:
        Iterator r106 = ((HashSet) this.f539190d.f539192a).iterator();
        long r110 = 0;
    L7:
        if (r106.hasNext() == false) goto L16;
        e r107 = (e) r106.next();
        a r108 = new a();
        r104.put(r107.getName(), r108);
        r108.f539186a = r107.getName();
        r108.f539187b = r107.getSize();
        if (xu3.a.a() == false) goto L12;
        List<String> r111 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "weedOut:name:" + r108.f539186a + " beforeSize:" + r108.f539187b);
    L12:
        r107.a(r100 - (((long) r102) * 86400000));
        long r109 = r107.getSize();
        r108.f539188c = r109;
        if (xu3.a.a() == false) goto L15;
        List<String> r112 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "weedOut:name:" + r108.f539186a + " afterSize:" + r108.f539188c);
    L15:
        r110 = r110 + r109;
        r103 = r103;
        goto L7
    L16:
        long r113 = r103;
        int r114 = r102 - 1;
    L18:
        if (r110 <= r113) goto L28;
        if (r114 <= 0) goto L28;
        Iterator r115 = ((HashSet) this.f539190d.f539192a).iterator();
        r110 = 0;
    L22:
        if (r115.hasNext() == false) goto L27;
        e r116 = (e) r115.next();
        r116.a(r100 - (((long) r114) * 86400000));
        long r117 = r116.getSize();
        a r118 = (a) r104.get(r116.getName());
        if (r118 == null) goto L26;
        r118.f539188c = r117;
    L26:
        r110 = r110 + r116.getSize();
        goto L22
    L27:
        r114 = r114 - 1;
    L28:
        d r119 = this.f539190d;
        int r120 = r119.f539196e;
        if (r120 <= 0) goto L43;
        long r121 = (((long) r120) * 1024) * 1024;
        if (r110 <= r121) goto L43;
        Iterator r122 = ((HashSet) r119.f539192a).iterator();
    L34:
        if (r122.hasNext() == false) goto L43;
        e r123 = (e) r122.next();
        long r124 = r123.getSize();
        if (r124 <= 0) goto L34;
        r123.b(r121);
        long r125 = r123.getSize();
        a r126 = (a) r104.get(r123.getName());
        if (r126 == null) goto L34;
        if (xu3.a.a() == false) goto L42;
        List<String> r127 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "weedOut:name:" + r126.f539186a + " afterSize:" + r125 + " maxBytesToday clean: " + (r124 - r125));
    L42:
        r126.f539189d = true;
        r126.f539188c = r125;
    L43:
        b r128 = this.f539190d.f539193b;
        if (r128 == null) goto L82;
        ArrayList r129 = new ArrayList(r104.values());
        ((q) r128).getClass();
        if (xu3.e.b(r129) == true) goto L83;
        JSONObject r130 = new JSONObject();
        JSONObject r131 = new JSONObject();
        Iterator r132 = r129.iterator();
    L50:
        if (r132.hasNext() == false) goto L57;
        a r133 = (a) r132.next();
        r131.put("before_size_" + r133.f539186a, r133.f539187b);     // Catch: Exception -> L56
        r131.put("after_size_" + r133.f539186a, r133.f539188c);     // Catch: Exception -> L56
        r130.put(BdpAppEventConstant.PARAMS_STRATEGY_NAME, r133.f539186a);     // Catch: Exception -> L56
        boolean r134 = r133.f539189d;     // Catch: Exception -> L56
        if (r134 == false) goto L50;
        r130.put("reach_top_today", r134);     // Catch: Exception -> L56
        goto L50
    L57:
        jt3.a.e("apm_db_size", 0, r130, r131, null);
        return;
    L83:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(d r100) {
        this.f539190d = r100;
        super(0, 14400000);
    }
}
