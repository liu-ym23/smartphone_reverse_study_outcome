package com.bytedance.locallife.dito.core;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f257987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f257988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f257989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f257990d;

    public static final class a {
    }

    static {
    }

    public t(int r110, s r111, g r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r113 & 2) == 0) goto L9;
        s r101 = new s(false, false, 0, 0, false, false, false, false, false, 65535);
    L11:
        if ((r113 & 4) == 0) goto L13;
        g r102 = new g();
    L14:
        Intrinsics.checkNotNullParameter(r101, "halfPageParams");
        Intrinsics.checkNotNullParameter(r102, "bounceParams");
        this.f257987a = r100;
        this.f257988b = r101;
        this.f257989c = r102;
        this.f257990d = null;
        return;
    L13:
        r102 = r112;
        goto L14
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
