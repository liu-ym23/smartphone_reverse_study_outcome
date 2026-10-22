package com.bytedance.ee.bear.bitable.preload.util;

import com.bytedance.ee.bear.bitable.dao.BitableDatabase;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class i<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f215040a;

    public i(b r100) {
        this.f215040a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        this.f215040a.getClass();
        BitableDatabase r102 = b.b();
        if (r102 == null) goto L7;
        as4.a r103 = r102.d();
        if (r103 == null) goto L7;
        ((as4.b) r103).a(r101);
    L7:
        this.f215040a.getClass();
        BitableDatabase r104 = b.b();
        if (r104 == null) goto L12;
        zr4.b r105 = r104.c();
        if (r105 == null) goto L12;
        ((zr4.c) r105).a(r101);
    L12:
        this.f215040a.getClass();
        BitableDatabase r106 = b.b();
        if (r106 == null) goto L17;
        zr4.b r107 = r106.c();
        if (r107 == null) goto L17;
        return Integer.valueOf(((zr4.c) r107).c(r101));
    L17:
        return null;
    }
}
