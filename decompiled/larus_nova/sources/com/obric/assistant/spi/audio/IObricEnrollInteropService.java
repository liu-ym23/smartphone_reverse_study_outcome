package com.obric.assistant.spi.audio;

import androidx.fragment.app.FragmentActivity;
import com.heytap.mcssdk.constant.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001:\u0001*J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\nH&J\b\u0010\u0010\u001a\u00020\u0005H&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\nH&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H&J\b\u0010\u0015\u001a\u00020\u0005H&J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00052\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0019H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H&J\b\u0010\u001b\u001a\u00020\u0005H&J\u000e\u0010\u001c\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u001dJ\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\nH&J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H&J\b\u0010#\u001a\u00020\u0005H&J\b\u0010$\u001a\u00020\nH&J\b\u0010%\u001a\u00020\nH&J\b\u0010&\u001a\u00020\nH&J\b\u0010'\u001a\u00020\u0005H&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010)\u001a\u00020\u0003H&¨\u0006+"}, d2 = {"Lcom/obric/assistant/spi/audio/IObricEnrollInteropService;", "", "setAssistantEnrollingStatus", "", "enrolling", "", "trackEnrollData", b.f276361k, "", "data", "", "setVoiceWakeupEnabled", "enabled", "setContinueSpeakNoiseReductionEnabled", "resetLockedUseAuthenticationTypeWhenVoicePrintDeleted", "uid", "isVoiceWakeupEnabled", "migrateLegacyPhoneWakeupSettingsToPersonalUid", "isBreathWakeupEnabled", "setBreathWakeupEnabled", "applyBreathWakeupEnabled", "isLockedScreenUseEnabled", "saveVoicePrintAuthenticationTypeForLockedUseSettings", "isSetDefaultSettingItems", "currentSettingItems", "", "setHelpImproveVoiceWakeupEnabled", "isHelpImproveVoiceWakeupEnabled", "refreshHelpImproveVoiceWakeupEnabled", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestEnrollGuideRecordPermission", "activity", "Landroidx/fragment/app/FragmentActivity;", "callback", "Lcom/obric/assistant/spi/audio/IObricEnrollInteropService$EnrollPermissionCallback;", "useSystemDrawableForEnrollGuide", "getDeviceUuid", "buildDoraEngineVersionJson", "buildObricContPvadVersionJson", "isCurrentSessionFromBreathWakeup", "setSvaSdkEnrollingStatus", "reloadVoiceWakeupSamiCore", "EnrollPermissionCallback", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricEnrollInteropService {

    public interface a {
        void a(boolean r100, boolean r101, List<String> r102, List<String> r103);
    }

    String A();

    boolean b();

    String c();

    boolean d();

    void e(int r100, String r101);

    void f(boolean r100);

    boolean g();

    void h();

    boolean i();

    void j(boolean r100);

    void k(FragmentActivity r100, a r101);

    void l(boolean r100, List<String> r101);

    boolean m(String r100);

    void n(String r100, boolean r101);

    void o();

    void p();

    Object q(Continuation<? super Boolean> r100);

    void r(String r100, boolean r101);

    void s();

    boolean t();

    boolean u(String r100);

    String v();

    void w(boolean r100);

    void x(boolean r100);

    boolean y(String r100);

    void z(String r100);
}
