package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.view.ECRoundedLinearLayout;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/refactor/widget/CombinationView;", "Lcom/bytedance/android/livesdk/livecommerce/view/ECRoundedLinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CombinationView extends ECRoundedLinearLayout {
    public final List<ECNetImageView> b;
    public int c;
    public final int d;
    public final ECDraweeView e;

    public CombinationView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CombinationView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public CombinationView(Context r12, AttributeSet r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, r14);
        this.b = new ArrayList();
        setOrientation(0);
        setBackgroundResource(2131234255);
        ImageView r15 = new ImageView(r12);
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams((int) UtilityKotlinExtentionsKt.c(12), (int) UtilityKotlinExtentionsKt.c(24));
        r0.setMargins((int) UtilityKotlinExtentionsKt.c(5), (int) UtilityKotlinExtentionsKt.c(2), 0, (int) UtilityKotlinExtentionsKt.c(3));
        r15.setImageResource(2131234548);
        Unit r16 = Unit.INSTANCE;
        r15.setLayoutParams(r0);
        addView(r15);
        int r17 = getChildCount();
        this.c = r17;
        this.d = r17;
        ECDraweeView r18 = new ECDraweeView(r12, null, 0, 6, null);
        LinearLayout.LayoutParams r19 = new LinearLayout.LayoutParams(r18.getDp(4), r18.getDp(7));
        r19.setMargins(r18.getDp(1), r18.getDp(12), r18.getDp(3), r18.getDp(10));
        r18.setImageResource(2131234549);
        r18.setLayoutParams(r19);
        this.e = r18;
        addView(r18);
    }

    public /* synthetic */ CombinationView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
