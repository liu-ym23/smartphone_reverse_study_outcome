package com.bytedance.live.datacontext;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class o<M> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Completable f255085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super M, Unit> f255086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Scheduler f255087c;

    public final void a(Function1<? super M, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f255086b = r100;
    }

    public o(Completable r100, Function1 r101) {
        int r102 = com.bytedance.revenue.platform.api.core.rx.p.f267522a;
        Scheduler r103 = AndroidSchedulers.mainThread();
        Intrinsics.checkNotNullParameter(r100, "onCleared");
        Intrinsics.checkNotNullParameter(r101, LiveCommonConstants.REASON_ON_DEDTROY);
        this.f255085a = r100;
        this.f255086b = r101;
        this.f255087c = r103;
    }
}
