package com.bytedance.ee.bear.sheet.inputbar.toolbar;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetEditorLayout;
import com.bytedance.ee.bear.widgets.t;
import com.larksuite.component.universe_design.edittext.UDEditText;
import eu5.h;
import wm5.k1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends t {
    public final /* synthetic */ ToolbarItemView c;
    public final /* synthetic */ String d;
    public final /* synthetic */ ToolbarItemAdapter e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r5) {
        h.a(this.c.getContext(), 10, 50);
        if (this.e.a != null) goto L6;
        return;
    L6:
        if (TextUtils.equals("ABC", this.d) == false) goto L9;
        this.e.y2(0);
        return;
    L9:
        if (TextUtils.equals("123", this.d) == false) goto L11;
        this.e.y2(1);
        return;
    L11:
        ToolbarItemAdapter.a r6 = this.e.a;
        String r1 = this.d;
        SheetEditorLayout r7 = ((k1) r6).d.m;
        if (r7 == null) goto L21;
        UDEditText r8 = r7.getCurrentEditText();
        if (r8 == null) goto L22;
        if (r1 == null) goto L23;
        int r2 = Math.max(0, r8.getSelectionStart());
        int r0 = Math.max(0, r8.getSelectionEnd());
        int r3 = Math.min(r2, r0);
        int r4 = Math.max(r2, r0);
        r8.getText().replace(r3, r4, r1);
        r8.setSelection(Math.min(r3 + r1.length(), r8.length()));
        return;
    L23:
        return;
    L22:
        return;
    }

    public c(ToolbarItemAdapter r1, ToolbarItemView r2, String r3) {
        this.e = r1;
        this.c = r2;
        this.d = r3;
    }
}
