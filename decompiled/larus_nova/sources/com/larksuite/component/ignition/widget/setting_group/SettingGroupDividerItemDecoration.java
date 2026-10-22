package com.larksuite.component.ignition.widget.setting_group;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rJ \u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J(\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/larksuite/component/ignition/widget/setting_group/SettingGroupDividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", ItemStyle.ITEM_STYLE_DIVIDER, "Lcom/larksuite/component/ignition/widget/setting_group/SettingGroupDividerDrawable;", "bounds", "Landroid/graphics/Rect;", "setDividerBackgroundColor", "", "dividerBackgroundColor", "", "setLeftPadding", "dividerLeftPadding", "onDraw", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "drawVertical", "canvas", "getDrawCount", "getItemOffsets", "outRect", "view", "Landroid/view/View;", "ignition-widget-settinggroup_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SettingGroupDividerItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SettingGroupDividerDrawable f284014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f284015b;

    public SettingGroupDividerItemDecoration(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f284014a = new SettingGroupDividerDrawable(r100);
        this.f284015b = new Rect();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r102, "state");
        if (r101.getLayoutManager() != null) goto L5;
        return;
    L5:
        r100.save();
        SettingGroupDividerDrawable r103 = this.f284014a;
        int r104 = r101.getPaddingLeft();
        int r105 = r101.getWidth() - r101.getPaddingRight();
        r100.clipRect(r104, r101.getPaddingTop(), r105, r101.getHeight() - r101.getPaddingBottom());
        int r106 = r101.getChildCount() - 1;
        int r107 = 0;
    L6:
        if (r107 >= r106) goto L8;
        View r108 = r101.getChildAt(r107);
        r101.getDecoratedBoundsWithMargins(r108, this.f284015b);
        int r109 = this.f284015b.bottom + MathKt.roundToInt(r108.getTranslationY());
        r103.setBounds(r104, r109 - r103.getIntrinsicHeight(), r105, r109);
        r103.draw(r100);
        r107 = r107 + 1;
        goto L6
    L8:
        r100.restore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        r100.set(0, 0, 0, this.f284014a.getIntrinsicHeight());
    }
}
