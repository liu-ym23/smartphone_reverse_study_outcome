package com.ss.android.lark.conditional.access.auth.v2.handler;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f417818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Set<String>, Unit> f417819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f417820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentSkipListSet<String> f417821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f417822e;

    /* JADX WARN: Multi-variable type inference failed */
    public e(long r100, Function1<? super Set<String>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "refreshCallback");
        this.f417818a = r100;
        this.f417819b = r101;
        this.f417821d = new ConcurrentSkipListSet();
    }
}
