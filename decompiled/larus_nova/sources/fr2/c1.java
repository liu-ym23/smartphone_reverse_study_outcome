package fr2;

import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedAudioDiagnosisType;
import com.bytedance.android.livesdk.revenue.service.livecore.IAudioDiagnosisTypeEnumParam;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c1 implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c1 f478493b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c1 f478494c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f478495d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ILiveWrappedAudioDiagnosisType f478496a;

    public static final class a {
        public a() {
        }

        public static c1 a(ILiveWrappedAudioDiagnosisType r100) {
            Intrinsics.checkNotNullParameter(r100, "real");
            if (r100 != ILiveWrappedAudioDiagnosisType.AudioDiagnosisTypeLoop) goto L7;
            return b(IAudioDiagnosisTypeEnumParam.AudioDiagnosisTypeLoop);
        L7:
            if (r100 == ILiveWrappedAudioDiagnosisType.AudioDiagnosisTypeOneShot) goto L9;
            return null;
        L9:
            return b(IAudioDiagnosisTypeEnumParam.AudioDiagnosisTypeOneShot);
        }

        public static c1 b(IAudioDiagnosisTypeEnumParam r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            int r101 = b1.f478491a[r100.ordinal()];
            if (r101 == 1) goto L10;
            if (r101 != 2) goto L8;
            return c1.f478494c;
        L8:
            throw new NoWhenBranchMatchedException();
        L10:
            return c1.f478493b;
        }
    }

    static {
        f478495d = new a();
        f478493b = new c1(ILiveWrappedAudioDiagnosisType.AudioDiagnosisTypeLoop);
        f478494c = new c1(ILiveWrappedAudioDiagnosisType.AudioDiagnosisTypeOneShot);
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f478496a;
    }

    public c1(ILiveWrappedAudioDiagnosisType r100) {
        this.f478496a = r100;
    }
}
