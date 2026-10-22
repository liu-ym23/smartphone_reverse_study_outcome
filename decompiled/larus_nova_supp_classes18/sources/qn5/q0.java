package qn5;

import com.bytedance.ee.bear.sheet_core.inputbar.editor.SheetEditorLayout;
import com.bytedance.ee.bear.widget.AtEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q0 implements AtEditText.a {
    public final /* synthetic */ SheetEditorLayout a;

    @Override // com.bytedance.ee.bear.widget.AtEditText.a
    public final void a() {
        this.a.v.f(true, true);
    }

    @Override // com.bytedance.ee.bear.widget.AtEditText.a
    public final boolean b() {
        if (this.a.l() == false) goto L5;
        this.a.Q = true;
    L5:
        this.a.o();
        this.a.j.F();
        return true;
    }

    public q0(SheetEditorLayout r1) {
        this.a = r1;
    }
}
