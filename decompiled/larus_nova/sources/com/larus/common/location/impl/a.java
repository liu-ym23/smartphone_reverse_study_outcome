package com.larus.common.location.impl;

import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocationResult;
import hq9.a3;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes27.dex */
public final class a implements a3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f326327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Continuation<LocationResult> f326328b;

    public a(Ref.BooleanRef r100, SafeContinuation r101) {
        this.f326327a = r100;
        this.f326328b = r101;
    }

    @Override // hq9.a3
    public final void a(LocationResult r100, Integer r101, GeoLocationInfo r102) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Ref.BooleanRef r103 = this.f326327a;
        if (r103.element == false) goto L5;
        return;
    L5:
        r103.element = true;
        this.f326328b.resumeWith(Result.m9449constructorimpl(r100));
    }
}
