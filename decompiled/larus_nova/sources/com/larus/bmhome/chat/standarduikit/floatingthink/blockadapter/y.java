package com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class y extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f309158a;

    public y(int r100) {
        this.f309158a = r100;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "outline");
        int r102 = r100.getWidth();
        int r103 = r100.getHeight();
        int r104 = this.f309158a;
        r101.setRoundRect(0, 0, r102, r103 + r104, r104);
    }
}
