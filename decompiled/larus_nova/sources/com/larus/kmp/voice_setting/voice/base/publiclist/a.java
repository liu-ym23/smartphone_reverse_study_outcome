package com.larus.kmp.voice_setting.voice.base.publiclist;

import com.hihonor.honorid.core.data.UserInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f351823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f351824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f351825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f351826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f351827e;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f351823a == r101.f351823a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f351824b, r101.f351824b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f351825c, r101.f351825c) == true) goto L18;
        return false;
    L18:
        if (this.f351826d == r101.f351826d) goto L21;
        return false;
    L21:
        if (this.f351827e == r101.f351827e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.f351823a == false) goto L5;
        int r100 = 1231;
    L7:
        return (((((((r100 * 31) + this.f351824b.hashCode()) * 31) + this.f351825c.hashCode()) * 31) + this.f351826d) * 31) + this.f351827e;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "PublicVoiceListLoadContext(isFromTts=" + this.f351823a + ", userId=" + this.f351824b + ", languageCode=" + this.f351825c + ", currentIndex=" + this.f351826d + ", pageSize=" + this.f351827e + ')';
    }

    public /* synthetic */ a(int r100) {
        this(false, "", "", 1, 20);
    }

    public a(boolean r100, String r101, String r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter(r102, UserInfo.LANGUAGECODE);
        this.f351823a = r100;
        this.f351824b = r101;
        this.f351825c = r102;
        this.f351826d = r103;
        this.f351827e = r104;
    }

    public static a a(a r100, boolean r101, String r102, String r103, int r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        r101 = r100.f351823a;
    L5:
        boolean r104 = r101;
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.f351824b;
    L8:
        String r105 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.f351825c;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r110 = r100.f351826d;
    L14:
        int r107 = r110;
        if ((r111 & 16) == 0) goto L17;
        int r108 = r100.f351827e;
    L18:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r105, "userId");
        Intrinsics.checkNotNullParameter(r106, UserInfo.LANGUAGECODE);
        return new a(r104, r105, r106, r107, r108);
    L17:
        r108 = 0;
        goto L18
    }
}
