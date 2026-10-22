package com.larus.uaigc.createpage.component.digitalavatar;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager", f = "DigitalAvatarInfoManager.kt", i = {}, l = {72}, m = "fetchWhiteTUrl", n = {}, s = {})
public final class DigitalAvatarInfoManager$fetchWhiteTUrl$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DigitalAvatarInfoManager this$0;

    public DigitalAvatarInfoManager$fetchWhiteTUrl$1(DigitalAvatarInfoManager r100, Continuation<? super DigitalAvatarInfoManager$fetchWhiteTUrl$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
