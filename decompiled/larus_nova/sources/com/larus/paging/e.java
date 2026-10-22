package com.larus.paging;

import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.larus.search.impl.global.GlobalSearchResultAdapter$Companion$diff$1;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1;

/* JADX INFO: loaded from: classes29.dex */
public final class e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DiffUtil.ItemCallback<T> f363806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ListUpdateCallback f363807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineDispatcher f363808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f363809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f363810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f363811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicInteger f363812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1 f363813h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final kotlinx.coroutines.flow.a1 f363814i;

    public e(GlobalSearchResultAdapter$Companion$diff$1 r100, AdapterListUpdateCallback r101, CoroutineDispatcher r102, CoroutineDispatcher r103) {
        Intrinsics.checkNotNullParameter(r100, "diffCallback");
        Intrinsics.checkNotNullParameter(r101, "updateCallback");
        Intrinsics.checkNotNullParameter(r102, "mainDispatcher");
        Intrinsics.checkNotNullParameter(r103, "workerDispatcher");
        this.f363806a = r100;
        this.f363807b = r101;
        this.f363808c = r103;
        d r104 = new d(this);
        this.f363809d = r104;
        c r105 = new c(this, r104, r102);
        this.f363811f = r105;
        this.f363812g = new AtomicInteger(0);
        this.f363813h = r105.f363899k;
        this.f363814i = kotlinx.coroutines.flow.e.a(r105.f363900l);
    }
}
