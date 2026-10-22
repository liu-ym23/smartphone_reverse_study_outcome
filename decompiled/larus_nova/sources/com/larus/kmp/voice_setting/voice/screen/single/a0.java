package com.larus.kmp.voice_setting.voice.screen.single;

import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f354867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f354868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SingleTtsSpeakerRowGroup f354869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b0 f354870d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.f354867a, r101.f354867a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f354868b, r101.f354868b) == true) goto L15;
        return false;
    L15:
        if (this.f354869c == r101.f354869c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f354870d, r101.f354870d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f354867a.hashCode() * 31) + this.f354868b.hashCode()) * 31) + this.f354869c.hashCode()) * 31) + this.f354870d.hashCode();
    }

    public final String toString() {
        return "SingleTtsSpeakerRowUiState(key=" + this.f354867a + ", voiceId=" + this.f354868b + ", group=" + this.f354869c + ", visual=" + this.f354870d + ')';
    }

    public a0(String r100, String r101, SingleTtsSpeakerRowGroup r102, b0 r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "voiceId");
        Intrinsics.checkNotNullParameter(r102, "group");
        Intrinsics.checkNotNullParameter(r103, AiProactiveTaskViewModel.TASK_TYPE_VISUAL);
        this.f354867a = r100;
        this.f354868b = r101;
        this.f354869c = r102;
        this.f354870d = r103;
    }
}
