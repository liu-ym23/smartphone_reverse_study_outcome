package mqa;

import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.sva.sdk.utils.InteractConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f514936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f514937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f514938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ServiceInfo f514939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f514940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Intent f514941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f514942g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f514943h;

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.put(ILoadStallMonitor.START_TIME, this.f514936a);     // Catch: Throwable -> L32
        r100.put("process", this.f514937b);     // Catch: Throwable -> L32
        r100.put("start_flag", this.f514940e);     // Catch: Throwable -> L32
        r100.put(InteractConst.WAKEUP_SCREEN_STATE, this.f514943h);     // Catch: Throwable -> L32
        ServiceInfo r101 = this.f514939d;     // Catch: Throwable -> L32
        if (r101 == null) goto L7;
        r100.put("start_component", r101.name);     // Catch: Throwable -> L32
    L7:
        Intent r102 = this.f514941f;     // Catch: Throwable -> L32
        if (r102 == null) goto L24;
        r100.put("intent", r102.toString());     // Catch: Throwable -> L32
        r100.put("intent_action", this.f514941f.getAction());     // Catch: Throwable -> L32
        if (this.f514941f.getComponent() == null) goto L12;
        r100.put("start_component", this.f514941f.getComponent().getClassName());     // Catch: Throwable -> L32
    L12:
        Bundle r103 = this.f514941f.getExtras();     // Catch: Throwable -> L32
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L32
        if (r103 != null) goto L15;
    L20:
        Uri r105 = this.f514941f.getData();     // Catch: Throwable -> L32
        if (r105 == null) goto L23;
        r104.put("intent_data_string", r105.toString());     // Catch: Throwable -> L32
    L23:
        r100.put("intent_data", r104);     // Catch: Throwable -> L32
        goto L24
    L15:
        if (r103.isEmpty() == true) goto L20;
        Iterator<String> r106 = r103.keySet().iterator();     // Catch: Throwable -> L32
    L18:
        if (r106.hasNext() == false) goto L20;
        String r107 = r106.next();     // Catch: Throwable -> L32
        r104.put(r107, r103.get(r107));     // Catch: Throwable -> L32
    L24:
        JSONArray r108 = new JSONArray();     // Catch: Throwable -> L32
        int r109 = 0;
    L26:
        if (r109 >= ((ArrayList) this.f514938c).size()) goto L28;
        r108.put(ListProtector.get(this.f514938c, r109));     // Catch: Throwable -> L32
        r109 = r109 + 1;     // Catch: Throwable -> L32
        goto L26
    L28:
        r100.put("message_list", r108);     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(this.f514942g) == true) goto L34;
        r100.put("referrer", this.f514942g);     // Catch: Throwable -> L32
    L34:
        return r100;
    L32:
        th = move-exception;
        th.printStackTrace();
        goto L34
    }

    public i() {
        this.f514936a = 0;
        this.f514937b = "";
        this.f514938c = new ArrayList();
        this.f514940e = 0;
    }

    public final String toString() {
        return a().toString();
    }
}
