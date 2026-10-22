package com.larus.bot.impl.common.util;

import android.text.InputFilter;
import android.text.Spanned;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c extends InputFilter.LengthFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f317676a;

    public c(int r100, Function0<Unit> r101) {
        super(r100);
        this.f317676a = r101;
    }

    @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
    public final CharSequence filter(CharSequence r100, int r101, int r102, Spanned r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r103, "dest");
        if ((getMax() - (r103.length() - (r105 - r104))) >= (r102 - r101)) goto L8;
        Function0<Unit> r106 = this.f317676a;
        if (r106 == null) goto L8;
        r106.invoke();
    L8:
        return super.filter(r100, r101, r102, r103, r104, r105);
    }
}
