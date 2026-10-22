package com.bytedance.live.datacontext;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewModelProvider f255103a;

    public final <T extends DataContext> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "cls");
        return (T) this.f255103a.get(r100);
    }

    public w(Fragment r100, Function1<? super Class<?>, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        if (r101 != null) goto L5;
        ViewModelProvider r102 = ViewModelProviders.of(r100);
    L6:
        this.f255103a = r102;
        return;
    L5:
        r102 = ViewModelProviders.of(r100, new g(r101));
        goto L6
    }
}
