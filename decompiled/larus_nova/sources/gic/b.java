package gic;

import com.obric.systemopt.SysPowerKit;
import com.ss.android.ttve.nativePort.TEBundle;
import com.ss.android.vesdk.lens.VEBaseRecorderLensParams;

/* JADX INFO: loaded from: classes40.dex */
public final class b extends VEBaseRecorderLensParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f481482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f481483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f481484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f481485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f481486e;

    public b() {
        this.f481482a = 15;
        this.f481483b = 0.5f;
        this.f481484c = 15;
        this.f481485d = 0.7f;
        this.f481486e = 0.8f;
        this.algorithmFlag = 34;
    }

    @Override // com.ss.android.vesdk.lens.VEBaseRecorderLensParams, com.ss.android.vesdk.algorithm.VEBaseAlgorithmParam
    public final TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setInt("BufferSize", this.f481482a);
        r100.setFloat(SysPowerKit.PWR_OVERUSE_THRESHOLD, this.f481483b);
        r100.setInt("StableFrameCount", this.f481484c);
        r100.setFloat("LowStableThreshold", this.f481485d);
        r100.setFloat("HighStableThreshold", this.f481486e);
        r100.setBool("Enable", this.enable);
        r100.setFloatArray("DeltaRotationMatrix", null);
        if (this.resultCallback == null) goto L5;
        boolean r101 = true;
    L6:
        r100.setBool("EnableResult", r101);
        return r100;
    L5:
        r101 = false;
        goto L6
    }
}
