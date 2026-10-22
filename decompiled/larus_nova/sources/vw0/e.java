package vw0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e {
    public static final void a(d r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$assign");
        Intrinsics.checkNotNullParameter(r101, "source");
        r100.setRechargeAgreementAccepted(r101.isRechargeAgreementAccepted());
        r100.setCombinedPaySelected(r101.isCombinedPaySelected());
        r100.setCustomPrice(r101.getCustomPrice());
        r100.setHidePanel(r101.isHidePanel());
        r100.setShowCenterLoading(r101.isShowCenterLoading());
        r100.setPanelMode(r101.getPanelMode());
    }
}
