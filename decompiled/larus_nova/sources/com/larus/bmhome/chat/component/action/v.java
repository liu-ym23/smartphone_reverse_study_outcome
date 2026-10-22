package com.larus.bmhome.chat.component.action;

import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class v implements Function2<BotModel, BotModel, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f297918a = null;

    static {
        f297918a = new v();
    }

    public v() {
    }

    @Override // kotlin.jvm.functions.Function2
    public final Boolean invoke(BotModel r100, BotModel r101) {
        BotModel r102 = r100;
        BotModel r103 = r101;
        String r104 = null;
        if (r102 == null) goto L5;
        String r105 = r102.getBotId();
    L6:
        if (r103 == null) goto L9;
        r104 = r103.getBotId();
    L9:
        return Boolean.valueOf(Intrinsics.areEqual(r105, r104));
    L5:
        r105 = null;
        goto L6
    }
}
