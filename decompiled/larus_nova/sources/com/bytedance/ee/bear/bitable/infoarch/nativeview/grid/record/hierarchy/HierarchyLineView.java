package com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.record.hierarchy;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.utils.statistics.PerfLog;
import gv4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0012B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/record/hierarchy/HierarchyLineView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/record/hierarchy/HierarchyLineData;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "addHierarchyLine", "style", "", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HierarchyLineView extends LinearLayout implements b<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f213614a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f213615b = 0;

    public static final class a {
    }

    static {
        f213614a = n.d(33);
        f213615b = n.d(21);
    }

    public HierarchyLineView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void a(int r100) {
        View r101 = new VerticalDividerView(getContext(), null, 6, 0);
        if (r100 != 1) goto L5;
        int r102 = f213614a;
    L7:
        if (r100 != 3) goto L9;
        int r103 = f213615b;
    L10:
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(n.d(1), -1);
        r104.setMargins(0, r102, ht4.a.f487126i, r103);
        r101.setLayoutParams(r104);
        addView(r101);
        return;
    L9:
        r103 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L7
    }

    public HierarchyLineView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setOrientation(0);
        int r102 = ht4.a.f487118a;
        setPadding(ht4.a.f487125h, 0, 0, 0);
    }
}
