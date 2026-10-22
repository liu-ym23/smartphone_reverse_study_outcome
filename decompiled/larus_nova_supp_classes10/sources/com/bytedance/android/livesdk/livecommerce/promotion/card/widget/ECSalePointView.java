package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.response.ECCarouselData;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001d\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0006\u0010\nB%\b\u0016\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/widget/ECSalePointView;", "Landroid/widget/LinearLayout;", "Landroid/view/View;", "getLine", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSalePointView extends LinearLayout {
    public final TextView a;
    public final View b;
    public final TextView c;
    public boolean d;

    private final View getLine() {
        View r0 = new View(getContext());
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.d(Double.valueOf(0.5d)), UtilityKotlinExtentionsKt.d(8));
        r1.leftMargin = UtilityKotlinExtentionsKt.d(3);
        r1.rightMargin = UtilityKotlinExtentionsKt.d(Double.valueOf(3.5d));
        r1.gravity = 16;
        r0.setLayoutParams(r1);
        r0.setBackgroundColor(th.a.a(getContext(), 2131106090));
        r0.setVisibility(8);
        return r0;
    }

    public ECSalePointView(Context r3) {
        super(r3);
        setOrientation(0);
        TextView r4 = b(getContext());
        this.a = r4;
        View r0 = getLine();
        this.b = r0;
        TextView r1 = b(getContext());
        this.c = r1;
        addView(r4);
        addView(r0);
        addView(r1);
    }

    public static TextView b(Context r3) {
        TextView r0 = new TextView(r3);
        r0.setTextSize(1, 12.0f);
        r0.setTextColor(th.a.a(r3, 2131106040));
        r0.setEllipsize(TextUtils.TruncateAt.END);
        r0.setMaxLines(1);
        return r0;
    }

    public final void a(ECCarouselData r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        if (this.d == false) goto L5;
        this.a.setTextColor(th.a.a(getContext(), 2131106228));
        this.c.setTextColor(th.a.a(getContext(), 2131106228));
        this.b.setBackgroundColor(th.a.a(getContext(), 2131106189));
    L6:
        String r0 = r6.getBefore();
        String r2 = null;
        if (cg4.a.a(r0) == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L13;
        this.a.setVisibility(0);
        this.a.setText(r0);
    L15:
        if (cg4.a.a(r6.getBefore()) == true) goto L17;
    L19:
        this.b.setVisibility(8);
    L20:
        String r1 = r6.getContent();
        if (cg4.a.a(r1) == false) goto L23;
        r2 = r1;
    L23:
        if (r2 == null) goto L27;
        this.c.setVisibility(0);
        this.c.setText(r2);
        int r3 = s.a;
        Integer r7 = s.b(r6.getColor());
        if (r7 == null) goto L29;
        this.c.setTextColor(r7.intValue());
        return;
    L29:
        return;
    L27:
        this.c.setVisibility(8);
        Unit r8 = Unit.INSTANCE;
        return;
    L17:
        if (cg4.a.a(r6.getContent()) == false) goto L19;
        this.b.setVisibility(0);
        goto L20
    L13:
        this.a.setVisibility(8);
        Unit r4 = Unit.INSTANCE;
        goto L15
    L5:
        this.a.setTextColor(th.a.a(getContext(), 2131106040));
        this.c.setTextColor(th.a.a(getContext(), 2131106040));
        this.b.setBackgroundColor(th.a.a(getContext(), 2131106090));
        goto L6
    }

    public ECSalePointView(Context r2, AttributeSet r3) {
        super(r2, r3);
        setOrientation(0);
        TextView r4 = b(getContext());
        this.a = r4;
        View r5 = getLine();
        this.b = r5;
        TextView r0 = b(getContext());
        this.c = r0;
        addView(r4);
        addView(r5);
        addView(r0);
    }

    public ECSalePointView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setOrientation(0);
        TextView r4 = b(getContext());
        this.a = r4;
        View r5 = getLine();
        this.b = r5;
        TextView r6 = b(getContext());
        this.c = r6;
        addView(r4);
        addView(r5);
        addView(r6);
    }
}
