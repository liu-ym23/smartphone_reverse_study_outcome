package com.bytedance.ee.bear.document.selection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class z implements Runnable {
    public final /* synthetic */ e0 a;

    public /* synthetic */ z(e0 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final e0 r0 = this.a;
        r0.getClass();
        Runnable r1 = new a0(r0);
        e0.l(new String[]{"jsGetActionModeMenu"});
        r0.g("javascript:window.lark.biz.navigation.requestCustomContextMenu", null, new d0(r0, r1));
    }
}
