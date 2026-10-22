package com.larus.init.task;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class y0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f351474b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f351475a;

    public static final class a {
    }

    static {
        f351474b = new AtomicBoolean(false);
    }

    public y0() {
        Application r100 = AppHost.f326268a.getApplication();
        Intrinsics.checkNotNullParameter(r100, "application");
        this.f351475a = r100;
    }
}
