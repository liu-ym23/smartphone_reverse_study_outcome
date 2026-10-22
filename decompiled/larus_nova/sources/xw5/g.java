package xw5;

import com.bytedance.flow_audio.api.service.common.KMPFlowAudioSceneASRReplyEndReason;
import com.bytedance.flow_audio.api.service.common.KMPFlowAudioSceneBroadcastEventType;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KMPFlowAudioSceneBroadcastEventType f565232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f565233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f565234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f565235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final KMPFlowAudioSceneASRReplyEndReason f565236e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f565237f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f565238g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f565239h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f565240i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f565241j;

    public g() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f565232a == r101.f565232a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f565233b, r101.f565233b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f565234c, r101.f565234c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f565235d, r101.f565235d) == true) goto L21;
        return false;
    L21:
        if (this.f565236e == r101.f565236e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f565237f, r101.f565237f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f565238g, r101.f565238g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f565239h, r101.f565239h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f565240i, r101.f565240i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f565241j, r101.f565241j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f565232a.hashCode() * 31;
        String r101 = this.f565233b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f565234c.hashCode()) * 31;
        String r105 = this.f565235d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        KMPFlowAudioSceneASRReplyEndReason r108 = this.f565236e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f565237f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Boolean r114 = this.f565238g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f565239h;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f565240i;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f565241j;
        if (r123 == null) goto L35;
        r102 = r123.hashCode();
    L35:
        return r122 + r102;
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "KMPFlowAudioSceneBroadcastEvent(type=" + this.f565232a + ", scene=" + this.f565233b + ", info=" + this.f565234c + ", asrLocalMessageID=" + this.f565235d + ", reason=" + this.f565236e + ", messageID=" + this.f565237f + ", isQuestion=" + this.f565238g + ", replyID=" + this.f565239h + ", localCallID=" + this.f565240i + ", questionID=" + this.f565241j + ')';
    }

    public final KMPFlowAudioSceneBroadcastEventType getType() {
        return this.f565232a;
    }

    public g(KMPFlowAudioSceneBroadcastEventType r100, String r101, String r102, KMPFlowAudioSceneASRReplyEndReason r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        Map<String, Object> r105 = MapsKt.emptyMap();
    L10:
        if ((r104 & 8) == 0) goto L13;
        r102 = null;
    L13:
        if ((r104 & 16) == 0) goto L15;
        r103 = null;
    L15:
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r105, "info");
        this.f565232a = r100;
        this.f565233b = r101;
        this.f565234c = r105;
        this.f565235d = r102;
        this.f565236e = r103;
        this.f565237f = null;
        this.f565238g = null;
        this.f565239h = null;
        this.f565240i = null;
        this.f565241j = null;
        return;
    L8:
        r105 = null;
        goto L10
    }
}
