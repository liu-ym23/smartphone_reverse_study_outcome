package com.obric.audio.enroll.ui.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Message;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.fragment.app.FragmentTransaction;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.audio.ObricEnrollInteropDelegate;
import com.obric.audio.enroll.model.EnrollState;
import com.obric.audio.enroll.model.TipsCode;
import com.obric.audio.enroll.recorder.VoicePrintEnrollRecordingsMgr;
import com.obric.audio.enroll.trace.VoiceEnrollTrace;
import com.obric.audio.enroll.ui.VoicePrintEnrollActivity;
import com.obric.audio.enroll.vm.EnrollViewModel;
import com.obric.audio.impl.databinding.SvaEnrollingFragmentBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.ui.fragment.EnrollingFragment$observe$5", f = "EnrollingFragment.kt", i = {}, l = {472}, m = "invokeSuspend", n = {}, s = {})
final class EnrollingFragment$observe$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EnrollingFragment this$0;

    /* JADX INFO: renamed from: com.obric.audio.enroll.ui.fragment.EnrollingFragment$observe$5$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EnrollingFragment f395636a;

        /* JADX INFO: renamed from: com.obric.audio.enroll.ui.fragment.EnrollingFragment$observe$5$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.audio.enroll.ui.fragment.EnrollingFragment$observe$5$1$1", f = "EnrollingFragment.kt", i = {}, l = {509, 517}, m = "invokeSuspend", n = {}, s = {})
        public static final class C46421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ EnrollingFragment this$0;

            public C46421(EnrollingFragment r100, Continuation<? super C46421> r101) {
                this.this$0 = r100;
                super(2, r101);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new C46421(this.this$0, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((C46421) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
                EnrollViewModel r111 = this.this$0.f395615f;     // Catch: Exception -> L28
                if (r111 != null) goto L22;
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Exception -> L28
                r111 = null;
            L22:
                r111.getRecordingManager().f395470k.g();     // Catch: Exception -> L28
                EnrollViewModel r112 = this.this$0.f395615f;     // Catch: Exception -> L28
                if (r112 != null) goto L26;
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Exception -> L28
                r112 = null;
            L26:
                if (r112.getEnrollDeviceType() != VoicePrintEnrollActivity.Companion.EnrollDeviceType.DORA_BT) goto L30;
                com.obric.audio.enroll.b.f395429a.set(null);     // Catch: Exception -> L28
                oia.a.b();     // Catch: Exception -> L28
            L30:
                EnrollViewModel r113 = this.this$0.f395615f;     // Catch: Exception -> L28
                if (r113 != null) goto L33;
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Exception -> L28
                r113 = null;
            L33:
                r113.setInterruptEnhancedVoiceEnroll(true);     // Catch: Exception -> L28
                EnrollingFragment r114 = this.this$0;     // Catch: Exception -> L28
                r114.getClass();     // Catch: Exception -> L28
                BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new EnrollingFragment$navigateToResult$1(r114, null), 3, null);     // Catch: Exception -> L28
                EnrollViewModel r115 = this.this$0.f395615f;     // Catch: Exception -> L28
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
                EnrollViewModel r117 = this.this$0.f395615f;     // Catch: Exception -> L28
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
            this.f395636a = r100;
        }

        public final Object a(qia.e r110, Continuation<? super Unit> r111) {
            if ((r111 instanceof EnrollingFragment$observe$5$1$emit$1) == false) goto L7;
            EnrollingFragment$observe$5$1$emit$1 r100 = (EnrollingFragment$observe$5$1$emit$1) r111;
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
        L144:
            return Unit.INSTANCE;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            ResultKt.throwOnFailure(r102);
        L133:
            return Unit.INSTANCE;
        L19:
            ResultKt.throwOnFailure(r102);
        L119:
            return Unit.INSTANCE;
        L20:
            ResultKt.throwOnFailure(r102);
        L110:
            return Unit.INSTANCE;
        L21:
            ResultKt.throwOnFailure(r102);
        L90:
            EnrollViewModel r105 = this.f395636a.f395615f;
            if (r105 != null) goto L94;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r105 = null;
        L94:
            if (Intrinsics.areEqual(r105.getStartFrom(), "SetUpWizard") == false) goto L111;
            pia.b r106 = pia.b.f529407a;
            Intrinsics.checkNotNullParameter("hasRecordPermission", "key");
            if (pia.b.a().getBoolean("hasRecordPermission", false) == true) goto L102;
            final EnrollingFragment r107 = this.f395636a;
            EnrollViewModel r108 = r107.f395615f;
            if (r108 != null) goto L100;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r109 = null;
        L101:
            r109.setRequestingRecordPermission(true);
            ObricEnrollInteropDelegate.f392835b.k(r107.requireActivity(), new EnrollingFragment$requestRecordPermission$1(r107));
        L237:
            return Unit.INSTANCE;
        L100:
            r109 = r108;
            goto L101
        L102:
            EnrollViewModel r112 = this.f395636a.f395615f;
            if (r112 != null) goto L105;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r113 = null;
        L106:
            VoicePrintEnrollRecordingsMgr r114 = r113.getRecordingManager();
            r100.label = 2;
            if (r114.b(r100) != r103) goto L110;
            return r103;
        L105:
            r113 = r112;
            goto L106
        L111:
            EnrollViewModel r115 = this.f395636a.f395615f;
            if (r115 != null) goto L114;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r116 = null;
        L115:
            VoicePrintEnrollRecordingsMgr r117 = r116.getRecordingManager();
            r100.label = 3;
            if (r117.b(r100) != r103) goto L119;
            return r103;
        L114:
            r116 = r115;
            goto L115
        L22:
            ResultKt.throwOnFailure(r102);
            FLogger r118 = FLogger.f375446a;
            r118.i("EnrollingFragment", "eventBus: " + r110);
            if ((r110 instanceof qia.o) == false) goto L83;
            EnrollingFragment r119 = this.f395636a;
            qia.o r120 = (qia.o) r110;
            int r121 = r120.f533220a;
            int r122 = EnrollingFragment.f395613k;
            r119.getClass();
            r118.i("EnrollingFragment", "showRippleOnce " + r121);
            if (r121 != 4) goto L27;
            boolean r123 = true;
        L28:
            if (r123 == false) goto L30;
            final float r124 = 0.4f;
        L31:
            SvaEnrollingFragmentBinding r125 = r119.f395614e;
            Intrinsics.checkNotNull(r125);
            final View r126 = r125.f395797d;
            r126.setAlpha(r124);
            r126.setScaleX(0.0f);
            r126.setScaleY(0.0f);
            ValueAnimator r127 = new ValueAnimator();
            r127.setIntValues(new int[]{0, 1});
            long r128 = 2000;
            r127.setDuration(2000);
            r127.setInterpolator(new LinearInterpolator());
            r127.addUpdateListener(new w(r126, r124));
            ValueAnimator r129 = new ValueAnimator();
            r129.setIntValues(new int[]{0, 1});
            if (r123 == false) goto L34;
            r128 = 3000;
        L34:
            r129.setDuration(r128);
            r129.setInterpolator(new DecelerateInterpolator());
            r129.addUpdateListener(new x(r126));
            AnimatorSet r130 = new AnimatorSet();
            r130.addListener(new d0(r126, r126));
            r130.playTogether(new Animator[]{r127, r129});
            r130.start();
            r118.i("EnrollStageView", "start animator ripple");
            EnrollingFragment r131 = this.f395636a;
            int r132 = r120.f533220a;
            r131.getClass();
            ria.c r133 = ria.c.f537921a;
            monitor-enter(r133);
            if (r132 >= 0) goto L238;
        L64:
            monitor-exit(r133);
        L65:
            EnrollingFragment r134 = this.f395636a;
            int r135 = r120.f533220a;
            r134.getClass();
            if (r135 < 0) goto L69;
            if (r135 >= 5) goto L69;
            boolean r136 = true;
        L70:
            if (r136 == false) goto L237;
            Context r137 = r134.requireContext();
            int r138 = ria.a.f537920a;
            Intrinsics.checkNotNullParameter(r137, PerfLog.PARAM_KEY_CONTEXT_ID);
            VibrationEffect r139 = VibrationEffect.createPredefined(2);
            Object r140 = r137.getSystemService("vibrator");
            if ((r140 instanceof Vibrator) == false) goto L74;
            Vibrator r141 = (Vibrator) r140;
        L75:
            if (r141 == null) goto L237;
            if (r141.hasVibrator() == false) goto L79;
            Vibrator r142 = r141;
        L80:
            if (r142 == null) goto L237;
            r142.vibrate(r139);
            goto L237
        L79:
            r142 = null;
            goto L80
        L74:
            r141 = null;
        L69:
            r136 = false;
            goto L70
        L238:
            Map<Integer, Integer> r143 = ria.c.f537925e;     // Catch: Throwable -> L61
            if (r132 >= r143.size()) goto L64;
            Map<Integer, Integer> r144 = ria.c.f537926f;     // Catch: Throwable -> L61
            Integer r145 = (Integer) ((LinkedHashMap) r144).get(Integer.valueOf(r132));     // Catch: Throwable -> L61
            if (r145 == null) goto L43;
            int r146 = r145.intValue();     // Catch: Throwable -> L61
        L45:
            if (r146 >= 0) goto L50;
            r118.i("SoundPlayer", "soundId " + r132 + " not loaded");     // Catch: Throwable -> L61
            SoundPool r147 = ria.c.f537927g;     // Catch: Throwable -> L61
            if (r147 != null) goto L49;
            Intrinsics.throwUninitializedPropertyAccessException("soundPool");     // Catch: Throwable -> L61
            r147 = null;
        L49:
            Context r148 = ria.c.f537922b;     // Catch: Throwable -> L61
            Integer r149 = r143.get(Integer.valueOf(r132));     // Catch: Throwable -> L61
            Intrinsics.checkNotNull(r149);     // Catch: Throwable -> L61
            ria.c.f537923c = r147.load(r148, r149.intValue(), 1);     // Catch: Throwable -> L61
            r144.put(Integer.valueOf(r132), Integer.valueOf(ria.c.f537923c));     // Catch: Throwable -> L61
            ria.c.f537924d = 1.0f;     // Catch: Throwable -> L61
            r118.e("SoundPlayer", "sound id to play = " + ria.c.f537923c);     // Catch: Throwable -> L61
        L59:
            monitor-exit(r133);
            goto L65
        L50:
            Integer r150 = (Integer) ((LinkedHashMap) r144).get(Integer.valueOf(r132));     // Catch: Throwable -> L61
            if (r150 == null) goto L53;
            int r151 = r150.intValue();     // Catch: Throwable -> L61
        L54:
            ria.c.f537923c = r151;     // Catch: Throwable -> L61
            r118.i("SoundPlayer", "sound id to play 2 = " + ria.c.f537923c);     // Catch: Throwable -> L61
            if (ria.c.f537923c != (-1)) goto L58;
            monitor-exit(r133);
            goto L65
        L58:
            Object r152 = ((LinkedHashMap) r144).get(Integer.valueOf(r132));     // Catch: Throwable -> L61
            Intrinsics.checkNotNull(r152);     // Catch: Throwable -> L61
            r133.a(((Number) r152).intValue(), 1.0f);     // Catch: Throwable -> L61
            goto L59
        L53:
            r151 = -1;
            goto L54
        L43:
            r146 = -1;
        L61:
            th = move-exception;
            throw th;
        L30:
            r124 = 0.2f;
            goto L31
        L27:
            r123 = false;
            goto L28
        L83:
            if ((r110 instanceof qia.l) == false) goto L121;
            EnrollViewModel r153 = this.f395636a.f395615f;
            if (r153 != null) goto L87;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r153 = null;
        L87:
            z0<Integer> r154 = r153.getEnrollIndex();
            Integer r155 = Boxing.boxInt(((qia.l) r110).f533217a);
            r100.label = 1;
            if (r154.emit(r155, r100) != r103) goto L90;
            return r103;
        L121:
            if ((r110 instanceof qia.k) == false) goto L124;
            EnrollingFragment r156 = this.f395636a;
            int r157 = EnrollingFragment.f395613k;
            r156.getClass();
            BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new EnrollingFragment$navigateToResult$1(r156, null), 3, null);
            goto L237
        L124:
            if (Intrinsics.areEqual(r110, qia.n.f533219a) == false) goto L135;
            EnrollViewModel r158 = this.f395636a.f395615f;
            if (r158 != null) goto L128;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r159 = null;
        L129:
            VoicePrintEnrollRecordingsMgr r160 = r159.getRecordingManager();
            r100.label = 4;
            if (r160.d(r100) != r103) goto L133;
            return r103;
        L128:
            r159 = r158;
            goto L129
        L135:
            if (Intrinsics.areEqual(r110, qia.m.f533218a) == false) goto L146;
            EnrollViewModel r161 = this.f395636a.f395615f;
            if (r161 != null) goto L139;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r162 = null;
        L140:
            VoicePrintEnrollRecordingsMgr r163 = r162.getRecordingManager();
            r100.label = 5;
            if (r163.b(r100) != r103) goto L144;
            return r103;
        L139:
            r162 = r161;
            goto L140
        L146:
            if (Intrinsics.areEqual(r110, qia.c.f533211a) == false) goto L148;
        L235:
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C46421(this.f395636a, null), 3, null);
            goto L237
        L148:
            if (Intrinsics.areEqual(r110, qia.d.f533212a) == true) goto L235;
            if ((r110 instanceof qia.q) == false) goto L156;
            r118.i("EnrollingFragment", "send tip event to channel with " + ((qia.q) r110).f533222a);
            Handler r164 = this.f395636a.f395618i;
            if (r164 == null) goto L237;
            Message r165 = Message.obtain();
            r165.obj = r110;
            r165.what = 0;
            Boxing.boxBoolean(r164.sendMessage(r165));
            goto L237
        L156:
            if (Intrinsics.areEqual(r110, qia.i.f533214a) == false) goto L163;
            EnrollViewModel r166 = this.f395636a.f395615f;
            if (r166 != null) goto L160;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r167 = null;
        L161:
            r167.reportEvent(new qia.q(TipsCode.TIPS_CODE_VAD_END_AND_NOT_ENOUGH_SIZE));
            goto L237
        L160:
            r167 = r166;
            goto L161
        L163:
            if (Intrinsics.areEqual(r110, qia.b.f533210a) == false) goto L184;
            if (this.f395636a.f395616g == true) goto L237;
            r118.i("EnrollingFragment", "playAnimation");
            SvaEnrollingFragmentBinding r168 = this.f395636a.f395614e;
            Intrinsics.checkNotNull(r168);
            r168.f395803j.playAnimation();
            EnrollingFragment r169 = this.f395636a;
            r169.f395616g = true;
            EnrollViewModel r170 = r169.f395615f;
            if (r170 != null) goto L169;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r170 = null;
        L169:
            EnrollViewModel r171 = this.f395636a.f395615f;
            if (r171 != null) goto L172;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r172 = null;
        L173:
            int r173 = r172.getEnrollIndex().getValue().intValue();
            if (r173 == 4) goto L178;
            if (r173 == 3) goto L178;
            boolean r174 = false;
        L179:
            if (r174 == false) goto L181;
            qia.q r175 = new qia.q(TipsCode.TIPS_CODE_FASTER_SAY_it);
        L182:
            r170.reportEvent(r175);
            goto L237
        L181:
            r175 = new qia.q(TipsCode.TIPS_CODE_SAY_it);
        L178:
            r174 = true;
            goto L179
        L172:
            r172 = r171;
            goto L173
        L184:
            if (Intrinsics.areEqual(r110, qia.a.f533209a) == false) goto L190;
            if (this.f395636a.f395616g == false) goto L188;
            r118.i("EnrollingFragment", "cancelAnimation");
            SvaEnrollingFragmentBinding r176 = this.f395636a.f395614e;
            Intrinsics.checkNotNull(r176);
            r176.f395803j.setFrame(1);
            SvaEnrollingFragmentBinding r177 = this.f395636a.f395614e;
            Intrinsics.checkNotNull(r177);
            r177.f395803j.cancelAnimation();
        L188:
            this.f395636a.f395616g = false;
            goto L237
        L190:
            if (Intrinsics.areEqual(r110, qia.p.f533221a) == false) goto L208;
            EnrollViewModel r178 = this.f395636a.f395615f;
            if (r178 != null) goto L195;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r178 = null;
        L195:
            if (r178.isRequestingRecordPermission() == true) goto L237;
            CoroutineScope r179 = VoiceEnrollTrace.f395572a;
            String r180 = VoiceEnrollTrace.f395573b;
            EnrollViewModel r181 = this.f395636a.f395615f;
            if (r181 != null) goto L199;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r181 = null;
        L199:
            VoiceEnrollTrace.c("obric_record_voice_wakeup_timeout", r180, r181.enterFrom());
            VoiceEnrollTrace.f395573b = "obric_record_voice_wakeup_timeout";
            EnrollingFragment r182 = this.f395636a;
            if (r182.getActivity() == null) goto L237;
            FragmentTransaction r183 = r182.getParentFragmentManager().beginTransaction().setCustomAnimations(R.anim.sva_slide_in_bottom_interpolator, R.anim.sva_router_no_anim, R.anim.sva_router_no_anim, R.anim.sva_router_no_anim);
            EnrollTimeoutFragment r184 = new EnrollTimeoutFragment();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r183, r184, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.fragment_container) == true) goto L206;
            r183 = r183.replace(R.id.fragment_container, r184);
        L206:
            r183.commit();
            goto L237
        L208:
            if (Intrinsics.areEqual(r110, qia.h.f533213a) == false) goto L219;
            CoroutineScope r185 = VoiceEnrollTrace.f395572a;
            String r186 = VoiceEnrollTrace.f395573b;
            if (r186 != null) goto L213;
            r186 = EnrollViewModel.GUIDE_PAGE;
        L213:
            EnrollViewModel r187 = this.f395636a.f395615f;
            if (r187 != null) goto L216;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r188 = null;
        L217:
            VoiceEnrollTrace.c("obric_record_voice_wakeup_1", r186, r188.enterFrom());
            VoiceEnrollTrace.f395573b = "obric_record_voice_wakeup_1";
            SvaEnrollingFragmentBinding r189 = this.f395636a.f395614e;
            Intrinsics.checkNotNull(r189);
            r189.f395796c.setText(this.f395636a.getString(R.string.sva_enroll_index_indicator, new Object[]{Boxing.boxInt(1), Boxing.boxInt(5)}));
            goto L237
        L216:
            r188 = r187;
            goto L217
        L219:
            if ((r110 instanceof qia.j) == false) goto L234;
            int r190 = ((qia.j) r110).f533215a + 1;
            if (r190 > 5) goto L237;
            CoroutineScope r191 = VoiceEnrollTrace.f395572a;
            EnrollViewModel r192 = this.f395636a.f395615f;
            if (r192 != null) goto L225;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r192 = null;
        L225:
            String r193 = r192.getCurrentPageName(r190);
            String r194 = VoiceEnrollTrace.f395573b;
            EnrollViewModel r195 = this.f395636a.f395615f;
            if (r195 != null) goto L228;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r195 = null;
        L228:
            VoiceEnrollTrace.c(r193, r194, r195.enterFrom());
            EnrollViewModel r196 = this.f395636a.f395615f;
            if (r196 != null) goto L231;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            EnrollViewModel r197 = null;
        L232:
            VoiceEnrollTrace.f395573b = r197.getCurrentPageName(r190);
            SvaEnrollingFragmentBinding r198 = this.f395636a.f395614e;
            Intrinsics.checkNotNull(r198);
            r198.f395796c.setText(this.f395636a.getString(R.string.sva_enroll_index_indicator, new Object[]{Boxing.boxInt(r190), Boxing.boxInt(5)}));
            goto L237
        L231:
            r197 = r196;
            goto L232
        L234:
            throw new NoWhenBranchMatchedException();
        L7:
            r100 = new EnrollingFragment$observe$5$1$emit$1(this, r111);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
            return a((qia.e) r100, r101);
        }
    }

    public EnrollingFragment$observe$5(EnrollingFragment r100, Continuation<? super EnrollingFragment$observe$5> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new EnrollingFragment$observe$5(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((EnrollingFragment$observe$5) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        EnrollViewModel r103 = this.this$0.f395615f;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r103 = null;
    L11:
        MutableSharedFlow<qia.e> r104 = r103.getEventBus();
        AnonymousClass1 r105 = new AnonymousClass1(this.this$0);
        this.label = 1;
        if (r104.collect(r105, this) != r101) goto L15;
        return r101;
    }
}
