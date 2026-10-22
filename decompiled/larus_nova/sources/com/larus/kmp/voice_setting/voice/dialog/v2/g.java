package com.larus.kmp.voice_setting.voice.dialog.v2;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements t1a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f353096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f353097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f353098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f353099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f353100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f353101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f353102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f353103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f353104i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f353105j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final UgcVoiceCreateVisualState f353106k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<Float> f353107l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final f0 f353108m;

    public g() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f353096a, r101.f353096a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f353097b, r101.f353097b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f353098c, r101.f353098c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f353099d, r101.f353099d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f353100e, r101.f353100e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f353101f, r101.f353101f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f353102g, r101.f353102g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f353103h, r101.f353103h) == true) goto L33;
        return false;
    L33:
        if (this.f353104i == r101.f353104i) goto L36;
        return false;
    L36:
        if (this.f353105j == r101.f353105j) goto L39;
        return false;
    L39:
        if (this.f353106k == r101.f353106k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f353107l, r101.f353107l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f353108m, r101.f353108m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((this.f353096a.hashCode() * 31) + this.f353097b.hashCode()) * 31) + this.f353098c.hashCode()) * 31) + this.f353099d.hashCode()) * 31) + this.f353100e.hashCode()) * 31) + this.f353101f.hashCode()) * 31) + this.f353102g.hashCode()) * 31) + this.f353103h.hashCode()) * 31;
        int r101 = 1231;
        if (this.f353104i == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f353105j == true) goto L11;
        r101 = 1237;
    L11:
        return ((((((r103 + r101) * 31) + this.f353106k.hashCode()) * 31) + this.f353107l.hashCode()) * 31) + this.f353108m.hashCode();
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "UgcVoiceCreateUiState(title=" + this.f353096a + ", exampleText=" + this.f353097b + ", holdToRecordText=" + this.f353098c + ", recordingHintText=" + this.f353099d + ", releaseToCancelText=" + this.f353100e + ", recordingTitle=" + this.f353101f + ", verifyingText=" + this.f353102g + ", failureText=" + this.f353103h + ", showRecordHint=" + this.f353104i + ", useBlurRecordStyle=" + this.f353105j + ", visualState=" + this.f353106k + ", audioLevels=" + this.f353107l + ", chatSpeakerState=" + this.f353108m + ')';
    }

    public /* synthetic */ g(int r210) {
        this("", "", "", "", "", "", "", "", true, false, UgcVoiceCreateVisualState.NORMAL, CollectionsKt.emptyList(), new f0(false, null, null, null, null, null, false, null, 16383));
    }

    public static g a(g r110, boolean r111, UgcVoiceCreateVisualState r210, List r211, f0 r212, int r213) {
        String r100 = null;
        if ((r213 & 1) == 0) goto L5;
        String r101 = r110.f353096a;
    L7:
        if ((r213 & 2) == 0) goto L9;
        String r102 = r110.f353097b;
    L11:
        if ((r213 & 4) == 0) goto L13;
        String r103 = r110.f353098c;
    L15:
        if ((r213 & 8) == 0) goto L17;
        String r104 = r110.f353099d;
    L19:
        if ((r213 & 16) == 0) goto L21;
        String r105 = r110.f353100e;
    L23:
        if ((r213 & 32) == 0) goto L25;
        String r112 = r110.f353101f;
    L27:
        if ((r213 & 64) == 0) goto L29;
        String r113 = r110.f353102g;
    L31:
        if ((r213 & 128) == 0) goto L33;
        r100 = r110.f353103h;
    L33:
        String r114 = r100;
        if ((r213 & 256) == 0) goto L36;
        boolean r115 = r110.f353104i;
    L38:
        if ((r213 & 512) == 0) goto L40;
        boolean r116 = r110.f353105j;
    L42:
        if ((r213 & 1024) == 0) goto L44;
        UgcVoiceCreateVisualState r117 = r110.f353106k;
    L46:
        if ((r213 & 2048) == 0) goto L48;
        List r106 = r110.f353107l;
    L50:
        if ((r213 & 4096) == 0) goto L52;
        f0 r107 = r110.f353108m;
    L53:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "exampleText");
        Intrinsics.checkNotNullParameter(r103, "holdToRecordText");
        Intrinsics.checkNotNullParameter(r104, "recordingHintText");
        Intrinsics.checkNotNullParameter(r105, "releaseToCancelText");
        Intrinsics.checkNotNullParameter(r112, "recordingTitle");
        Intrinsics.checkNotNullParameter(r113, "verifyingText");
        Intrinsics.checkNotNullParameter(r114, "failureText");
        Intrinsics.checkNotNullParameter(r117, "visualState");
        Intrinsics.checkNotNullParameter(r106, "audioLevels");
        Intrinsics.checkNotNullParameter(r107, "chatSpeakerState");
        return new g(r101, r102, r103, r104, r105, r112, r113, r114, r115, r116, r117, r106, r107);
    L52:
        r107 = r212;
        goto L53
    L48:
        r106 = r211;
        goto L50
    L44:
        r117 = r210;
        goto L46
    L40:
        r116 = false;
        goto L42
    L36:
        r115 = r111;
        goto L38
    L29:
        r113 = null;
        goto L31
    L25:
        r112 = null;
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
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public g(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, boolean r110, boolean r111, UgcVoiceCreateVisualState r112, List<Float> r113, f0 r114) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "exampleText");
        Intrinsics.checkNotNullParameter(r102, "holdToRecordText");
        Intrinsics.checkNotNullParameter(r103, "recordingHintText");
        Intrinsics.checkNotNullParameter(r104, "releaseToCancelText");
        Intrinsics.checkNotNullParameter(r105, "recordingTitle");
        Intrinsics.checkNotNullParameter(r106, "verifyingText");
        Intrinsics.checkNotNullParameter(r107, "failureText");
        Intrinsics.checkNotNullParameter(r112, "visualState");
        Intrinsics.checkNotNullParameter(r113, "audioLevels");
        Intrinsics.checkNotNullParameter(r114, "chatSpeakerState");
        this.f353096a = r100;
        this.f353097b = r101;
        this.f353098c = r102;
        this.f353099d = r103;
        this.f353100e = r104;
        this.f353101f = r105;
        this.f353102g = r106;
        this.f353103h = r107;
        this.f353104i = r110;
        this.f353105j = r111;
        this.f353106k = r112;
        this.f353107l = r113;
        this.f353108m = r114;
    }
}
