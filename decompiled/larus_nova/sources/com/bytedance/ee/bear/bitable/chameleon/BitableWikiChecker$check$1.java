package com.bytedance.ee.bear.bitable.chameleon;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.bitable.chameleon.BitableWikiChecker", f = "BitableWikiChecker.kt", i = {0, 1}, l = {63, 76}, m = "check", n = {WikiFolderPushPlugin.WIKI_TOKEN, "resolvedWikiInfo"}, s = {"L$0", "L$0"})
public final class BitableWikiChecker$check$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BitableWikiChecker this$0;

    public BitableWikiChecker$check$1(BitableWikiChecker r100, Continuation<? super BitableWikiChecker$check$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
