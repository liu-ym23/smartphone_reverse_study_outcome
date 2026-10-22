package com.bytedance.locallife.pdp.rv;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.locallife.dito.view.f;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final RecyclerView a(View r100) {
        if (r100 != null) goto L5;
    L33:
        return null;
    L5:
        if (r100.getVisibility() != 0) goto L33;
        boolean r101 = true;
        if ((r100 instanceof RecyclerView) == false) goto L19;
        RecyclerView r102 = (RecyclerView) r100;
        RecyclerView.LayoutManager r103 = r102.getLayoutManager();
        if (r103 != null) goto L12;
    L14:
        r101 = false;
    L15:
        if (r101 == false) goto L17;
        return r102;
    L17:
        return null;
    L12:
        if (r103.canScrollVertically() != true) goto L14;
    L19:
        if ((r100 instanceof ViewGroup) == true) goto L21;
        return null;
    L21:
        ViewGroup r104 = (ViewGroup) r100;
        int r105 = r104.getChildCount() - 1;
    L23:
        if ((-1) >= r105) goto L33;
        View r106 = r104.getChildAt(r105);
        int r107 = (r106.getLeft() + r106.getRight()) / 2;
        int r108 = r104.getScrollX();
        if (r107 <= r108) goto L32;
        if (r107 >= (r108 + r104.getWidth())) goto L32;
        RecyclerView r109 = a(r106);
        if (r109 == null) goto L32;
        return r109;
    L32:
        r105 = r105 - 1;
        goto L23
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final ViewGroup b(View r100) {
        if (r100 != 0) goto L5;
    L21:
        return null;
    L5:
        if ((r100 instanceof ViewGroup) == false) goto L21;
        if ((r100 instanceof f) == true) goto L10;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
    L15:
        r102 = r102 - 1;
        if ((-1) >= r102) goto L21;
        ViewGroup r103 = b(r101.getChildAt(r102));
        if (r103 == null) goto L15;
        return r103;
    L10:
        if (((f) r100).o() == true) goto L12;
        return null;
    L12:
        return (ViewGroup) r100;
    }
}
