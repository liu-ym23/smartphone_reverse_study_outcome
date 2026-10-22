package et3;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class c$a extends RecyclerView.OnScrollListener {
    public final /* synthetic */ c a;

    public c$a(c r1) {
        this.a = r1;
    }

    public final void onScrollStateChanged(RecyclerView r1, int r2) {
        super.onScrollStateChanged(r1, r2);
        if (r2 == 0) goto L5;
        this.a.d();
        return;
    L5:
        this.a.f();
    }
}
