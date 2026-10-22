package com.larksuite.framework.ui.stickyheader;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import q28.c;
import r28.a;
import u28.b;

/* JADX INFO: loaded from: classes24.dex */
public class StickyRecyclerHeadersDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f285860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<Rect> f285861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f285862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f285863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q28.a f285864e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final t28.a f285865f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final s28.a f285866g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f285867h;

    public StickyRecyclerHeadersDecoration(c r100) {
        u28.a r101 = new u28.a();
        s28.a r102 = new s28.a();
        t28.a r103 = new t28.a(r101);
        r28.b r104 = new r28.b(r100, r101);
        q28.a r105 = new q28.a(r100, r104, r101, r102);
        this.f285861b = new SparseArray();
        this.f285867h = new Rect();
        this.f285860a = r100;
        this.f285862c = r104;
        this.f285863d = r101;
        this.f285865f = r103;
        this.f285866g = r102;
        this.f285864e = r105;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        super.onDrawOver(r110, r111, r112);
        int r113 = r111.getChildCount();
        if (r113 > 0) goto L5;
        return;
    L5:
        if (this.f285860a.getItemCount() <= 0) goto L26;
        this.f285861b.clear();
        int r100 = 0;
    L8:
        if (r100 >= r113) goto L27;
        View r101 = r111.getChildAt(r100);
        int r102 = r111.getChildAdapterPosition(r101);
        if (r102 == (-1)) goto L20;
        boolean r103 = this.f285864e.e(r101, ((u28.a) this.f285863d).a(r111), r102);
        if (r103 == false) goto L15;
    L16:
        View r104 = ((r28.b) this.f285862c).a(r111, r102);
        Rect r105 = this.f285861b.get(r102);
        if (r105 != null) goto L19;
        r105 = new Rect();
        this.f285861b.put(r102, r105);
    L19:
        Rect r106 = r105;
        this.f285864e.f(r106, r111, r104, r101, r103);
        this.f285865f.a(r111, r110, r104, r106);
        goto L20
    L15:
        if (this.f285864e.d(r102, ((u28.a) this.f285863d).b(r111)) == true) goto L16;
    L20:
        r100 = r100 + 1;
        goto L8
    L27:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        super.getItemOffsets(r100, r101, r102, r103);
        int r104 = r102.getChildAdapterPosition(r101);
        if (r104 != (-1)) goto L6;
        return;
    L6:
        if (this.f285864e.d(r104, ((u28.a) this.f285863d).b(r102)) == false) goto L12;
        View r105 = ((r28.b) this.f285862c).a(r102, r104);
        int r106 = ((u28.a) this.f285863d).a(r102);
        s28.a r107 = this.f285866g;
        Rect r108 = this.f285867h;
        r107.getClass();
        s28.a.a(r108, r105);
        if (r106 != 1) goto L10;
        int r109 = r105.getHeight();
        Rect r110 = this.f285867h;
        r100.top = (r109 + r110.top) + r110.bottom;
        return;
    L10:
        int r111 = r105.getWidth();
        Rect r112 = this.f285867h;
        r100.left = (r111 + r112.left) + r112.right;
        return;
    }
}
