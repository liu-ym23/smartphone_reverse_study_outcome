package com.bytedance.android.livesdk.livecommerce.iron.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/ui/ECCustomizedCountDownView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCustomizedCountDownView extends AppCompatTextView {
    public String a;

    public ECCustomizedCountDownView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECCustomizedCountDownView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(long r8) {
        if (r8 >= 86400000) goto L11;
        double r9 = r8;
        if (r9 <= 0) goto L7;
        int r1 = (int) (r9 / ((double) 3600000));
        double r10 = r9 - ((double) (3600000 * r1));
        int r2 = (int) (r10 / ((double) 60000));
        int r11 = (int) ((r10 - ((double) (60000 * r2))) / ((double) 1000));
    L8:
        String r12 = getContext().getString(2131896692, new Object[]{Integer.valueOf(r1)}) + ':' + getContext().getString(2131896692, new Object[]{Integer.valueOf(r2)}) + ':' + getContext().getString(2131896692, new Object[]{Integer.valueOf(r11)});
        if ((!Intrinsics.areEqual(this.a, r12)) == false) goto L15;
        this.a = r12;
        setText(r12);
        return;
    L15:
        return;
    L7:
        r11 = 0;
        r1 = 0;
        r2 = 0;
        goto L8
    L11:
        String r13 = getContext().getString(2131896560, new Object[]{Integer.valueOf((int) (r8 / ((double) 86400000)))});
        if ((!Intrinsics.areEqual(this.a, r13)) == false) goto L17;
        this.a = r13;
        setText(r13);
        return;
    }

    public ECCustomizedCountDownView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ ECCustomizedCountDownView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
