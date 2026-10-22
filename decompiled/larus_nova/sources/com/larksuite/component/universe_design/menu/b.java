package com.larksuite.component.universe_design.menu;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f285070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f285071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f285072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PositionAlign f285073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f285074e;

    public b(View r100, View r101, int r102, PositionAlign r103, float r104) {
        Intrinsics.checkNotNullParameter(r100, "uiView");
        Intrinsics.checkNotNullParameter(r101, "anchorView");
        Intrinsics.checkNotNullParameter(r103, "anchorAlign");
        this.f285070a = r100;
        this.f285071b = r101;
        this.f285072c = r102;
        this.f285073d = r103;
        this.f285074e = r104;
    }
}
