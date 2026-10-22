package com.bytedance.ee.bear.bitable.fieldedit.view.edit;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
public final class m implements fp5.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f211469a;

    public m(Ref.BooleanRef r100) {
        this.f211469a = r100;
    }

    @Override // fp5.a.b
    public final void a(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "checkBox");
        this.f211469a.element = r101;
    }
}
