package com.bytedance.bdp.appbase.base.log.diagnose;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes11.dex */
public final class DiagnoseSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f200595a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f200596b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f200597c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f200598d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f200599e = null;

    public DiagnoseSettings() {
    }

    static {
        f200595a = LazyKt.lazy(DiagnoseSettings$settingConfig$2.INSTANCE);
        f200596b = LazyKt.lazy(DiagnoseSettings$sharedPref$2.INSTANCE);
        f200597c = LazyKt.lazy(DiagnoseSettings$maxLogSize$2.INSTANCE);
        f200598d = LazyKt.lazy(DiagnoseSettings$expireTime$2.INSTANCE);
        f200599e = LazyKt.lazy(DiagnoseSettings$enable$2.INSTANCE);
    }
}
