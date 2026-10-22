package hga;

import com.obric.assistant.spi.audio.WakeupAudioCaptureReadScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WakeupAudioCaptureReadScene f485035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f485036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f485037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f485038d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f485035a == r101.f485035a) goto L12;
        return false;
    L12:
        if (this.f485036b == r101.f485036b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f485037c, r101.f485037c) == true) goto L18;
        return false;
    L18:
        if (this.f485038d == r101.f485038d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f485035a.hashCode() * 31;
        long r101 = this.f485036b;
        return ((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f485037c.hashCode()) * 31) + this.f485038d;
    }

    public final String toString() {
        return "WakeupAudioCaptureReadRequest(scene=" + this.f485035a + ", wantedStartTimeMs=" + this.f485036b + ", reason=" + this.f485037c + ", wakeupId=" + this.f485038d + ')';
    }

    public /* synthetic */ e(WakeupAudioCaptureReadScene r100, long r101, String r110) {
        this(r100, r101, r110, 0);
    }

    public e(WakeupAudioCaptureReadScene r100, long r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r102, "reason");
        this.f485035a = r100;
        this.f485036b = r101;
        this.f485037c = r102;
        this.f485038d = r103;
    }
}
