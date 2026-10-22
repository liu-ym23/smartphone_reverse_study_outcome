package com.bytedance.android.window.shop.home;

import android.net.Uri;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public com.bytedance.android.window.shop.c a;
    public Uri b;
    public boolean c;
    public final fo.b d;
    public final zn.a<Boolean> e;
    public final zn.a<uq3.b> f;
    public final ECWindowViewModel g;

    public c(ECWindowViewModel r4) {
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        this.g = r4;
        this.d = new fo.b();
        zn.a<Boolean> r5 = new zn.a(true, 6);
        r5.setValue(Boolean.FALSE);
        Unit r2 = Unit.INSTANCE;
        this.e = r5;
        this.f = new zn.a(true, 6);
    }
}
