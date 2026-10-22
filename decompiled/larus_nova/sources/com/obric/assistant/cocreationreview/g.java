package com.obric.assistant.cocreationreview;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f387284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f387285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashSet<Function1<String, Unit>> f387286c;

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        LinkedHashSet<Function1<String, Unit>> r101 = this.f387286c;
        monitor-enter(r101);
        List r102 = CollectionsKt.toList(this.f387286c);     // Catch: Throwable -> L11
        monitor-exit(r101);
        int r103 = s3.f387719a;
        s3.b(this.f387285b, "changed owner=" + this.f387284a + ", reason=" + r100 + ", listeners=" + r102.size());
        Iterator r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        ((Function1) r104.next()).invoke(r100);
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.assistant.cocreationreview.f] */
    public final f b(final Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        LinkedHashSet<Function1<String, Unit>> r101 = this.f387286c;
        monitor-enter(r101);
        this.f387286c.add(r100);     // Catch: Throwable -> L8
        int r102 = this.f387286c.size();     // Catch: Throwable -> L8
        monitor-exit(r101);
        int r103 = s3.f387719a;
        s3.b(this.f387285b, "observe owner=" + this.f387284a + ", listeners=" + r102);
        return new f(this, r100);
    L8:
        th = move-exception;
        throw th;
    }

    public g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "stage");
        this.f387284a = r100;
        this.f387285b = r101;
        this.f387286c = new LinkedHashSet();
    }
}
