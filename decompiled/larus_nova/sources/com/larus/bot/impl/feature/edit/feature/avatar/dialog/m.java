package com.larus.bot.impl.feature.edit.feature.avatar.dialog;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import com.larus.bot.impl.databinding.LarusDialogAvatarPromptInputBinding;

/* JADX INFO: loaded from: classes26.dex */
public final class m implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AvatarPromptInputDialog f318570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LarusDialogAvatarPromptInputBinding f318571b;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public m(AvatarPromptInputDialog r100, LarusDialogAvatarPromptInputBinding r101) {
        this.f318570a = r100;
        this.f318571b = r101;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        if (r100 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L13;
        AvatarPromptInputDialog r105 = this.f318570a;
        int r106 = AvatarPromptInputDialog.f318545o;
        LarusDialogAvatarPromptInputBinding r107 = r105.f318548f;
        if (r107 == null) goto L21;
        r107.f317733b.setEnabled(false);
        r107.f317733b.setAlpha(0.3f);
        return;
    L21:
        return;
    L13:
        LarusDialogAvatarPromptInputBinding r108 = this.f318570a.f318548f;
        if (r108 == null) goto L17;
        r108.f317733b.setEnabled(true);
        r108.f317733b.setAlpha(1.0f);
    L17:
        if (r100.length() <= 100) goto L19;
        r100 = r100.subSequence(0, 100);
        this.f318571b.f317734c.setText(r100);
        Selection.setSelection(this.f318571b.f317734c.getText(), r100.length());
    L19:
        AvatarPromptInputDialog r109 = this.f318570a;
        r109.f318550h = r100.toString();
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}
