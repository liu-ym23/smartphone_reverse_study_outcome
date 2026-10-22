package com.bytedance.android.window.shop.holder.presenter;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ WindowHotsaleLiveOrderItemPresenter a;

    public u(WindowHotsaleLiveOrderItemPresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        List<com.bytedance.android.window.shop.repository.dto.c> r10 = ((WindowTabDataListResponseDTODeprecated) r9).getMixFullCards();
        if (r10 == null) goto L45;
        Iterator<T> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L63;
        com.bytedance.android.window.shop.repository.dto.c r0 = (com.bytedance.android.window.shop.repository.dto.c) r11.next();
        Integer r1 = r0.c();
        if (r1 == null) goto L6;
        if (r1.intValue() != 301) goto L6;
        com.bytedance.android.window.shop.repository.dto.h r2 = (com.bytedance.android.window.shop.repository.dto.h) r0.b(com.bytedance.android.window.shop.repository.dto.h.class);
        Integer r3 = null;
        if (r2 == null) goto L16;
        Long r4 = r2.a();
    L17:
        sq3.g r5 = this.a.i;
        if (r5 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mVO");
    L21:
        if ((!Intrinsics.areEqual(r4, r5.k)) == true) goto L6;
        if (r2 == null) goto L25;
        Integer r6 = r2.c();
    L27:
        if (r6 == null) goto L35;
        if (r6.intValue() != 1) goto L35;
        TextView r7 = (TextView) this.a.Z().b(2131391046).f();
        r7.setText(ag4.a.d(2131896743));
        r7.setTextColor(ColorProtector.parseColor("#80161823"));
        ((LinearLayout) this.a.Z().b(2131374550).f()).setBackgroundResource(2131247923);
        this.a.Z().b(2131363242).f().setBackgroundResource(2131234720);
        sq3.g r8 = this.a.i;
        if (r8 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mVO");
    L34:
        r8.l = 1;
    L35:
        if (r2 == null) goto L37;
        r3 = r2.c();
    L37:
        if (r3 == null) goto L6;
        if (r3.intValue() != 2) goto L6;
        TextView r12 = (TextView) this.a.Z().b(2131391046).f();
        r12.setText(ag4.a.d(2131896780));
        r12.setTextColor(ColorProtector.parseColor("#FE2C55"));
        ((LinearLayout) this.a.Z().b(2131374550).f()).setBackgroundResource(2131247924);
        this.a.Z().b(2131363242).f().setBackgroundResource(2131234721);
        sq3.g r13 = this.a.i;
        if (r13 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mVO");
    L44:
        r13.l = 2;
        goto L6
    L25:
        r6 = null;
        goto L27
    L16:
        r4 = null;
        goto L17
    L63:
        return;
    }
}
