package com.ss.android.lark.audio.opus;

import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes34.dex */
public final class AudioPlayerFocusHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f408991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f408992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Channel<g> f408993c;

    /* JADX INFO: renamed from: com.ss.android.lark.audio.opus.AudioPlayerFocusHelper$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.audio.opus.AudioPlayerFocusHelper$1", f = "AudioPlayerFocusHelper.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AudioPlayerFocusHelper this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.audio.opus.AudioPlayerFocusHelper$1$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AudioPlayerFocusHelper f408994a;

            public a(AudioPlayerFocusHelper r100) {
                this.f408994a = r100;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r100, Continuation r101) {
                g r102 = (g) r100;
                if ((r102 instanceof g.b) == false) goto L20;
                Log.i("AudioPlayerFocusHelper", "onFocusCommandListener get onRequestFocus");
                h r103 = this.f408994a.f408991a;
                if (r103 == null) goto L15;
                e r104 = (e) r103;
                if (Build.VERSION.SDK_INT < 26) goto L9;
                AudioAttributes r105 = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
                AudioFocusRequest r106 = new AudioFocusRequest.Builder(2).setAudioAttributes(r105).setOnAudioFocusChangeListener(r104.f409019m).setAcceptsDelayedFocusGain(true).build();
                r104.f409018l = r106;
                int r107 = r104.f409010d.requestAudioFocus(r106);
            L10:
                if (r107 == 0) goto L14;
                if (r107 != 1) goto L15;
                Log.i("AudioPlayer", "requestAudioFocus granted");
                goto L15
            L14:
                Log.i("AudioPlayer", "requestAudioFocus failed");
                goto L15
            L9:
                r107 = r104.f409010d.requestAudioFocus(r104.f409019m, 3, 2);
            L15:
                Object r108 = DelayKt.delay(100, r101);
                if (r108 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L44;
                return r108;
            L44:
                return Unit.INSTANCE;
            L20:
                if ((r102 instanceof g.a) == false) goto L43;
                Log.i("AudioPlayerFocusHelper", "onFocusCommandListener get onAbandonFocus");
                h r109 = this.f408994a.f408991a;
                if (r109 == null) goto L37;
                e r110 = (e) r109;
                AudioManager r111 = r110.f409010d;
                if (r111 == null) goto L37;
                if (Build.VERSION.SDK_INT < 26) goto L31;
                AudioFocusRequest r112 = r110.f409018l;
                if (r112 == null) goto L30;
                int r113 = r111.abandonAudioFocusRequest(r112);
            L32:
                if (r113 == 0) goto L36;
                if (r113 == 1) goto L35;
                Log.i("AudioPlayer", "abandonAudioFocus no need");
                goto L37
            L35:
                Log.i("AudioPlayer", "abandonAudioFocus granted");
                goto L37
            L36:
                Log.i("AudioPlayer", "abandonAudioFocus failed");
                goto L37
            L30:
                r113 = -1;
                goto L32
            L31:
                r113 = r111.abandonAudioFocus(r110.f409019m);
            L37:
                Object r114 = DelayKt.delay(100, r101);
                if (r114 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L41;
                return r114;
            L41:
                return Unit.INSTANCE;
            L43:
                throw new NoWhenBranchMatchedException();
            }
        }

        public AnonymousClass1(AudioPlayerFocusHelper r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            kotlinx.coroutines.flow.b r103 = kotlinx.coroutines.flow.e.l(this.this$0.f408993c);
            a r104 = new a(this.this$0);
            this.label = 1;
            if (r103.collect(r104, this) != r101) goto L12;
            return r101;
        }
    }

    public static final class a {
    }

    static {
    }

    public AudioPlayerFocusHelper(h r100) {
        this.f408991a = r100;
        CoroutineScope r101 = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.f408992b = r101;
        this.f408993c = ChannelKt.Channel$default(-2, null, null, 6, null);
        BuildersKt.launch$default(r101, null, null, new AnonymousClass1(this, null), 3, null);
    }
}
