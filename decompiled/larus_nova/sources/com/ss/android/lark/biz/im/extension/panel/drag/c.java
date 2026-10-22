package com.ss.android.lark.biz.im.extension.panel.drag;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements com.ss.android.lark.biz.im.extension.panel.drag.view.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DragPanel f410532a;

    @Override // com.ss.android.lark.biz.im.extension.panel.drag.view.a
    public final void a() {
        this.f410532a.c();
    }

    @Override // com.ss.android.lark.biz.im.extension.panel.drag.view.a
    public final void onBackPressed() {
        this.f410532a.dismiss();
    }

    public c(DragPanel r100) {
        this.f410532a = r100;
    }
}
