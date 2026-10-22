package com.bytedance.forest;

import com.bytedance.forest.model.Response;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f244158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f244159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Response f244160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.forest.utils.e f244161d;

    public c(String r100, String r101, Response r102, com.bytedance.forest.utils.e r103) {
        this.f244158a = r100;
        this.f244159b = r101;
        this.f244160c = r102;
        this.f244161d = r103;
    }

    public final void a() {
        JSONObject r100 = new JSONObject();
        r100.put("channel", this.f244158a);
        r100.put("bundle", this.f244159b);
        r100.put("loader", "Forest");
        r100.put("mode", 2);
        List<fx5.a> r101 = f.f244205a;
        f.a(this.f244160c, "res_gecko_loader_secure", r100, new JSONObject(), new JSONObject(), 0, this.f244161d);
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
}
