package com.larus.home.impl.sdk;

import android.os.Bundle;
import com.larus.platform.api.y4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class j0 implements n38.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y4 f346190a;

    public j0(y4 r100) {
        this.f346190a = r100;
    }

    @Override // n38.l
    public final void a(String r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        this.f346190a.a(r100, r101);
    }

    @Override // n38.l
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "errorMsg");
        this.f346190a.onFailure(r100, r101);
    }
}
