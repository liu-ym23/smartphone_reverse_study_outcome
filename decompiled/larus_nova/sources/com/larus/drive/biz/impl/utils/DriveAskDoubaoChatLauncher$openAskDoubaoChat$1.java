package com.larus.drive.biz.impl.utils;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.biz.impl.utils.DriveAskDoubaoChatLauncher", f = "DriveAskDoubaoChatLauncher.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {56, 61, 62, 65, 83}, m = "openAskDoubaoChat", n = {PerfLog.PARAM_KEY_CONTEXT_ID, "file", "forceTaskMode", PerfLog.PARAM_KEY_CONTEXT_ID, "file", "botId", "forceTaskMode", PerfLog.PARAM_KEY_CONTEXT_ID, "file", "botId", "botModel", "forceTaskMode", PerfLog.PARAM_KEY_CONTEXT_ID, "file", "botId", "botModel", "conversationId", "forceTaskMode"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"})
public final class DriveAskDoubaoChatLauncher$openAskDoubaoChat$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DriveAskDoubaoChatLauncher this$0;

    public DriveAskDoubaoChatLauncher$openAskDoubaoChat$1(DriveAskDoubaoChatLauncher r100, Continuation<? super DriveAskDoubaoChatLauncher$openAskDoubaoChat$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, false, this);
    }
}
