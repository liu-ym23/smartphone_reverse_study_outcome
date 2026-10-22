package com.obric.assistant.cocreationreview;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class r5 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<String, Unit> f387713a;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r5(Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onTextChanged");
        this.f387713a = r100;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        Function1<String, Unit> r104 = this.f387713a;
        if (r100 == null) goto L5;
        String r105 = r100.toString();
    L6:
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        r104.invoke(r105);
        return;
    L5:
        r105 = null;
        goto L6
    }
}
