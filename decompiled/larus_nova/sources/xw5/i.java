package xw5;

import com.bytedance.flow_audio.api.service.common.KMPFlowAudioSceneInterruptReasonType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KMPFlowAudioSceneInterruptReasonType f565245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f565246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f565247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f565248d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f565245a == r101.f565245a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f565246b, r101.f565246b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f565247c, r101.f565247c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f565248d, r101.f565248d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f565245a.hashCode() * 31;
        Integer r101 = this.f565246b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f565247c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f565248d;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "KMPFlowAudioSceneInterruptReason(type=" + this.f565245a + ", systemReason=" + this.f565246b + ", otherScene=" + this.f565247c + ", message=" + this.f565248d + ')';
    }

    public i() {
        KMPFlowAudioSceneInterruptReasonType r100 = KMPFlowAudioSceneInterruptReasonType.UNKNOWN;
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f565245a = r100;
        this.f565246b = null;
        this.f565247c = null;
        this.f565248d = null;
    }

    public final KMPFlowAudioSceneInterruptReasonType getType() {
        return this.f565245a;
    }
}
