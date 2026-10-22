package com.ss.android.lark.keyboard.utils;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements View.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f430956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f430957b;

    public c(Function0<Unit> r100) {
        this.f430957b = r100;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View r100, int r101, KeyEvent r102) {
        Intrinsics.checkNotNullParameter(r102, "event");
        if ((r100 instanceof EditText) == false) goto L5;
        EditText r103 = (EditText) r100;
    L7:
        if (r103 != null) goto L10;
        return false;
    L10:
        if (r101 == 66) goto L13;
        return false;
    L13:
        if (r102.getAction() != 0) goto L29;
        if (r102.getRepeatCount() > 0) goto L17;
        this.f430956a = false;
        if (r102.isShiftPressed() == false) goto L22;
        return false;
    L22:
        if (r102.isCtrlPressed() == false) goto L27;
        this.f430956a = true;
        if (TextUtils.isEmpty(StringsKt.trim(r103.getText())) == true) goto L26;
        this.f430957b.invoke();
    L26:
        return true;
    L27:
        return false;
    L17:
        return this.f430956a;
    L29:
        if (r102.getAction() == 1) goto L31;
        return false;
    L31:
        return this.f430956a;
    L5:
        r103 = null;
        goto L7
    }
}
