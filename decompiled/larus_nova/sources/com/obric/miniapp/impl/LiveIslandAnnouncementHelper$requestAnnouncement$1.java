package com.obric.miniapp.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.impl.LiveIslandAnnouncementHelper", f = "LiveIslandAnnouncementHelper.kt", i = {}, l = {47}, m = "requestAnnouncement", n = {}, s = {})
public final class LiveIslandAnnouncementHelper$requestAnnouncement$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LiveIslandAnnouncementHelper this$0;

    public LiveIslandAnnouncementHelper$requestAnnouncement$1(LiveIslandAnnouncementHelper r100, Continuation<? super LiveIslandAnnouncementHelper$requestAnnouncement$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        LiveIslandAnnouncementHelper r101 = this.this$0;
        LiveIslandAnnouncementHelper r102 = LiveIslandAnnouncementHelper.f397646a;
        return r101.b(null, this);
    }
}
