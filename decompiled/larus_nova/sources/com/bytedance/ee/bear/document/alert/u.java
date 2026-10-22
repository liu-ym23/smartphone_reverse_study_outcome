package com.bytedance.ee.bear.document.alert;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes16.dex */
public final class u implements fp5.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f218953a;

    public u(Ref.BooleanRef r100) {
        this.f218953a = r100;
    }

    @Override // fp5.a.b
    public final void a(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "checkBox");
        this.f218953a.element = r101;
    }
}
