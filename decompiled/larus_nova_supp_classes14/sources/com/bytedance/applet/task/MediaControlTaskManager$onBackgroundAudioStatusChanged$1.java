package com.bytedance.applet.task;

import aw3.q0;
import com.bytedance.applet.audio.background.BackgroundAudioPlaybackState;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.task.MediaControlTaskManager$onBackgroundAudioStatusChanged$1", f = "MediaControlTaskManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MediaControlTaskManager$onBackgroundAudioStatusChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appletId;
    final /* synthetic */ q0 $state;
    int label;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BackgroundAudioPlaybackState.values().length];
            r0[BackgroundAudioPlaybackState.PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[BackgroundAudioPlaybackState.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public MediaControlTaskManager$onBackgroundAudioStatusChanged$1(String r1, q0 r2, Continuation<? super MediaControlTaskManager$onBackgroundAudioStatusChanged$1> r3) {
        this.$appletId = r1;
        this.$state = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MediaControlTaskManager$onBackgroundAudioStatusChanged$1(this.$appletId, this.$state, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L73;
        ResultKt.throwOnFailure(r13);
        String r14 = this.$appletId;
        String r0 = null;
        if (r14 != null) goto L7;
    L9:
        r14 = null;
    L10:
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("onBackgroundAudioStatusChanged: appletId = ");
        String r4 = "";
        if (r14 != null) goto L13;
        String r5 = "";
    L14:
        r3.append(r5);
        r3.append(", state = ");
        r3.append(this.$state.m.getValue());
        r3.append(", mediaInfo = ");
        b r6 = b.a;
        q0 r7 = this.$state;
        r6.getClass();
        StringBuilder r8 = new StringBuilder("hasTitle=");
        String r9 = r7.b;
        boolean r10 = false;
        if (r9 != null) goto L17;
    L20:
        boolean r11 = true;
    L21:
        r8.append(!r11);
        r8.append(", hasSinger=");
        String r12 = r7.d;
        if (r12 != null) goto L24;
    L27:
        boolean r15 = true;
    L28:
        r8.append(!r15);
        r8.append(", hasCover=");
        String r16 = r7.e;
        if (r16 != null) goto L31;
    L32:
        r10 = true;
    L33:
        r8.append(!r10);
        r3.append(r8.toString());
        r2.i("MediaControlTaskManager", r3.toString());
        int r17 = a.a[this.$state.m.ordinal()];
        if (r17 != 1) goto L36;
        PlaybackState r18 = PlaybackState.PLAYING;
    L40:
        PlaybackState r19 = r18;
        if (r14 == null) goto L69;
        q0 r20 = this.$state;
        r6.getClass();
        String r21 = r20.b;
        if (r21 != null) goto L45;
    L49:
        r21 = r20.c;
        if (r21 != null) goto L52;
    L54:
        r21 = null;
    L55:
        if (r21 != null) goto L57;
        r21 = "音频播放";
    L57:
        r6.getClass();
        String r22 = r20.d;
        if (r22 != null) goto L60;
    L63:
        r0 = "";
    L64:
        String r1 = r20.e;
        if (r1 == null) goto L68;
        r4 = r1;
    L68:
        final n r23 = new n(r14, r21, r0, r4);
    L70:
        b.a(r6, TaskKey.MUSIC, r19, r23, new c(r23), new d());
        return Unit.INSTANCE;
    L60:
        if ((true ^ StringsKt.isBlank(r22)) == false) goto L62;
        r0 = r22;
    L62:
        if (r0 != null) goto L64;
    L52:
        if ((!StringsKt.isBlank(r21)) == false) goto L54;
    L45:
        if ((!StringsKt.isBlank(r21)) == true) goto L48;
        r21 = null;
    L48:
        if (r21 != null) goto L57;
    L69:
        r23 = null;
        goto L70
    L36:
        if (r17 == 2) goto L38;
        r18 = PlaybackState.STOPPED;
        goto L40
    L38:
        r18 = PlaybackState.PAUSED;
        goto L40
    L31:
        if (StringsKt.isBlank(r16) == false) goto L33;
    L24:
        if (StringsKt.isBlank(r12) == true) goto L27;
        r15 = false;
        goto L28
    L17:
        if (StringsKt.isBlank(r9) == true) goto L20;
        r11 = false;
        goto L21
    L13:
        r5 = r14;
        goto L14
    L7:
        if ((!StringsKt.isBlank(r14)) == false) goto L9;
    L73:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
