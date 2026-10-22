package com.obric.oui.slider;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f403031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f403032b;

    /* JADX INFO: renamed from: com.obric.oui.slider.a$a, reason: collision with other inner class name */
    public static final class C4680a {
    }

    static {
    }

    public a() {
        this.f403032b = Integer.MAX_VALUE;
    }

    public final void a(Context r100, int r101, String r102, boolean r103, View r104) {
        if (this.f403032b >= 2) goto L10;
        wma.b.a("SeekBarVibrateHelper", Intrinsics.stringPlus("vibrateIfNeeded: ", r102));
        if (r103 == false) goto L7;
        bma.a.c(r100, r101);
    L8:
        this.f403032b++;
        return;
    L7:
        bma.a.b(r104, r101);
        goto L8
    }
}
