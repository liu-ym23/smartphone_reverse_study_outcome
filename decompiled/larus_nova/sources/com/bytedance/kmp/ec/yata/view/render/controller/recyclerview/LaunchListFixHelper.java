package com.bytedance.kmp.ec.yata.view.render.controller.recyclerview;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class LaunchListFixHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.view.c f251895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f251896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque<Function0<Unit>> f251897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f251898d;

    public final void a() {
        com.bytedance.kmp.ec.yata.view.c r100 = this.f251895a;
        if (r100.f251835r == false) goto L5;
        return;
    L5:
        this.f251898d = true;
        r100.f251825h.a(new LaunchListFixHelper$knockTask$1(this));
    }

    public LaunchListFixHelper(com.bytedance.kmp.ec.yata.view.c r100) {
        Intrinsics.checkNotNullParameter(r100, "viewWrapper");
        this.f251895a = r100;
        this.f251897c = new ArrayDeque();
    }
}
