package com.ss.android.lark.widget.recyclerview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J \u0010\u0017\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rH\u0016R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/widget/recyclerview/FocusDisableRecycler;", "Lcom/ss/android/lark/widget/recyclerview/PointRecoderRecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attributes", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "disableFocus", "", "getDisableFocus", "()Z", "setDisableFocus", "(Z)V", "requestChildFocus", "", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "focused", "requestChildRectangleOnScreen", SVGRenderEngine.RECT, "Landroid/graphics/Rect;", "immediate", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FocusDisableRecycler extends PointRecoderRecyclerView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f448160l;

    public final boolean getDisableFocus() {
        return this.f448160l;
    }

    public FocusDisableRecycler(Context r100) {
        super(r100);
    }

    public final void setDisableFocus(boolean r100) {
        this.f448160l = r100;
    }

    public FocusDisableRecycler(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, "focused");
        if (this.f448160l == true) goto L6;
        super.requestChildFocus(r100, r101);
        return;
    }

    public FocusDisableRecycler(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View r100, Rect r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, SVGRenderEngine.RECT);
        if (this.f448160l == false) goto L7;
        return false;
    L7:
        return super.requestChildRectangleOnScreen(r100, r101, r102);
    }
}
