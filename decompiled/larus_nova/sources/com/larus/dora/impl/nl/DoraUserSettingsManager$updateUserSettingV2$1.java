package com.larus.dora.impl.nl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.nl.DoraUserSettingsManager", f = "DoraUserSettingsManager.kt", i = {0, 0}, l = {444}, m = "updateUserSettingV2", n = {"key", "value"}, s = {"L$0", "L$1"})
final class DoraUserSettingsManager$updateUserSettingV2$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraUserSettingsManager this$0;

    public DoraUserSettingsManager$updateUserSettingV2$1(DoraUserSettingsManager r100, Continuation<? super DoraUserSettingsManager$updateUserSettingV2$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return DoraUserSettingsManager.c(this.this$0, null, null, this);
    }
}
