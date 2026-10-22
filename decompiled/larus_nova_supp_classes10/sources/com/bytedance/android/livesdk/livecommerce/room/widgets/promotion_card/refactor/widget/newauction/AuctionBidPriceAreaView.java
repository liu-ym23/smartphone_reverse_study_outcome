package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget.newauction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.response.ECAuctionInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/refactor/widget/newauction/AuctionBidPriceAreaView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AuctionBidPriceAreaView extends ConstraintLayout {
    public static final /* synthetic */ int g = 0;
    public final PriceView a;
    public final ConstraintLayout b;
    public final PriceView c;
    public final ConstraintLayout d;
    public final Lazy<a<Long>> e;
    public final Lazy<a<ECAuctionInfo>> f;

    public AuctionBidPriceAreaView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AuctionBidPriceAreaView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AuctionBidPriceAreaView(final Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        LayoutInflater.from(r3).inflate(2131560385, this, true);
        ConstraintLayout r6 = (AuctionBidPriceItemView) findViewById(2131363361);
        ConstraintLayout r7 = (AuctionBidPriceItemView) findViewById(2131363362);
        this.a = r7.findViewById(2131391147);
        this.b = r7.findViewById(2131377441);
        this.c = r6.findViewById(2131391147);
        this.d = r6.findViewById(2131377441);
        this.e = LazyKt.lazy(new AnonymousClass1(this));
        this.f = LazyKt.lazy(new AnonymousClass2(this, r3));
    }

    public /* synthetic */ AuctionBidPriceAreaView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
