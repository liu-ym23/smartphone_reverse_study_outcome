package com.bytedance.ee.bear.onboarding;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f236164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f236165b;

    public final void a() {
        if (Intrinsics.areEqual((k) ((LinkedList) this.f236164a.f236156a).peekFirst(), this.f236165b) == false) goto L6;
        StringBuilder r100 = new StringBuilder("[");
        String r101 = f.f236155h;
        r100.append(f.f236155h);
        r100.append("]Pending Task out of date : ");
        r100.append(this.f236165b.f236166b);
        tt5.a.b("OnBoardingManager", r100.toString());
        ((LinkedList) this.f236164a.f236156a).removeFirst();
        this.f236164a.b();
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public g(f r100, i r101) {
        this.f236164a = r100;
        this.f236165b = r101;
    }
}
