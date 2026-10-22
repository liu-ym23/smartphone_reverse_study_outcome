package x48;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z48.a f562448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f562449b;

    public b() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f562448a, r101.f562448a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L15;
        return false;
    L15:
        if (this.f562449b == r101.f562449b) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        z48.a r100 = this.f562448a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((r101 * 31) + 0) * 31;
        if (this.f562449b == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChatSpeakerConfig(chatSpeakerUIConfig=" + this.f562448a + ", chatSpeakerStyleConfig=null, chatSpeakerAlterSendTextOrVoice=" + this.f562449b + ')';
    }

    public b(z48.a r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this.f562448a = r100;
        this.f562449b = false;
    }
}
