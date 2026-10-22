package com.bytedance.android.shopping.anchorv4.voavhs.offerrecord;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/offerrecord/AnchorV4OfferRecordsView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4OfferRecordsView extends LinearLayout {
    public final b a;

    public AnchorV4OfferRecordsView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorV4OfferRecordsView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.View
    public final void draw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        this.a.e(r2);
        super.draw(r2);
        this.a.d(r2);
    }

    public AnchorV4OfferRecordsView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        b r6 = new b(this);
        this.a = r6;
        setOrientation(1);
        setBackgroundColor(-1);
        setPadding(com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12));
        r6.f(new Radius(8, 8, 8, 8));
    }

    public /* synthetic */ AnchorV4OfferRecordsView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.a.c(r1, r2);
    }
}
