package com.bytedance.ee.bear.document.alert;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class u implements fp5.a.b {
    public final /* synthetic */ Ref.BooleanRef a;

    public u(Ref.BooleanRef r1) {
        this.a = r1;
    }

    public final void a(View r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "checkBox");
        this.a.element = r3;
    }
}
