package g15;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ com.bytedance.ee.bear.document.export.e a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ String c;
    public final /* synthetic */ com.bytedance.ee.bear.document.export.e.b d;
    public final /* synthetic */ int[] e;
    public final /* synthetic */ int f;

    public /* synthetic */ k(com.bytedance.ee.bear.document.export.e r1, Map r2, String r3, com.bytedance.ee.bear.document.export.e.b r4, int[] r5, int r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.ee.bear.document.export.e r0 = this.a;
        Map<String, com.bytedance.ee.bear.document.export.e.b> r1 = this.b;
        String r2 = this.c;
        com.bytedance.ee.bear.document.export.e.b r3 = this.d;
        int[] r4 = this.e;
        int r5 = this.f;
        r0.getClass();
        r1.put(r2, r3);
        int r6 = r4[0] + 1;
        r4[0] = r6;
        if (r6 < r5) goto L7;
        r0.v(r1);
        return;
    }
}
