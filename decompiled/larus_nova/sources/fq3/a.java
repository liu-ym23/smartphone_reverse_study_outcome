package fq3;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.window.shop.product.pinrecyclerview.ECRecyclerViewPinnableLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECRecyclerViewPinnableLayout f478410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f478411b;

    public a(ECRecyclerViewPinnableLayout r100, int r101) {
        this.f478410a = r100;
        this.f478411b = r101;
    }

    public final void a() {
        RecyclerView.Adapter r100 = this.f478410a.f189264c.getAdapter();
        if (r100 == null) goto L5;
        r100.notifyItemChanged(this.f478411b);
    L5:
        ECRecyclerViewPinnableLayout.b r101 = this.f478410a.getPinedCallback();
        if (r101 == null) goto L9;
        ECRecyclerViewPinnableLayout r102 = this.f478410a;
        ECRecyclerViewPinnableLayout.InnerRecyclerView r103 = r102.f189264c;
        int r104 = this.f478411b;
        ((Number) ListProtector.get(r102.f189265d, r104)).intValue();
        r101.A(r103);
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
