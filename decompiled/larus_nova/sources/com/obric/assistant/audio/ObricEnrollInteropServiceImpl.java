package com.obric.assistant.audio;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.device.obricDeviceManagerDelegate;
import com.obric.assistant.guide.IObricUserGuide;
import com.obric.assistant.permission.IObricPermissionService;
import com.obric.assistant.settings.experience.ObricUserExperiencePlanManager;
import com.obric.assistant.spi.account.IObricAccountSPIService;
import com.obric.assistant.spi.audio.IObricEnrollInteropService;
import com.obric.assistant.spi.dora.IDoraWakeupService;
import com.obric.assistant.t1;
import com.obric.assistant.voice.IObricVoiceService;
import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import com.obric.audio.enroll.VoiceEnrollServiceDelegate;
import com.obric.sva.sdk.base.Constant;
import com.obric.sva.sdk.controller.Global;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J \u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\t2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u001f\u001a\u00020\tH\u0016J\u000e\u0010 \u001a\u00020\tH\u0096@¢\u0006\u0002\u0010!J\u0018\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u000eH\u0002J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u000eH\u0002J\u0018\u0010%\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\u0018\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\tH\u0016J\b\u0010/\u001a\u00020\u000eH\u0016J\b\u00100\u001a\u00020\u000eH\u0016J\b\u00101\u001a\u00020\u000eH\u0016J\b\u00102\u001a\u00020\tH\u0016J\u0010\u00103\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u00104\u001a\u00020\u0007H\u0016J\f\u00105\u001a\u00020\u0007*\u000206H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/obric/assistant/audio/ObricEnrollInteropServiceImpl;", "Lcom/obric/assistant/spi/audio/IObricEnrollInteropService;", "<init>", "()V", "ipcScope", "Lkotlinx/coroutines/CoroutineScope;", "setAssistantEnrollingStatus", "", "enrolling", "", "trackEnrollData", com.heytap.mcssdk.constant.b.f276361k, "", "data", "", "setVoiceWakeupEnabled", "enabled", "setContinueSpeakNoiseReductionEnabled", "resetLockedUseAuthenticationTypeWhenVoicePrintDeleted", "uid", "isVoiceWakeupEnabled", "migrateLegacyPhoneWakeupSettingsToPersonalUid", "isBreathWakeupEnabled", "setBreathWakeupEnabled", "applyBreathWakeupEnabled", "isLockedScreenUseEnabled", "saveVoicePrintAuthenticationTypeForLockedUseSettings", "isSetDefaultSettingItems", "currentSettingItems", "", "setHelpImproveVoiceWakeupEnabled", "isHelpImproveVoiceWakeupEnabled", "refreshHelpImproveVoiceWakeupEnabled", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "migrateLegacyVoiceWakeupSwitch", "personalUid", "migrateLegacyBreathWakeupSwitch", "storeHelpImproveVoiceWakeupEnabled", "syncHelpImproveVoiceWakeupEnabled", "getHelpImproveVoiceWakeupKeva", "Lcom/bytedance/keva/Keva;", "requestEnrollGuideRecordPermission", "activity", "Landroidx/fragment/app/FragmentActivity;", "callback", "Lcom/obric/assistant/spi/audio/IObricEnrollInteropService$EnrollPermissionCallback;", "useSystemDrawableForEnrollGuide", "getDeviceUuid", "buildDoraEngineVersionJson", "buildObricContPvadVersionJson", "isCurrentSessionFromBreathWakeup", "setSvaSdkEnrollingStatus", "reloadVoiceWakeupSamiCore", "safeClose", "Landroid/content/ContentProviderClient;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricEnrollInteropServiceImpl implements IObricEnrollInteropService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f385625b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f385626a;

    public static final class a {
    }

    public static final class b implements IObricPermissionService.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IObricEnrollInteropService.a f385627a;

        public b(IObricEnrollInteropService.a r100) {
            this.f385627a = r100;
        }

        @Override // com.obric.assistant.permission.IObricPermissionService.a
        public final void a(boolean r100, boolean r101, List<String> r102, List<String> r103) {
            Intrinsics.checkNotNullParameter(r102, "grantedList");
            Intrinsics.checkNotNullParameter(r103, "deniedList");
            this.f385627a.a(r100, r101, r102, r103);
        }
    }

    static {
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void p() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        IObricAccountSPIService r102 = (IObricAccountSPIService) ServiceManager.get().getService(IObricAccountSPIService.class);     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        String r103 = r102.a();     // Catch: Throwable -> L9
    L7:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
    L11:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L15;
        FLogger.f375446a.e("ObricEnrollInteropServiceImpl", "migrateLegacyPhoneWakeupSettings get personal uid failed: " + r105.getMessage());
    L15:
        if (Result.m9455isFailureimpl(r104) == true) goto L18;
        r100 = r104;
    L18:
        String r106 = (String) r100;
        if (r106 != null) goto L22;
        r106 = "";
    L22:
        if (StringsKt.isBlank(r106) == false) goto L25;
        FLogger.f375446a.i("ObricEnrollInteropServiceImpl", "migrateLegacyPhoneWakeupSettings skip: personal uid blank");
        return;
    L25:
        Lazy r107 = pia.d.f529409a;
        Intrinsics.checkNotNullParameter(r106, "uid");
        boolean r108 = false;
        if (StringsKt.isBlank(r106) == false) goto L28;
        boolean r109 = false;
    L30:
        if (r109 == false) goto L70;
    L47:
        Intrinsics.checkNotNullParameter(r106, "uid");
        if (StringsKt.isBlank(r106) == false) goto L50;
        boolean r110 = false;
    L51:
        if (r110 == true) goto L74;
    L58:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Object r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L60:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L63;
        FLogger.f375446a.e("ObricEnrollInteropServiceImpl", "migrateLegacyBreathWakeupSwitch read legacy failed: " + r113.getMessage());
    L63:
        Boolean r114 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r112) == false) goto L66;
        r112 = r114;
    L66:
        boolean r115 = ((Boolean) r112).booleanValue();
        pia.d.n(r106, r115);
        FLogger.f375446a.i("ObricEnrollInteropServiceImpl", "migrateLegacyBreathWakeupSwitch uidLen=" + r106.length() + " enabled=" + r115);
        return;
    L54:
        if (Keva.getRepo("default_sva", 1).getInt(Constant.BREATH_WAKEUP_STATUS, 0) != 1) goto L56;
        r108 = true;
    L56:
        r112 = Result.m9449constructorimpl(Boolean.valueOf(r108));     // Catch: Throwable -> L58
        goto L60
    L74:
        return;
    L50:
        r110 = pia.d.i().contains("breath_wakeup_enabled_".concat(r106));
        goto L51
    L70:
    L38:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        Object r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L40:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
        if (r118 == null) goto L43;
        FLogger.f375446a.e("ObricEnrollInteropServiceImpl", "migrateLegacyVoiceWakeupSwitch read legacy failed: " + r118.getMessage());
    L43:
        Boolean r119 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r117) == false) goto L46;
        r117 = r119;
    L46:
        boolean r120 = ((Boolean) r117).booleanValue();
        pia.d.r(r106, r120);
        FLogger.f375446a.i("ObricEnrollInteropServiceImpl", "migrateLegacyVoiceWakeupSwitch uidLen=" + r106.length() + " enabled=" + r120);
        goto L47
    L33:
        if (Keva.getRepo("default_sva", 1).getInt(Global.SETTINGS_VOICE_ASSISTANT_WAKEUP_STATUS, 0) != 1) goto L35;
        boolean r121 = true;
    L36:
        r117 = Result.m9449constructorimpl(Boolean.valueOf(r121));     // Catch: Throwable -> L38
        goto L40
    L35:
        r121 = false;
        goto L36
    L28:
        r109 = pia.d.i().contains("voice_wakeup_enabled_".concat(r106));
        goto L30
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final String A() {
        String r100 = AccountService.f365697a.getUserId();
        String r101 = obricDeviceManagerDelegate.f389029b.getUuid();
        String r102 = wda.b.a();
        if (r102 != null) goto L5;
        String r103 = r101;
    L6:
        JSONObject r104 = new JSONObject();
        r104.put("engine_version", "1.0.0.100");
        r104.put("voice_print_id", r100 + '-' + r103);
        VoiceEnrollServiceDelegate r105 = VoiceEnrollServiceDelegate.f395411c;
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        r104.put("has_feature", r105.r(r102));
        r104.put("default_did", r101);
        return r104.toString();
    L5:
        r103 = r102;
        goto L6
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean b() {
        return t1.f393353a.b();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final String c() {
        return obricDeviceManagerDelegate.f389029b.getUuid();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean d() {
        IObricVoiceService.f394360a.getClass();
        IObricVoiceService r100 = IObricVoiceService.a.a();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.d() != true) goto L7;
        return true;
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean g() {
        IObricUserGuide r100 = (IObricUserGuide) ServiceManager.get().getService(IObricUserGuide.class);
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.h() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void h() {
        t1.f393353a.y(true);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean i() {
        return t1.f393353a.i();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void o() {
        Context r100 = AppHost.f326268a.getApplication().getApplicationContext();
        BuildersKt.launch$default(this.f385626a, null, null, new ObricEnrollInteropServiceImpl$reloadVoiceWakeupSamiCore$1(r100, this, null), 3, null);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void s() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(AccountService.f365697a.getUserId());     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L9;
        r101 = null;
    L9:
        String r102 = (String) r101;
        if (r102 != null) goto L13;
        r102 = "";
    L13:
        if (StringsKt.isBlank(r102) == false) goto L15;
        return;
    L15:
        BuildersKt.launch$default(this.f385626a, null, null, new ObricEnrollInteropServiceImpl$syncHelpImproveVoiceWakeupEnabled$1(true, r102, null), 3, null);
        return;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean t() {
        return t1.f393353a.x0();
    }

    public ObricEnrollInteropServiceImpl() {
        this.f385626a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final String v() {
        CoWakeupApi r100 = uha.a.a();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        String r103 = "";
        if (r102 == false) goto L17;
        IDoraWakeupService r104 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r104 != null) goto L13;
    L15:
        if (r101 == false) goto L17;
        return "";
    L13:
        if (r104.n() == true) goto L15;
        r101 = true;
    L17:
        String r105 = AccountService.f365697a.getUserId();
        String r106 = obricDeviceManagerDelegate.f389029b.getUuid();
        String r107 = wda.b.a();
        if (r107 != null) goto L20;
        String r108 = r106;
    L21:
        JSONObject r109 = new JSONObject();
        r109.put("engine_version", "1.0.0.100");
        r109.put("voice_print_id", r105 + '-' + r108);
        VoiceEnrollServiceDelegate r110 = VoiceEnrollServiceDelegate.f395411c;
        if (r107 == null) goto L25;
        r103 = r107;
    L25:
        r109.put("has_feature", r110.r(r103));
        r109.put("default_did", r106);
        return r109.toString();
    L20:
        r108 = r107;
        goto L21
    L5:
        if (r100.b() != true) goto L7;
        r102 = true;
        goto L8
    }

    public static void B(ContentProviderClient r100) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        r100.close();
        return;
    L5:
        r100.release();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void f(boolean r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(AccountService.f365697a.getUserId());     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r102) == false) goto L9;
        r102 = null;
    L9:
        String r103 = (String) r102;
        if (r103 != null) goto L13;
        r103 = "";
    L13:
        if ((!StringsKt.isBlank(r103)) == false) goto L15;
        pia.d.r(r103, r100);
    L15:
        t1.f393353a.f(r100);
        return;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void j(boolean r100) {
        Bundle r101 = new Bundle();
        r101.putBoolean("status", r100);
        ContentProviderClient r102 = 0;
        ContentProviderClient r103 = a(AppHost.f326268a.getApplication().getContentResolver(), com.obric.assistant.voice.k.f394380a);     // Catch: Throwable -> L11 RemoteException -> L13
        if (r103 != null) goto L25;
    L9:
        if (r103 == null) goto L28;
    L17:
        B(r103);
        return;
    L28:
        return;
    L25:
        r103.call("breath-set-status", null, r101);     // Catch: RemoteException -> L7 Throwable -> L19
    L7:
        RemoteException e100 = e;
    L15:
        FLogger.f375446a.e("ObricEnrollInteropServiceImpl", "applyBreathWakeupEnabled failed: " + e100.getMessage());     // Catch: Throwable -> L19
        if (r103 != null) goto L17;
        return;
    L19:
        th = move-exception;
        th = th;
        r102 = "status";
    L21:
        if (r102 == 0) goto L23;
        B(r102);
    L23:
        throw th;
    L13:
        e = move-exception;
        r103 = null;
        e100 = e;
    L11:
        th = th;
        goto L21
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (StringsKt.isBlank(r100) == false) goto L21;
        return false;
    L21:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(AccountService.f365697a.getUserId());     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r102) == false) goto L12;
        r102 = null;
    L12:
        String r103 = (String) r102;
        if (r103 != null) goto L16;
        r103 = "";
    L16:
        if (Intrinsics.areEqual(r100, r103) == false) goto L20;
        return t1.f393353a.x0();
    L20:
        return Keva.getRepo("obric_settings_".concat(r100), 0).getBoolean("voice_wakeup_audio_upload_enable", false);
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final Object q(Continuation<? super Boolean> r100) {
        if ((r100 instanceof ObricEnrollInteropServiceImpl$refreshHelpImproveVoiceWakeupEnabled$1) == false) goto L7;
        ObricEnrollInteropServiceImpl$refreshHelpImproveVoiceWakeupEnabled$1 r101 = (ObricEnrollInteropServiceImpl$refreshHelpImproveVoiceWakeupEnabled$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L18:
        return Boxing.boxBoolean(((ObricUserExperiencePlanManager.a) r103).f392040a);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        ObricUserExperiencePlanManager r106 = ObricUserExperiencePlanManager.f392033a;
        r101.label = 1;
        r103 = r106.f(r101);
        if (r103 != r104) goto L18;
        return r104;
    L7:
        r101 = new ObricEnrollInteropServiceImpl$refreshHelpImproveVoiceWakeupEnabled$1(this, r100);
        goto L8
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean u(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return false;
    L5:
        p();
        Lazy r101 = pia.d.f529409a;
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (StringsKt.isBlank(r100) == false) goto L9;
        return false;
    L9:
        return pia.d.i().getBoolean("voice_wakeup_enabled_" + r100, false);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void w(boolean r100) {
        IObricVoiceService.f394360a.getClass();
        IObricVoiceService r101 = IObricVoiceService.a.a();
        if (r101 == null) goto L6;
        r101.i(r100);
        return;
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void x(boolean r110) {
        Bundle r100 = new Bundle();
        r100.putBoolean("status", r110);
        r100.putBinder("owner_token", com.obric.assistant.voice.c.f394376a);
        r100.putLong("ipc_generation", com.obric.assistant.voice.c.f394377b);
        Context r101 = AppHost.f326268a.getApplication().getApplicationContext();
        BuildersKt.launch$default(this.f385626a, null, null, new ObricEnrollInteropServiceImpl$setSvaSdkEnrollingStatus$1(r110, r101, r100, this, null), 3, null);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean y(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return false;
    L5:
        p();
        Lazy r101 = pia.d.f529409a;
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (StringsKt.isBlank(r100) == false) goto L9;
        return false;
    L9:
        return pia.d.i().getBoolean("breath_wakeup_enabled_" + r100, false);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void z(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (StringsKt.isBlank(r100) == false) goto L6;
        FLogger.f375446a.i("ObricEnrollInteropServiceImpl", "resetLockedUseAuthenticationTypeWhenVoicePrintDeleted skip: blank uid");
        return;
    L6:
        Lazy r101 = pia.d.f529409a;
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (StringsKt.isBlank(r100) == true) goto L25;
        pia.d.i().storeBoolean("locked_auth_type_cleared_".concat(r100), true);
    L25:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        Object r103 = Result.m9449constructorimpl(AccountService.f365697a.getUserId());     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r103) == false) goto L17;
        r103 = null;
    L17:
        String r104 = (String) r103;
        if (r104 != null) goto L21;
        r104 = "";
    L21:
        if (Intrinsics.areEqual(r100, r104) == false) goto L23;
        t1.f393353a.h0();
        return;
    L23:
        FLogger.f375446a.i("ObricEnrollInteropServiceImpl", "resetLockedUseAuthenticationTypeWhenVoicePrintDeleted uidLen=" + r100.length() + " currentUidLen=" + r104.length() + ", record only (not current login)");
        return;
    L12:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static ContentProviderClient a(ContentResolver r110, Uri r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240008);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r110, r101, "android.content.ContentProviderClient", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ContentProviderClient) r107.f474983b;
    L21:
        return r110.acquireUnstableContentProviderClient(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void e(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        IObricVoiceService.f394360a.getClass();
        IObricVoiceService r102 = IObricVoiceService.a.a();
        if (r102 == null) goto L6;
        r102.e(r100, r101);
        return;
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void k(FragmentActivity r110, IObricEnrollInteropService.a r111) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "callback");
        IObricPermissionService r100 = (IObricPermissionService) ServiceManager.get().getService(IObricPermissionService.class);
        if (r100 != null) goto L6;
        r111.a(true, false, CollectionsKt.emptyList(), CollectionsKt.emptyList());
        return;
    L6:
        IObricPermissionService.f391047a.getClass();
        r100.n(r110, IObricPermissionService.Companion.f391051d, true, false, false, false, new b(r111));
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void l(boolean r100, List<String> r101) {
        t1.f393353a.l(r100, r101);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void n(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (StringsKt.isBlank(r100) == false) goto L6;
        FLogger.f375446a.i("ObricEnrollInteropServiceImpl", "setVoiceWakeupEnabled skip: blank uid enabled=" + r101);
        return;
    L6:
        pia.d.r(r100, r101);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        Object r103 = Result.m9449constructorimpl(AccountService.f365697a.getUserId());     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r103) == false) goto L14;
        r103 = null;
    L14:
        String r104 = (String) r103;
        if (r104 != null) goto L18;
        r104 = "";
    L18:
        if (Intrinsics.areEqual(r100, r104) == false) goto L20;
        t1.f393353a.f(r101);
        return;
    L20:
        FLogger.f375446a.i("ObricEnrollInteropServiceImpl", "setVoiceWakeupEnabled uidLen=" + r100.length() + " currentUidLen=" + r104.length() + " enabled=" + r101 + ", record only (not current login)");
        return;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void r(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (StringsKt.isBlank(r100) == false) goto L6;
        FLogger.f375446a.i("ObricEnrollInteropServiceImpl", "setBreathWakeupEnabled skip: blank uid enabled=" + r101);
        return;
    L6:
        pia.d.n(r100, r101);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        Object r103 = Result.m9449constructorimpl(AccountService.f365697a.getUserId());     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r103) == false) goto L14;
        r103 = null;
    L14:
        String r104 = (String) r103;
        if (r104 != null) goto L18;
        r104 = "";
    L18:
        if (Intrinsics.areEqual(r100, r104) == false) goto L20;
        j(r101);
        return;
    L20:
        FLogger.f375446a.i("ObricEnrollInteropServiceImpl", "setBreathWakeupEnabled uidLen=" + r100.length() + " currentUidLen=" + r104.length() + " enabled=" + r101 + ", record only (not current login)");
        return;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }
}
