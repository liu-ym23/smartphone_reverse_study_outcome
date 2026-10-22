package com.larus.kmp.voice_setting.voice.screen.doubletab;

import androidx.compose.material3.TopAppBarScrollBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class y3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TopAppBarScrollBehavior f354790a;

    public final float a() {
        return this.f354790a.getState().getCollapsedFraction();
    }

    public final float b() {
        return this.f354790a.getState().getHeightOffset();
    }

    public final float c() {
        return this.f354790a.getState().getHeightOffsetLimit();
    }

    public y3(TopAppBarScrollBehavior r100) {
        Intrinsics.checkNotNullParameter(r100, "behavior");
        this.f354790a = r100;
    }

    public final void d(float r100) {
        this.f354790a.getState().setHeightOffset(r100);
    }

    public final void e(float r100) {
        this.f354790a.getState().setHeightOffsetLimit(r100);
    }
}
