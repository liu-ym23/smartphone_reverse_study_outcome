package com.larus.bmhome.chat.manager.settings;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextToggle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class t {
    public t() {
    }

    public static ItemTextArrow a(ItemGroup r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "group");
        String r103 = r100.getContext().getString(r101);
        Intrinsics.checkNotNullParameter(r100, "group");
        Intrinsics.checkNotNullParameter(r103, "text");
        ItemTextArrow r104 = new ItemTextArrow(r100.getContext());
        r104.setText(r103);
        r104.setTextFontWeight(500);
        r104.setImageSrc(r102);
        r100.addView(r104);
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r106 = (LinearLayout.LayoutParams) r105;
        r106.width = -1;
        r106.height = -2;
        return r104;
    }

    public static ItemTextToggle b(ItemGroup r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "group");
        ItemTextToggle r103 = new ItemTextToggle(r100.getContext());
        r103.setText(r103.getContext().getString(r101));
        r103.setTextFontWeight(500);
        r103.setImageSrc(r102);
        r100.addView(r103);
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r105 = (LinearLayout.LayoutParams) r104;
        r105.width = -1;
        r105.height = -2;
        return r103;
    }
}
