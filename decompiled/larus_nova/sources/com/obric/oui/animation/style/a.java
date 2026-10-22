package com.obric.oui.animation.style;

import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static final List<EditText> a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ArrayList r101 = new ArrayList();
        if ((r100 instanceof ViewGroup) == false) goto L8;
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L10;
        int r105 = r104 + 1;
        r101.addAll(a(r102.getChildAt(r104)));
        r104 = r105;
    L10:
        return r101;
    L8:
        if ((r100 instanceof EditText) == false) goto L10;
        r101.add(r100);
        goto L10
    }

    public static final void b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        List<EditText> r101 = a(r100);
        Object r102 = r100.getContext().getSystemService("input_method");
        if (r102 == null) goto L12;
        InputMethodManager r103 = (InputMethodManager) r102;
        Iterator r104 = ((ArrayList) r101).iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        EditText r105 = (EditText) r104.next();
        if (r103.isActive(r105) == false) goto L6;
        r103.hideSoftInputFromWindow(r105.getWindowToken(), 0);
        goto L6
    L10:
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }
}
