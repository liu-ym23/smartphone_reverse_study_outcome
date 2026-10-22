package com.bytedance.livesdk.preview.enter;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class EnterRoomManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f256427a;

    public static final class ExecuteManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lazy f256428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final EnterRoomManager f256429b;

        public ExecuteManager(EnterRoomManager r100) {
            Intrinsics.checkNotNullParameter(r100, "manager");
            this.f256429b = r100;
            this.f256428a = LazyKt.lazy(EnterRoomManager$ExecuteManager$tempProcessors$2.INSTANCE);
        }
    }

    public EnterRoomManager() {
        this.f256427a = LazyKt.lazy(EnterRoomManager$commonProcessors$2.INSTANCE);
    }
}
