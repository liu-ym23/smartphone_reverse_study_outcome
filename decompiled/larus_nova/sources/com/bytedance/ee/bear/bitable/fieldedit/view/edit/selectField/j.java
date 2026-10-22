package com.bytedance.ee.bear.bitable.fieldedit.view.edit.selectField;

import com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConditionListView f211623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<com.bytedance.ee.bear.bitable.fieldedit.model.a> f211624b;

    public j(ConditionListView r100, List<com.bytedance.ee.bear.bitable.fieldedit.model.a> r101) {
        this.f211623a = r100;
        this.f211624b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        List r101 = (List) r100;
        ConditionListView r102 = this.f211623a;
        List<com.bytedance.ee.bear.bitable.fieldedit.model.a> r103 = this.f211624b;
        Intrinsics.checkNotNull(r103);
        r102.r(r103);
    }
}
