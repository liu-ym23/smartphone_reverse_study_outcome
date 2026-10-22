package com.bytedance.bdturing.identityverify;

import android.text.TextUtils;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.nio.charset.Charset;
import java.util.HashMap;
import jc4.f;
import kotlin.text.Charsets;
import org.json.JSONObject;
import qb4.b;
import qb4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class IdentityVerifyService$e implements Runnable {
    public final /* synthetic */ f a;
    public final /* synthetic */ JSONObject b;

    public final void a() {
        String r0 = this.a.f();     // Catch: Exception -> L25
        if (TextUtils.isEmpty(r0) == true) goto L32;
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L25
        BdTuringConfig r2 = b.c.a.a;     // Catch: Exception -> L25
        JSONObject r3 = null;
        if (r2 == null) goto L8;
        String r4 = r2.getAppId();     // Catch: Exception -> L25
    L9:
        long r5 = 0;
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L25
    L16:
        r1.put("aid", r5);     // Catch: Exception -> L25
        r1.put("scene", this.a.o);     // Catch: Exception -> L25
        r1.put("detail", this.a.r);     // Catch: Exception -> L25
        JSONObject r6 = this.b;     // Catch: Exception -> L25
        if (r6 == null) goto L20;
        r3 = r6.optJSONObject("ext_data");     // Catch: Exception -> L25
    L20:
        if (r3 == null) goto L22;
        String r7 = r3.optString("ticket");     // Catch: Exception -> L25
    L23:
        r1.put("ticket", r7);     // Catch: Exception -> L25
        String r8 = r1.toString();     // Catch: Exception -> L25
        Charset r9 = Charsets.UTF_8;     // Catch: Exception -> L25
        byte[] r10 = r8.getBytes(r9);     // Catch: Exception -> L25
        ec4.b r11 = b.c.a.a.getHttpClient();     // Catch: Exception -> L25
        HashMap r12 = new HashMap();     // Catch: Exception -> L25
        r12.put("Content-Type", "application/json; charset=utf-8");     // Catch: Exception -> L25
        new JSONObject(new String(r11.post(r0, r12, r10), r9)).optInt("err_code", -1);     // Catch: Exception -> L25
        int r13 = n.a;     // Catch: Exception -> L25
        return;
    L22:
        r7 = "";
        goto L23
    L11:
        if (TextUtils.isEmpty(r4) == true) goto L16;
        r5 = CastLongProtector.parseLong(r4);     // Catch: Exception -> L14
    L8:
        r4 = null;
        goto L9
    L32:
        return;
    L25:
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

    public IdentityVerifyService$e(f r1, JSONObject r2) {
        this.a = r1;
        this.b = r2;
    }
}
