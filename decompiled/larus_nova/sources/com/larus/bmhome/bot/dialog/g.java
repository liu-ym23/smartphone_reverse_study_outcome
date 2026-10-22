package com.larus.bmhome.bot.dialog;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class g implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f296577a;

    public /* synthetic */ g(Function0 r100) {
        this.f296577a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        Function0 r101 = this.f296577a;
        boolean r102 = ((Boolean) r100).booleanValue();
        int r103 = BotAvatarViewerDialog.f296549y;
        if (r102 == false) goto L6;
        r101.invoke();
    L6:
        return Unit.INSTANCE;
    }
}
