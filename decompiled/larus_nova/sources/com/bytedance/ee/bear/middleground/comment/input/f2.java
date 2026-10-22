package com.bytedance.ee.bear.middleground.comment.input;

import com.bytedance.ee.bear.middleground.comment.export.Action;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b2 f231939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f231940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Action f231941c;

    public f2(b2 r100, String r101, Action r102) {
        this.f231939a = r100;
        this.f231940b = r101;
        this.f231941c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.ee.bear.middleground.comment.control.t r100 = this.f231939a.f231905d;     // Catch: Throwable -> L4
        String r101 = this.f231940b;     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L4
        r100.w(r101, this.f231941c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
