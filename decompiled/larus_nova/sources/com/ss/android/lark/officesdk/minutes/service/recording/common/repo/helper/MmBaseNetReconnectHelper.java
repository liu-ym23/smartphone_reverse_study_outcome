package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes37.dex */
public abstract class MmBaseNetReconnectHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i1<Boolean> f434964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f434965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f434966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f434967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Job f434968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Job f434969f;

    public abstract Object b(Continuation<? super Unit> r100);

    public abstract long c();

    public abstract long d();

    public abstract String e();

    public abstract void f();

    public final void g() {
        this.f434967d = this.f434964a.getValue().booleanValue();
        lvb.a.e(e(), "start, isNetAvailable: " + this.f434967d);
        Job r100 = this.f434968e;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f434968e = BuildersKt.launch$default(this.f434965b, null, null, new MmBaseNetReconnectHelper$start$1(this, null), 3, null);
    }

    public MmBaseNetReconnectHelper(b1 r100, CoroutineScope r101) {
        Intrinsics.checkNotNullParameter(r100, "networkAvailableFlow");
        Intrinsics.checkNotNullParameter(r101, "scope");
        this.f434964a = r100;
        this.f434965b = r101;
        this.f434966c = System.currentTimeMillis();
    }

    public static final Object a(MmBaseNetReconnectHelper r100, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof MmBaseNetReconnectHelper$performFetch$1) == false) goto L7;
        MmBaseNetReconnectHelper$performFetch$1 r101 = (MmBaseNetReconnectHelper$performFetch$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        ResultKt.throwOnFailure(r111);
    L28:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r111);
    L22:
        if (r100.f434967d == true) goto L24;
        lvb.a.e(r100.e(), "performFetch, wait over but net unavailable");
        return Unit.INSTANCE;
    L24:
        lvb.a.e(r100.e(), "performFetch, executing");
        r100.f434966c = System.currentTimeMillis();
        r101.label = 2;
        if (r100.b(r101) != r103) goto L28;
        return r103;
    L16:
        ResultKt.throwOnFailure(r111);
        long r105 = System.currentTimeMillis() - r100.f434966c;
        if (r105 >= r100.d()) goto L24;
        long r106 = r100.d() - r105;
        lvb.a.e(r100.e(), "performFetch, throttling, wait for " + r106 + " ms");
        r101.label = 1;
        if (DelayKt.delay(r106, r101) != r103) goto L22;
        return r103;
    L7:
        r101 = new MmBaseNetReconnectHelper$performFetch$1(r100, r110);
        goto L8
    }
}
