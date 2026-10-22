package com.ss.android.ugc.aweme.discover.commodity.marketing.bridge.popup;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/popup/SearchSession;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<String, PopupCandidate> f450334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f450335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f450336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f450337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f450338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f450339f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f450340g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f450341h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f450342i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f450343j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f450344k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f450345l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f450346m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f450347n;

    public SearchSession(String r100, long r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "searchId");
        this.f450345l = r100;
        this.f450346m = r101;
        this.f450347n = r102;
        this.f450334a = new LinkedHashMap();
        this.f450342i = -1;
        this.f450343j = -1;
    }
}
