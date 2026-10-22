package com.ss.android.ugc.route_monitor.impl.route_out;

import android.content.Intent;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.ugc.route_monitor.utils.Logger;
import com.ss.android.ugc.route_monitor.utils.u;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f454687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f454688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f454689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f454690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f454691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f454692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Intent f454693g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f454694h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Object> f454695i;

    public static final class a {
    }

    static {
    }

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        Iterator r101 = ((ConcurrentHashMap) this.f454695i).entrySet().iterator();     // Catch: Exception -> L8
    L5:
        if (r101.hasNext() == false) goto L10;
        Map.Entry r102 = (Map.Entry) r101.next();     // Catch: Exception -> L8
        r100.put((String) r102.getKey(), r102.getValue());     // Catch: Exception -> L8
    L10:
        r100.put(AppbrandHostConstants.SCHEMA_INSPECT.SESSION, this.f454687a);
        r100.put("report_reason", this.f454688b);
        r100.put("back_cost_time", this.f454689c);
        r100.put("target_app", this.f454690d);
        r100.put("back_timestamp", this.f454691e);
        r100.put("back_page_name", this.f454692f);
        r100.put("route_out_type", this.f454694h);
        r100.put("back_page_data", u.g(this.f454693g));
        return r100;
    L8:
        e = move-exception;
        Logger.f454747c.d(e);
        goto L10
    }

    public g(l r100) {
        this.f454692f = "";
        this.f454694h = "";
        ConcurrentHashMap r101 = new ConcurrentHashMap();
        this.f454695i = r101;
        this.f454687a = r100.f454704a;
        this.f454688b = 1;
        this.f454689c = r100.f454713j;
        this.f454690d = r100.f454705b;
        this.f454691e = r100.f454709f;
        this.f454694h = r100.f454720q;
        r101.putAll(r100.f454716m);
    }
}
