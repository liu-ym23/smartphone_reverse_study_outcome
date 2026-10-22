package com.larus.bmhome.floatchat.component;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class w extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f311750a;

    public w(View r100) {
        this.f311750a = r100;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r100, Outline r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r110, "outline");
        float r101 = this.f311750a.getContext().getResources().getDimension(v19.c.b(R.attr.larus_dp_24, this.f311750a.getContext(), R.dimen.larus_dp_24));
        r110.setRoundRect(0, 0, r100.getWidth(), r100.getHeight() + ((int) r101), r101);
    }
}
