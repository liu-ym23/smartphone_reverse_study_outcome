package com.obric.oui.orecyclerview.widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public abstract class h0 extends RecyclerView.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f401825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Scroller f401826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f401827c;

    public class a extends RecyclerView.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f401828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h0 f401829b;

        public a(h0 r100) {
            this.f401829b = r100;
            this.f401828a = false;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.o
        public final void a(RecyclerView r100, int r101) {
            if (r101 == 0) goto L4;
            return;
        L4:
            if (this.f401828a == false) goto L8;
            this.f401828a = false;
            this.f401829b.d();
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.o
        public final void b(RecyclerView r100, int r101, int r102) {
            if (r101 != 0) goto L4;
            if (r102 != 0) goto L4;
            return;
        L4:
            this.f401828a = true;
        }
    }

    public abstract int[] b(RecyclerView.k r100, View r101);

    public abstract View c(RecyclerView.k r100);

    public final void d() {
        RecyclerView r100 = this.f401825a;
        if (r100 != null) goto L5;
        return;
    L5:
        RecyclerView.k r101 = r100.getLayoutManager();
        if (r101 != null) goto L8;
        return;
    L8:
        View r102 = c(r101);
        if (r102 != null) goto L11;
        return;
    L11:
        int[] r103 = b(r101, r102);
        int r104 = r103[0];
        if (r104 == 0) goto L14;
    L15:
        this.f401825a.X(r104, r103[1], null, Integer.MIN_VALUE, false);
        return;
    L14:
        if (r103[1] != 0) goto L15;
    }

    public h0() {
        this.f401827c = new a(this);
    }

    public final void a(RecyclerView r100) throws IllegalStateException {
        RecyclerView r101 = this.f401825a;
        if (r101 != r100) goto L5;
        return;
    L5:
        if (r101 == null) goto L10;
        a r102 = this.f401827c;
        List<RecyclerView.o> r103 = r101.V0;
        if (r103 == null) goto L9;
        ((ArrayList) r103).remove(r102);
    L9:
        this.f401825a.setOnFlingListener(null);
    L10:
        this.f401825a = r100;
        if (r100 != null) goto L13;
        return;
    L13:
        if (r100.getOnFlingListener() != null) goto L16;
        this.f401825a.j(this.f401827c);
        this.f401825a.setOnFlingListener(this);
        this.f401826b = new Scroller(this.f401825a.getContext(), new DecelerateInterpolator());
        d();
        return;
    L16:
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }
}
