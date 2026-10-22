package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentCoverView;
import com.bytedance.ee.bear.bitable.common.model.field.NativeCell;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.AttachmentModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<AttachmentModel> {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.a$a, reason: collision with other inner class name */
    public static final class C0028a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.ATTACHMENT.getValue();
    }

    public a(iv4.b r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttachmentCoverView r6 = new AttachmentCoverView(r4, null, 6, 0);
        r6.setLayoutParams(new ViewGroup.LayoutParams(com.bytedance.ee.util.ui.n.d(24), com.bytedance.ee.util.ui.n.d(24)));
        int r7 = com.bytedance.ee.util.ui.n.d(24);
        com.bytedance.ee.util.ui.n.d(24);
        if (r7 > 0) goto L6;
        r7 = -1;
    L6:
        r6.q = r7;
        com.bytedance.ee.bear.bitable.m.g(r6.getMPlaceholderIcon(), com.bytedance.ee.util.ui.n.d(24), com.bytedance.ee.util.ui.n.d(24));
        com.bytedance.ee.bear.bitable.m.g(r6.getMPlayVideoIcon(), com.bytedance.ee.util.ui.n.d(14), com.bytedance.ee.util.ui.n.d(14));
        return r6;
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void f(View r3, h0 r4) {
        AttachmentModel r5 = (AttachmentModel) r4;
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
