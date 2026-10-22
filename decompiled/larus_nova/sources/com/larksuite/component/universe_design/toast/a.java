package com.larksuite.component.universe_design.toast;

import com.ss.android.lark.compose.foundation.toast.FlowToast;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements FlowToast.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UDToast.b f285430a;

    public a(UDToast.b r100) {
        this.f285430a = r100;
    }

    @Override // com.larksuite.component.universe_design.toast.UDToast.b
    public final void a(com.ss.android.lark.compose.foundation.toast.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toast");
        this.f285430a.a(r100);
    }
}
