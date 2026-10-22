package z48;

import com.larus.asr.config.ChatSpeakerStatus;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f570036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ChatSpeakerStatus f570037b;

    public b() {
        this(false, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f570036a == r101.f570036a) goto L12;
        return false;
    L12:
        if (this.f570037b == r101.f570037b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f570036a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        ChatSpeakerStatus r102 = this.f570037b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatSpeakerUIContext(isDarkMode=" + this.f570036a + ", currentStatus=" + this.f570037b + ')';
    }

    public b(boolean r100, ChatSpeakerStatus r101) {
        this.f570036a = r100;
        this.f570037b = r101;
    }
}
