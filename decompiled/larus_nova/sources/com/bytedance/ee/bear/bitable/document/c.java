package com.bytedance.ee.bear.bitable.document;

import android.os.Bundle;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements com.bytedance.ee.bear.container.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkedDocxContainerFragment f211110a;

    @Override // com.bytedance.ee.bear.container.f
    public final boolean a(String r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "argument");
        return false;
    }

    @Override // com.bytedance.ee.bear.container.f
    public final boolean w() {
        Function0<Unit> r100 = this.f211110a.f211102k;
        if (r100 == null) goto L7;
        r100.invoke();
        return true;
    L7:
        return true;
    }

    public c(LinkedDocxContainerFragment r100) {
        this.f211110a = r100;
    }
}
