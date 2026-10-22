package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentCoverView;
import com.bytedance.ee.bear.bitable.common.model.field.NativeCell;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.AttachmentModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<AttachmentModel> {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.a$a, reason: collision with other inner class name */
    public static final class C3084a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.ATTACHMENT.getValue();
    }

    public a(iv4.b r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttachmentCoverView r102 = new AttachmentCoverView(r100, null, 6, 0);
        r102.setLayoutParams(new ViewGroup.LayoutParams(com.bytedance.ee.util.ui.n.d(24), com.bytedance.ee.util.ui.n.d(24)));
        int r103 = com.bytedance.ee.util.ui.n.d(24);
        com.bytedance.ee.util.ui.n.d(24);
        if (r103 > 0) goto L6;
        r103 = -1;
    L6:
        r102.f207414q = r103;
        com.bytedance.ee.bear.bitable.m.g(r102.getMPlaceholderIcon(), com.bytedance.ee.util.ui.n.d(24), com.bytedance.ee.util.ui.n.d(24));
        com.bytedance.ee.bear.bitable.m.g(r102.getMPlayVideoIcon(), com.bytedance.ee.util.ui.n.d(14), com.bytedance.ee.util.ui.n.d(14));
        return r102;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void f(View r100, h0 r101) {
        AttachmentModel r102 = (AttachmentModel) r101;
        Intrinsics.checkNotNullParameter(r100, "kitView");
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if ((r100 instanceof AttachmentCoverView) == false) goto L5;
        AttachmentCoverView r103 = (AttachmentCoverView) r100;
    L6:
        if (r103 == null) goto L13;
        AttachmentEntity r104 = r103.getCurrentEntity();
        if (r104 != null) goto L10;
    L11:
        r103.b(r102, 0);
        r103.getMPlaceholderContainer().setBackground(null);
        return;
    L10:
        if (Intrinsics.areEqual(r104, r102) == false) goto L11;
        return;
    L13:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
