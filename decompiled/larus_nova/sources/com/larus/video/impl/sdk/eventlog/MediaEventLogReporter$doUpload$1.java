package com.larus.video.impl.sdk.eventlog;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.video.impl.sdk.eventlog.MediaEventLogReporter", f = "MediaEventLogReporter.kt", i = {}, l = {66}, m = "doUpload", n = {}, s = {})
final class MediaEventLogReporter$doUpload$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MediaEventLogReporter this$0;

    public MediaEventLogReporter$doUpload$1(MediaEventLogReporter r100, Continuation<? super MediaEventLogReporter$doUpload$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MediaEventLogReporter.a(this.this$0, null, null, this);
    }
}
