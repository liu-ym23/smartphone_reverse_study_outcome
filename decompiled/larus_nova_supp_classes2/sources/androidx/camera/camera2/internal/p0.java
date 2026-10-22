package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.CameraCharacteristicsProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final /* synthetic */ class p0 implements CameraCharacteristicsProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CameraCharacteristicsCompat f381a;

    public /* synthetic */ p0(CameraCharacteristicsCompat r1) {
        this.f381a = r1;
    }

    @Override // androidx.camera.camera2.internal.compat.workaround.CameraCharacteristicsProvider
    public final Object get(CameraCharacteristics.Key r2) {
        return this.f381a.get(r2);
    }
}
