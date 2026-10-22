package com.bytedance.ee.bear.clip.handlers;

import at5.j;
import com.bytedance.ee.larkwebview.bridge.Status;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ ClipFetchHandler.FetchData a;
    public final /* synthetic */ j b;

    public b(ClipFetchHandler.FetchData r1, at5.d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r10) {
        Throwable r11 = (Throwable) r10;
        StringBuilder r0 = new StringBuilder("fetch error for url: ");
        String r1 = this.a.getUrl();
        if (r1 != null) goto L5;
        r1 = null;
    L5:
        r0.append(du5.b.f(r1));
        tt5.a.e("DocsClip#ClipFetchHandler", r0.toString(), r11, false);
        this.b.a(Status.SUCCESS, new ClipFetchHandler.FetchResult(-3, "unkown error", "{}", null, 8, null));
    }
}
