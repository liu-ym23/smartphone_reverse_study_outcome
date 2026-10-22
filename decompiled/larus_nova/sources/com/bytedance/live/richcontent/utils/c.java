package com.bytedance.live.richcontent.utils;

import com.bytedance.live.richcontent.ResourceInfo;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import ik6.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ck6.a f255805a;

    public c(ck6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "logger");
        this.f255805a = r100;
    }

    public final void c(ek6.b r100) {
        Intrinsics.checkNotNullParameter(r100, "resource");
        this.f255805a.a();
    }

    public final void d(ek6.b r100) {
        Intrinsics.checkNotNullParameter(r100, "resource");
        this.f255805a.a();
    }

    public final void e(d r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "rendItem");
        Intrinsics.checkNotNullParameter(r101, "rendType");
        this.f255805a.a();
    }

    public final void f(ResourceInfo r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "resource");
        this.f255805a.error("onUpdateResourceStateFailed, resource is " + r100.f255740a + ", current state is " + r100.f255742c + ", update state is " + r101, null);
    }

    public final void b(ek6.b r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "resource");
        this.f255805a.error("onResourceLoadFailed, currentThread is " + ThreadMethodProxy.currentThread() + ", resource is " + r100 + ", error msg is " + r101, r102);
    }

    public final void a(d r100, ek6.d r101, String r102, Throwable r103) {
        Intrinsics.checkNotNullParameter(r100, "rendItem");
        this.f255805a.error("onContentSpanRendFailed, currentThread is " + ThreadMethodProxy.currentThread() + ", text is " + r100.f490271c + ", content is " + r101 + ", error msg is " + r102, r103);
    }
}
