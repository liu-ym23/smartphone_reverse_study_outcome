package com.bytedance.gamecenter.base;

import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.download.api.config.IHttpCallback;
import com.ss.android.downloadlib.DownloadComponentManager;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class i implements IHttpCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f244988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f244989b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f244990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f244991b;

        public final void a() {
            JSONObject r100 = new JSONObject(this.f244990a);     // Catch: JSONException -> L20
            this.f244991b.f244989b.getClass();     // Catch: JSONException -> L20
            if (r100.optInt("code", -1) == 0) goto L5;
        L7:
            boolean r101 = false;
        L8:
            JSONObject r102 = r100.optJSONObject("enable_feature");     // Catch: JSONException -> L20
            if (r101 == false) goto L18;
            if (r101 == true) goto L13;
            return;
        L13:
            if (q.l().k().optInt("enable_cancel_reserve", 0) != 1) goto L25;
            i r103 = this.f244991b;     // Catch: JSONException -> L20
            n r104 = r103.f244989b;     // Catch: JSONException -> L20
            JSONObject r105 = r103.f244988a;     // Catch: JSONException -> L20
            r104.getClass();     // Catch: JSONException -> L20
            String r106 = r105.optString("cancel_reserve_url");     // Catch: JSONException -> L20
            if (TextUtils.isEmpty(r106) == true) goto L26;
            HashMap r107 = new HashMap();     // Catch: JSONException -> L20
            r107.put("unified_game_id", r105.optString("order_id"));     // Catch: JSONException -> L20
            k r108 = new k(r104, r105, r102);     // Catch: JSONException -> L20
            DownloadComponentManager.getInstance().submitCPUTask(new l(r106, r107, r108));     // Catch: JSONException -> L20
            return;
        L26:
            return;
        L25:
            return;
        L18:
            i r109 = this.f244991b;     // Catch: JSONException -> L20
            n.a(r109.f244989b, r109.f244988a, r102);     // Catch: JSONException -> L20
            return;
        L5:
            if (r100.optInt("status") != 1) goto L7;
            r101 = true;
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

        public a(i r100, String r101) {
            this.f244991b = r100;
            this.f244990a = r101;
        }
    }

    @Override // com.ss.android.download.api.config.IHttpCallback
    public final void onError(Throwable r100) {
    }

    @Override // com.ss.android.download.api.config.IHttpCallback
    public final void onResponse(String r100) {
        this.f244989b.f245010b.post(new a(this, r100));
    }

    public i(n r100, JSONObject r101) {
        this.f244989b = r100;
        this.f244988a = r101;
    }
}
