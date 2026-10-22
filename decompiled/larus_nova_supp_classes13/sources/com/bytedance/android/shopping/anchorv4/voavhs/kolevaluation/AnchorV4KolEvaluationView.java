package com.bytedance.android.shopping.anchorv4.voavhs.kolevaluation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.KolGridComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.LongContentLabelComponentView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4KolEvaluationView extends LinearLayout {
    public final LongContentLabelComponentView a;
    public final KolGridComponentView b;
    public final LinearLayout c;
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b d;

    public AnchorV4KolEvaluationView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorV4KolEvaluationView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public AnchorV4KolEvaluationView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b r5 = new com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b(this);
        this.d = r5;
        View r6 = th.a.c(r2, 2131560611, this, true);
        this.a = (LongContentLabelComponentView) r6.findViewById(2131362828);
        this.b = (KolGridComponentView) r6.findViewById(2131362826);
        this.c = (LinearLayout) r6.findViewById(2131362827);
        r5.f(new Radius(8, 8, 8, 8));
        setBackgroundColor(-1);
    }

    public /* synthetic */ AnchorV4KolEvaluationView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
