package com.obric.assistant.common.utils;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f387883a = 0;

    static {
    }

    public static int a(ConstraintLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        WindowInsetsCompat r101 = ViewCompat.getRootWindowInsets(r100);
        if (r101 == null) goto L5;
        Insets r102 = r101.getInsets(WindowInsetsCompat.Type.navigationBars());
    L6:
        if (r102 == null) goto L8;
        int r103 = r102.bottom;
    L9:
        FLogger.f375446a.d("ObricNavigationBarUtils", "getNavigationBarHeightPx() navBarHeight=" + r103);
        return r103;
    L8:
        r103 = 0;
        goto L9
    L5:
        r102 = null;
        goto L6
    }
}
