package com.bytedance.android.livesdk.livecommerce.promotionlist.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.livesdk.livecommerce.promotionlist.model.ToggleElement;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/widget/LivePromotionListTopTabView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePromotionListTopTabView extends ConstraintLayout {
    public final ECDraweeView a;
    public final TextView b;

    public static final class a {
    }

    static {
    }

    public LivePromotionListTopTabView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LivePromotionListTopTabView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void R5(ToggleElement r10) {
        Intrinsics.checkNotNullParameter(r10, "element");
        h0.d(this.a, r10.getIcon(), new r("ec_live", "promotion_list_header_store_avatar"), null, null, null, null, 120);
        this.b.setText(r10.getText());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(boolean r3) {
        if (r3 == false) goto L4;
        this.b.setTextColor(th.a.a(getContext(), 2131106066));
        return;
    L4:
        this.b.setTextColor(th.a.a(getContext(), 2131106226));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LivePromotionListTopTabView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View r5 = th.a.c(r2, 2131564729, this, true);
        this.a = r5.findViewById(2131376019);
        this.b = (TextView) r5.findViewById(2131390975);
        int r6 = UtilityKotlinExtentionsKt.d(Float.valueOf(5.0f));
        setPadding(r6, r6, r6, r6);
    }

    public /* synthetic */ LivePromotionListTopTabView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
