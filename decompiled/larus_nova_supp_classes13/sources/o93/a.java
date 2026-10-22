package o93;

import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final LottieAnimationView a;
    public final View b;
    public final View c;
    public final View d;

    public a(ViewGroup r4, com.bytedance.android.shopping.mall.homepage.card.loadview.a r5) {
        Intrinsics.checkNotNullParameter(r4, "container");
        Intrinsics.checkNotNullParameter(r5, "retryClickListener");
        View r6 = LayoutInflater.from(r4.getContext()).inflate(2131560789, r4, false);
        this.a = r6.findViewById(2131379257);
        this.b = r6.findViewById(2131378690);
        this.c = r6.findViewById(2131378689);
        Button r0 = (Button) r6.findViewById(2131364597);
        if (r0 == null) goto L8;
        r0.setOnClickListener(r5);
        TextPaint r7 = r0.getPaint();
        if (r7 == null) goto L7;
        r7.setFakeBoldText(true);
    L7:
        Unit r8 = Unit.INSTANCE;
    L8:
        Unit r9 = Unit.INSTANCE;
        this.d = r6;
    }
}
