package com.bytedance.locallife.poi.dito.poi.component;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/poi/dito/poi/component/CenterSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class CenterSmoothScroller extends LinearSmoothScroller {
    public CenterSmoothScroller(Context r100) {
        super(r100);
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final int calculateDtToFit(int r100, int r101, int r102, int r103, int r104) {
        return (r102 + ((r103 - r102) / 2)) - (r100 + ((r101 - r100) / 2));
    }
}
