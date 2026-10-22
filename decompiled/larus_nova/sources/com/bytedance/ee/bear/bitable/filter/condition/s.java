package com.bytedance.ee.bear.bitable.filter.condition;

import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.UserEntity;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class s<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserFilterConditionView f211867a;

    public s(UserFilterConditionView r100) {
        this.f211867a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f211867a.f211841p = (UserEntity[]) r100;
    }
}
