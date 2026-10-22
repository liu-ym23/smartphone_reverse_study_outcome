package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model;

import com.ss.bduploader.BDVideoUploaderBase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy$BaseSearchStrategy", f = "UserSearchAndMatchStrategy.kt", i = {0, 1}, l = {BDVideoUploaderBase.KeyIsSkipCode2ndFileSize, BDVideoUploaderBase.KeyIsDynamicSliceNormalSize}, m = "awaitFinish$suspendImpl", n = {"$this", "$this"}, s = {"L$0", "L$0"})
public final class UserSearchAndMatchStrategy$BaseSearchStrategy$awaitFinish$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserSearchAndMatchStrategy.BaseSearchStrategy this$0;

    public UserSearchAndMatchStrategy$BaseSearchStrategy$awaitFinish$1(UserSearchAndMatchStrategy.BaseSearchStrategy r100, Continuation<? super UserSearchAndMatchStrategy$BaseSearchStrategy$awaitFinish$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return UserSearchAndMatchStrategy.BaseSearchStrategy.e(this.this$0, this);
    }
}
