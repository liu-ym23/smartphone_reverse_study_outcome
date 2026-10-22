package com.larus.kmp.voice_setting.voice.bridge;

import com.larus.im.bean.bot.SpeakerVoice;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f351917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f351918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f351919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final VoiceSingleScreenSelectionMode f351920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f351921f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f351922g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final eh9.p f351923h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f351924i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<SpeakerVoice> f351925j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<SpeakerVoice> f351926k;

    public z() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.f351916a, r101.f351916a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f351917b, r101.f351917b) == true) goto L15;
        return false;
    L15:
        if (this.f351918c == r101.f351918c) goto L18;
        return false;
    L18:
        if (this.f351919d == r101.f351919d) goto L21;
        return false;
    L21:
        if (this.f351920e == r101.f351920e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f351921f, r101.f351921f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f351922g, r101.f351922g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f351923h, r101.f351923h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f351924i, r101.f351924i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f351925j, r101.f351925j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f351926k, r101.f351926k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f351916a.hashCode() * 31) + this.f351917b.hashCode()) * 31;
        int r101 = 1231;
        if (this.f351918c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f351919d == true) goto L11;
        r101 = 1237;
    L11:
        return ((((((((((((((r103 + r101) * 31) + this.f351920e.hashCode()) * 31) + this.f351921f.hashCode()) * 31) + this.f351922g.hashCode()) * 31) + this.f351923h.hashCode()) * 31) + this.f351924i.hashCode()) * 31) + this.f351925j.hashCode()) * 31) + this.f351926k.hashCode();
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoiceSingleScreenExternalState(title=" + this.f351916a + ", createVoiceText=" + this.f351917b + ", showCreateVoiceButton=" + this.f351918c + ", shouldOpenCreateVoiceOnStart=" + this.f351919d + ", selectionMode=" + this.f351920e + ", muteVoiceId=" + this.f351921f + ", currentUserId=" + this.f351922g + ", texts=" + this.f351923h + ", privatePermissionText=" + this.f351924i + ", systemVoices=" + this.f351925j + ", ugcVoices=" + this.f351926k + ')';
    }

    public /* synthetic */ z(int r110) {
        this("", "", false, false, VoiceSingleScreenSelectionMode.UPDATE_BOT, "", "", new eh9.p(0), "", CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public z(String r100, String r101, boolean r102, boolean r103, VoiceSingleScreenSelectionMode r104, String r105, String r106, eh9.p r107, String r110, List<SpeakerVoice> r111, List<SpeakerVoice> r112) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "createVoiceText");
        Intrinsics.checkNotNullParameter(r104, "selectionMode");
        Intrinsics.checkNotNullParameter(r105, "muteVoiceId");
        Intrinsics.checkNotNullParameter(r106, "currentUserId");
        Intrinsics.checkNotNullParameter(r107, "texts");
        Intrinsics.checkNotNullParameter(r110, "privatePermissionText");
        Intrinsics.checkNotNullParameter(r111, "systemVoices");
        Intrinsics.checkNotNullParameter(r112, "ugcVoices");
        this.f351916a = r100;
        this.f351917b = r101;
        this.f351918c = r102;
        this.f351919d = r103;
        this.f351920e = r104;
        this.f351921f = r105;
        this.f351922g = r106;
        this.f351923h = r107;
        this.f351924i = r110;
        this.f351925j = r111;
        this.f351926k = r112;
    }
}
