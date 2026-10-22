package com.larus.kmp.voice_setting.voice.bridge;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: classes30.dex */
public final class d implements IIMCallback<BotModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletableDeferred<BotModel> f351863a;

    @Override // com.larus.im.callback.IIMCallback
    public final boolean mustInMain() {
        return true;
    }

    public d(CompletableDeferred<BotModel> r100) {
        this.f351863a = r100;
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onFailure(IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        this.f351863a.complete(null);
    }

    @Override // com.larus.im.callback.IIMCallback
    public final void onSuccess(BotModel r100) {
        BotModel r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        this.f351863a.complete(r101);
    }
}
