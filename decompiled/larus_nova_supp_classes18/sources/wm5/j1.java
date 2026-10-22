package wm5;

import com.bytedance.ee.bear.sheet.inputbar.SheetEditFragment;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetEditorLayout;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaSignatureView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j1 implements b {
    public final /* synthetic */ SheetEditFragment a;

    @Override // wm5.b
    public final void a() {
        SheetEditFragment r0 = this.a;
        r0.f.setEditable(r0.m.getInputEditable());
        this.a.f.setExpand(Boolean.FALSE);
        this.a.h.resetState();
        SheetEditorLayout r1 = this.a.m;
        Runnable r2 = new i1(this);
        if (r1.I == false) goto L5;
        r1.J = r2;
        return;
    L5:
        r2.run();
    }

    @Override // wm5.b
    public final void b() {
        SheetEditFragment r0 = this.a;
        r0.f.setEditable(r0.m.getFullEditable());
        this.a.f.setExpand(Boolean.TRUE);
        this.a.h.saveState();
        SheetEditFragment r1 = this.a;
        r1.h.b(r1.getResources().getColor(2131105852), true);
        SheetEditFragment r2 = this.a;
        r2.p = null;
        com.bytedance.ee.bear.sheet.inputbar.formula.a r3 = r2.n;
        if (r3 != null) goto L5;
    L7:
        FormulaSignatureView r4 = this.a.o;
        if (r4 == null) goto L10;
        r4.a();
    L10:
        this.a.ea0();
        return;
    L5:
        if (r3.c() == false) goto L7;
        this.a.n.a();
        goto L7
    }

    public j1(SheetEditFragment r1) {
        this.a = r1;
    }
}
