package wm5;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.sheet.inputbar.SheetEditFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l1 extends RecyclerView.OnScrollListener {
    public final /* synthetic */ RecyclerView.LayoutManager a;
    public final /* synthetic */ View b;
    public final /* synthetic */ SheetEditFragment c;

    public l1(SheetEditFragment r1, RecyclerView.LayoutManager r2, View r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }

    public final void onScrolled(RecyclerView r2, int r3, int r4) {
        super.onScrolled(r2, r3, r4);
        boolean r5 = true;
        int r0 = 0;
        if (this.a.findLastCompletelyVisibleItemPosition() == (this.c.u.getItemCount() - 1)) goto L6;
        r5 = false;
    L6:
        View r6 = this.b;
        if (r5 == false) goto L9;
        r0 = 8;
    L9:
        r6.setVisibility(r0);
    }
}
