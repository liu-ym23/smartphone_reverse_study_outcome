package com.bytedance.forest.model;

import com.bytedance.forest.pollyfill.NetWorker;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NetWorker f244330a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f244331b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f244332c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<FetcherType> f244333d = null;

    static {
        f244330a = NetWorker.TTNet;
        f244331b = true;
        f244332c = 20000;
        f244333d = CollectionsKt.listOf(new FetcherType[]{FetcherType.f244229d, FetcherType.f244230e, FetcherType.f244231f});
    }
}
