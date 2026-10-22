package com.larus.home.impl.main.side_bar.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.main.side_bar.data.SideBarPreloadManager", f = "SideBarPreloadManager.kt", i = {0}, l = {38}, m = "preloadData", n = {"configModel"}, s = {"L$0"})
public final class SideBarPreloadManager$preloadData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SideBarPreloadManager this$0;

    public SideBarPreloadManager$preloadData$1(SideBarPreloadManager r100, Continuation<? super SideBarPreloadManager$preloadData$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
