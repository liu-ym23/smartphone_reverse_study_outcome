package com.ss.android.lark.officesdk.minutes.ui.foundation.mvi;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmBaseFragment f435629a;

    public b(MmBaseFragment r100) {
        this.f435629a = r100;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
        Intrinsics.checkNotNullParameter(r100, "<unused var>");
        Intrinsics.checkNotNullParameter(r101, "insets");
        Insets r102 = r101.getInsets(WindowInsetsCompat.Type.systemBars());
        int r103 = r102.left;
        int r104 = r102.top;
        int r105 = r102.right;
        MmBaseFragment r106 = this.f435629a;
        int r107 = MmBaseFragment.f435621j;
        r106.getClass();
        Insets r108 = Insets.of(r103, r104, r105, xvb.a.a(r101));
        if (Intrinsics.areEqual(r102, this.f435629a.f435624f) == true) goto L6;
        this.f435629a.f435624f = r102;
    L6:
        if (Intrinsics.areEqual(r108, this.f435629a.f435623e) == true) goto L8;
        MmBaseFragment r109 = this.f435629a;
        r109.f435623e = r108;
        r109.Y90(r108.left, r108.top, r108.right, r108.bottom);
    L8:
        return r101;
    }
}
