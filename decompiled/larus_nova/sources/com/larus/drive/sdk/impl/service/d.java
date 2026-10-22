package com.larus.drive.sdk.impl.service;

import com.larus.drive.biz.impl.view.AbsDriveListFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class d implements e89.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s79.a f341935a;

    public d() {
    }

    @Override // e89.b
    public final s79.a a() {
        return this.f341935a;
    }

    @Override // e89.b
    public final void k(AbsDriveListFragment.d r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f341935a = r100;
    }
}
