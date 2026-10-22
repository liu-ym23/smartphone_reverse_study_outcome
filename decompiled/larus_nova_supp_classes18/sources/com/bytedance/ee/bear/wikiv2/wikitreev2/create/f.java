package com.bytedance.ee.bear.wikiv2.wikitreev2.create;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ WikiCreateToFragment a;

    public f(WikiCreateToFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        tt5.a.e("Wiki_WikiCreateToFragment", "checkUploadPerm err. ", r5, false);
        Context r0 = this.a.getContext();
        Map<String, Integer> r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.a;
        Toast.showFailureText(r0, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q.d(WikiAction.ADD, r5));
    }
}
