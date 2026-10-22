package com.vivo.push;

import android.content.Intent;
import com.vivo.push.h.ai;

/* JADX INFO: loaded from: classes41.dex */
public final class l implements IPushClientFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ai f462394a;

    public l() {
        this.f462394a = new ai();
    }

    @Override // com.vivo.push.IPushClientFactory
    public final com.vivo.push.h.ab createReceiveTask(v r100) {
        return ai.b(r100);
    }

    @Override // com.vivo.push.IPushClientFactory
    public final v createReceiverCommand(Intent r100) {
        int r101 = r100.getIntExtra("command", -1);
        if (r101 >= 0) goto L6;
        r101 = r100.getIntExtra(com.alipay.sdk.m.p.e.f25671s, -1);
    L6:
        if (r101 != 20) goto L8;
        v r102 = new com.vivo.push.b.v();
    L27:
        if (r102 == null) goto L32;
        d r103 = d.a(r100);
        if (r103 != null) goto L31;
        com.vivo.push.util.t.b("PushCommand", "bundleWapper is null");
        goto L32
    L31:
        r102.b(r103);
    L32:
        return r102;
    L8:
        if (r101 != 2016) goto L10;
        r102 = new com.vivo.push.b.l();
        goto L27
    L10:
        if (r101 == 2023) goto L24;
        switch(r101) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L15;
            case 10: goto L14;
            case 11: goto L14;
            case 12: goto L13;
            default: goto L12;
        };
    L12:
        r102 = null;
        goto L27
    L13:
        r102 = new com.vivo.push.b.j();
        goto L27
    L14:
        v r104 = new com.vivo.push.b.i(r101);
    L23:
        r102 = r104;
        goto L27
    L15:
        r102 = new com.vivo.push.b.k();
        goto L27
    L16:
        r102 = new com.vivo.push.b.m();
        goto L27
    L17:
        r102 = new com.vivo.push.b.n();
        goto L27
    L18:
        r102 = new com.vivo.push.b.s();
        goto L27
    L19:
        r102 = new com.vivo.push.b.p();
        goto L27
    L20:
        r102 = new com.vivo.push.b.q();
        goto L27
    L21:
        r102 = new com.vivo.push.b.o();
        goto L27
    L22:
        r104 = new com.vivo.push.b.u(r101);
        goto L23
    L24:
        r102 = new com.vivo.push.b.r();
        goto L27
    }

    @Override // com.vivo.push.IPushClientFactory
    public final s createTask(v r100) {
        return ai.a(r100);
    }
}
