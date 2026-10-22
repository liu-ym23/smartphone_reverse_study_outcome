package com.ss.android.lark.flow.passport.ui.widget.password;

import android.animation.ValueAnimator;
import android.view.View;
import com.ss.android.lark.flow.passport.ui.widget.common.g;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PasswordEditText f423906a;

    public b(PasswordEditText r100) {
        this.f423906a = r100;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        PasswordEditText r102 = this.f423906a;
        int r103 = PasswordEditText.f423885k;
        r102.getClass();
        View.OnFocusChangeListener r104 = this.f423906a.f423891f;
        if (r104 == null) goto L5;
        r104.onFocusChange(r100, r101);
    L5:
        this.f423906a.getClass();
        if (r101 == false) goto L8;
        g r105 = g.f423844b;
    L9:
        PasswordEditText r106 = this.f423906a;
        List<ValueAnimator> r107 = r106.f423894i;
        ArrayList r108 = (ArrayList) r107;
        r108.add(r106.f423895j.c(r105));
        return;
    L8:
        r105 = g.f423843a;
        goto L9
    }
}
