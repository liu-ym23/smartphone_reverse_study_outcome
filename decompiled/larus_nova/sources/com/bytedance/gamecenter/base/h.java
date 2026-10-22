package com.bytedance.gamecenter.base;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.download.api.config.IHttpCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements IHttpCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f244984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f244985b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f244986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f244987b;

        public final void a() {
            JSONObject r100 = new JSONObject(this.f244986a);     // Catch: JSONException -> L15
            this.f244987b.f244985b.getClass();     // Catch: JSONException -> L15
            if (r100.optInt("code", -1) == 0) goto L5;
        L7:
            boolean r101 = false;
        L8:
            JSONObject r102 = r100.optJSONObject("enable_feature");     // Catch: JSONException -> L15
            if (r101 == false) goto L13;
            if (r101 != true) goto L19;
            this.f244987b.f244984a.c(r102);     // Catch: JSONException -> L15
            return;
        L19:
            return;
        L13:
            this.f244987b.f244984a.d(r102);     // Catch: JSONException -> L15
            return;
        L5:
            if (r100.optInt("status") != 1) goto L7;
            r101 = true;
        L15:
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

        public a(h r100, String r101) {
            this.f244987b = r100;
            this.f244986a = r101;
        }
    }

    @Override // com.ss.android.download.api.config.IHttpCallback
    public final void onError(Throwable r100) {
    }

    @Override // com.ss.android.download.api.config.IHttpCallback
    public final void onResponse(String r100) {
        this.f244985b.f245010b.post(new a(this, r100));
    }

    public h(n r100, p r101) {
        this.f244985b = r100;
        this.f244984a = r101;
    }
}
