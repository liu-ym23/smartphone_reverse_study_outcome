package dw7;

import androidx.recyclerview.widget.RecyclerView;
import wv7.d;

/* JADX INFO: loaded from: classes23.dex */
public final class b {
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(RecyclerView.Adapter r100, RecyclerView.ViewHolder r101, int r102) {
        if ((r100 instanceof wv7.c) == false) goto L7;
        return ((wv7.c) r100).h1(r101, r102);
    L7:
        return r100.onFailedToRecycleView(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(RecyclerView.Adapter r100, RecyclerView.ViewHolder r101, int r102) {
        if ((r100 instanceof wv7.c) == false) goto L5;
        ((wv7.c) r100).C1(r101, r102);
        return;
    L5:
        r100.onViewAttachedToWindow(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(RecyclerView.Adapter r100, RecyclerView.ViewHolder r101, int r102) {
        if ((r100 instanceof wv7.c) == false) goto L5;
        ((wv7.c) r100).C(r101, r102);
        return;
    L5:
        r100.onViewDetachedFromWindow(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(RecyclerView.Adapter r100, RecyclerView.ViewHolder r101, int r102) {
        if ((r100 instanceof d) == false) goto L5;
        ((d) r100).E0(r101, r102);
        return;
    L5:
        r100.onViewRecycled(r101);
    }
}
