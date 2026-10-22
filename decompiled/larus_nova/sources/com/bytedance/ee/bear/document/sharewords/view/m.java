package com.bytedance.ee.bear.document.sharewords.view;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m<T> f221853a = null;

    static {
        f221853a = new m();
    }

    public m() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.d("ShareWordsForwardComponent", "commentFlowable error " + ((Throwable) r100).getMessage());
        Toast.cancelLoading();
    }
}
