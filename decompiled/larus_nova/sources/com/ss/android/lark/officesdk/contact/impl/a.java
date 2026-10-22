package com.ss.android.lark.officesdk.contact.impl;

import com.larus.setting.api.s;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mtb.f;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements ltb.a<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ltb.a<f> f433141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f433142b;

    @Override // ltb.a
    public final void onSuccess(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f433141a.onSuccess(this.f433142b);
    }

    public a(s r100, f r101) {
        this.f433141a = r100;
        this.f433142b = r101;
    }

    @Override // ltb.a
    public final void onError(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        this.f433141a.onError(r100, r101);
    }
}
