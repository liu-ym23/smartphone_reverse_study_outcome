package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i implements OnApplyWindowInsetsListener {
    public final /* synthetic */ View a;

    public i(View r1) {
        this.a = r1;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r5, WindowInsetsCompat r6) {
        Intrinsics.checkNotNullParameter(r5, "v");
        Intrinsics.checkNotNullParameter(r6, "insets");
        int r0 = r6.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        tt5.a.h("ForsetiInsetsHelper", "insets change, navBarHeight: " + r0 + ", view: " + r5);
        View r7 = this.a;
        r7.setPadding(r7.getPaddingLeft(), r7.getPaddingTop(), r7.getPaddingRight(), r0);
        return r6;
    }
}
