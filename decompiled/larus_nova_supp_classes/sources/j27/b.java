package j27;

import android.app.Application;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.bytedance.mira.Mira;
import com.bytedance.mira.event.PluginEventManager;
import com.bytedance.mira.helper.MiraThreadPoolHelper;
import com.bytedance.mira.helper.ProcessHelper;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.plugin.Plugin;
import com.bytedance.mira.plugin.PluginManager;
import com.bytedance.morpheus.mira.MiraMorpheusHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import k27.g;
import l27.d;
import l27.e;
import m27.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b {
    public b() {
        c r0 = c.a();
        monitor-enter(r0);
    L48:
        th = move-exception;
        throw th;
    L6:
        if (r0.a == false) goto L9;
        monitor-exit(r0);
    L11:
        Mira.init(h27.a.b.b());
        Mira.start();
        if (ProcessHelper.isMainProcess(h27.a.getContext()) == false) goto L14;
    L15:
        List r1 = PluginManager.getInstance().listPlugins();
        HashMap r3 = new HashMap();
        Iterator r2 = r1.iterator();
    L17:
        if (r2.hasNext() == false) goto L24;
        Plugin r4 = (Plugin) r2.next();
        switch(r4.mLifeCycle) {
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
        String r6 = r4.mPackageName;
        r3.put(r6, new i27.a(r6, r4.mVersionCode, 5));
        goto L17
    L22:
        MiraLogger.d(MiraLogger.TAG_DOWNLOAD, String.format("LIFE_RESOLVE_FAILED name = %s ", new Object[]{r4.mPackageName}));
        String r7 = r4.mPackageName;
        i27.a r5 = new i27.a(r7, r4.mVersionCode, 6);
        r5.g = -100;
        r3.put(r7, r5);
        goto L17
    L23:
        String r8 = r4.mPackageName;
        r3.put(r8, new i27.a(r8, r4.mVersionCode, 4));
        goto L17
    L20:
        String r9 = r4.mPackageName;
        r3.put(r9, new i27.a(r9, r4.mVersionCode, 1));
        goto L17
    L24:
        ((HashMap) h27.c.a().c).putAll(r3);
        MiraMorpheusHelper.a();
        h27.c r10 = h27.c.a();
        ((CopyOnWriteArrayList) r10.b).add(new a());
    L26:
        if (ProcessHelper.isMainProcess(h27.a.getContext()) == false) goto L72;
        o27.c r11 = o27.c.a();
        Application r12 = h27.a.b.b();
        r11.getClass();
        r12.registerActivityLifecycleCallbacks(new o27.b(r11));
        e r13 = e.d();
        r13.getClass();
        r13.a = h27.a.b.b();
        a r14 = h27.a.b;
        r14.getClass();
        if ((true ^ (r14 instanceof cl9.a)) == false) goto L30;
        o27.c r15 = o27.c.a();
        ((ArrayList) r15.c).add(new d(r13));
    L30:
        g.a().getClass();
        MiraThreadPoolHelper.sMiraFastExecutor.execute(new g.a());
        n27.d r16 = n27.d.a();
        r16.getClass();
        JSONArray r17 = new JSONArray();
        Iterator r18 = PluginManager.getInstance().listPlugins().iterator();
    L32:
        if (r18.hasNext() == false) goto L41;
        Plugin r19 = (Plugin) r18.next();
        if (r19.mLifeCycle < 4) goto L32;
        JSONObject r20 = new JSONObject();
        r20.putOpt("plugin_name", r19.mPackageName);     // Catch: JSONException -> L38
        r20.putOpt("version_code", Integer.valueOf(r19.mVersionCode));     // Catch: JSONException -> L38
    L40:
        r17.put(r20);
    L38:
        e = move-exception;
        e.printStackTrace();
        goto L40
    L41:
        long r21 = System.currentTimeMillis();
        JSONObject r22 = new JSONObject();
        r22.putOpt("timestamp", Long.valueOf(r21));     // Catch: JSONException -> L44
        r22.putOpt("plugins", r17);     // Catch: JSONException -> L44
    L46:
        MonitorUtils.monitorCommonLog("mira_plugin_monitor", r22);
        r16.a = r21;
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
        PluginEventManager.getInstance().addPluginEventListener(new m27.a(r0));     // Catch: Throwable -> L48
        r0.a = true;     // Catch: Throwable -> L48
        monitor-exit(r0);
        goto L11
    }
}
