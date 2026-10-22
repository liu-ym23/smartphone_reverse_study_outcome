package com.bytedance.ies.bullet.service.sdk;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<t36.e> f248123a;

    public c() {
        this.f248123a = new ArrayList();
    }

    public final void a(e r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        ((ArrayList) this.f248123a).add(r100);
    }
}
