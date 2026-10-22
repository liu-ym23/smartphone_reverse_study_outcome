package com.larus.bmhome.chat.manager;

import com.larus.bmhome.actionbar.model.ReplyOption;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a0 implements Function1<wc9.e, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wc9.e f306692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReplyOption f306693b;

    public a0(wc9.e r100, ReplyOption r101) {
        this.f306692a = r100;
        this.f306693b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(wc9.e r100) {
        wc9.e r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "createdConversation");
        tx9.h0.c(r101.f559198a, this.f306692a.f559198a, "", this.f306693b.getModeId(), this.f306693b.getModel().getKey(), tx9.h0.g(tx9.h0.f(r101.f559215r).opt("fork_index")));
        return Unit.INSTANCE;
    }
}
