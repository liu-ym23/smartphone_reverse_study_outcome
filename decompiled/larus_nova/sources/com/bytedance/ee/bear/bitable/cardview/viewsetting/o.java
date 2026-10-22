package com.bytedance.ee.bear.bitable.cardview.viewsetting;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bitable.cardview.GridViewLayoutType;
import com.bytedance.ee.bear.bitable.uikit.setting.card.CardType;
import com.bytedance.ee.bear.bitable.uikit.setting.card.GridType;

/* JADX INFO: loaded from: classes15.dex */
public final class o<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CardType f209276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GridType f209277b;

    public o(CardType r100, GridType r101) {
        this.f209276a = r100;
        this.f209277b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        GridViewLayoutType r101 = (GridViewLayoutType) r100;
        CardType r102 = this.f209276a;
        boolean r103 = true;
        boolean r104 = false;
        if (r101 != GridViewLayoutType.CardViewLayout) goto L5;
        boolean r105 = true;
    L6:
        Boolean r106 = Boolean.valueOf(r105);
        if (r106 == null) goto L9;
        r102.getClass();
        boolean r107 = r106.booleanValue();
    L10:
        r102.setSelected(r107);
        GridType r108 = this.f209277b;
        if (r101 == GridViewLayoutType.GridViewLayout) goto L14;
        r103 = false;
    L14:
        Boolean r109 = Boolean.valueOf(r103);
        if (r109 == null) goto L17;
        r108.getClass();
        r104 = r109.booleanValue();
    L17:
        r108.setSelected(r104);
        return;
    L9:
        r107 = false;
        goto L10
    L5:
        r105 = false;
        goto L6
    }
}
