package ub8;

import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f549384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SpeakerVoice f549385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f549386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f549387d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f549384a == r101.f549384a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f549385b, r101.f549385b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f549386c, r101.f549386c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f549387d, r101.f549387d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f549384a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        SpeakerVoice r102 = this.f549385b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        Long r106 = this.f549386c;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f549387d;
        if (r109 == null) goto L19;
        r103 = r109.hashCode();
    L19:
        return r108 + r103;
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoiceUpdateResult(success=" + this.f549384a + ", speakerVoice=" + this.f549385b + ", errCode=" + this.f549386c + ", errorMsg=" + this.f549387d + ')';
    }

    public h(boolean r100, SpeakerVoice r101, Long r102, String r103) {
        this.f549384a = r100;
        this.f549385b = r101;
        this.f549386c = r102;
        this.f549387d = r103;
    }
}
