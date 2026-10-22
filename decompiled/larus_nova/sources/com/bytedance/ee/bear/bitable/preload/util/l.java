package com.bytedance.ee.bear.bitable.preload.util;

import com.bytedance.ee.bear.bitable.dao.BitableDatabase;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class l<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<String> f215043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f215044b;

    public l(List<String> r100, b r101) {
        this.f215043a = r100;
        this.f215044b = r101;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((List) r100, "it");
        List<String> r101 = this.f215043a;
        b r102 = this.f215044b;
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L21;
        String r104 = (String) r103.next();
        r102.getClass();
        BitableDatabase r105 = b.b();
        if (r105 == null) goto L10;
        as4.a r106 = r105.d();
        if (r106 == null) goto L10;
        ((as4.b) r106).a(r104);
    L10:
        BitableDatabase r107 = b.b();
        if (r107 == null) goto L15;
        zr4.b r108 = r107.c();
        if (r108 == null) goto L15;
        ((zr4.c) r108).a(r104);
    L15:
        BitableDatabase r109 = b.b();
        if (r109 == null) goto L4;
        zr4.b r110 = r109.c();
        if (r110 == null) goto L4;
        ((zr4.c) r110).c(r104);
        goto L4
    L21:
        return Unit.INSTANCE;
    }
}
