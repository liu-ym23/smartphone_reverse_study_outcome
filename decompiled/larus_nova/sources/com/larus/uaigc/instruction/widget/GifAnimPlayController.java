package com.larus.uaigc.instruction.widget;

import android.graphics.drawable.Animatable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes31.dex */
public final class GifAnimPlayController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f373433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f373434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GifAnimPlayController$scrollListener$1 f373435c;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.uaigc.instruction.widget.GifAnimPlayController$scrollListener$1] */
    public GifAnimPlayController() {
        this.f373435c = new GifAnimPlayController$scrollListener$1(this);
    }

    public static final void a(GifAnimPlayController r100) {
        RecyclerView r101 = r100.f373433a;
        if (r101 == null) goto L31;
        RecyclerView.LayoutManager r102 = r101.getLayoutManager();
        if (r102 == null) goto L39;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L40;
        View r105 = r102.getChildAt(r104);
        if (r105 == null) goto L30;
        RecyclerView r106 = r100.f373433a;
        ImageSelectorHolder r107 = null;
        if (r106 == null) goto L15;
        RecyclerView.ViewHolder r108 = r106.getChildViewHolder(r105);
    L17:
        if ((r108 instanceof ImageSelectorHolder) == false) goto L19;
        r107 = (ImageSelectorHolder) r108;
    L19:
        if (r107 == null) goto L30;
        if (r107.U3() == true) goto L24;
        r107.V3();
        goto L30
    L24:
        if (r107.f373441c == true) goto L30;
        Animatable r109 = r107.f373445g;
        if (r109 == null) goto L30;
        r109.start();
        goto L30
    L15:
        r108 = null;
    L30:
        r104 = r104 + 1;
        goto L8
    L40:
        return;
    L39:
        return;
    }
}
