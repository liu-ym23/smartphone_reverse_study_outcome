package com.ss.android.ugc.aweme.search.common.monitor.fps;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/monitor/fps/ECSearchFpsConfig;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
final class ECSearchFpsConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f451810a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ECSearchFpsConfig f451811b = null;

    private ECSearchFpsConfig() {
    }

    static {
        f451811b = new ECSearchFpsConfig();
        f451810a = SetsKt.setOf(new String[]{"search_ec_commodity", "search_ec_photo"});
    }
}
