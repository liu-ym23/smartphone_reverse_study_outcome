package com.ss.android.lark.search.baseview;

import android.view.View;
import com.suite.lark.emm.autofocus.AutoFocusEditText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchInputView f439925a;

    public e(SearchInputView r100) {
        this.f439925a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        SearchInputView r101 = this.f439925a;
        r101.f439902h = "";
        AutoFocusEditText r102 = r101.f439896b;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchEdtTxt");
        r102 = null;
    L5:
        r102.setText(this.f439925a.f439902h);
        this.f439925a.getClass();
    }
}
