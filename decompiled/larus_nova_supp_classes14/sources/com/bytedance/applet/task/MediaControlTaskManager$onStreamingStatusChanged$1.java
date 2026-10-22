package com.bytedance.applet.task;

import com.larus.audioplayer.api.stream.AudioStreamPlayerDelegate;
import com.larus.audioplayer.api.stream.StreamPlayerStatus;
import com.larus.multitask_management.api.data.TaskKey;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.task.MediaControlTaskManager$onStreamingStatusChanged$1", f = "MediaControlTaskManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MediaControlTaskManager$onStreamingStatusChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StreamPlayerStatus $status;
    int label;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[StreamPlayerStatus.values().length];
            r0[StreamPlayerStatus.PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[StreamPlayerStatus.PREPARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[StreamPlayerStatus.PAUSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public MediaControlTaskManager$onStreamingStatusChanged$1(StreamPlayerStatus r1, Continuation<? super MediaControlTaskManager$onStreamingStatusChanged$1> r2) {
        this.$status = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MediaControlTaskManager$onStreamingStatusChanged$1(this.$status, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r8);
        FLogger.a.i("MediaControlTaskManager", "onStreamingStatusChanged: status = " + this.$status);
        c88.a r9 = AudioStreamPlayerDelegate.b.f();
        int r0 = a.a[this.$status.ordinal()];
        if (r0 != 1) goto L7;
    L12:
        PlaybackState r1 = PlaybackState.PLAYING;
    L13:
        PlaybackState r3 = r1;
        if (r9 == null) goto L19;
        String r2 = r9.a;
        String r4 = r9.b;
        String r5 = r9.c;
        String r10 = r9.d;
        if (r10 != null) goto L18;
        r10 = "";
    L18:
        final n r6 = new n(r2, r4, r5, r10);
    L20:
        b.a(b.a, TaskKey.STREAMING_PODCAST, r3, r6, new i(r6), new j());
        return Unit.INSTANCE;
    L19:
        r6 = null;
        goto L20
    L7:
        if (r0 == 2) goto L12;
        if (r0 == 3) goto L11;
        r1 = PlaybackState.STOPPED;
        goto L13
    L11:
        r1 = PlaybackState.PAUSED;
        goto L13
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
