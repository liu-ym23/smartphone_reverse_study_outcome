package com.bytedance.ee.bear.bitable.filter.condition;

import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.UserEntity;
import io.reactivex.functions.Consumer;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes15.dex */
public final class t<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UserFilterConditionView f211868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserEntity[] f211869b;

    public t(UserFilterConditionView r100, UserEntity[] r101) {
        this.f211868a = r100;
        this.f211869b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        UserEntity[] r101 = (UserEntity[]) r100;
        StringBuilder r102 = new StringBuilder("checkDataContentChanged finish: userArray -> ");
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(r101.length);
    L6:
        r102.append(r103);
        tt5.a.b("UserFilterConditionView", r102.toString());
        if (r101 == null) goto L11;
        UserFilterConditionView r104 = this.f211868a;
        UserEntity[] r105 = this.f211869b;
        r104.getClass();
        int r106 = r105.length;
        int r107 = 0;
    L9:
        if (r107 >= r106) goto L11;
        ArraysKt.contains(r101, r105[r107]);
        r107 = r107 + 1;
    L11:
        UserFilterConditionView r108 = this.f211868a;
        k.a r109 = r108.f211849g;
        if (r109 == null) goto L16;
        r109.b(r108.f211846d - 1);
        return;
    L16:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
