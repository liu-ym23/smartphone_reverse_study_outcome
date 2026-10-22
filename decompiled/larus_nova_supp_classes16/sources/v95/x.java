package v95;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.drive.view.preview.pdf.SimplePdfView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class x extends RecyclerView.OnScrollListener {
    public final /* synthetic */ SimplePdfView a;

    public x(SimplePdfView r1) {
        this.a = r1;
    }

    public final void onScrolled(RecyclerView r1, int r2, int r3) {
        if (r3 != 0) goto L4;
        return;
    L4:
        SimplePdfView r4 = this.a;
        int r5 = SimplePdfView.K;
        r4.i();
    }
}
