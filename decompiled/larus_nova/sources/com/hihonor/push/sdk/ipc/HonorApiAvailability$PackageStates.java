package com.hihonor.push.sdk.ipc;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum HonorApiAvailability$PackageStates extends Enum<HonorApiAvailability$PackageStates> {
    public static final HonorApiAvailability$PackageStates DISABLED = null;
    public static final HonorApiAvailability$PackageStates ENABLED = null;
    public static final HonorApiAvailability$PackageStates NOT_INSTALLED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HonorApiAvailability$PackageStates[] f276685a = null;

    static {
        HonorApiAvailability$PackageStates r100 = new HonorApiAvailability$PackageStates("ENABLED", 0);
        ENABLED = r100;
        HonorApiAvailability$PackageStates r101 = new HonorApiAvailability$PackageStates("DISABLED", 1);
        DISABLED = r101;
        HonorApiAvailability$PackageStates r102 = new HonorApiAvailability$PackageStates("NOT_INSTALLED", 2);
        NOT_INSTALLED = r102;
        f276685a = new HonorApiAvailability$PackageStates[]{r100, r101, r102};
    }

    public static HonorApiAvailability$PackageStates[] values() {
        return (HonorApiAvailability$PackageStates[]) f276685a.clone();
    }

    public static HonorApiAvailability$PackageStates valueOf(String r100) {
        return (HonorApiAvailability$PackageStates) a.a(HonorApiAvailability$PackageStates.class, r100);
    }

    public HonorApiAvailability$PackageStates(String r100, int r101) {
        super(r100, r101);
    }
}
