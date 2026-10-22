package com.obric.assistant.interaction.impl;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.IObricTtsService;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.keyguard.BiometricState;
import com.obric.assistant.interaction.api.keyguard.IKeyguardBiometricSetting;
import com.obric.assistant.interaction.api.keyguard.RequestSource;
import com.obric.assistant.spi.keyguard.IKeyguardService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import v19.q5;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J:\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\nH\u0002J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\nH\u0003J&\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00120(H\u0002J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\nH\u0002J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\nH\u0002J\b\u0010+\u001a\u00020\u0012H\u0016J\n\u0010,\u001a\u0004\u0018\u00010&H\u0016J\n\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\nH\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n00H\u0016J\b\u00101\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u00063"}, d2 = {"Lcom/obric/assistant/interaction/impl/ObricKeyguardServiceImpl;", "Lcom/obric/assistant/spi/keyguard/IKeyguardService;", "<init>", "()V", "workScope", "Lkotlinx/coroutines/CoroutineScope;", "playUnlockTtsJob", "Lkotlinx/coroutines/Job;", "isDismissingKeyguard", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "keyguardManager", "Landroid/app/KeyguardManager;", "getKeyguardManager", "()Landroid/app/KeyguardManager;", "keyguardManager$delegate", "Lkotlin/Lazy;", "registerDismissKeyguardChangedListener", "", "listener", "Lcom/obric/assistant/spi/keyguard/IDismissKeyguardStatusListener;", "unregisterDismissKeyguardChangedListener", "requestDismissKeyguard", "callback", "Lcom/obric/assistant/spi/keyguard/DismissKeyguardCallback;", "fastFailWhenAppBackground", "playTts", "allowBiometricUnlock", "autoPopupWindow", "reportParams", "Landroid/os/Bundle;", "reportAuthResultIfNeeded", "isSuccess", "dismissWithTopActivity", "completeTopActivityDismiss", "terminalGate", "Lcom/obric/assistant/interaction/impl/KeyguardDismissTerminalGate;", "source", "", "onFirstTerminal", "Lkotlin/Function0;", "setKeyGuardBiometricUnlock", "dismissWithHelperActivity", "cancelDismissKeyguard", "getHelperActivityName", "getHelperActivityComponentName", "Landroid/content/ComponentName;", "isKeyguardLocked", "Lkotlinx/coroutines/flow/StateFlow;", "isRequestingDismissKeyguard", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricKeyguardServiceImpl implements IKeyguardService {
    public static final Companion Companion = null;
    public static final String TAG = "DismissKeyguardHelper";
    private static CopyOnWriteArrayList<oga.a> dismissKeyguardCallbacks;
    private static final CopyOnWriteArrayList<oga.b> dismissKeyguardStatusChangedCallbacks = null;
    private static WeakReference<Activity> lockedHelperActivity;
    private static boolean shouldAutoPopupWindow;
    private final z0<Boolean> isDismissingKeyguard;
    private final Lazy keyguardManager$delegate;
    private volatile Job playUnlockTtsJob;
    private final CoroutineScope workScope;

    /* JADX INFO: loaded from: classes4.dex */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0013J\u0015\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0015J\r\u0010\u0016\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0017J\r\u0010\u0018\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0019J\r\u0010\u001a\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u001bJ\r\u0010\u001c\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u001dJ\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/assistant/interaction/impl/ObricKeyguardServiceImpl$Companion;", "", "<init>", "()V", "TAG", "", "dismissKeyguardCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/assistant/spi/keyguard/DismissKeyguardCallback;", "lockedHelperActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "dismissKeyguardStatusChangedCallbacks", "Lcom/obric/assistant/spi/keyguard/IDismissKeyguardStatusListener;", "shouldAutoPopupWindow", "", "onLockedHelperActivityCreated", "", "activity", "onLockedHelperActivityCreated$impl_mainlandRelease", "onLockedHelperActivityDestroyed", "onLockedHelperActivityDestroyed$impl_mainlandRelease", "onKeyguardDismissSucceeded", "onKeyguardDismissSucceeded$impl_mainlandRelease", "onKeyguardDismissError", "onKeyguardDismissError$impl_mainlandRelease", "onRequestDismissKeyguard", "onRequestDismissKeyguard$impl_mainlandRelease", "onKeyguardDismissCancelled", "onKeyguardDismissCancelled$impl_mainlandRelease", "clearCallbacks", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final List<oga.a> clearCallbacks() {
            List<oga.a> r100 = CollectionsKt.toList(ObricKeyguardServiceImpl.access$getDismissKeyguardCallbacks$cp());
            ObricKeyguardServiceImpl.access$getDismissKeyguardCallbacks$cp().clear();
            return r100;
        }

        public final void onKeyguardDismissCancelled$impl_mainlandRelease() {
            Iterator<T> r100 = clearCallbacks().iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((oga.a) r100.next()).onDismissFailed();
            goto L4
        L6:
            Iterator r101 = ObricKeyguardServiceImpl.access$getDismissKeyguardStatusChangedCallbacks$cp().iterator();
        L8:
            if (r101.hasNext() == false) goto L10;
            ((oga.b) r101.next()).onDismissFailed(ObricKeyguardServiceImpl.access$getShouldAutoPopupWindow$cp());
            goto L8
        }

        public final void onKeyguardDismissError$impl_mainlandRelease() {
            Iterator<T> r100 = clearCallbacks().iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((oga.a) r100.next()).onDismissFailed();
            goto L4
        L6:
            Iterator r101 = ObricKeyguardServiceImpl.access$getDismissKeyguardStatusChangedCallbacks$cp().iterator();
        L8:
            if (r101.hasNext() == false) goto L10;
            ((oga.b) r101.next()).onDismissFailed(ObricKeyguardServiceImpl.access$getShouldAutoPopupWindow$cp());
            goto L8
        }

        public final void onKeyguardDismissSucceeded$impl_mainlandRelease() {
            Iterator<T> r100 = clearCallbacks().iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((oga.a) r100.next()).onDismissSucceeded();
            goto L4
        L6:
            Iterator r101 = ObricKeyguardServiceImpl.access$getDismissKeyguardStatusChangedCallbacks$cp().iterator();
        L8:
            if (r101.hasNext() == false) goto L10;
            ((oga.b) r101.next()).onDismissSucceeded(ObricKeyguardServiceImpl.access$getShouldAutoPopupWindow$cp());
            goto L8
        }

        public final void onRequestDismissKeyguard$impl_mainlandRelease() {
            Iterator r100 = ObricKeyguardServiceImpl.access$getDismissKeyguardStatusChangedCallbacks$cp().iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((oga.b) r100.next()).onRequestDismissKeyguard();
            goto L4
        }

        public final void onLockedHelperActivityCreated$impl_mainlandRelease(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            ObricKeyguardServiceImpl.access$setLockedHelperActivity$cp(new WeakReference(r100));
        }

        public final void onLockedHelperActivityDestroyed$impl_mainlandRelease(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            ObricKeyguardServiceImpl.access$setLockedHelperActivity$cp(null);
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.ObricKeyguardServiceImpl$requestDismissKeyguard$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.ObricKeyguardServiceImpl$requestDismissKeyguard$1", f = "ObricKeyguardServiceImpl.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(r101);
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
            FLogger.f375446a.e(ObricKeyguardServiceImpl.TAG, "play unlock tts after delay");
            IObricTtsService r103 = (IObricTtsService) ServiceManager.get().getService(IObricTtsService.class);
            if (r103 == null) goto L15;
            r103.f("requestDismissKeyguard", AppHost.f326268a.getApplication().getString(R.string.obric_unlock_to_continue));
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            FLogger.f375446a.e(ObricKeyguardServiceImpl.TAG, "play unlock tts before delay");
            this.label = 1;
            if (DelayKt.delay(2500, this) != r101) goto L11;
            return r101;
        }
    }

    public static /* synthetic */ Unit a(ObricKeyguardServiceImpl r100, Throwable r101) {
        return requestDismissKeyguard$lambda$2$lambda$1(r100, r101);
    }

    public static /* synthetic */ KeyguardManager b() {
        return keyguardManager_delegate$lambda$0();
    }

    public static /* synthetic */ Unit c() {
        return dismissWithTopActivity$lambda$5$lambda$4();
    }

    static {
        Companion = new Companion(null);
        dismissKeyguardCallbacks = new CopyOnWriteArrayList();
        dismissKeyguardStatusChangedCallbacks = new CopyOnWriteArrayList();
    }

    private static final Unit dismissWithTopActivity$lambda$5$lambda$4() {
        Companion.onKeyguardDismissSucceeded$impl_mainlandRelease();
        return Unit.INSTANCE;
    }

    private final KeyguardManager getKeyguardManager() {
        return (KeyguardManager) this.keyguardManager$delegate.getValue();
    }

    private static final KeyguardManager keyguardManager_delegate$lambda$0() {
        Object r100 = AppHost.f326268a.getApplication().getSystemService("keyguard");
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.KeyguardManager");
        return (KeyguardManager) r100;
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public void cancelDismissKeyguard() {
        FLogger.f375446a.e(TAG, "cancelDismissKeyguard");
        this.isDismissingKeyguard.setValue(Boolean.FALSE);
        Companion.onKeyguardDismissCancelled$impl_mainlandRelease();
        WeakReference<Activity> r100 = lockedHelperActivity;
        if (r100 == null) goto L10;
        Activity r101 = r100.get();
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.isDestroyed() == true) goto L12;
        r101.finishAndRemoveTask();
        return;
    L12:
        return;
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public ComponentName getHelperActivityComponentName() {
        if (ObricFeatureServiceDelegate.f387839b.c() == true) goto L7;
        return null;
    L7:
        return new ComponentName(AppHost.f326268a.getApplication(), LockedHelperActivity.class);
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public boolean isRequestingDismissKeyguard() {
        WeakReference<Activity> r100 = lockedHelperActivity;
        if (r100 == null) goto L10;
        Activity r101 = r100.get();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.isDestroyed() == true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public ObricKeyguardServiceImpl() {
        this.workScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.isDismissingKeyguard = j1.a(Boolean.FALSE);
        this.keyguardManager$delegate = LazyKt.lazy(new t());
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public String getHelperActivityName() {
        ComponentName r100 = getHelperActivityComponentName();
        if (r100 == null) goto L8;
        String r101 = r100.getClassName();
        if (r101 != null) goto L7;
        return null;
    L7:
        return StringsKt.substringAfterLast$default(r101, '.', null, 2, null);
    L8:
        return null;
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public boolean isKeyguardLocked() {
        return IKeyguardStateKt.getKeyguardState().isKeyguardLocked();
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getDismissKeyguardCallbacks$cp() {
        return dismissKeyguardCallbacks;
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getDismissKeyguardStatusChangedCallbacks$cp() {
        return dismissKeyguardStatusChangedCallbacks;
    }

    public static final /* synthetic */ boolean access$getShouldAutoPopupWindow$cp() {
        return shouldAutoPopupWindow;
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public i1<Boolean> isDismissingKeyguard() {
        return this.isDismissingKeyguard;
    }

    public static final /* synthetic */ KeyguardManager access$getKeyguardManager(ObricKeyguardServiceImpl r100) {
        return r100.getKeyguardManager();
    }

    public static final /* synthetic */ Job access$getPlayUnlockTtsJob$p(ObricKeyguardServiceImpl r100) {
        return r100.playUnlockTtsJob;
    }

    public static final /* synthetic */ z0 access$isDismissingKeyguard$p(ObricKeyguardServiceImpl r100) {
        return r100.isDismissingKeyguard;
    }

    public static final /* synthetic */ void access$setLockedHelperActivity$cp(WeakReference r100) {
        lockedHelperActivity = r100;
    }

    private final void dismissWithHelperActivity(boolean r100) {
        FLogger.f375446a.i(TAG, "dismiss with helper activity");
        setKeyGuardBiometricUnlock(r100);
        AppHost.Companion r101 = AppHost.f326268a;
        Application r102 = r101.getApplication();
        Intent r103 = new Intent(r101.getApplication(), LockedHelperActivity.class);
        r103.addFlags(402653184);
        r103.putExtra("obric_allow_show_when_locked", true);
        r102.startActivity(r103);
        Iterator r104 = ((ArrayList) v19.a.f552443a).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((q5) r104.next()).gotoToSystemPage();
        goto L4
    }

    private final void dismissWithTopActivity(boolean r110) {
        FLogger r100 = FLogger.f375446a;
        r100.i(TAG, "device is unlocked, dismiss with top activity quietly");
        KeyguardDismissTerminalGate r101 = new KeyguardDismissTerminalGate();
        ObricKeyguardServiceImpl$dismissWithTopActivity$dismissCallback$1 r102 = new ObricKeyguardServiceImpl$dismissWithTopActivity$dismissCallback$1(this, r101);
        Activity r103 = AppHost.f326268a.a().getCurrentActivity();
        if (r103 == null) goto L8;
        setKeyGuardBiometricUnlock(r110);
        if (getKeyguardManager().isKeyguardLocked() == true) goto L7;
        completeTopActivityDismiss(r101, "pre_request_unlocked", new s());
        return;
    L7:
        getKeyguardManager().requestDismissKeyguard(r103, r102);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ObricKeyguardServiceImpl$dismissWithTopActivity$1$2(this, r101, null), 3, null);
        return;
    L8:
        r100.e(TAG, "current activity is null!");
    }

    private final void setKeyGuardBiometricUnlock(boolean r100) {
        IKeyguardBiometricSetting r101 = (IKeyguardBiometricSetting) ServiceManager.get().getService(IKeyguardBiometricSetting.class);
        if (r101 == null) goto L10;
        RequestSource r102 = RequestSource.DISMISS_KEYGUARD;
        if (r100 == false) goto L7;
        BiometricState r103 = BiometricState.DEFAULT;
    L8:
        r101.requestBiometricState(r102, r103);
        return;
    L7:
        r103 = BiometricState.DISABLED;
        goto L8
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public void registerDismissKeyguardChangedListener(oga.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<oga.b> r101 = dismissKeyguardStatusChangedCallbacks;
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);
        return;
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public void unregisterDismissKeyguardChangedListener(oga.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<oga.b> r101 = dismissKeyguardStatusChangedCallbacks;
        if (r101.contains(r100) == false) goto L6;
        r101.remove(r100);
        return;
    }

    private final void reportAuthResultIfNeeded(Bundle r100, boolean r101) {
        if (IKeyguardStateKt.getKeyguardState().isDeviceSecure() == true) goto L6;
        FLogger.f375446a.i(TAG, "skip reportAuthResult because device is not secure");
        return;
    L6:
        com.obric.assistant.reporter.c.a(r100, r101);
    }

    private static final Unit requestDismissKeyguard$lambda$2$lambda$1(ObricKeyguardServiceImpl r100, Throwable r101) {
        r100.playUnlockTtsJob = null;
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$reportAuthResultIfNeeded(ObricKeyguardServiceImpl r100, Bundle r101, boolean r102) {
        r100.reportAuthResultIfNeeded(r101, r102);
    }

    private final void completeTopActivityDismiss(KeyguardDismissTerminalGate r100, String r101, Function0<Unit> r102) {
        if (r100.tryComplete() == true) goto L6;
        FLogger.f375446a.i(TAG, "ignore duplicated top activity dismiss result, source = " + r101);
        return;
    L6:
        FLogger.f375446a.i(TAG, "complete top activity dismiss, source = " + r101);
        r102.invoke();
    }

    public static final /* synthetic */ void access$completeTopActivityDismiss(ObricKeyguardServiceImpl r100, KeyguardDismissTerminalGate r101, String r102, Function0 r103) {
        r100.completeTopActivityDismiss(r101, r102, r103);
    }

    @Override // com.obric.assistant.spi.keyguard.IKeyguardService
    public void requestDismissKeyguard(final oga.a r110, boolean r111, boolean r112, boolean r113, boolean r114, final Bundle r210) {
        Intrinsics.checkNotNullParameter(r110, "callback");
        if (Build.VERSION.SDK_INT >= 26) goto L6;
        FLogger.f375446a.e(TAG, "requestDismissKeyguard not support");
        r110.onDismissSucceeded();
        return;
    L6:
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("requestDismissKeyguard fastFail = ");
        r101.append(r111);
        r101.append(", allowBiometricUnlock = ");
        r101.append(r113);
        r101.append(", reportParams = ");
        r101.append(com.obric.assistant.common.utils.e.b(r210));
        r101.append(", isAppBackground = ");
        AppHost.Companion r102 = AppHost.f326268a;
        r101.append(r102.a().isAppBackground());
        r101.append(", callback = ");
        r101.append(r110);
        r101.append(", dismissKeyguardCallback = ");
        r101.append(dismissKeyguardCallbacks);
        r100.e(TAG, r101.toString());
        if (getKeyguardManager().isKeyguardLocked() == true) goto L10;
        r110.onDismissSucceeded();
        return;
    L10:
        if (r111 == true) goto L12;
    L15:
        this.isDismissingKeyguard.setValue(Boolean.TRUE);
        shouldAutoPopupWindow = r114;
        Job r103 = this.playUnlockTtsJob;
        boolean r104 = true;
        if (r103 == null) goto L18;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L18:
        this.playUnlockTtsJob = null;
        if (r112 == true) goto L21;
    L23:
        WeakReference<Activity> r105 = lockedHelperActivity;
        if (r105 == null) goto L30;
        Activity r106 = r105.get();
        if (r106 == null) goto L30;
        if (r106.isDestroyed() == true) goto L30;
        r106.finishAndRemoveTask();
    L30:
        dismissKeyguardCallbacks.add(new AnonymousClass4(this, r210, r110));
        if (r102.a().isAppBackground() == true) goto L42;
        IAssistantChatWindow r107 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r107 != null) goto L35;
    L37:
        r104 = false;
    L38:
        if (r104 == false) goto L42;
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == true) goto L42;
        dismissWithTopActivity(r113);
        return;
    L35:
        if (r107.isShowing() == true) goto L37;
    L42:
        dismissWithHelperActivity(r113);
        return;
    L21:
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L23;
        Job r108 = BuildersKt.launch$default(this.workScope, null, null, new AnonymousClass1(null), 3, null);
        r108.invokeOnCompletion(new u(this));
        this.playUnlockTtsJob = r108;
        goto L23
    L12:
        if (r102.a().isAppBackground() == false) goto L15;
        r100.e(TAG, "fast failed!");
        r110.onDismissFailed();
    }
}
