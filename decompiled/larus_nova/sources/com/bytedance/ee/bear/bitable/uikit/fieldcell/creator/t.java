package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentCoverView;
import com.bytedance.ee.bear.bitable.common.model.field.NativeCell;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.SignatureModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class t extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<SignatureModel> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f216189e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f216190f;

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.SIGNATURE.getValue();
    }

    public t(iv4.b r100) {
        super(r100);
        this.f216189e = 42;
        this.f216190f = 24;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttachmentCoverView r102 = new AttachmentCoverView(r100, null, 6, 0);
        r102.setLayoutParams(new ViewGroup.LayoutParams(com.bytedance.ee.util.ui.n.d(this.f216189e), com.bytedance.ee.util.ui.n.d(this.f216190f)));
        int r103 = com.bytedance.ee.util.ui.n.d(this.f216189e);
        com.bytedance.ee.util.ui.n.d(this.f216190f);
        if (r103 > 0) goto L6;
        r103 = -1;
    L6:
        r102.f207414q = r103;
        com.bytedance.ee.bear.bitable.m.g(r102.getMPlaceholderIcon(), com.bytedance.ee.util.ui.n.d(Math.min(this.f216189e, this.f216190f)), com.bytedance.ee.util.ui.n.d(Math.min(this.f216189e, this.f216190f)));
        r102.setCoverFitType(ImageView.ScaleType.FIT_CENTER);
        r102.setCoverTint(com.bytedance.ee.bear.bitable.celleditor.editor.signature.c.a(r100));
        return r102;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void f(View r100, h0 r101) {
        SignatureModel r102 = (SignatureModel) r101;
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
