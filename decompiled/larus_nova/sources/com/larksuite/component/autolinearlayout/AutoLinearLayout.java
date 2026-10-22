package com.larksuite.component.autolinearlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larksuite.component.universe_design.button.UDButton;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0014J \u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0002J\b\u0010\u0017\u001a\u00020\rH\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larksuite/component/autolinearlayout/AutoLinearLayout;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "autoAjustmentCompleted", "", "lastWidthMeasureSpec", "", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "addView", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "changeToHorizontal", "changeToVertical", "findPrimary", "Lcom/larksuite/component/universe_design/button/UDButton;", "findSecondary", "Companion", "widget-autolinearlayout_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class AutoLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f282970c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f282971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f282972b;

    public static final class a {
    }

    static {
        f282970c = CollectionsKt.listOf(new String[]{"primary", "secondary"});
    }

    public AutoLinearLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public AutoLinearLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        if (getChildCount() == 2) goto L5;
        super.onMeasure(r110, r111);
        return;
    L5:
        if (this.f282972b == r110) goto L7;
        this.f282972b = r110;
        UDButton r100 = (UDButton) findViewWithTag("primary");
        UDButton r101 = (UDButton) findViewWithTag("secondary");
        setOrientation(0);
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r103 = (LinearLayout.LayoutParams) r102;
        r103.weight = 1.0f;
        r103.width = 0;
        ViewGroup.LayoutParams r104 = r101.getLayoutParams();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r105 = (LinearLayout.LayoutParams) r104;
        r105.weight = 1.0f;
        r105.width = 0;
        removeViewInLayout(r100);
        addViewInLayout(r100, 1, r100.getLayoutParams(), true);
        this.f282971a = false;
    L7:
        super.onMeasure(r110, r111);
        if (this.f282971a == true) goto L17;
        UDButton r106 = (UDButton) findViewWithTag("primary");
        UDButton r107 = (UDButton) findViewWithTag("secondary");
        if (ny7.a.a(r106) == false) goto L12;
    L13:
        UDButton r108 = (UDButton) findViewWithTag("primary");
        UDButton r109 = (UDButton) findViewWithTag("secondary");
        setOrientation(1);
        ViewGroup.LayoutParams r112 = r108.getLayoutParams();
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r113 = (LinearLayout.LayoutParams) r112;
        r113.weight = 0.0f;
        r113.width = -1;
        ViewGroup.LayoutParams r114 = r109.getLayoutParams();
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r115 = (LinearLayout.LayoutParams) r114;
        r115.weight = 0.0f;
        r115.width = -1;
        removeViewInLayout(r109);
        addViewInLayout(r109, 1, r109.getLayoutParams(), true);
    L14:
        this.f282971a = true;
        super.onMeasure(r110, r111);
        return;
    L12:
        if (ny7.a.a(r107) == false) goto L14;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "params");
        if ((r100 instanceof UDButton) == false) goto L11;
        List<String> r103 = f282970c;
        if (CollectionsKt.contains(r103, ((UDButton) r100).getTag()) == false) goto L9;
        super.addView(r100, r101, r102);
        return;
    L9:
        throw new IllegalArgumentException(("Child View must has one of " + r103 + " tag").toString());
    L11:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
