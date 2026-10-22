package iq5;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v<T> implements Consumer {
    public final /* synthetic */ com.bytedance.ee.bear.wikiv2.selector.w a;

    public v(com.bytedance.ee.bear.wikiv2.selector.w r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        tt5.a.h("RootSelectView", "isVisible, fetch MyLibrary ID: " + ((String) r3));
        this.a.k();
    }
}
