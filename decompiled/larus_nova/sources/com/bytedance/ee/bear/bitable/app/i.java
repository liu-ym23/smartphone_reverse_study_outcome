package com.bytedance.ee.bear.bitable.app;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bitable.app.model.AppTheme;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class i<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableAppUIContainer f206942a;

    public i(BitableAppUIContainer r100) {
        this.f206942a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        AppTheme r101 = (AppTheme) r100;
        Intrinsics.checkNotNullParameter(r101, "appTheme");
        BitableAppUIContainer r102 = this.f206942a;
        r102.t(r102.f206853o, Integer.valueOf(ColorProtector.parseColor(r101.getNavigationBgColor())));
    }
}
