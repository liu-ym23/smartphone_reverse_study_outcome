package com.bytedance.bdp.appbase.core;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes11.dex */
public final class AppInfo implements com.bytedance.bdp.appbase.core.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f200774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f200775b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.bdp.appbase.core.a
    public final void a() {
    }

    @Override // com.bytedance.bdp.appbase.core.a
    public final void getAppId() {
    }

    @Override // com.bytedance.bdp.appbase.core.a
    public final void getMetaInfo() {
    }

    @Override // com.bytedance.bdp.appbase.core.a
    public int getType() {
        return 0;
    }

    public final String toString() {
        return "appId=null appName= version=(0)";
    }

    public AppInfo() {
        this.f200774a = LazyKt.lazy(AppInfo$mUniqueId$2.INSTANCE);
        this.f200775b = LazyKt.lazy(LazyThreadSafetyMode.NONE, new AppInfo$extraJsonOpt$2(this));
    }
}
