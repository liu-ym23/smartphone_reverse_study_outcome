package com.suite.lark.platform.feature.forward.doubao;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoubaoForwardConfirmFragment f461351a;

    public h(DoubaoForwardConfirmFragment r100) {
        this.f461351a = r100;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
        Intrinsics.checkNotNullParameter(r100, "<unused var>");
        Intrinsics.checkNotNullParameter(r101, "insets");
        boolean r102 = r101.isVisible(WindowInsetsCompat.Type.ime());
        int r103 = 0;
        if (r102 == false) goto L5;
        int r104 = r101.getInsets(WindowInsetsCompat.Type.ime()).bottom;
    L6:
        int r105 = r101.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
        DoubaoForwardConfirmFragment r106 = this.f461351a;
        if (r106.f461222s == true) goto L9;
        DoubaoForwardConfirmFragment.T90(r106, r104, true);
    L9:
        DoubaoForwardConfirmFragment r107 = this.f461351a;
        View r108 = r107.f461217n;
        if (r108 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("bottomContainer");
        r108 = null;
    L12:
        if (r102 == true) goto L15;
        r103 = r105;
    L15:
        DoubaoForwardConfirmFragment.S90(r107, r108, r103);
        return r101;
    L5:
        r104 = 0;
        goto L6
    }
}
