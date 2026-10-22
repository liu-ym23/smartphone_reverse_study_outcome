package com.bytedance.dux.window.listener;

import androidx.lifecycle.Observer;
import hm4.c;
import hm4.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/dux/window/listener/WindowConfigChangeObserver;", "Landroidx/lifecycle/Observer;", "Lhm4/d;", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class WindowConfigChangeObserver implements Observer<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f205946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jm4.b f205947b;

    @Override // androidx.lifecycle.Observer
    public final void onChanged(d r100) {
        d r101 = r100;
        if (r101 == null) goto L6;
        this.f205947b.a(r101);
        return;
    }

    public WindowConfigChangeObserver(c r100, jm4.b r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f205946a = r100;
        this.f205947b = r101;
    }
}
