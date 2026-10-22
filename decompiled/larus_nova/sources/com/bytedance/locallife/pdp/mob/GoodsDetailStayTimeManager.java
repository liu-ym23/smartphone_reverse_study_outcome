package com.bytedance.locallife.pdp.mob;

import androidx.lifecycle.LifecycleObserver;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ww6.n;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/locallife/pdp/mob/GoodsDetailStayTimeManager;", "Landroidx/lifecycle/LifecycleObserver;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class GoodsDetailStayTimeManager implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f261570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f261571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f261572c;

    public static final class a {
    }

    static {
    }

    public GoodsDetailStayTimeManager(n r100) {
        Intrinsics.checkNotNullParameter(r100, "trackManagerProvider");
        this.f261570a = r100;
    }
}
