package com.bytedance.ee.bear.templates.center.list.base;

import com.bytedance.ee.bear.templates.data.TemplateV4;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ BaseTemplateListPresenter a;
    public final /* synthetic */ TemplateV4 b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public d(BaseTemplateListPresenter r1, TemplateV4 r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r7) {
        Throwable r4 = (Throwable) r7;
        Intrinsics.checkNotNullParameter(r4, "throwable");
        tt5.a.d("BaseTemplateListPresenter", "createBlankDocument createOfflineDocumentFlow()...failed, throwable = " + r4);
        BaseTemplateListPresenter.I8(this.a, this.b, this.c, this.d, r4, false);
    }
}
