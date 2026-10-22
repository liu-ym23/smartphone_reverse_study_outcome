package com.bytedance.android.livesdk.livecommerce.iron.ui.top.avatar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import th.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/top/avatar/ECPromotionListShopAvatarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionListShopAvatarView extends ConstraintLayout {
    public final ECDraweeView a;
    public final TextView b;
    public final ECDraweeView c;
    public final View d;

    public ECPromotionListShopAvatarView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECPromotionListShopAvatarView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(ECPromotionList.a r13, final Function0<Unit> r14) {
        Intrinsics.checkNotNullParameter(r13, "avatarInfo");
        this.a.setVisibility(0);
        ECDraweeView r2 = this.a;
        ECUrlModel r3 = new ECUrlModel();
        r3.setUrlList(r13.urlList);
        r3.setWidth((int) r13.width);
        r3.setHeight((int) r13.height);
        Unit r0 = Unit.INSTANCE;
        h0.d(r2, r3, new r("ec_live", "promotion_list_header_store_avatar"), null, null, null, null, 120);
        this.b.setText(r13.avatarTitle);
        this.b.setVisibility(8);
        ECUrlModel r4 = r13.browsingIcon;
        if (r4 == null) goto L7;
        h0.d(this.c, r4, new r("ec_live", "promotion_list_header_store_avatar"), null, null, null, null, 120);
        ViewGroup.LayoutParams r1 = this.c.getLayoutParams();
        if (r1 == null) goto L7;
        r1.height = UtilityKotlinExtentionsKt.d(Integer.valueOf(r4.getHeight()));
        r1.width = UtilityKotlinExtentionsKt.d(Integer.valueOf(r4.getWidth()));
    L7:
        this.c.setVisibility(8);
        String r15 = r13.borderColor;
        if (r15 == null) goto L15;
        Drawable r5 = this.d.getBackground();
        if ((r5 instanceof GradientDrawable) == true) goto L12;
        r5 = null;
    L12:
        GradientDrawable r6 = (GradientDrawable) r5;
        if (r6 == null) goto L15;
        int r7 = UtilityKotlinExtentionsKt.d(1);
        int r8 = s.a;
        r6.setStroke(r7, s.a(r15, a.a(getContext(), 2131106066)));
    L15:
        f.c(this, null, "bind_key_live_promotion_list", new ECPromotionListShopAvatarView$bindData$4$1(r14), 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECPromotionListShopAvatarView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131560771, this, true);
        ECDraweeView r5 = findViewById(2131376019);
        this.a = r5;
        TextView r6 = (TextView) findViewById(2131363741);
        this.b = r6;
        this.c = findViewById(2131363742);
        this.d = findViewById(2131376049);
        r5.setAdjustMode(2000);
        r6.setVisibility(8);
    }

    public /* synthetic */ ECPromotionListShopAvatarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
