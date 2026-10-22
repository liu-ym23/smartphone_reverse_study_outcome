package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.audio.voiceinput.AudioPluginFeature;
import com.ss.android.lark.audio.voiceinput.CancelAsrTimeoutState;
import com.ss.android.lark.audio.voiceinput.VoiceInputConstants;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000fJ\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0013J\"\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00170!J\u0006\u0010\"\u001a\u00020\u0006J\u000e\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u000fJ\"\u0010%\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00170!J\u0006\u0010&\u001a\u00020\u000fJ\u0014\u0010'\u001a\u00020\u00172\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170)J\b\u0010*\u001a\u00020\u0017H\u0014J\u0014\u0010+\u001a\u00020\u00172\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170)J\u0016\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u000fJ\u0006\u00101\u001a\u00020\u0017J\u0006\u00102\u001a\u00020\u0017J\u0006\u00103\u001a\u00020\u0017J\u0006\u00104\u001a\u00020\u000fJ1\u00105\u001a\u00020\u0017\"\u0004\b\u0000\u001062\f\u00107\u001a\b\u0012\u0004\u0012\u0002H60\b2\u0006\u00108\u001a\u0002H62\u0006\u00109\u001a\u00020:H\u0002¢\u0006\u0002\u0010;R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "mEnabledFeatures", "", "Lcom/ss/android/lark/audio/voiceinput/AudioPluginFeature;", "_currentFeature", "Landroidx/lifecycle/MutableLiveData;", "lastFeature", "getLastFeature", "()Lcom/ss/android/lark/audio/voiceinput/AudioPluginFeature;", "setLastFeature", "(Lcom/ss/android/lark/audio/voiceinput/AudioPluginFeature;)V", "_isAudioPluginSelected", "", "asrTimeOutChecker", "Lkotlinx/coroutines/Job;", "asrSessionState", "", "waitForLastAsrRequest", "Lkotlinx/coroutines/channels/Channel;", "initFeatures", "", "enableRecord", "enableRecognize", "enableWithText", "updateCurrentFeature", "featIndex", "addCurrentFeatureObserver", "owner", "Landroidx/lifecycle/LifecycleOwner;", "callback", "Lkotlin/Function1;", "getCurrentFeature", "onAudioPluginSelectChange", "isSelect", "addAudioPluginSelectChangeObserver", "isAudioPluginSelected", "delayTriggerAsrTimeOut", "onAsrTimeOut", "Lkotlin/Function0;", "onCleared", "whenOnRecordTimeTooShort", "action", "cancelAsrTimeOut", "cancelAsrTimeoutState", "Lcom/ss/android/lark/audio/voiceinput/CancelAsrTimeoutState;", "hasAsrText", "onAsrLastRequest", "onAudioRecordStart", "triggerAsrSessionEnd", "isAsrSessionRunning", "updateMutableLiveData", ExifInterface.GPS_DIRECTION_TRUE, "data", "value", "dataName", "", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;Ljava/lang/String;)V", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioViewModel extends ViewModel {
    public static final int ASR_SESSION_END = 1003;
    public static final int ASR_SESSION_IDLE = 1000;
    public static final int ASR_SESSION_RECORDING = 1001;
    public static final int ASR_SESSION_WAIT_RECOGNIZING = 1002;
    public static final a Companion = null;
    private static final String TAG = "AudioViewModel";
    private final MutableLiveData<AudioPluginFeature> _currentFeature;
    private final MutableLiveData<Boolean> _isAudioPluginSelected;
    private int asrSessionState;
    private Job asrTimeOutChecker;
    private AudioPluginFeature lastFeature;
    private final List<AudioPluginFeature> mEnabledFeatures;
    private Channel<Boolean> waitForLastAsrRequest;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<Boolean, Unit> f429922a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super Boolean, Unit> r100) {
            this.f429922a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            Function1<Boolean, Unit> r102 = this.f429922a;
            Intrinsics.checkNotNull(r101);
            r102.invoke(r101);
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<AudioPluginFeature, Unit> f429923a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super AudioPluginFeature, Unit> r100) {
            this.f429923a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            AudioPluginFeature r101 = (AudioPluginFeature) r100;
            Function1<AudioPluginFeature, Unit> r102 = this.f429923a;
            Intrinsics.checkNotNull(r101);
            r102.invoke(r101);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel$delayTriggerAsrTimeOut$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel$delayTriggerAsrTimeOut$1", f = "AudioViewModel.kt", i = {}, l = {119, 120}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onAsrTimeOut;
        int label;
        final /* synthetic */ AudioViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel$delayTriggerAsrTimeOut$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel$delayTriggerAsrTimeOut$1$1", f = "AudioViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C51081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function0<Unit> $onAsrTimeOut;
            int label;
            final /* synthetic */ AudioViewModel this$0;

            public C51081(AudioViewModel r100, Function0<Unit> r101, Continuation<? super C51081> r102) {
                this.this$0 = r100;
                this.$onAsrTimeOut = r101;
                super(2, r102);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new C51081(this.this$0, this.$onAsrTimeOut, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((C51081) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L11;
                ResultKt.throwOnFailure(r100);
                if (this.this$0.isAsrSessionRunning() == false) goto L7;
                this.$onAsrTimeOut.invoke();
            L9:
                return Unit.INSTANCE;
            L7:
                Log.i(AudioViewModel.TAG, "delayTriggerAsrTimeOut cancel show toast by session end. " + AudioViewModel.access$getAsrSessionState$p(this.this$0));
                goto L9
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(AudioViewModel r100, Function0<Unit> r101, Continuation<? super AnonymousClass1> r102) {
            this.this$0 = r100;
            this.$onAsrTimeOut = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$onAsrTimeOut, r101);
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
            if (r102 == 0) goto L12;
            if (r102 == 1) goto L10;
            if (r102 != 2) goto L9;
            ResultKt.throwOnFailure(r100);     // Catch: Exception -> L19
        L22:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r100);     // Catch: Exception -> L19
        L16:
            MainCoroutineDispatcher r103 = Dispatchers.getMain().getImmediate();     // Catch: Exception -> L19
            C51081 r104 = new C51081(this.this$0, this.$onAsrTimeOut, null);     // Catch: Exception -> L19
            this.label = 2;     // Catch: Exception -> L19
            if (BuildersKt.withContext(r103, r104, this) != r101) goto L22;
            return r101;
        L12:
            ResultKt.throwOnFailure(r100);
            long r105 = ((Number) VoiceInputConstants.f409174a.getValue()).longValue();     // Catch: Exception -> L19
            this.label = 1;     // Catch: Exception -> L19
            if (DelayKt.delay(r105, this) != r101) goto L16;
            return r101;
        L19:
            e = move-exception;
            Log.i(AudioViewModel.TAG, "delayTriggerAsrTimeOut / Exception" + e);
            goto L22
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel$whenOnRecordTimeTooShort$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel$whenOnRecordTimeTooShort$1", f = "AudioViewModel.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
    public static final class C119031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $action;
        int label;
        final /* synthetic */ AudioViewModel this$0;

        public C119031(AudioViewModel r100, Function0<Unit> r101, Continuation<? super C119031> r102) {
            this.this$0 = r100;
            this.$action = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C119031(this.this$0, this.$action, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C119031) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
            Object r103 = ((kotlinx.coroutines.channels.g) r100).f504697a;
        L11:
            kotlinx.coroutines.channels.g.c r104 = kotlinx.coroutines.channels.g.f504696b;
            if ((!(r103 instanceof kotlinx.coroutines.channels.g.c)) == false) goto L19;
            Boolean r105 = (Boolean) kotlinx.coroutines.channels.g.b(r103);
            if (r105 == null) goto L19;
            Function0<Unit> r106 = this.$action;
            if (r105.booleanValue() == true) goto L19;
            r106.invoke();
        L19:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            Channel r107 = AudioViewModel.access$getWaitForLastAsrRequest$p(this.this$0);
            this.label = 1;
            r103 = r107.mo10963receiveCatchingJP2dKIU(this);
            if (r103 != r101) goto L11;
            return r101;
        }
    }

    static {
        Companion = new a();
    }

    public final AudioPluginFeature getCurrentFeature() {
        AudioPluginFeature r100 = this._currentFeature.getValue();
        if (r100 != null) goto L6;
        Log.w(TAG, "getCurrentFeature / _currentFeature.value is null");
        return (AudioPluginFeature) ListProtector.get(this.mEnabledFeatures, 0);
    L6:
        return r100;
    }

    public final boolean isAsrSessionRunning() {
        int r100 = this.asrSessionState;
        boolean r101 = true;
        if (r100 == 1000) goto L5;
        boolean r102 = true;
    L7:
        if (r100 != 1003) goto L11;
        r101 = false;
    L11:
        return r102 & r101;
    L5:
        r102 = false;
        goto L7
    }

    public final boolean isAudioPluginSelected() {
        return Intrinsics.areEqual(this._isAudioPluginSelected.getValue(), Boolean.TRUE);
    }

    public final void onAsrLastRequest() {
        this.asrSessionState = 1002;
    }

    public final void onAudioRecordStart() {
        this.asrSessionState = 1001;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        cancelAsrTimeOut(CancelAsrTimeoutState.CancelByCleared, false);
    }

    public final void triggerAsrSessionEnd() {
        this.asrSessionState = 1003;
    }

    public AudioViewModel() {
        this.mEnabledFeatures = new ArrayList();
        this._currentFeature = new MutableLiveData();
        this._isAudioPluginSelected = new MutableLiveData();
        this.asrSessionState = 1000;
        this.waitForLastAsrRequest = ChannelKt.Channel$default(0, null, null, 7, null);
    }

    public final AudioPluginFeature getLastFeature() {
        return this.lastFeature;
    }

    public static final /* synthetic */ int access$getAsrSessionState$p(AudioViewModel r100) {
        return r100.asrSessionState;
    }

    public static final /* synthetic */ Channel access$getWaitForLastAsrRequest$p(AudioViewModel r100) {
        return r100.waitForLastAsrRequest;
    }

    public final void delayTriggerAsrTimeOut(Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "onAsrTimeOut");
        Job r100 = this.asrTimeOutChecker;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.asrTimeOutChecker = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, r110, null), 2, null);
    }

    public final void onAudioPluginSelectChange(boolean r100) {
        updateMutableLiveData(this._isAudioPluginSelected, Boolean.valueOf(r100), "isAudioPluginSelected");
    }

    public final void setLastFeature(AudioPluginFeature r100) {
        this.lastFeature = r100;
    }

    public final void updateCurrentFeature(int r100) {
        if (r100 >= 0) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
        Log.e(TAG, "setFeature / featIndex out of range");
        AudioPluginFeature r102 = (AudioPluginFeature) ListProtector.get(this.mEnabledFeatures, 0);
    L11:
        this.lastFeature = this._currentFeature.getValue();
        updateMutableLiveData(this._currentFeature, r102, "currentFeature");
        return;
    L10:
        r102 = (AudioPluginFeature) ListProtector.get(this.mEnabledFeatures, r100);
        goto L11
    L5:
        if (r100 >= this.mEnabledFeatures.size()) goto L7;
        r101 = true;
        goto L8
    }

    public final void whenOnRecordTimeTooShort(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (this._currentFeature.getValue() != AudioPluginFeature.RECOGNIZE) goto L5;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C119031(this, r100, null), 3, null);
        return;
    L5:
        r100.invoke();
    }

    public final void addAudioPluginSelectChangeObserver(LifecycleOwner r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this._isAudioPluginSelected.observe(r100, new b(r101));
    }

    public final void addCurrentFeatureObserver(LifecycleOwner r100, Function1<? super AudioPluginFeature, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this._currentFeature.observe(r100, new c(r101));
    }

    public final void cancelAsrTimeOut(CancelAsrTimeoutState r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "cancelAsrTimeoutState");
        Job r101 = this.asrTimeOutChecker;
        if (r101 == null) goto L7;
        Log.i(TAG, "cancelAsrTimeOut by " + r100.info());
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
        if (KeyboardVoiceFGUtils.h() == true) goto L7;
        String r102 = fwa.a.f479017a;
        fwa.a.a(false, r100.info());
    L7:
        this.asrTimeOutChecker = null;
        this.asrSessionState = 1003;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L10
        Result.m9449constructorimpl(BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AudioViewModel$cancelAsrTimeOut$2$1(this, r110, null), 3, null));     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    private final <T> void updateMutableLiveData(MutableLiveData<T> r100, T r101, String r102) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L7;
        Log.i(TAG, "updateMutableLiveData / Data: " + r102 + ", origin value: " + r100.getValue() + ", new value: " + r101);
        if (Intrinsics.areEqual(r100.getValue(), r101) == true) goto L9;
        r100.setValue(r101);
        return;
    L9:
        return;
    L7:
        Log.w(TAG, "updateMutableLiveData / Not in main looper, data: " + r102 + ", origin value: " + r100.getValue() + ", new value: " + r101);
        r100.postValue(r101);
    }

    public final void initFeatures(boolean r100, boolean r101, boolean r102) {
        if (r102 == false) goto L4;
        this.mEnabledFeatures.add(AudioPluginFeature.WITH_TEXT);
    L4:
        if (r100 == false) goto L6;
        this.mEnabledFeatures.add(AudioPluginFeature.RECORD);
    L6:
        if (r101 == false) goto L9;
        this.mEnabledFeatures.add(AudioPluginFeature.RECOGNIZE);
    L9:
        if (this.mEnabledFeatures.size() != 0) goto L11;
        Log.e(TAG, "initFeatures / No feature enabled");
        this.mEnabledFeatures.add(AudioPluginFeature.RECORD);
    L11:
        AudioPluginFeature.a r103 = AudioPluginFeature.Companion;
        int r104 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.f430003a;
        int r105 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.e();
        r103.getClass();
        AudioPluginFeature r106 = AudioPluginFeature.WITH_TEXT;
        if (r105 == r106.getIndex()) goto L21;
        r106 = AudioPluginFeature.RECORD;
        if (r105 == r106.getIndex()) goto L21;
        AudioPluginFeature r107 = AudioPluginFeature.RECOGNIZE;
        if (r105 != r107.getIndex()) goto L21;
        r106 = r107;
    L21:
        if (this.mEnabledFeatures.contains(r106) == true) goto L23;
        updateCurrentFeature(0);
        return;
    L23:
        updateMutableLiveData(this._currentFeature, r106, "currentFeature");
    }

    public static /* synthetic */ void initFeatures$default(AudioViewModel r100, boolean r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = true;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = true;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = true;
    L11:
        r100.initFeatures(r101, r102, r103);
    }
}
