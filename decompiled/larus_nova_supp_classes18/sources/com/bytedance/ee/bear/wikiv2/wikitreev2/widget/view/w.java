package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiDeletePlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog.WikiDeleteConfirmDialog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w implements WikiDeleteConfirmDialog.b {
    public final /* synthetic */ WikiDeletePlugin a;
    public final /* synthetic */ t b;

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog.WikiDeleteConfirmDialog.b
    public final void onCancel() {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog.WikiDeleteConfirmDialog.b
    public final void a() {
        WikiDeletePlugin r0 = this.a;
        t r1 = this.b;
        WikiDialogs r2 = r1.h;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r3 = r1.b;
        r0.deleteCurrentOnly(r2, r3.a, r3.b, r3.c, r3.d, true);
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog.WikiDeleteConfirmDialog.b
    public final void b() {
        WikiDeletePlugin r0 = this.a;
        t r1 = this.b;
        WikiDialogs r2 = r1.h;
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r3 = r1.b;
        r0.deleteWithSub(r2, r3.a, r3.b, r3.c, r3.d, true);
    }

    public w(WikiDeletePlugin r1, t r2) {
        this.a = r1;
        this.b = r2;
    }
}
