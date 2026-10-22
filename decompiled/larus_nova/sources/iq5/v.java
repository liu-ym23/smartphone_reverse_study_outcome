package iq5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class v<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.wikiv2.selector.w f495380a;

    public v(com.bytedance.ee.bear.wikiv2.selector.w r100) {
        this.f495380a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.h("RootSelectView", "isVisible, fetch MyLibrary ID: " + ((String) r100));
        this.f495380a.k();
    }
}
