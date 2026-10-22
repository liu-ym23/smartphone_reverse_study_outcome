package com.larus.home.impl.sdk;

import com.larus.common.mssdk.api.SecurityService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b1 f346144a = null;

    static {
        f346144a = new b1();
    }

    public b1() {
    }

    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        SecurityService r101 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.z(r100);
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        SecurityService r101 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r101 == null) goto L6;
        r101.w(r100);
        return;
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        SecurityService r101 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r101 == null) goto L6;
        r101.y(r100);
        return;
    }

    public final void a(String r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        Intrinsics.checkNotNullParameter(r101, "completeCB");
        SecurityService r102 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r102 != null) goto L6;
        r101.invoke(Boolean.TRUE);
        return;
    L6:
        r102.c(r100, r101);
    }
}
