package qn5;

import android.view.View;
import com.bytedance.ee.bear.sheet_core.inputbar.editor.SheetEditorLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m0 extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ SheetEditorLayout c;

    public m0(SheetEditorLayout r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r4) {
        this.c.v.f(true, false);
        int r5 = this.c.j.getSelectionStart();
        int r0 = this.c.j.getSelectionEnd();
        if (SheetEditorLayout.i(this.c.j, r5, r0) == false) goto L6;
        this.c.j.getText().replace(r5, r0, "");
        this.c.j.getText().replace(this.c.j.getSelectionStart(), this.c.j.getSelectionEnd(), "\n");
        return;
    }
}
