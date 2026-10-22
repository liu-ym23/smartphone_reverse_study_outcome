package com.ss.android.ugc.tools.net;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class AutoRetryManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f454834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<NetworkState, NetworkState, Unit> f454835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Boolean> f454836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f454837d;

    public AutoRetryManager(Function0<Boolean> r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "retryCondition");
        Intrinsics.checkNotNullParameter(r101, "retryCallback");
        this.f454836c = r100;
        this.f454837d = r101;
        this.f454835b = new AutoRetryManager$networkChangeListener$1(this);
    }
}
