package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import android.widget.ImageView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class z<T> implements Consumer {
    public final /* synthetic */ KtvMvControlAreaWidget a;

    public z(KtvMvControlAreaWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        if (((Boolean) r3).booleanValue() == false) goto L11;
        ImageView r4 = this.a.k;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerToneBtn");
    L7:
        r4.setAlpha(1.0f);
        ImageView r5 = this.a.k;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerToneBtn");
    L10:
        r5.setClickable(true);
        return;
    L11:
        ImageView r6 = this.a.k;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerToneBtn");
    L14:
        r6.setAlpha(0.5f);
        ImageView r7 = this.a.k;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerToneBtn");
    L17:
        r7.setClickable(false);
    }
}
