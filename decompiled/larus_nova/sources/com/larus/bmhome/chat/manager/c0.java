package com.larus.bmhome.chat.manager;

import android.view.View;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c0 implements Function1<com.larus.bmhome.chat.nestedmenu.c, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f306709a;

    public c0(View r100) {
        this.f306709a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(com.larus.bmhome.chat.nestedmenu.c r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        t19.s.f544207a.g(this.f306709a.getContext(), R.string.larus_infra_branch_toast_option_unavailable, false);
        return Unit.INSTANCE;
    }
}
