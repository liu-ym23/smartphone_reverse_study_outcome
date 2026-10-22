package com.larus.im.internal.delegate;

import com.larus.im.FlowRuntime;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements gd9.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f348188b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gd9.h f348189c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gd9.h f348190a;

    static {
        f348188b = new a();
        f348189c = FlowRuntime.b().e();
    }

    public a() {
        this.f348190a = FlowRuntime.b().e();
    }

    @Override // gd9.h
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f348189c.d("FlowIMSDK_" + r100, r101);
    }

    @Override // gd9.h
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f348189c.e("FlowIMSDK_" + r100, r101);
    }

    @Override // gd9.h
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f348189c.i("FlowIMSDK_" + r100, r101);
    }

    @Override // gd9.h
    public final void v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f348189c.v("FlowIMSDK_" + r100, r101);
    }

    @Override // gd9.h
    public final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f348189c.w("FlowIMSDK_" + r100, r101);
    }

    @Override // gd9.h
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f348189c.e("FlowIMSDK_" + r100, r101, r102);
    }

    @Override // gd9.h
    public final void w(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        f348189c.w("FlowIMSDK_" + r100, r101, r102);
    }
}
