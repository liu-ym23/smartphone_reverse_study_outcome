package eh9;

import com.larus.kmp.voice_setting.voice.component.VoiceListKind;
import com.larus.kmp.voice_setting.voice.list.VoiceListLoadTriggerKind;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VoiceListKind f472736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VoiceListLoadTriggerKind f472737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f472738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f472739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f472740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f472741f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f472742g;

    public l() {
        this(null, null, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f472736a == r101.f472736a) goto L12;
        return false;
    L12:
        if (this.f472737b == r101.f472737b) goto L15;
        return false;
    L15:
        if (this.f472738c == r101.f472738c) goto L18;
        return false;
    L18:
        if (this.f472739d == r101.f472739d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f472740e, r101.f472740e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f472741f, r101.f472741f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f472742g, r101.f472742g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f472736a.hashCode() * 31) + this.f472737b.hashCode()) * 31) + this.f472738c) * 31) + this.f472739d) * 31;
        String r101 = this.f472740e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f472741f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f472742g;
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
        return "VoiceListLoadRequestData(listKind=" + this.f472736a + ", trigger=" + this.f472737b + ", rowIndex=" + this.f472738c + ", screenIndex=" + this.f472739d + ", voiceId=" + this.f472740e + ", selectedVoiceId=" + this.f472741f + ", activeTabKey=" + this.f472742g + ')';
    }

    public l(VoiceListKind r100, VoiceListLoadTriggerKind r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = VoiceListKind.UNSPECIFIED;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r101 = VoiceListLoadTriggerKind.FIRST_PAGE;
    L8:
        int r104 = -1;
        if ((r103 & 4) == 0) goto L11;
        int r105 = -1;
    L13:
        if ((r103 & 8) != 0) goto L17;
        r104 = 0;
    L17:
        if ((r103 & 64) == 0) goto L19;
        r102 = null;
    L19:
        Intrinsics.checkNotNullParameter(r100, "listKind");
        Intrinsics.checkNotNullParameter(r101, "trigger");
        this.f472736a = r100;
        this.f472737b = r101;
        this.f472738c = r105;
        this.f472739d = r104;
        this.f472740e = null;
        this.f472741f = null;
        this.f472742g = r102;
        return;
    L11:
        r105 = 0;
        goto L13
    }
}
