package com.ss.android.lark.image.impl;

import com.ss.android.lark.featuregating.FeatureGatingModule;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/image/impl/AvatarMonitorExecutor;", "", "<init>", "()V", "CORE_POOL_SIZE", "", "MAX_POOL_SIZE", "QUEUE_CAPACITY", "KEEP_ALIVE_SECONDS", "", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "getExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "executor$delegate", "Lkotlin/Lazy;", "tryExecute", "", "task", "Ljava/lang/Runnable;", "isDisabled", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AvatarMonitorExecutor {
    public static final int $stable = 0;
    public static final AvatarMonitorExecutor INSTANCE = null;
    private static final Lazy executor$delegate = null;

    private AvatarMonitorExecutor() {
    }

    static {
        INSTANCE = new AvatarMonitorExecutor();
        executor$delegate = LazyKt.lazy(AvatarMonitorExecutor$executor$2.INSTANCE);
        $stable = 8;
    }

    private final ThreadPoolExecutor getExecutor() {
        return (ThreadPoolExecutor) executor$delegate.getValue();
    }

    private final boolean isDisabled() {
        return FeatureGatingModule.getFeatureGatingService().isEnable("android_image.disable_avatar_monitor_executor");
    }

    public final boolean tryExecute(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        if (isDisabled() == false) goto L6;
        return false;
    L6:
        getExecutor().execute(r100);
        return true;
    }
}
