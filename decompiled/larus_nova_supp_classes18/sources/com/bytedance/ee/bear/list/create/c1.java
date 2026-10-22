package com.bytedance.ee.bear.list.create;

import android.text.TextUtils;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c1 implements Function<DocumentCreateEntity, DocumentCreateEntity> {
    public c1() {
    }

    public final Object apply(Object r4) throws Exception {
        final DocumentCreateEntity r5 = (DocumentCreateEntity) r4;
        if (TextUtils.isEmpty(r5.getObjToken()) == false) goto L5;
        tt5.a.h("UpdateOwnerTypeFun", "objToken is empty.");
    L6:
        return r5;
    L5:
        md5.e.a(r5.getObjToken(), r5.getType()).observeOn(fo5.d.b()).subscribe(new a1(this, r5), new b1());
        goto L6
    }
}
