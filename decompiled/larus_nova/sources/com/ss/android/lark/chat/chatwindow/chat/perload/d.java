package com.ss.android.lark.chat.chatwindow.chat.perload;

import kotlin.jvm.internal.Intrinsics;
import u3b.a;
import u3b.e;

/* JADX INFO: loaded from: classes35.dex */
public final class d<Task extends u3b.a, DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<Task> f413468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.chat.chatwindow.chat.perload.loader.c<Task, e<DATA>> f413469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t3b.e<Task> f413470c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f413468a, r101.f413468a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f413469b, r101.f413469b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f413470c, r101.f413470c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f413468a.hashCode() * 31) + this.f413469b.hashCode()) * 31;
        t3b.e<Task> r101 = this.f413470c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "DataPreLoaderHolder(taskClass=" + this.f413468a + ", loader=" + this.f413469b + ", keyProvider=" + this.f413470c + ')';
    }

    public d(Class r100, f6b.c r101, f6b.a r102) {
        Intrinsics.checkNotNullParameter(r100, "taskClass");
        Intrinsics.checkNotNullParameter(r101, "loader");
        this.f413468a = r100;
        this.f413469b = r101;
        this.f413470c = r102;
    }
}
