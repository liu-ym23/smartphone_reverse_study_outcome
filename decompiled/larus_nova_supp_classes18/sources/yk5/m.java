package yk5;

import android.app.Activity;
import android.graphics.RectF;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.onboarding.export.Direction;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m {
    public static final String e = null;
    public final Activity a;
    public final int b;
    public final int c;
    public final Integer d;

    public static final class a {
    }

    static {
        e = n.class.getSimpleName();
    }

    public m(FragmentActivity r2, int r3, int r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public final List<Float> b(View r10, int[] r11, RectF r12, Direction r13) {
        if (r10 == null) goto L6;
        int[] r14 = new int[2];
        r10.getLocationOnScreen(r14);
        int r4 = r14[0];
        return a(r4, r14[1], r4 + r10.getWidth(), r14[1] + r10.getHeight(), r13);
    L6:
        if (r11 != null) goto L8;
    L11:
        if (r12 != null) goto L13;
        tt5.a.d(e, "No TargetView or targetPos is set!!");
        return null;
    L13:
        return a((int) r12.left, (int) r12.top, (int) r12.right, (int) r12.bottom, r13);
    L8:
        if (r11.length < 2) goto L11;
        int r6 = r11[0];
        int r7 = r11[1];
        return a(r6, r7, r6, r7, r13);
    }

    public final List<Float> a(int r17, int r18, int r19, int r20, Direction r21) {
        View r4 = this.a.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r5 = ThreadMethodProxy.currentThread();
        if (r5 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r5, "getDecorView");
    L7:
        int r6 = r4.getMeasuredWidth();
        int r7 = r4.getMeasuredHeight();
        int r8 = com.bytedance.ee.util.ui.k.e(this.a);
        int r9 = this.a.getResources().getDimensionPixelSize(2131168369);
        Integer r10 = this.d;
        if (r10 == null) goto L10;
        int r11 = r10.intValue();
    L11:
        int r12 = r18 - r8;
        int r13 = r7 - r20;
        if (r12 <= r13) goto L14;
        float r14 = r11;
        float r15 = (r18 - r14) - r9;
        float r16 = ((r14 / 2) + r15) - this.c;
    L15:
        String r110 = e;
        if (r12 > r13) goto L18;
    L22:
        if (r12 < r13) goto L24;
    L28:
        int r1 = this.a.getResources().getDimensionPixelSize(2131168315);
        int r2 = this.a.getResources().getDimensionPixelSize(2131168315) + this.a.getResources().getDimensionPixelSize(2131167883);
        int r3 = (r17 + r19) / 2;
        if (r3 >= r1) goto L32;
        float r22 = r1;
    L35:
        int r23 = this.b;
        float r24 = r3 - (r23 / 2);
        float r25 = r1 / 2;
        if (r24 >= r25) goto L39;
        r24 = r25;
    L42:
        return CollectionsKt.listOf(new Float[]{Float.valueOf(r22), Float.valueOf(r15), Float.valueOf(r24), Float.valueOf(r16)});
    L39:
        if (((r23 + r24) + r25) <= r6) goto L42;
        r24 = (r6 - r23) - r25;
        goto L42
    L32:
        if ((r6 - r3) >= r2) goto L34;
        r22 = r6 - r2;
        goto L35
    L34:
        r22 = r3 - (r11 / 2);
        goto L35
    L24:
        if (Direction.UP != r21) goto L28;
        tt5.a.b(r110, "remindTop " + r13 + ", panel.measuredHeight " + this.c + ", arrowLen " + r11);
        if (r12 <= (this.c + r11)) goto L28;
        tt5.a.h(r110, "change by up suggestedDirection");
        float r26 = r11;
        r15 = (r18 - r26) - r9;
        r16 = ((r26 / 2) + r15) - this.c;
        goto L28
    L18:
        if (Direction.DOWN != r21) goto L22;
        tt5.a.b(r110, "remindBottom " + r13 + ", panel.measuredHeight " + this.c + ", arrowLen " + r11);
        if (r13 <= (this.c + r11)) goto L28;
        tt5.a.b(r110, "change by down suggestedDirection");
        r15 = r20 + r9;
        r16 = r15 + (r11 / 2);
        goto L28
    L14:
        r15 = r20 + r9;
        r16 = (r11 / 2) + r15;
        goto L15
    L10:
        r11 = this.a.getResources().getDimensionPixelSize(2131167883);
        goto L11
    }
}
