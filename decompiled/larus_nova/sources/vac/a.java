package vac;

import com.ss.android.lark.voiceinput.api.data.config.asr.resultConfig.VoiceAsrMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VoiceAsrMode f553989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f553990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f553991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f553992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f553993e;

    public a() {
        this(null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f553989a == r101.f553989a) goto L12;
        return false;
    L12:
        if (this.f553990b == r101.f553990b) goto L15;
        return false;
    L15:
        if (this.f553991c == r101.f553991c) goto L18;
        return false;
    L18:
        if (this.f553992d == r101.f553992d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f553993e, r101.f553993e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f553989a.hashCode() * 31;
        int r101 = 1231;
        if (this.f553990b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f553991c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f553992d == true) goto L14;
        r101 = 1237;
    L14:
        int r106 = (r105 + r101) * 31;
        Long r107 = this.f553993e;
        if (r107 != null) goto L17;
        int r108 = 0;
    L19:
        return r106 + r108;
    L17:
        r108 = r107.hashCode();
        goto L19
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "VoiceAsrResultConfig(mode=" + this.f553989a + ", enablePunctuation=" + this.f553990b + ", enableTextFormatting=" + this.f553991c + ", enableNer=" + this.f553992d + ", completionTimeoutMs=" + this.f553993e + ')';
    }

    public a(VoiceAsrMode r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = VoiceAsrMode.Streaming;
    L6:
        if ((r101 & 2) == 0) goto L8;
        boolean r102 = true;
    L9:
        Intrinsics.checkNotNullParameter(r100, "mode");
        this.f553989a = r100;
        this.f553990b = r102;
        this.f553991c = false;
        this.f553992d = false;
        this.f553993e = null;
        return;
    L8:
        r102 = false;
        goto L9
    }
}
