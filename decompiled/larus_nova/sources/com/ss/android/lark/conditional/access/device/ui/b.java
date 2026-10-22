package com.ss.android.lark.conditional.access.device.ui;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.ss.android.lark.conditional.access.device.viewmodel.DeviceDeclareViewModel;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserScopeDeclareReasonEditFragment f418031a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public b(UserScopeDeclareReasonEditFragment r100) {
        this.f418031a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        UserScopeDeclareReasonEditFragment r101 = this.f418031a;
        int r102 = UserScopeDeclareReasonEditFragment.f418014m;
        DeviceDeclareViewModel r103 = r101.X90();
        if (r100 == null) goto L6;
        String r104 = r100.toString();
        if (r104 == null) goto L6;
    L7:
        r103.setReason(r104);
        if (r100 == null) goto L10;
        int r105 = TextUtils.getTrimmedLength(r100);
    L11:
        this.f418031a.Y90(r105);
        return;
    L10:
        r105 = 0;
    L6:
        r104 = "";
        goto L7
    }
}
