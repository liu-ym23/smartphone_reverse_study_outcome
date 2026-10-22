package com.ss.android.lark.keyboard.utils;

import android.text.Editable;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements ActionMode.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KeyboardFunctionEditText f430962a;

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r100) {
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
        return true;
    }

    public e(KeyboardFunctionEditText r100) {
        this.f430962a = r100;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.getItemId() != R.id.kb_editor_action_mode_change_line) goto L14;
        Editable r102 = this.f430962a.getEditableText();
        int r103 = this.f430962a.getSelectionStart();
        int r104 = this.f430962a.getSelectionEnd();
        if ((r104 - r103) <= 0) goto L9;
        r102.delete(r103, r104);
    L9:
        if (r103 >= 0) goto L11;
        r103 = r102.length();
    L11:
        this.f430962a.setSelection(r103);
        r102.insert(r103, "\n");
        return true;
    L14:
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
        if ((this.f430962a.getSelectionEnd() - this.f430962a.getSelectionStart()) <= 0) goto L5;
        return true;
    L5:
        if (r101 == null) goto L7;
        r101.add(769711401, R.id.kb_editor_action_mode_change_line, 0, R.string.Lark_IM_TextBoxNewLine_Button);
    L7:
        return true;
    }
}
