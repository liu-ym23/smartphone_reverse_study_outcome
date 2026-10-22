package com.bytedance.ee.bear.bitable.filter.step.impl.valueedit;

import android.view.View;
import com.bytedance.ee.bear.bitable.common.widgets.item.BitableSelectorItemView;
import com.bytedance.ee.bear.bitable.filter.model.EFilterDuration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class g implements BitableSelectorItemView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DateFilterValueEditViewHolder f211991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EFilterDuration f211992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f211993c;

    @Override // com.bytedance.ee.bear.bitable.common.widgets.item.BitableSelectorItemView.b
    public final void a(BitableSelectorItemView r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.item.BitableSelectorItemView.b
    public final boolean b(BitableSelectorItemView r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        DateFilterValueEditViewHolder r101 = this.f211991a;
        r101.f211944p = this.f211992b;
        int r102 = r101.f211940l.getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L12;
        View r104 = r101.f211940l.getChildAt(r103);
        if ((r104 instanceof BitableSelectorItemView) == false) goto L7;
        BitableSelectorItemView r105 = (BitableSelectorItemView) r104;
    L8:
        if (r105 == null) goto L10;
        r105.setSelected(Intrinsics.areEqual(r105, r100));
    L10:
        r103 = r103 + 1;
        goto L3
    L7:
        r105 = null;
        goto L8
    L12:
        if (this.f211993c == false) goto L16;
        i.a r106 = this.f211991a.f211979h;
        if (r106 == null) goto L24;
        r106.SO();
        return true;
    L24:
        return true;
    L16:
        i.a r107 = this.f211991a.f211979h;
        if (r107 == null) goto L26;
        r107.NC();
        return true;
    L26:
        return true;
    }

    public g(DateFilterValueEditViewHolder r100, EFilterDuration r101, boolean r102) {
        this.f211991a = r100;
        this.f211992b = r101;
        this.f211993c = r102;
    }
}
