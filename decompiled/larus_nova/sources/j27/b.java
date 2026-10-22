package j27;

import android.app.Application;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.bytedance.mira.Mira;
import com.bytedance.mira.event.PluginEventManager;
import com.bytedance.mira.helper.MiraThreadPoolHelper;
import com.bytedance.mira.helper.ProcessHelper;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.plugin.Plugin;
import com.bytedance.mira.plugin.PluginManager;
import com.bytedance.morpheus.mira.MiraMorpheusHelper;
import h27.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import k27.g;
import l27.e;
import m27.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: loaded from: classes3.dex */
    public class a implements i27.b {
        public a() {
        }

        @Override // i27.b
        public final void a(i27.a r100) {
            MiraLogger.d(MiraLogger.TAG_DOWNLOAD, String.format("setupStatus name = %s , status = %d", new Object[]{r100.f488047a, Integer.valueOf(r100.f488049c)}));
            if (r100.f488049c != 6) goto L7;
            Exception r101 = r100.f488055i;
            if (r101 == null) goto L7;
            MiraLogger.d(MiraLogger.TAG_DOWNLOAD, String.format("setupStatus ERROR name = %s , error = %s", new Object[]{r100.f488047a, r101.toString()}));
        L7:
            h27.a.f483619b.getClass();
            d r102 = d.a();
            r102.f483628a.put(r100.f488047a, Integer.valueOf(r100.f488049c));
        }
    }

    public b() {
        c r100 = c.a();
        monitor-enter(r100);
    L48:
        th = move-exception;
        throw th;
    L6:
        if (r100.f511674a == false) goto L9;
        monitor-exit(r100);
    L11:
        Mira.init(h27.a.f483619b.b());
        Mira.start();
        if (ProcessHelper.isMainProcess(h27.a.getContext()) == false) goto L14;
    L15:
        List<Plugin> r101 = PluginManager.getInstance().listPlugins();
        HashMap r102 = new HashMap();
        Iterator<Plugin> r103 = r101.iterator();
    L17:
        if (r103.hasNext() == false) goto L24;
        Plugin r104 = r103.next();
        switch(r104.mLifeCycle) {
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L21;
            case 6: goto L22;
            case 7: goto L21;
            case 8: goto L21;
            default: goto L20;
        };
    L21:
        String r105 = r104.mPackageName;
        r102.put(r105, new i27.a(r105, r104.mVersionCode, 5));
        goto L17
    L22:
        MiraLogger.d(MiraLogger.TAG_DOWNLOAD, String.format("LIFE_RESOLVE_FAILED name = %s ", new Object[]{r104.mPackageName}));
        String r106 = r104.mPackageName;
        i27.a r107 = new i27.a(r106, r104.mVersionCode, 6);
        r107.f488053g = -100;
        r102.put(r106, r107);
        goto L17
    L23:
        String r108 = r104.mPackageName;
        r102.put(r108, new i27.a(r108, r104.mVersionCode, 4));
        goto L17
    L20:
        String r109 = r104.mPackageName;
        r102.put(r109, new i27.a(r109, r104.mVersionCode, 1));
        goto L17
    L24:
        ((HashMap) h27.c.a().f483624c).putAll(r102);
        MiraMorpheusHelper.a();
        h27.c r110 = h27.c.a();
        ((CopyOnWriteArrayList) r110.f483623b).add(new a());
    L26:
        if (ProcessHelper.isMainProcess(h27.a.getContext()) == false) goto L72;
        o27.c r111 = o27.c.a();
        Application r112 = h27.a.f483619b.b();
        r111.getClass();
        r112.registerActivityLifecycleCallbacks(new o27.b(r111));
        e r113 = e.d();
        r113.getClass();
        r113.f507148a = h27.a.f483619b.b();
        j27.a r114 = h27.a.f483619b;
        r114.getClass();
        if ((true ^ (r114 instanceof cl9.a)) == false) goto L30;
        o27.c r115 = o27.c.a();
        ((ArrayList) r115.f521788c).add(new l27.d(r113));
    L30:
        g.a().getClass();
        MiraThreadPoolHelper.sMiraFastExecutor.execute(new g.a());
        n27.d r116 = n27.d.a();
        r116.getClass();
        JSONArray r117 = new JSONArray();
        Iterator<Plugin> r118 = PluginManager.getInstance().listPlugins().iterator();
    L32:
        if (r118.hasNext() == false) goto L41;
        Plugin r119 = r118.next();
        if (r119.mLifeCycle < 4) goto L32;
        JSONObject r120 = new JSONObject();
        r120.putOpt("plugin_name", r119.mPackageName);     // Catch: JSONException -> L38
        r120.putOpt("version_code", Integer.valueOf(r119.mVersionCode));     // Catch: JSONException -> L38
    L40:
        r117.put(r120);
    L38:
        e = move-exception;
        e.printStackTrace();
        goto L40
    L41:
        long r121 = System.currentTimeMillis();
        JSONObject r122 = new JSONObject();
        r122.putOpt("timestamp", Long.valueOf(r121));     // Catch: JSONException -> L44
        r122.putOpt(n.KEY_PLUGINS, r117);     // Catch: JSONException -> L44
    L46:
        MonitorUtils.monitorCommonLog("mira_plugin_monitor", r122);
        r116.f516748a = r121;
        return;
    L44:
        e = move-exception;
        e.printStackTrace();
        goto L46
    L72:
        return;
    L14:
        if (ProcessHelper.isPluginProcess(h27.a.getContext()) == false) goto L26;
    L9:
        PluginEventManager.getInstance().addPluginEventListener(new m27.a(r100));     // Catch: Throwable -> L48
        r100.f511674a = true;     // Catch: Throwable -> L48
        monitor-exit(r100);
        goto L11
    }
}
