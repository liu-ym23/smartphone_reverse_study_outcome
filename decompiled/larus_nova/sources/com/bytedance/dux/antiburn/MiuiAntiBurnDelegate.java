package com.bytedance.dux.antiburn;

import android.view.View;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class MiuiAntiBurnDelegate implements IAntiBurn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f204802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f204803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f204804c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.dux.antiburn.IAntiBurn
    public final void onDetachedFromWindow() {
    }

    @Override // com.bytedance.dux.antiburn.IAntiBurn
    public final boolean getScreenAntiBurnEnabled() {
        return this.f204803b;
    }

    public MiuiAntiBurnDelegate(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f204802a = r100;
        this.f204804c = LazyKt.lazy(new MiuiAntiBurnDelegate$name$2(this));
    }

    @Override // com.bytedance.dux.antiburn.IAntiBurn
    public final void setScreenAntiBurnEnabled(boolean r100) {
        this.f204803b = r100;
    }
}
