package com.bytedance.android.shopping.feed.widget.gesture;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.bytedance.android.ui.base.widget.round.RoundLinearLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends RoundLinearLayout {
    public final Lazy a;
    public final Lazy b;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.feed.widget.gesture.b$b, reason: collision with other inner class name */
    public interface InterfaceC0070b {
        void onAnimationCancel();

        void onAnimationEnd();
    }

    static {
    }

    public b(Context r3) {
        this(r3, null, 14);
    }

    private final TextView getLongPressDescView() {
        return (TextView) this.b.getValue();
    }

    private final LottieAnimationView getLottieView() {
        return (LottieAnimationView) this.a.getValue();
    }

    public static final /* synthetic */ LottieAnimationView a(b r0) {
        return r0.getLottieView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(final Context r3, final com.bytedance.android.shopping.feed.widget.b r4, int r5) {
        BackgroundDrawable r0 = null;
        if ((r5 & 2) == 0) goto L5;
        r4 = null;
    L5:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, null, 0);
        this.a = LazyKt.lazy(new GestureView$lottieView$2(this, r3, r4));
        this.b = LazyKt.lazy(new GestureView$longPressDescView$2(r3));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setOrientation(1);
        ViewExtensionsKt.g(this, 16.0f, 16.0f, 16.0f, 16.0f);
        setGravity(17);
        addView(getLottieView());
        addView(getLongPressDescView());
        int r6 = ContextCompat.getColor(r3, 2131101765);
        BackgroundDrawable r7 = getBackground();
        if ((r7 instanceof BackgroundDrawable) == false) goto L9;
        r0 = r7;
    L9:
        BackgroundDrawable r1 = r0;
        if (r1 == null) goto L14;
        BackgroundDrawable r8 = r1.setBgColor(r6);
        if (r8 == null) goto L14;
        r8.invalidate();
    L14:
        new Handler(Looper.getMainLooper()).postDelayed(new com.bytedance.android.shopping.feed.widget.gesture.a(this), 3000);
    }
}
