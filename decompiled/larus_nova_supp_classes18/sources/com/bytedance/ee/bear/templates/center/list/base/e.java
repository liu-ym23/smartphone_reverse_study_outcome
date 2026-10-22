package com.bytedance.ee.bear.templates.center.list.base;

import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ TemplateV4 a;
    public final /* synthetic */ BaseTemplateListPresenter b;
    public final /* synthetic */ String c;

    public e(TemplateV4 r1, BaseTemplateListPresenter r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r5) {
        DocumentCreateInfo r6 = (DocumentCreateInfo) r5;
        Intrinsics.checkNotNullParameter(r6, "documentCreateInfo");
        tt5.a.h("BaseTemplateListPresenter", "createBlankDocument createOnlineDocument()...success, type = " + this.a.getObjType());
        BaseTemplateListPresenter r0 = this.b;
        BaseTemplateListPresenter.J8(r0, this.a, r6.d, BaseTemplateListPresenter.H8(r0, this.c), r6);
    }
}
