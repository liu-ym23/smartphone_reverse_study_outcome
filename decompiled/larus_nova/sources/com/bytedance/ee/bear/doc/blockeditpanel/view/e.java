package com.bytedance.ee.bear.doc.blockeditpanel.view;

import com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseBlockEditPanel f217665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f217666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f217667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f217668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ BlockEditPanelFragment f217669e;

    public e(BaseBlockEditPanel r100, int r101, int r102, int r103, BlockEditPanelFragment r104) {
        this.f217665a = r100;
        this.f217666b = r101;
        this.f217667c = r102;
        this.f217668d = r103;
        this.f217669e = r104;
    }

    public final void a() {
        int r100 = this.f217665a.getMeasuredHeight();
        tt5.a.h("BlockEditPanelFragment", "panel id: " + this.f217665a.getPanelId());
        int r101 = this.f217666b;
        if (r100 >= r101) goto L5;
        tt5.a.h("BlockEditPanelFragment", "this panel height: (" + r100 + ") Low to topPanelHeight: " + this.f217666b + "; not need scale");
    L6:
        this.f217665a.a(false);
        return;
    L5:
        int r102 = r101 - (((this.f217667c - this.f217668d) - 1) * this.f217669e.f217635g);
        tt5.a.h("BlockEditPanelFragment", "this targetHeight: (" + r102 + ") ; " + this.f217665a.getPanelId());
        BlockEditPanelFragment r103 = this.f217669e;
        BaseBlockEditPanel r104 = this.f217665a;
        r103.getClass();
        BlockEditPanelFragment.U90(r104, r102).start();
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
