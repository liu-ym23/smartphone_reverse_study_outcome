package com.bytedance.frameworks.baselib.network.connectionclass;

/* JADX INFO: loaded from: classes19.dex */
public class CdnDeviceBandwidthSampler extends DeviceBandwidthSampler {

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final CdnDeviceBandwidthSampler f244648a = null;

        static {
            f244648a = new CdnDeviceBandwidthSampler(jx5.a.C6492a.f500866a, null);
        }
    }

    public static CdnDeviceBandwidthSampler getInstance() {
        return b.f244648a;
    }

    private CdnDeviceBandwidthSampler(jx5.a r100) {
        super(r100);
    }

    public /* synthetic */ CdnDeviceBandwidthSampler(jx5.a r100, a r101) {
        this(r100);
    }
}
