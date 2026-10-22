package com.larus.settings.protector;

import com.larus.common.apphost.AppHost;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes4.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f368556a = null;

    static {
        f368556a = LazyKt.lazy(new c());
    }

    public static boolean a(boolean r100) {
        if (xg9.b.a().getBoolean("tt_protector_enable_in_test_channel", false) == true) goto L12;
        if (r100 == true) goto L7;
    L9:
        return false;
    L7:
        if (AppHost.f326268a.isTestChannel() == true) goto L9;
        return true;
    L12:
        return r100;
    }
}
