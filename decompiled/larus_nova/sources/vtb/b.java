package vtb;

import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.a f557288a;

    public final void a() {
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L20
        r100.put("latency", Float.valueOf(this.f557288a.B.longValue()));     // Catch: Exception -> L20
        r100.put("load_message", this.f557288a.f557295f.longValue() - this.f557288a.f557294e.longValue());     // Catch: Exception -> L20
        r100.put("load_net_message", this.f557288a.f557297h.longValue() - this.f557288a.f557296g.longValue());     // Catch: Exception -> L20
        r100.put("first_render", this.f557288a.f557293d.longValue() - this.f557288a.f557292c.longValue());     // Catch: Exception -> L20
        this.f557288a.getClass();     // Catch: Exception -> L20
        r100.put("loading", 0);     // Catch: Exception -> L20
        r100.put("sdk_cost", this.f557288a.f557306q);     // Catch: Exception -> L20
        r100.put("client_data_cost", this.f557288a.f557308s);     // Catch: Exception -> L20
        c.a r101 = this.f557288a;     // Catch: Exception -> L20
        r100.put("client_render_cost", r101.f557313x - r101.f557312w);     // Catch: Exception -> L20
        if (this.f557288a.f557298i.longValue() <= 0) goto L7;
        r100.put("client_getLauncherInfo_cost", this.f557288a.f557298i);     // Catch: Exception -> L20
    L7:
        if (this.f557288a.f557299j.longValue() <= 0) goto L10;
        r100.put("client_openChatActivity_cost", this.f557288a.f557299j);     // Catch: Exception -> L20
    L10:
        if (this.f557288a.f557300k.longValue() <= 0) goto L12;
        r100.put("client_initview_cost", this.f557288a.f557300k);     // Catch: Exception -> L20
    L12:
        this.f557288a.getClass();     // Catch: Exception -> L20
        long r102 = this.f557288a.f557309t;     // Catch: Exception -> L20
        if (r102 <= 0) goto L15;
        r100.put("message_delay_cost", r102);     // Catch: Exception -> L20
    L15:
        long r103 = this.f557288a.f557310u;     // Catch: Exception -> L20
        if (r103 <= 0) goto L18;
        r100.put("message_wait_cost", r103);     // Catch: Exception -> L20
    L18:
        r100.put("load_message_from_net_cost", this.f557288a.f557301l);     // Catch: Exception -> L20
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L20
        r104.put("source_type", this.f557288a.F.value);     // Catch: Exception -> L20
        r104.put("chat_type", this.f557288a.G.value);     // Catch: Exception -> L20
        r104.put("is_first_start", this.f557288a.f557302m);     // Catch: Exception -> L20
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L20
        r105.put("chat_id", this.f557288a.f557305p);     // Catch: Exception -> L20
        r105.put("context_id", this.f557288a.f557304o);     // Catch: Exception -> L20
        r105.put("section.latency", this.f557288a.f557290a + "," + this.f557288a.f557291b);     // Catch: Exception -> L20
        r105.put("section.load_message", this.f557288a.f557294e + "," + this.f557288a.f557295f);     // Catch: Exception -> L20
        r105.put("section.load_net_message", this.f557288a.f557296g + "," + this.f557288a.f557297h);     // Catch: Exception -> L20
        r105.put("context_id.load_net_message", this.f557288a.f557304o);     // Catch: Exception -> L20
        r105.put("section.first_render", this.f557288a.f557292c + "," + this.f557288a.f557293d);     // Catch: Exception -> L20
        r105.put("section.client_render_cost", this.f557288a.f557312w + "," + this.f557288a.f557313x);     // Catch: Exception -> L20
        MonitorUtils.monitorEvent("chat_load_time", r104, r100, r105);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
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

    public b(c.a r100) {
        this.f557288a = r100;
    }
}
