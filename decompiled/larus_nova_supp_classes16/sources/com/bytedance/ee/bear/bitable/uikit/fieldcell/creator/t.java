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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<SignatureModel> {
    public final int e;
    public final int f;

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.SIGNATURE.getValue();
    }

    public t(iv4.b r1) {
        super(r1);
        this.e = 42;
        this.f = 24;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r5, ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        AttachmentCoverView r7 = new AttachmentCoverView(r5, null, 6, 0);
        r7.setLayoutParams(new ViewGroup.LayoutParams(com.bytedance.ee.util.ui.n.d(this.e), com.bytedance.ee.util.ui.n.d(this.f)));
        int r0 = com.bytedance.ee.util.ui.n.d(this.e);
        com.bytedance.ee.util.ui.n.d(this.f);
        if (r0 > 0) goto L6;
        r0 = -1;
    L6:
        r7.q = r0;
        com.bytedance.ee.bear.bitable.m.g(r7.getMPlaceholderIcon(), com.bytedance.ee.util.ui.n.d(Math.min(this.e, this.f)), com.bytedance.ee.util.ui.n.d(Math.min(this.e, this.f)));
        r7.setCoverFitType(ImageView.ScaleType.FIT_CENTER);
        r7.setCoverTint(com.bytedance.ee.bear.bitable.celleditor.editor.signature.c.a(r5));
        return r7;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void f(View r3, h0 r4) {
        SignatureModel r5 = (SignatureModel) r4;
        Intrinsics.checkNotNullParameter(r3, "kitView");
        Intrinsics.checkNotNullParameter(r5, "model");
        if ((r3 instanceof AttachmentCoverView) == false) goto L5;
        AttachmentCoverView r6 = (AttachmentCoverView) r3;
    L6:
        if (r6 == null) goto L13;
        AttachmentEntity r0 = r6.getCurrentEntity();
        if (r0 != null) goto L10;
    L11:
        r6.b(r5, 0);
        r6.getMPlaceholderContainer().setBackground(null);
        return;
    L10:
        if (Intrinsics.areEqual(r0, r5) == false) goto L11;
        return;
    L13:
        return;
    L5:
        r6 = null;
        goto L6
    }
}
