package com.obric.assistant.settings.autogui;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.autogui.ObricAutoGuiSettingsImpl", f = "ObricAutoGuiSettingsImpl.kt", i = {0, 0, 0, 0, 0, 0}, l = {325}, m = "getAutoActionAppBlacklistFromCloudAndOs", n = {"this_$iv", "methodName$iv", "accountScope", "appScopeConfig", "startTime$iv", "success$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "I$0"})
public final class ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromCloudAndOs$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricAutoGuiSettingsImpl this$0;

    public ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromCloudAndOs$1(ObricAutoGuiSettingsImpl r100, Continuation<? super ObricAutoGuiSettingsImpl$getAutoActionAppBlacklistFromCloudAndOs$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(this);
    }
}
