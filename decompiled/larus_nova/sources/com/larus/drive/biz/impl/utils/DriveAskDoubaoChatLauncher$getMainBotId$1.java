package com.larus.drive.biz.impl.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.biz.impl.utils.DriveAskDoubaoChatLauncher", f = "DriveAskDoubaoChatLauncher.kt", i = {}, l = {105}, m = "getMainBotId", n = {}, s = {})
public final class DriveAskDoubaoChatLauncher$getMainBotId$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DriveAskDoubaoChatLauncher this$0;

    public DriveAskDoubaoChatLauncher$getMainBotId$1(DriveAskDoubaoChatLauncher r100, Continuation<? super DriveAskDoubaoChatLauncher$getMainBotId$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DriveAskDoubaoChatLauncher r101 = this.this$0;
        DriveAskDoubaoChatLauncher r102 = DriveAskDoubaoChatLauncher.f341249a;
        return r101.a(this);
    }
}
