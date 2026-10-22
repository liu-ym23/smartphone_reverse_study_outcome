package et3;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends RecyclerView.OnScrollListener {
    public final /* synthetic */ h a;

    public f(h r1) {
        this.a = r1;
    }

    public final void onScrollStateChanged(RecyclerView r1, int r2) {
        super.onScrollStateChanged(r1, r2);
        if (r2 == 0) goto L5;
        this.a.c();
        return;
    L5:
        this.a.d();
    }
}
