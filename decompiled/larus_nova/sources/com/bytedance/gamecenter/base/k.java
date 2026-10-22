package com.bytedance.gamecenter.base;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.download.api.config.IHttpCallback;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class k implements IHttpCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f244997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f244998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f244999c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f245000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f245001b;

        public final void a() {
            k r100 = this.f245001b;     // Catch: JSONException -> L8
            n r101 = r100.f244999c;     // Catch: JSONException -> L8
            JSONObject r102 = r100.f244997a;     // Catch: JSONException -> L8
            JSONObject r103 = new JSONObject(this.f245000a);     // Catch: JSONException -> L8
            JSONObject r104 = this.f245001b.f244998b;     // Catch: JSONException -> L8
            Map<String, p> r105 = r101.f245009a;     // Catch: JSONException -> L8
            HashMap r106 = (HashMap) r105;     // Catch: JSONException -> L8
            p r107 = (p) r106.get(r102.optString("order_id"));     // Catch: JSONException -> L8
            if (r107 != null) goto L5;
            return;
        L5:
            if (r103.optInt("code") != 0) goto L14;
            r107.d(r104);     // Catch: JSONException -> L8
            return;
        L14:
            return;
        L8:
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

        public a(k r100, String r101) {
            this.f245001b = r100;
            this.f245000a = r101;
        }
    }

    @Override // com.ss.android.download.api.config.IHttpCallback
    public final void onError(Throwable r100) {
    }

    @Override // com.ss.android.download.api.config.IHttpCallback
    public final void onResponse(String r100) {
        this.f244999c.f245010b.post(new a(this, r100));
    }

    public k(n r100, JSONObject r101, JSONObject r102) {
        this.f244999c = r100;
        this.f244997a = r101;
        this.f244998b = r102;
    }
}
