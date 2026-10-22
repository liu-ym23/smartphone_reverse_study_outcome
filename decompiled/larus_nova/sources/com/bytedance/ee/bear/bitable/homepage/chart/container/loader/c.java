package com.bytedance.ee.bear.bitable.homepage.chart.container.loader;

import com.lynx.tasm.LynxError;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements uqb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f212446a;

    public c(b r100) {
        this.f212446a = r100;
    }

    @Override // uqb.a
    public final void a(uqb.c r100) {
        Intrinsics.checkNotNullParameter(r100, "templateInfo");
        b r101 = this.f212446a;
        monitor-enter(r101);
        int r102 = ((ArrayList) r101.f212443f).size();     // Catch: Throwable -> L11
        Iterator<T> r103 = r101.f212443f.iterator();     // Catch: Throwable -> L11
    L6:
        if (r103.hasNext() == false) goto L8;
        ((uqb.a) r103.next()).a(r100);     // Catch: Throwable -> L11
        goto L6
    L8:
        ((ArrayList) r101.f212443f).clear();     // Catch: Throwable -> L11
        tt5.a.h("GeckoTemplateLoader", "onSuccess callback and clear, callback list size is " + r102);     // Catch: Throwable -> L11
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r101);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // uqb.a
    public final void onFailed(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        b r101 = this.f212446a;
        monitor-enter(r101);
        int r102 = ((ArrayList) r101.f212443f).size();     // Catch: Throwable -> L11
        Iterator<T> r103 = r101.f212443f.iterator();     // Catch: Throwable -> L11
    L6:
        if (r103.hasNext() == false) goto L8;
        ((uqb.a) r103.next()).onFailed(r100);     // Catch: Throwable -> L11
        goto L6
    L8:
        ((ArrayList) r101.f212443f).clear();     // Catch: Throwable -> L11
        tt5.a.d("GeckoTemplateLoader", "onFailed callback and clear, callback list size is " + r102);     // Catch: Throwable -> L11
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r101);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
