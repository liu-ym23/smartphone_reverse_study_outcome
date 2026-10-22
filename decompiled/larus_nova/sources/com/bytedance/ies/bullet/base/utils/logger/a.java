package com.bytedance.ies.bullet.base.utils.logger;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f246347a;

    public a() {
        this.f246347a = new ArrayList();
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        List<b> r102 = this.f246347a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new b(r100, r101));
    }
}
