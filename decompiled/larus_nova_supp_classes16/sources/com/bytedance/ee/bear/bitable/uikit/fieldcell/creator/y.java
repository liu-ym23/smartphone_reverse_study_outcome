package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bitable.common.model.field.NativeCell;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.IconCapsuleModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.pure.UserItemView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class y extends com.bytedance.ee.bear.bitable.uikit.fieldcell.b<IconCapsuleModel> {
    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public String getType() {
        return NativeCell.User.getValue();
    }

    public y(iv4.b r1) {
        super(r1);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final View c(Context r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r6 = ht4.b.a;
        getType();
        return new UserItemView(r4, null, 6, 0);
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.b
    public final void f(View r3, h0 r4) {
        IconCapsuleModel r5 = (IconCapsuleModel) r4;
        Intrinsics.checkNotNullParameter(r3, "kitView");
        Intrinsics.checkNotNullParameter(r5, "model");
        if ((r3 instanceof UserItemView) == false) goto L8;
        UserItemView r6 = (UserItemView) r3;
        a(r6.getContentView(), true);
        r6.a = r5;
        if (r5 == null) goto L9;
        r6.b.c.setText(r5.getText());
        com.bytedance.ee.bear.bitable.common.h.a(r6.getContext(), r5.getAvatarUrl(), null, r6.b.b);
        return;
    L9:
        return;
    }
}
