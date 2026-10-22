package p2a;

import com.larus.voice_setting.VoiceSettingRuntimeKind;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f527498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VoiceSettingRuntimeKind f527499b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.f527498a, r101.f527498a) == true) goto L12;
        return false;
    L12:
        if (this.f527499b == r101.f527499b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f527498a.hashCode() * 31) + this.f527499b.hashCode();
    }

    public final String toString() {
        return "VoiceSettingRuntimeSelection(service=" + this.f527498a + ", kind=" + this.f527499b + ')';
    }

    public x(h r100, VoiceSettingRuntimeKind r101) {
        Intrinsics.checkNotNullParameter(r100, "service");
        Intrinsics.checkNotNullParameter(r101, "kind");
        this.f527498a = r100;
        this.f527499b = r101;
    }
}
