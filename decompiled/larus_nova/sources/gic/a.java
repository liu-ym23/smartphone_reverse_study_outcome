package gic;

import com.obric.systemopt.SysPowerKit;
import com.ss.android.ttve.nativePort.TEBundle;
import com.ss.android.vesdk.lens.VEBaseRecorderLensParams;

/* JADX INFO: loaded from: classes40.dex */
public final class a extends VEBaseRecorderLensParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f481477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f481478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f481479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f481480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f481481e;

    public a() {
        this.f481477a = 1;
        this.f481478b = 2;
        this.f481479c = 1.0f;
        this.f481480d = 1.0f;
        this.f481481e = 65.0f;
        this.algorithmFlag = 33;
    }

    @Override // com.ss.android.vesdk.lens.VEBaseRecorderLensParams, com.ss.android.vesdk.algorithm.VEBaseAlgorithmParam
    public final TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setString("ModelPath", null);
        r100.setString("KernelBinPath", null);
        r100.setInt("NumThread", this.f481478b);
        r100.setInt("BackendType", this.f481477a);
        r100.setInt("RunType", 4);
        r100.setFloat(SysPowerKit.PWR_OVERUSE_THRESHOLD, this.f481481e);
        r100.setBool("Enable", this.enable);
        r100.setFloat("Alpha", this.f481479c);
        r100.setFloat("Beta", this.f481480d);
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
