package com.bytedance.bdturing.livedetect;

import android.util.Pair;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import ec4.h;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ a$c b;
    public final /* synthetic */ a c;

    public final void a() {
        String r2 = "";
        boolean r3 = false;
        SsResponse r4 = h.b(this.a).doGet(false, this.a, null, null).execute();     // Catch: Throwable -> L18 Exception -> L20
        if (r4 != null) goto L6;
    L29:
        r2 = "net_work_error";
    L30:
        a$c r0 = this.b;
        if (r0 == null) goto L43;
        r0.G0(r3, r2);
        return;
    L43:
        return;
    L6:
        if (r4.code() != 200) goto L29;
        a.b(this.c);     // Catch: Throwable -> L18 Exception -> L20
        InputStream r5 = ((TypedInput) r4.body()).in();     // Catch: Throwable -> L18 Exception -> L20
        long r6 = ((TypedInput) r4.body()).length();     // Catch: Throwable -> L18 Exception -> L20
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L18 Exception -> L20
        r7.append(this.c.b);     // Catch: Throwable -> L18 Exception -> L20
        String r8 = File.separator;     // Catch: Throwable -> L18 Exception -> L20
        r7.append(r8);     // Catch: Throwable -> L18 Exception -> L20
        r7.append("bytenn_models.zip");     // Catch: Throwable -> L18 Exception -> L20
        String r9 = r7.toString();     // Catch: Throwable -> L18 Exception -> L20
        File r10 = hc4.c.c(r5, r9);     // Catch: Throwable -> L18 Exception -> L20
        if (r10 != null) goto L10;
    L28:
        r2 = "model_file_load_error";
        goto L30
    L10:
        if (r10.exists() == false) goto L28;
        if (r10.length() != r6) goto L28;
        String r11 = this.c.b + r8 + "temp";     // Catch: Throwable -> L18 Exception -> L20
        if (hc4.c.d(r10.getAbsolutePath(), r11) == false) goto L27;
        PolarisFileWrapper r12 = new PolarisFileWrapper(r11);     // Catch: Throwable -> L18 Exception -> L20
        if (r12.exists() == false) goto L22;
        Pair r13 = hc4.c.h(r12, new PolarisFileWrapper(this.c.b));     // Catch: Throwable -> L18 Exception -> L20
        String r1 = "trans file success:" + r13.first + ",trans_file_msg:" + ((String) r13.second);     // Catch: Throwable -> L18 Exception -> L20
        hc4.c.e(r11);     // Catch: Throwable -> L18 Exception -> L20
        hc4.c.e(r9);     // Catch: Throwable -> L18 Exception -> L20
    L23:
        Pair r14 = a.c(this.c);     // Catch: Throwable -> L18 Exception -> L20
        int r15 = ((Integer) r14.first).intValue();     // Catch: Throwable -> L18 Exception -> L20
        String r16 = (String) r14.second;     // Catch: Throwable -> L18 Exception -> L20
        if (r15 != 0) goto L26;
        r3 = true;
        goto L30
    L26:
        r2 = "model_checkModelSum_error:ret=" + r15 + ";msg=" + r16 + ";file_trans_msg=" + r1;     // Catch: Throwable -> L18 Exception -> L20
        a.b(this.c);     // Catch: Throwable -> L18 Exception -> L20
        goto L30
    L22:
        r1 = "";
        goto L23
    L27:
        a.b(this.c);     // Catch: Throwable -> L18 Exception -> L20
        r2 = "model_decompress_error";
    L18:
        th = move-exception;
        a$c r17 = this.b;
        if (r17 == null) goto L41;
        r17.G0(false, "");
    L41:
        throw th;
    L20:
        e = move-exception;
        String r18 = e.getMessage();     // Catch: Throwable -> L18
        a$c r19 = this.b;
        if (r19 == null) goto L45;
        r19.G0(false, r18);
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

    public b(a r1, String r2, a$c r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
