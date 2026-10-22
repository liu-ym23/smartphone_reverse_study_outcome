package com.bytedance.kmp.performance.platform;

import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes19.dex */
public final class s extends u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<AutoCloseable> f252809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<AutoCloseable> f252810c;

    @Override // java.lang.AutoCloseable
    public final void close() {
        AutoCloseable r100 = this.f252809b.element;
        if (r100 == null) goto L5;
        r100.close();
    L5:
        AutoCloseable r101 = this.f252810c.element;
        if (r101 == null) goto L9;
        r101.close();
        return;
    }

    public s(Ref.ObjectRef<AutoCloseable> r100, Ref.ObjectRef<AutoCloseable> r101) {
        this.f252809b = r100;
        this.f252810c = r101;
    }
}
