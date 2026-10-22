package com.bytedance.bdturing.livedetect;

import xb4.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class LiveDetectService$c implements ec4.c {
    public final /* synthetic */ xb4.b a;

    public LiveDetectService$c(xb4.b r1) {
        this.a = r1;
    }

    @Override // ec4.c
    public final void a(a r7) {
        xb4.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(r7.a, r7.b, new String[]{r7.c, r7.d});
        return;
    }

    @Override // ec4.c
    public final void onError(Throwable r2) {
        xb4.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onError(r2);
        return;
    }
}
