package com.bytedance.apm.config;

import com.bytedance.apm.d;
import ns3.c;
import tr3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b {
    public boolean a;
    public long b;
    public boolean c;
    public long d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final com.bytedance.apm.config.a i;
    public final String j;
    public final boolean k;
    public c l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final e q;

    public static final class a {
        public boolean a;
        public long b;
        public boolean c;
        public long d;
        public boolean e;
        public boolean f;
        public boolean g;
        public boolean h;
        public String i;
        public boolean j;
        public boolean k;
        public com.bytedance.apm.config.a l;
        public c m;
        public boolean n;
        public boolean o;
        public boolean p;
        public boolean q;
        public final e r;

        public a() {
            this.g = false;
            this.k = false;
            this.a = false;
            this.b = 20000;
            this.c = false;
            this.d = 1000;
            this.r = new e();
        }
    }

    public final String toString() {
        return "ApmInitConfig{mCacheBufferCount=1000, isReportCacheException=false, mViewIdmonitorPageSwitch=" + this.a + ", mMaxValidPageLoadTimeMs=" + this.b + ", mMaxValidLaunchTimeMs=15000, mTraceListener=null, mReportEvilMethodSwitch=" + this.c + ", mEvilMethodThresholdMs=" + this.d + ", mLimitEvilMethodDepth=" + this.e + ", mFullFpsTracer=" + this.f + ", mDisableFpsTracer=false, mChangeFpsLifeCycle=false, mActivityFps=" + this.g + ", mBinderMonitor=" + this.h + ", mTraceExtraFlag=0, mTraceExtraCollectTimeMs=30000, mActivityLeakDetectConfig=" + this.i + ", mIgnoreNetMonitorUserAgentLabel='null', mProcessName='" + this.j + "', mEnableDeviceInfoOnPerfData=" + this.k + ", mLaunchConfig=" + this.l + ", mSupportMultiFrameRate=" + this.m + ", mEnableSliverDump=false, mEnableCpuAllocOpt=" + this.n + ", mEnableCloseListener=false, mEnableLooperOpt=" + this.o + ", mAlogUploadStrategy=" + this.q + '}';
    }

    public b(a r3) {
        this.a = r3.a;
        this.b = r3.b;
        this.c = r3.c;
        this.d = r3.d;
        this.e = r3.e;
        this.f = r3.f;
        this.g = r3.g;
        this.h = r3.h;
        this.j = r3.i;
        this.i = r3.l;
        this.l = r3.m;
        this.m = r3.n;
        d.b = r3.j;
        xu3.a.a = d.j();
        d.c = false;
        this.k = r3.k;
        this.q = r3.r;
        this.n = r3.o;
        this.o = r3.p;
        this.p = r3.q;
    }
}
