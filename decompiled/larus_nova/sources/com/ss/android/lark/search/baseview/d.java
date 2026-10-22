package com.ss.android.lark.search.baseview;

import android.view.KeyEvent;
import android.widget.TextView;
import com.larksuite.framework.utils.KeyboardUtils;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchInputView f439924a;

    public d(SearchInputView r100) {
        this.f439924a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        long r103 = System.currentTimeMillis();
        SearchInputView r104 = this.f439924a;
        if ((r103 - r104.f439904j) >= 200) goto L5;
        return false;
    L5:
        r104.f439904j = System.currentTimeMillis();
        if (StringsKt.isBlank(this.f439924a.f439902h) == true) goto L15;
        KeyboardUtils.hideKeyboard(this.f439924a.f439895a);
        SearchInputView r105 = this.f439924a;
        SearchInputView.e r106 = r105.f439908n;
        if (r106 == null) goto L10;
        r106.onImeSearch(r105.f439902h);
    L10:
        SearchInputView r107 = this.f439924a;
        SearchInputView.g r108 = r107.f439900f;
        if (r108 == null) goto L17;
        r108.onSearch(r107.f439902h);
        return true;
    L17:
        return true;
    L15:
        this.f439924a.getMIOnHintSearch();
        return false;
    }
}
