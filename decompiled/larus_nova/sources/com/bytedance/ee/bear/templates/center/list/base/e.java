package com.bytedance.ee.bear.templates.center.list.base;

import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TemplateV4 f239003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseTemplateListPresenter f239004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f239005c;

    public e(TemplateV4 r100, BaseTemplateListPresenter r101, String r102) {
        this.f239003a = r100;
        this.f239004b = r101;
        this.f239005c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        DocumentCreateInfo r101 = (DocumentCreateInfo) r100;
        Intrinsics.checkNotNullParameter(r101, "documentCreateInfo");
        tt5.a.h("BaseTemplateListPresenter", "createBlankDocument createOnlineDocument()...success, type = " + this.f239003a.getObjType());
        BaseTemplateListPresenter r102 = this.f239004b;
        BaseTemplateListPresenter.J8(r102, this.f239003a, r101.f216950d, BaseTemplateListPresenter.H8(r102, this.f239005c), r101);
    }
}
