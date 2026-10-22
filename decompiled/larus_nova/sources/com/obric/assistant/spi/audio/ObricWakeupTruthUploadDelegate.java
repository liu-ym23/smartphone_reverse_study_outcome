package com.obric.assistant.spi.audio;

import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hga.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\t\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0005H\u0096\u0001¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/spi/audio/ObricWakeupTruthUploadDelegate;", "Lcom/obric/assistant/spi/audio/IObricWakeupTruthUploadService;", "<init>", "()V", "clearRegisterDataIdForUid", "", "uid", "", "reason", "consumeFirstWakeupAfterVoiceprintRecord", "", "consumeWakeupPocketMode", InteractConst.WAKEUP_WAKEUP_ID, "", "markVoiceprintRecordedForNextWakeup", "markWakeupPocketMode", "pocketMode", "onVoiceWakeupAudioCaptured", "data", "Lcom/obric/assistant/spi/audio/WakeupTruthUploadData;", "onVoiceWakeupCaptureStarted", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricWakeupTruthUploadDelegate implements IObricWakeupTruthUploadService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricWakeupTruthUploadDelegate f392845b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IObricWakeupTruthUploadService f392846a;

    static {
        f392845b = new ObricWakeupTruthUploadDelegate();
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final void a() {
        Intrinsics.checkNotNullParameter("voiceprint enroll success", "reason");
        this.f392846a.a();
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final void b() {
        this.f392846a.b();
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final boolean c() {
        return this.f392846a.c();
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final void d(int r100, boolean r101) {
        this.f392846a.d(r100, r101);
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final void e(g r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f392846a.e(r100);
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final void f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "reason");
        this.f392846a.f(r100, r101);
    }

    @Override // com.obric.assistant.spi.audio.IObricWakeupTruthUploadService
    public final boolean g(int r100) {
        return this.f392846a.g(r100);
    }

    private ObricWakeupTruthUploadDelegate() {
        this.f392846a = (IObricWakeupTruthUploadService) ServiceManager.get().getService(IObricWakeupTruthUploadService.class);
    }
}
