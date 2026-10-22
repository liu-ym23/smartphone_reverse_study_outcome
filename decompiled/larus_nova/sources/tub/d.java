package tub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecordingPriorityScene f547643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f547644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f547645c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f547643a == r101.f547643a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f547644b, r101.f547644b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f547645c, r101.f547645c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f547643a.hashCode() * 31) + this.f547644b.hashCode()) * 31) + this.f547645c.hashCode();
    }

    public final String toString() {
        return "RecordingSceneInstance(scene=" + this.f547643a + ", sceneInstanceId=" + this.f547644b + ", priorityContext=" + this.f547645c + ')';
    }

    public d(String r100, b r101) {
        Intrinsics.checkNotNullParameter(null, "scene");
        Intrinsics.checkNotNullParameter(r100, "sceneInstanceId");
        Intrinsics.checkNotNullParameter(r101, "priorityContext");
        this.f547643a = null;
        this.f547644b = r100;
        this.f547645c = r101;
    }
}
