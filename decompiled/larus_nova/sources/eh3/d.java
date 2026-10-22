package eh3;

import android.view.View;
import com.bytedance.android.shopping.sameproduct.viewmodel.SameProductViewModel;
import com.bytedance.android.shopping.sameproduct.widget.SimilarApiErrorView;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d extends com.bytedance.android.ec.core.widget.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ SimilarApiErrorView f472651g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ SameProductViewModel f472652h;

    @Override // com.bytedance.android.ec.core.widget.d
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        if (this.f472652h.isMainProductApiError() == false) goto L6;
        this.f472652h.loadMainProductCard();
    L6:
        if (this.f472652h.isProductListApiError() == false) goto L8;
        this.f472652h.loadSameProductList();
    L8:
        this.f472651g.setVisibility(8);
    }

    public d(SimilarApiErrorView r100, SameProductViewModel r101) {
        this.f472651g = r100;
        this.f472652h = r101;
        super(null, null, 3);
    }
}
