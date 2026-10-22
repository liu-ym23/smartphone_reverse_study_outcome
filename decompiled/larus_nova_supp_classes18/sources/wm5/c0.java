package wm5;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.sheet.inputbar.OfficeSheetEditFragment;
import com.bytedance.ee.bear.sheet.inputbar.formula.FormulaSignatureView;
import com.bytedance.ee.bear.sheet_core.inputbar.editor.SheetEditorLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c0 implements b {
    public final /* synthetic */ OfficeSheetEditFragment a;

    @Override // wm5.b
    public final void a() {
        OfficeSheetEditFragment r0 = this.a;
        r0.f.setEditable(r0.m.getInputEditable());
        this.a.f.setExpand(Boolean.FALSE);
        this.a.h.resetState();
        OfficeSheetEditFragment r1 = this.a;
        vz4.b.a r2 = r1.v;
        if (r2 == null) goto L6;
        r2.close();
        r1.v = null;
    L6:
        SheetEditorLayout r3 = this.a.m;
        Runnable r4 = new b0(this);
        if (r3.F == false) goto L9;
        r3.G = r4;
        return;
    L9:
        r4.run();
    }

    @Override // wm5.b
    public final void b() {
        OfficeSheetEditFragment r0 = this.a;
        r0.f.setEditable(r0.m.getFullEditable());
        this.a.f.setExpand(Boolean.TRUE);
        this.a.h.saveState();
        OfficeSheetEditFragment r1 = this.a;
        r1.h.b(r1.getResources().getColor(2131105852), true);
        OfficeSheetEditFragment r2 = this.a;
        if (r2.v != null) goto L11;
        PluginHost r3 = r2.u;
        if (r3 == null) goto L8;
        vz4.b r4 = (vz4.b) r3.getHostAbilityOrNull(vz4.b.class);
    L9:
        if (r4 == null) goto L11;
        r2.v = r4.qh("OfficeSheetEditFragment");
        goto L11
    L8:
        r4 = null;
    L11:
        OfficeSheetEditFragment r5 = this.a;
        r5.B = null;
        com.bytedance.ee.bear.sheet.inputbar.formula.a r6 = r5.z;
        if (r6 != null) goto L14;
    L16:
        FormulaSignatureView r7 = this.a.A;
        if (r7 == null) goto L19;
        r7.a();
    L19:
        this.a.ea0();
        return;
    L14:
        if (r6.c() == false) goto L16;
        this.a.z.a();
        goto L16
    }

    public c0(OfficeSheetEditFragment r1) {
        this.a = r1;
    }
}
