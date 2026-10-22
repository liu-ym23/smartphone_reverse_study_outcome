package fr2;

import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedAudioDiagnosisType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class v0 implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final uf2.g f478546a;

    @Override // fr2.a
    public d getType() {
        ILiveWrappedAudioDiagnosisType r100 = this.f478546a.getType();
        if (r100 == null) goto L5;
        c1.f478495d.getClass();
        return c1.a.a(r100);
    L5:
        return null;
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f478546a;
    }

    public v0(uf2.g r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f478546a = r100;
    }

    @Override // fr2.a
    public final void H2(int r100) {
        this.f478546a.a();
    }

    @Override // fr2.a
    public final void J3(int r100) {
        this.f478546a.c();
    }

    @Override // fr2.a
    public final void k2(d r100) {
        uf2.g r101 = this.f478546a;
        if (r100 == null) goto L5;
        Object r102 = r100.getReal();
    L6:
        ILiveWrappedAudioDiagnosisType r103 = (ILiveWrappedAudioDiagnosisType) r102;
        r101.b();
        return;
    L5:
        r102 = null;
        goto L6
    }
}
