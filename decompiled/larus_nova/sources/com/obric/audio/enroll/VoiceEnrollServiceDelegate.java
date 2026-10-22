package com.obric.audio.enroll;

import com.obric.assistant.settings.voiceprint.v;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J)\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u0005H\u0096\u0001J\u001f\u0010\u000e\u001a\u00020\u00052\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0096\u0001J'\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00072\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J'\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u0016\u001a\u00020\rH\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0096\u0001J\u001b\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001c0\u0019H\u0096\u0001J\u0011\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u001e\u001a\u00020\rH\u0096\u0001J\t\u0010\u001f\u001a\u00020\rH\u0096\u0001J\t\u0010 \u001a\u00020\u0014H\u0096\u0001J\u0011\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\rH\u0096\u0001J\t\u0010\"\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010#\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\rH\u0096\u0001J\t\u0010&\u001a\u00020\u0005H\u0096\u0001J'\u0010'\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u00072\b\u0010)\u001a\u0004\u0018\u00010\u00072\b\u0010*\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0019\u0010+\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0096\u0001J\t\u0010-\u001a\u00020\u0005H\u0096\u0001¨\u0006."}, d2 = {"Lcom/obric/audio/enroll/VoiceEnrollServiceDelegate;", "Lcom/obric/audio/enroll/IVoiceEnrollService;", "<init>", "()V", "addEnrolledDevice", "", "sn", "", "deviceName", "clearAllVoicePrintByUid", "fallbackUid", "callback", "Lkotlin/Function1;", "", "clearVoicePrint", "clearVoicePrintForUid", "uid", "deleteDefaultVoicePrintFromCloud", "deleteEnrolledDevice", "forceReEnrollWakeupSid", "", "reason", "getDefaultVoicePrintEnrollStatus", "getDeviceEnrollStatus", "getEnrolledDeviceInfos", "", "Lcom/obric/audio/enroll/EnrolledDeviceInfo;", "getEnrolledDevices", "Lkotlin/Pair;", "isBtHeadsetVoicePrintRecorded", "isDefaultVoicePrintRecordedWithMic0Flow", "isDefaultVoicePrintUploadedToCloud", "migrateLegacyPhoneEnrollIfNeeded", "skipForEnterprise", "queryBtHeadsetVoicePrintCloudAndResetLocalStatus", "releaseVoiceEnrollStateForAccountChange", "setDefaultVoicePrintTrainable", "isTrainable", "tryDeleteBtAndDoraVoicePrintOnce", "updateBtHeadsetEnrollModelPaths", "firstKwsModelPath", "sidEnrollModelPath", "silentFilePath", "updateEnrolledDeviceName", "newName", "uploadDefaultVoicePrintToCloud", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceEnrollServiceDelegate implements IVoiceEnrollService {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final VoiceEnrollServiceDelegate f395411c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IVoiceEnrollService f395412b;

    static {
        f395411c = new VoiceEnrollServiceDelegate();
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sn");
        return this.f395412b.a(r100);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void b(String r100, String r101, String r102) {
        this.f395412b.b(r100, r101, r102);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final boolean c() {
        return this.f395412b.c();
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final boolean d() {
        return this.f395412b.d();
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void e(v r100) {
        this.f395412b.e(r100);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final boolean f() {
        return this.f395412b.f();
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "sn");
        Intrinsics.checkNotNullParameter(r101, "deviceName");
        this.f395412b.g(r100, r101);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void h(boolean r100) {
        this.f395412b.h(r100);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f395412b.i(r100);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void j(String r100, com.obric.assistant.settings.voiceprint.g r101) {
        Intrinsics.checkNotNullParameter(r100, "sn");
        this.f395412b.j(r100, r101);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void k() {
        this.f395412b.k();
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final int l(boolean r100) {
        return this.f395412b.l(r100);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final List<d> m() {
        return this.f395412b.m();
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void n() {
        this.f395412b.n();
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final int o() {
        return this.f395412b.o();
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void p() {
        this.f395412b.p();
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void q(String r100) {
        this.f395412b.q(r100);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final boolean r(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sn");
        return this.f395412b.r(r100);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final int s(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        return this.f395412b.s(r100);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void t(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        this.f395412b.t(r100);
    }

    private VoiceEnrollServiceDelegate() {
        this.f395412b = (IVoiceEnrollService) ServiceManager.get().getService(IVoiceEnrollService.class);
    }
}
