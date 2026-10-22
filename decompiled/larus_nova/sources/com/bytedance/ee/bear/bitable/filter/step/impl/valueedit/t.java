package com.bytedance.ee.bear.bitable.filter.step.impl.valueedit;

import android.content.Context;
import com.bytedance.ee.bear.bitable.card.view.cell.select.SelectEditAdapter;
import com.bytedance.ee.bear.bitable.card.view.cell.select.StageSelectEditAdapter;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class t extends p {
    @Override // com.bytedance.ee.bear.bitable.filter.step.impl.valueedit.p
    public final SelectEditAdapter i() {
        return new StageSelectEditAdapter();
    }

    public t(Context r100, FilterFieldOption r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r101, r102);
    }
}
