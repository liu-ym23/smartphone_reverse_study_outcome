package eq7;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements gq7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<List<Long>> f473501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<List<Long>> f473502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f473503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f473504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f473505e;

    public final String toString() {
        return "CpuIdleTimeStatInfo{stateTimeLists=" + this.f473501a + ", stateDeltaTimeLists=" + this.f473502b + ", totalCpuIdleTime=" + this.f473503c + ", deltaCpuIdleTime=" + this.f473504d + ", mergedDeltaCpuIdleTime=" + this.f473505e + '}';
    }

    public a() {
        this.f473501a = new ArrayList();
        this.f473502b = new ArrayList();
        this.f473503c = 0;
        this.f473504d = 0;
        this.f473505e = 0;
    }
}
