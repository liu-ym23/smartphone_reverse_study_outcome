package com.larus.camera.impl.ui.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.nova.R;
import com.larus.utils.w0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class j extends com.larus.camera.impl.ui.arch.b {
    public j() {
        com.larus.camera.impl.ui.arch.c r100 = com.larus.camera.impl.ui.arch.c.f321810a;
        super(80, com.larus.camera.impl.ui.arch.c.f321812c);
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final CameraContainer.b f(int r100) {
        CameraContainer.b r101 = super.f(r100);
        ((FrameLayout.LayoutParams) r101).width = -1;
        ((FrameLayout.LayoutParams) r101).height = -1;
        return r101;
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return r100.inflate(R.layout.larus_layout_view_control_component, r101, false);
    }

    public final void p(int r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r101, "config");
        View r102 = h(R.id.left_icon);
        ImageView r103 = (ImageView) r102;
        w0.e(r103, r100);
        r103.setBackgroundColor(0);
        r101.invoke(r102);
    }

    public static void q(j r100, int r101, int r102) {
        Function1 r103 = new h();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "config");
        View r104 = r100.h(R.id.left_icon_container);
        FrameLayout r105 = (FrameLayout) r104;
        w0.e(r105, r101);
        r105.setBackgroundColor(r102);
        r103.invoke(r104);
    }
}
