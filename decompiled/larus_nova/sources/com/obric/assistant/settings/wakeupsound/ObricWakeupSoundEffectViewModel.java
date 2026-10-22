package com.obric.assistant.settings.wakeupsound;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.larus.im.FlowRuntime;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ObricWakeupSoundConfig;
import com.obric.assistant.ObricWakeupSoundOption;
import com.obric.assistant.WakeupSoundEffectSettings;
import com.obric.assistant.interaction.base.util.SoundEffectHelper;
import com.obric.assistant.t1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u000eH\u0014J\u0012\u0010\u0013\u001a\u00020\u000e2\b\b\u0001\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u000e2\b\b\u0001\u0010\u0017\u001a\u00020\u0015H\u0002J.\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0017\u001a\u00020\u00152\u0010\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0019H\u0002J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0019H\u0002J \u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0015H\u0002J\u0017\u0010%\u001a\u0004\u0018\u00010\"2\u0006\u0010$\u001a\u00020\u0015H\u0002¢\u0006\u0002\u0010&J$\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u001b2\b\b\u0001\u0010)\u001a\u00020\u00152\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\u0015H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006,"}, d2 = {"Lcom/obric/assistant/settings/wakeupsound/ObricWakeupSoundEffectViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "playingStateJob", "Lkotlinx/coroutines/Job;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/assistant/settings/wakeupsound/ObricWakeupSoundEffectUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "refresh", "", "onWakeupSoundEffectSelected", MapController.ITEM_LAYER_TAG, "Lcom/obric/assistant/settings/wakeupsound/WakeupSoundEffectItemUiModel;", "onCleared", "clearPlayingState", "value", "", "playPreviewWakeupSound", "selectedSoundId", "resolveWakeupSoundOption", "Lcom/obric/assistant/ObricWakeupSoundOption;", "options", "", "defaultSoundId", "playPreviewRawWakeupSound", "option", "playPreviewRawPoolWakeupSound", "playResolvedPreviewRaw", "rawResId", "", "optionId", "audio", "resolveWakeupRawResId", "(Ljava/lang/String;)Ljava/lang/Integer;", "buildRows", "Lcom/obric/assistant/settings/wakeupsound/WakeupSoundEffectRowUiModel;", "selectedValue", "playingValue", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricWakeupSoundEffectViewModel extends ViewModel {
    public static final a Companion = null;
    private static final long PLAYING_STATE_DURATION_MS = 1200;
    private static final String RAW_AUDIO_PREFIX = "raw:";
    private static final String TAG = "ObricWakeupSoundEffectViewModel";
    private final z0<d> _uiState;
    private Job playingStateJob;
    private final i1<d> uiState;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.settings.wakeupsound.ObricWakeupSoundEffectViewModel$onWakeupSoundEffectSelected$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.wakeupsound.ObricWakeupSoundEffectViewModel$onWakeupSoundEffectSelected$1", f = "ObricWakeupSoundEffectViewModel.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ g $item;
        int label;
        final /* synthetic */ ObricWakeupSoundEffectViewModel this$0;

        public AnonymousClass1(ObricWakeupSoundEffectViewModel r100, g r101, Continuation<? super AnonymousClass1> r102) {
            this.this$0 = r100;
            this.$item = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$item, r101);
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
        L11:
            ObricWakeupSoundEffectViewModel.access$clearPlayingState(this.this$0, this.$item.f392507a);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            this.label = 1;
            if (DelayKt.delay(1200, this) != r101) goto L11;
            return r101;
        }
    }

    static {
        Companion = new a();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Job r100 = this.playingStateJob;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        super.onCleared();
    }

    public final void refresh() {
        String r100 = this._uiState.getValue().f392504c;
        z0<d> r101 = this._uiState;
        r101.setValue(d.a(r101.getValue(), buildRows(e.a(), r100), null, 5));
    }

    public ObricWakeupSoundEffectViewModel() {
        StateFlowImpl r100 = j1.a(new d(FlowRuntime.a().getApplication().getString(R.string.obric_setting_wakeup_sound_effect), buildRows$default(this, e.a(), null, 2, null), null));
        this._uiState = r100;
        this.uiState = kotlinx.coroutines.flow.e.b(r100);
    }

    public final i1<d> getUiState() {
        return this.uiState;
    }

    private final void clearPlayingState(@WakeupSoundEffectSettings String r100) {
        if (Intrinsics.areEqual(this._uiState.getValue().f392504c, r100) == true) goto L5;
        return;
    L5:
        z0<d> r101 = this._uiState;
        r101.setValue(d.a(r101.getValue(), buildRows(e.a(), null), null, 1));
    }

    private final void playPreviewRawPoolWakeupSound(ObricWakeupSoundOption r100) {
        if (Intrinsics.areEqual(r100.getResourceSource(), "raw_builtin") == true) goto L6;
        FLogger.f375446a.w(TAG, "playPreviewRawPoolWakeupSound unsupported resourceSource=" + r100.getResourceSource() + ", id=" + r100.getId());
        SoundEffectHelper.INSTANCE.playActivate();
        return;
    L6:
        List<String> r101 = r100.getAudioPool();
        if (r101 == null) goto L17;
        List r102 = CollectionsKt.filterNotNull(r101);
        if (r102 == null) goto L17;
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L12:
        if (r104.hasNext() == false) goto L16;
        Object r105 = r104.next();
        if ((!StringsKt.isBlank((String) r105)) == false) goto L12;
        r103.add(r105);
        goto L12
    L16:
        String r106 = (String) CollectionsKt.randomOrNull(r103, Random.Default);
    L18:
        if (r106 != null) goto L21;
        FLogger.f375446a.w(TAG, "playPreviewRawPoolWakeupSound empty audioPool, id=" + r100.getId());
        SoundEffectHelper.INSTANCE.playActivate();
        return;
    L21:
        Integer r107 = resolveWakeupRawResId(r106);
        if (r107 != null) goto L25;
        FLogger.f375446a.w(TAG, "playPreviewRawPoolWakeupSound unsupported audio=" + r106 + ", id=" + r100.getId());
        SoundEffectHelper.INSTANCE.playActivate();
        return;
    L25:
        int r108 = r107.intValue();
        String r109 = r100.getId();
        if (r109 != null) goto L28;
        r109 = "";
    L28:
        playResolvedPreviewRaw(r108, r109, r106);
        return;
    L17:
        r106 = null;
        goto L18
    }

    private final void playPreviewRawWakeupSound(ObricWakeupSoundOption r100) {
        String r101 = r100.getAudio();
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        Integer r103 = resolveWakeupRawResId(r101);
        if (r103 == null) goto L13;
        int r104 = r103.intValue();
        String r105 = r100.getId();
        if (r105 == null) goto L11;
        r102 = r105;
    L11:
        playResolvedPreviewRaw(r104, r102, r101);
        return;
    L13:
        FLogger.f375446a.w(TAG, "playPreviewRawWakeupSound unsupported audio=" + r101 + ", id=" + r100.getId());
        SoundEffectHelper.INSTANCE.playActivate();
    }

    private final void playPreviewWakeupSound(@WakeupSoundEffectSettings String r100) {
        ObricWakeupSoundConfig r101 = t1.f393353a.x1();
        ObricWakeupSoundOption r102 = resolveWakeupSoundOption(r100, r101.getOptions(), r101.getDefaultSoundId());
        if (r102 != null) goto L6;
        FLogger.f375446a.w(TAG, "playPreviewWakeupSound fallback, option not found, selectedSoundId=" + r100);
        SoundEffectHelper.INSTANCE.playActivate();
        return;
    L6:
        String r103 = r102.getType();
        if (Intrinsics.areEqual(r103, TemplateNodeType.RAW) == false) goto L10;
        playPreviewRawWakeupSound(r102);
        return;
    L10:
        if (Intrinsics.areEqual(r103, "raw_pool") == false) goto L12;
        playPreviewRawPoolWakeupSound(r102);
        return;
    L12:
        FLogger.f375446a.w(TAG, "playPreviewWakeupSound fallback, unknown type=" + r102.getType() + ", id=" + r102.getId());
        SoundEffectHelper.INSTANCE.playActivate();
    }

    private final Integer resolveWakeupRawResId(String r100) {
        String r101 = StringsKt.removePrefix(r100, RAW_AUDIO_PREFIX);
        if (StringsKt.startsWith$default(r100, RAW_AUDIO_PREFIX, false, 2, null) == true) goto L6;
        r101 = null;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        int r102 = r101.hashCode();
        if (r102 == (-1621433828)) goto L47;
        if (r102 == (-612322121)) goto L43;
        switch(r102) {
            case -935579990: goto L39;
            case -935579989: goto L35;
            case -935579988: goto L31;
            case -935579987: goto L27;
            case -935579986: goto L23;
            case -935579985: goto L19;
            case -935579984: goto L15;
            default: goto L59;
        };
    L59:
        return null;
    L15:
        if (r101.equals("sound_effect_doubao_peach_07") == true) goto L51;
        return null;
    L51:
        return Integer.valueOf(R.raw.sound_effect_doubao_peach_07);
    L19:
        if (r101.equals("sound_effect_doubao_peach_06") == true) goto L52;
        return null;
    L52:
        return Integer.valueOf(R.raw.sound_effect_doubao_peach_06);
    L23:
        if (r101.equals("sound_effect_doubao_peach_05") == true) goto L53;
        return null;
    L53:
        return Integer.valueOf(R.raw.sound_effect_doubao_peach_05);
    L27:
        if (r101.equals("sound_effect_doubao_peach_04") == true) goto L54;
        return null;
    L54:
        return Integer.valueOf(R.raw.sound_effect_doubao_peach_04);
    L31:
        if (r101.equals("sound_effect_doubao_peach_03") == true) goto L55;
        return null;
    L55:
        return Integer.valueOf(R.raw.sound_effect_doubao_peach_03);
    L35:
        if (r101.equals("sound_effect_doubao_peach_02") == true) goto L56;
        return null;
    L56:
        return Integer.valueOf(R.raw.sound_effect_doubao_peach_02);
    L39:
        if (r101.equals("sound_effect_doubao_peach_01") == true) goto L57;
        return null;
    L57:
        return Integer.valueOf(R.raw.sound_effect_doubao_peach_01);
    L43:
        if (r101.equals("sound_effect_assistant_wake_up") == true) goto L58;
        return null;
    L58:
        return Integer.valueOf(R.raw.sound_effect_assistant_wake_up);
    L47:
        if (r101.equals("sound_effect_assistant_listening") == true) goto L50;
        return null;
    L50:
        return Integer.valueOf(R.raw.sound_effect_assistant_listening);
    }

    public final void onWakeupSoundEffectSelected(g r110) {
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        t1.f393353a.t1(r110.f392507a);
        playPreviewWakeupSound(r110.f392507a);
        Job r100 = this.playingStateJob;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        z0<d> r101 = this._uiState;
        d r102 = r101.getValue();
        String r103 = r110.f392507a;
        r101.setValue(d.a(r102, buildRows(r103, r103), r110.f392507a, 1));
        this.playingStateJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r110, null), 3, null);
    }

    public static final /* synthetic */ void access$clearPlayingState(ObricWakeupSoundEffectViewModel r100, String r101) {
        r100.clearPlayingState(r101);
    }

    private final List<h> buildRows(@WakeupSoundEffectSettings String r110, @WakeupSoundEffectSettings String r111) {
        Application r100 = FlowRuntime.a().getApplication();
        return CollectionsKt.listOf(new h.a[]{new h.a(new g(WakeupSoundEffectSettings.CLASSIC, r100.getString(R.string.obric_setting_wakeup_sound_effect_classic), Intrinsics.areEqual(r110, WakeupSoundEffectSettings.CLASSIC), Intrinsics.areEqual(r111, WakeupSoundEffectSettings.CLASSIC), 1)), new h.a(new g("smart", r100.getString(R.string.obric_setting_wakeup_sound_effect_dynamic), Intrinsics.areEqual(r110, "smart"), Intrinsics.areEqual(r111, "smart"), 2)), new h.a(new g(WakeupSoundEffectSettings.DOUBAO_SAME_VOICE, r100.getString(R.string.obric_setting_wakeup_sound_effect_gentle_peach), Intrinsics.areEqual(r110, WakeupSoundEffectSettings.DOUBAO_SAME_VOICE), Intrinsics.areEqual(r111, WakeupSoundEffectSettings.DOUBAO_SAME_VOICE), 3))});
    }

    private final void playResolvedPreviewRaw(int r100, String r101, String r102) {
        SoundEffectHelper r103 = SoundEffectHelper.INSTANCE;
        if (r103.playWakeupRaw(r100) == true) goto L5;
        FLogger.f375446a.w(TAG, "playResolvedPreviewRaw failed, fallback playActivate, id=" + r101 + ", audio=" + r102);
        r103.playActivate();
    L5:
        FLogger.f375446a.i(TAG, "playResolvedPreviewRaw, id=" + r101 + ", audio=" + r102 + ", rawResId=" + r100);
    }

    private final ObricWakeupSoundOption resolveWakeupSoundOption(String r100, List<ObricWakeupSoundOption> r101, String r102) {
        Object r103 = null;
        if (r101 == null) goto L5;
        List r104 = CollectionsKt.filterNotNull(r101);
    L6:
        if (r104 != null) goto L9;
        r104 = CollectionsKt.emptyList();
    L9:
        if (r104.isEmpty() == false) goto L11;
        return null;
    L11:
        List r105 = r104;
        Iterator r106 = r105.iterator();
    L13:
        if (r106.hasNext() == false) goto L17;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((ObricWakeupSoundOption) r107).getId(), r100) == false) goto L13;
    L18:
        ObricWakeupSoundOption r108 = (ObricWakeupSoundOption) r107;
        if (r108 != null) goto L34;
        Iterator r109 = r105.iterator();
    L22:
        if (r109.hasNext() == false) goto L27;
        Object r110 = r109.next();
        if (Intrinsics.areEqual(((ObricWakeupSoundOption) r110).getId(), r102) == false) goto L22;
        r103 = r110;
    L27:
        return (ObricWakeupSoundOption) r103;
    L34:
        return r108;
    L17:
        r107 = null;
        goto L18
    L5:
        r104 = null;
        goto L6
    }

    public static /* synthetic */ List buildRows$default(ObricWakeupSoundEffectViewModel r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.buildRows(r101, r102);
    }
}
