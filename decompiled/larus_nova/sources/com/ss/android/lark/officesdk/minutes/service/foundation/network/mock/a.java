package com.ss.android.lark.officesdk.minutes.service.foundation.network.mock;

import com.ss.android.lark.pb.improto.Command;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements com.ss.android.lark.officesdk.minutes.service.foundation.network.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.network.a f433939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f433940b;

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.a
    public final void c(Command r100) {
        Intrinsics.checkNotNullParameter(r100, "command");
        g r101 = this.f433940b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "command");
        if (r101.d("server_push", r100.getName()) == true) goto L6;
        this.f433939a.c(r100);
        return;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.a
    public final void d(com.bytedance.lark.pb.basic.v1.Command r100) {
        Intrinsics.checkNotNullParameter(r100, "command");
        g r101 = this.f433940b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "command");
        if (r101.d("client_push", r100.getName()) == true) goto L6;
        this.f433939a.d(r100);
        return;
    }

    public a(com.ss.android.lark.officesdk.minutes.service.foundation.network.core.e r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "real");
        Intrinsics.checkNotNullParameter(r101, "mockEngine");
        this.f433939a = r100;
        this.f433940b = r101;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.a
    public final <R> d1<R> a(Command r100, Class<R> r101) {
        Intrinsics.checkNotNullParameter(r100, "command");
        Intrinsics.checkNotNullParameter(r101, "respType");
        g r102 = this.f433940b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "command");
        Intrinsics.checkNotNullParameter(r101, "respType");
        r100.getName();
        r102.a();
        return this.f433939a.a(r100, r101);
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.network.a
    public final <R> d1<R> b(com.bytedance.lark.pb.basic.v1.Command r100, Class<R> r101) {
        Intrinsics.checkNotNullParameter(r100, "command");
        Intrinsics.checkNotNullParameter(r101, "respType");
        g r102 = this.f433940b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "command");
        Intrinsics.checkNotNullParameter(r101, "respType");
        r100.getName();
        r102.a();
        return this.f433939a.b(r100, r101);
    }
}
