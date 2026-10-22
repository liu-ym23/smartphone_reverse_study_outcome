package com.larus.im.internal.core.conversation.bot;

import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f347567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<BotModel, BotModel> f347568b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f347567a, r101.f347567a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f347568b, r101.f347568b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f347567a.hashCode() * 31) + this.f347568b.hashCode();
    }

    public final String toString() {
        return "UpdateLocalBotRequest(botId=" + this.f347567a + ", update=" + this.f347568b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(String r100, Function1<? super BotModel, BotModel> r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        Intrinsics.checkNotNullParameter(r101, "update");
        this.f347567a = r100;
        this.f347568b = r101;
    }
}
