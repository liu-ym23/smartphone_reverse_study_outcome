package com.ss.android.lark.keyboard.classicinput.base;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements View.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditText f428674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f428675b;

    public a(KeyboardFunctionEditText r100, View r101) {
        this.f428674a = r100;
        this.f428675b = r101;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View r100, int r101, KeyEvent r102) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r102, "event");
        if (r101 == 66) goto L5;
        return false;
    L5:
        if (r102.getAction() == 0) goto L7;
        return false;
    L7:
        if (r102.isShiftPressed() == true) goto L15;
        if (r102.isCtrlPressed() == true) goto L15;
        if (TextUtils.isEmpty(StringsKt.trim(this.f428674a.getText())) == true) goto L15;
        this.f428675b.performClick();
        return true;
    L15:
        if (TextUtils.isEmpty(StringsKt.trim(this.f428674a.getText())) == false) goto L18;
        return true;
    L18:
        if (r102.isCtrlPressed() == false) goto L20;
    L21:
        this.f428674a.append("\n");
        return true;
    L20:
        if (r102.isShiftPressed() == true) goto L21;
        return false;
    }
}
