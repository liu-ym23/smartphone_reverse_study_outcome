package com.bytedance.ee.bear.document.sharewords.view;

import com.bytedance.ee.bear.facade.common.widget.Toast;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m<T> implements Consumer {
    public static final m<T> a = null;

    static {
        a = new m();
    }

    public m() {
    }

    public final void accept(Object r3) {
        tt5.a.d("ShareWordsForwardComponent", "commentFlowable error " + ((Throwable) r3).getMessage());
        Toast.cancelLoading();
    }
}
