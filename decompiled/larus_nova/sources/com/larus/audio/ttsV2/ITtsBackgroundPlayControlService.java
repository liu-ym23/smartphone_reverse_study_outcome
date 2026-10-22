package com.larus.audio.ttsV2;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/larus/audio/ttsV2/ITtsBackgroundPlayControlService;", "", "allowPlayWhenAppBackground", "", "shouldStopWhenEnterBackgroundDuringPlayback", "TtsBackgroundPlayControlServiceDelegate", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ITtsBackgroundPlayControlService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TtsBackgroundPlayControlServiceDelegate f289865a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001¨\u0006\u0007"}, d2 = {"Lcom/larus/audio/ttsV2/ITtsBackgroundPlayControlService$TtsBackgroundPlayControlServiceDelegate;", "Lcom/larus/audio/ttsV2/ITtsBackgroundPlayControlService;", "<init>", "()V", "allowPlayWhenAppBackground", "", "shouldStopWhenEnterBackgroundDuringPlayback", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TtsBackgroundPlayControlServiceDelegate implements ITtsBackgroundPlayControlService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ TtsBackgroundPlayControlServiceDelegate f289866c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ITtsBackgroundPlayControlService f289867b;

        static {
            f289866c = new TtsBackgroundPlayControlServiceDelegate();
        }

        @Override // com.larus.audio.ttsV2.ITtsBackgroundPlayControlService
        public final boolean a() {
            return this.f289867b.a();
        }

        @Override // com.larus.audio.ttsV2.ITtsBackgroundPlayControlService
        public final boolean b() {
            return this.f289867b.b();
        }

        private TtsBackgroundPlayControlServiceDelegate() {
            ITtsBackgroundPlayControlService r100 = (ITtsBackgroundPlayControlService) ServiceManager.get().getService(ITtsBackgroundPlayControlService.class);
            if (r100 != null) goto L5;
            r100 = new TtsBackgroundPlayControlServiceNoop();
        L5:
            this.f289867b = r100;
        }
    }

    static {
        f289865a = TtsBackgroundPlayControlServiceDelegate.f289866c;
    }

    boolean a();

    boolean b();
}
