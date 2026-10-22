package com.ivy.ivykit.plugin.impl.jsb;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class m implements ue7.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f278401a;

    public m(n r100) {
        this.f278401a = r100;
    }

    @Override // ue7.d
    public final void a(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f278401a.f278402a.sendEvent(r100, r101);
    }
}
