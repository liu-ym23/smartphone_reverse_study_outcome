package ql5;

import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e0 {
    public String a;
    public String b;

    public e0() {
    }

    public final void a(String r4) {
        HashMap r0 = new HashMap();
        r0.put("file_id", this.a);
        r0.put("file_type", this.b);
        r0.put("module", this.b);
        r0.put("action", r4);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("client_reminder_operation", r0);
    }
}
