package com.bytedance.ee.bear.templates.center.list.base;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import dd5.s1;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ TemplateV4 a;
    public final /* synthetic */ BaseTemplateListPresenter b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public c(TemplateV4 r1, BaseTemplateListPresenter r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r12) {
        OfflineDoc r13 = (OfflineDoc) r12;
        Intrinsics.checkNotNullParameter(r13, "offlineDoc");
        tt5.a.h("BaseTemplateListPresenter", "createBlankDocument createOfflineDocumentFlow()...success, type = " + this.a.getObjType());
        if (TextUtils.isEmpty(r13.getFakeToken()) == true) goto L5;
        String r0 = s45.p.a().ua(sbb.e.f(this.a.getObjType()), r13.getFakeToken(), "tab_create");
        BaseTemplateListPresenter r1 = this.b;
        TemplateV4 r2 = this.a;
        String r3 = BaseTemplateListPresenter.H8(r1, this.c);
        DocumentCreateInfo r4 = new DocumentCreateInfo();
        r4.a = r13.getFakeToken();
        r4.b = r13.getObj_token();
        r4.c = "";
        r4.d = r13.getUrl();
        r4.e = "";
        r4.g = r13.getOwner_type();
        r4.f = r13.getType();
        r4.i = r13.getIs_wiki();
        Unit r5 = Unit.INSTANCE;
        BaseTemplateListPresenter.J8(r1, r2, r0, r3, r4);
        s1.a.a.d(r13);
        jw4.a.e((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), new jw4.c(sbb.e.f(this.a.getObjType()), r13.getFakeToken(), this.d, this.c));
        return;
    L5:
        BaseTemplateListPresenter.I8(this.b, this.a, this.d, this.c, new Throwable(), false);
    }
}
