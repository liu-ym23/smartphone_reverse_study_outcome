package com.bytedance.ee.bear.middleground.comment.input;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z0 implements View.OnLayoutChangeListener {
    public final /* synthetic */ InputComment a;

    public z0(InputComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r1, "v");
        tt5.a.h("Comment#InputComment", "onLayoutChange " + this.a.o.getHeight() + " lastLocation:" + this.a.e0 + " }");
        tt5.a.h("Comment#InputComment", "onLayoutChange top:" + r3 + ", bottom:" + r5 + ", left:" + r2 + ", right:" + r4);
        if (this.a.o.getHeight() == 0) goto L31;
        int r10 = this.a.o.getHeight();
        this.a.getClass();
        this.a.b.p1().invoke(Integer.valueOf(r10));
        int[] r11 = new int[2];
        r1.getLocationOnScreen(r11);
        tt5.a.h("Comment#InputComment", "onLayoutChange location[1]:" + r11[1]);
        InputComment r12 = this.a;
        int r13 = r12.e0;
        if (r13 != 0) goto L7;
    L9:
        r12.e0 = r11[1];
        int r14 = cu5.c.c();
        InputComment r15 = this.a;
        if ((r14 - r15.e0) <= InputComment.x0) goto L12;
    L15:
        List<Function2<Integer, Boolean, Unit>> r16 = this.a.b.a();
        InputComment r17 = this.a;
        Iterator<T> r18 = r16.iterator();
    L17:
        if (r18.hasNext() == false) goto L19;
        ((Function2) r18.next()).invoke(Integer.valueOf(r11[1]), Boolean.valueOf(r17.k.isForWhole()));
    L19:
        InputComment r19 = this.a;
        if (r19.o0 == false) goto L22;
    L23:
        List<Function2<Integer, Boolean, Unit>> r20 = r19.b.c();
        InputComment r21 = this.a;
        Iterator<T> r22 = r20.iterator();
    L25:
        if (r22.hasNext() == false) goto L27;
        ((Function2) r22.next()).invoke(Integer.valueOf(r3), Boolean.valueOf(r21.k.isForWhole()));
    L27:
        InputComment r23 = this.a;
        r23.e.invoke(Integer.valueOf(r1.getBottom() - r1.getTop()));
        r23.a.N.a(new ef5.r(r23));
        return;
    L22:
        if (r19.p0 == false) goto L27;
    L12:
        if (rcb.b.a(r15.a.getActivity()) == true) goto L15;
        tt5.a.h("Comment#InputComment", "onLayoutChange  SAFE_DISTANCE ");
        goto L19
    L7:
        if (r13 != r11[1]) goto L9;
        return;
    }
}
