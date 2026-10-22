package an5;

import android.view.View;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetEditorLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l0 extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ SheetEditorLayout c;

    public l0(SheetEditorLayout r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r4) {
        this.c.y.h(false, false);
        int r5 = this.c.m.getSelectionStart();
        int r0 = this.c.m.getSelectionEnd();
        if (SheetEditorLayout.i(this.c.m, r5, r0) == false) goto L6;
        this.c.m.getText().replace(r5, r0, "");
        this.c.m.getText().replace(this.c.m.getSelectionStart(), this.c.m.getSelectionEnd(), "\n");
        return;
    }
}
