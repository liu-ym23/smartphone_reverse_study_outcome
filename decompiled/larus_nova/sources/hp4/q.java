package hp4;

import android.view.View;
import com.bytedance.ee.bear.bitable.card.model.enums.EFieldUneditableReason;
import com.bytedance.ee.bear.bitable.card.view.cell.BaseCellViewHolder;

/* JADX INFO: loaded from: classes15.dex */
public final class q extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ EFieldUneditableReason f486423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BaseCellViewHolder f486424d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        this.f486424d.M4(this.f486423c);
    }

    public q(BaseCellViewHolder r100, EFieldUneditableReason r101) {
        this.f486424d = r100;
        this.f486423c = r101;
        super(800);
    }
}
