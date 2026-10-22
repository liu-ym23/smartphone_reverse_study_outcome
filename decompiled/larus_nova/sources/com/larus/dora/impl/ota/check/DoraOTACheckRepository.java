package com.larus.dora.impl.ota.check;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraOTACheckRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraOTACheckRepository f337428a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f337429b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f337430c = null;

    public DoraOTACheckRepository() {
    }

    static {
        f337428a = new DoraOTACheckRepository();
        f337429b = LazyKt.lazy(new b());
        f337430c = LazyKt.lazy(new c());
    }

    public final Object b(String r110, String r111, String r112, String r113, String r210, String r211, String r212, String r213, boolean r214, Continuation<? super Result<e49.a>> r215) {
        if ((r215 instanceof DoraOTACheckRepository$checkUpdate$1) == false) goto L7;
        DoraOTACheckRepository$checkUpdate$1 r100 = (DoraOTACheckRepository$checkUpdate$1) r215;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DoraOTACheckRepository$checkUpdate$1 r114 = r100;
        Object r102 = r114.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r114.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
        return ((Result) r102).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        r114.label = 1;
        Object r105 = a(r110, r111, r112, r113, r210, r211, r212, r213, r214, true, r114);
        if (r105 != r103) goto L18;
        return r103;
    L18:
        return r105;
    L7:
        r100 = new DoraOTACheckRepository$checkUpdate$1(this, r215);
        goto L8
    }

    public final Object a(String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, boolean r218, boolean r219, Continuation<? super Result<e49.a>> r310) {
        if ((r310 instanceof DoraOTACheckRepository$checkUpdate$2) == false) goto L7;
        DoraOTACheckRepository$checkUpdate$2 r100 = (DoraOTACheckRepository$checkUpdate$2) r310;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L22:
        return ((Result) r102).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        g49.d.d("DoraOTACheckRepository", "checkUpdate: start isDebug=" + r218);
        if (r218 == false) goto L17;
        d r105 = (a) f337429b.getValue();
    L18:
        DoraOTACheckRepository$checkUpdate$3 r106 = new DoraOTACheckRepository$checkUpdate$3(r219, r105, r210, r211, r212, r213, r214, r215, r216, r217, null);
        r100.label = 1;
        r102 = CoroutineScopeKt.coroutineScope(r106, r100);
        if (r102 != r103) goto L22;
        return r103;
    L17:
        r105 = (DoraOTACheckFromNetworkDataSource) f337430c.getValue();
    L7:
        r100 = new DoraOTACheckRepository$checkUpdate$2(this, r310);
        goto L8
    }
}
