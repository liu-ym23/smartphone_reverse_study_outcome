package com.bytedance.ee.bear.document.selection;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e0 f221722a;

    public /* synthetic */ z(e0 r100) {
        this.f221722a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final e0 r100 = this.f221722a;
        r100.getClass();
        Runnable r101 = new a0(r100);
        e0.l(new String[]{"jsGetActionModeMenu"});
        r100.g("javascript:window.lark.biz.navigation.requestCustomContextMenu", null, new d0(r100, r101));
    }
}
