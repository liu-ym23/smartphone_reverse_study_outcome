package com.bytedance.android.livesdk.livecommerce.intro.card.widget.secondframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/secondframe/PropertyItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PropertyItemView extends ConstraintLayout {
    public final TextView a;
    public final TextView b;
    public final ImageView c;

    public PropertyItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PropertyItemView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void onMeasure(int r1, int r2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PropertyItemView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        th.a.c(r2, 2131560757, this, true);
        setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        this.a = (TextView) findViewById(2131391209);
        this.b = (TextView) findViewById(2131391208);
        this.c = (ImageView) findViewById(2131376182);
    }

    public /* synthetic */ PropertyItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
