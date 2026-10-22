package com.ss.android.ugc.aweme.search.optimize.preload.monitor;

import com.obric.miniapp.alarm.AlarmSessionType;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/optimize/preload/monitor/SearchPreloadForecastMonitorMob;", "", "Companion", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class SearchPreloadForecastMonitorMob {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f453372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f453373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f453374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet<PreloadConfigHitStatus> f453375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashSet<Set<PreloadConfigHitStatus>> f453376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashSet<Set<PreloadConfigHitStatus>> f453377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f453378g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/optimize/preload/monitor/SearchPreloadForecastMonitorMob$Companion;", "", "()V", AlarmSessionType.EVENT, "", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public SearchPreloadForecastMonitorMob(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "keyword");
        Intrinsics.checkNotNullParameter(r101, "searchSource");
        Intrinsics.checkNotNullParameter(r102, "scene");
        this.f453372a = r100;
        this.f453373b = r101;
        this.f453374c = r102;
        this.f453375d = new HashSet();
        this.f453376e = new HashSet();
        this.f453377f = new HashSet();
    }
}
