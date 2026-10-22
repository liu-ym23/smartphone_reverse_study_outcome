package com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.cell;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.bitable.databinding.BitableNativeViewCommonFieldCellLayoutBinding;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseCellData;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.util.ui.n;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import gv4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\"B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u000fJ\u0016\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0019J\u0018\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0019H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/uikit/cell/CommonFieldCellView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseCellData;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableNativeViewCommonFieldCellLayoutBinding;", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", DyPayConstant.KEY_SHOW_LOADING, "hideLoading", "setLayoutOrientation", "horizontal", "", "horizontalCellWeight", "", "setCellEmptyValueVisible", "visible", "setCellLoadingPercent", "percent", "updateWeight", "view", "Landroid/view/View;", "weight", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonFieldCellView extends FrameLayout implements b<BaseCellData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableNativeViewCommonFieldCellLayoutBinding f213391a;

    public static final class a {
    }

    static {
    }

    public CommonFieldCellView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommonFieldCellView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setCellEmptyValueVisible(boolean r100) {
        BitableNativeViewCommonFieldCellLayoutBinding r101 = this.f213391a;
        if (r101 == null) goto L8;
        CommonCellView r102 = r101.f210973c;
        if (r102 == null) goto L9;
        r102.setEmptyValueVisible(r100);
        return;
    L9:
        return;
    }

    public final void setCellLoadingPercent(float r100) {
        BitableNativeViewCommonFieldCellLayoutBinding r101 = this.f213391a;
        if (r101 == null) goto L8;
        CommonLoadingView r102 = r101.f210972b;
        if (r102 == null) goto L9;
        r102.setLoadingWidthPercent(r100);
        return;
    L9:
        return;
    }

    public static void b(View r100, float r101) {
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r103 = (LinearLayout.LayoutParams) r102;
        if (((int) r101) != 0) goto L5;
        int r104 = -1;
    L6:
        r103.width = r104;
        r103.weight = r101;
        r100.setLayoutParams(r103);
        return;
    L5:
        r104 = 0;
        goto L6
    }

    public final void a(boolean r100, float r101) {
        BitableNativeViewCommonFieldCellLayoutBinding r102 = this.f213391a;
        if (r102 != null) goto L5;
        return;
    L5:
        LinearLayout r103 = r102.f210975e;
        if (r100 == false) goto L12;
        b(r102.f210977g, 1.0f);
        b(r102.f210974d, r101);
        m.e(r102.f210975e, n.d(26));
        View r104 = r102.f210979i;
        int r105 = 0;
        if (((int) r101) != 0) goto L10;
        int r106 = 8;
    L11:
        r104.setVisibility(r106);
    L13:
        r103.setOrientation(r105);
        return;
    L10:
        r106 = 0;
        goto L11
    L12:
        b(r102.f210977g, 0.0f);
        b(r102.f210974d, 0.0f);
        m.e(r102.f210975e, -2);
        r105 = 1;
        goto L13
    }

    public CommonFieldCellView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f213391a = BitableNativeViewCommonFieldCellLayoutBinding.a(LayoutInflater.from(r100), this);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.e("CommonFieldCellView", "CommonFieldCellView init failed", e, false);
    }

    public /* synthetic */ CommonFieldCellView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
