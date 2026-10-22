package com.obric.assistant.util;

import android.text.InputFilter;
import android.text.Spanned;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class o1 implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f393788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f393789b;

    public o1(int r100, com.obric.assistant.chat.component.bottom.core.a r101) {
        this.f393788a = r100;
        this.f393789b = r101;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r100, int r101, int r102, Spanned r103, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r103, "dest");
        int r104 = r111 - r110;
        int r105 = this.f393788a - (r103.length() - r104);
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("filter, keep: ");
        r107.append(r105);
        r107.append(", end - start: ");
        int r108 = r102 - r101;
        r107.append(r108);
        r107.append(", dend - dstart: ");
        r107.append(r104);
        r107.append(", ");
        r107.append(r101);
        r107.append(", ");
        r107.append(r102);
        r107.append(", ");
        r107.append(r110);
        r107.append(", ");
        r107.append(r111);
        r107.append(", ");
        r106.d("ObricInputLengthFilter", r107.toString());
        if (r105 > 0) goto L8;
        if (r108 <= r104) goto L20;
        Function0<Unit> r109 = this.f393789b;
        if (r109 == null) goto L21;
        r109.invoke();
        return "";
    L21:
        return "";
    L20:
        return "";
    L8:
        if (r105 < r108) goto L10;
        return null;
    L10:
        Function0<Unit> r112 = this.f393789b;
        if (r112 == null) goto L13;
        r112.invoke();
    L13:
        int r113 = r105 + r101;
        if (Character.isHighSurrogate(r100.charAt(r113 - 1)) == false) goto L19;
        r113 = r113 - 1;
        if (r113 != r101) goto L19;
        return "";
    L19:
        return r100.subSequence(r101, r113);
    }
}
