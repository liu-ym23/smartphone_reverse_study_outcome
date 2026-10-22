package com.larus.kmp.voice_setting.voice.component;

import com.larus.kmp.voice_setting.voice.mix.VoiceMixPlayVisualState;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class i5 implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w2a.f f352290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gh9.a f352291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VoiceEditMode f352292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e6 f352293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<d5> f352294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<d5> f352295f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final VoiceMixPlayVisualState f352296g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f352297h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e5 f352298i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.editvoice.b f352299j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.platform.q0 f352300k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f5 f352301l;

    public i5() {
        this(null, null, null, null, null, null, null, null, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i5) == true) goto L8;
        return false;
    L8:
        i5 r101 = (i5) r100;
        if (Intrinsics.areEqual(this.f352290a, r101.f352290a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f352291b, r101.f352291b) == true) goto L15;
        return false;
    L15:
        if (this.f352292c == r101.f352292c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f352293d, r101.f352293d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f352294e, r101.f352294e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f352295f, r101.f352295f) == true) goto L27;
        return false;
    L27:
        if (this.f352296g == r101.f352296g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f352297h, r101.f352297h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f352298i, r101.f352298i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f352299j, r101.f352299j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f352300k, r101.f352300k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f352301l, r101.f352301l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        w2a.f r100 = this.f352290a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        gh9.a r104 = this.f352291b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((((((((r103 + r105) * 31) + this.f352292c.hashCode()) * 31) + this.f352293d.hashCode()) * 31) + this.f352294e.hashCode()) * 31) + this.f352295f.hashCode()) * 31) + this.f352296g.hashCode()) * 31;
        String r107 = this.f352297h;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.f352298i.hashCode()) * 31;
        com.larus.kmp.voice_setting.voice.editvoice.b r110 = this.f352299j;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        com.larus.kmp.voice_setting.platform.q0 r113 = this.f352300k;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return ((r112 + r101) * 31) + this.f352301l.hashCode();
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceMixStateData(editInfo=" + this.f352290a + ", previewInfo=" + this.f352291b + ", mode=" + this.f352292c + ", selection=" + this.f352293d + ", mixItems=" + this.f352294e + ", pendingItems=" + this.f352295f + ", playState=" + this.f352296g + ", activePreviewVoiceId=" + this.f352297h + ", labels=" + this.f352298i + ", mixPreviewRequest=" + this.f352299j + ", previewPlaybackRequest=" + this.f352300k + ", lastAction=" + this.f352301l + ')';
    }

    public static i5 a(i5 r110, VoiceEditMode r111, e6 r112, List r210, VoiceMixPlayVisualState r211, String r212, e5 r213, int r214) {
        f5 r100 = null;
        if ((r214 & 1) == 0) goto L5;
        w2a.f r101 = r110.f352290a;
    L7:
        if ((r214 & 2) == 0) goto L9;
        gh9.a r102 = r110.f352291b;
    L11:
        if ((r214 & 4) == 0) goto L13;
        VoiceEditMode r103 = r110.f352292c;
    L15:
        if ((r214 & 8) == 0) goto L17;
        e6 r104 = r110.f352293d;
    L19:
        if ((r214 & 16) == 0) goto L21;
        List r105 = r110.f352294e;
    L23:
        if ((r214 & 32) == 0) goto L25;
        List<d5> r113 = r110.f352295f;
    L27:
        if ((r214 & 64) == 0) goto L29;
        VoiceMixPlayVisualState r114 = r110.f352296g;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r115 = r110.f352297h;
    L35:
        if ((r214 & 256) == 0) goto L37;
        e5 r116 = r110.f352298i;
    L39:
        if ((r214 & 512) == 0) goto L41;
        com.larus.kmp.voice_setting.voice.editvoice.b r117 = r110.f352299j;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        com.larus.kmp.voice_setting.platform.q0 r118 = r110.f352300k;
    L47:
        if ((r214 & 2048) == 0) goto L49;
        r100 = r110.f352301l;
    L49:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r103, "mode");
        Intrinsics.checkNotNullParameter(r104, "selection");
        Intrinsics.checkNotNullParameter(r105, "mixItems");
        Intrinsics.checkNotNullParameter(r113, "pendingItems");
        Intrinsics.checkNotNullParameter(r114, Keys.API_EVENT_KEY_PLAY_STATE);
        Intrinsics.checkNotNullParameter(r116, "labels");
        Intrinsics.checkNotNullParameter(r100, "lastAction");
        return new i5(r101, r102, r103, r104, r105, r113, r114, r115, r116, r117, r118, r100);
    L45:
        r118 = null;
        goto L47
    L41:
        r117 = null;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r115 = r212;
        goto L35
    L29:
        r114 = r211;
        goto L31
    L25:
        r113 = null;
        goto L27
    L21:
        r105 = r210;
        goto L23
    L17:
        r104 = r112;
        goto L19
    L13:
        r103 = r111;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public /* synthetic */ i5(VoiceEditMode r110, e6 r111, List r112, VoiceMixPlayVisualState r113, String r210, e5 r211, com.larus.kmp.voice_setting.voice.editvoice.b r212, com.larus.kmp.voice_setting.platform.q0 r213, int r214) {
        if ((r214 & 4) == 0) goto L5;
        VoiceEditMode r100 = VoiceEditMode.NONE;
    L7:
        if ((r214 & 8) == 0) goto L9;
        e6 r101 = new e6(null, 31);
    L11:
        if ((r214 & 16) == 0) goto L13;
        List r102 = CollectionsKt.emptyList();
    L15:
        if ((r214 & 32) == 0) goto L17;
        List r103 = CollectionsKt.emptyList();
    L19:
        if ((r214 & 64) == 0) goto L21;
        VoiceMixPlayVisualState r104 = VoiceMixPlayVisualState.Idle;
    L23:
        if ((r214 & 128) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r214 & 256) == 0) goto L29;
        e5 r114 = new e5(0);
    L31:
        if ((r214 & 512) == 0) goto L33;
        com.larus.kmp.voice_setting.voice.editvoice.b r115 = null;
    L35:
        if ((r214 & 1024) == 0) goto L37;
        com.larus.kmp.voice_setting.platform.q0 r116 = null;
    L39:
        if ((r214 & 2048) == 0) goto L41;
        f5 r117 = new f5(0);
    L42:
        this(null, null, r100, r101, r102, r103, r104, r105, r114, r115, r116, r117);
        return;
    L41:
        r117 = null;
        goto L42
    L37:
        r116 = r213;
        goto L39
    L33:
        r115 = r212;
        goto L35
    L29:
        r114 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r113;
        goto L23
    L17:
        r103 = null;
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

    public i5(w2a.f r100, gh9.a r101, VoiceEditMode r102, e6 r103, List<d5> r104, List<d5> r105, VoiceMixPlayVisualState r106, String r107, e5 r110, com.larus.kmp.voice_setting.voice.editvoice.b r111, com.larus.kmp.voice_setting.platform.q0 r112, f5 r113) {
        Intrinsics.checkNotNullParameter(r102, "mode");
        Intrinsics.checkNotNullParameter(r103, "selection");
        Intrinsics.checkNotNullParameter(r104, "mixItems");
        Intrinsics.checkNotNullParameter(r105, "pendingItems");
        Intrinsics.checkNotNullParameter(r106, Keys.API_EVENT_KEY_PLAY_STATE);
        Intrinsics.checkNotNullParameter(r110, "labels");
        Intrinsics.checkNotNullParameter(r113, "lastAction");
        this.f352290a = r100;
        this.f352291b = r101;
        this.f352292c = r102;
        this.f352293d = r103;
        this.f352294e = r104;
        this.f352295f = r105;
        this.f352296g = r106;
        this.f352297h = r107;
        this.f352298i = r110;
        this.f352299j = r111;
        this.f352300k = r112;
        this.f352301l = r113;
    }
}
