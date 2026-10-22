package com.bytedance.ee.bear.templates.center.list.base;

import android.content.Context;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.create.q0;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ BaseTemplateListPresenter a;
    public final /* synthetic */ TemplateV4 b;

    public a(BaseTemplateListPresenter r1, TemplateV4 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r18) {
        CreateSelectResult r1 = (CreateSelectResult) r18;
        if (r1.b == null) goto L27;
        BaseTemplateListPresenter r4 = this.a;
        TemplateV4 r2 = this.b;
        CreateSelectResult r3 = r4.O8().getCreateSelectResult();
        String r5 = r1.c;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r3.c = r5;
        String r6 = r1.e;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r3.e = r6;
        r3.f = r1.f;
        r3.b = r1.b;
        boolean r15 = r1.d();
        tt5.a.h("BaseTemplateListPresenter", "createBlankDocument: isCreateInWiki:" + r15 + " parentToken: " + du5.b.i(r1.c) + " spaceId:" + r1.e);
        if (com.bytedance.ee.bear.list.create.a.a(r2.getObjType()) == false) goto L20;
        if (r1.d == false) goto L20;
        int r7 = r2.getObjType();
        if (r15 == true) goto L12;
    L14:
        boolean r8 = true;
    L15:
        if (r8 == false) goto L20;
        if (r1.c() == true) goto L20;
        String r9 = r4.O8().getCreateSelectResult().c;
        String r10 = r4.O8().getModule();
        r4.P8().k0();
        r4.e.add(q0.a(r2.getObjType(), r9, r4.O8().isSpaceV2(), r15).observeOn(fo5.d.d()).subscribe(new c(r2, r4, r10, r9), new d(r4, r2, r9, r10)));
        TemplateReportV2 r11 = TemplateReportV2.a;
        TemplateReportV2.d(r2, null);
        return;
    L12:
        if (r7 != sbb.e.g.b) goto L14;
        r8 = false;
    L20:
        if (r4.T8(r2) == false) goto L34;
        String r12 = r4.O8().getCreateSelectResult().c;
        String r13 = r4.O8().getModule();
        if ((true ^ StringsKt.isBlank(r4.O8().getSpaceId())) == false) goto L25;
        String r14 = r4.O8().getSpaceId();
    L26:
        String r16 = r14;
        tt5.a.h("BaseTemplateListPresenter", "createOnlineDocument: parentToken:" + du5.b.i(r12) + " spaceId:" + r16 + " module:" + r13 + ' ');
        r4.P8().k0();
        r4.e.add(q0.b(r2.getObjType(), r12, r13, r4.O8().isSpaceV2(), r15, r16, 0, null, null).observeOn(fo5.d.d()).subscribe(new e(r2, r4, r13), new f(r4, r2, r12, r13, r15)));
        TemplateReportV2 r17 = TemplateReportV2.a;
        TemplateReportV2.d(r2, null);
        return;
    L25:
        r14 = r4.O8().getCreateSelectResult().e;
        goto L26
    L34:
        return;
    L27:
        BaseTemplateListPresenter r19 = this.a;
        r19.P8().c0();
        Context r20 = r19.M8().getContext();
        if (r20 == null) goto L33;
        Toast.showFailureText(r20, r20.getString(2131887996));
        return;
    }
}
