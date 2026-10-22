package com.bytedance.ee.bear.list.create;

import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.x3;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class k0 implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ m b;

    public /* synthetic */ k0(m r2) {
        this.a = "action_docx_create";
        this.b = r2;
    }

    public final void accept(Object r8) {
        String r0 = this.a;
        final m r6 = this.b;
        final CreateSelectResult r5 = (CreateSelectResult) r8;
        Toast.cancelLoading();
        sbb.e r9 = sbb.e.g;
        int r1 = r9.b;
        if ("action_doc_create".equals(r0) == false) goto L6;
        int r2 = r9.b;
    L23:
        final int r3 = r2;
    L25:
        final com.bytedance.ee.bear.route.h r4 = (com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class);
        if (r5.b != null) goto L29;
        q0.h();
        return;
    L29:
        if (r5.d() == false) goto L52;
        boolean r7 = false;
        if (r3 != sbb.e.o.b) goto L33;
        boolean r10 = true;
    L34:
        if (r10 == true) goto L36;
    L48:
        tt5.a.h("DocumentCreator", "handleCreateWikiDocument: createOffline:" + r7 + ",docxEnable:" + r10 + ",createOffline:" + r7 + ",createSelectResult:" + r5);
        if (r7 == false) goto L51;
        com.bytedance.ee.bear.route.h r11 = (com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class);
        x3.c().b(r5.c, r3, r6.a.d).observeOn(fo5.d.d()).subscribe(new o0(r3, r5, r6), new p0());
        return;
    L51:
        q0.g(r6, r3, true, null, r5);
        return;
    L36:
        if (r5.d == false) goto L48;
        if (r5.d() == true) goto L41;
    L42:
        boolean r12 = true;
    L44:
        if (r12 == false) goto L48;
        if (r5.c() == true) goto L48;
        r7 = true;
        goto L48
    L41:
        if (r3 != r9.b) goto L42;
        r12 = false;
        goto L44
    L33:
        r10 = false;
        goto L34
    L52:
        final int r13 = r3;
        x3.c().a(r5.c, r3, r6.a.d).observeOn(fo5.d.d()).subscribe(new m0(r13, r3, r4, r5, r6), new n0());
        return;
    L6:
        if ("action_sheet_create".equals(r0) == false) goto L9;
        r2 = sbb.e.h.b;
        goto L23
    L9:
        if ("action_bitable_create".equals(r0) == false) goto L12;
        r2 = sbb.e.i.b;
        goto L23
    L12:
        if ("action_docx_create".equals(r0) == false) goto L15;
        r2 = sbb.e.o.b;
        goto L23
    L15:
        if ("action_mindnote_create".equals(r0) == false) goto L18;
        r2 = sbb.e.k.b;
        goto L23
    L18:
        if ("action_docx_open".equals(r0) == false) goto L21;
        r2 = sbb.e.o.b;
        goto L23
    L21:
        if ("action_bitable_open".equals(r0) == false) goto L24;
        r2 = sbb.e.i.b;
        goto L23
    L24:
        r3 = r1;
        goto L25
    }
}
