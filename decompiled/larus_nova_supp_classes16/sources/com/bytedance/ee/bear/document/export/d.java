package com.bytedance.ee.bear.document.export;

import g15.k;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements ut5.a<Boolean> {
    public final /* synthetic */ Map a;
    public final /* synthetic */ int[] b;
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ e f;

    public final void onResult(Object r9) {
        e r1 = this.f;
        Map r2 = this.a;
        int[] r5 = this.b;
        int r6 = this.c;
        String r3 = this.d;
        Boolean r0 = Boolean.TRUE;
        e.b r4 = new e.b(r0.equals((Boolean) r9), true, false);
        r1.a.runOnUiThread(new k(r1, r2, r3, r4, r5, r6));
    }

    public final void onError(int r10, Throwable r11) {
        tt5.a.e("DocumentExportAction", "minutes action/state validate failed, optionId = " + this.d + ", token = " + du5.b.k(this.e), r11, false);
        e r3 = this.f;
        Map r4 = this.a;
        int[] r7 = this.b;
        int r8 = this.c;
        String r5 = this.d;
        r3.getClass();
        r3.a.runOnUiThread(new k(r3, r4, r5, new e.b(false, false, true), r7, r8));
    }

    public d(e r1, Map r2, int[] r3, int r4, String r5, String r6) {
        this.f = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
