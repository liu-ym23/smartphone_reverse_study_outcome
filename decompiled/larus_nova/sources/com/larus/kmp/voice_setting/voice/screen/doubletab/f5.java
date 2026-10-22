package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.larus.kmp.voice_setting.voice.component.VoiceListKind;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f354311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f354312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VoiceListKind f354313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larus.kmp.voice_setting.voice.base.api.i f354314d;

    public /* synthetic */ f5() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f5) == true) goto L8;
        return false;
    L8:
        f5 r101 = (f5) r100;
        if (Intrinsics.areEqual(this.f354311a, r101.f354311a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f354312b, r101.f354312b) == true) goto L15;
        return false;
    L15:
        if (this.f354313c == r101.f354313c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f354314d, r101.f354314d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f354311a.hashCode() * 31) + this.f354312b.hashCode()) * 31) + this.f354313c.hashCode()) * 31;
        com.larus.kmp.voice_setting.voice.base.api.i r101 = this.f354314d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "VoiceDoubleTabPageSpec(tabKey=" + this.f354311a + ", title=" + this.f354312b + ", listKind=" + this.f354313c + ", multiTabInfo=" + this.f354314d + ')';
    }

    public f5(String r100, String r101, VoiceListKind r102, com.larus.kmp.voice_setting.voice.base.api.i r103) {
        Intrinsics.checkNotNullParameter(r100, "tabKey");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "listKind");
        this.f354311a = r100;
        this.f354312b = r101;
        this.f354313c = r102;
        this.f354314d = r103;
    }
}
