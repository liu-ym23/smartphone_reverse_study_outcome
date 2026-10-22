package com.ss.android.lark.feed.app.tablayout;

import android.graphics.drawable.Drawable;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {
    public static final View a(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100.getCallback() instanceof View) == false) goto L8;
        Drawable.Callback r101 = r100.getCallback();
        if ((r101 instanceof View) == true) goto L7;
        return null;
    L7:
        return (View) r101;
    L8:
        return null;
    }
}
