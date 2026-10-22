package com.bytedance.kmp.ec.yata.view.render.controller.recyclerview;

import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ListUpdateCallback f251958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AsyncDifferConfig<T> f251959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LaunchListFixHelper f251960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<? extends T> f251961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<? extends T> f251962e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<? extends T> f251963f;

    public h(com.bytedance.kmp.ec.yata.view.c r100, RecyclerView.Adapter r101, BodyAdapter$itemCallback$1 r102) {
        Intrinsics.checkNotNullParameter(r100, "viewWrapper");
        Intrinsics.checkNotNullParameter(r101, "adapter");
        Intrinsics.checkNotNullParameter(r102, "diffCallback");
        AdapterListUpdateCallback r103 = new AdapterListUpdateCallback(r101);
        AsyncDifferConfig<T> r104 = new AsyncDifferConfig.Builder(r102).build();
        Intrinsics.checkNotNullParameter(r100, "viewWrapper");
        Intrinsics.checkNotNullParameter(r103, "mUpdateCallback");
        Intrinsics.checkNotNullParameter(r104, "mConfig");
        this.f251958a = r103;
        this.f251959b = r104;
        this.f251960c = new LaunchListFixHelper(r100);
        this.f251962e = CollectionsKt.emptyList();
        this.f251963f = CollectionsKt.emptyList();
    }
}
