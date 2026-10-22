package androidx.camera.camera2.internal;

import androidx.camera.core.SafeCloseImageReaderProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final /* synthetic */ class v3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SafeCloseImageReaderProxy f438a;

    public /* synthetic */ v3(SafeCloseImageReaderProxy r1) {
        this.f438a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f438a.safeClose();
    }
}
