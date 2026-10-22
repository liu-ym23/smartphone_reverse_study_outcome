package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

/* JADX INFO: loaded from: classes27.dex */
public final class i implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraObricEarbudsAddRuleInputSheet f339884a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public i(DoraObricEarbudsAddRuleInputSheet r100) {
        this.f339884a = r100;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        boolean r104 = false;
        if (r100 == null) goto L5;
        int r105 = r100.length();
    L6:
        DoraObricEarbudsAddRuleInputSheet r106 = this.f339884a;
        int r107 = DoraObricEarbudsAddRuleInputSheet.f339726i;
        TextView r108 = r106.f339729f;
        if (r108 == null) goto L9;
        r108.setText(r105 + "/300");
    L9:
        DoraObricEarbudsAddRuleInputSheet r109 = this.f339884a;
        if (r105 <= 0) goto L12;
        r104 = true;
    L12:
        r109.W90(r104);
        return;
    L5:
        r105 = 0;
        goto L6
    }
}
