package com.huawei.hms.push.utils.ha;

/* JADX INFO: loaded from: classes23.dex */
public class PushAnalyticsCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PushBaseAnalytics f277679a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static PushAnalyticsCenter f277680a;

        static {
            f277680a = new PushAnalyticsCenter();
        }

        public static /* synthetic */ PushAnalyticsCenter a() {
            return f277680a;
        }
    }

    public PushAnalyticsCenter() {
    }

    public static PushAnalyticsCenter getInstance() {
        return a.a();
    }

    public PushBaseAnalytics getPushAnalytics() {
        return this.f277679a;
    }

    public void register(PushBaseAnalytics r100) {
        this.f277679a = r100;
    }
}
