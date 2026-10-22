package com.bytedance.bdturing.livedetect;

import android.text.TextUtils;
import com.bytedance.bdturing.EventReport;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
import qb4.c0;
import rb4.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class a$b implements a$c {
    public final /* synthetic */ long a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ com.bytedance.bdturing.livedetect.a d;

    public class a implements Runnable {
        public final /* synthetic */ a$c a;
        public final /* synthetic */ a$b b;

        @Override // java.lang.Runnable
        public final void run() {
            a$b r0 = this.b;     // Catch: Throwable -> L6
            com.bytedance.bdturing.livedetect.a r1 = r0.d;     // Catch: Throwable -> L6
            String r2 = r0.c;     // Catch: Throwable -> L6
            a$c r3 = this.a;     // Catch: Throwable -> L6
            r1.getClass();     // Catch: Throwable -> L6
            e r4 = e.a();     // Catch: Throwable -> L6
            b r5 = new b(r1, r2, r3);     // Catch: Throwable -> L6
            PThreadPoolExecutor r6 = r4.a;     // Catch: Throwable -> L6
            if (r6 == null) goto L9;
            r6.execute(r5);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(a$b r1, a$c r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    @Override // com.bytedance.bdturing.livedetect.a$c
    public final void G0(boolean r10, String r11) {
        long r0 = System.currentTimeMillis() - this.a;
        if (TextUtils.isEmpty(r11) == true) goto L5;
        String r2 = r11;
    L6:
        String r3 = this.b;
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L13
        r6.put("key", "load_model");     // Catch: Exception -> L13
        if (r10 == false) goto L10;
        int r8 = 0;
    L11:
        r6.put("result", r8);     // Catch: Exception -> L13
        r6.put("custom", r3);     // Catch: Exception -> L13
        r6.put("duration", r0);     // Catch: Exception -> L13
        r6.put("msg", r2);     // Catch: Exception -> L13
        EventReport.w("turing_verify_sdk", r6, null);     // Catch: Exception -> L13
    L15:
        if (r10 == true) goto L19;
        com.bytedance.bdturing.livedetect.a r1 = this.d;
        int r4 = r1.a;
        if (r4 >= 1) goto L19;
        r1.a = r4 + 1;
        c0.a.a.b(new a(this, this), 500);
        return;
    L19:
        com.bytedance.bdturing.livedetect.a r5 = this.d;
        r5.c = false;
        r5.a = 0;
        if (r10 == true) goto L22;
        r5.e++;
    L22:
        Iterator r7 = ((ArrayList) r5.d).iterator();
    L24:
        if (r7.hasNext() == false) goto L31;
        a$c r9 = (a$c) r7.next();
        if (r9 == null) goto L24;
        r9.G0(r10, r11);     // Catch: Exception -> L29
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L24
    L31:
        ((ArrayList) r5.d).clear();
        return;
    L10:
        r8 = 1;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        r2 = "";
        goto L6
    }

    public a$b(com.bytedance.bdturing.livedetect.a r1, long r2, String r4, String r5) {
        this.d = r1;
        this.a = r2;
        this.b = r4;
        this.c = r5;
    }
}
