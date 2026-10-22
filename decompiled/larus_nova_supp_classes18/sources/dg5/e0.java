package dg5;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e0 extends RecyclerView.OnScrollListener {
    public final /* synthetic */ a0 a;

    public e0(a0 r1) {
        this.a = r1;
    }

    public final void onScrollStateChanged(RecyclerView r3, int r4) {
        super.onScrollStateChanged(r3, r4);
        tt5.a.h("PanelView", "onScrollStateChanged newState = " + r4);
        if (r4 == 0) goto L5;
    L7:
        this.a.l.j(false);
    L8:
        if (r4 != 0) goto L11;
        a0 r5 = this.a;
        a0.a(r5, r5.s);
        return;
    L11:
        return;
    L5:
        if (r3.computeVerticalScrollOffset() != 0) goto L7;
        this.a.l.j(true);
        goto L8
    }

    public final void onScrolled(RecyclerView r1, int r2, int r3) {
        super.onScrolled(r1, r2, r3);
        if (r2 != 0) goto L7;
        if (r3 != 0) goto L8;
        a0 r4 = this.a;
        a0.a(r4, r4.s);
        return;
    L8:
        return;
    }
}
