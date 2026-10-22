package com.larus.avlink.env.diary.detail;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes25.dex */
public final class p implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DiaryFeedbackBottomSheetDialogFragment f292036a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public p(DiaryFeedbackBottomSheetDialogFragment r100) {
        this.f292036a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        DiaryFeedbackBottomSheetDialogFragment r101 = this.f292036a;
        int r102 = DiaryFeedbackBottomSheetDialogFragment.f291980h;
        DoraEnvObserveDiaryDetailViewModel r103 = r101.S90();
        if (r100 == null) goto L5;
        String r104 = r100.toString();
    L6:
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        r103.updateInputText(r104);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
