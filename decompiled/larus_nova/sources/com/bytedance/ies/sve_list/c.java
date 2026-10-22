package com.bytedance.ies.sve_list;

import com.bytedance.ies.sve_core.w;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class c extends w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f248728d;

    public abstract void g();

    @Override // com.bytedance.ies.sve_core.h
    public final void a(com.bytedance.ies.sve_core.a r100) {
        if ((r100 instanceof d) == false) goto L8;
        ((d) r100).getClass();
        if (Intrinsics.areEqual(null, this.f248728d) == false) goto L9;
        g();
        return;
    L9:
        return;
    }
}
