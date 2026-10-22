package com.bytedance.android.window.shop.home.presenter;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p0<T> implements Observer {
    public final /* synthetic */ ECWindowDialogStyledBackgroundPresenter a;
    public final /* synthetic */ Bitmap b;

    public p0(ECWindowDialogStyledBackgroundPresenter r1, Bitmap r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r5) {
        uq3.o r6 = ((uq3.a) r5).c;
        if (r6 != null) goto L5;
    L9:
        View r7 = this.a.w().b(2131370857).f();
        BitmapDrawable r0 = new BitmapDrawable(this.b);
        int r1 = com.bytedance.android.ec.window.base.utils.c.a;
        Intrinsics.checkNotNullParameter(r7, "$this$setBackgroundCompat");
        r7.setBackground(r0);
        Unit r8 = Unit.INSTANCE;
        return;
    L5:
        if (r6.g == null) goto L9;
        Integer r9 = r6.h;
        if (r9 == null) goto L11;
        this.a.w().b(2131370857).f().setBackgroundColor(ColorUtils.setAlphaComponent(r9.intValue(), RangesKt.coerceIn((int) (RangesKt.coerceAtMost((this.a.N() + this.a.d0().getHeight()) / RangesKt.coerceAtLeast(com.bytedance.android.ec.window.base.utils.c.a * 0.5612789f, 0.1f), 1.0f) * 255), 0, 255)));
        return;
    }
}
