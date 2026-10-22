package com.ss.android.ugc.aweme.search.common.view;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes40.dex */
public class RoundCornerViewOutlineProvider extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f452380a;

    public RoundCornerViewOutlineProvider(int r100) {
        this.f452380a = r100;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r101) {
        r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), this.f452380a);
    }
}
