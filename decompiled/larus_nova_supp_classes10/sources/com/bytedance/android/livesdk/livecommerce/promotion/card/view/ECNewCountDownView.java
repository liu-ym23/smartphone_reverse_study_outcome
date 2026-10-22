package com.bytedance.android.livesdk.livecommerce.promotion.card.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/view/ECNewCountDownView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECNewCountDownView extends AppCompatTextView {
    public ECNewCountDownView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECNewCountDownView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public ECNewCountDownView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ ECNewCountDownView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void x(ECNewCountDownView r6, long r7, String r9, int r10) {
        if ((r10 & 2) == 0) goto L5;
        String r0 = "";
    L7:
        if ((r10 & 4) == 0) goto L9;
        r9 = "";
    L9:
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "prefix");
        Intrinsics.checkNotNullParameter(r9, "extraText");
        double r8 = r7;
        if (r8 <= 0) goto L12;
        int r2 = (int) (r8 / ((double) 3600000));
        double r11 = r8 - ((double) (3600000 * r2));
        int r3 = (int) (r11 / ((double) 60000));
        int r12 = (int) ((r11 - ((double) (60000 * r3))) / ((double) 1000));
    L13:
        r6.setText(r0 + r6.getContext().getString(2131896692, new Object[]{Integer.valueOf(r2)}) + ':' + r6.getContext().getString(2131896692, new Object[]{Integer.valueOf(r3)}) + ':' + r6.getContext().getString(2131896692, new Object[]{Integer.valueOf(r12)}) + r9);
        return;
    L12:
        r12 = 0;
        r2 = 0;
        r3 = 0;
        goto L13
    L5:
        r0 = null;
        goto L7
    }
}
