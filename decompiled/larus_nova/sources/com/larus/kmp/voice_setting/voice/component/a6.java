package com.larus.kmp.voice_setting.voice.component;

import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a6 implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VoiceRootHostActionKind f352148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f352149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b6 f352150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f352151d;

    public a6() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a6) == true) goto L8;
        return false;
    L8:
        a6 r101 = (a6) r100;
        if (this.f352148a == r101.f352148a) goto L12;
        return false;
    L12:
        if (this.f352149b == r101.f352149b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f352150c, r101.f352150c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(null, null) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f352151d, r101.f352151d) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f352148a.hashCode() * 31;
        long r101 = this.f352149b;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f352150c.hashCode()) * 31;
        int r103 = 0;
        int r104 = (r102 + 0) * 31;
        String r105 = this.f352151d;
        if (r105 == null) goto L7;
        r103 = r105.hashCode();
    L7:
        return r104 + r103;
    }

    public final String toString() {
        return "VoiceRootHostActionData(kind=" + this.f352148a + ", token=" + this.f352149b + ", route=" + this.f352150c + ", result=null, source=" + this.f352151d + ')';
    }

    public /* synthetic */ a6(int r110) {
        this(VoiceRootHostActionKind.NONE, 0, new b6(null, null, null, null, null, 63), null);
    }

    public a6(VoiceRootHostActionKind r100, long r101, b6 r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "kind");
        Intrinsics.checkNotNullParameter(r102, CloudControlInf.ROUTE);
        this.f352148a = r100;
        this.f352149b = r101;
        this.f352150c = r102;
        this.f352151d = r103;
    }
}
