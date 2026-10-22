package com.bytedance.ee.bear.bitable.fieldedit.view.edit.selectField;

import com.bytedance.ee.bear.bitable.common.model.field.OptionItem;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class x<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StaticPropertyEditViewHolder f211641a;

    public x(StaticPropertyEditViewHolder r100) {
        this.f211641a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        OptionItem r101 = (OptionItem) r100;
        List<OptionItem> r102 = this.f211641a.f211564q;
        Intrinsics.checkNotNull(r101);
        ((ArrayList) r102).add(r101);
        StaticPropertyEditViewHolder r103 = this.f211641a;
        r103.f211563p = false;
        StaticPropertyEditViewHolder.SelectOptionAdapter r104 = r103.f211560m;
        if (r104 == null) goto L6;
        r104.notifyItemInserted(CollectionsKt.getLastIndex(r103.f211564q));
        return;
    }
}
