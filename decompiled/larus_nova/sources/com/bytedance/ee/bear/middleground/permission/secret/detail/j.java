package com.bytedance.ee.bear.middleground.permission.secret.detail;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f234092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f234093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f234094c;

    public j() {
        this(false, 7);
    }

    public j(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r101 & 2) == 0) goto L8;
        ArrayList r102 = new ArrayList();
    L9:
        Intrinsics.checkNotNullParameter(r102, "children");
        this.f234092a = r100;
        this.f234093b = r102;
        this.f234094c = 0;
        return;
    L8:
        r102 = null;
        goto L9
    }
}
