package com.larus.home.impl.main.side_bar.view.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class x0 {
    public static final Pair<RecyclerView.Adapter<?>, Integer> a(ConcatAdapter r100, int r101) {
        Iterator<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r102 = r100.getAdapters().iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L13;
        RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r104 = r102.next();
        int r105 = r104.getItemCount() + r103;
        if (r101 < r105) goto L7;
        r103 = r105;
        goto L4
    L7:
        int r106 = r101 - r103;
        if ((r104 instanceof ConcatAdapter) == false) goto L11;
        return a((ConcatAdapter) r104, r106);
    L11:
        return TuplesKt.to(r104, Integer.valueOf(r106));
    L13:
        return null;
    }

    public static final Pair<RecyclerView.Adapter<?>, Integer> b(ConcatAdapter r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Pair<RecyclerView.Adapter<?>, Integer> r102 = a(r100, r101);
        if (r102 != null) goto L6;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(new Throwable("GlobalPositionOutOfBoundsException globalPosition=" + r101));
        FLogger.f375446a.e("getChildAdapterAndPosition", "GlobalPositionOutOfBoundsException globalPosition=" + r101);
        return null;
    L6:
        return r102;
    }

    public static final void c(View r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "rootView");
        Context r100 = r110.getContext();
        int r101 = ContextCompat.getColor(r100, v19.c.b(R.attr.larus_base_2_overlay, r100, R.color.larus_base_2_overlay));
        int r102 = ContextCompat.getColor(r100, v19.c.b(R.attr.larus_base_1, r100, R.color.larus_base_1));
        GradientDrawable r103 = new GradientDrawable();
        r103.setCornerRadius(r100.getResources().getDimension(v19.c.b(R.attr.larus_dp_12, r100, R.dimen.larus_dp_12)));
        ColorStateList r104 = new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed, android.R.attr.state_selected}, new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_selected}, new int[0]}, new int[]{r101, r101, r101, r102});
        if (r111 == false) goto L5;
        r104 = ColorStateList.valueOf(ColorUtils.compositeColors(r104.getColorForState(new int[]{android.R.attr.state_pressed}, r104.getDefaultColor()), r104.getDefaultColor()));
    L5:
        r103.setColor(r104);
        r110.setBackground(r103);
    }
}
