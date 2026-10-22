package com.larus.home.impl.main.side_bar.feed.arch;

import com.larus.home.impl.main.side_bar.feed.SideBarFeedCardType;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Enum<?>, eb9.w> f344640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Enum<?>, Integer> f344641b;

    public w() {
        this.f344640a = new ConcurrentHashMap();
        this.f344641b = new ConcurrentHashMap();
    }

    public final void a(eb9.w r100) {
        Intrinsics.checkNotNullParameter(r100, "factory");
        this.f344640a.put(r100.getCardType(), r100);
        ConcurrentHashMap<Enum<?>, Integer> r101 = this.f344641b;
        SideBarFeedCardType r102 = r100.getCardType();
        if (r101.get(r102) != null) goto L6;
        r101.putIfAbsent(r102, Integer.valueOf(this.f344641b.size()));
        return;
    }
}
