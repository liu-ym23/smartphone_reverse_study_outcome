package com.bytedance.ee.bear.tts.media;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ b a;

    public g(b r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        long r0 = ((Number) r4).longValue();
        b r5 = this.a;
        if (r5.l == false) goto L9;
        r5.l = false;
        TtsMediaService.f r6 = r5.k;
        if (r6 == null) goto L11;
        TtsMediaService r7 = r6.b;
        a r2 = r7.g;
        if (r2 == null) goto L12;
        r2.h = r0;
        r7.e();
        return;
    L12:
        return;
    L11:
        return;
    L9:
        r5.l = true;
    }
}
