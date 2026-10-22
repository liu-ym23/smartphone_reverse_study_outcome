package com.larus.kmp.voice_setting.voice.screen.single;

import com.larus.kmp.voice_setting.voice.component.o4;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c0 implements t1a.f, m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f354875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f354876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a0> f354877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f354878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f354879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f354880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f354881g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f354882h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final o4 f354883i;

    public c0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.f354875a, r101.f354875a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f354876b, r101.f354876b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f354877c, r101.f354877c) == true) goto L18;
        return false;
    L18:
        if (this.f354878d == r101.f354878d) goto L21;
        return false;
    L21:
        if (this.f354879e == r101.f354879e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f354880f, r101.f354880f) == true) goto L27;
        return false;
    L27:
        if (this.f354881g == r101.f354881g) goto L30;
        return false;
    L30:
        if (this.f354882h == r101.f354882h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f354883i, r101.f354883i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f354875a.hashCode() * 31) + this.f354876b.hashCode()) * 31) + this.f354877c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f354878d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f354879e == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((r103 + r104) * 31) + this.f354880f.hashCode()) * 31;
        if (this.f354881g == true) goto L15;
        r101 = 1237;
    L15:
        return ((((r105 + r101) * 31) + this.f354882h) * 31) + this.f354883i.hashCode();
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "SingleTtsSpeakerSettingScreenUiState(title=" + this.f354875a + ", createVoiceText=" + this.f354876b + ", rows=" + this.f354877c + ", showCreateVoiceButton=" + this.f354878d + ", showCreateBotButton=" + this.f354879e + ", createBotButtonText=" + this.f354880f + ", createBotButtonEnabled=" + this.f354881g + ", scrollToTopRequestKey=" + this.f354882h + ", dropdownMenuState=" + this.f354883i + ')';
    }

    public /* synthetic */ c0(int r110) {
        this("", "", CollectionsKt.emptyList(), false, false, "", false, 0, new o4(0));
    }

    public static c0 a(c0 r110, String r111, String r112, List r113, boolean r114, String r115, o4 r116, int r210) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.f354875a;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.f354876b;
    L11:
        if ((r210 & 4) == 0) goto L13;
        List r102 = r110.f354877c;
    L15:
        if ((r210 & 8) == 0) goto L17;
        boolean r103 = r110.f354878d;
    L19:
        if ((r210 & 16) == 0) goto L21;
        boolean r104 = r110.f354879e;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.f354880f;
    L27:
        if ((r210 & 64) == 0) goto L29;
        boolean r117 = r110.f354881g;
    L31:
        if ((r210 & 128) == 0) goto L33;
        int r118 = r110.f354882h;
    L35:
        if ((r210 & 256) == 0) goto L37;
        o4 r119 = r110.f354883i;
    L38:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "createVoiceText");
        Intrinsics.checkNotNullParameter(r102, "rows");
        Intrinsics.checkNotNullParameter(r105, "createBotButtonText");
        Intrinsics.checkNotNullParameter(r119, "dropdownMenuState");
        return new c0(r100, r101, r102, r103, r104, r105, r117, r118, r119);
    L37:
        r119 = r116;
        goto L38
    L33:
        r118 = 0;
        goto L35
    L29:
        r117 = false;
        goto L31
    L25:
        r105 = r115;
        goto L27
    L21:
        r104 = false;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public c0(String r100, String r101, List<a0> r102, boolean r103, boolean r104, String r105, boolean r106, int r107, o4 r110) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "createVoiceText");
        Intrinsics.checkNotNullParameter(r102, "rows");
        Intrinsics.checkNotNullParameter(r105, "createBotButtonText");
        Intrinsics.checkNotNullParameter(r110, "dropdownMenuState");
        this.f354875a = r100;
        this.f354876b = r101;
        this.f354877c = r102;
        this.f354878d = r103;
        this.f354879e = r104;
        this.f354880f = r105;
        this.f354881g = r106;
        this.f354882h = r107;
        this.f354883i = r110;
    }
}
