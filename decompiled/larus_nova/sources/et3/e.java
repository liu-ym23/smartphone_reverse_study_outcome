package et3;

import com.bytedance.apm.constant.FilterTypeStringDef;
import com.bytedance.apm.util.i;
import com.bytedance.apm.util.j;
import com.bytedance.apm.util.k;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f473905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f473906b;

    public final void a() {
    L24:
        e = move-exception;
        if (com.bytedance.apm.d.j() == false) goto L35;
        e.printStackTrace();
        return;
    L35:
        return;
    L4:
        if (k.b(this.f473905a) == false) goto L6;
        return;
    L6:
        float r100 = i.f190669a;     // Catch: Exception -> L24
        int r101 = i.f190670b;     // Catch: Exception -> L24
        int r102 = r101 - 1;     // Catch: Exception -> L24
        int[] r103 = new int[(r102 + 0) + 1];     // Catch: Exception -> L24
        Iterator r104 = this.f473905a.iterator();     // Catch: Exception -> L24
        int r105 = 0;
        int r106 = 0;
    L8:
        if (r104.hasNext() == false) goto L10;
        Integer r107 = (Integer) r104.next();     // Catch: Exception -> L24
        int r110 = (int) (100.0f * r100);     // Catch: Exception -> L24
        int r111 = Math.max(Math.min(((r107.intValue() + (r110 - 1)) / r110) - 1, r102), 0);     // Catch: Exception -> L24
        r103[r111] = r103[r111] + 1;     // Catch: Exception -> L24
        r106 = r106 + (r107.intValue() / 100);     // Catch: Exception -> L24
        goto L8
    L10:
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L24
    L11:
        if (r105 > r102) goto L16;
        if (r103[r105] <= 0) goto L15;
        r108.put(String.valueOf(r105), r103[r105]);     // Catch: Exception -> L24
    L15:
        r105 = r105 + 1;     // Catch: Exception -> L24
        goto L11
    L16:
        c.InterfaceC5817c r109 = this.f473906b.f473893d;     // Catch: Exception -> L24
        if (r109 == null) goto L19;
        r109.dropFrame(j.a(r108));     // Catch: Exception -> L24
    L19:
        JSONObject r112 = new JSONObject();     // Catch: Exception -> L24
        r112.put("scene", this.f473906b.f473890a);     // Catch: Exception -> L24
        JSONObject r113 = new JSONObject();     // Catch: Exception -> L24
        r113.put("total_scroll_time", r106);     // Catch: Exception -> L24
        StringBuilder r114 = new StringBuilder();     // Catch: Exception -> L24
        this.f473906b.getClass();     // Catch: Exception -> L24
        r114.append(0.0f);     // Catch: Exception -> L24
        r114.append(",");     // Catch: Exception -> L24
        this.f473906b.getClass();     // Catch: Exception -> L24
        r114.append(0.0f);     // Catch: Exception -> L24
        r113.put("velocity", r114.toString());     // Catch: Exception -> L24
        StringBuilder r115 = new StringBuilder();     // Catch: Exception -> L24
        this.f473906b.getClass();     // Catch: Exception -> L24
        r115.append(0.0f);     // Catch: Exception -> L24
        r115.append(",");     // Catch: Exception -> L24
        this.f473906b.getClass();     // Catch: Exception -> L24
        r115.append(0.0f);     // Catch: Exception -> L24
        r113.put("distance", r115.toString());     // Catch: Exception -> L24
        JSONObject r116 = this.f473906b.f473899j;     // Catch: Exception -> L24
        if (r116 == null) goto L22;
        r113.put("extra", r116);     // Catch: Exception -> L24
    L22:
        r113.put("drop_time_rate", 1.0f - ((this.f473905a.size() * 1.0f) / ((int) (r106 / r100))));     // Catch: Exception -> L24
        js3.e r117 = new js3.e(FilterTypeStringDef.FPS_DROP, this.f473906b.f473890a, r108, r112, r113);     // Catch: Exception -> L24
        JSONObject r118 = ou3.a.a().c(true);     // Catch: Exception -> L24
        r117.f500222f = r118;     // Catch: Exception -> L24
        r118.put("refresh_rate", r101);     // Catch: Exception -> L24
        is3.a.h().b(r117);     // Catch: Exception -> L24
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

    public e(c r100, List r101) {
        this.f473906b = r100;
        this.f473905a = r101;
    }
}
