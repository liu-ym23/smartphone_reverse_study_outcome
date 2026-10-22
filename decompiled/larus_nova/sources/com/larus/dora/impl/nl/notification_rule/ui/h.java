package com.larus.dora.impl.nl.notification_rule.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.dora.impl.databinding.LarusDoraFragmentAddRuleInputBinding;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public final class h implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AddRuleInputFragment f336354a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public h(AddRuleInputFragment r100) {
        this.f336354a = r100;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        if (r100 == null) goto L5;
        String r104 = r100.toString();
        if (r104 == null) goto L5;
    L6:
        AddRuleInputFragment r105 = this.f336354a;
        int r106 = r104.length();
        int r107 = AddRuleInputFragment.f336295h;
        r105.T90(r106);
        this.f336354a.S90(r104);
        AddRuleInputFragment r108 = this.f336354a;
        LarusDoraFragmentAddRuleInputBinding r109 = r108.f336296d;
        if (r109 == null) goto L11;
        ConstraintLayout r110 = r109.f332557h;
        if (r110 == null) goto L11;
        r110.setBackgroundResource(R.drawable.larus_dora_bg_item_white);
    L11:
        LarusDoraFragmentAddRuleInputBinding r111 = r108.f336296d;
        if (r111 == null) goto L17;
        TextView r112 = r111.f332553d;
        if (r112 == null) goto L18;
        r112.setVisibility(8);
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r104 = "";
        goto L6
    }
}
