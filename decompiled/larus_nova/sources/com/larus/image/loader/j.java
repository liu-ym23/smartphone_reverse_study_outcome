package com.larus.image.loader;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PThreadPoolExecutor f350978a = null;

    static {
        f350978a = new PThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("ImageLoadReporter"));
    }

    public static void a(String r100, String r101) {
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        h r103 = new h();
        r103.f350970a = 1;
        r103.f350975f = r100;
        Intrinsics.checkNotNullParameter(r103, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        f350978a.execute(new i(r103));
        return;
    L12:
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
