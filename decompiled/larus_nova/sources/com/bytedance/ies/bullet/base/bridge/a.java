package com.bytedance.ies.bullet.base.bridge;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements com.bytedance.ies.web.jsbridge2.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.bullet.service.base.o f246279a;

    public a(com.bytedance.ies.bullet.service.base.o r100) {
        this.f246279a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.h
    public final <T> void a(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f246279a.sendEvent(r100, r101);
    }
}
