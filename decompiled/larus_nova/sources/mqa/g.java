package mqa;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile g f514930c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PushMultiProcessSharedProvider.b f514931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f514932b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f514933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f514934b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<String> f514935c;

        public a(String r100) {
            int r101 = 0;
            this.f514933a = false;
            this.f514934b = false;
            this.f514935c = null;
            if (TextUtils.isEmpty(r100) == true) goto L42;
            JSONObject r102 = new JSONObject(r100);     // Catch: Exception -> L30
            if (r102.optInt("is_monitor_alive_enable", 0) <= 0) goto L8;
            boolean r103 = true;
        L9:
            this.f514933a = r103;     // Catch: Exception -> L30
            r102.optInt("monitor_live_interval_second", 30);     // Catch: Exception -> L30
            r102.optInt("max_send_start_info_num", 100);     // Catch: Exception -> L30
            r102.optInt("default_send_data_interval", 7200);     // Catch: Exception -> L30
            this.f514934b = r102.optBoolean("enable_upload_unactive_apps", false);     // Catch: Exception -> L30
            JSONArray r104 = r102.optJSONArray("upload_unactive_app_packages");     // Catch: Exception -> L30
            if (r104 == null) goto L23;
            this.f514935c = new ArrayList();     // Catch: Exception -> L30
            int r105 = 0;
        L14:
            if (r105 >= r104.length()) goto L23;
            String r106 = JSONArrayProtectorUtils.getString(r104, r105);     // Catch: JSONException -> L19 Exception -> L30
            if (TextUtils.isEmpty(r106) == true) goto L21;
            this.f514935c.add(r106);     // Catch: JSONException -> L19 Exception -> L30
        L21:
            r105 = r105 + 1;     // Catch: Exception -> L30
        L19:
            e = move-exception;
            com.bytedance.push.utils.f.b("MonitorLiveSetting", "setConfigJson error" + e.getMessage());     // Catch: Exception -> L30
        L23:
            if (com.bytedance.push.utils.f.f267065a == false) goto L41;
            com.bytedance.push.utils.f.b("MonitorLiveSetting", "enable_upload_unactive_apps : " + this.f514934b);     // Catch: Exception -> L30
            StringBuilder r107 = new StringBuilder();     // Catch: Exception -> L30
            r107.append("upload_unactive_app_packages size : ");     // Catch: Exception -> L30
            List<String> r108 = this.f514935c;     // Catch: Exception -> L30
            if (r108 == null) goto L28;
            r101 = r108.size();     // Catch: Exception -> L30
        L28:
            r107.append(r101);     // Catch: Exception -> L30
            r107.append("");     // Catch: Exception -> L30
            com.bytedance.push.utils.f.b("MonitorLiveSetting", r107.toString());     // Catch: Exception -> L30
            return;
        L41:
            return;
        L8:
            r103 = false;
        L30:
            e = move-exception;
            e.printStackTrace();
            return;
        }
    }

    public final synchronized a a() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f514932b != null) goto L6;
        this.f514932b = new a(this.f514931a.e("monitor_alive_config"));     // Catch: Throwable -> L9
    L6:
        a r100 = this.f514932b;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    public g(Context r100) {
        if ((r100 instanceof Application) == true) goto L5;
        r100 = r100.getApplicationContext();
    L5:
        this.f514931a = PushMultiProcessSharedProvider.e(r100);
    }
}
