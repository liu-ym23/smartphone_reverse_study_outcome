package com.obric.assistant.chat.component.interaction;

import com.larus.bmhome.chat.component.cvs.y;
import com.larus.im.bean.bot.BotModel;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class l implements y.a<BotModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f386878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<BotModel> f386879b;

    @Override // com.larus.bmhome.chat.component.cvs.y.a
    public final void c(BotModel r100) {
        BotModel r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "new");
        this.f386878a.lQ(this);
        if (this.f386879b.isActive() == false) goto L6;
        this.f386879b.resumeWith(Result.m9449constructorimpl(r101));
        return;
    }

    public l(y r100, kotlinx.coroutines.j r101) {
        this.f386878a = r100;
        this.f386879b = r101;
    }
}
