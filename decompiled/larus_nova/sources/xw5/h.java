package xw5;

import com.bytedance.flow_audio.api.service.common.KMPFlowAudioSceneErrorCode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KMPFlowAudioSceneErrorCode f565242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f565243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f565244c;

    /* JADX WARN: Multi-variable type inference failed */
    public h() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f565242a == r101.f565242a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f565243b, r101.f565243b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f565244c, r101.f565244c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f565242a.hashCode() * 31;
        String r101 = this.f565243b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f565244c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "KMPFlowAudioSceneError(code=" + this.f565242a + ", message=" + this.f565243b + ", occupiedScene=" + this.f565244c + ')';
    }

    public /* synthetic */ h(KMPFlowAudioSceneErrorCode r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = KMPFlowAudioSceneErrorCode.UNKNOWN;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101, null);
    }

    public h(KMPFlowAudioSceneErrorCode r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "code");
        this.f565242a = r100;
        this.f565243b = r101;
        this.f565244c = r102;
    }
}
