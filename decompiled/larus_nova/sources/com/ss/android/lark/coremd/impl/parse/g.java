package com.ss.android.lark.coremd.impl.parse;

import android.view.View;
import com.ss.android.lark.coremd.base.parse.z;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class g implements com.ss.android.lark.coremd.base.parse.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Class<? extends s>, com.ss.android.lark.coremd.base.parse.n.b<s>> f419892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Class<? extends View>, z<View>> f419893b;

    public g() {
        this.f419892a = new ConcurrentHashMap();
        this.f419893b = new ConcurrentHashMap();
    }

    @Override // com.ss.android.lark.coremd.base.parse.n
    public final <T extends s> com.ss.android.lark.coremd.base.parse.n.b<T> b(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Object r101 = this.f419892a.get(r100);
        if ((r101 instanceof com.ss.android.lark.coremd.base.parse.n.b) == true) goto L7;
        return null;
    L7:
        return (com.ss.android.lark.coremd.base.parse.n.b) r101;
    }

    public final void c(z<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        this.f419893b.put((Class<? extends View>) r100.b(), (z<View>) r100);
    }

    @Override // com.ss.android.lark.coremd.base.parse.n
    public final <T extends s> void a(Class<T> r100, com.ss.android.lark.coremd.base.parse.n.b<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "handler");
        this.f419892a.put(r100, r101);
    }
}
