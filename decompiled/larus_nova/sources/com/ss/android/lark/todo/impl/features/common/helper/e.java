package com.ss.android.lark.todo.impl.features.common.helper;

import android.view.View;
import com.larksuite.component.universe_design.toast.UDToast;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements UDToast.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f442451a;

    public e(View.OnClickListener r100) {
        this.f442451a = r100;
    }

    @Override // com.larksuite.component.universe_design.toast.UDToast.b
    public final void a(com.ss.android.lark.compose.foundation.toast.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toast");
        this.f442451a.onClick(null);
        r100.cancel();
    }
}
