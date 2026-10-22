package com.larksuite.component.blockit.hashtag.add;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.larksuite.framework.utils.KeyboardUtils;

/* JADX INFO: loaded from: classes24.dex */
public final class d implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditText f283011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f283012b;

    public d(EditText r100, b r101) {
        this.f283011a = r100;
        this.f283012b = r101;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        if (r101 == false) goto L5;
        KeyboardUtils.showKeyboard(this.f283011a);
        return;
    L5:
        if (TextUtils.isEmpty(this.f283011a.getText()) == false) goto L9;
        KeyboardUtils.hideKeyboard(this.f283012b.f283008g);
        return;
    }
}
