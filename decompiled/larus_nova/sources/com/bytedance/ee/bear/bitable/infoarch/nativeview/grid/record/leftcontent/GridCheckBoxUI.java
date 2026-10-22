package com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.record.leftcontent;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridSelectInfo;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.ss.android.lark.utils.statistics.PerfLog;
import gv4.b;
import ht4.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/record/leftcontent/GridCheckBoxUI;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridSelectInfo;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "checkBox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "checkBoxGroup", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GridCheckBoxUI extends FrameLayout implements b<GridSelectInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UDCheckBox f213618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f213619b;

    public GridCheckBoxUI(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public GridCheckBoxUI(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        UDCheckBox r102 = new UDCheckBox(r100);
        r102.setPadding(0, 0, 0, 0);
        this.f213618a = r102;
        r102.setClickable(false);
        r102.setLongClickable(false);
        FrameLayout r103 = new FrameLayout(r100);
        this.f213619b = r103;
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-2, -2);
        r104.gravity = 17;
        Unit r105 = Unit.INSTANCE;
        r103.addView(r102, r104);
        int r106 = a.f487118a;
        int r107 = a.f487124g;
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(r107, r107);
        r108.gravity = 17;
        addView(r103, r108);
    }
}
