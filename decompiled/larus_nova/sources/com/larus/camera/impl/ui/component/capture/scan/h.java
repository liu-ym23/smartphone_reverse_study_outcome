package com.larus.camera.impl.ui.component.capture.scan;

import android.view.ViewGroup;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.ui.component.capture.CaptureTitleComponent;
import com.larus.utils.i0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h extends CaptureTitleComponent {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<String> f322034n;

    public h() {
        List<String> r100 = fx8.a.f479110a;
        this.f322034n = fx8.a.f479111b;
    }

    @Override // com.larus.camera.impl.ui.component.capture.CaptureTitleComponent, com.larus.camera.impl.ui.arch.b
    public final void m() {
        super.m();
        q(new g());
    }

    @Override // com.larus.camera.impl.ui.component.capture.CaptureTitleComponent, com.larus.camera.impl.ui.component.capture.a
    public final List<String> d() {
        return this.f322034n;
    }

    @Override // com.larus.camera.impl.ui.base.k, com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r100) {
        CameraContainer.b r101 = super.f(r100);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        i0.f375410a.getClass();
        ((ViewGroup.MarginLayoutParams) r101).topMargin = i0.g();
        return r101;
    }
}
