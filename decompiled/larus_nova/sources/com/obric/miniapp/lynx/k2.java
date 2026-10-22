package com.obric.miniapp.lynx;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes33.dex */
public final class k2 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxOUIDatePickerViewUI f398178a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public k2(LynxOUIDatePickerViewUI r100) {
        this.f398178a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        if (this.f398178a.f397923v == false) goto L5;
        return;
    L5:
        if (r100 == null) goto L19;
        String r101 = r100.toString();
        if (r101 == null) goto L22;
        this.f398178a.getClass();
        String r102 = new Regex("\\s*年\\s*").replace(r101, "年");
        String r103 = new Regex("\\s*月\\s*").replace(r102, "月");
        if (Intrinsics.areEqual(r103, r101) == false) goto L12;
        return;
    L12:
        this.f398178a.f397923v = true;
        r100.replace(0, r100.length(), r103);     // Catch: Throwable -> L16
        this.f398178a.f397923v = false;
        return;
    L16:
        th = move-exception;
        this.f398178a.f397923v = false;
        throw th;
    L22:
        return;
    }
}
