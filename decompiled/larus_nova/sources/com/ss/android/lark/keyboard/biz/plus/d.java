package com.ss.android.lark.keyboard.biz.plus;

import com.ss.android.socialbase.appdownloader.ah.DevicePlans;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T> f428503a = null;

    static {
        f428503a = new d();
    }

    public d() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        d5b.a r102 = (d5b.a) r100;
        d5b.a r103 = (d5b.a) r101;
        Intrinsics.checkNotNullParameter(r102, DevicePlans.DEVICE_PLAN_OPPO1);
        Intrinsics.checkNotNullParameter(r103, DevicePlans.DEVICE_PLAN_OPPO2);
        return r102.e() - r103.e();
    }
}
