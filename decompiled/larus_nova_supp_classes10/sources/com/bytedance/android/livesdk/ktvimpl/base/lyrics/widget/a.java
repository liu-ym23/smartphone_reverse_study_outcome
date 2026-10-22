package com.bytedance.android.livesdk.ktvimpl.base.lyrics.widget;

import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.component.lyric.model.b;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public List<b> a;
    public Integer b;
    public long c;
    public final long d;
    public final int e;
    public final LinkedList<Integer> f;
    public final Function1<? super Integer, Unit> g;

    public a(Function1<? super Integer, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "countDownCallback");
        this.g = r3;
        this.c = -1;
        this.d = KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION;
        this.e = ((int) KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION) / 1000;
        this.f = new LinkedList();
    }

    public final void a(long r9) {
        Integer r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r1 = false;
        if (r0 == null) goto L8;
        int r2 = r0.intValue();
    L9:
        long r3 = r2;
        if (r9 >= r3) goto L12;
        return;
    L12:
        long r10 = r9 - r3;
        long r4 = 1000;
        Long r11 = Long.valueOf(r10 / r4);
        if (r11.longValue() == this.c) goto L16;
        r1 = true;
    L16:
        if (r1 == true) goto L19;
        r11 = null;
    L19:
        if (r11 == null) goto L32;
        long r5 = r11.longValue();
        long r6 = 0;
        if (r5 < 0) goto L25;
        r6 = r5;
    L25:
        if ((r5 * r4) < this.d) goto L30;
        this.g.invoke(null);
        if (this.f.isEmpty() == false) goto L29;
        this.g.invoke(-1);
    L29:
        this.b = this.f.poll();
        this.c = -1;
        return;
    L30:
        this.c = r6;
        this.g.invoke(Integer.valueOf(this.e - ((int) r6)));
        return;
    L32:
        return;
    L8:
        r2 = 0;
        goto L9
    }
}
