package com.larus.kmp.voice_setting.voice.base.multitab;

import com.hihonor.honorid.core.data.UserInfo;
import com.larus.kmp.voice_setting.voice.base.api.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f351796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f351797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f351798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f351799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f351800f;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f351795a, r101.f351795a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f351796b, r101.f351796b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f351797c, r101.f351797c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f351798d, r101.f351798d) == true) goto L21;
        return false;
    L21:
        if (this.f351799e == r101.f351799e) goto L24;
        return false;
    L24:
        if (this.f351800f == r101.f351800f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f351795a.hashCode() * 31) + this.f351796b.hashCode()) * 31) + this.f351797c.hashCode()) * 31;
        i r101 = this.f351798d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((r100 + r102) * 31) + this.f351799e) * 31) + this.f351800f;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MultiTabVoiceLoadContext(botId=" + this.f351795a + ", languageCode=" + this.f351796b + ", ownerTabKey=" + this.f351797c + ", tab=" + this.f351798d + ", currentIndex=" + this.f351799e + ", pageSize=" + this.f351800f + ')';
    }

    public /* synthetic */ b(int r100) {
        this("", "", "", null, 1, 20);
    }

    public b(String r100, String r101, String r102, i r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        Intrinsics.checkNotNullParameter(r101, UserInfo.LANGUAGECODE);
        Intrinsics.checkNotNullParameter(r102, "ownerTabKey");
        this.f351795a = r100;
        this.f351796b = r101;
        this.f351797c = r102;
        this.f351798d = r103;
        this.f351799e = r104;
        this.f351800f = r105;
    }

    public static b a(b r100, String r101, String r102, String r110, i r111, int r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        r101 = r100.f351795a;
    L5:
        String r103 = r101;
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.f351796b;
    L8:
        String r104 = r102;
        if ((r113 & 4) == 0) goto L11;
        r110 = r100.f351797c;
    L11:
        String r105 = r110;
        if ((r113 & 8) == 0) goto L14;
        r111 = r100.f351798d;
    L14:
        i r106 = r111;
        if ((r113 & 16) == 0) goto L17;
        r112 = r100.f351799e;
    L17:
        int r107 = r112;
        if ((r113 & 32) == 0) goto L20;
        int r108 = r100.f351800f;
    L21:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "botId");
        Intrinsics.checkNotNullParameter(r104, UserInfo.LANGUAGECODE);
        Intrinsics.checkNotNullParameter(r105, "ownerTabKey");
        return new b(r103, r104, r105, r106, r107, r108);
    L20:
        r108 = 0;
        goto L21
    }
}
