package com.bytedance.ee.bear.bitable.core;

import androidx.fragment.app.Fragment;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Boolean, Unit> f210108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IdentityHashMap<Fragment, Boolean> f210109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<Fragment> f210110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f210111d;

    public final void a() {
        boolean r100 = !this.f210110c.isEmpty();
        if (r100 != this.f210111d) goto L5;
        return;
    L5:
        this.f210111d = r100;
        this.f210108a.invoke(Boolean.valueOf(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function1<? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onActiveChanged");
        this.f210108a = r100;
        this.f210109b = new IdentityHashMap();
        this.f210110c = Collections.newSetFromMap(new IdentityHashMap());
    }
}
