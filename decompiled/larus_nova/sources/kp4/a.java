package kp4;

import com.bytedance.ee.bear.bitable.card.view.cell.barcode.BarCodeCellViewHolder;
import hp4.g;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BarCodeCellViewHolder f505498a;

    public a(BarCodeCellViewHolder r100) {
        this.f505498a = r100;
    }

    @Override // hp4.g.a
    public final void onDismiss() {
        BarCodeCellViewHolder.h5(this.f505498a);
    }
}
