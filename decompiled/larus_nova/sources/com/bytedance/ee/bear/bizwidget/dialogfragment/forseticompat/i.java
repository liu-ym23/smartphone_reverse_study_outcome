package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class i implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f216469a;

    public i(View r100) {
        this.f216469a = r100;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r101, "insets");
        int r102 = r101.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        tt5.a.h("ForsetiInsetsHelper", "insets change, navBarHeight: " + r102 + ", view: " + r100);
        View r103 = this.f216469a;
        r103.setPadding(r103.getPaddingLeft(), r103.getPaddingTop(), r103.getPaddingRight(), r102);
        return r101;
    }
}
