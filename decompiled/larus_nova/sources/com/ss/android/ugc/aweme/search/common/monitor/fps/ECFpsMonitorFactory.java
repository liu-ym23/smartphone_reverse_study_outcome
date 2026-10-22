package com.ss.android.ugc.aweme.search.common.monitor.fps;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/monitor/fps/ECFpsMonitorFactory;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECFpsMonitorFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, ECFpsMonitor> f451787a = null;

    private ECFpsMonitorFactory() {
    }

    static {
        new ECFpsMonitorFactory();
        f451787a = new HashMap();
    }

    @JvmStatic
    public static final ECFpsMonitor a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        HashMap<String, ECFpsMonitor> r101 = f451787a;
        ECFpsMonitor r102 = r101.get(r100);
        if (r102 != null) goto L6;
        RealECFpsMonitor r103 = new RealECFpsMonitor(r100);
        r101.put(r100, r103);
        return r103;
    L6:
        return r102;
    }
}
