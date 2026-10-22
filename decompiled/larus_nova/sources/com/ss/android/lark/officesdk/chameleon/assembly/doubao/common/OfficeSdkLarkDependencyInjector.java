package com.ss.android.lark.officesdk.chameleon.assembly.doubao.common;

import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSdkLarkDependencyInjector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f433125a = null;

    static {
        f433125a = new AtomicBoolean(false);
    }

    public static void a() {
        AtomicBoolean r100 = f433125a;
        if (r100.get() == false) goto L5;
        return;
    L5:
        DependencyContainer.f433166a.b(null, OfficeSdkLarkDependencyInjector$inject$1.INSTANCE);
        r100.set(true);
    }
}
