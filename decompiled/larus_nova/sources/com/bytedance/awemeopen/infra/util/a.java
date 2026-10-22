package com.bytedance.awemeopen.infra.util;

import android.content.Intent;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class a implements AoActivityResultRequest.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function3 f198958a;

    public /* synthetic */ a(Function3 r100) {
        this.f198958a = r100;
    }

    public final void a(int r100, int r101, Intent r102) {
        Function3 r103 = this.f198958a;
        Intrinsics.checkNotNullParameter(r103, "$callback");
        r103.invoke(Integer.valueOf(r100), Integer.valueOf(r101), r102);
    }
}
