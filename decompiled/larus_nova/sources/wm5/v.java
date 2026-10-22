package wm5;

import android.text.Editable;
import com.bytedance.ee.bear.sheet.inputbar.OfficeSheetEditFragment;
import com.bytedance.ee.bear.sheet_core.inputbar.editor.SheetEditorLayout;
import com.bytedance.ee.bear.sheet_core.inputbar.toolbar.ToolbarItemEnum;

/* JADX INFO: loaded from: classes18.dex */
public final /* synthetic */ class v implements SheetEditorLayout.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeSheetEditFragment f560347a;

    public /* synthetic */ v(OfficeSheetEditFragment r100) {
        this.f560347a = r100;
    }

    public final void a() {
        OfficeSheetEditFragment r100 = this.f560347a;
        SheetEditorLayout r101 = r100.f237889m;
        if (r101.B == false) goto L5;
        Editable r102 = r101.getFullEditable();
    L7:
        if (r102 == r100.f237882f.getEditable().getValue()) goto L9;
        r100.f237882f.setEditable(r102);
    L9:
        r100.fa0();
        if (ToolbarItemEnum.text.equals(r100.X90()) == false) goto L13;
        r100.f237899w = true;
        return;
    L13:
        return;
    L5:
        r102 = r101.getInputEditable();
        goto L7
    }
}
