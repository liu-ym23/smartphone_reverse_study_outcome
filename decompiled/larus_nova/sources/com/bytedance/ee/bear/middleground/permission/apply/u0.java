package com.bytedance.ee.bear.middleground.permission.apply;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class u0 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeBitableApplyPermissionFragment f233077a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public u0(OfficeBitableApplyPermissionFragment r100) {
        this.f233077a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        OfficeBitableApplyPermissionFragment r101 = this.f233077a;
        int r102 = 0;
        if (r100 == null) goto L5;
        int r103 = r100.length();
    L6:
        int r104 = OfficeBitableApplyPermissionFragment.f232937r;
        r101.getClass();
        if (r103 <= 300) goto L9;
        boolean r105 = true;
    L10:
        TextView r106 = r101.f232945l;
        if (r106 == null) goto L18;
        if (r105 == true) goto L15;
        r102 = 8;
    L15:
        r106.setVisibility(r102);
        if (r105 == false) goto L18;
        r106.setText(R.string.Bitable_AdvancedPermission_MaxNotesLength);
    L18:
        TextView r107 = r101.f232946m;
        if (r107 == null) goto L22;
        r107.setEnabled(!r105);
        return;
    L22:
        return;
    L9:
        r105 = false;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }
}
