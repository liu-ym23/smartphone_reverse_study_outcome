package r74;

import android.content.Context;
import com.bytedance.bdinstall.dtrait.constant.DTraitRiskType;
import com.bytedance.common.utility.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends s74.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, w74.f> f536432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f536433g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile String f536434h;

    @Override // s74.a
    public final String c() {
        return "[collectLoader] ";
    }

    @Override // s74.a
    public final List<String> b() {
        ((ArrayList) this.f536433g).add("d_i0");
        ((ArrayList) this.f536433g).add("d_a0");
        ((ArrayList) this.f536433g).add("d_r0");
        ((ArrayList) this.f536433g).add("d_b0");
        ((ArrayList) this.f536433g).add("d_m0");
        return this.f536433g;
    }

    public final void e() {
        if (((ArrayList) this.f540924a).size() > 0) goto L6;
        m74.a.a("[dt] [collectLoader] doCollect# futureList is 0, return.");
        return;
    L6:
        m74.a.a("[dt] [collectLoader] doCollect# futureList size: " + ((ArrayList) this.f540924a).size());
        int r100 = 0;
        ExecutorCompletionService r101 = new ExecutorCompletionService(o74.a.f522262e.b(new Object[0]));
        Iterator r102 = ((ArrayList) this.f540924a).iterator();
    L8:
        if (r102.hasNext() == false) goto L11;
        r101.submit((p74.a) r102.next());
    L11:
        if (r100 >= ((ArrayList) this.f540924a).size()) goto L17;
        w74.f r103 = (w74.f) r101.take().get(5, TimeUnit.SECONDS);     // Catch: Exception -> L14
        ((HashMap) this.f536432f).put(r103.f558526a, r103);     // Catch: Exception -> L14
    L16:
        r100 = r100 + 1;
    L14:
        e = move-exception;
        m74.a.b("[dt] [collectLoader] doCollect# error " + e.getMessage());
        goto L16
    }

    public static void d(c r100, JSONObject r101, boolean r102) {
        if (((HashMap) r100.f536432f).size() > 0) goto L5;
        m74.a.a("[dt] [collectLoader] doReport# loaderInfoList is 0, return.");
        return;
    L5:
        JSONObject r103 = new JSONObject();
        Iterator r104 = ((HashMap) r100.f536432f).entrySet().iterator();
    L7:
        if (r104.hasNext() == false) goto L14;
        Map.Entry r105 = (Map.Entry) r104.next();
        r103.putOpt((String) r105.getKey(), y74.d.b(((w74.f) r105.getValue()).f558530e));     // Catch: JSONException -> L11
    L11:
        e = move-exception;
        Logger.e("[dt] [collectLoader] doReport# error " + e.getMessage());
        goto L7
    L14:
        if (n74.a.f518199a == false) goto L18;
        m74.c r106 = (m74.c) v74.e.a(m74.c.class);
        if (r106 == null) goto L18;
        Logger.d("[dt] [collectLoader] LoaderManager#statsCollect start get dtrait...... ");
        r100.f536434h = r106.f512345a.a("[status_collect]", DTraitRiskType.HIGH, 30000).get("x-tt-device-dtrait");
    L18:
        o74.a.f522259b.b(new Object[0]).execute(new b(r100, r101, r103, r102));
    }

    public c(Context r100, p74.b r101, v74.a r102, boolean r103) {
        super(r100, r101, r102, r103);
        this.f536434h = "";
        this.f536432f = new HashMap();
        this.f536433g = new ArrayList();
    }
}
