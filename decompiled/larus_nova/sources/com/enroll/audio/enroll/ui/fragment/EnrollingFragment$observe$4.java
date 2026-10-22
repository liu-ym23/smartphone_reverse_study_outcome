package com.enroll.audio.enroll.ui.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.keva.Keva;
import com.enroll.audio.enroll.model.EnrollState;
import com.enroll.audio.enroll.model.TipsCode;
import com.enroll.audio.enroll.recorder.VoicePrintEnrollRecordingsMgr;
import com.enroll.audio.enroll.resource.VoicePrintResourceManager;
import com.enroll.audio.enroll.trace.VoiceEnrollTrace;
import com.enroll.audio.enroll.ui.VoicePrintEnrollActivity;
import com.enroll.audio.enroll.vm.EnrollViewModel;
import com.enroll.audio.impl.databinding.EnrollEnrollingFragmentBinding;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.audio.ObricEnrollInteropDelegate;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.enroll.audio.enroll.ui.fragment.EnrollingFragment$observe$4", f = "EnrollingFragment.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_VIDEO_FIRSTSEG_CONNECT_TIME}, m = "invokeSuspend", n = {}, s = {})
final class EnrollingFragment$observe$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EnrollingFragment this$0;

    /* JADX INFO: renamed from: com.enroll.audio.enroll.ui.fragment.EnrollingFragment$observe$4$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EnrollingFragment f273865a;

        /* JADX INFO: renamed from: com.enroll.audio.enroll.ui.fragment.EnrollingFragment$observe$4$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.enroll.audio.enroll.ui.fragment.EnrollingFragment$observe$4$1$1", f = "EnrollingFragment.kt", i = {}, l = {TTVideoEngineInterface.PLAYER_OPTION_PREPARE_CACHE_MS, TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_BARRAGE_MASK}, m = "invokeSuspend", n = {}, s = {})
        public static final class C38321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ EnrollingFragment this$0;

            public C38321(EnrollingFragment r100, Continuation<? super C38321> r101) {
                this.this$0 = r100;
                super(2, r101);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new C38321(this.this$0, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((C38321) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r110) {
                Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r101 = this.label;
                EnrollViewModel r102 = null;
                if (r101 == 0) goto L12;
                if (r101 == 1) goto L10;
                if (r101 != 2) goto L9;
                ResultKt.throwOnFailure(r110);     // Catch: Exception -> L28
            L42:
                return Unit.INSTANCE;
            L9:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L10:
                ResultKt.throwOnFailure(r110);     // Catch: Exception -> L28
            L19:
                EnrollViewModel r111 = this.this$0.f273844f;     // Catch: Exception -> L28
                if (r111 != null) goto L22;
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Exception -> L28
                r111 = null;
            L22:
                r111.getRecordingManager().f273757j.g();     // Catch: Exception -> L28
                EnrollViewModel r112 = this.this$0.f273844f;     // Catch: Exception -> L28
                if (r112 != null) goto L26;
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Exception -> L28
                r112 = null;
            L26:
                if (r112.getEnrollDeviceType() != VoicePrintEnrollActivity.Companion.EnrollDeviceType.DORA_BT) goto L30;
                com.enroll.audio.enroll.b.f273720a.set(null);     // Catch: Exception -> L28
                gt7.a.b();     // Catch: Exception -> L28
            L30:
                EnrollViewModel r113 = this.this$0.f273844f;     // Catch: Exception -> L28
                if (r113 != null) goto L33;
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Exception -> L28
                r113 = null;
            L33:
                r113.setInterruptEnhancedVoiceEnroll(true);     // Catch: Exception -> L28
                EnrollingFragment r114 = this.this$0;     // Catch: Exception -> L28
                r114.getClass();     // Catch: Exception -> L28
                BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new EnrollingFragment$navigateToResult$1(r114, null), 3, null);     // Catch: Exception -> L28
                EnrollViewModel r115 = this.this$0.f273844f;     // Catch: Exception -> L28
                if (r115 != null) goto L36;
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Exception -> L28
            L37:
                z0<EnrollState> r116 = r102.getEnrollState();     // Catch: Exception -> L28
                EnrollState r103 = EnrollState.ENROLLED_INTERRUPT;     // Catch: Exception -> L28
                this.label = 2;     // Catch: Exception -> L28
                if (r116.emit(r103, this) != r100) goto L42;
                return r100;
            L36:
                r102 = r115;
                goto L37
            L12:
                ResultKt.throwOnFailure(r110);
                EnrollViewModel r117 = this.this$0.f273844f;     // Catch: Exception -> L28
                if (r117 != null) goto L16;
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Exception -> L28
                r117 = null;
            L16:
                VoicePrintEnrollRecordingsMgr r118 = r117.getRecordingManager();     // Catch: Exception -> L28
                this.label = 1;     // Catch: Exception -> L28
                if (r118.d(this) != r100) goto L19;
                return r100;
            L28:
                e = move-exception;
                FLogger.f375446a.e("EnrollingFragment", "Error BluetoothScoConnectFailed", e);
                goto L42
            }
        }

        public AnonymousClass1(EnrollingFragment r100) {
            this.f273865a = r100;
        }

        public final Object a(jt7.e r110, Continuation<? super Unit> r111) {
            if ((r111 instanceof EnrollingFragment$observe$4$1$emit$1) == false) goto L7;
            EnrollingFragment$observe$4$1$emit$1 r100 = (EnrollingFragment$observe$4$1$emit$1) r111;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r102 = r100.result;
            Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r104 = r100.label;
            if (r104 == 0) goto L22;
            if (r104 == 1) goto L21;
            if (r104 == 2) goto L20;
            if (r104 == 3) goto L19;
            if (r104 == 4) goto L18;
            if (r104 != 5) goto L17;
            ResultKt.throwOnFailure(r102);
        L139:
            return Unit.INSTANCE;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            ResultKt.throwOnFailure(r102);
        L128:
            return Unit.INSTANCE;
        L19:
            ResultKt.throwOnFailure(r102);
        L114:
            return Unit.INSTANCE;
        L20:
            ResultKt.throwOnFailure(r102);
        L105:
            return Unit.INSTANCE;
        L21:
            ResultKt.throwOnFailure(r102);
        L85:
            EnrollViewModel r105 = this.f273865a.f273844f;
            if (r105 != null) goto L89;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r105 = null;
        L89:
            if (Intrinsics.areEqual(r105.getStartFrom(), "SetUpWizard") == false) goto L106;
            it7.b r106 = it7.b.f495722a;
            Intrinsics.checkNotNullParameter("hasRecordPermission", "key");
            if (((Keva) it7.b.f495723b.getValue()).getBoolean("hasRecordPermission", false) == true) goto L97;
            final EnrollingFragment r107 = this.f273865a;
            EnrollViewModel r108 = r107.f273844f;
            if (r108 != null) goto L95;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r109 = null;
        L96:
            r109.setRequestingRecordPermission(true);
            ObricEnrollInteropDelegate.f392835b.k(r107.requireActivity(), new EnrollingFragment$requestRecordPermission$1(r107));
        L226:
            return Unit.INSTANCE;
        L95:
            r109 = r108;
            goto L96
        L97:
            EnrollViewModel r112 = this.f273865a.f273844f;
            if (r112 != null) goto L100;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r113 = null;
        L101:
            VoicePrintEnrollRecordingsMgr r114 = r113.getRecordingManager();
            r100.label = 2;
            if (r114.b(r100) != r103) goto L105;
            return r103;
        L100:
            r113 = r112;
            goto L101
        L106:
            EnrollViewModel r115 = this.f273865a.f273844f;
            if (r115 != null) goto L109;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r116 = null;
        L110:
            VoicePrintEnrollRecordingsMgr r117 = r116.getRecordingManager();
            r100.label = 3;
            if (r117.b(r100) != r103) goto L114;
            return r103;
        L109:
            r116 = r115;
            goto L110
        L22:
            ResultKt.throwOnFailure(r102);
            FLogger r118 = FLogger.f375446a;
            r118.i("EnrollingFragment", "eventBus: " + r110);
            if ((r110 instanceof jt7.o) == false) goto L78;
            EnrollingFragment r119 = this.f273865a;
            jt7.o r120 = (jt7.o) r110;
            int r121 = r120.f500334a;
            int r122 = EnrollingFragment.f273842k;
            r119.getClass();
            r118.i("EnrollingFragment", "showRippleOnce " + r121);
            if (r121 != 4) goto L27;
            boolean r123 = true;
        L28:
            if (r123 == false) goto L30;
            final float r124 = 0.4f;
        L31:
            EnrollEnrollingFragmentBinding r125 = r119.f273843e;
            Intrinsics.checkNotNull(r125);
            final View r126 = r125.f273998d;
            r126.setAlpha(r124);
            r126.setScaleX(0.0f);
            r126.setScaleY(0.0f);
            ValueAnimator r127 = new ValueAnimator();
            r127.setIntValues(new int[]{0, 1});
            long r128 = 2000;
            r127.setDuration(2000);
            r127.setInterpolator(new LinearInterpolator());
            r127.addUpdateListener(new j(r126, r124));
            ValueAnimator r129 = new ValueAnimator();
            r129.setIntValues(new int[]{0, 1});
            if (r123 == false) goto L34;
            r128 = 3000;
        L34:
            r129.setDuration(r128);
            r129.setInterpolator(new DecelerateInterpolator());
            r129.addUpdateListener(new k(r126));
            AnimatorSet r130 = new AnimatorSet();
            r130.addListener(new q(r126, r126));
            r130.playTogether(new Animator[]{r127, r129});
            r130.start();
            r118.i("EnrollStageView", "start animator ripple");
            EnrollingFragment r131 = this.f273865a;
            int r132 = r120.f500334a;
            r131.getClass();
            com.enroll.audio.enroll.sound.c r133 = com.enroll.audio.enroll.sound.c.f273811a;
            monitor-enter(r133);
            VoicePrintResourceManager.f273781a.getClass();     // Catch: Throwable -> L74
            String r134 = VoicePrintResourceManager.h(r132);     // Catch: Throwable -> L74
            if (r134 != null) goto L39;
        L42:
            boolean r135 = true;
        L43:
            if (r135 == false) goto L47;
            r118.e("SoundPlayer", "soundPath is empty, soundId=" + r132);     // Catch: Throwable -> L74
            monitor-exit(r133);
        L67:
            EnrollingFragment r136 = this.f273865a;
            int r137 = r120.f500334a;
            r136.getClass();
            if (r137 < 0) goto L71;
            if (r137 >= 5) goto L71;
            boolean r138 = true;
        L72:
            if (r138 == false) goto L226;
            Context r139 = r136.requireContext();
            int r140 = com.enroll.audio.enroll.sound.a.f273810a;
            Intrinsics.checkNotNullParameter(r139, PerfLog.PARAM_KEY_CONTEXT_ID);
            com.enroll.audio.enroll.sound.a.a(r139, 2, 30);
        L71:
            r138 = false;
            goto L72
        L47:
            r118.i("SoundPlayer", "play soundId=" + r132 + " path=" + r134 + " volume=1.0 loop=false");     // Catch: Throwable -> L74
            Map<Integer, Integer> r141 = com.enroll.audio.enroll.sound.c.f273814d;     // Catch: Throwable -> L74
            Integer r142 = (Integer) ((LinkedHashMap) r141).get(Integer.valueOf(r132));     // Catch: Throwable -> L74
            if (r142 == null) goto L50;
            int r143 = r142.intValue();     // Catch: Throwable -> L74
        L52:
            if (r143 >= 0) goto L57;
            r118.i("SoundPlayer", "soundId " + r132 + " not loaded");     // Catch: Throwable -> L74
            SoundPool r144 = com.enroll.audio.enroll.sound.c.f273815e;     // Catch: Throwable -> L74
            if (r144 != null) goto L56;
            Intrinsics.throwUninitializedPropertyAccessException("soundPool");     // Catch: Throwable -> L74
            r144 = null;
        L56:
            com.enroll.audio.enroll.sound.c.f273812b = r144.load(r134, 1);     // Catch: Throwable -> L74
            r141.put(Integer.valueOf(r132), Integer.valueOf(com.enroll.audio.enroll.sound.c.f273812b));     // Catch: Throwable -> L74
            com.enroll.audio.enroll.sound.c.f273813c = 1.0f;     // Catch: Throwable -> L74
            r118.e("SoundPlayer", "sound id to play = " + com.enroll.audio.enroll.sound.c.f273812b);     // Catch: Throwable -> L74
        L66:
            monitor-exit(r133);
            goto L67
        L57:
            Integer r145 = (Integer) ((LinkedHashMap) r141).get(Integer.valueOf(r132));     // Catch: Throwable -> L74
            if (r145 == null) goto L60;
            int r146 = r145.intValue();     // Catch: Throwable -> L74
        L61:
            com.enroll.audio.enroll.sound.c.f273812b = r146;     // Catch: Throwable -> L74
            r118.i("SoundPlayer", "sound id to play 2 = " + com.enroll.audio.enroll.sound.c.f273812b);     // Catch: Throwable -> L74
            if (com.enroll.audio.enroll.sound.c.f273812b != (-1)) goto L65;
            monitor-exit(r133);
            goto L67
        L65:
            Object r147 = ((LinkedHashMap) r141).get(Integer.valueOf(r132));     // Catch: Throwable -> L74
            Intrinsics.checkNotNull(r147);     // Catch: Throwable -> L74
            com.enroll.audio.enroll.sound.c.a(((Number) r147).intValue(), 1.0f);     // Catch: Throwable -> L74
            goto L66
        L60:
            r146 = -1;
            goto L61
        L50:
            r143 = -1;
            goto L52
        L39:
            if (StringsKt.isBlank(r134) == true) goto L42;
            r135 = false;
        L74:
            th = move-exception;
            throw th;
        L30:
            r124 = 0.2f;
            goto L31
        L27:
            r123 = false;
            goto L28
        L78:
            if ((r110 instanceof jt7.l) == false) goto L116;
            EnrollViewModel r148 = this.f273865a.f273844f;
            if (r148 != null) goto L82;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r148 = null;
        L82:
            z0<Integer> r149 = r148.getEnrollIndex();
            Integer r150 = Boxing.boxInt(((jt7.l) r110).f500331a);
            r100.label = 1;
            if (r149.emit(r150, r100) != r103) goto L85;
            return r103;
        L116:
            if ((r110 instanceof jt7.k) == false) goto L119;
            EnrollingFragment r151 = this.f273865a;
            int r152 = EnrollingFragment.f273842k;
            r151.getClass();
            BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new EnrollingFragment$navigateToResult$1(r151, null), 3, null);
            goto L226
        L119:
            if (Intrinsics.areEqual(r110, jt7.n.f500333a) == false) goto L130;
            EnrollViewModel r153 = this.f273865a.f273844f;
            if (r153 != null) goto L123;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r154 = null;
        L124:
            VoicePrintEnrollRecordingsMgr r155 = r154.getRecordingManager();
            r100.label = 4;
            if (r155.d(r100) != r103) goto L128;
            return r103;
        L123:
            r154 = r153;
            goto L124
        L130:
            if (Intrinsics.areEqual(r110, jt7.m.f500332a) == false) goto L141;
            EnrollViewModel r156 = this.f273865a.f273844f;
            if (r156 != null) goto L134;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r157 = null;
        L135:
            VoicePrintEnrollRecordingsMgr r158 = r157.getRecordingManager();
            r100.label = 5;
            if (r158.b(r100) != r103) goto L139;
            return r103;
        L134:
            r157 = r156;
            goto L135
        L141:
            if (Intrinsics.areEqual(r110, jt7.c.f500325a) == false) goto L143;
        L224:
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C38321(this.f273865a, null), 3, null);
            goto L226
        L143:
            if (Intrinsics.areEqual(r110, jt7.d.f500326a) == true) goto L224;
            if ((r110 instanceof jt7.q) == false) goto L151;
            r118.i("EnrollingFragment", "send tip event to channel with " + ((jt7.q) r110).f500336a);
            Handler r159 = this.f273865a.f273847i;
            if (r159 == null) goto L226;
            Message r160 = Message.obtain();
            r160.obj = r110;
            r160.what = 0;
            Boxing.boxBoolean(r159.sendMessage(r160));
            goto L226
        L151:
            if (Intrinsics.areEqual(r110, jt7.i.f500328a) == false) goto L157;
            EnrollViewModel r161 = this.f273865a.f273844f;
            if (r161 != null) goto L155;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r161 = null;
        L155:
            r161.reportEvent(new jt7.q(TipsCode.TIPS_CODE_VAD_END_AND_NOT_ENOUGH_SIZE, null));
            goto L226
        L157:
            if (Intrinsics.areEqual(r110, jt7.b.f500324a) == false) goto L177;
            if (this.f273865a.f273845g == true) goto L226;
            r118.i("EnrollingFragment", "playAnimation");
            EnrollEnrollingFragmentBinding r162 = this.f273865a.f273843e;
            Intrinsics.checkNotNull(r162);
            r162.f274003i.playAnimation();
            EnrollingFragment r163 = this.f273865a;
            r163.f273845g = true;
            EnrollViewModel r164 = r163.f273844f;
            if (r164 != null) goto L163;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r164 = null;
        L163:
            EnrollViewModel r165 = this.f273865a.f273844f;
            if (r165 != null) goto L166;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r165 = null;
        L166:
            int r166 = r165.getEnrollIndex().getValue().intValue();
            if (r166 == 4) goto L171;
            if (r166 == 3) goto L171;
            boolean r167 = false;
        L172:
            if (r167 == false) goto L174;
            jt7.q r168 = new jt7.q(TipsCode.TIPS_CODE_FASTER_SAY_it, null);
        L175:
            r164.reportEvent(r168);
            goto L226
        L174:
            r168 = new jt7.q(TipsCode.TIPS_CODE_SAY_it, null);
        L171:
            r167 = true;
            goto L172
        L177:
            if (Intrinsics.areEqual(r110, jt7.a.f500323a) == false) goto L183;
            if (this.f273865a.f273845g == false) goto L181;
            r118.i("EnrollingFragment", "cancelAnimation");
            EnrollEnrollingFragmentBinding r169 = this.f273865a.f273843e;
            Intrinsics.checkNotNull(r169);
            r169.f274003i.setFrame(1);
            EnrollEnrollingFragmentBinding r170 = this.f273865a.f273843e;
            Intrinsics.checkNotNull(r170);
            r170.f274003i.cancelAnimation();
        L181:
            this.f273865a.f273845g = false;
            goto L226
        L183:
            if (Intrinsics.areEqual(r110, jt7.p.f500335a) == false) goto L201;
            EnrollViewModel r171 = this.f273865a.f273844f;
            if (r171 != null) goto L188;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r171 = null;
        L188:
            if (r171.isRequestingRecordPermission() == true) goto L226;
            String r172 = VoiceEnrollTrace.f273818b;
            EnrollViewModel r173 = this.f273865a.f273844f;
            if (r173 != null) goto L192;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r173 = null;
        L192:
            VoiceEnrollTrace.c("obric_record_voice_wakeup_timeout", r172, r173.enterFrom());
            VoiceEnrollTrace.f273818b = "obric_record_voice_wakeup_timeout";
            EnrollingFragment r174 = this.f273865a;
            if (r174.getActivity() == null) goto L226;
            FragmentTransaction r175 = r174.getParentFragmentManager().beginTransaction().setCustomAnimations(R.anim.enroll_slide_in_bottom_interpolator, R.anim.enroll_router_no_anim, R.anim.enroll_router_no_anim, R.anim.enroll_router_no_anim);
            EnrollTimeoutFragment r176 = new EnrollTimeoutFragment();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r175, r176, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.fragment_container) == true) goto L199;
            r175 = r175.replace(R.id.fragment_container, r176);
        L199:
            r175.commit();
            goto L226
        L201:
            if (Intrinsics.areEqual(r110, jt7.h.f500327a) == false) goto L208;
            String r177 = VoiceEnrollTrace.f273818b;
            EnrollViewModel r178 = this.f273865a.f273844f;
            if (r178 != null) goto L205;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r179 = null;
        L206:
            VoiceEnrollTrace.c("obric_record_voice_wakeup_1", r177, r179.enterFrom());
            VoiceEnrollTrace.f273818b = "obric_record_voice_wakeup_1";
            EnrollEnrollingFragmentBinding r180 = this.f273865a.f273843e;
            Intrinsics.checkNotNull(r180);
            r180.f273997c.setText(this.f273865a.getString(R.string.enroll_enroll_index_indicator, new Object[]{Boxing.boxInt(1), Boxing.boxInt(5)}));
            goto L226
        L205:
            r179 = r178;
            goto L206
        L208:
            if ((r110 instanceof jt7.j) == false) goto L223;
            int r181 = ((jt7.j) r110).f500329a + 1;
            if (r181 > 5) goto L226;
            CoroutineScope r182 = VoiceEnrollTrace.f273817a;
            EnrollViewModel r183 = this.f273865a.f273844f;
            if (r183 != null) goto L214;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r183 = null;
        L214:
            String r184 = r183.getCurrentPageName(r181);
            String r185 = VoiceEnrollTrace.f273818b;
            EnrollViewModel r186 = this.f273865a.f273844f;
            if (r186 != null) goto L217;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r186 = null;
        L217:
            VoiceEnrollTrace.c(r184, r185, r186.enterFrom());
            EnrollViewModel r187 = this.f273865a.f273844f;
            if (r187 != null) goto L220;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r188 = null;
        L221:
            VoiceEnrollTrace.f273818b = r188.getCurrentPageName(r181);
            EnrollEnrollingFragmentBinding r189 = this.f273865a.f273843e;
            Intrinsics.checkNotNull(r189);
            r189.f273997c.setText(this.f273865a.getString(R.string.enroll_enroll_index_indicator, new Object[]{Boxing.boxInt(r181), Boxing.boxInt(5)}));
            goto L226
        L220:
            r188 = r187;
            goto L221
        L223:
            throw new NoWhenBranchMatchedException();
        L7:
            r100 = new EnrollingFragment$observe$4$1$emit$1(this, r111);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
            return a((jt7.e) r100, r101);
        }
    }

    public EnrollingFragment$observe$4(EnrollingFragment r100, Continuation<? super EnrollingFragment$observe$4> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new EnrollingFragment$observe$4(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((EnrollingFragment$observe$4) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L6;
        ResultKt.throwOnFailure(r100);
    L15:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        EnrollViewModel r103 = this.this$0.f273844f;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r103 = null;
    L11:
        MutableSharedFlow<jt7.e> r104 = r103.getEventBus();
        AnonymousClass1 r105 = new AnonymousClass1(this.this$0);
        this.label = 1;
        if (r104.collect(r105, this) != r101) goto L15;
        return r101;
    }
}
