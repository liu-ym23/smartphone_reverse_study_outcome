package fq3;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.window.shop.product.pinrecyclerview.ECRecyclerViewPinnableLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements Runnable {
    public final /* synthetic */ ECRecyclerViewPinnableLayout a;
    public final /* synthetic */ int b;

    public a(ECRecyclerViewPinnableLayout r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        RecyclerView.Adapter r0 = this.a.c.getAdapter();
        if (r0 == null) goto L5;
        r0.notifyItemChanged(this.b);
    L5:
        ECRecyclerViewPinnableLayout.b r1 = this.a.getPinedCallback();
        if (r1 == null) goto L9;
        ECRecyclerViewPinnableLayout r2 = this.a;
        ECRecyclerViewPinnableLayout.InnerRecyclerView r3 = r2.c;
        int r4 = this.b;
        ((Number) ListProtector.get(r2.d, r4)).intValue();
        r1.A(r3);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
