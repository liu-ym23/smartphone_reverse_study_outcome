package eh3;

import android.view.View;
import com.bytedance.android.shopping.sameproduct.viewmodel.SameProductViewModel;
import com.bytedance.android.shopping.sameproduct.widget.SimilarApiErrorView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends com.bytedance.android.ec.core.widget.d {
    public final /* synthetic */ SimilarApiErrorView g;
    public final /* synthetic */ SameProductViewModel h;

    public final void a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        if (this.h.isMainProductApiError() == false) goto L6;
        this.h.loadMainProductCard();
    L6:
        if (this.h.isProductListApiError() == false) goto L8;
        this.h.loadSameProductList();
    L8:
        this.g.setVisibility(8);
    }

    public d(SimilarApiErrorView r1, SameProductViewModel r2) {
        this.g = r1;
        this.h = r2;
        super(null, null, 3);
    }
}
