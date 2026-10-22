package com.ss.android.ugc.aweme.search.dynamic.tools.checker;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/tools/checker/SearchCardChecker;", "CardInfo", "", "<init>", "()V", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public abstract class SearchCardChecker<CardInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, ICardSnapshot<CardInfo>> f452763a;

    public SearchCardChecker() {
        this.f452763a = new ConcurrentHashMap();
    }

    public final ICardSnapshot<CardInfo> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "token");
        ConcurrentHashMap<String, ICardSnapshot<CardInfo>> r101 = this.f452763a;
        ICardSnapshot<CardInfo> r102 = r101.get(r100);
        if (r102 != null) goto L25;
        DynamicCardChecker r103 = (DynamicCardChecker) this;
        Intrinsics.checkNotNullParameter(r100, "token");
        ConcurrentHashMap<String, ICardSnapshot<CardInfo>> r104 = r103.f452763a;
        ICardSnapshot<CardInfo> r105 = r104.get(r100);
        if (r105 == null) goto L7;
    L20:
        r102 = r105;
        ICardSnapshot<CardInfo> r106 = r101.putIfAbsent(r100, r102);
        if (r106 == null) goto L25;
        r102 = r106;
        goto L25
    L7:
        if (r103.f452763a.size() <= 5) goto L16;
        Iterator r107 = CollectionsKt.sortedWith(r103.f452763a.entrySet(), new DynamicCardChecker$initSnapShot$lambda$1$$inlined$sortedBy$1()).iterator();
    L10:
        if (r103.f452763a.size() <= 5) goto L16;
        if (r107.hasNext() == false) goto L16;
        Map.Entry r108 = (Map.Entry) r107.next();
        if (((ICardSnapshot) r108.getValue()).g() == true) goto L10;
        r103.f452763a.remove(r108.getKey());
    L16:
        r105 = new DynamicCardSnapshot(r103.f452745b.getAndIncrement(), r103.f452763a);
        ICardSnapshot<CardInfo> r109 = r104.putIfAbsent(r100, r105);
        if (r109 == null) goto L20;
        r105 = r109;
    L25:
        return r102;
    }
}
