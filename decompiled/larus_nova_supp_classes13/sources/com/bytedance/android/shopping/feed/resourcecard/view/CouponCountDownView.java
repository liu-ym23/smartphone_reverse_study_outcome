package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.ActivityCountDownTimer;
import com.bytedance.android.ec.core.utils.l1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/CouponCountDownView;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponCountDownView extends LinearLayoutCompat {
    public static final /* synthetic */ int g = 0;
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public ActivityCountDownTimer d;
    public final b e;
    public Function0<Unit> f;

    public static final class a {
    }

    public static final class b implements l1.a {
        public final /* synthetic */ CouponCountDownView a;

        public final void onStart() {
        }

        public final void onFinish() {
            CouponCountDownView r0 = this.a;
            int r1 = CouponCountDownView.g;
            r0.d(0);
            Function0<Unit> r2 = this.a.f;
            if (r2 == null) goto L6;
            Unit r3 = (Unit) r2.invoke();
            return;
        }

        public b(CouponCountDownView r1) {
            this.a = r1;
        }

        public final void onTick(long r3) {
            CouponCountDownView r0 = this.a;
            int r1 = CouponCountDownView.g;
            r0.d(r3);
        }
    }

    static {
    }

    public CouponCountDownView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CouponCountDownView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(long r8) {
        double r9 = r8;
        if (r9 <= 0) goto L5;
        int r2 = (int) (r9 / ((double) 3600000));
        double r10 = r9 - ((double) (3600000 * r2));
        int r3 = (int) (r10 / ((double) 60000));
        int r11 = (int) ((r10 - ((double) (60000 * r3))) / ((double) 1000));
    L6:
        TextView r12 = this.a;
        if (r12 == null) goto L9;
        r12.setText(getContext().getString(2131896692, new Object[]{Integer.valueOf(r2)}));
    L9:
        TextView r13 = this.b;
        if (r13 == null) goto L12;
        r13.setText(getContext().getString(2131896692, new Object[]{Integer.valueOf(r3)}));
    L12:
        TextView r14 = this.c;
        if (r14 == null) goto L16;
        r14.setText(getContext().getString(2131896692, new Object[]{Integer.valueOf(r11)}));
        return;
    L16:
        return;
    L5:
        r11 = 0;
        r2 = 0;
        r3 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CouponCountDownView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560556, this, true);
        this.a = (TextView) findViewById(2131390757);
        this.b = (TextView) findViewById(2131390956);
        this.c = (TextView) findViewById(2131391371);
        this.e = new b(this);
    }

    public /* synthetic */ CouponCountDownView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
