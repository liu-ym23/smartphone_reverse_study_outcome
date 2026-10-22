package com.obric.assistant.settings.spi;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f392392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f392393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f392394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f392395d;

    public Object a(Continuation<? super Boolean> r100) {
        return Boxing.boxBoolean(true);
    }

    public e(String r100, String r101, CharSequence r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "groupId");
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "title");
        this.f392392a = r100;
        this.f392393b = r101;
        this.f392394c = r102;
        this.f392395d = r103;
    }
}
