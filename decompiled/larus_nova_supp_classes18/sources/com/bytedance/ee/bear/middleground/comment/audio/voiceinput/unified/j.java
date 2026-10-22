package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import androidx.lifecycle.LifecycleCoroutineScope;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j {
    public static final CompletableJob a(LifecycleCoroutineScope r10, i1 r11, d1 r12, i1 r13, Function1 r14, h r15) {
        Intrinsics.checkNotNullParameter(r10, "scope");
        Intrinsics.checkNotNullParameter(r11, "results");
        Intrinsics.checkNotNullParameter(r12, "events");
        Intrinsics.checkNotNullParameter(r13, "recordState");
        Intrinsics.checkNotNullParameter(r14, "consumerResult");
        Intrinsics.checkNotNullParameter(r15, "callbacks");
        i r1 = new i(CoroutineExceptionHandler.Key);
        CompletableJob r0 = SupervisorKt.SupervisorJob(r10.getCoroutineContext().get(Job.Key));
        CoroutineScope r16 = CoroutineScopeKt.CoroutineScope(r10.getCoroutineContext().plus(r0).plus(r1));
        CoroutineStart r8 = CoroutineStart.UNDISPATCHED;
        BuildersKt.launch$default(r16, null, r8, new CommentUnifiedVoiceComponentFlowCallbacksKt$observeCommentUnifiedVoiceComponentFlows$1(r11, r14, r15, null), 1, null);
        BuildersKt.launch$default(r16, null, r8, new CommentUnifiedVoiceComponentFlowCallbacksKt$observeCommentUnifiedVoiceComponentFlows$2(r12, r15, null), 1, null);
        BuildersKt.launch$default(r16, null, r8, new CommentUnifiedVoiceComponentFlowCallbacksKt$observeCommentUnifiedVoiceComponentFlows$3(r13, r15, null), 1, null);
        return r0;
    }
}
