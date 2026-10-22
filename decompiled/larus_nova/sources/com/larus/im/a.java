package com.larus.im;

import gd9.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f346406a = 0;

    static {
    }

    public static o a() {
        if (com.larus.im.internal.d.f347913a == null) goto L5;
    L9:
        o r100 = com.larus.im.internal.d.f347913a;
        Intrinsics.checkNotNull(r100);
        return r100;
    L5:
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == false) goto L9;
        throw new IllegalStateException("av sdk not init");
    }
}
