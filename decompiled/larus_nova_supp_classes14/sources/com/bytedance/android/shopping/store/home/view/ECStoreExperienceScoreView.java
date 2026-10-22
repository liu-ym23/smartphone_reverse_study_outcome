package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/ECStoreExperienceScoreView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreExperienceScoreView extends LinearLayout {
    public final LinearLayout a;
    public final TextView b;
    public final ImageView c;

    public ECStoreExperienceScoreView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECStoreExperienceScoreView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Type inference failed for: r8v4, types: [android.widget.ImageView, com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView, com.facebook.drawee.view.GenericDraweeView] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    public final ECDraweeView a(ECUrlModel r7, ECStoreViewModel r8) {
        ECDraweeView r9 = (ECDraweeView) r8.getMultiLeveViewCache().a(ECDraweeView.class, new ECStoreExperienceScoreView$createStarView$1(this));
        ?? r10 = r9;
        if (r9 != null) goto L5;
        r10 = new ECDraweeView(getContext(), null, 0, 6, null);
    L5:
        r10.setLayoutParams(new LinearLayout.LayoutParams(0, r10.getDp(14)));
        r10.setAdjustMode(1);
        com.bytedance.android.ec.core.utils.y.a(r10, r7);
        return r10;
    }

    public ECStoreExperienceScoreView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LinearLayout.inflate(r2, 2131560934, this);
        LinearLayout r5 = (LinearLayout) findViewById(2131372895);
        this.a = r5;
        TextView r6 = (TextView) findViewById(2131372897);
        this.b = r6;
        this.c = (ImageView) findViewById(2131372896);
        com.bytedance.android.shopping.extensions.f.d(r5, com.bytedance.android.shopping.extensions.b.b(1), 2);
        ViewExtensionsKt.h(r6, 13);
    }

    public /* synthetic */ ECStoreExperienceScoreView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
