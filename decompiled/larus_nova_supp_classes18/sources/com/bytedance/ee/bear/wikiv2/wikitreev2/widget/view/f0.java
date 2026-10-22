package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog.WikiDeleteConfirmDialog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f0 implements WikiDeleteConfirmDialog.b {
    public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j a;
    public final /* synthetic */ c0 b;

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog.WikiDeleteConfirmDialog.b
    public final void a() {
        Boolean r3 = Boolean.valueOf(this.a.d());
        String r4 = this.b.d;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r0 = this.a;
        String r5 = r0.b;
        Boolean r6 = Boolean.valueOf(r0.e());
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r1 = this.a;
        gq5.d.h(new gq5.d.b("delete", "none", r3, r4, r5, r6, r1.c, sbb.e.c(r1.d), "single_page", Boolean.valueOf(this.a.c())));
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r2 = this.b.e;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r7 = this.a;
        r2.deleteCurrentOnly(r7.a, r7.b);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog.WikiDeleteConfirmDialog.b
    public final void b() {
        Boolean r3 = Boolean.valueOf(this.a.d());
        String r4 = this.b.d;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r0 = this.a;
        String r5 = r0.b;
        Boolean r6 = Boolean.valueOf(r0.e());
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r1 = this.a;
        gq5.d.h(new gq5.d.b("delete", "none", r3, r4, r5, r6, r1.c, sbb.e.c(r1.d), "include_children", Boolean.valueOf(this.a.c())));
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.b r2 = this.b.e;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r7 = this.a;
        r2.delete(r7.a, r7.b);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog.WikiDeleteConfirmDialog.b
    public final void onCancel() {
        Boolean r3 = Boolean.valueOf(this.a.d());
        String r4 = this.b.d;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r0 = this.a;
        String r5 = r0.b;
        Boolean r6 = Boolean.valueOf(r0.e());
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r1 = this.a;
        gq5.d.h(new gq5.d.b(DocFeed$Value$Result.CANCEL, "none", r3, r4, r5, r6, r1.c, sbb.e.c(r1.d), null, null));
    }

    public f0(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r1, c0 r2) {
        this.a = r1;
        this.b = r2;
    }
}
