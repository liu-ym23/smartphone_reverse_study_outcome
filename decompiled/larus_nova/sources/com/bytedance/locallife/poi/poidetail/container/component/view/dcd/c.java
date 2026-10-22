package com.bytedance.locallife.poi.poidetail.container.component.view.dcd;

import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiExpDcdProductViewHolder f263824a;

    public c(PoiExpDcdProductViewHolder r100) {
        this.f263824a = r100;
    }

    public final void a() {
        this.f263824a.itemView.getLayoutParams().width = (int) ((UIUtils.getScreenWidth(this.f263824a.itemView.getContext()) - UIUtils.dip2Px(this.f263824a.itemView.getContext(), 80.0f)) / 2);
        this.f263824a.itemView.requestLayout();
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
