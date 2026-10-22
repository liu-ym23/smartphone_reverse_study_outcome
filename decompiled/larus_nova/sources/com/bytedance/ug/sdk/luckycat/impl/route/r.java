package com.bytedance.ug.sdk.luckycat.impl.route;

/* JADX INFO: loaded from: classes22.dex */
public final class r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f271467e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f271468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f271469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f271470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f271471d;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "SchemaProxyPendingSettingsConfig(minTriggerStaticSettingsInterval=" + this.f271468a + ", proxyPendingMs=" + this.f271469b + ", proxyPendingMsForDogNotInit=" + this.f271470c + ", enablePendingProxy=" + this.f271471d + ')';
    }

    public r() {
        this.f271468a = 300000;
        this.f271469b = 5000;
        this.f271470c = 5000;
        this.f271471d = 1;
    }
}
