package com.bytedance.ee.bear.middleground.permission.custompassword;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.bytedance.ee.bear.middleground.permission.custompassword.model.TriggerAction;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements TextWatcher {
    public final /* synthetic */ CustomPasswordSettingFragment a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r1) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public i(CustomPasswordSettingFragment r1) {
        this.a = r1;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r2, int r3, int r4, int r5) {
        CustomPasswordSettingFragment r6 = this.a;
        int r7 = CustomPasswordSettingFragment.D;
        String r8 = String.valueOf(r6.ga0().getText());
        if (StringsKt.contains$default(r8, " ", false, 2, null) == false) goto L9;
        int r9 = this.a.ga0().getSelectionStart() - 1;
        this.a.ga0().setText(new Regex(" ").replace(r8, ""));
        if (r9 > String.valueOf(this.a.ga0().getText()).length()) goto L14;
        if (r9 < 0) goto L15;
        this.a.ga0().setSelection(r9);
        return;
    L15:
        return;
    L14:
        return;
    L9:
        TriggerAction r10 = TriggerAction.DEFAULT;
        if (TextUtils.isEmpty(r8) == false) goto L12;
        r10 = TriggerAction.CLEAR;
    L12:
        CustomPasswordSettingFragment r11 = this.a;
        r11.B = "customized";
        r11.na0().updatePasswordView(r10, r8);
    }
}
