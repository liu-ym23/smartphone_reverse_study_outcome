package com.larus.bmhome.chat.component.bottom.voice;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.component.bottom.core.f6;
import com.larus.bmhome.chat.component.bottom.core.g6;
import com.larus.bmhome.chat.component.bottom.core.h6;
import com.larus.bmhome.chat.component.bottom.core.y5;
import com.larus.bmhome.chat.component.bottom.voice.service.VoiceMixInputManager;
import com.larus.bmhome.chat.component.bottom.voice.service.VoiceMixInputService;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.common_ui.utils.ViewExtKt$watchOnImeInsetsAnimationEndOnce$callback$1;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 r2\u00060\u0001j\u0002`\u00022\u00020\u0003:\u0001rB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020:H\u0002J\u000e\u0010>\u001a\u00020:H\u0082@¢\u0006\u0002\u0010?J\b\u0010@\u001a\u00020:H\u0016J\u0010\u0010A\u001a\u00020:2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u000208H\u0016J\b\u0010E\u001a\u00020FH\u0016J\b\u0010G\u001a\u000208H\u0016J\b\u0010H\u001a\u000208H\u0016J\u0010\u0010I\u001a\u00020:2\u0006\u0010J\u001a\u00020<H\u0016J\b\u0010K\u001a\u000208H\u0016J\u001e\u0010L\u001a\u00020M2\u0014\u0010N\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010P\u0012\u0004\u0012\u00020:0OH\u0016J\u001e\u0010Q\u001a\u00020M2\u0014\u0010N\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010R\u0012\u0004\u0012\u00020:0OH\u0016J\u001c\u0010S\u001a\u00020M2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020:0OH\u0016J\u001e\u0010U\u001a\u00020M2\u0014\u0010N\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010)\u0012\u0004\u0012\u00020:0OH\u0016J\u0018\u0010V\u001a\u00020:2\u0006\u0010W\u001a\u0002082\u0006\u0010X\u001a\u000208H\u0016J\b\u0010Y\u001a\u00020:H\u0016J\b\u0010Z\u001a\u00020RH\u0016J\b\u0010[\u001a\u00020\\H\u0016J\u0016\u0010]\u001a\u00020:2\u0006\u0010^\u001a\u00020_H\u0082@¢\u0006\u0002\u0010`J \u0010a\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020FH\u0002J$\u0010e\u001a\u000e\u0012\u0004\u0012\u00020g\u0012\u0004\u0012\u00020g0f2\u0006\u0010;\u001a\u00020<2\u0006\u0010b\u001a\u00020cH\u0002J\u001c\u0010h\u001a\u000e\u0012\u0004\u0012\u00020g\u0012\u0004\u0012\u00020g0f2\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010i\u001a\u00020:H\u0016J\b\u0010j\u001a\u00020:H\u0016J\"\u0010k\u001a\u00020:2\b\u0010l\u001a\u0004\u0018\u00010m2\u0006\u0010n\u001a\u00020F2\u0006\u0010o\u001a\u00020_H\u0016J\u0012\u0010p\u001a\u00020:2\b\u0010l\u001a\u0004\u0018\u00010mH\u0016J\n\u0010q\u001a\u0004\u0018\u00010!H\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b$\u0010%R#\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u000b\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u000b\u001a\u0004\b/\u00100R\u001b\u00102\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u000b\u001a\u0004\b4\u00105R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/voice/VoiceMixInputComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/chat/component/bottom/voice/IVoiceMixInputAbility;", "<init>", "()V", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "conversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "conversationAbility$delegate", "speakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "getSpeakerAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "speakerAbility$delegate", "uiController", "Lcom/larus/bmhome/chat/component/bottom/voice/IVoiceMixInputUIController;", "service", "Lcom/larus/bmhome/chat/component/bottom/voice/service/VoiceMixInputService;", "getService", "()Lcom/larus/bmhome/chat/component/bottom/voice/service/VoiceMixInputService;", "service$delegate", "nonStreamDetailStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/bmhome/chat/component/bottom/voice/service/IVoiceMixInputService$NonStreamDetailStatus;", "getNonStreamDetailStatus", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "nonStreamDetailStatus$delegate", "loadingHelper", "Lcom/larus/asr/AsrLoadingHelper;", "getLoadingHelper", "()Lcom/larus/asr/AsrLoadingHelper;", "loadingHelper$delegate", "speakerPressLifecycle", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/ChatSpeakerPressLifecycle;", "getSpeakerPressLifecycle", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/ChatSpeakerPressLifecycle;", "speakerPressLifecycle$delegate", "disablePanel", "", "onViewCreated", "", "view", "Landroid/view/View;", "observeNonStreamAsrSession", "beforeStartNonStreamAsr", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAttach", "switchVoiceInputStatus", "data", "Lcom/larus/bmhome/chat/component/bottom/voice/SwitchVoiceInputData;", "hitExperiment", "getExperimentGroup", "", "isOnlyLongPressVoiceMixInput", "supportStreamVoiceMixInput", "showTips", "anchor", "inVoiceMixInput", "observeVoiceMixInputStatus", "Lkotlinx/coroutines/Job;", "callback", "Lkotlin/Function1;", "Lcom/larus/bmhome/chat/component/bottom/voice/service/IVoiceMixInputService$Status;", "observeTextStream", "Lcom/larus/bmhome/chat/component/bottom/voice/service/IVoiceMixInputService$TextStream;", "observeAudioData", "", "observeNonStreamDetailStatus", "interruptVoiceMixInput", "flushTextStream", "showIme", "closeVoiceInputPanel", "currentTextStream", "buildNonStreamVoiceMixInputTouchListener", "Lcom/larus/common_ui/utils/CompoundTouchListener;", "afterEndAsrUi", "source", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleNonStreamVoiceMixInputMoveOrEnd", "event", "Landroid/view/MotionEvent;", "action", "getGlobalActionXY", "Lkotlin/Pair;", "", "getDeltaXY", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, DyPayConstant.KEY_SHOW_LOADING, "anchorView", "Landroid/widget/EditText;", "loadingResId", "currentText", "dismissLoading", "getController", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceMixInputComponent extends BaseContentWidget implements com.larus.bmhome.chat.component.bottom.voice.a {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final List<Integer> f300382x = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f300383m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f300384n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f300385o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f300386p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f300387q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.larus.bmhome.chat.component.bottom.voice.c f300388r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f300389s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f300390t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f300391u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f300392v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f300393w;

    public static final class a {
    }

    public static final class b implements com.larus.bmhome.chat.component.bottom.voice.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceMixInputComponent f300394a;

        @Override // com.larus.bmhome.chat.component.bottom.voice.b
        public final de8.c f1() {
            VoiceMixInputComponent r100 = this.f300394a;
            List<Integer> r101 = VoiceMixInputComponent.f300382x;
            return (de8.c) r100.f300385o.getValue();
        }

        @Override // com.larus.bmhome.chat.component.bottom.voice.b
        public FragmentActivity getActivity() {
            return s1a.a.getActivity(this.f300394a);
        }

        @Override // com.larus.bmhome.chat.component.bottom.voice.b
        public final va8.o w0() {
            VoiceMixInputComponent r100 = this.f300394a;
            List<Integer> r101 = VoiceMixInputComponent.f300382x;
            return (va8.o) r100.f300384n.getValue();
        }

        public b(VoiceMixInputComponent r100) {
            this.f300394a = r100;
        }
    }

    public static final class c implements com.larus.bmhome.chat.component.bottom.core.speaker.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceMixInputComponent f300395a;

        @Override // com.larus.bmhome.chat.component.bottom.core.speaker.e.b
        public final void A9() {
            VoiceMixInputComponent r100 = this.f300395a;
            List<Integer> r101 = VoiceMixInputComponent.f300382x;
            com.larus.bmhome.chat.component.bottom.core.speaker.l r102 = r100.B3();
            if (r102 == null) goto L6;
            r102.A9();
            return;
        }

        public c(VoiceMixInputComponent r100) {
            this.f300395a = r100;
        }

        @Override // com.larus.bmhome.chat.component.bottom.core.speaker.e.b
        public final void B9(com.larus.bmhome.chat.component.bottom.core.speaker.f r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            VoiceMixInputComponent r101 = this.f300395a;
            List<Integer> r102 = VoiceMixInputComponent.f300382x;
            com.larus.bmhome.chat.component.bottom.core.speaker.l r103 = r101.B3();
            if (r103 == null) goto L6;
            r103.e8(r100);
            return;
        }

        @Override // com.larus.bmhome.chat.component.bottom.core.speaker.e.b
        public final void C9(com.larus.bmhome.chat.component.bottom.core.speaker.f r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            VoiceMixInputComponent r101 = this.f300395a;
            List<Integer> r102 = VoiceMixInputComponent.f300382x;
            com.larus.bmhome.chat.component.bottom.core.speaker.l r103 = r101.B3();
            if (r103 == null) goto L6;
            r103.B9(r100);
            return;
        }

        @Override // com.larus.bmhome.chat.component.bottom.core.speaker.e.b
        public final void D9(Function1<? super String, Boolean> r100) {
            Intrinsics.checkNotNullParameter(r100, "handle");
            VoiceMixInputComponent r101 = this.f300395a;
            List<Integer> r102 = VoiceMixInputComponent.f300382x;
            com.larus.bmhome.chat.component.bottom.core.speaker.l r103 = r101.B3();
            if (r103 == null) goto L6;
            com.larus.bmhome.chat.component.bottom.core.speaker.l.a.b(r103, r100);
            return;
        }
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onStop() {
        com.larus.bmhome.chat.component.bottom.voice.a.C4042a.a(this, 3);
    }

    static {
        f300382x = CollectionsKt.listOf(new Integer[]{3, 4});
    }

    public final com.larus.bmhome.chat.component.bottom.core.speaker.l B3() {
        return (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.f300387q.getValue();
    }

    public final com.larus.bmhome.chat.component.bottom.core.speaker.e C3() {
        return (com.larus.bmhome.chat.component.bottom.core.speaker.e) this.f300392v.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final boolean OL() {
        return f300382x.contains(Integer.valueOf(Ef()));
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.bmhome.chat.component.bottom.voice.n] */
    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final v19.e QZ() {
        return new v19.e(new j(this), new k(this), new l(this), new m(this), new n(this), 32);
    }

    public final com.larus.bmhome.chat.component.bottom.voice.c m3() {
        com.larus.bmhome.chat.component.bottom.voice.c r100 = this.f300388r;
        if (r100 == null) goto L9;
        if (this.f300393w == true) goto L9;
        if (r100 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("uiController");
        goto L9
    L10:
        return r100;
    L9:
        return null;
    }

    public final z0<com.larus.bmhome.chat.component.bottom.voice.service.d> p3() {
        return (z0) this.f300390t.getValue();
    }

    public final VoiceMixInputService z3() {
        return (VoiceMixInputService) this.f300389s.getValue();
    }

    public VoiceMixInputComponent() {
        this.f300383m = LazyKt.lazy(new t(this));
        this.f300384n = LazyKt.lazy(new u(this));
        this.f300385o = LazyKt.lazy(new v(this));
        this.f300386p = LazyKt.lazy(new w(this));
        this.f300387q = LazyKt.lazy(new x(this));
        this.f300389s = LazyKt.lazy(new y(this));
        this.f300390t = LazyKt.lazy(new z());
        this.f300391u = LazyKt.lazy(new f());
        this.f300392v = LazyKt.lazy(new g(this));
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final boolean DG() {
        return z3().g();
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final int Ef() {
        z3().getClass();
        return VoiceMixInputService.d();
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final com.larus.bmhome.chat.component.bottom.voice.service.h Hw() {
        return z3().b();
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final void lP() {
        com.larus.bmhome.chat.component.bottom.voice.c r100 = m3();
        if (r100 == null) goto L6;
        r100.a(0);
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        C3().d("on_destroy");
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final boolean q40() {
        z3().getClass();
        return z2.f365865a.enableVoiceMixInput();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        if (q40() == false) goto L6;
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.bmhome.chat.component.bottom.voice.a.class);
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final void Cd(final LottieAnimationView r100) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        VoiceMixInputService r101 = z3();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "anchor");
        VoiceMixInputManager r102 = (VoiceMixInputManager) r101.f300462b.getValue();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "anchor");
        if (((Keva) r102.f300443a.getValue()).getBoolean("key_show_tips", false) == true) goto L7;
        ((Keva) r102.f300443a.getValue()).storeBoolean("key_show_tips", true);
        int r103 = d0.f300410d;
        d0.a.a("show tips");
        Function0 r104 = new com.larus.bmhome.chat.component.bottom.voice.service.o(r100);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewCompat.setWindowInsetsAnimationCallback(r100, new ViewExtKt$watchOnImeInsetsAnimationEndOnce$callback$1(r104, r100));
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final Job IL(f6 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        return z3().k(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final Job S50(h6 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        return z3().j(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final void T70(EditText r100) {
        ((com.larus.asr.f) this.f300391u.getValue()).a(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final Job a20(g6 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        return z3().i(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final Job jI(y5 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        return kotlinx.coroutines.flow.e.x(new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(p3(), new VoiceMixInputComponent$observeNonStreamDetailStatus$1(r100)), new VoiceMixInputComponent$observeNonStreamDetailStatus$2(null)), LifecycleOwnerKt.getLifecycleScope(this));
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (m3() == null) goto L5;
        return;
    L5:
        if (q40() == false) goto L18;
        b r101 = new b(this);
        z3().getClass();
        int r102 = VoiceMixInputService.d();
        if (r102 != 1) goto L9;
        final j0 r103 = new j0(new c0((ChatConstraintLayout) r100.findViewById(R.id.chat_root), true), (ViewGroup) r100.findViewById(R.id.voice_input_container));
        r103.f(r101);
        z3().i(new e(r103, this));
        this.f300388r = r103;
        return;
    L9:
        if (r102 != 2) goto L11;
        i0 r104 = new i0(new c0((ChatConstraintLayout) r100.findViewById(R.id.chat_root), false));
        Function0<Unit> r105 = new p(this);
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r104.f300428f = r105;
        r104.e(r101);
        this.f300388r = r104;
        return;
    L11:
        if (r102 != 4) goto L21;
        i0 r106 = new i0(new c0((ChatConstraintLayout) r100.findViewById(R.id.chat_root), false));
        Function0<Unit> r107 = new s(this);
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r106.f300428f = r107;
        r106.e(r101);
        this.f300388r = r106;
        int r108 = d0.f300410d;
        d0.a.a("observeNonStreamAsrSession");
        C3().e(new i(this));
        return;
    L21:
        return;
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final void x30(final d r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        this.f300393w = r110.f300406b;
        VoiceMixInputService r100 = z3();
        com.larus.bmhome.chat.component.cvs.y r101 = (com.larus.bmhome.chat.component.cvs.y) this.f300386p.getValue();
        Integer r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.Y1();
    L7:
        if (r103 != null) goto L9;
        String r104 = "";
    L10:
        de8.c r105 = (de8.c) this.f300385o.getValue();
        if (r105 == null) goto L15;
        Bundle r106 = r105.f468086b;
        if (r106 == null) goto L15;
        String r107 = r106.getString("item_id", "");
    L16:
        if (r107 != null) goto L18;
        String r108 = "";
    L19:
        com.larus.bmhome.chat.component.cvs.y r109 = (com.larus.bmhome.chat.component.cvs.y) this.f300386p.getValue();
        if (r109 == null) goto L22;
        String r111 = r109.getBotId();
    L23:
        if (r111 != null) goto L25;
        String r112 = "";
    L26:
        de8.c r113 = (de8.c) this.f300385o.getValue();
        if (r113 == null) goto L29;
        r102 = r113.m();
    L29:
        if (r102 == null) goto L31;
        boolean r114 = true;
    L32:
        r100.m(new com.larus.bmhome.chat.component.bottom.voice.service.f(r104, r108, r112, r114, r110.f300407c), r110.f300405a, s1a.a.getActivity(this), new o(this), new q(this), new r(this, r110), r110.f300409e);
        return;
    L31:
        r114 = false;
        goto L32
    L25:
        r112 = r111;
        goto L26
    L22:
        r111 = null;
        goto L23
    L18:
        r108 = r107;
    L15:
        r107 = null;
        goto L16
    L9:
        r104 = r103;
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    public static final Object h3(VoiceMixInputComponent r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof VoiceMixInputComponent$beforeStartNonStreamAsr$1) == false) goto L7;
        VoiceMixInputComponent$beforeStartNonStreamAsr$1 r102 = (VoiceMixInputComponent$beforeStartNonStreamAsr$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
    L29:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
    L25:
        z0<com.larus.bmhome.chat.component.bottom.voice.service.d> r107 = r100.p3();
        com.larus.bmhome.chat.component.bottom.voice.service.d.e r108 = com.larus.bmhome.chat.component.bottom.voice.service.d.e.f300478a;
        r102.label = 2;
        if (r107.emit(r108, r102) != r105) goto L29;
        return r105;
    L16:
        ResultKt.throwOnFailure(r104);
        r100.f300393w = false;
        com.larus.bmhome.chat.component.bottom.voice.c r109 = r100.m3();
        if (r109 == null) goto L19;
        r109.d();
    L19:
        VoiceMixInputService r110 = r100.z3();
        com.larus.bmhome.chat.component.bottom.voice.service.g r111 = new com.larus.bmhome.chat.component.bottom.voice.service.g(true, r100.Ef());
        r102.label = 1;
        Object r112 = r110.c().emit(r111, r102);
        if (r112 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        r112 = Unit.INSTANCE;
    L23:
        if (r112 != r105) goto L25;
        return r105;
    L7:
        r102 = new VoiceMixInputComponent$beforeStartNonStreamAsr$1(r100, r101);
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final void ql(boolean r100, final boolean r101) {
        if (Ef() != 4) goto L5;
        C3().b();
        return;
    L5:
        z3().h(r100, new h(this, r101));
    }

    public static final Object Y2(VoiceMixInputComponent r100, String r101, Continuation r102) {
        r100.getClass();
        int r103 = d0.f300410d;
        d0.a.a("afterEndAsrUi source=".concat(r101));
        com.larus.bmhome.chat.component.bottom.voice.c r104 = r100.m3();
        if (r104 == null) goto L5;
        r104.c();
    L5:
        r100.f300393w = true;
        VoiceMixInputService r105 = r100.z3();
        com.larus.bmhome.chat.component.bottom.voice.service.g r106 = new com.larus.bmhome.chat.component.bottom.voice.service.g(false, r100.Ef());
        Object r107 = r105.c().emit(r106, r102);
        if (r107 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        r107 = Unit.INSTANCE;
    L10:
        if (r107 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r107;
    L13:
        return Unit.INSTANCE;
    }

    public final void D3(View r100, MotionEvent r101, int r102) {
        Rect r103 = new Rect();
        r100.getGlobalVisibleRect(r103);
        Pair r104 = new Pair(Float.valueOf(r103.left + r101.getX()), Float.valueOf(r103.top + r101.getY()));
        Object r105 = r100.getTag(R.id.chat_input_touch_delta);
        Float r106 = null;
        if ((r105 instanceof Pair) == false) goto L5;
        Pair r107 = (Pair) r105;
    L7:
        if (r107 != null) goto L9;
        Pair r108 = TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(0.0f));
    L21:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r109 = B3();
        if (r109 == null) goto L25;
        r109.pv(r102, ((Number) r104.getFirst()).floatValue(), ((Number) r104.getSecond()).floatValue(), ((Number) r108.getFirst()).floatValue(), ((Number) r108.getSecond()).floatValue());
        return;
    L25:
        return;
    L9:
        r100.setTag(R.id.chat_input_touch_delta, null);
        Object r110 = r107.getFirst();
        if ((r110 instanceof Float) == false) goto L12;
        Float r111 = (Float) r110;
    L13:
        if (r111 == null) goto L20;
        float r112 = r111.floatValue();
        Object r113 = r107.getSecond();
        if ((r113 instanceof Float) == false) goto L17;
        r106 = (Float) r113;
    L17:
        if (r106 == null) goto L19;
        r108 = TuplesKt.to(Float.valueOf(r112), Float.valueOf(r106.floatValue()));
        goto L21
    L19:
        r108 = TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(0.0f));
        goto L21
    L20:
        r108 = TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(0.0f));
        goto L21
    L12:
        r111 = null;
        goto L13
    L5:
        r107 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.component.bottom.voice.a
    public final void jj(EditText r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "currentText");
        ((com.larus.asr.f) this.f300391u.getValue()).b(r100, r101, r102);
    }
}
