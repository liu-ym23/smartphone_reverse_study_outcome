package com.larus.bmhome.upload.sdk.impl.engine;

import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f314868a;

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends c> r100) {
        Intrinsics.checkNotNullParameter(r100, "engines");
        this.f314868a = r100;
    }

    public final c a(is8.a r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.ROUTE);
        Iterator<T> r101 = this.f314868a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (((c) r102).a(r100) == false) goto L4;
    L10:
        return (c) r102;
    L8:
        r102 = null;
        goto L10
    }
}
