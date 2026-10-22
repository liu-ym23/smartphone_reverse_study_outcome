package com.ss.android.lark.flow.chat.creategroup.page;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f422101a;

    public g(int r100) {
        this.f422101a = r100;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r101, "insets");
        int r102 = Math.max(r101.getInsets(WindowInsetsCompat.Type.ime()).bottom, r101.getInsets(WindowInsetsCompat.Type.systemBars()).bottom);
        int r103 = this.f422101a + r102;
        r100.setPadding(r100.getPaddingLeft(), r100.getPaddingTop(), r100.getPaddingRight(), r103);
        return r101;
    }
}
