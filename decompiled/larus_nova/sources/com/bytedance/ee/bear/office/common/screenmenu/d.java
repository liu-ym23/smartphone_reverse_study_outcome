package com.bytedance.ee.bear.office.common.screenmenu;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import com.baidu.platform.comapi.map.MapController;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements fk5.b {
    public d() {
    }

    @Override // fk5.b
    public final void a(CommonMenu r100, fk5.a r101, View r102, Function1<? super fk5.a, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r103, "listener");
    }

    @Override // fk5.b
    public void update(fk5.a r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
    }

    @Override // fk5.b
    public final View b(CommonMenu r100, int r101, int r102, fk5.a r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        if ((r103 instanceof c) == true) goto L5;
        return null;
    L5:
        if (r101 <= 0) goto L25;
        int r104 = -1;
        if ((r102 - 1) == r101) goto L25;
        c r105 = (c) r103;
        if (r105.f235201e <= 0) goto L25;
        FrameLayout r106 = new FrameLayout(r100.getContext());
        int r107 = r105.f235202f;
        if (r107 <= 0) goto L14;
        r104 = r107;
    L14:
        r106.setLayoutParams(new LinearLayoutCompat.LayoutParams(r104, r105.f235201e));
        r106.setPadding(k.a(r106.getContext(), 16), r106.getPaddingTop(), k.a(r106.getContext(), 16), r106.getPaddingBottom());
        int r108 = r105.f235198b;
        if (r108 == 0) goto L18;
        r106.setBackgroundColor(r108);
    L24:
        return r106;
    L18:
        if (r105.f235199c == 0) goto L20;
        r106.setBackground(ContextCompat.getDrawable(r106.getContext(), r105.f235199c));
        goto L24
    L20:
        Drawable r109 = r105.f235200d;
        if (r109 == null) goto L23;
        r106.setBackground(r109);
        goto L24
    L23:
        r106.setBackgroundResource(R.drawable.office_common_menu_divider);
    L25:
        return null;
    }
}
