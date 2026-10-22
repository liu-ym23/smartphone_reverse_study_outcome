package com.larus.bmhome.notification;

import com.larus.bmhome.chat.model.repo.b2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c implements com.larus.platform.api.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NotifyRedDotLifecycleObserver f313461a;

    @Override // com.larus.platform.api.b
    public final void a(com.larus.platform.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    public c(NotifyRedDotLifecycleObserver r100) {
        this.f313461a = r100;
    }

    @Override // com.larus.platform.api.b
    public final void b(com.larus.platform.api.c r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f313461a.f313418b.getClass();
        b2.f307775b.postValue(0);
    }
}
