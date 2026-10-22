package an5;

import com.bytedance.ee.bear.sheet.inputbar.editor.SheetEditorLayout;
import com.bytedance.ee.bear.widget.AtEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p0 implements AtEditText.a {
    public final /* synthetic */ SheetEditorLayout a;

    @Override // com.bytedance.ee.bear.widget.AtEditText.a
    public final void a() {
        this.a.y.h(true, true);
    }

    @Override // com.bytedance.ee.bear.widget.AtEditText.a
    public final boolean b() {
        if (this.a.l() == false) goto L5;
        this.a.T = true;
    L5:
        this.a.o();
        this.a.j.F();
        return true;
    }

    public p0(SheetEditorLayout r1) {
        this.a = r1;
    }
}
