package com.ss.android.lark;

import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.keyboard.event.HeightChange;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.keyboard.event.o;
import com.ss.android.lark.keyboard.keyboard2.BasicKeyboard;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenu;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c {
    public static final int a(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof BasicKeyboard) == false) goto L15;
        BasicKeyboard r101 = (BasicKeyboard) r100;
        if (r101.f429436b.getVisibility() != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        int r103 = r101.f429445k;
    L14:
        return r103;
    L10:
        if (r101.z().y() == false) goto L16;
        r103 = r101.z().height();
        goto L14
    L16:
        return 0;
    L7:
        r102 = false;
        goto L8
    L15:
        return 0;
    }

    public static final void b(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        k r101 = r100.e();
        HeightChange r102 = HeightChange.f429287b.a();
        r102.f429288a = 0;
        k.a.a(r101, r102);
        if ((r100 instanceof BasicKeyboard) == false) goto L11;
        ((BasicKeyboard) r100).f429436b.setVisibility(8);
        com.ss.android.lark.keyboard.ime.a r103 = r100.z();
        r103.g();
        r103.a();
        com.ss.android.lark.keyboard.keyboard2.d r104 = r100.H();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.ss.android.lark.keyboard.keyboard2.KeyboardMenu");
        KeyboardMenu r105 = (KeyboardMenu) r104;
        if (r105.f429473k == false) goto L13;
        r105.f429473k = false;
        if (r105.f429467e == false) goto L12;
        r105.m();
        return;
    L12:
        return;
    L13:
        return;
    }

    public static final void c(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        com.ss.android.lark.keyboard.ime.a r101 = r100.z();
        if (r101.y() == false) goto L6;
        r101.g();
    L6:
        if (r101.B() == false) goto L9;
        r101.a();
        return;
    }

    public static final void d(k r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = a(((o) r100).f429301a);
        Log.i(ObricActionBarTrackType.KEY_BOARD, "notifyKeyboardHeightChange: height is " + r101);
        HeightChange r102 = HeightChange.f429287b.a();
        r102.f429288a = r101;
        r100.a(r102, r100.b());
    }

    public static final void e(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof BasicKeyboard) == false) goto L10;
        ((BasicKeyboard) r100).f429436b.setVisibility(0);
        com.ss.android.lark.keyboard.keyboard2.d r101 = r100.H();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ss.android.lark.keyboard.keyboard2.KeyboardMenu");
        KeyboardMenu r102 = (KeyboardMenu) r101;
        if (r102.f429473k == true) goto L10;
        r102.f429473k = true;
        if (r102.f429467e == false) goto L10;
        r102.m();
    L10:
        d(r100.e());
    }

    public static final void f(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.z().z();
    }
}
