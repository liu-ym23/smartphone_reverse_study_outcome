package com.larus.livetutor.impl.repository.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a extends l0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f356196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f356197c;

    @Override // com.larus.livetutor.impl.repository.viewmodel.l0
    public final int a() {
        return this.f356197c;
    }

    @Override // com.larus.livetutor.impl.repository.viewmodel.l0
    public final String b() {
        return this.f356196b;
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f356196b = r100;
        this.f356197c = 0;
    }
}
