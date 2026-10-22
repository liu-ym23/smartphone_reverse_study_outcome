package com.bytedance.android.shopping.feed.resourcecard.view.countdownview;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.ActivityCountDownTimer;
import com.bytedance.android.ec.core.utils.l1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0006B%\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003¢\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H&R$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR\u001b\u0010\u001a\u001a\u00020\u00158DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/countdownview/BaseCountDownView;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "", "", "getLayout", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "getTvHours", "()Landroid/widget/TextView;", "setTvHours", "(Landroid/widget/TextView;)V", "tvHours", "b", "getTvMins", "setTvMins", "tvMins", "c", "getTvSecs", "setTvSecs", "tvSecs", "Lcom/bytedance/android/ec/core/utils/ActivityCountDownTimer;", "d", "Lkotlin/Lazy;", "getCountDownTimer", "()Lcom/bytedance/android/ec/core/utils/ActivityCountDownTimer;", "countDownTimer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseCountDownView extends LinearLayoutCompat {
    public TextView a;
    public TextView b;
    public TextView c;
    public final Lazy d;
    public Long e;
    public com.bytedance.android.shopping.feed.resourcecard.view.countdownview.a f;
    public final b g;

    public static final class a {
    }

    public static final class b implements l1.a {
        public final /* synthetic */ BaseCountDownView a;

        public final void onStart() {
        }

        public final void onFinish() {
            com.bytedance.android.shopping.feed.resourcecard.view.countdownview.a r0 = this.a.f;
            if (r0 == null) goto L6;
            r0.a();
            return;
        }

        public b(BaseCountDownView r1) {
            this.a = r1;
        }

        public final void onTick(long r2) {
            this.a.e(r2);
        }
    }

    static {
    }

    public final ActivityCountDownTimer getCountDownTimer() {
        return (ActivityCountDownTimer) this.d.getValue();
    }

    public abstract int getLayout();

    public final void d() {
        Long r0 = this.e;
        if (r0 == null) goto L6;
        long r1 = r0.longValue();
        ActivityCountDownTimer.b(getCountDownTimer(), SystemClock.elapsedRealtime() / 1000, (SystemClock.elapsedRealtime() / 1000) + r1, this.g);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        getCountDownTimer().c();
    }

    public final TextView getTvHours() {
        return this.a;
    }

    public final TextView getTvMins() {
        return this.b;
    }

    public final TextView getTvSecs() {
        return this.c;
    }

    public void e(long r8) {
        long r9 = r8 / 1000;
        if (r9 <= 0) goto L14;
        TextView r0 = this.a;
        if (r0 == null) goto L7;
        r0.setText(String.valueOf(r9 / ((long) 3600)));
    L7:
        TextView r1 = this.b;
        if (r1 == null) goto L10;
        r1.setText(String.valueOf((r9 % ((long) 3600)) / ((long) 60)));
    L10:
        TextView r2 = this.c;
        if (r2 == null) goto L15;
        r2.setText(String.valueOf((r9 % ((long) 3600)) % ((long) 60)));
        return;
    L15:
        return;
    }

    public final void setTvHours(TextView r1) {
        this.a = r1;
    }

    public final void setTvMins(TextView r1) {
        this.b = r1;
    }

    public final void setTvSecs(TextView r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseCountDownView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = LazyKt.lazy(BaseCountDownView$countDownTimer$2.INSTANCE);
        this.g = new b(this);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(getLayout(), this, true);
        this.a = (TextView) findViewById(2131390757);
        this.b = (TextView) findViewById(2131390956);
        this.c = (TextView) findViewById(2131391371);
    }
}
