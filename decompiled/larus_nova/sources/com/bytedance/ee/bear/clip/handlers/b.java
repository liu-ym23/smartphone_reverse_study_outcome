package com.bytedance.ee.bear.clip.handlers;

import at5.j;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ee.larkwebview.bridge.Status;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClipFetchHandler.FetchData f216689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f216690b;

    public b(ClipFetchHandler.FetchData r100, at5.d r101) {
        this.f216689a = r100;
        this.f216690b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Throwable r111 = (Throwable) r110;
        StringBuilder r100 = new StringBuilder("fetch error for url: ");
        String r101 = this.f216689a.getUrl();
        if (r101 != null) goto L5;
        r101 = null;
    L5:
        r100.append(du5.b.f(r101));
        tt5.a.e("DocsClip#ClipFetchHandler", r100.toString(), r111, false);
        this.f216690b.a(Status.SUCCESS, new ClipFetchHandler.FetchResult(-3, "unkown error", SliceInitService.DEFAULT_SWITCH, null, 8, null));
    }
}
