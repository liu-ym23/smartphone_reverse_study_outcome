package com.bytedance.android.livesdk.ktvimpl.mv;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o<V> implements Callable {
    public final /* synthetic */ MvServiceImpl a;
    public final /* synthetic */ String b;

    public o(MvServiceImpl r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        MvServiceImpl r0 = this.a;
        String r1 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "dirPath");
        PolarisFileWrapper r2 = new PolarisFileWrapper(r1);
        if (r2.isDirectory() == false) goto L24;
        File[] r3 = r2.listFiles();
        if (r3 == null) goto L31;
        List r4 = ArraysKt.toList(r3);
        if (r4 != null) goto L10;
        return;
    L10:
        if (r4.isEmpty() == false) goto L12;
        return;
    L12:
        if (r4.size() < 8) goto L34;
        List r5 = r4;
        List r6 = CollectionsKt.take(CollectionsKt.sortedWith(r5, new r()), 5);
        ArrayList r7 = new ArrayList();
        Iterator r8 = r5.iterator();
    L16:
        if (r8.hasNext() == false) goto L20;
        Object r9 = r8.next();
        if ((!r6.contains((File) r9)) == false) goto L16;
        r7.add(r9);
        goto L16
    L20:
        Iterator r10 = r7.iterator();
    L22:
        if (r10.hasNext() == false) goto L35;
        ((File) r10.next()).delete();
        goto L22
    L35:
        return;
    L34:
        return;
    L31:
        return;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
