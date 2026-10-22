package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/NumberScrollViewFlipper;", "Landroid/widget/ViewFlipper;", "", "colorString", "", "setTextColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class NumberScrollViewFlipper extends ViewFlipper {
    public String a;
    public final List<TextView> b;

    public static final class a implements Runnable {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public NumberScrollViewFlipper(Context r2) {
        this(r2, null);
    }

    public final void setTextColor(String r4) {
        Intrinsics.checkNotNullParameter(r4, "colorString");
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((TextView) r0.next()).setTextColor(ColorProtector.parseColor(r4));
        goto L4
    }

    public NumberScrollViewFlipper(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        this.a = BDLocationException.ERROR_TIMEOUT;
        this.b = new ArrayList();
        int r6 = 0;
    L4:
        if (r6 >= 2) goto L6;
        TextView r0 = new TextView(r4);
        r0.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        r0.setGravity(17);
        com.bytedance.android.live.core.utils.a1.j(r0, 17);
        r0.setTextSize(10.0f);
        r0.setTextAlignment(4);
        r0.setTextColor(ColorProtector.parseColor("#ffffff"));
        addView(r0);
        this.b.add(r0);
        r6 = r6 + 1;
        goto L4
    }

    public final void a(String r4, boolean r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "number");
        Intrinsics.checkNotNullParameter(r6, "onAnimationEnd");
        if (Intrinsics.areEqual(r4, this.a) == false) goto L7;
        r6.invoke();
        return;
    L7:
        if (Intrinsics.areEqual(r4, "1") == false) goto L12;
        Iterator r1 = ((ArrayList) this.b).iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        ((TextView) r1.next()).setText("1");
    L12:
        List<TextView> r0 = this.b;
        if (getDisplayedChild() != 0) goto L15;
        int r2 = 1;
    L16:
        TextView r3 = (TextView) ListProtector.get(r0, r2);
        r3.setText(r4);
        if (r5 == false) goto L19;
        setInAnimation(getContext(), 2130772626);
        setOutAnimation(getContext(), 2130772642);
        showNext();
        postDelayed(new a(r6), 600);
    L20:
        this.a = r4;
        return;
    L19:
        setInAnimation(null);
        setOutAnimation(null);
        setDisplayedChild(((ArrayList) this.b).indexOf(r3));
        r6.invoke();
        goto L20
    L15:
        r2 = 0;
        goto L16
    }
}
