package com.larus.voicecall.impl.component.denoise;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.keva.Keva;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.av_call.view.VoiceCallBottomLayout;
import com.larus.bmhome.chat.model.repo.SettingRepoDelegate;
import com.larus.bmhome.view.screenmenu.n1;
import com.larus.common.apphost.AppHost;
import com.larus.im.service.audio.z0;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.RealtimeCallService;
import com.larus.voicecall.impl.component.dialog.RealtimeDialogTriggerTime;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.skydoves.balloon.Balloon;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000Ñ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n*\u0001Y\u0018\u0000 \u008c\u00012\u00020\u00012\u00020\u0002:\u0002\u008c\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010[\u001a\u00020TH\u0016J\b\u0010\\\u001a\u00020TH\u0016J\b\u0010]\u001a\u00020TH\u0002J(\u0010^\u001a\u00020T2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020`2\u0006\u0010c\u001a\u00020\nH\u0016J\b\u0010d\u001a\u00020\u001fH\u0002J\b\u0010e\u001a\u00020TH\u0002J\u0010\u0010f\u001a\u00020T2\u0006\u0010g\u001a\u00020hH\u0016J\b\u0010i\u001a\u00020TH\u0002J\u0010\u0010j\u001a\u00020T2\u0006\u0010k\u001a\u00020\u0006H\u0002J$\u0010l\u001a\u00020T2\u0006\u0010m\u001a\u00020\u001f2\u0006\u0010n\u001a\u00020\u001f2\n\b\u0002\u0010o\u001a\u0004\u0018\u00010\u0006H\u0002J$\u0010p\u001a\u00020T2\u0006\u0010m\u001a\u00020\u001f2\u0006\u0010n\u001a\u00020\u001f2\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u0006H\u0002J\f\u0010r\u001a\u00020s*\u00020sH\u0002J\b\u0010t\u001a\u00020TH\u0002J\u0016\u0010u\u001a\u00020v2\f\u0010w\u001a\b\u0012\u0004\u0012\u00020T0xH\u0016J\b\u0010y\u001a\u00020TH\u0016J\b\u0010z\u001a\u00020TH\u0016J\u0018\u0010{\u001a\u00020T2\u0006\u0010|\u001a\u00020\u001f2\u0006\u0010k\u001a\u00020\u0006H\u0016J\u0010\u0010}\u001a\u00020T2\u0006\u0010~\u001a\u00020\u0006H\u0002J\u0019\u0010\u007f\u001a\u00020T2\u0006\u0010n\u001a\u00020\u001f2\u0007\u0010\u0080\u0001\u001a\u00020\u001fH\u0002J4\u0010\u0081\u0001\u001a\u00020T2\u0014\u0010\u0082\u0001\u001a\u000f\u0012\u0005\u0012\u00030\u0083\u0001\u0012\u0004\u0012\u00020T0R2\u0013\u0010\u0084\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020T0RH\u0002J\t\u0010\u0085\u0001\u001a\u00020TH\u0002J\u0014\u0010\u0086\u0001\u001a\u00020\u00062\t\b\u0001\u0010\u0087\u0001\u001a\u00020\nH\u0002J\u0018\u0010\u0088\u0001\u001a\u00020T*\u00020\u00062\t\b\u0002\u0010\u0089\u0001\u001a\u00020sH\u0002J\u0011\u0010\u008a\u0001\u001a\u00020T2\u0006\u0010|\u001a\u00020\u001fH\u0002J\t\u0010\u008b\u0001\u001a\u00020TH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001b\u0010\u001cR$\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R(\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010%8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\"R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0010\u001a\u0004\b.\u0010/R\u0016\u00101\u001a\u0004\u0018\u0001028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u000e\u00105\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020908X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010<\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0010\u001a\u0004\b>\u0010?R\u001b\u0010A\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\u0010\u001a\u0004\bC\u0010DR\u001b\u0010F\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0010\u001a\u0004\bH\u0010IR\u0010\u0010K\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010L\u001a\u0004\u0018\u00010M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u0010\u001a\u0004\bN\u0010OR\u001a\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020T0RX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010U\u001a\u00020S2\u0006\u0010\u001e\u001a\u00020S@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bV\u0010WR\u0010\u0010X\u001a\u00020YX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z¨\u0006\u008d\u0001"}, d2 = {"Lcom/larus/voicecall/impl/component/denoise/RealtimeDenoiseComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/denoise/IRealtimeDenoiseAbility;", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "currentUIState", "", "topAbility", "Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "getTopAbility", "()Lcom/larus/voicecall/impl/component/top/IRealtimeTopAbility;", "topAbility$delegate", "Lkotlin/Lazy;", "reportJob", "Lkotlinx/coroutines/Job;", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getKeva", "()Lcom/bytedance/keva/Keva;", "keva$delegate", "interpretAbility", "Lcom/larus/voicecall/impl/interpret/IRealtimeInterpretAbility;", "getInterpretAbility", "()Lcom/larus/voicecall/impl/interpret/IRealtimeInterpretAbility;", "interpretAbility$delegate", "value", "", "hasColdShowAuthDialogInKeva", "getHasColdShowAuthDialogInKeva", "()Z", "setHasColdShowAuthDialogInKeva", "(Z)V", "Lcom/larus/voicecall/impl/component/denoise/DenoiseStatusRes;", "lastVoiceFeatureStatusInKeva", "getLastVoiceFeatureStatusInKeva", "()Lcom/larus/voicecall/impl/component/denoise/DenoiseStatusRes;", "setLastVoiceFeatureStatusInKeva", "(Lcom/larus/voicecall/impl/component/denoise/DenoiseStatusRes;)V", "isDenoiseSwitchClickAble", "callService", "Lcom/larus/voicecall/impl/RealtimeCallService;", "getCallService", "()Lcom/larus/voicecall/impl/RealtimeCallService;", "callService$delegate", "denoisePlugin", "Lcom/larus/voicecall/impl/plugins/IRealtimeDenoiseProvider;", "getDenoisePlugin", "()Lcom/larus/voicecall/impl/plugins/IRealtimeDenoiseProvider;", "hasManualCloseDenoise", "hasSNRNoticed", "asrInfoMap", "", "", "balloon", "Lcom/skydoves/balloon/Balloon;", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "tracer", "Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "getTracer", "()Lcom/larus/audio/call/tracer/IRealtimeCallTracer;", "tracer$delegate", "firstEnterJob", "bottomAbility", "Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "getBottomAbility", "()Lcom/larus/voicecall/impl/component/bottom/IRealtimeBottomAbility;", "bottomAbility$delegate", "closeDenoiseGuideStateTransfer", "Lkotlin/Function1;", "Lcom/larus/voicecall/impl/component/denoise/snr/RealtimeBaseDenoiseSNRState;", "", "closeDenoiseGuideState", "setCloseDenoiseGuideState", "(Lcom/larus/voicecall/impl/component/denoise/snr/RealtimeBaseDenoiseSNRState;)V", "dialogExecutor", "com/larus/voicecall/impl/component/denoise/RealtimeDenoiseComponent$dialogExecutor$1", "Lcom/larus/voicecall/impl/component/denoise/RealtimeDenoiseComponent$dialogExecutor$1;", "onAttach", "onVContextReady", "triggerUpdateAsrInfo", "onUpdateUIState", "currentMajorState", "Lcom/larus/audio/call/mgr/MajorState;", "currentState", "newMajorState", "newState", "canCheckSnr", "storeSNRNoticeShow", "onReceiveEvent", "event", "Lcom/larus/im/service/audio/MediaSessionListener$Event;", "showDenoiseTips", "showDeNoiseAuthDialog", "source", "mobNoiseFreeSettingResult", "success", "toOpen", "errorMsg", "mobVoiceFeatureAuthResult", "errMsg", "appendBaseParam", "Lorg/json/JSONObject;", "showOpenDenoiseToast", "getDenoiseSwitch", "Lcom/larus/bmhome/view/screenmenu/SwitchMenuV2;", "onSwitchClicked", "Lkotlin/Function0;", "onMenuItemClicked", LiveCommonConstants.REASON_ON_DEDTROY, "onDenoiseSwitchChanged", "isOpen", "mobNoiseFreeResultToastShow", "toastType", "mobClickNoiseFreeSwitch", "fromOpen", "startAuthAndOpenRequest", "onSuccess", "Lcom/larus/voicecall/impl/component/denoise/DenoiseReportRes;", "onFail", "updateDenoiseGuideStatus", "formatDouBaoString", PickerReporterConstants.KEY.TARGET, "mob", "jsonObject", "tryStartChangeDenoiseSwitchRequest", "onFragmentViewDestroyed", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeDenoiseComponent extends RealtimeComponent implements g {
    public static final /* synthetic */ int D = 0;
    public final Lazy A;
    public com.larus.voicecall.impl.component.denoise.snr.a B;
    public final RealtimeDenoiseComponent$dialogExecutor$1 C;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f377360n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f377361o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Job f377362p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f377363q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f377364r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f377365s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f377366t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Map<String, ? extends Object> f377367u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Balloon f377368v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f377369w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f377370x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f377371y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Job f377372z;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f377373a = null;

        static {
            int[] r100 = new int[DenoiseStatusRes.values().length];
            r100[DenoiseStatusRes.FEATURE_ENABLED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[DenoiseStatusRes.LEARNING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[DenoiseStatusRes.FEATURE_DISABLED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f377373a = r100;
        }
    }

    public static final class c implements w3a.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RealtimeDenoiseComponent f377374a;

        public c(RealtimeDenoiseComponent r100) {
            this.f377374a = r100;
        }

        @Override // w3a.i
        public final void a(w3a.h r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            if ((r100 instanceof w3a.j) == false) goto L6;
            RealtimeDenoiseComponent r101 = this.f377374a;
            int r102 = RealtimeDenoiseComponent.D;
            r101.c4();
            return;
        }
    }

    static {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void A2() {
        RealtimeCallUtil.f379424a.getClass();
        W3(RealtimeCallUtil.f379455t);
    }

    public final e3a.b C3() {
        return (e3a.b) this.f377370x.getValue();
    }

    public final String D3() {
        return "DenoiseComponent_" + C3().a().f288743d;
    }

    @Override // com.larus.voicecall.impl.component.denoise.g
    public final void YY() {
        u3a.a r100 = (u3a.a) this.f377364r.getValue();
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L11;
        t19.s.j(t19.s.f544207a, AppHost.f326268a.getApplication(), getContext().getResources().getString(R.string.larus_interpreting_mode_toast_voiceFocusOff), null, false, 28);
        return;
    L11:
        Z3();
        RealtimeCallUtil.f379424a.getClass();
        if (RealtimeCallUtil.G() == false) goto L18;
        if (RealtimeCallUtil.f379455t != DenoiseStatusRes.LEARNING) goto L18;
        t19.s.j(t19.s.f544207a, getContext(), p3(R.string.larus_voiceFocus_toast_stillLearn), null, false, 28);
        G3("still_study");
        E3(false, false);
        return;
    L18:
        if (RealtimeCallUtil.G() == false) goto L27;
        int r103 = b.f377373a[RealtimeCallUtil.f379455t.ordinal()];
        if (r103 != 1) goto L22;
        r101 = false;
    L26:
        V3(r101, "onMenuItemClicked");
        return;
    L22:
        if (r103 == 3) goto L26;
        FLogger.f375446a.e(D3(), "onMenuItemClicked, current status is " + RealtimeCallUtil.f379455t);
        return;
    L27:
        X3("item_click");
        return;
    L5:
        if (r100.YM() != true) goto L7;
        r102 = true;
        goto L8
    }

    public final void c4() {
        com.larus.voicecall.impl.component.denoise.snr.a r100 = this.B;
        if (this.f377360n != 3) goto L5;
        boolean r101 = true;
    L6:
        boolean r102 = C3().f484272m;
        RealtimeCallUtil.f379424a.getClass();
        r100.e(r101, r102, RealtimeCallUtil.t());
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        Job r100 = this.f377372z;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f377372z = null;
        Balloon r101 = this.f377368v;
        if (r101 == null) goto L8;
        r101.h();
    L8:
        this.B.d();
        Job r102 = this.f377362p;
        if (r102 == null) goto L11;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L11:
        this.f377362p = null;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, g.class);
    }

    public final Keva z3() {
        return (Keva) this.f377363q.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [com.larus.voicecall.impl.component.denoise.RealtimeDenoiseComponent$dialogExecutor$1] */
    public RealtimeDenoiseComponent() {
        this.f377360n = -1;
        this.f377361o = LazyKt.lazy(new h(this));
        this.f377363q = LazyKt.lazy(new s());
        this.f377364r = LazyKt.lazy(new w(this));
        this.f377365s = LazyKt.lazy(new x(this));
        this.f377367u = MapsKt.emptyMap();
        this.f377369w = LazyKt.lazy(new y(this));
        this.f377370x = LazyKt.lazy(new z(this));
        this.f377371y = LazyKt.lazy(new a0(this));
        this.A = LazyKt.lazy(new b0(this));
        this.B = new com.larus.voicecall.impl.component.denoise.snr.c(new c0(this));
        this.C = new RealtimeDenoiseComponent$dialogExecutor$1(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.larus.voicecall.impl.component.denoise.j] */
    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void A0() {
        Z3();
        com.larus.voicecall.impl.plugins.t r100 = (com.larus.voicecall.impl.plugins.t) LLMCallController.y(((RealtimeCallService) this.f377365s.getValue()).f377099u, Reflection.getOrCreateKotlinClass(com.larus.voicecall.impl.plugins.t.class));
        if (r100 == 0) goto L5;
        r100.F0(new j(this));
    L5:
        RealtimeDialogTriggerTime r101 = RealtimeDialogTriggerTime.ON_COMMON_AUDIO_CONFIG;
        RealtimeDenoiseComponent$dialogExecutor$1 r102 = this.C;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r101, "triggerTime");
        Intrinsics.checkNotNullParameter(r102, "executor");
        h3a.c r103 = (h3a.c) s1a.d.a(this).a(h3a.c.class);
        if (r103 == null) goto L13;
        Intrinsics.checkNotNullParameter(r101, "triggerTime");
        Intrinsics.checkNotNullParameter(r102, "executor");
        if (((Map) r103.f483728a.getValue()).containsKey(r101) == false) goto L12;
        List r104 = (List) ((Map) r103.f483728a.getValue()).get(r101);
        if (r104 == null) goto L13;
        r104.add(r102);
        goto L13
    L12:
        ((Map) r103.f483728a.getValue()).put(r101, CollectionsKt.mutableListOf(new h3a.a[]{r102}));
    L13:
        ((w3a.k) s1a.d.a(this).f(w3a.k.class)).c(new c(this));
    }

    public final DenoiseStatusRes B3() {
        Keva r100 = z3();
        String r101 = "last_voice_feature_status_".concat(AccountService.f365697a.getSecUserId());
        DenoiseStatusRes r102 = DenoiseStatusRes.UNKNOWN;
        int r103 = r100.getInt(r101, r102.getValue());
        if (r103 != 0) goto L5;
        return r102;
    L5:
        if (r103 == 1) goto L14;
        if (r103 == 2) goto L17;
        if (r103 == 3) goto L16;
        return r102;
    L16:
        return DenoiseStatusRes.FEATURE_DISABLED;
    L17:
        return DenoiseStatusRes.FEATURE_ENABLED;
    L14:
        return DenoiseStatusRes.LEARNING;
    }

    public final void Z3() {
        boolean r100 = false;
        if (m3() == false) goto L13;
        RealtimeCallUtil.f379424a.getClass();
        if (RealtimeCallUtil.t() == true) goto L13;
        if (this.f377366t == true) goto L13;
        if (this.f377360n != 3) goto L13;
        if (RealtimeCallUtil.f379455t == DenoiseStatusRes.LEARNING) goto L13;
        boolean r101 = true;
    L14:
        Pair[] r102 = new Pair[5];
        if (u3a.f.e() == false) goto L17;
        boolean r103 = false;
    L18:
        r102[0] = TuplesKt.to("is_denoise_feature_enable", Boolean.valueOf(r103));
        RealtimeCallUtil.f379424a.getClass();
        if (RealtimeCallUtil.f379455t != DenoiseStatusRes.FEATURE_ENABLED) goto L21;
    L22:
        r100 = true;
    L23:
        r102[1] = TuplesKt.to("is_feat_learning_done", Boolean.valueOf(r100));
        r102[2] = TuplesKt.to("is_feat_learning_enable", Boolean.valueOf(RealtimeCallUtil.G()));
        r102[3] = TuplesKt.to("check_audio_snr", Boolean.valueOf(r101));
        r102[4] = TuplesKt.to("too_long_sv", Boolean.valueOf(this.B instanceof com.larus.voicecall.impl.component.denoise.snr.d));
        Map<String, ? extends Object> r104 = MapsKt.mutableMapOf(r102);
        if (Intrinsics.areEqual(r104.toString(), this.f377367u.toString()) == true) goto L26;
        FLogger r105 = FLogger.f375446a;
        r105.i(D3(), "triggerUpdateAsrInfo asr_info change. new=" + r104 + " old=" + this.f377367u + " closeDenoiseGuideState=" + this.B.a() + ' ');
        r105.i(D3(), "triggerUpdateAsrInfo snrCheck=" + r101 + "  hasSNRNoticed=false canCheckSnr=" + m3() + " hasManualCloseDenoise=" + this.f377366t + " currentUIState=" + this.f377360n + " denoiseStatus=" + RealtimeCallUtil.f379455t);
    L26:
        this.f377367u = r104;
        return;
    L21:
        if (RealtimeCallUtil.f379455t != DenoiseStatusRes.FEATURE_DISABLED) goto L23;
    L17:
        RealtimeCallUtil.f379424a.getClass();
        r103 = RealtimeCallUtil.t();
    L13:
        r101 = false;
        goto L14
    }

    public final boolean m3() {
        long r100 = System.currentTimeMillis();
        Keva r101 = z3();
        AccountService r102 = AccountService.f365697a;
        if ((r100 - r101.getLong("KEVA_KEY_SNR_LAST_DATE_".concat(r102.getSecUserId()), 0)) <= 86400000) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L10;
        z3().storeInt("KEVA_KEY_SNR_TIMES_".concat(r102.getSecUserId()), 0);
    L10:
        if (z3().getInt("KEVA_KEY_SNR_TIMES_".concat(r102.getSecUserId()), 0) < 2) goto L14;
        return false;
    L14:
        return true;
    L5:
        r103 = false;
        goto L7
    }

    public static String p3(int r100) {
        int r101 = j0.f375426a;
        String r102 = j0.d(r100);
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        return String.format(Locale.CHINA, r102, Arrays.copyOf(new Object[]{j0.d(R.string.larus_memo_record_push_recording_title)}, 1));
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void D9(z0.a r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        Intrinsics.checkNotNullParameter(r110, "event");
        if ((r110 instanceof pf9.o) == true) goto L90;
        boolean r100 = true;
        String r101 = null;
        if ((r110 instanceof pf9.l) == false) goto L62;
        pf9.l r111 = (pf9.l) r110;
        int r102 = r111.f528937a;
        VoiceFeatureAuthStatus[] r103 = VoiceFeatureAuthStatus.values();
        int r104 = r103.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L15;
        VoiceFeatureAuthStatus r106 = r103[r105];
        if (r106.getValue() != r102) goto L11;
        boolean r107 = true;
    L12:
        if (r107 == true) goto L16;
        r105 = r105 + 1;
    L16:
        if (r106 != null) goto L18;
        r106 = VoiceFeatureAuthStatus.UNAUTHORIZED;
    L18:
        int r108 = r111.f528938b;
        if (r108 == 0) goto L29;
        if (r108 != 1) goto L22;
        DenoiseStatusRes r109 = DenoiseStatusRes.LEARNING;
    L30:
        FLogger r112 = FLogger.f375446a;
        r112.i(D3(), "onReceiveEvent, FlowLLMAudioConfigEvent voiceFeatureAuthor_value=" + r111.f528937a + "  denoiseStatus_value=" + r111.f528938b + " authStatus=" + r106.getDesc() + " denoiseStatus=" + r109.getDesc());
        RealtimeCallUtil.f379424a.getClass();
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        RealtimeCallUtil.f379455t = r109;
        VoiceFeatureAuthStatus r113 = VoiceFeatureAuthStatus.AUTHORIZED;
        if (r106 != r113) goto L33;
        boolean r114 = true;
    L35:
        if (r114 == RealtimeCallUtil.G()) goto L41;
        SettingRepoDelegate r115 = SettingRepoDelegate.f307752b;
        if (r106 != r113) goto L39;
        boolean r116 = true;
    L40:
        r115.k(r116);
        goto L41
    L39:
        r116 = false;
    L41:
        if (r114 == true) goto L43;
    L45:
        r100 = false;
    L46:
        JSONObject r117 = new JSONObject();
        if (r100 == false) goto L49;
        String r118 = "1";
    L50:
        r117.put("is_noise_free", r118);
        Unit r119 = Unit.INSTANCE;
        com.larus.platform.service.o r120 = com.larus.platform.service.o.f365780a;
        h3(r117);
        r120.reportEvent("call_noise_free_result", r117);
        if (B3() != DenoiseStatusRes.LEARNING) goto L56;
        if (r114 == false) goto L56;
        if (r109 != DenoiseStatusRes.FEATURE_ENABLED) goto L56;
        t19.s r121 = t19.s.f544207a;
        Context r122 = getContext();
        r121.getClass();
        t19.s.o(r122, R.string.larus_voiceFocus_toast_turnOn, false);
        r112.i(D3(), "notice denoise enable.on FlowLLMAudioConfigEvent");
    L60:
        W3(r109);
        return;
    L56:
        String r123 = D3();
        StringBuilder r124 = new StringBuilder("do not show denoise enable toast. lastVoiceFeatureStatusInKeva=");
        DenoiseStatusRes r125 = B3();
        if (r125 == null) goto L59;
        r101 = r125.getDesc();
    L59:
        r124.append(r101);
        r124.append("  isAuthorize=");
        r124.append(r114);
        r124.append(" denoiseStatus=");
        r124.append(r109.getDesc());
        r112.w(r123, r124.toString());
        goto L60
    L49:
        r118 = "0";
        goto L50
    L43:
        if (r109 != DenoiseStatusRes.FEATURE_ENABLED) goto L45;
    L33:
        r114 = false;
        goto L35
    L22:
        if (r108 != 2) goto L24;
        r109 = DenoiseStatusRes.FEATURE_ENABLED;
        goto L30
    L24:
        if (r108 == 3) goto L26;
        r109 = DenoiseStatusRes.UNKNOWN;
        goto L30
    L26:
        r109 = DenoiseStatusRes.FEATURE_DISABLED;
        goto L30
    L29:
        r109 = DenoiseStatusRes.UNKNOWN;
        goto L30
    L11:
        r107 = false;
        goto L12
    L15:
        r106 = null;
        goto L16
    L62:
        if ((r110 instanceof pf9.c0) == false) goto L74;
        pf9.a r126 = ((pf9.c0) r110).f528895a;
        if (r126 == null) goto L66;
        r101 = r126.f528874a;
    L66:
        if (r101 != null) goto L68;
    L71:
        if (r100 == false) goto L92;
        this.B.c();
        return;
    L92:
        return;
    L68:
        if (r101.length() == 0) goto L71;
        r100 = false;
        goto L71
    L74:
        if ((r110 instanceof pf9.k) == false) goto L81;
        this.B.b();
        FLogger.f375446a.i(D3(), "onReceiveEvent, FlowLLMAsrRejectEvent");
        com.larus.voicecall.impl.component.bottom.b r127 = (com.larus.voicecall.impl.component.bottom.b) this.A.getValue();
        if (r127 == null) goto L94;
        VoiceCallBottomLayout r128 = r127.BT();
        if (r128 == null) goto L95;
        r128.post(new o(this));
        return;
    L95:
        return;
    L94:
        return;
    L81:
        if ((r110 instanceof pf9.j) == false) goto L97;
        FLogger r129 = FLogger.f375446a;
        String r130 = D3();
        StringBuilder r131 = new StringBuilder("onReceiveEvent, FlowLLMAsrNoiseInfoEvent isAdded=");
        Intrinsics.checkNotNullParameter(this, "<this>");
        r131.append(com.larus.ui.arch.component.internal.attach.a.b(this, this).isAdded());
        r129.i(r130, r131.toString());
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).isAdded() == false) goto L98;
        Intrinsics.checkNotNullParameter(this, "<this>");
        View r132 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getView();
        if (r132 == null) goto L99;
        r132.post(new p(this));
        return;
    L99:
        return;
    L98:
        return;
    L97:
        return;
    }

    public final void G3(String r100) {
        com.larus.platform.service.o r101 = com.larus.platform.service.o.f365780a;
        JSONObject r102 = new JSONObject();
        ((IRealtimeCallTracer) this.f377371y.getValue()).x(com.larus.voicecall.impl.util.d.c(r102));
        h3(r102);
        r102.put("toast_type", r100);
        Unit r103 = Unit.INSTANCE;
        r101.reportEvent("noise_free_result_toast_show", r102);
    }

    public final void W3(DenoiseStatusRes r100) {
        Keva r101 = z3();
        String r102 = "last_voice_feature_status_".concat(AccountService.f365697a.getSecUserId());
        if (r100 != null) goto L6;
        r100 = DenoiseStatusRes.UNKNOWN;
    L6:
        r101.storeInt(r102, r100.getValue());
    }

    public final void X3(String r100) {
        boolean r101 = true;
        z3().storeBoolean("has_cold_show_auth_dialog", true);
        DeNoiseAuthDialog r102 = new DeNoiseAuthDialog(new d0(this), new i(this));
        JSONObject r103 = new JSONObject();
        r103.put("current_page", "chat");
        r103.put("source", r100);
        r103.put("call_id", C3().a().f288745e);
        r102.f377351f = r103;
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r104 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r104 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == false) goto L11;
        FLogger.f375446a.e(D3(), "showDeNoiseAuthDialog failed. activity is finishing!");
        return;
    L11:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r106 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r106 != null) goto L14;
    L16:
        r101 = false;
    L17:
        if (r101 == false) goto L20;
        FLogger.f375446a.e(D3(), "showDeNoiseAuthDialog failed. activity is isDestroyed!");
        return;
    L20:
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).isAdded() == false) goto L34;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).isDetached() == true) goto L34;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).isRemoving() == true) goto L34;
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Throwable -> L32
        FragmentManager r107 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getChildFragmentManager();     // Catch: Throwable -> L32
        String r108 = D3();     // Catch: Throwable -> L32
        LandscapeRestrictionOperation r109 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Throwable -> L32
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r102, r108, r109);     // Catch: Throwable -> L32
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r107, r102, r109) == true) goto L42;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L36 Throwable -> L32
    L30:
        r102.show(r107, r108);     // Catch: Throwable -> L32
        return;
    L42:
        return;
    L32:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th);
        FLogger.f375446a.e(D3(), "showDeNoiseAuthDialog failed. e=" + th);
        return;
    L34:
        FLogger r110 = FLogger.f375446a;
        String r111 = D3();
        StringBuilder r112 = new StringBuilder("isAdded=");
        Intrinsics.checkNotNullParameter(this, "<this>");
        r112.append(com.larus.ui.arch.component.internal.attach.a.b(this, this).isAdded());
        r112.append("  isDetached=");
        Intrinsics.checkNotNullParameter(this, "<this>");
        r112.append(com.larus.ui.arch.component.internal.attach.a.b(this, this).isDetached());
        r112.append("  isRemoving=");
        Intrinsics.checkNotNullParameter(this, "<this>");
        r112.append(com.larus.ui.arch.component.internal.attach.a.b(this, this).isRemoving());
        r110.e(r111, r112.toString());
        return;
    L14:
        if (r106.isDestroyed() != true) goto L16;
    L5:
        if (r104.isFinishing() != true) goto L7;
        r105 = true;
        goto L8
    }

    public final void a4(boolean r100) {
        Job r101 = this.f377362p;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L24;
        Job r104 = this.f377362p;
        if (r104 != null) goto L12;
    L14:
        boolean r105 = false;
    L15:
        if (r105 == false) goto L24;
        Job r106 = this.f377362p;
        if (r106 != null) goto L19;
    L21:
        if (r102 == false) goto L24;
        t19.s r107 = t19.s.f544207a;
        Context r108 = getContext();
        int r109 = j0.f375426a;
        t19.s.j(r107, r108, j0.d(R.string.larus_botsComment_commentPanel_errToast_shark_reject), null, false, 28);
        FLogger.f375446a.e(D3(), "onDenoiseSwitchChanged target status is " + r100 + ". but net request is working");
        return;
    L19:
        if (r106.isCancelled() == true) goto L21;
        r102 = true;
        goto L21
    L12:
        if (r104.isCompleted() == true) goto L14;
        r105 = true;
    L24:
        this.f377362p = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new RealtimeDenoiseComponent$tryStartChangeDenoiseSwitchRequest$1(r100, this, null), 2, null);
        return;
    L5:
        if (r101.isActive() != true) goto L7;
        r103 = true;
        goto L8
    }

    public final void h3(JSONObject r100) {
        r100.put("current_page", "chat");
        r100.put("call_id", C3().a().f288745e);
    }

    @Override // com.larus.voicecall.impl.component.denoise.g
    public final n1 rC(final Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "onSwitchClicked");
        int r100 = j0.f375426a;
        String r101 = j0.d(R.string.larus_voiceFocus_onboarding_title_callNoise);
        RealtimeCallUtil.f379424a.getClass();
        boolean r111 = RealtimeCallUtil.t();
        int r102 = 0;
        if (RealtimeCallUtil.f379455t == DenoiseStatusRes.LEARNING) goto L5;
        boolean r103 = true;
    L6:
        boolean r112 = !r103;
        int r104 = v19.c.b(R.attr.larus_ic_denoise_dialog_title_icon, null, R.drawable.larus_ic_denoise_dialog_title_icon);
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Throwable -> L9
        r102 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getResources().getColor(R.color.neutral_100);     // Catch: Throwable -> L9
    L15:
        return new n1(4, false, r101, null, Integer.valueOf(r104), Integer.valueOf(r102), false, false, r111, r112, new n(r110, this), null, u3a.f.e());
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Throwable r107 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r107 == null) goto L15;
        FLogger.f375446a.e("RealtimeComponent", "onErr=" + r107 + " color=2131103681 clazz=" + RealtimeDenoiseComponent.class);
        goto L15
    L5:
        r103 = false;
        goto L6
    }

    public static void Q3(RealtimeDenoiseComponent r100, boolean r101) {
        com.larus.platform.service.o r102 = com.larus.platform.service.o.f365780a;
        JSONObject r103 = new JSONObject();
        r100.h3(r103);
        r103.put("scene", "turn_on_voice_feature_auth");
        r103.put("success", 1);
        if (r101 == false) goto L5;
        String r104 = "on";
    L6:
        r103.put("to_status", r104);
        r103.put("error_reason", null);
        Unit r105 = Unit.INSTANCE;
        r102.reportEvent("voice_feature_auth_setting_result", r103);
        return;
    L5:
        r104 = "off";
        goto L6
    }

    public final void E3(boolean r100, boolean r101) {
        com.larus.platform.service.o r102 = com.larus.platform.service.o.f365780a;
        JSONObject r103 = new JSONObject();
        ((IRealtimeCallTracer) this.f377371y.getValue()).x(com.larus.voicecall.impl.util.d.c(r103));
        h3(r103);
        String r104 = "on";
        if (r101 == false) goto L5;
        Object r105 = "on";
    L6:
        r103.put("from_status", r105);
        if (r100 == true) goto L10;
        r104 = "off";
    L10:
        r103.put("to_status", r104);
        String r106 = "0";
        if (C3().a().f288756p.f288869q == false) goto L13;
    L16:
        Object r107 = "1";
    L17:
        r103.put("is_continuous_speak", r107);
        if (C3().a().f288739b == false) goto L20;
        r106 = "1";
    L20:
        r103.put("is_obric_continuous_talk", r106);
        Unit r108 = Unit.INSTANCE;
        r102.reportEvent("click_noise_free_switch", r103);
        return;
    L13:
        if (C3().a().f288737a == true) goto L16;
        r107 = "0";
        goto L17
    L5:
        r105 = "off";
        goto L6
    }

    public final void V3(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        RealtimeCallUtil.f379424a.getClass();
        if (RealtimeCallUtil.G() == true) goto L7;
        if (r100 == false) goto L7;
        FLogger.f375446a.i(D3(), "onDenoiseSwitchChanged isOpen=" + r100 + ". cur not auth, so show the auth dialog");
        X3("user_initiative_click");
        return;
    L7:
        if (r100 == true) goto L9;
    L14:
        if (r100 == true) goto L16;
    L21:
        if (r100 == false) goto L23;
    L26:
        E3(r100, !r100);
        a4(r100);
        return;
    L23:
        if (RealtimeCallUtil.t() == true) goto L26;
        t19.s r102 = t19.s.f544207a;
        Context r103 = getContext();
        int r104 = j0.f375426a;
        t19.s.j(r102, r103, j0.d(R.string.larus_voiceFocus_toast_turnOff), null, false, 28);
        FLogger.f375446a.e(D3(), "user hope to close, but already close.");
        return;
    L16:
        if (RealtimeCallUtil.G() == false) goto L21;
        if (RealtimeCallUtil.f379455t != DenoiseStatusRes.LEARNING) goto L21;
        t19.s.j(t19.s.f544207a, getContext(), p3(R.string.larus_voiceFocus_toast_startLearn), null, false, 28);
        FLogger.f375446a.e(D3(), "user hope to open, but already in learn state.");
        return;
    L9:
        if (RealtimeCallUtil.G() == false) goto L14;
        if (RealtimeCallUtil.f379455t != DenoiseStatusRes.FEATURE_ENABLED) goto L14;
        t19.s r105 = t19.s.f544207a;
        Context r106 = getContext();
        r105.getClass();
        t19.s.o(r106, R.string.larus_voiceFocus_toast_turnOn, false);
        FLogger.f375446a.e(D3(), "user hope to open, but already open.");
    }

    public final void H3(boolean r100, boolean r101, String r102) {
        com.larus.platform.service.o r103 = com.larus.platform.service.o.f365780a;
        JSONObject r104 = new JSONObject();
        h3(r104);
        if (r101 == false) goto L5;
        String r105 = "turn_on_noise_free";
    L6:
        r104.put("scene", r105);
        r104.put("success", r100 ? 1 : 0);
        RealtimeCallUtil.f379424a.getClass();
        r104.put("to_status", RealtimeCallUtil.f379455t.getDesc());
        r104.put("error_reason", r102);
        Unit r106 = Unit.INSTANCE;
        r103.reportEvent("noise_free_setting_result", r104);
        return;
    L5:
        r105 = "turn_off_noise_free";
        goto L6
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void o1(MajorState r100, int r101, MajorState r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "currentMajorState");
        Intrinsics.checkNotNullParameter(r102, "newMajorState");
        if (r103 != 14) goto L5;
        return;
    L5:
        if (r103 == 15) goto L9;
        this.f377360n = r103;
        Z3();
        c4();
        return;
    }
}
