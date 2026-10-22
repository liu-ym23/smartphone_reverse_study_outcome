package com.obric.assistant.spi.audio;

import androidx.fragment.app.FragmentActivity;
import com.heytap.mcssdk.constant.b;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0001J\t\u0010\n\u001a\u00020\tH\u0096\u0001J\t\u0010\u000b\u001a\u00020\tH\u0096\u0001J\u0011\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\tH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u000f\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\tH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\tH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0005H\u0096\u0001J\u000e\u0010\u0013\u001a\u00020\u0007H\u0096A¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\tH\u0096\u0001J!\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00072\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001fH\u0096\u0001J\u0011\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\"\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010#\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010$\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010$\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010%\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010&\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010&\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\tH\u0096\u0001J\t\u0010+\u001a\u00020\u0007H\u0096\u0001¨\u0006,"}, d2 = {"Lcom/obric/assistant/spi/audio/ObricEnrollInteropDelegate;", "Lcom/obric/assistant/spi/audio/IObricEnrollInteropService;", "<init>", "()V", "applyBreathWakeupEnabled", "", "enabled", "", "buildDoraEngineVersionJson", "", "buildObricContPvadVersionJson", "getDeviceUuid", "isBreathWakeupEnabled", "uid", "isCurrentSessionFromBreathWakeup", "isHelpImproveVoiceWakeupEnabled", "isLockedScreenUseEnabled", "isVoiceWakeupEnabled", "migrateLegacyPhoneWakeupSettingsToPersonalUid", "refreshHelpImproveVoiceWakeupEnabled", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reloadVoiceWakeupSamiCore", "requestEnrollGuideRecordPermission", "activity", "Landroidx/fragment/app/FragmentActivity;", "callback", "Lcom/obric/assistant/spi/audio/IObricEnrollInteropService$EnrollPermissionCallback;", "resetLockedUseAuthenticationTypeWhenVoicePrintDeleted", "saveVoicePrintAuthenticationTypeForLockedUseSettings", "isSetDefaultSettingItems", "currentSettingItems", "", "setAssistantEnrollingStatus", "enrolling", "setBreathWakeupEnabled", "setContinueSpeakNoiseReductionEnabled", "setHelpImproveVoiceWakeupEnabled", "setSvaSdkEnrollingStatus", "setVoiceWakeupEnabled", "trackEnrollData", b.f276361k, "", "data", "useSystemDrawableForEnrollGuide", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricEnrollInteropDelegate implements IObricEnrollInteropService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricEnrollInteropDelegate f392835b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricEnrollInteropService f392836a;

    static {
        f392835b = new ObricEnrollInteropDelegate();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final String A() {
        return this.f392836a.A();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean b() {
        return this.f392836a.b();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final String c() {
        return this.f392836a.c();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean d() {
        return this.f392836a.d();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void e(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f392836a.e(r100, r101);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void f(boolean r100) {
        this.f392836a.f(r100);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean g() {
        return this.f392836a.g();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void h() {
        this.f392836a.h();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean i() {
        return this.f392836a.i();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void j(boolean r100) {
        this.f392836a.j(r100);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void k(FragmentActivity r100, IObricEnrollInteropService.a r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f392836a.k(r100, r101);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void l(boolean r100, List<String> r101) {
        this.f392836a.l(r100, r101);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        return this.f392836a.m(r100);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void n(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        this.f392836a.n(r100, r101);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void o() {
        this.f392836a.o();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void p() {
        this.f392836a.p();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final Object q(Continuation<? super Boolean> r100) {
        return this.f392836a.q(r100);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void r(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        this.f392836a.r(r100, r101);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void s() {
        this.f392836a.s();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean t() {
        return this.f392836a.t();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean u(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        return this.f392836a.u(r100);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final String v() {
        return this.f392836a.v();
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void w(boolean r100) {
        this.f392836a.w(r100);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void x(boolean r100) {
        this.f392836a.x(r100);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final boolean y(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        return this.f392836a.y(r100);
    }

    @Override // com.obric.assistant.spi.audio.IObricEnrollInteropService
    public final void z(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        this.f392836a.z(r100);
    }

    private ObricEnrollInteropDelegate() {
        IObricEnrollInteropService r100 = (IObricEnrollInteropService) ServiceManager.get().getService(IObricEnrollInteropService.class);
        if (r100 != null) goto L5;
        r100 = new DefaultObricEnrollInteropServiceImpl();
    L5:
        this.f392836a = r100;
    }
}
