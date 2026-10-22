package com.larus.kmp.voice_setting.voice.screen.doubletab;

import androidx.compose.material3.TopAppBarScrollBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class x3 implements e4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y3 f354780a;

    @Override // com.larus.kmp.voice_setting.voice.screen.doubletab.e4
    public final y3 getState() {
        return this.f354780a;
    }

    public x3(TopAppBarScrollBehavior r100) {
        Intrinsics.checkNotNullParameter(r100, "behavior");
        this.f354780a = new y3(r100);
    }
}
