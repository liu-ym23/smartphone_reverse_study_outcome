package com.larus.gallery.tracker;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.gallery.tracker.ThumbnailListController", f = "ThumbnailListController.kt", i = {0, 0, 0}, l = {233}, m = "prefetchWindow", n = {"uniqueKey", "end", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION}, s = {"L$0", "I$0", "I$1"})
final class ThumbnailListController$prefetchWindow$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ i this$0;

    public ThumbnailListController$prefetchWindow$1(i r100, Continuation<? super ThumbnailListController$prefetchWindow$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return i.a(this.this$0, 0, 0, 0, this);
    }
}
