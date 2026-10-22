package com.bytedance.applet.task;

import com.larus.audioplayer.api.news.NewsUrlAudioManagerDelegate;
import com.larus.audioplayer.api.news.UrlAudioPlayStatus;
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
@DebugMetadata(c = "com.bytedance.applet.task.MediaControlTaskManager$onPodcastStatusChanged$1", f = "MediaControlTaskManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MediaControlTaskManager$onPodcastStatusChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UrlAudioPlayStatus $status;
    int label;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UrlAudioPlayStatus.values().length];
            r0[UrlAudioPlayStatus.PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[UrlAudioPlayStatus.PREPARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[UrlAudioPlayStatus.PAUSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public MediaControlTaskManager$onPodcastStatusChanged$1(UrlAudioPlayStatus r1, Continuation<? super MediaControlTaskManager$onPodcastStatusChanged$1> r2) {
        this.$status = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MediaControlTaskManager$onPodcastStatusChanged$1(this.$status, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r8);
        FLogger.a.i("MediaControlTaskManager", "onPodcastStatusChanged: status = " + this.$status);
        b88.d r9 = NewsUrlAudioManagerDelegate.b.c();
        int r0 = a.a[this.$status.ordinal()];
        if (r0 != 1) goto L7;
    L12:
        PlaybackState r1 = PlaybackState.PLAYING;
    L13:
        PlaybackState r3 = r1;
        if (r9 == null) goto L23;
        String r2 = r9.k;
        String r4 = "";
        if (r2 != null) goto L18;
        r2 = "";
    L18:
        String r5 = r9.e;
        String r6 = r9.f;
        String r10 = r9.h;
        if (r10 == null) goto L22;
        r4 = r10;
    L22:
        final n r7 = new n(r2, r5, r6, r4);
    L24:
        b.a(b.a, TaskKey.PODCAST, r3, r7, new g(r7), new h());
        return Unit.INSTANCE;
    L23:
        r7 = null;
        goto L24
    L7:
        if (r0 == 2) goto L12;
        if (r0 == 3) goto L11;
        r1 = PlaybackState.STOPPED;
        goto L13
    L11:
        r1 = PlaybackState.PAUSED;
        goto L13
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
