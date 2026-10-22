package com.bytedance.ee.bear.doc.docupgrade;

import com.bytedance.ee.bear.contract.j0;
import com.bytedance.ee.bear.list.dto.Document;
import io.reactivex.functions.Function;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c<T, R> implements Function {
    public final /* synthetic */ Document a;

    public c(Document r1) {
        this.a = r1;
    }

    public final Object apply(Object r9) {
        this.a.w = ((Boolean) r9).booleanValue();
        rc5.a r10 = (rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6);
        Document r5 = this.a;
        r10.U(new j0(true, false, DocRedirectToDocxPlugin.DOC_TO_DOCX, false, r5, new b(r5)));
        return Unit.INSTANCE;
    }
}
