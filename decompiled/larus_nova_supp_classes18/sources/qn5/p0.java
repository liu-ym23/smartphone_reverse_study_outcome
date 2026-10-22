package qn5;

import com.bytedance.ee.bear.sheet_core.inputbar.editor.SheetEditorLayout;
import com.bytedance.ee.bear.widget.AtEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p0 implements AtEditText.a {
    public final /* synthetic */ SheetEditorLayout a;

    @Override // com.bytedance.ee.bear.widget.AtEditText.a
    public final void a() {
    }

    @Override // com.bytedance.ee.bear.widget.AtEditText.a
    public final boolean b() {
        SheetEditorLayout r0 = this.a;
        if (r0.J == false) goto L9;
        if (r0.l() == false) goto L7;
        this.a.q(false);
        goto L9
    L7:
        this.a.p();
    L9:
        return this.a.m.F();
    }

    public p0(SheetEditorLayout r1) {
        this.a = r1;
    }
}
