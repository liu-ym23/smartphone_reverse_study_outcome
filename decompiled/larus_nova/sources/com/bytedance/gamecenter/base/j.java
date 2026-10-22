package com.bytedance.gamecenter.base;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.download.api.config.IHttpCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class j implements IHttpCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f244992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f244993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f244994c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f244995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f244996b;

        @Override // java.lang.Runnable
        public final void run() {
            j r100 = this.f244996b;     // Catch: Throwable -> L4 JSONException -> L6
            n.b(r100.f244994c, r100.f244992a, new JSONObject(this.f244995a), this.f244996b.f244993b);     // Catch: Throwable -> L4 JSONException -> L6
        L13:
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L6:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L4
            goto L13
        }

        public a(j r100, String r101) {
            this.f244996b = r100;
            this.f244995a = r101;
        }
    }

    @Override // com.ss.android.download.api.config.IHttpCallback
    public final void onError(Throwable r100) {
    }

    @Override // com.ss.android.download.api.config.IHttpCallback
    public final void onResponse(String r100) {
        this.f244994c.f245010b.post(new a(this, r100));
    }

    public j(n r100, JSONObject r101, JSONObject r102) {
        this.f244994c = r100;
        this.f244992a = r101;
        this.f244993b = r102;
    }
}
