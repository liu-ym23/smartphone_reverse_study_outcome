package com.larksuite.framework.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0014J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larksuite/framework/ui/AutoAdjustLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "maxWidthInPixels", "", "maxHeightInPixels", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onViewAdded", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "common-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoAdjustLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f285817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f285818b;

    public AutoAdjustLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (getChildCount() > 1) goto L7;
        super.onViewAdded(r100);
        return;
    L7:
        throw new IllegalStateException("Maximum 1 child");
    }

    public AutoAdjustLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f285817a = 1080;
        this.f285818b = 1280;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        View.MeasureSpec.getMode(r110);
        int r100 = View.MeasureSpec.getSize(r110);
        View.MeasureSpec.getMode(r111);
        int r101 = View.MeasureSpec.getSize(r111);
        if (getChildCount() <= 0) goto L11;
        boolean r102 = false;
        View r103 = getChildAt(0);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.View");
        int r104 = Math.min(r100, this.f285817a);
        if (r104 >= r100) goto L7;
        r102 = true;
    L7:
        if (r102 == false) goto L9;
        int r105 = Math.min(r101, this.f285818b);
    L10:
        measureChildWithMargins(r103, r110, r100 - r104, r111, r101 - r105);
        goto L11
    L9:
        r105 = r101;
    L11:
        setMeasuredDimension(r100, r101);
    }
}
