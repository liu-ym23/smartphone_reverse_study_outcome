package com.bytedance.android.livesdk.livecommerce.promotion.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.response.k;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\u000b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R#\u0010\u000e\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/view/CountDownView;", "Landroid/widget/LinearLayout;", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getHoursTextView", "()Landroid/widget/TextView;", "hoursTextView", "b", "getMinsTextView", "minsTextView", "c", "getSecTextView", "secTextView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CountDownView extends LinearLayout {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;

    public CountDownView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CountDownView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final TextView getHoursTextView() {
        return (TextView) this.a.getValue();
    }

    private final TextView getMinsTextView() {
        return (TextView) this.b.getValue();
    }

    private final TextView getSecTextView() {
        return (TextView) this.c.getValue();
    }

    public final void a(long r7) {
        double r8 = r7;
        if (r8 <= 0) goto L5;
        int r2 = (int) (r8 / ((double) 3600000));
        double r9 = r8 - ((double) (3600000 * r2));
        int r3 = (int) (r9 / ((double) 60000));
        int r10 = (int) ((r9 - ((double) (60000 * r3))) / ((double) 1000));
    L6:
        getHoursTextView().setText(getContext().getString(2131896692, new Object[]{Integer.valueOf(r2)}));
        getMinsTextView().setText(getContext().getString(2131896692, new Object[]{Integer.valueOf(r3)}));
        getSecTextView().setText(getContext().getString(2131896692, new Object[]{Integer.valueOf(r10)}));
        return;
    L5:
        r10 = 0;
        r2 = 0;
        r3 = 0;
        goto L6
    }

    public final void b(k r2) {
        Intrinsics.checkNotNullParameter(r2, "vO");
        int r0 = s.a;
        int r3 = s.a(r2.e(), -1);
        getHoursTextView().setTextColor(r3);
        getMinsTextView().setTextColor(r3);
        getSecTextView().setTextColor(r3);
        TextView r1 = (TextView) findViewById(2131390334);
        if (r1 == null) goto L5;
        r1.setTextColor(r3);
    L5:
        TextView r4 = (TextView) findViewById(2131390335);
        if (r4 == null) goto L9;
        r4.setTextColor(r3);
        return;
    }

    public final void c(IPromotionUIConfig.b r2) {
        int r0 = UIConfigHelper.a;
        UIConfigHelper.c(getHoursTextView(), r2);
        UIConfigHelper.c(getMinsTextView(), r2);
        UIConfigHelper.c(getSecTextView(), r2);
    }

    public CountDownView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new CountDownView$hoursTextView$2(this));
        this.b = LazyKt.lazy(new CountDownView$minsTextView$2(this));
        this.c = LazyKt.lazy(new CountDownView$secTextView$2(this));
        LinearLayout.inflate(r2, 2131560672, this);
        setGravity(16);
    }

    public /* synthetic */ CountDownView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
