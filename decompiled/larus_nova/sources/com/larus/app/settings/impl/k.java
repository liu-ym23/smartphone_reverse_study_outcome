package com.larus.app.settings.impl;

import android.content.Context;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.nova.R;
import com.larus.utils.e1;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class k {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f287036a = null;

        static {
            int[] r100 = new int[ItemClickMode.values().length];
            r100[ItemClickMode.DIRECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ItemClickMode.DEBOUNCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ItemClickMode.STICKY_DEBOUNCE_1S.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f287036a = r100;
        }
    }

    public static final int b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return c(r100, R.attr.larus_dp_12, R.dimen.larus_dp_12);
    }

    public static final int c(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.getResources().getDimensionPixelSize(v19.c.b(r101, r100, r102));
    }

    public static final ItemTextArrow a(ItemGroup r100, String r101, ItemClickMode r102, final Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "clickMode");
        Intrinsics.checkNotNullParameter(r103, SendEventContainerMethodParamModel.EventKinds.onClick);
        ItemTextArrow r104 = new ItemTextArrow(r100.getContext());
        r104.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r104.setText(r101);
        r104.setTextFontWeight(500);
        int r105 = a.f287036a[r102.ordinal()];
        if (r105 != 1) goto L5;
        r104.setOnClickListener(new h(r103));
    L13:
        r100.addView(r104);
        return r104;
    L5:
        if (r105 != 2) goto L7;
        e1.d(r104, new i(r103));
        goto L13
    L7:
        if (r105 != 3) goto L10;
        e1.a(r104, 1000, new j(r103));
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
