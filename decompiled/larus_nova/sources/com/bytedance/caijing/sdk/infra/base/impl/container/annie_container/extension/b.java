package com.bytedance.caijing.sdk.infra.base.impl.container.annie_container.extension;

import cd4.p;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements gd4.b, p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f202407a;

    public b() {
    }

    @Override // gd4.b
    public final void d() {
        this.f202407a = true;
    }

    @Override // cd4.p, com.android.ttcjpaysdk.base.framework.container.abs.IRelease
    public final void release() {
        throw null;
    }

    @Override // gd4.b
    public final boolean e() {
        return this.f202407a;
    }
}
