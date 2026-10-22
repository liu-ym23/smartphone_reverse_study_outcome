package com.larus.livetutor.impl.rtc;

import com.bytedance.services.apm.api.EnsureManager;
import com.larus.livetutor.impl.utils.UtilsKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes30.dex */
public final class j0 implements Function2<Integer, String, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<Pair<Integer, String>> f356392a;

    public j0(kotlinx.coroutines.j r100) {
        this.f356392a = r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(Integer r100, String r101) {
        int r102 = r100.intValue();
        String r103 = r101;
        boolean r104 = kj9.b.f503724a;
        StringBuilder r105 = new StringBuilder("[callOnStart] success = ");
        if (r102 != 0) goto L5;
        boolean r106 = true;
    L6:
        r105.append(r106);
        kj9.b.b(r105.toString());
        kotlinx.coroutines.i<Pair<Integer, String>> r107 = this.f356392a;
        Pair r108 = TuplesKt.to(Integer.valueOf(r102), r103);
        boolean r109 = UtilsKt.f356659a;
        Intrinsics.checkNotNullParameter(r107, "<this>");
        if ((r107 instanceof kotlinx.coroutines.i) == false) goto L9;
        kotlinx.coroutines.i<Pair<Integer, String>> r110 = r107;
    L10:
        if (r110 == null) goto L12;
        boolean r111 = r110.isActive();
    L13:
        if (r111 == false) goto L23;
        r107.resumeWith(Result.m9449constructorimpl(r108));     // Catch: Throwable -> L17
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L20:
        if (Result.m9452exceptionOrNullimpl(r112) == null) goto L23;
        EnsureManager.ensureNotReachHere();
    L17:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L23:
        return Unit.INSTANCE;
    L12:
        r111 = JobKt.isActive(r107.getContext());
        goto L13
    L9:
        r110 = null;
        goto L10
    L5:
        r106 = false;
        goto L6
    }
}
