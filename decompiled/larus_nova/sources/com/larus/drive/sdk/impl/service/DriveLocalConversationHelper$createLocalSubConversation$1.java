package com.larus.drive.sdk.impl.service;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.service.DriveLocalConversationHelper", f = "DriveLocalConversationHelper.kt", i = {1, 1, 1, 2, 2, 2, 3}, l = {31, 37, 42, 43}, m = "createLocalSubConversation", n = {PerfLog.PARAM_KEY_CONTEXT_ID, "inputLeftActionStyle", "customSuffix", PerfLog.PARAM_KEY_CONTEXT_ID, "inputLeftActionStyle", "customSuffix", "botModel"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0"})
public final class DriveLocalConversationHelper$createLocalSubConversation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DriveLocalConversationHelper this$0;

    public DriveLocalConversationHelper$createLocalSubConversation$1(DriveLocalConversationHelper r100, Continuation<? super DriveLocalConversationHelper$createLocalSubConversation$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, this);
    }
}
