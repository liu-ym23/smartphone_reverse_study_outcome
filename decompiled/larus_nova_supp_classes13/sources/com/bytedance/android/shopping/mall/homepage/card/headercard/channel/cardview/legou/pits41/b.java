package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Arrays;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends CountDownTimer {
    public final /* synthetic */ CycleActivityView41 a;

    @Override // android.os.CountDownTimer
    public final void onFinish() {
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long r10) {
        CycleActivityView41 r11 = this.a;
        long r0 = r11.g;
        if (r0 <= 0) goto L5;
        r11.b.setText((CharSequence) ListProtector.get(CycleActivityView41.l, 0));
        TextView r12 = this.a.e;
        StringCompanionObject r2 = StringCompanionObject.INSTANCE;
        long r4 = 60;
        r12.setText(String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(r0 % r4)}, 1)));
        this.a.d.setText(String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf((r0 / r4) % r4)}, 1)));
        this.a.c.setText(String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(r0 / ((long) 3600))}, 1)));
    L8:
        this.a.g--;
        return;
    L5:
        r11.b.setText((CharSequence) ListProtector.get(CycleActivityView41.l, 1));
        this.a.e.setText("00");
        this.a.d.setText("00");
        this.a.c.setText("00");
        b r13 = this.a.j;
        if (r13 == null) goto L8;
        r13.cancel();
        goto L8
    }

    public b(CycleActivityView41 r1, long r2, long r4) {
        this.a = r1;
        super(r2, r4);
    }
}
