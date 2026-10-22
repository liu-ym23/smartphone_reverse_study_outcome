package wm5;

import android.text.Editable;
import com.bytedance.ee.bear.sheet.inputbar.SheetEditFragment;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetEditorLayout;
import com.bytedance.ee.bear.sheet.inputbar.toolbar.ToolbarItemEnum;

/* JADX INFO: loaded from: classes18.dex */
public final /* synthetic */ class c1 implements SheetEditorLayout.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SheetEditFragment f560276a;

    public /* synthetic */ c1(SheetEditFragment r100) {
        this.f560276a = r100;
    }

    public final void a() {
        SheetEditFragment r100 = this.f560276a;
        SheetEditorLayout r101 = r100.f237920m;
        if (r101.E == false) goto L5;
        Editable r102 = r101.getFullEditable();
    L7:
        if (r102 == r100.f237913f.getEditable().getValue()) goto L9;
        r100.f237913f.setEditable(r102);
    L9:
        r100.fa0();
        if (ToolbarItemEnum.text.equals(r100.X90()) == false) goto L13;
        r100.A = true;
        return;
    L13:
        return;
    L5:
        r102 = r101.getInputEditable();
        goto L7
    }
}
