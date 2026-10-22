package com.larus.common.baidunavi.impl.notification;

import android.app.UiModeManager;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f326284a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f326285b = null;

    static {
        f326284a = LazyKt.lazy(new a());
        f326285b = LazyKt.lazy(new b());
    }

    public static boolean a() {
        UiModeManager r100 = (UiModeManager) f326284a.getValue();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getNightMode() != 2) goto L7;
        return true;
    }
}
