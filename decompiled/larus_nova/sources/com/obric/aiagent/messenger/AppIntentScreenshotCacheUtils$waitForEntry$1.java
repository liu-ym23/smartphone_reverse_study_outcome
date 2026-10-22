package com.obric.aiagent.messenger;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.AppIntentScreenshotCacheUtils", f = "AppIntentScreenshotCacheUtils.kt", i = {0, 0, 0}, l = {245}, m = "waitForEntry", n = {"messageIdKey", "questionIdKey", "deadline"}, s = {"L$0", "L$1", "J$0"})
public final class AppIntentScreenshotCacheUtils$waitForEntry$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppIntentScreenshotCacheUtils this$0;

    public AppIntentScreenshotCacheUtils$waitForEntry$1(AppIntentScreenshotCacheUtils r100, Continuation<? super AppIntentScreenshotCacheUtils$waitForEntry$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        AppIntentScreenshotCacheUtils r101 = this.this$0;
        AppIntentScreenshotCacheUtils r102 = AppIntentScreenshotCacheUtils.f384749a;
        return r101.j(null, null, this);
    }
}
