package com.ss.android.lark.utils;

import com.larksuite.component.ui.dialog.LKUIDialog;

/* JADX INFO: loaded from: classes38.dex */
public final class e1 extends com.larksuite.component.ui.dialog.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewUtils.b f444708a;

    public e1(ViewUtils.b r100) {
        this.f444708a = r100;
    }

    @Override // com.larksuite.component.ui.dialog.d.a
    public final void a(LKUIDialog r100) {
        this.f444708a.g(r100.getWindow());
    }

    @Override // com.larksuite.component.ui.dialog.d.a
    public final void b(LKUIDialog r100) {
        ViewUtils.b r101 = this.f444708a;
        r101.f(r100, r101.f444679d);
    }
}
