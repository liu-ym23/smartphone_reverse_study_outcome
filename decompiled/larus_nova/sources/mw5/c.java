package mw5;

import com.bytedance.flow_audio.api.scene.FlowAudioAssistantScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlowAudioAssistantScene f515947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f515948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f515949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f515950d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f515947a == r101.f515947a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f515948b, r101.f515948b) == true) goto L15;
        return false;
    L15:
        if (Double.compare(this.f515949c, r101.f515949c) == 0) goto L18;
        return false;
    L18:
        if (this.f515950d == r101.f515950d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f515947a.hashCode() * 31;
        b r101 = this.f515948b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        long r104 = Double.doubleToLongBits(this.f515949c);
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        if (this.f515950d == false) goto L9;
        int r106 = 1231;
    L11:
        return r105 + r106;
    L9:
        r106 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowAudioTtsSessionConfig(scene=" + this.f515947a + ", ttsConfig=" + this.f515948b + ", recAudioTimeout=" + this.f515949c + ", allowUploadText=" + this.f515950d + ')';
    }

    public c(FlowAudioAssistantScene r100, b r101, double r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f515947a = r100;
        this.f515948b = r101;
        this.f515949c = r102;
        this.f515950d = r103;
    }
}
