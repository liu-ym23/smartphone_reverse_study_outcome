package com.bytedance.awemeopen.bizmodels.feed.shopping.card.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/widget/ECMultiProCardPriceContainer;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class ECMultiProCardPriceContainer extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f198200a = 0;

    public static final class a {
    }

    static {
    }

    public ECMultiProCardPriceContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECMultiProCardPriceContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        int r100 = getMeasuredWidth();
        if (r100 > 0) goto L5;
        return;
    L5:
        if (getWidth() <= 0) goto L45;
        int r101 = getChildCount();
        int r102 = 0;
        int r103 = 0;
    L8:
        if (r102 >= r101) goto L46;
        final View r104 = getChildAt(r102);
        if (r104.getVisibility() == 8) goto L37;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        final ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
    L15:
        measureChild(r104, r110, r111);
        int r107 = r104.getMeasuredWidth();
        if (r106 == null) goto L18;
        int r108 = r106.leftMargin;
    L19:
        int r109 = r107 + r108;
        if (r106 == null) goto L22;
        int r112 = r106.rightMargin;
    L23:
        int r113 = r109 + r112;
        r103 = r103 + r113;
        if (r103 > r100) goto L26;
    L29:
        if (r102 != 3) goto L37;
        if (r103 <= r100) goto L37;
        if (r106 == null) goto L37;
        int r114 = r103 - r113;
        int r115 = ((r100 - r114) - r106.leftMargin) - r106.rightMargin;
        if (r115 < r113) goto L36;
        r115 = r104.getMeasuredWidth();
    L36:
        r106.width = r115;
        r103 = ((r114 + r106.leftMargin) + r106.rightMargin) + r115;
        r104.post(new y14.a(r104, r106));
        goto L37
    L26:
        if (r102 <= 1) goto L29;
        if (r102 == 3) goto L29;
        r104.setVisibility(8);
        goto L29
    L22:
        r112 = 0;
        goto L23
    L18:
        r108 = 0;
        goto L19
    L14:
        r106 = null;
    L37:
        r102 = r102 + 1;
        goto L8
    L46:
        return;
    }

    public ECMultiProCardPriceContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
    }

    public /* synthetic */ ECMultiProCardPriceContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
