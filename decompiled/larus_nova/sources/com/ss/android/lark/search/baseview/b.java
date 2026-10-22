package com.ss.android.lark.search.baseview;

import android.text.TextUtils;
import android.view.View;
import com.larksuite.framework.utils.KeyboardUtils;
import com.suite.lark.emm.autofocus.AutoFocusEditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchInputView f439921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AutoFocusEditText f439922b;

    public b(SearchInputView r100, AutoFocusEditText r101) {
        this.f439921a = r100;
        this.f439922b = r101;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        if (r101 == false) goto L8;
        AutoFocusEditText r102 = this.f439921a.f439896b;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEdtTxt");
        r102 = null;
    L6:
        KeyboardUtils.showKeyboard(r102);
        return;
    L8:
        if (TextUtils.isEmpty(this.f439922b.getText()) == false) goto L12;
        KeyboardUtils.hideKeyboard(this.f439921a.f439895a);
        return;
    }
}
