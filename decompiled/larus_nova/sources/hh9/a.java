package hh9;

import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SpeakerVoice f485236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f485237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f485238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f485239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f485240e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f485241f;

    public a() {
        this(null, 0, 0, 0, 0, 0, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f485236a, r101.f485236a) == true) goto L12;
        return false;
    L12:
        if (this.f485237b == r101.f485237b) goto L15;
        return false;
    L15:
        if (this.f485238c == r101.f485238c) goto L18;
        return false;
    L18:
        if (this.f485239d == r101.f485239d) goto L21;
        return false;
    L21:
        if (this.f485240e == r101.f485240e) goto L24;
        return false;
    L24:
        if (this.f485241f == r101.f485241f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        SpeakerVoice r100 = this.f485236a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((((((((r101 * 31) + this.f485237b) * 31) + this.f485238c) * 31) + this.f485239d) * 31) + this.f485240e) * 31) + this.f485241f;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "VoiceItem(voice=" + this.f485236a + ", selectedState=" + this.f485237b + ", uploadState=" + this.f485238c + ", playState=" + this.f485239d + ", addState=" + this.f485240e + ", itemType=" + this.f485241f + ')';
    }

    public a(SpeakerVoice r100, int r101, int r102, int r103, int r104, int r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r101 = 10;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r102 = 1;
    L12:
        if ((r106 & 8) == 0) goto L15;
        r103 = 2;
    L15:
        if ((r106 & 16) == 0) goto L18;
        r104 = 60;
    L18:
        if ((r106 & 32) == 0) goto L20;
        r105 = 0;
    L20:
        this.f485236a = r100;
        this.f485237b = r101;
        this.f485238c = r102;
        this.f485239d = r103;
        this.f485240e = r104;
        this.f485241f = r105;
    }
}
