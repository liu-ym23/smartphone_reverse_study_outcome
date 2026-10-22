package wm5;

import android.text.Editable;
import com.bytedance.ee.bear.sheet.inputbar.OfficeSheetEditFragment;
import com.bytedance.ee.bear.sheet_core.inputbar.editor.SheetEditorLayout;
import com.bytedance.ee.bear.sheet_core.inputbar.toolbar.ToolbarItemEnum;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class v implements SheetEditorLayout.h {
    public final /* synthetic */ OfficeSheetEditFragment a;

    public /* synthetic */ v(OfficeSheetEditFragment r1) {
        this.a = r1;
    }

    public final void a() {
        OfficeSheetEditFragment r0 = this.a;
        SheetEditorLayout r1 = r0.m;
        if (r1.B == false) goto L5;
        Editable r2 = r1.getFullEditable();
    L7:
        if (r2 == r0.f.getEditable().getValue()) goto L9;
        r0.f.setEditable(r2);
    L9:
        r0.fa0();
        if (ToolbarItemEnum.text.equals(r0.X90()) == false) goto L13;
        r0.w = true;
        return;
    L13:
        return;
    L5:
        r2 = r1.getInputEditable();
        goto L7
    }
}
