package com.larus.bmhome.view.actionbar.custom;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/view/actionbar/custom/OffsetLinearSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "offset", "", "<init>", "(Landroid/content/Context;I)V", "calculateDtToFit", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class OffsetLinearSmoothScroller extends LinearSmoothScroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f315815a;

    public OffsetLinearSmoothScroller(Context r100, int r101) {
        super(r100);
        this.f315815a = r101;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final int calculateDtToFit(int r100, int r101, int r102, int r103, int r104) {
        return (r103 - r101) + this.f315815a;
    }
}
