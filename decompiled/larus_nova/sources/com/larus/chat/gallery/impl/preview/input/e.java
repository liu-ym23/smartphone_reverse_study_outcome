package com.larus.chat.gallery.impl.preview.input;

import com.larus.im.bean.bot.BotModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f324370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BotModel f324371b;

    public /* synthetic */ e(g r100, BotModel r101) {
        this.f324370a = r100;
        this.f324371b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g r100 = this.f324370a;
        BotModel r101 = this.f324371b;
        Function1<? super BotModel, Unit> r102 = r100.f324377d;
        if (r102 == null) goto L6;
        r102.invoke(r101);
        return;
    }
}
