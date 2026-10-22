package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.model.response.anchorv3.ProductLeaderBoardEntryStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductAuthorEntriesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCommentsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/SellPointView;", "Lcom/bytedance/android/shopping/feed/widget/OneRowLinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SellPointView extends OneRowLinearLayout {
    public SellPointView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SellPointView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(PromotionProductStruct r8) {
        Intrinsics.checkNotNullParameter(r8, "promotion");
        removeAllViews();
        PromotionProductAuthorEntriesStruct r0 = r8.getEntryInfo();
        if (r0 == null) goto L14;
        ProductLeaderBoardEntryStruct r1 = r0.getLeaderBoardEntry();
        if (r1 == null) goto L14;
        Integer r4 = r1.getRank();
        if (r4 != null) goto L9;
    L11:
        String r2 = r1.getContent();
    L12:
        if (r2 == null) goto L14;
        int r5 = g1.a;
        addView(b(r2, g1.a.a(getContext(), 2131101203), null, false));
        goto L14
    L9:
        if (r4.intValue() <= 0) goto L11;
        r2 = th.a.h(getContext(), 2131895890, new Object[]{r1.getContent(), String.valueOf(r1.getRank())});
    L14:
        PromotionProductCommentsStruct r9 = r8.getCommentInfo();
        if (r9 == null) goto L28;
        String r10 = r9.getGoodRatio();
        if (r10 == null) goto L29;
        Integer r11 = Integer.valueOf((int) CastDoubleProtector.parseDouble(r10));
        if (r11.intValue() <= 0) goto L21;
        boolean r3 = true;
    L22:
        if (r3 == true) goto L25;
        r11 = null;
    L25:
        if (r11 == null) goto L30;
        String r12 = th.a.h(getContext(), 2131895854, new Object[]{Integer.valueOf(r11.intValue())});
        int r6 = g1.a;
        addView(b(r12, g1.a.a(getContext(), 2131106061), null, false));
        return;
    L30:
        return;
    L21:
        r3 = false;
        goto L22
    L29:
        return;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r5) {
        if (getChildCount() <= 0) goto L6;
        if (r5 == null) goto L6;
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, -1);
        Resources r2 = Resources.getSystem();
        r0.setMargins(MathKt.roundToInt(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()))), 0, 0, 0);
        Unit r1 = Unit.INSTANCE;
        r5.setLayoutParams(r0);
    L6:
        super.addView(r5);
    }

    public SellPointView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ SellPointView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.widget.TextView, com.bytedance.android.shopping.feed.widget.SellPointItemView] */
    public final SellPointItemView b(String r6, int r7, Integer r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r6, "content");
        ?? r0 = new SellPointItemView(getContext(), null, 6, 0);
        r0.setBorderAndTextColor(r7);
        if (r8 == null) goto L5;
        r8.intValue();
        r0.setBorderColor(r8.intValue());
    L5:
        if (r9 == false) goto L7;
        float r10 = 4;
        Resources r11 = Resources.getSystem();
        int r12 = MathKt.roundToInt(TypedValue.applyDimension(1, r10, WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics())));
        float r1 = 0;
        Resources r2 = Resources.getSystem();
        int r3 = MathKt.roundToInt(TypedValue.applyDimension(1, r1, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics())));
        Resources r4 = Resources.getSystem();
        int r13 = MathKt.roundToInt(TypedValue.applyDimension(1, r10, WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics())));
        Resources r5 = Resources.getSystem();
        r0.setPadding(r12, r3, r13, MathKt.roundToInt(TypedValue.applyDimension(1, r1, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()))));
    L7:
        r0.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        r0.setText(r6);
        return r0;
    }
}
