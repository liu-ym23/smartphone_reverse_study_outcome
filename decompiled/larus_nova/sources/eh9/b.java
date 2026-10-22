package eh9;

import com.larus.kmp.voice_setting.voice.list.VoiceRowSelectionSnapshot;
import com.larus.kmp.voice_setting.voice.list.VoiceRowUploadState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f472673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f472674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f472675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f472676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f472677e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f472678f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final VoiceRowUploadState f472679g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final VoiceRowSelectionSnapshot f472680h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f472681i;

    public b() {
        this(null, null, null, 0, 0, null, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f472673a, r101.f472673a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f472674b, r101.f472674b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f472675c, r101.f472675c) == true) goto L18;
        return false;
    L18:
        if (this.f472676d == r101.f472676d) goto L21;
        return false;
    L21:
        if (this.f472677e == r101.f472677e) goto L24;
        return false;
    L24:
        if (this.f472678f == r101.f472678f) goto L27;
        return false;
    L27:
        if (this.f472679g == r101.f472679g) goto L30;
        return false;
    L30:
        if (this.f472680h == r101.f472680h) goto L33;
        return false;
    L33:
        if (this.f472681i == r101.f472681i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f472673a.hashCode() * 31) + this.f472674b.hashCode()) * 31) + this.f472675c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f472676d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((((((r100 + r102) * 31) + this.f472677e) * 31) + this.f472678f) * 31) + this.f472679g.hashCode()) * 31) + this.f472680h.hashCode()) * 31;
        if (this.f472681i == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "NormalVoiceRowRenderInput(voiceName=" + this.f472673a + ", creatorUserName=" + this.f472674b + ", avatarUrl=" + this.f472675c + ", isUgcVoice=" + this.f472676d + ", status=" + this.f472677e + ", nameStatus=" + this.f472678f + ", uploadState=" + this.f472679g + ", selectionState=" + this.f472680h + ", isOwnedByCurrentUser=" + this.f472681i + ')';
    }

    public /* synthetic */ b(String r110, String r111, String r112, int r113, int r114, VoiceRowUploadState r115, VoiceRowSelectionSnapshot r210, int r211) {
        if ((r211 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r211 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r211 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r211 & 16) == 0) goto L17;
        int r103 = 1;
    L19:
        if ((r211 & 32) == 0) goto L21;
        int r104 = 1;
    L23:
        if ((r211 & 64) == 0) goto L25;
        VoiceRowUploadState r116 = VoiceRowUploadState.SUCCESS;
    L27:
        if ((r211 & 128) == 0) goto L29;
        VoiceRowSelectionSnapshot r117 = VoiceRowSelectionSnapshot.UNSELECTED;
    L30:
        this(r100, r101, r102, false, r103, r104, r116, r117, false);
        return;
    L29:
        r117 = r210;
        goto L30
    L25:
        r116 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public b(String r100, String r101, String r102, boolean r103, int r104, int r105, VoiceRowUploadState r106, VoiceRowSelectionSnapshot r107, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "voiceName");
        Intrinsics.checkNotNullParameter(r101, "creatorUserName");
        Intrinsics.checkNotNullParameter(r102, "avatarUrl");
        Intrinsics.checkNotNullParameter(r106, "uploadState");
        Intrinsics.checkNotNullParameter(r107, "selectionState");
        this.f472673a = r100;
        this.f472674b = r101;
        this.f472675c = r102;
        this.f472676d = r103;
        this.f472677e = r104;
        this.f472678f = r105;
        this.f472679g = r106;
        this.f472680h = r107;
        this.f472681i = r110;
    }
}
