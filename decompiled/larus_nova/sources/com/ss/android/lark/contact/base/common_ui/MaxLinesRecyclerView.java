package com.ss.android.lark.contact.base.common_ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class MaxLinesRecyclerView extends CommonRecyclerView {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f418550k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<Integer> f418551l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f418552m;

    public interface a {
    }

    public void setOnHeightChangedListener(a r100) {
    }

    public MaxLinesRecyclerView(Context r100) {
        super(r100);
        this.f418551l = new ArrayList();
        this.f418552m = 0;
    }

    public void setMaxLines(int r100) {
        this.f418550k = r100;
    }

    public MaxLinesRecyclerView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f418551l = new ArrayList();
        this.f418552m = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int r100, int r101) {
        computeVerticalScrollRange();
        int r102 = computeVerticalScrollExtent();
        if (this.f418550k <= 0) goto L8;
        if (((ArrayList) this.f418551l).size() != this.f418550k) goto L8;
        List<Integer> r103 = this.f418551l;
        r101 = View.MeasureSpec.makeMeasureSpec(((Integer) ListProtector.get(r103, ((ArrayList) r103).size() - 1)).intValue(), Integer.MIN_VALUE);
    L8:
        if (((ArrayList) this.f418551l).size() >= this.f418550k) goto L13;
        if (r102 <= 0) goto L13;
        if (((ArrayList) this.f418551l).contains(Integer.valueOf(r102)) == true) goto L13;
        ((ArrayList) this.f418551l).add(Integer.valueOf(r102));
    L13:
        super.onMeasure(r100, r101);
    }

    public MaxLinesRecyclerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f418551l = new ArrayList();
        this.f418552m = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = r104 - r102;
        if (this.f418552m == r105) goto L6;
        this.f418552m = r105;
        return;
    }
}
