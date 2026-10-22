package com.bytedance.awemeopen.apps.framework.launchconfig;

import com.bytedance.awemeopen.infra.base.task.AoPool;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class LaunchConfigManager$checkLaunchConfig$1 {
    public LaunchConfigManager$checkLaunchConfig$1() {
    }

    public final void a(final h54.a r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        AoPool.g(new LaunchConfigManager$checkLaunchConfig$1$onConfigPrepareSuccess$1(r100));
    }
}
