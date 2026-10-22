package com.bytedance.bdnavigationsdk;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class h implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f200013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f200014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Exception f200015c;

    public /* synthetic */ h(String r100, int r101, Exception r102) {
        this.f200013a = r100;
        this.f200014b = r101;
        this.f200015c = r102;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        String r101 = this.f200013a;
        int r102 = this.f200014b;
        Exception r103 = this.f200015c;
        w r104 = (w) r100;
        Intrinsics.checkNotNullParameter(r104, "listener");
        r104.k(new com.bytedance.bdnavigationsdk.navigation.x(r101, r102, null, r103, 4));
        return Unit.INSTANCE;
    }
}
