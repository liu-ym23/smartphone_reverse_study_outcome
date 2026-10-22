package com.bytedance.pia.core.api.resource;

import r27.a;

/* JADX INFO: loaded from: classes21.dex */
public final enum LoadFrom extends Enum<LoadFrom> {
    public static final LoadFrom Auto = null;
    public static final LoadFrom Offline = null;
    public static final LoadFrom Online = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadFrom[] f266162a = null;

    static {
        LoadFrom r100 = new LoadFrom("Offline", 0);
        Offline = r100;
        LoadFrom r101 = new LoadFrom("Online", 1);
        Online = r101;
        LoadFrom r102 = new LoadFrom("Auto", 2);
        Auto = r102;
        f266162a = new LoadFrom[]{r100, r101, r102};
    }

    public static LoadFrom[] values() {
        return (LoadFrom[]) f266162a.clone();
    }

    public static LoadFrom valueOf(String r100) {
        return (LoadFrom) a.a(LoadFrom.class, r100);
    }

    public LoadFrom(String r100, int r101) {
        super(r100, r101);
    }
}
