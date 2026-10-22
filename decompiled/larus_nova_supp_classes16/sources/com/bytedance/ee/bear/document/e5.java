package com.bytedance.ee.bear.document;

import com.bytedance.ee.bear.document.security.DeleteImageData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e5<T> implements Consumer {
    public final /* synthetic */ DeleteImageData a;

    public e5(DeleteImageData r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        String r4 = (String) r3;
        k25.e0 r5 = k25.e0.m();
        String r0 = this.a.getToken();
        String r1 = this.a.getFileToken();
        r5.getClass();
        ((j25.p) r5.q().d()).a(r0, r1);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        iu5.d.c(e);
    }
}
