package com.relax.relaxframework;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class k3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f405166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f405167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f405168c;

    public k3(Function0<Unit> r100, Function0<Unit> r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "onEnterForeground");
        Intrinsics.checkNotNullParameter(r101, "onEnterBackground");
        Intrinsics.checkNotNullParameter(r102, LiveCommonConstants.REASON_ON_DEDTROY);
        this.f405166a = r100;
        this.f405167b = r101;
        this.f405168c = r102;
    }
}
