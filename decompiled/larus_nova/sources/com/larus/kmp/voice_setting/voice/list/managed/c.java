package com.larus.kmp.voice_setting.voice.list.managed;

import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f353471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f353472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f353473c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f353471a, r101.f353471a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f353472b, r101.f353472b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f353473c, r101.f353473c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f353471a.hashCode() * 31) + this.f353472b.hashCode()) * 31) + this.f353473c.hashCode();
    }

    public final String toString() {
        return "ManagedVoiceListRowUiState(key=" + this.f353471a + ", voiceId=" + this.f353472b + ", visual=" + this.f353473c + ')';
    }

    public c(String r100, String r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "voiceId");
        Intrinsics.checkNotNullParameter(r102, AiProactiveTaskViewModel.TASK_TYPE_VISUAL);
        this.f353471a = r100;
        this.f353472b = r101;
        this.f353473c = r102;
    }
}
