package com.bytedance.ee.bear.bitable.sort;

import com.bytedance.ee.bear.bitable.filter.step.FilterStepClickEvent;
import com.bytedance.ee.bear.bitable.panel.l;
import com.bytedance.ee.bear.bitable.toolbox.BitableToolboxAnalytic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableSortPanelFragment f215584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f215585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BitableSortData.SortedField f215586c;

    @Override // com.bytedance.ee.bear.bitable.panel.l
    public final void onExit() {
        BitableSortPanelFragment r100 = this.f215584a;
        int r101 = BitableSortPanelFragment.f215552u;
        BitableToolboxAnalytic r102 = r100.X90();
        if (r102 == null) goto L6;
        r102.P("cancel", "field");
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.panel.l
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        BitableSortData r101 = this.f215584a.f215562n;
        if (r101 == null) goto L11;
        BitableSortData.SortedField[] r102 = r101.getSortInfo();
        if (r102 == null) goto L11;
        int r103 = this.f215585b;
        BitableSortData.SortedField r104 = this.f215586c;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        if (r102.length <= r103) goto L10;
        r104 = r102[r103];
    L10:
        if (r104 == null) goto L11;
    L13:
        if (Intrinsics.areEqual(r100, r104.getFieldId()) == true) goto L18;
        r104.setFieldId(r100);
        this.f215584a.updateView();
        this.f215584a.aa0();
        BitableToolboxAnalytic r105 = this.f215584a.X90();
        if (r105 == null) goto L19;
        r105.P(FilterStepClickEvent.INPUT_AREA, "field");
        return;
    L19:
        return;
    L18:
        return;
    L11:
        r104 = this.f215586c;
        tt5.a.d("BitableSortPanelFragment", "mCurrentSortData find field error");
        goto L13
    }

    public f(BitableSortPanelFragment r100, int r101, BitableSortData.SortedField r102) {
        this.f215584a = r100;
        this.f215585b = r101;
        this.f215586c = r102;
    }
}
