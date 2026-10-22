package com.enroll.audio.enroll;

import com.larus.dora.impl.util.p0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\t\u0010\t\u001a\u00020\u0005H\u0096\u0001J'\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0096\u0001J\t\u0010\u000e\u001a\u00020\rH\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u001b\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00120\u0011H\u0096\u0001J\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0005H\u0096\u0001J'\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0019\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0096\u0001¨\u0006\u001f"}, d2 = {"Lcom/enroll/audio/enroll/VoiceEnrollServiceDelegate;", "Lcom/enroll/audio/enroll/IVoiceEnrollService;", "<init>", "()V", "addEnrolledDevice", "", "sn", "", "deviceName", "clearVoicePrint", "deleteEnrolledDevice", "callback", "Lkotlin/Function1;", "", "getDefaultVoicePrintEnrollStatus", "getDeviceEnrollStatus", "getEnrolledDevices", "", "Lkotlin/Pair;", "getSpeechFingerprintResult", "", "isBtHeadsetVoicePrintRecorded", "preloadVoicePrintResourcesIfNeeded", "query", "queryBtHeadsetVoicePrintCloudAndResetLocalStatus", "updateBtHeadsetEnrollModelPaths", "firstKwsModelPath", "sidEnrollModelPath", "silentFilePath", "updateEnrolledDeviceName", "newName", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceEnrollServiceDelegate implements IVoiceEnrollService {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final VoiceEnrollServiceDelegate f273711c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IVoiceEnrollService f273712b;

    static {
        f273711c = new VoiceEnrollServiceDelegate();
    }

    @Override // com.enroll.audio.enroll.IVoiceEnrollService
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sn");
        return this.f273712b.a(r100);
    }

    @Override // com.enroll.audio.enroll.IVoiceEnrollService
    public final void b(String r100, String r101, String r102) {
        this.f273712b.b(r100, r101, r102);
    }

    @Override // com.enroll.audio.enroll.IVoiceEnrollService
    public final boolean f() {
        return this.f273712b.f();
    }

    @Override // com.enroll.audio.enroll.IVoiceEnrollService
    public final void g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "sn");
        Intrinsics.checkNotNullParameter(r101, "deviceName");
        this.f273712b.g(r100, r101);
    }

    @Override // com.enroll.audio.enroll.IVoiceEnrollService
    public final byte[] h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sn");
        return this.f273712b.h(r100);
    }

    @Override // com.enroll.audio.enroll.IVoiceEnrollService
    public final void i() {
        this.f273712b.i();
    }

    @Override // com.enroll.audio.enroll.IVoiceEnrollService
    public final void j(String r100, p0 r101) {
        Intrinsics.checkNotNullParameter(r100, "sn");
        this.f273712b.j(r100, r101);
    }

    @Override // com.enroll.audio.enroll.IVoiceEnrollService
    public boolean query(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sn");
        return this.f273712b.query(r100);
    }

    private VoiceEnrollServiceDelegate() {
        this.f273712b = (IVoiceEnrollService) ServiceManager.get().getService(IVoiceEnrollService.class);
    }
}
