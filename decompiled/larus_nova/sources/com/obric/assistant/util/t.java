package com.obric.assistant.util;

import com.obric.assistant.state.api.v2.core.IObricStateDispatcherService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f393840a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f393841b = null;

    static {
        f393840a = new Object();
        f393841b = new LinkedHashSet();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "ownerId");
        Object r101 = f393840a;
        monitor-enter(r101);
        Set<String> r102 = f393841b;     // Catch: Throwable -> L16
        if (r102.remove(r100) == false) goto L9;
        if (r102.isEmpty() == false) goto L9;
        boolean r103 = true;
    L10:
        monitor-exit(r101);
        if (r103 == false) goto L21;
        IObricStateDispatcherService r104 = (IObricStateDispatcherService) ServiceManager.get().getService(IObricStateDispatcherService.class);
        if (r104 == null) goto L22;
        r104.k();
        return;
    L22:
        return;
    L21:
        return;
    L9:
        r103 = false;
    L16:
        th = move-exception;
        throw th;
    }
}
