package com.bytedance.bdturing.livedetect;

import android.util.Pair;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import ec4.h;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f201904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a.c f201905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f201906c;

    public final void a() {
        String r100 = "";
        boolean r101 = false;
        SsResponse<TypedInput> r102 = h.b(this.f201904a).doGet(false, this.f201904a, null, null).execute();     // Catch: Throwable -> L18 Exception -> L20
        if (r102 != null) goto L6;
    L29:
        r100 = "net_work_error";
    L30:
        a.c r103 = this.f201905b;
        if (r103 == null) goto L43;
        r103.G0(r101, r100);
        return;
    L43:
        return;
    L6:
        if (r102.code() != 200) goto L29;
        a.b(this.f201906c);     // Catch: Throwable -> L18 Exception -> L20
        InputStream r104 = r102.body().in();     // Catch: Throwable -> L18 Exception -> L20
        long r105 = r102.body().length();     // Catch: Throwable -> L18 Exception -> L20
        StringBuilder r106 = new StringBuilder();     // Catch: Throwable -> L18 Exception -> L20
        r106.append(this.f201906c.f201893b);     // Catch: Throwable -> L18 Exception -> L20
        String r107 = File.separator;     // Catch: Throwable -> L18 Exception -> L20
        r106.append(r107);     // Catch: Throwable -> L18 Exception -> L20
        r106.append("bytenn_models.zip");     // Catch: Throwable -> L18 Exception -> L20
        String r108 = r106.toString();     // Catch: Throwable -> L18 Exception -> L20
        File r109 = hc4.c.c(r104, r108);     // Catch: Throwable -> L18 Exception -> L20
        if (r109 != null) goto L10;
    L28:
        r100 = "model_file_load_error";
        goto L30
    L10:
        if (r109.exists() == false) goto L28;
        if (r109.length() != r105) goto L28;
        String r110 = this.f201906c.f201893b + r107 + "temp";     // Catch: Throwable -> L18 Exception -> L20
        if (hc4.c.d(r109.getAbsolutePath(), r110) == false) goto L27;
        PolarisFileWrapper r111 = new PolarisFileWrapper(r110);     // Catch: Throwable -> L18 Exception -> L20
        if (r111.exists() == false) goto L22;
        Pair r112 = hc4.c.h(r111, new PolarisFileWrapper(this.f201906c.f201893b));     // Catch: Throwable -> L18 Exception -> L20
        String r113 = "trans file success:" + r112.first + ",trans_file_msg:" + ((String) r112.second);     // Catch: Throwable -> L18 Exception -> L20
        hc4.c.e(r110);     // Catch: Throwable -> L18 Exception -> L20
        hc4.c.e(r108);     // Catch: Throwable -> L18 Exception -> L20
    L23:
        Pair r114 = a.c(this.f201906c);     // Catch: Throwable -> L18 Exception -> L20
        int r115 = ((Integer) r114.first).intValue();     // Catch: Throwable -> L18 Exception -> L20
        String r116 = (String) r114.second;     // Catch: Throwable -> L18 Exception -> L20
        if (r115 != 0) goto L26;
        r101 = true;
        goto L30
    L26:
        r100 = "model_checkModelSum_error:ret=" + r115 + ";msg=" + r116 + ";file_trans_msg=" + r113;     // Catch: Throwable -> L18 Exception -> L20
        a.b(this.f201906c);     // Catch: Throwable -> L18 Exception -> L20
        goto L30
    L22:
        r113 = "";
        goto L23
    L27:
        a.b(this.f201906c);     // Catch: Throwable -> L18 Exception -> L20
        r100 = "model_decompress_error";
    L18:
        th = move-exception;
        a.c r117 = this.f201905b;
        if (r117 == null) goto L41;
        r117.G0(false, "");
    L41:
        throw th;
    L20:
        e = move-exception;
        String r118 = e.getMessage();     // Catch: Throwable -> L18
        a.c r119 = this.f201905b;
        if (r119 == null) goto L45;
        r119.G0(false, r118);
        return;
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

    public b(a r100, String r101, a.c r102) {
        this.f201906c = r100;
        this.f201904a = r101;
        this.f201905b = r102;
    }
}
