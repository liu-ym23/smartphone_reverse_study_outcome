package com.obric.assistant.session.lifecycle;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import bga.j;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.obric.ObricRealtimeCallServiceDelegate;
import com.obric.assistant.common.utils.p;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SoundEffectHelper;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import com.obric.assistant.session.model.IDoraOperation;
import com.obric.assistant.session.model.ISessionMaintaining;
import com.obric.assistant.session.singleton.SessionMaintainer;
import com.obric.assistant.wakeup.bluetooth_headset.api.BlueAudioScoState;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes33.dex */
public final class BluetoothSoundEffectPlayer extends com.obric.assistant.session.lifecycle.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BluetoothSoundEffectPlayer f391614b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f391615c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f391616d;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f391617a = null;

        static {
            int[] r100 = new int[BlueAudioScoState.values().length];
            r100[BlueAudioScoState.CONNECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[BlueAudioScoState.DISCONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[BlueAudioScoState.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f391617a = r100;
        }
    }

    static {
        f391614b = new BluetoothSoundEffectPlayer();
        f391615c = LazyKt.lazy(new b());
    }

    @Override // bga.i
    public final void onDestroy() {
        Lazy r100 = com.obric.assistant.utils.d.f393873a;
        if (ContextCompat.checkSelfPermission(AppHost.f326268a.getApplication(), "android.permission.BLUETOOTH_CONNECT") != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        return;
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L17;
        IBluetoothHeadSetAPI r102 = tha.c.a();
        if (r102 == null) goto L13;
        r102.stop();
    L13:
        IBluetoothHeadSetAPI r103 = tha.c.a();
        if (r103 == null) goto L18;
        r103.f((UUID) f391615c.getValue());
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public BluetoothSoundEffectPlayer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.obric.assistant.session.lifecycle.c] */
    @Override // bga.i
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Build.VERSION.SDK_INT < 23) goto L19;
        IBluetoothHeadSetAPI r101 = tha.c.a();
        boolean r102 = true;
        if (r101 == null) goto L7;
        boolean r103 = r101.start(r100);
    L8:
        if (r103 == true) goto L15;
        Lazy r104 = com.obric.assistant.utils.d.f393873a;
        if (ContextCompat.checkSelfPermission(AppHost.f326268a.getApplication(), "android.permission.BLUETOOTH_CONNECT") == 0) goto L13;
        r102 = false;
    L13:
        if (r102 == true) goto L15;
        return;
    L15:
        IBluetoothHeadSetAPI r105 = tha.c.a();
        if (r105 == 0) goto L20;
        r105.o((UUID) f391615c.getValue(), new c());
        return;
    L20:
        return;
    L7:
        r103 = true;
        goto L8
    }

    public static final Object d(BluetoothSoundEffectPlayer r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof BluetoothSoundEffectPlayer$playToneInternal$1) == false) goto L7;
        BluetoothSoundEffectPlayer$playToneInternal$1 r102 = (BluetoothSoundEffectPlayer$playToneInternal$1) r101;
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
    L52:
        if (ObricRealtimeCallServiceDelegate.f379667b.a() == true) goto L57;
        FLogger r107 = FLogger.f375446a;
        Lazy<String> r108 = SessionMaintainer.f391652k;
        r107.w(SessionMaintainer.a.a(), "isMicInUse start ");
        Set<String> r109 = p.f387885a;
        AppHost.Companion r110 = AppHost.f326268a;
        boolean r111 = p.f(r110.getApplication(), p.b(r110.getApplication()));
        r107.w(SessionMaintainer.a.a(), "isMicInUse end. value is " + r111 + ' ');
        if (r111 == true) goto L59;
        if (ILoginService.f286097a.getAccountInfo().f531528a == true) goto L57;
    L59:
        return Unit.INSTANCE;
    L57:
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_WAKE_UP);
        goto L59
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
    L48:
        r102.label = 2;
        if (DelayKt.delay(100, r102) != r105) goto L52;
        return r105;
    L16:
        ResultKt.throwOnFailure(r104);
        FLogger r112 = FLogger.f375446a;
        String r113 = r100.c();
        StringBuilder r114 = new StringBuilder("Really play tone ! wakeupSource ");
        r114.append(com.obric.assistant.session.lifecycle.a.b());
        r114.append("  sessionName ");
        ISessionMaintaining r115 = j.b();
        String r116 = "";
        if (r115 == null) goto L20;
        String r117 = r115.o();
        if (r117 == null) goto L20;
    L21:
        r114.append(r117);
        r114.append(" , NOTE: if it is BREATH , will not play !");
        r112.w(r113, r114.toString());
        if (com.obric.assistant.feedback.a.a() == false) goto L30;
        String r118 = r100.c();
        StringBuilder r119 = new StringBuilder("skip main wakeup feedback: reason=child_already_played requestFrom=");
        r119.append(com.obric.assistant.session.lifecycle.a.b());
        r119.append(" sessionName=");
        ISessionMaintaining r120 = j.b();
        if (r120 == null) goto L29;
        String r121 = r120.o();
        if (r121 == null) goto L29;
        r116 = r121;
    L29:
        r119.append(r116);
        r112.i(r118, r119.toString());
        return Unit.INSTANCE;
    L30:
        boolean r122 = false;
        if (Intrinsics.areEqual(com.obric.assistant.session.lifecycle.a.b(), "WAKEUP_SOURCE_VOICE_ASSIST") == true) goto L33;
    L35:
        boolean r123 = false;
    L36:
        boolean r124 = Intrinsics.areEqual(com.obric.assistant.session.lifecycle.a.b(), "WAKEUP_SOURCE_AUTO_MIC");
        IDoraOperation r125 = bga.f.a();
        if (r125 == null) goto L40;
        r122 = r125.c();
    L40:
        if (ILoginService.f286097a.getAccountInfo().f531528a == false) goto L52;
        if (r122 == true) goto L52;
        if (r123 == true) goto L52;
        if (r124 == false) goto L45;
        SoundEffectHelper.INSTANCE.playRelease();
        goto L48
    L45:
        WakeupSoundPlayer r126 = WakeupSoundPlayer.f391618a;
        r102.label = 1;
        if (r126.b(r102) != r105) goto L48;
        return r105;
    L33:
        if (Intrinsics.areEqual(j.c(), "BREATH") == false) goto L35;
        r123 = true;
    L20:
        r117 = "";
    L7:
        r102 = new BluetoothSoundEffectPlayer$playToneInternal$1(r100, r101);
        goto L8
    }

    public final void e(boolean r100, boolean r101) {
        if (Intrinsics.areEqual(j.c(), "BREATH") == true) goto L7;
        if (r100 == false) goto L7;
        FLogger.f375446a.w(c(), "playTone! WILL NOT playing , Because the bluetooth sco will connecting ....thus waiting for sco connected ...");
        f391616d = true;
        return;
    L7:
        FLogger.f375446a.w(c(), "playTone NOW  ♫♫♫");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new BluetoothSoundEffectPlayer$playTone$1(r101, null), 3, null);
        f391616d = false;
    }
}
