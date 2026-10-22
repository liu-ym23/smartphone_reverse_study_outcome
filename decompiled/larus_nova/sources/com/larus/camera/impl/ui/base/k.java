package com.larus.camera.impl.ui.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewGroupKt;
import com.larus.camera.impl.ui.arch.CameraContainer;
import com.larus.camera.impl.widget.title.TitleRightIconGroupView;
import com.larus.camera.impl.widget.title.TitleRightIconView;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class k extends com.larus.camera.impl.ui.arch.b {
    public k() {
        com.larus.camera.impl.ui.arch.c r100 = com.larus.camera.impl.ui.arch.c.f321810a;
        super(48, com.larus.camera.impl.ui.arch.c.f321812c);
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public CameraContainer.b f(int r100) {
        CameraContainer.b r101 = super.f(r100);
        ((FrameLayout.LayoutParams) r101).width = -1;
        ((FrameLayout.LayoutParams) r101).height = getContext().getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_44, getContext(), R.dimen.larus_camera_top_height));
        return r101;
    }

    public final void p(Function1<? super ImageView, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        r100.invoke(h(R.id.left_icon));
    }

    public final void q(Function1<? super TitleRightIconGroupView, ? extends List<ay8.e>> r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        TitleRightIconGroupView r101 = (TitleRightIconGroupView) h(R.id.right_icon_group);
        r101.setIconList(r100.invoke(r101));
    }

    public final void r(Function1<? super TitleRightIconView, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Iterator<View> r101 = ViewGroupKt.getChildren((TitleRightIconGroupView) h(R.id.right_icon_group)).iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        View r102 = r101.next();
        if ((r102 instanceof TitleRightIconView) == false) goto L8;
        TitleRightIconView r103 = (TitleRightIconView) r102;
    L9:
        if (r103 == null) goto L4;
        r100.invoke(r103);
        goto L4
    L8:
        r103 = null;
        goto L9
    }

    @Override // com.larus.camera.impl.ui.arch.b
    public final View g(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return r100.inflate(R.layout.larus_layout_view_title_component, r101, false);
    }
}
