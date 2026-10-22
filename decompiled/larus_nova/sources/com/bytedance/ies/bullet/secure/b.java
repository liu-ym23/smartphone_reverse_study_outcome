package com.bytedance.ies.bullet.secure;

import com.bytedance.ies.bullet.service.base.ResourceFrom;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f247753a = null;

    static {
        int[] r100 = new int[ResourceFrom.values().length];
        r100[ResourceFrom.CDN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r100[ResourceFrom.GECKO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        f247753a = r100;
    }
}
