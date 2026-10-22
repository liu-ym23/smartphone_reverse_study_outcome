package com.ss.android.ugc.aweme.search.optimize.preload.monitor;

import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/optimize/preload/monitor/TradeSearchPreloadCacheHitMonitor;", "", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class TradeSearchPreloadCacheHitMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f453379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f453380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f453381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f453382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public StringBuilder f453383e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f453384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f453385g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f453386h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f453387i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f453388j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f453389k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f453390l;

    public TradeSearchPreloadCacheHitMonitor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f453379a = r100;
        this.f453380b = new LinkedHashSet();
        this.f453381c = new LinkedHashSet();
        this.f453383e = new StringBuilder();
        this.f453387i = ItemStyle.ITEM_STYLE_DOUBLE;
        this.f453388j = "";
    }
}
