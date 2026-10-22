package com.larus.disk.api;

import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f330525a = null;

    static {
        f330525a = LazyKt.lazy(new a());
    }

    public static boolean a() {
        if (AppHost.f326268a.isTestChannel() == true) goto L5;
        return false;
    L5:
        if (((Keva) f330525a.getValue()).getBoolean("enable_ignore_disk_clean_fluency", false) == false) goto L9;
        return true;
    L9:
        return false;
    }
}
