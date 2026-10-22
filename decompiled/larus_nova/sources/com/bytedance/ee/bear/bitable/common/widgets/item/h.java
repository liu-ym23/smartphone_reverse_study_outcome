package com.bytedance.ee.bear.bitable.common.widgets.item;

import android.view.LayoutInflater;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.bytedance.ee.bear.bitable.uikit.empty.EmptyData;
import com.bytedance.ee.bear.bitable.uikit.empty.EmptyView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class h implements j<EmptyData> {
    public h() {
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.item.j
    public final View b(NestedScrollView r100) {
        Intrinsics.checkNotNullParameter(r100, "parentView");
        return LayoutInflater.from(r100.getContext()).inflate(R.layout.bitable_uikit_empty_view, r100, false);
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.item.j
    public final void a(View r100, Object r101) {
        EmptyData r102 = (EmptyData) r101;
        Intrinsics.checkNotNullParameter(r100, "contentView");
        Intrinsics.checkNotNullParameter(r102, "extra");
        if ((r100 instanceof EmptyView) == false) goto L6;
        ((EmptyView) r100).a(r102, null);
        return;
    }
}
