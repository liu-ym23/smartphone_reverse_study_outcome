package com.bytedance.applet.task;

import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
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
@DebugMetadata(c = "com.bytedance.applet.task.MediaControlTaskManager$onMusicStatusChanged$1", f = "MediaControlTaskManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MediaControlTaskManager$onMusicStatusChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $status;
    int label;

    public MediaControlTaskManager$onMusicStatusChanged$1(int r1, Continuation<? super MediaControlTaskManager$onMusicStatusChanged$1> r2) {
        this.$status = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MediaControlTaskManager$onMusicStatusChanged$1(this.$status, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r8);
        FLogger.a.i("MediaControlTaskManager", "onMusicStatusChanged: status = " + this.$status);
        a88.e r9 = MusicPlayManagerDelegate.b.a();
        int r0 = this.$status;
        if (r0 != 1) goto L7;
        PlaybackState r1 = PlaybackState.PLAYING;
    L11:
        PlaybackState r3 = r1;
        if (r9 == null) goto L21;
        String r2 = r9.n;
        String r4 = "";
        if (r2 != null) goto L16;
        r2 = "";
    L16:
        String r5 = r9.c;
        String r6 = r9.d;
        String r10 = r9.i;
        if (r10 == null) goto L20;
        r4 = r10;
    L20:
        final n r7 = new n(r2, r5, r6, r4);
    L22:
        b.a(b.a, TaskKey.MUSIC, r3, r7, new e(r7), new f());
        return Unit.INSTANCE;
    L21:
        r7 = null;
        goto L22
    L7:
        if (r0 == 2) goto L9;
        r1 = PlaybackState.STOPPED;
        goto L11
    L9:
        r1 = PlaybackState.PAUSED;
        goto L11
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
