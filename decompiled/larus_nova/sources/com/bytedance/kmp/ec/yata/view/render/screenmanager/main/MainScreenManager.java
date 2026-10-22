package com.bytedance.kmp.ec.yata.view.render.screenmanager.main;

import com.bytedance.kmp.ec.yata.view.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class MainScreenManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f252033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f252034b;

    public MainScreenManager(c r100) {
        Intrinsics.checkNotNullParameter(r100, "viewWrapper");
        this.f252033a = r100;
        this.f252034b = LazyKt.lazy(new MainScreenManager$renderTreeManager$2(this));
    }
}
