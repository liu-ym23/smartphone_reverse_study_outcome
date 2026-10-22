package com.larus.bmhome.music.utils;

import android.text.InputFilter;
import android.text.Spanned;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f313152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f313153b;

    public a(int r100, Function0<Unit> r101) {
        this.f313152a = r100;
        this.f313153b = r101;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r100, int r101, int r102, Spanned r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r103, "dest");
        int r106 = r105 - r104;
        int r107 = this.f313152a - (r103.length() - r106);
        if (r107 > 0) goto L10;
        if ((r102 - r101) <= r106) goto L22;
        Function0<Unit> r108 = this.f313153b;
        if (r108 == null) goto L23;
        r108.invoke();
        return "";
    L23:
        return "";
    L22:
        return "";
    L10:
        if (r107 < (r102 - r101)) goto L12;
        return null;
    L12:
        Function0<Unit> r109 = this.f313153b;
        if (r109 == null) goto L15;
        r109.invoke();
    L15:
        int r110 = r107 + r101;
        if (Character.isHighSurrogate(r100.charAt(r110 - 1)) == false) goto L21;
        r110 = r110 - 1;
        if (r110 != r101) goto L21;
        return "";
    L21:
        return r100.subSequence(r101, r110);
    }
}
