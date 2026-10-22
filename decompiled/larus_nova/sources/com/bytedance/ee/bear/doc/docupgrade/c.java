package com.bytedance.ee.bear.doc.docupgrade;

import com.bytedance.ee.bear.contract.j0;
import com.bytedance.ee.bear.list.dto.Document;
import io.reactivex.functions.Function;
import kotlin.Unit;

/* JADX INFO: loaded from: classes16.dex */
public final class c<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Document f217878a;

    public c(Document r100) {
        this.f217878a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        this.f217878a.f227903w = ((Boolean) r100).booleanValue();
        rc5.a r101 = (rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6);
        Document r102 = this.f217878a;
        r101.U(new j0(true, false, DocRedirectToDocxPlugin.DOC_TO_DOCX, false, r102, new b(r102)));
        return Unit.INSTANCE;
    }
}
