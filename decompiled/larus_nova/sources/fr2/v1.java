package fr2;

import android.graphics.Bitmap;
import com.bytedance.live.livelink.kmp.api.core.mixer.RTCWaterMarkRegion;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class v1 implements e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RTCWaterMarkRegion f478547a;

    @Override // fr2.e0
    public final void Y0() {
        this.f478547a.f255235a = 0.0f;
    }

    @Override // fr2.e0
    public final void f1() {
        this.f478547a.f255239e = 0;
    }

    @Override // fr2.e0
    public final void d1() {
        this.f478547a.f255237c = 1.0f;
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f478547a;
    }

    public v1(RTCWaterMarkRegion r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f478547a = r100;
    }

    @Override // fr2.e0
    public final void setH(float r100) {
        this.f478547a.f255238d = r100;
    }

    @Override // fr2.e0
    public final void setY(float r100) {
        this.f478547a.f255236b = r100;
    }

    @Override // fr2.e0
    public final void x4(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f478547a.f255242h = r100;
    }
}
