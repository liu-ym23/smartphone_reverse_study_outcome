package yp4;

import android.content.DialogInterface;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.bitable.card.view.cell.progress.b f568707a;

    public c(com.bytedance.ee.bear.bitable.card.view.cell.progress.b r100) {
        this.f568707a = r100;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r100) {
        BitableAnalytic r101 = this.f568707a.f207963b;
        if (r101 == null) goto L10;
        String r102 = EFieldUIType.PROGRESS.getReportValue();
        if (this.f568707a.f207977p != null) goto L7;
        boolean r103 = true;
    L8:
        r101.A(r102, r103);
        return;
    L7:
        r103 = false;
        goto L8
    }
}
