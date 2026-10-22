package com.ss.android.lark.keyboard.edittext2.widget;

import android.text.InputFilter;
import android.text.Spannable;
import android.text.Spanned;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements InputFilter, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FunctionEditText f429261a;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext2.widget.a$a, reason: collision with other inner class name */
    public static final class C5098a {
    }

    static {
    }

    public a(FunctionEditText r100) {
        Intrinsics.checkNotNullParameter(r100, "richEditor");
        this.f429261a = r100;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r100, int r101, int r102, Spanned r103, int r104, int r105) {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (r100.length() >= 10) goto L8;
        return r100;
    L8:
        List<String> r106 = com.ss.android.lark.keyboard.edittext2.utils.b.f429249a;
        if (com.ss.android.lark.keyboard.edittext2.utils.b.c(r100, 0, r100.length()) == false) goto L12;
        return r100;
    L12:
        if ((r100 instanceof Spannable) == false) goto L14;
        Spannable r107 = (Spannable) r100;
    L15:
        ((eob.a) this.f429261a.q(eob.a.f473406f)).Z(r107, r101, r102);
        return r107;
    L14:
        r107 = com.ss.android.lark.keyboard.edittext2.utils.e.e(r100);
        goto L15
    }
}
