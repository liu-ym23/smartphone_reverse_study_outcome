package zac;

import com.ss.android.lark.voiceinput.api.data.model.asr.VoiceAsrState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VoiceAsrState f571115b;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f571114a, r101.f571114a) == true) goto L12;
        return false;
    L12:
        if (this.f571115b == r101.f571115b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f571114a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f571115b.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "VoiceAsrStatus(taskId=" + this.f571114a + ", state=" + this.f571115b + ')';
    }

    public /* synthetic */ b(int r100) {
        this(null, VoiceAsrState.Idle);
    }

    public b(String r100, VoiceAsrState r101) {
        Intrinsics.checkNotNullParameter(r101, "state");
        this.f571114a = r100;
        this.f571115b = r101;
    }
}
