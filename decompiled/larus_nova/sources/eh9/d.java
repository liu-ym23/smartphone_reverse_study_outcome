package eh9;

import com.larus.kmp.voice_setting.voice.list.VoiceRowAddState;
import com.larus.kmp.voice_setting.voice.list.VoiceRowPlayState;
import com.larus.kmp.voice_setting.voice.list.VoiceRowSelectionSnapshot;
import com.larus.kmp.voice_setting.voice.list.VoiceRowUploadState;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f472693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f472694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f472695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f472696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f472697e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f472698f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f472699g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f472700h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final VoiceRowUploadState f472701i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final VoiceRowSelectionSnapshot f472702j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final VoiceRowPlayState f472703k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final VoiceRowAddState f472704l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f472705m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f472706n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f472707o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f472708p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f472709q;

    public d() {
        this(null, null, 0, 0, 0, null, null, null, null, false, false, null, 131071);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f472693a, r101.f472693a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f472694b, r101.f472694b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f472695c, r101.f472695c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f472696d, r101.f472696d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f472697e, r101.f472697e) == true) goto L24;
        return false;
    L24:
        if (this.f472698f == r101.f472698f) goto L27;
        return false;
    L27:
        if (this.f472699g == r101.f472699g) goto L30;
        return false;
    L30:
        if (this.f472700h == r101.f472700h) goto L33;
        return false;
    L33:
        if (this.f472701i == r101.f472701i) goto L36;
        return false;
    L36:
        if (this.f472702j == r101.f472702j) goto L39;
        return false;
    L39:
        if (this.f472703k == r101.f472703k) goto L42;
        return false;
    L42:
        if (this.f472704l == r101.f472704l) goto L45;
        return false;
    L45:
        if (this.f472705m == r101.f472705m) goto L48;
        return false;
    L48:
        if (this.f472706n == r101.f472706n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f472707o, r101.f472707o) == true) goto L54;
        return false;
    L54:
        if (this.f472708p == r101.f472708p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f472709q, r101.f472709q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((((((((((this.f472693a.hashCode() * 31) + this.f472694b.hashCode()) * 31) + this.f472695c.hashCode()) * 31) + this.f472696d.hashCode()) * 31) + this.f472697e.hashCode()) * 31) + this.f472698f) * 31) + this.f472699g) * 31) + this.f472700h) * 31) + this.f472701i.hashCode()) * 31) + this.f472702j.hashCode()) * 31) + this.f472703k.hashCode()) * 31) + this.f472704l.hashCode()) * 31;
        int r101 = 1231;
        if (this.f472705m == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f472706n == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((r103 + r104) * 31) + this.f472707o.hashCode()) * 31;
        if (this.f472708p == true) goto L15;
        r101 = 1237;
    L15:
        return ((r105 + r101) * 31) + this.f472709q.hashCode();
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "PublicVoiceRowRenderInput(voiceName=" + this.f472693a + ", avatarUrl=" + this.f472694b + ", fallbackAvatarUrl=" + this.f472695c + ", creatorTagText=" + this.f472696d + ", tagLabels=" + this.f472697e + ", status=" + this.f472698f + ", nameStatus=" + this.f472699g + ", privateStatus=" + this.f472700h + ", uploadState=" + this.f472701i + ", selectionState=" + this.f472702j + ", playState=" + this.f472703k + ", addState=" + this.f472704l + ", isUgcVoice=" + this.f472705m + ", isOwnedByCurrentUser=" + this.f472706n + ", displayHeatScore=" + this.f472707o + ", bestMatch=" + this.f472708p + ", createdDateText=" + this.f472709q + ')';
    }

    public /* synthetic */ d(String r210, String r211, int r212, int r213, int r214, VoiceRowUploadState r215, VoiceRowSelectionSnapshot r216, VoiceRowPlayState r217, VoiceRowAddState r310, boolean r311, boolean r312, String r313, int r314) {
        String r100 = "";
        if ((r314 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r314 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r314 & 16) == 0) goto L21;
        List r105 = CollectionsKt.emptyList();
    L23:
        if ((r314 & 32) == 0) goto L25;
        int r106 = 1;
    L27:
        if ((r314 & 64) == 0) goto L29;
        int r110 = 1;
    L31:
        if ((r314 & 128) == 0) goto L33;
        int r111 = 0;
    L35:
        if ((r314 & 256) == 0) goto L37;
        VoiceRowUploadState r112 = VoiceRowUploadState.SUCCESS;
    L39:
        if ((r314 & 512) == 0) goto L41;
        VoiceRowSelectionSnapshot r113 = VoiceRowSelectionSnapshot.UNSELECTED;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        VoiceRowPlayState r114 = VoiceRowPlayState.STOPPED;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        VoiceRowAddState r115 = VoiceRowAddState.NONE;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        boolean r116 = false;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        boolean r117 = false;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        String r118 = "";
    L63:
        if ((r314 & 65536) != 0) goto L66;
        r100 = null;
    L66:
        this(r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, false, r100);
        return;
    L61:
        r118 = r313;
        goto L63
    L57:
        r117 = r312;
        goto L59
    L53:
        r116 = r311;
        goto L55
    L49:
        r115 = r310;
        goto L51
    L45:
        r114 = r217;
        goto L47
    L41:
        r113 = r216;
        goto L43
    L37:
        r112 = r215;
        goto L39
    L33:
        r111 = r214;
        goto L35
    L29:
        r110 = r213;
        goto L31
    L25:
        r106 = r212;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = r210;
        goto L7
    }

    public d(String r110, String r111, String r112, String r113, List<String> r114, int r115, int r210, int r211, VoiceRowUploadState r212, VoiceRowSelectionSnapshot r213, VoiceRowPlayState r214, VoiceRowAddState r215, boolean r216, boolean r217, String r218, boolean r219, String r310) {
        Intrinsics.checkNotNullParameter(r110, "voiceName");
        Intrinsics.checkNotNullParameter(r111, "avatarUrl");
        Intrinsics.checkNotNullParameter(r112, "fallbackAvatarUrl");
        Intrinsics.checkNotNullParameter(r113, "creatorTagText");
        Intrinsics.checkNotNullParameter(r114, "tagLabels");
        Intrinsics.checkNotNullParameter(r212, "uploadState");
        Intrinsics.checkNotNullParameter(r213, "selectionState");
        Intrinsics.checkNotNullParameter(r214, Keys.API_EVENT_KEY_PLAY_STATE);
        Intrinsics.checkNotNullParameter(r215, "addState");
        Intrinsics.checkNotNullParameter(r218, "displayHeatScore");
        Intrinsics.checkNotNullParameter(r310, "createdDateText");
        this.f472693a = r110;
        this.f472694b = r111;
        this.f472695c = r112;
        this.f472696d = r113;
        this.f472697e = r114;
        this.f472698f = r115;
        this.f472699g = r210;
        this.f472700h = r211;
        this.f472701i = r212;
        this.f472702j = r213;
        this.f472703k = r214;
        this.f472704l = r215;
        this.f472705m = r216;
        this.f472706n = r217;
        this.f472707o = r218;
        this.f472708p = r219;
        this.f472709q = r310;
    }
}
