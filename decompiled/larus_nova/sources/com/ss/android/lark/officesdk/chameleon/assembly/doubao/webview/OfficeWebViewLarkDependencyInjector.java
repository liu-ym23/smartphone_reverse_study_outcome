package com.ss.android.lark.officesdk.chameleon.assembly.doubao.webview;

import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officesdk.di.core.DependencyContextUniqueId;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeWebViewLarkDependencyInjector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f433133a = null;

    static {
        f433133a = new AtomicBoolean(false);
    }

    public static void a() {
        AtomicBoolean r100 = f433133a;
        if (r100.get() == false) goto L5;
        return;
    L5:
        DependencyContainer.f433166a.b(DependencyContextUniqueId.OfficeWebView, OfficeWebViewLarkDependencyInjector$inject$1.INSTANCE);
        r100.set(true);
    }
}
